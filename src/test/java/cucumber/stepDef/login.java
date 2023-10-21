package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String url = "https://www.saucedemo.com/";

    @Given("Login Page Saucedemo")
    public void login_page_saucedemo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);

        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("Input Username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }


    @And("click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("Input Invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_12345");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String appLogo = driver.findElement(By.className("error-message-container")).getText();
        Assert.assertEquals(appLogo, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
