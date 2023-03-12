package StepDefinition;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class BDD_Steps_Saucedemo {
	private WebDriver driver;
	private WebElement itemisaddedtothecart;
	private Object l;
    
    @Given("User is on the SauceDemo login page")
    public void user_is_on_the_SauceDemo_login_page() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("invalid_user");
        driver.findElement(By.id("password")).sendKeys("invalid_password");
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User is redirected to the SauceDemo inventory page")
    public void user_is_redirected_to_the_SauceDemo_inventory_page() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(expectedUrl);
        driver.quit();
    }

    @Then("Error message is displayed")
    public void error_message_is_displayed() {
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assert actualErrorMessage.equals(expectedErrorMessage);
        driver.quit();
    }
   
    @Given("I am on the login page")
	public void i_am_on_the_login_page() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://www.saucedemo.com/");
	}
    
    @When("I enter valid credentials")
	public void i_enter_valid_credentials() throws Throwable {
	    WebElement usernameInput = driver.findElement(By.id("user-name"));
	    WebElement passwordInput = driver.findElement(By.id("password"));
	    usernameInput.sendKeys("standard_user");
	    passwordInput.sendKeys("secret_sauce");
	}

	@And("I click the login button")
	public void i_click_the_login_button() throws Throwable {
	    WebElement loginButton = driver.findElement(By.id("login-button"));
	    loginButton.click();
	}

	@Then("I am redirected to the home page")
	public void i_am_redirected_to_the_home_page() throws Throwable {
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.urlContains("https://www.saucedemo.com/inventory.html"));
	}
	
	@And("User open item")
	public void user_open_products() {
		System.out.println("Steps - User open item");
		driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();
	}
	
	@When("I add an item to the cart")
	public void i_add_an_item_to_the_cart() throws Throwable {
	    WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
	    addToCartButton.click();
	}

	@Then("the item is added to the cart")
	public void the_item_is_added_to_the_cart() throws Throwable {
	    driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
	}
	@And("User proceeds to checkout")
	public void User_proceeds_to_checkout() {
		System.out.println("Steps - User proceeds to checkout");
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
	}

	@And("User fills out the checkout form with valid data")
	public void user_fills_out_the_checkout_form_with_valid_data() throws Throwable {
	    WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
	    WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
	    WebElement postalCode = driver.findElement(By.xpath("//input[@id='postal-code']"));
	    WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
	    
	    firstName.sendKeys("Rendy");
	    lastName.sendKeys("Nurhuda");
	    postalCode.sendKeys("12345");
	    continueBtn.click();
	}

	@And("User confirms the purchase")
	public void user_confirms_the_purchase() throws Throwable {
	    WebElement finishBtn = driver.findElement(By.xpath("//button[@id='finish']"));
	    finishBtn.click();
	}

	@Then("^User should see the confirmation page$")
	public void user_should_see_the_confirmation_page() throws Throwable {
	    driver.findElement(By.xpath("//h2[@class='complete-header']"));
	    //assert(confirmationMessage.isDisplayed());
	}
	
	@And("User redirected to the home page")
	public void User_redirected_to_the_home_page() {
		System.out.println("Steps - User redirected to the home page");
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
	}
	
	@When("User clicks the menu button")
		public void User_clicks_the_menu_button() {
		System.out.println("Steps - user clicks the menu button");
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
	}
	
	@When("User clicks the Logout button")
    public void user_clicks_the_logout_button() {
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
    }

    @Then("User should be logged out successfully")
    public void user_should_be_logged_out_successfully() {
        // code to verify successful logout, such as checking if the login page is displayed
    	driver.quit();
    }
}