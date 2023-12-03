package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginStep extends Hooks{

    @Given("User is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        openBrowser();
        Assert.assertTrue(demoLoginPage.isLoginPageOpen(), "User is not in login page");
    }
    @When("User input username {string}")
    public void userInputUsername(String username) {
        demoLoginPage.setUserName(username);
    }
    @And("User input password {string}")
    public void userInputPassword(String password) {
        demoLoginPage.setPassword(password);

    }

    @And("User click on the login button")
    public void userClickOnTheLoginButton() {
        demoLoginPage.clickOnLogin();

    }

    @Then("User successfully logged in")
    public void userSuccessfullyLoggedIn() {
        Assert.assertEquals(demoLoginPage.getProductPageTitle() , "Products", "products page does not open");
    }

    @And("User should see the inventory page")
    public void userShouldSeeTheInventoryPage() {
        Assert.assertEquals(demoLoginPage.getProductPageTitle() , "Products", "products page does not open");
    }
}