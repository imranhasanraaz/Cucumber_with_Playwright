package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.stream.Collectors;

class ResourceFile {
    private final String fileContent;

    ResourceFile(String resourceName) {
        fileContent = getResourceFileContent(resourceName);
    }

    String getResourceFileContent(final String resourceName) {
        InputStreamReader inputStream = new InputStreamReader(Objects.requireNonNull(JsonUtils.class.getClassLoader().getResourceAsStream(resourceName)), StandardCharsets.UTF_8);
        try (BufferedReader br = new BufferedReader(inputStream)) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new UncheckedIOException(String.format("Reading of resource file '%1$s' was failed", resourceName), e);
        }
    }


    String getFileContent() {
        return fileContent;
    }
}