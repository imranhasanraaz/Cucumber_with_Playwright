package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UncheckedIOException;

public class JsonUtils {
    private final ObjectMapper mapper = new ObjectMapper();
    private final String content;

    public JsonUtils(String resourceName) {
        ResourceFile resourceFile = new ResourceFile(resourceName);
        this.content = resourceFile.getFileContent();
    }

    public Object getValue(String jsonPath) {
        return getEnvValueOrDefault(jsonPath);
    }

    private Object getEnvValueOrDefault(String jsonPath) {
        String envVar = getEnvValue(jsonPath);
        JsonNode node = getJsonNode(jsonPath, envVar == null);
        return node.isMissingNode()
                ? envVar
                : castEnvOrDefaultValue(node, envVar);
    }

    private Object castEnvOrDefaultValue(JsonNode node, String envVar) {
        if (node.isBoolean()) {
            return envVar == null ? node.asBoolean() : Boolean.parseBoolean(envVar);
        } else if (node.isLong()) {
            return envVar == null ? node.asLong() : Long.parseLong(envVar);
        } else if (node.isInt()) {
            return envVar == null ? node.asInt() : Integer.parseInt(envVar);
        } else if (node.isDouble()) {
            return envVar == null ? node.asDouble() : Double.parseDouble(envVar);
        } else if (node.isObject()) {
            return envVar == null ? node.toString() : envVar;
        } else {
            return envVar == null ? node.asText() : envVar;
        }
    }

    private String getEnvValue(String jsonPath) {
        String key = jsonPath.replace("/", ".").substring(1, jsonPath.length());
        String envVar = System.getProperty(key);
        if (envVar != null) {
            System.out.println("Environment value is null");
        }
        return envVar;
    }

    private JsonNode getJsonNode(String jsonPath, boolean throwIfEmpty) {
        JsonNode nodeAtPath;
        String errorMessage = String.format("Json field by json-path %1$s was not found in the file %2$s", jsonPath, content);
        try {
            JsonNode node = mapper.readTree(content);
            nodeAtPath = node.at(jsonPath);
        } catch (IOException e) {
            throw new UncheckedIOException(errorMessage, e);
        }
        if (throwIfEmpty && nodeAtPath.isMissingNode()) {
            throw new IllegalArgumentException(errorMessage);
        }
        return nodeAtPath;
    }
}