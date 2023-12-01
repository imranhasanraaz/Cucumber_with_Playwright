import BasePage from '../pages/basepage';

class LoginPage extends BasePage {
  constructor(page) {
    super(page);
    this.locators = {
      usernameLocator: '[data-test="username"]',
      passwordLocator: '[data-test="password"]',
      loginButtonLocator: '[data-test="login-button"]',
    };
  }

  async gotoLoginPage() {
    await this.gotoPage('https://www.saucedemo.com/');
  }

  async enterUsername(username) {
    await this.fillField(this.locators.usernameLocator, username);
  }

  async enterPassword(password) {
    await this.fillField(this.locators.passwordLocator, password);
  }

  async clickLoginButton() {
    await this.clickElement(this.locators.loginButtonLocator);
  }
}

export default LoginPage;