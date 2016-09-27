package edu.csumb.cst438fa16.hangman.webclient;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * User story:
 *
 *   As a user I want to be able to guess a letter for a given word
 *
 * Class name ends in IT so it runs with "mvn integration-test", not "mvn test".
 */

public class HangmanIT {
	
	WebDriver driver = new ChromeDriver();
	
	@Before
	public void setUp(){
		driver.get("http://localhost:8080/hangman.html");
	}
	
	@After 
	public void tearDown(){
		driver.quit();
	}
	
	/**
	 * Acceptance test:
	 * 
	 * 	Given I am on the hangman page and the word to guess is 'cat'
	 * 	When I enter the letters 'r', 'w', and 't' one by one 
	 * 	Then I should be able to see my previews guesses
	 * 
	 * **/
	
	@Test
	public void testSeeListOfOldGuesses(){
		
		driver.findElement(By.id("newGuesses")).sendKeys("r");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.id("newGuesses")).sendKeys("w");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.id("newGuesses")).sendKeys("t");
		driver.findElement(By.id("submit")).click();
	   
	      // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBe(By.id("oldGuesses"), "rwt"));
		//Success
	}
	
	/**
	 * Acceptance test:
	 * 
	 * 	Given I am on the hangman page and the word to guess is 'cat'
	 * 	When I enter the letters 'c', 'a', and 't' one by one 
	 * 	Then I will see a alert message saying I have won
	 * 
	 * **/
	
	@Test
	public void testEnterCorrectWord(){
		
		driver.findElement(By.id("newGuesses")).sendKeys("c");
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.id("newGuesses")).sendKeys("a");
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.id("newGuesses")).sendKeys("t");
		driver.findElement(By.id("submit")).click();

		 (new WebDriverWait(driver, 10))
         .until(ExpectedConditions.alertIsPresent());
	        
		//Success
		
	}	
	
}
