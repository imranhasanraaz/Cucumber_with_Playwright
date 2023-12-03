package step_definitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.DemoLoginPage;
import utilities.JsonUtils;
import static factory.PlaywrightFactory.initBrowser;

public class Hooks {
    protected Page page;
    protected DemoLoginPage demoLoginPage;
    static JsonUtils configReader = new JsonUtils("config.json");

    public  void openBrowser() throws InterruptedException {
        String browserName = configReader.getValue("/browserName").toString();
        String baseUrl = configReader.getValue("/baseUrl").toString();
        page = initBrowser(browserName, baseUrl);
        demoLoginPage = new DemoLoginPage(page);
    }
    public void closeBrowser(){
        page.context().browser().close();
    }
}