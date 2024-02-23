package Amazon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.annotation.Before;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ECommerceFunctionality {

    private WebDriver driver;
    public String productName;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
    public void loadData() throws Exception {
        JSONParser parser = new JSONParser();  

        try {
            Object obj = parser.parse(new FileReader("src/test/resources/data.json"));    
            JSONObject jsonObject = (JSONObject) obj;
            
            productName = (String) jsonObject.get("productName");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Error loading data from JSON file");
        } 
    }

    @Test
    public void testProductSearch() {
        searchProduct(productName);
        Assert.assertTrue(verifyProductSearchResult(productName));
    }

    @Test
    public void testAddToCart() {
        searchProduct(productName);
        addToCart();
        Assert.assertTrue(verifyProductAddedToCart(productName));
    }

    @Test
    public void testCartConfirmation() {
        navigateToCart();
        Assert.assertTrue(verifyProductInCart());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private void searchProduct(String productName) {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(productName);
        searchBox.submit();
    }

    private boolean verifyProductSearchResult(String productName) {
        WebElement productTitle = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        return productTitle.getText().equalsIgnoreCase(productName);
    }

    private void addToCart() {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
    }

    private boolean verifyProductAddedToCart(String productName) {
        WebElement cartItem = driver.findElement(By.xpath("//span[contains(text(),'" + productName + "')]"));
        return cartItem.isDisplayed();
    }

    private void navigateToCart() {
        WebElement cartIcon = driver.findElement(By.id("nav-cart-count-container"));
        cartIcon.click();
    }

    private boolean verifyProductInCart() {
        WebElement cartItem = driver.findElement(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']"));
        return cartItem.isDisplayed();
    }
}
