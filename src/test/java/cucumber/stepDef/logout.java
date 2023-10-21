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

public class logout {
    WebDriver driver;
    String url = "https://www.saucedemo.com/";

    @Given("Login Page")
    public void login_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);

        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("Write Username")
    public void writeUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Write Password")
    public void writePassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login")
    public void clickLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("click menu")
    public void clickMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("click logout")
    public void clickLogout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User is in login page")
    public void userIsInLoginPage() {
        String Logo = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(Logo, "Swag Labs");
        driver.close();
    }
}
