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

public class transaction {
    WebDriver driver;
    String url = "https://www.saucedemo.com/";

    @Given("Login page saucedemo")
    public void loginPageSaucedemo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);

        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }


    @When("input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click Login Button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("Click one item to add to cart")
    public void clickOneItemToAddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("Click cart")
    public void clickCart() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }


    @And("CLick checkout button")
    public void clickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }


    @And("Click continue button")
    public void clickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }


    @And("input name")
    public void inputName() {
        driver.findElement(By.id("first-name")).sendKeys("Lionel");
    }

    @And("input last name")
    public void inputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Messi");
    }

    @And("input postal code")
    public void inputPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("123456");
    }

    @And("Click finish button")
    public void clickFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("Checkout complete page appear")
    public void checkoutCompletePageAppear() {
        String orderComplete = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(orderComplete, "Thank you for your order!");
        driver.close();
    }
}
