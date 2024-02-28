package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

// new, you have to manually write it to get access of common method
// this is possible when they are static in nature, * means all
// This is called static import
import static common.CommonActions.*;

import java.security.PublicKey;

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
	public void use_of_partialLinkText_as_locator_in_terms_and_conditions_hyperlink() {
		pause(3);
		clickElement(termsAndConditions);
		pause(3);
	}
	
	// Web Element: Logo
	// logo: class attribute value:  cms-icon cms-sprite-loggedout ms-3
	// Exception 'InvalidSelectorException': 'Compound class names not permitted',
	// so even if you see class value is unique but separated by space, avoid this as class name locator
	// This scenario will show error and will failed everywhere
	public void why_we_use_cssSelector_as_locator_in_logo () {
		driver.findElement(By.className("cms-icon cms-sprite-loggedout ms-3")).click();
	}
	
	// Web Element: New User Registration Button
	// Important: Use of cssSelector as locator
	// cssSelector is very important for interview
	// cssSelector by class --> inside the string, first put html tag, then dot, then write value of the class attribute 
	public void role1_use_of_cssSelector_by_class_name_value () {
		driver.findElement(By.cssSelector("a.cms-newuser-reg")).click();
		pause(3);
	}
	
	// Important: Use of cssSelector as locator
	// Web Element: login Button
	// if you wanna create cssSelector by id 
	// first html tag, then # (hash), then write the value of id attribute inside the string
	public void role2_use_of_cssSelector_by_id_value() {
		driver.findElement(By.cssSelector("button#cms-login-submit")).click();
		pause(3);
	}
	
	// Web Element: logo
	// Important: Use of cssSelector as locator
	// if the class (compound class) contain separate words [cms-icon cms-sprite-loggedout ms-3], 
	// they are actually different class, then
	// we have to close the gap between classes by putting the dot/period
	// cssSelector by class --> htmltag.class name value 
	// remove the space between words in class value, and replace with dot/period
	public void role3_use_of_cssSelector_by_compund_class_name_value () {
		driver.findElement(By.cssSelector("em.cms-icon.cms-sprite-loggedout.ms-3")).click();
		pause(3);
	}
		
	// Above 3 is mostly used, 90% cases of css selector, also very common interview question
	// below 3 high level, no need to see if you feel they are tough
	
	// Use of cssSelector as locator
	// Web Element: login Button
	// high level, you can ignore
	// cssSelector by another attribute
	// --> htmltag[id/class/name attribute = 'value of the attribute' ] , in xpath - you use // and @, which is absent here 
	// and you can use any other attribute name except id and class
	public void role4_use_of_cssSelector_by_attribute_and_its_value () {
		driver.findElement(By.cssSelector("button[name='Submit Login']")).click();
		pause(3);
	}
	
	// Web Element: NUR Button
	// Not important, can ignore
	// cssSelector by another attribute
	// --> htmltag.value of class[id/class/name attribute = 'value of the attribute'] , in xpath you use // and @, which is absent here and you can use attribute except id and class
	// That's why we use title
	public void role5_use_of_cssSelector_by_class_name_value_and_attribute_and_its_value() {
		driver.findElement(By.cssSelector("a.cms-newuser-reg[title='New User Registration']")).click();
		pause(3);
	}
	
	// Important: Use of cssSelector as locator
	// Web Element: login Button
	// Not important, can ignore
	// cssSelector by another attribute
	// --> htmltag#value of ID[attribute name='value'] , in xpath you use // and @, which is absent here and you can use attribute except id and class	
	public void role6_use_of_cssSelector_by_id_value_and_attribute_and_its_value() {
		driver.findElement(By.cssSelector("button#cms-login-submit[title='Login']")).click();
		pause(3);
	}
	
	// Important: Use of tagName as locator
	// tag name: we have to go to Amazon and find "table" tag
	
	// in cms portal not a single tag except header
	public void use_of_tagName_as_locator() {
		driver.findElement(By.tagName("header")).click(); // not a click able element, just showed you
	}
	
	// Web Element: logo
	// isDisplayed() is an alternate of click() method which is boolean type
	// isDisplayed() is the method used to verify the presence of a web element within the web page.
	// Use of isDisplayed() available in --> image, link, button, text field, check box etc.
	public void use_of_isDisplayed() {
		boolean elementDisplayed = driver.findElement(By.cssSelector("em.cms-icon.cms-sprite-loggedout.ms-3")).isDisplayed();
		System.out.println("Is the Logo displayed? Ans: " + elementDisplayed);
	}
	// This is raw, used without common method
	
	// use of isDisplayed method inside elementDisplayed()
	public void use_of_isDisplayed_in_login() {
		elementDisplayed(userId);
		inputText(userId, "Tofael");
		pause(3);
		elementDisplayed(password);
		inputText(password, "Enthrall@63468");
		pause(3);
		elementDisplayed(iAgree);
		clickElement(iAgree);
		pause(3);
		clickElement(loginButton);
		pause(3);
	}
	
	// Web Element: login Button
	// isEnabled() is the method used to verify if the web element is enabled or
	// disabled within the web page. isEnabled() is primarily used with buttons.
	// Use of isEnabled(), a boolean type method
	
	// use of isEnabled method inside elementEnabled()
	public void use_of_isEnabled_in_login() {
		elementDisplayed(userId);
		inputText(userId, "Tofael");
		pause(3);
		elementDisplayed(password);
		inputText(password, "Enthrall@63468");
		pause(3);
		elementDisplayed(iAgree);
		clickElement(iAgree);
		pause(3);
		elementEnabled(loginButton); // here is the use
		clickElement(loginButton);
		pause(3);
	}
	
	// Web Element: I agree
	// Used with radio buttons, dropdowns and checkboxes.
	// use of isSelected() method inside
	
	public void use_of_isSelected_in_login() {
		elementDisplayed(userId);
		inputText(userId, "enthrall_12");
		pause(3);
		elementDisplayed(password);
		inputText(password, "Nabeeha19@12345");
		pause(3);
		elementSelected(iAgree); // here is the use
		clickElement(iAgree);
		pause(3);
		elementEnabled(loginButton);
		clickElement(loginButton);
		pause(3);
		
	}
	
	// In real time scenario we do below test at the beginning of a page
	public void getMethodsOfThePage() {
		String actual = driver.getTitle();
		System.out.println("Title name: "+ actual);
		String expected = "     CMS Enterprise Portal";
		Assert.assertEquals(actual, expected, "Title doesn't match");
		
		System.out.println("Current URL: " + driver.getCurrentUrl());
		// use of getText() in "login button"
		String nameOfTheWebElement = driver.findElement(By.name("Submit Login")).getText();
		System.out.println("Text Present: "+nameOfTheWebElement);
	}
	
	// This is the first method used in a class
	// what is title?
	// what is the url?
	// is logo displayed?
	// method coming from common action
	public void newUserRegistrationPageValidation() {
		pause(3);
		elementDisplayed(logo);
		verifyTitle(driver,"CMS Enterprise Portal");
		elementEnabled(newUserRegistration);
		verifyTextInTheWebElement(newUserRegistration, "New User Registration");
		clickElement(newUserRegistration);
		pause(3);
		verifyCurrentUrl(driver);
		
	}
	
	// Here We used User ID field
	// getAttribute() actually give the value of the Attribute, not common
	// raw use, in next method we will use from common action
	public void use_of_getAttribute_method () {
		elementDisplayed(userId);
		pause(4);
		// 1 example is enough
		String value01 = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("placeholder");
		String value02 = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("class");
		String value03 = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("id");
		String value04 = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("title");
		System.out.println("The value of the placeholder attribute is: " + value01);
		System.out.println("The value of the class attribute is: " + value02);
		System.out.println("The value of the id attribute is: " + value03);
		System.out.println("The value of the title attribute is: " + value04);
	}
	
	// attribute er common action in next class
	// Assert in details
	
	// use of clear()
	public void use_of_clear_in_login() {
		elementDisplayed(userId);
		inputText(userId, "enthrall_12");
		pause(3);
		clearTextFromTheField(userId);
		inputText(userId, "enthrall_12");
		pause(3);
		elementDisplayed(password);
		inputText(password, "Nabeeha19@12345");
		pause(3);
		clearTextFromTheField(password);
		pause(3);
		inputText(password, "Nabeeha19@12345");
		elementSelected(iAgree); // here is the use
		clickElement(iAgree);
		pause(3);
		elementEnabled(loginButton);
		verifyTextInTheWebElement(loginButton, "Login");
		clickElement(loginButton);
		pause(3);
		
	}
	
	
	
	
	
	
	

}