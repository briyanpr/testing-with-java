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

public class description {
    WebDriver driver;
    String url = "https://www.saucedemo.com/";

    @Given("Login Page saucedemo")
    public void loginPageSaucedemo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);

        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }


    @When("Input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("Click one title from item")
    public void clickOneTitleFromItem() {
        driver.findElement(By.id("item_4_title_link")).click();
    }

    @Then("User is in description page")
    public void userIsInDescriptionPage() {
        String title = driver.findElement(By.className("inventory_details_name")).getText();
        Assert.assertEquals(title, "Sauce Labs Backpack");
        driver.close();
    }
}
