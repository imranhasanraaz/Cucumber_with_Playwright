import BasePage from './basepage';

class Products extends BasePage {
    constructor(page) {
        super(page)
        this.locators = {
            productsPageTitle: "//span[@class='title']",
        };
    }

    async getProductsPageTitleText() {
        return this.getLocatorText(this.locators.productsPageTitle);
    }


} export default Products;