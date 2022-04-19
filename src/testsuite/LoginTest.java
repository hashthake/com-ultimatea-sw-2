package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNevigateToLoginPageSuccessfully(){
        //Click on sign in link
        WebElement signIn = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signIn.click();
        //verify the message display is as per requirement
        String expectedMessage = "Welcome Back!";

        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualMessageElement.getText();
        //vvalidate message
        Assert.assertEquals("Welcome Back!",expectedMessage,actualMessage);


    }
    @Test
    public void verifyTheErrorMessage(){
        //Click on sign in link
        WebElement signIn = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signIn.click();
        //enter username as per requirement
        WebElement email = driver.findElement(By.id("user[email]"));
        email.sendKeys("abc@gmail.com");
        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("ABC123");
        //click on signin button
        WebElement signIn1 = driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        signIn1.click();
        //Verify messagae as per requirement
        String expectedMessage = "Invalid email or password.";

        WebElement actualMessageelement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
