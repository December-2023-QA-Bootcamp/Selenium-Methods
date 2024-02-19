package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// new, you have to manually write it to get access of common method
// this is possible when they are static in nature, * means all
// This is called static import
import static common.CommonActions.*;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		// PageFactory help to instantiate WebElements
		PageFactory.initElements(driver, this);
		// If no PageFactory class, Web element can't instantiated and will show "NullPointerException"
		// do java comment for line 16 to see the exception
	}
	
	// 1st way: Most common way to write the WebElement (@FindBy), you must know how to do that 95%
	
	// Use of unique 'Id' attribute as locator
	@FindBy(id = "cms-login-submit")
	WebElement loginButton;
	
	// Use of unique 'name' attribute as locator
	@FindBy(name = "user-d")
	WebElement userId;
	
	// 2nd way to write the WebElement: not common, here I used for the 'password'	
	// Just to make you guys familiar, if you see in your job
	
	// Use of unique 'name' attribute as locator
	@FindBy(how = How.NAME, using = "pass-d")
	WebElement password;
	
	// Use of unique  'className' attribute as locator
	@FindBy(className = "cms-newuser-reg")
	WebElement newUserRegistration;
	
	// FYI: Never take a class value as unique if they have white space between words. 
	// Example: class value of password, this is unique, but a compound class
	//	@FindBy(className = "cms-login-field ng-dirty ng-touched ng-invalid cms-error-border")
	//	WebElement password2;
	// We gave java comments above 2 line, because compiler stuck here by seeing compound class

	
	@FindBy(xpath = "//parent::nav//em[@id='cms-homepage-header-logo-unauth']")
	WebElement logo;
		
	@FindBy(xpath = "//a[text()='User ID']")
	WebElement forgotUserId;
	
	@FindBy(className = "-newuser-reg")
	WebElement wrongNewUserRegistration;
	
	public void clickLoginButton() throws InterruptedException {
		loginButton.click();
		// We used throws to throw exception
		Thread.sleep(4000);
	}
	
	public void clickUserIdField() {
		userId.click();
		// We used try catch block to throw exception
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickPasswordField() {
		password.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickNewUserRegistration() {
		newUserRegistration.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void clickLogo() {
		clickElement(logo);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickForgotUserId() {
		clickElement(forgotUserId);
	}
	
	public void clickWrongNewUserRegistration() {
		clickElement(wrongNewUserRegistration);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}