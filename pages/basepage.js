class BasePage {
  constructor(page) {
    this.page = page;
  }

  async gotoPage(url) {
    await this.page.goto(url);
  }

  async clickElement(locator) {
    const element = await this.page.locator(locator);
    await element.click();
  }

  async fillField(locator, value) {
    const field = await this.page.locator(locator);
    await field.click();
    await field.fill(value);
  }

  async getLocatorText(locator) {
    const element = await this.page.locator(locator);
    const text = await element.textContent();
    return text;
  }

}

export default BasePage;  