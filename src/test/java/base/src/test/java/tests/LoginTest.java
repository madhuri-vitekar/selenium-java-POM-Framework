package tests;
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    
    @Test
    public void validLoginTest() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title, "Products");
        System.out.println("Login Test Passed!");
    }
    
    @Test
    public void paymentFlowTest() {
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        // Add to cart and checkout - Payment flow
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Madhuri");
        driver.findElement(By.id("last-name")).sendKeys("Vitekar");
        driver.findElement(By.id("postal-code")).sendKeys("401101");
        driver.findElement(By.id("continue")).click();
        
        String paymentInfo = driver.findElement(By.className("summary_info")).getText();
        Assert.assertTrue(paymentInfo.contains("Payment Information"));
        System.out.println("Payment Flow Test Passed!");
    }
}
