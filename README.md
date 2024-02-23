# E-Commerce Automation with Selenium WebDriver

## Purpose
The purpose of this script is to automate various functionalities on the Amazon India website using Selenium WebDriver.

## Prerequisites
- Java Development Kit (JDK)
- Selenium WebDriver
- TestNG
- ChromeDriver

## Instructions for Execution
1. Clone this repository to your local machine.
2. Install the necessary dependencies (JDK, Selenium WebDriver, TestNG, ChromeDriver).
3. Set up the ChromeDriver path in the script.
4. Run the test script using TestNG.

## Structure of Reusable Functions
### Functionality 1: Product Search
- **Open the web browser and navigate to the esteemed Amazon India website:**
  - Implemented in the `setUp()` method using Selenium WebDriver to open the Chrome browser and navigate to Amazon's India website.

- **Employ Selenium WebDriver to initiate a targeted search for a specific product based on JSON input, showcasing adept navigation skills:**
  - Utilized a JSON input file to fetch the product name.
  - Created a `loadData()` method to read the product name from the JSON file.

- **Implement reusable functions to meticulously validate that the search results impeccably present the specified product:**
  - Defined a `searchProduct(String productName)` method to search for the specified product.
  - Created a `verifyProductSearchResult(String productName)` method to verify that the search results display the specified product.

### Functionality 2: Add-to-Cart
- **Having navigated the intricate pathways, progress to the product page of the specified product with Selenium finesse:**
  - Utilized the `searchProduct(String productName)` method to search for the specified product, leading to the product page.

- **Demonstrate Selenium's precision by orchestrating the addition of the product to the cart, ensuring meticulous verification of specifications:**
  - Implemented the `addToCart()` method to add the product to the cart.
  - Utilized the `verifyProductAddedToCart(String productName)` method to confirm that the specified product is added to the cart.

- **Leverage reusable functions to confirm the seamless integration of the specified product into the shopping cart:**
  - Defined the `verifyProductAddedToCart(String productName)` method to verify the presence of the specified product in the cart.

### Functionality 3: Cart Confirmation
- **Lead the Selenium orchestra to the bustling shopping cart, now graced by the specified product:**
  - Implemented the `navigateToCart()` method to navigate to the shopping cart.

- **Showcase the prowess of reusable functions in confirming the accurate display of the product within the cart, poised for a smooth transition to the checkout stage:**
  - Utilized the `verifyProductInCart()` method to confirm the presence of the specified product in the cart.

## Contributors
Karishma Salvi

This README file provides comprehensive documentation about the script's purpose, prerequisites, instructions for execution, and the structure of reusable functions, enabling fellow developers to comprehend and potentially extend the automation solution.
