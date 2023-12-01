const { Given, When, Then} = require('@cucumber/cucumber');
import { expect } from '@playwright/test';
import LoginPage from '../pages/login';
import Products from '../pages/products';

Given('the user is on the login page',  async function () {
  this.login = new LoginPage(this.page);
  await this.login.gotoLoginPage();
  return 'pending'
});

When('the user enters the username {string} and password {string}', async function (username, password) {
  await this.login.enterUsername(username);
  await this.login.enterPassword(password);
});

When('clicks the login button', async function () {
  await this.login.clickLoginButton();
});

Then('the user should be redirected to the products page', async function () {
  const products = new Products(this.page);
  expect(this.page.url()).toBe('https://www.saucedemo.com/inventory.html');
});

Then('the products page title should be {string}', async function (expectedTitle) {
  const products = new Products(this.page);
  const pageTitle = await products.getProductsPageTitleText();
  expect(pageTitle).toBe(expectedTitle);
});
