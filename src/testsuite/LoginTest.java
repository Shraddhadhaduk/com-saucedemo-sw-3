package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
      String baseUrl = "https://www.saucedemo.com/";

      @Before
    public void setUp(){
          openBrowser(baseUrl);
      }

      @Test
    public void userShouldLoginSuccessfullyWithValid(){
          //4.1 Enter standard username
          sendTextToElement(By.id("user-name"), "standard_user");
          //4.2 Enter standard password
          sendTextToElement(By.id("password"), "secret_sauce");
          //4.3 Click on login button
          clickOnElement(By.xpath("//input[@id='login-button']"));
          //4.4 Verify text
          String expectedText = "Products";
          String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
          Assert.assertEquals(expectedText, actualText);
      }

      @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
          //4.5 Enter standard username
          sendTextToElement(By.id("user-name"), "standard_user");
          //4.6 Enter standard password
          sendTextToElement(By.id("password"), "secret_sauce");
          //4.7 Click on login button
          clickOnElement(By.xpath("//input[@id='login-button']"));
          //4.8 Verify six product are displayed
          List<WebElement> products = driver.findElements(By.className("inventory_item"));
          System.out.println("Total products are: " + products.size());
          Assert.assertEquals("",6, products.size());
      }

      @After
    public void tearDown(){
          closeBrowser();
      }


}
