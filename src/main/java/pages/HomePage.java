package pages;

import org.openqa.selenium.By;
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
	
	// 3rd way to write the WebElement by "By Class" : Not common, here I used unlock web element from the home page
	// instead of xpath, we can also use id, name, class etc as locator.
	By unlock = By.xpath("//a[contains(text(), 'un')]");
	// Here, unlock is the WebElement name, By is a class
	
	@FindBy(id = "cms-label-tc")
	WebElement iAgree;
	
	@FindBy(linkText = "Password")
	WebElement forgotPassword;
	
	@FindBy(partialLinkText = "Terms & Con")
	WebElement termsAndConditions;
	
	
	public void clickLoginButton() {
		loginButton.click(); // This is raw, used without common method
		pause(4);
	}
	
	public void clickUserIdField() {
		clickElement(userId); // common method for click is used here
		pause(4);
	}
	
	public void clickPasswordField() {
		clickElement(password);
		pause(4);
	}
	
	public void clickNewUserRegistration() {
		newUserRegistration.click();
		pause(4);
	}
	
	
	public void clickLogo() {
		clickElement(logo);
		pause(4);
	}
	
	public void clickForgotUserId() {
		clickElement(forgotUserId);
	}
	
	public void clickWrongNewUserRegistration() {
		clickElement(wrongNewUserRegistration);
		pause(4);
	}
	
	// Not common, just for your reference
	public void clickUnlock() {
		pause(4);
		// This is the new way to call the web element
		driver.findElement(unlock).click();
		pause(4);
	}
	
	// We are using sendKeys() method to input the text in any field
	public void inputTextInUserIdField() {
		// whatever the value we pass, always inside  " ", even if you use int type (1, 2, 3 etc)
		userId.sendKeys("December 2023 QA"); // This is raw, used without common method
		pause(4);
	}
	
	// We are using both common action here
	public void inputTextInUserIdAndPasswordFieldThenClickLoginButton() throws InterruptedException {
			inputText(userId, "Dcember 2023 QA"); // common method for sendKeys is used here
			pause(3);
			inputText(password, "Enthrall@2024");
			pause(3);
			clickElement(iAgree);
			pause(3);
			clickElement(loginButton);
			pause(3);
	}
	
	// Alternate of above method
	// We can use a web element directly in the method, that is also common, but different people like different way
	public void useOfByClassInLogin() {
		driver.findElement(By.name("user-d")).sendKeys("Enthrall IT");
		pause(3);
		driver.findElement(By.xpath("//input[@id='cms-login-password']")).sendKeys("abc@1234");
		pause(3);
		driver.findElement(By.id("cms-label-tc")).click();
		pause(3);
		driver.findElement(By.id("cms-login-submit")).click();
		pause(3);
	}
		
	public void use_of_By_class_in_new_user_registration_button() {
		driver.findElement(By.xpath("//a[contains(text(), 'New User Registration')]")).click();
		pause(3);		
	}
	
	// Important: Use of linkText as locator
	// Web Element: forgot password
	public void use_of_linkText_as_locator_in_forgot_passowrd_hyperlink() {
		pause(3);
		clickElement(forgotPassword);
		pause(3);
	}
	
	// Important: Use of linkText as locator
	// Web Element: forgot password
	public void use_of_partialLinkText_as_locator_in_terms_and_Conditions_hyperlink() {
		pause(3);
		clickElement(termsAndConditions);
		pause(3);
	}
		
	
	
	
	
	

}