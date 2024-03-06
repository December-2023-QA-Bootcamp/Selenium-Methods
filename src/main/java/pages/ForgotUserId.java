package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static common.CommonActions.*;

public class ForgotUserId {
	public WebDriver driver;
	public Select select;

	public ForgotUserId(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "cms-forgot-userid")
	WebElement forgotUserId;
	
	@FindBy(xpath = "//input[@id='cms-forgotid-firstName']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='cms-forgotid-lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//select[@name='cms-forgotid-birthDate']")
	WebElement birthDate;
	
	@FindBy(xpath = "//select[@id='cms-forgotid-birthYear']")
	WebElement birthYear;
	
	@FindBy(xpath = "//select[@id='cms-forgotid-birthMonth']")
	WebElement birthMonth;
	
	@FindBy(xpath = "//input[@id='cms-forgotid-forgotEmail']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='cms-forgotid-usZipCode']")
	WebElement zipCode;
	
	@FindBy(xpath = "//button[contains(text(), 'Su')]")
	WebElement submitButton;
	
	public void navigateToForgotUserIdPage() {
		clickElement(forgotUserId);
		pause(3);
		verifyTitle(driver, "CMS Enterprise Portal - Forgot User ID");
		verifyCurrentUrl(driver);
	}
	
	// birth month
	// use method --> selectByValue()
	public void use_of_dropdown_with_selectByValue_method() {
		select = new Select(birthMonth);
		select.selectByValue("05");
		pause(3);
	}
	
	// birth date
	// drop down, all 3 categories
	// drop down is a commonly asked interview question
	// here we are using selectByIndex() method
	// This method is not suggested, or not used much
	// Because, adding a new web element or deleting a new one can change the index number	
	public void use_of_dropdown_with_selectByIndex_method() {
		// Select select = new Select(birthDate);
		select = new Select(birthDate);
		select.selectByIndex(10);
		pause(3);
	}
	
	// birth year
	// drop down is a commonly asked interview question
	// Most commonly use method in drop down --> selectByVisibleText()
	public void use_of_dropdown_selectByVisibleText_method() {
		select = new Select(birthYear);
		select.selectByVisibleText("1995");
		pause(3);
	}
	
	public void forgotUserid() {
		inputText(firstName, "Mohammad");
		pause(3);
		inputText(lastName, "Sharkar");
		pause(3);
		selectDropdown(birthMonth, "April");
		pause(3);
		selectDropdown(birthDate, "3");
		pause(3);
		selectDropdown(birthYear, "1980");
		pause(3);
		inputText(email, "tofael483@gmail.com");
		pause(3);
		inputText(zipCode, "10019");
		pause(3);
		clickElement(submitButton);
		pause(3);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
