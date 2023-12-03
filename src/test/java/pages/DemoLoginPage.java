package pages;

import com.microsoft.playwright.Page;

public class DemoLoginPage {
    Page page;
    public DemoLoginPage(Page page){
        this.page = page;
    }
    private final String userName = "//input[@id='user-name']";
    private final String password = "//input[@id='password']";
    private final String loginButton = "//input[@id='login-button']";
    private final String error = "//h3[@data-test='error']";
    private final String productsTitle = "//span[@class='title']";

    public boolean isLoginPageOpen(){
        return page.locator(loginButton).isVisible();
    }
    public void setUserName(String user){
        page.locator(userName).fill(user);

    }

    public void setPassword(String pass){
        page.locator(password).fill(pass);
    }

    public void clickOnLogin(){
        page.locator(loginButton).click();
    }

    public String getProductPageTitle(){
        return page.locator(productsTitle).innerText();
    }
}
