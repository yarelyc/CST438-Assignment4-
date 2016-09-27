package feature.word;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

public class WordSteps {

	WebDriver driver = new ChromeDriver();

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }

    @Given("^that the user is on the (\\w+) page$")
    public void page(String pageName) throws Throwable {
        driver.get("http://localhost:8080/" + pageName + ".html");
    }

    @When("^the user enters letter (.*)$")
    public void the_user_enters_letter(String letter) throws Throwable {
        driver.findElement(By.id("newGuesses")).sendKeys(letter);
        driver.findElement(By.id("submit")).click();
    }

    @Then("^the user sees he has guessed a (.*) letter$")
    public void i_see_the_correct_guessed_answer(String answer) throws Throwable {
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBe(By.id("answer"), answer));
    }

     @Then("^the user sees he has a (.*) letter$")
    public void i_see_the_wrong_guessed_answer(String answer) throws Throwable {
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBe(By.id("answer"), answer));
    }
 
}