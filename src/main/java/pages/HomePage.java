package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import constants.Attribute;

// new, you have to manually write it to get access of common method
// this is possible when they are static in nature, * means all
// This is called static import
import static common.CommonActions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;


public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions actions;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		// PageFactory help to instantiate WebElements
		PageFactory.initElements(driver, this);
		// If no PageFactory class, Web element can't instantiated and will show "NullPointerException"
		// do java comment for line 16 to see the exception
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
		inputText(userId, "enthrall_12");
		pause(3);
		elementDisplayed(password);
		inputText(password, "OnthrallTest@1234");
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
		inputText(userId, "enthrall_12");
		pause(3);
		elementDisplayed(password);
		inputText(password, "OnthrallTest@1234");
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
		inputText(password, "OnthrallTest@1234");
		pause(3);
		elementSelected(iAgree); // here is the use
		clickElement(iAgree);
		pause(3);
		elementEnabled(loginButton);
		clickElement(loginButton);
		pause(3);
		
	}
	
	// Learning Assertion
	public void logoDisplayed01() {
		elementDisplayed(logo); // Actual outcome from selenium method
		Assert.assertTrue(true); // Expected outcome
	}
	
	public void logoDisplayed02() {
		elementDisplayed(logo); // Actual Result or outcome which doesn't match with your below expectation
		Assert.assertTrue(false); // Expected Result // java.lang.AssertionError: expected [true] but found [false]
		// Although the outcome is true, but because of difference between expected vs actual is not same, the test case failed
	}
	
	public void logoDisplayed03() {
		elementDisplayed(logo); // Actual outcome from selenium method
		// Assert.assertTrue(false, "Expected vs actual doesn't match"); // Expected outcome
		// Assert.assertTrue(true, "Application Logo is not displayed"); // This error message will appear if failed
		Assert.assertFalse(false, "Application Logo is not displayed"); // false false means true
		
	}
	
	public void logoDisplayed04() {
		elementDisplayed(logo); // Actual outcome from selenium method
		Assert.assertFalse(true, "Expected vs actual doesn't match"); // false false means true
		
	}
		
	// In real time scenario we do below test at the beginning of a page
	// this test case will fail, as expected vs actual doesn't match
	public void getMethodsOfThePage01() {
		String actual = driver.getTitle();
		System.out.println("Title name: "+ actual);
		String expected = "  CMS Enterprise Portal";
		Assert.assertEquals(actual, expected, "Title doesn't match");
		
		System.out.println("Current URL: " + driver.getCurrentUrl());
		// use of getText() in "login button"
		String nameOfTheWebElement = driver.findElement(By.name("Submit Login")).getText();
		System.out.println("Text Present: "+nameOfTheWebElement);
	}
	
	// Use of SoftAssertion
	public void getMethodsOfThePage02() {
		String actual = driver.getTitle();
		System.out.println("Title name: "+ actual);
		String expected = "  CMS Enterprise Portal";
		// SoftAssert is used instead of HardAssert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected, "Title doesn't match");
		// When we use Soft Assertion, execution will not stopped below, if Assertion is failed in above line
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
	
	// Here We used User ID field
	// getAttribute() actually give the value of the Attribute, not common
	// raw use, in next method we will use from common action
	public void use_of_getAttribute_method_01 () {
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
	
	// getAttribute value from common action
	public void use_of_getAttribute_method_02 () {
		elementDisplayed(userId);
		pause(4);
		verifyAttribute01(userId,  Attribute.ID, "cms-login-userId");	
		verifyAttribute01(userId, Attribute.NAME, "user-d");
	}
	
	// use of Keys.ENTER, most common then below one
	public void use_of_sendKeys_method_then_click_by_enter_key_of_the_laptop () {
		elementDisplayed(userId);
		inputTextThenClickEnter(userId, "Enthrall_12");
		pause(3);
	}
	
	// use of Keys.RETURN , do the same function of above
	public void use_of_sendKeys_method_then_click_by_return_key_of_the_laptop () {
		elementDisplayed(userId);
		inputTextThenClickReturn(userId, "Enthrall_12");
		pause(3);
		inputTextThenClickReturn(password, "hgfshdgj");
		pause(3);
	}
	
	// use of navigate()
	// mostly interview question, never used in framework
	public void use_of_navigate_method () {
		pause(3);
		// if we click on help button, we can get below url
		driver.navigate().to("https://portal.cms.gov/portal/help/digital/home");
		pause(3);
		driver.navigate().back();
		pause(3);
		driver.navigate().forward();
		pause(3);
		driver.navigate().refresh();
		pause(3);
	}
	
	// dropdown feature is showed in forgot User id page
	
	// Very very important for use in framework and also a interview question
	public void use_of_mouse_hoverAction_on_ourLocations () {
		pause(3);
		driver.navigate().to("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		WebElement ourLocations = driver.findElement(By.xpath("//a[normalize-space(text()) = 'Our Locations' and @class='hidden-xs dropdown']"));
		// Actions actions = new Actions(driver);
		actions.moveToElement(ourLocations).build().perform();
		pause(6);
	}
	
	// very very  Important interview question + they ask you to write the code in MS word
	// JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver. 
	// so, practice it by paper pen, then in ms word
	// alternate of click()
	// login button used
	public void alternate_of_click_method() {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginButton); // memorize the content
		// arguments[0] means, find the web element of index 0, first occurrence
		pause(3);
	}
	
	// how to input text inside a field by JavascriptExecutor, alternate of sendKeys()
	// user id field is used to input text
	public void alternate_of_send_keys_method() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = 'enthrall_12'", userId);
		pause(3);
	}
	
	// login process by JavascriptExecutor
	// alternative of click(), sendKeys() is used
	public void login_process_by_JavascriptExecutor(){
		// js = (JavascriptExecutor) driver;
		elementDisplayed(userId);		
		js.executeScript("arguments[0].value = 'enthrall_12' ", userId);
		pause(3);
		elementDisplayed(password);
		js.executeScript("arguments[0].value = 'OnthrallTest@1234' ", password);
		pause(3);
		elementSelected(iAgree);
		js.executeScript("arguments[0].click()", iAgree);
		pause(3);
		elementEnabled(loginButton);
		verifyTextInTheWebElement(loginButton, "Login");
		js.executeScript("arguments[0].click()", loginButton);
		pause(3);
	}
	
	// it will fail, because selenium can't handle hidden element
	public void how_to_handle_hidden_element_by_regular_selenium_method() {
		pause(3);
		driver.navigate().to("https://www.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		pause(3);
		// identify the 'Hide' element and click on it [line 548]
		// The search field will be disappeared, but we can pass value on it, as we got the info before
		driver.findElement(By.id("hide-textbox")).click();
		pause(3);
		// identify element and set/input text or value (line 551) by selenium
		driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("August 2023");
		// it will fail by below error message
		// org.openqa.selenium.ElementNotInteractableException: element not interactable
		// whenever you find element not interactable in console, that is for sure a hidden element		
	}
	
	// it will pass
	public void how_to_handle_hidden_element_by_javascriptExecutor() {
		pause(3);
		driver.navigate().to("https://www.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		pause(3);
		// identify the 'Hide' element and click on it [line 548]
		// The search field will be disappeared, but we can pass value on it, as we got the info before
		driver.findElement(By.id("hide-textbox")).click();
		pause(3);
		// identify element and set/input text or value (line 551) by selenium
		// identify element and set/input text or value by JavascriptExecutor
		WebElement searchField = driver.findElement(By.xpath("//input[@id='displayed-text']"));
		//js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = 'December 2023' ", searchField);	
		
		
		// You can really know what was the text written by the JavascriptExecutor		
		// not important and not related
		// Extra code
		// Extra not related to hidden elements and not important
		// To find out what you send as text, not necessary for this scenario
		// Just save the below code for future reference
		String s = (String) js.executeScript("return document.getElementById('displayed-text').value");
		System.out.print("Value entered in hidden field: " + s + "\n");
		
		// not important
		// How to get title of the page by JavaScript
		// How to read a JavaScript variable in Selenium WebDriver?
		// How to getTitle by Javascript, 
		String sText = js.executeScript("return document.title;").toString(); // fetching page title by javascript
		System.out.println("The title of the Page is: "+sText);	
		
		// not related with this test
		// How to refresh by Javascript, 
		js.executeScript("history.go(0)"); // To do refresh by Javascript
		
	}
	
	// very very important
	// when the web element always failed in test, use explicitly wait, 
	// in this web site doesn't have that complex scenario
	// "unlock" web element 
	// using visibilityOfElementLocated() method , Number one
	// This is a very common scenario in industry to use explicitly wait
	public void use_of_explicitly_wait_01() {
		pause(3);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(unlock)).click();
		pause(3);
	}
	
	// unlock webElement
	// using elementToBeClickable() method, number two
	public void use_of_explicitly_wait_02(){
		pause(3);
		wait.until(ExpectedConditions.elementToBeClickable(unlock)).click();
		pause(4);
	}
	
	// userId webElement
	// using visibilityOf() method, number three
	public void use_of_explicitly_wait_03(){
		pause(3);
		wait.until(ExpectedConditions.visibilityOf(userId)).isDisplayed(); // here userId is webElement type
		pause(4);
	}
	
	// Try to remember this above 3 conditions name for interview, most time they asked it
		
	// Not important, you can use it to practice
	// "unlock" web element 
	// using presenceOfElementLocated() method
	public void use_of_explicitly_wait_04(){
		pause(3);
		wait.until(ExpectedConditions.presenceOfElementLocated(unlock)).click();
		pause(4);
	}
	
	// Not important, you can use it to practice
	// "Login Button" web element
	// using textToBePresentInElement() method
	// this is not a clickable method, just to recognize the web element
	public void use_of_explicitly_wait_05(){
		pause(3);
		boolean outcome = wait.until(ExpectedConditions.textToBePresentInElement(loginButton, "Login"));
		System.out.println(outcome);
		pause(4);
	}
	
	// important interview question
	// 1st way: Scroll by Actions class
	// scroll bottom and then top
	public void use_of_scroll_down_and_up_by_actions_class () {
		pause(3);
		// for Scroll Down using Actions class, to go at the bottom of the page
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		pause(3);
		// for Scroll Up using Actions class at the top of the page
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		pause(3);
		// instead of END and HOME, we can use Keys.UP or Keys.Down
		// But it doesn't change much but the test case passes, we will not use them
	}
	
	// important interview question
	// 2nd way: Scroll by javascriptExecutor
	// scroll in a certain position (not at the bottom or up)
	public void use_of_scroll_down_and_up_by_javascriptExecutor () {
		pause(3);
		// This will scroll down the page by 1000 pixel vertically
		// here 0 is x axis, 1000 y axis
		// you choose your pixel accordingly to reach to that web element
		js.executeScript("window.scrollBy(0, 1000)", "");
		// You can change the value to any pixel, and put your own to see the web element you wanna test
		pause(4);
		js.executeScript("window.scrollBy(0, -1000)", ""); // scroll up till 1000px, but not necessary based on your test
		// minus when it goes opposite of down
		pause(3);
	}
	
	// not important, just to know
	public void use_of_scroll_down_and_scroll_up_by_robot_class () throws InterruptedException, AWTException {
		// For some reason, they are not going completely Up or Down
		Robot robot = new Robot();
		// Scroll Down using Robot class
		robot.keyPress(KeyEvent.VK_PAGE_DOWN); // Constant for the PAGE_DOWN virtual key.
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		pause(3);
		// Scroll Up using Robot class
        robot.keyPress(KeyEvent.VK_PAGE_UP); // Constant for the PAGE_UP virtual key. 
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        pause(3);		
	}
	
	// scroll Into View The Element
	// This is very very important, standard interview question
	// This is better to use
	public void scroll_into_view_the_element() {
		pause(3);
		WebElement enterprise = driver.findElement(By.xpath("//h1[contains(text(), 'Enterprise')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", enterprise);
		pause(4);		
	}
	
	// very very important for interview
	public void web_based_alert_accept () {
		pause(4);
		driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[contains(text(), 'Try it')]")).click();
		pause(4);
		Alert alert = driver.switchTo().alert();
		pause(3);
		System.out.println("The text present in the alert is: " + alert.getText());
		alert.accept(); // will click on OK button
		pause(3);
		// line 721, not part of the accept function, 
		// we just added to know about, the text is present in the alert or not,
		// also if you use it after 722, it might not retrieve the text							
	}
	
	public void web_based_alert_dismiss () {
		pause(4);
		driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[contains(text(), 'Try it')]")).click();
		pause(4);
		Alert alert = driver.switchTo().alert();
		pause(3);
		System.out.println("The text present in the alert is: " + alert.getText());
		alert.dismiss(); // will click on Cancel button
		pause(3);						
	}
	
	// Only important for interview
	public void authentication_pop_up (){
		pause(3);	
		String userName = "admin";
		String password = "admin";
		// original one is: "https://the-internet.herokuapp.com/basic_auth";
		// Updated one is: "https://admin:admin@the-internet.herokuapp.com/basic_auth";
		String url = "https://" + userName + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
		driver.get(url);
		pause(3);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pause(3);
		
		// The below part is not part of this test
		// identify and get text after authentication of pop up
		String t = driver.findElement(By.tagName("p")).getText(); // we use tag name as a locator in our course
		System.out.println("The Text is: " + t);
	}
	
	// only important for interview
	public void use_of_right_click_action () {
		pause(3);
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement rcButton = driver.findElement(By.xpath("//span[contains(text(), 'right click me')]"));
		// Actions actions = new Actions(driver);
		actions.moveToElement(rcButton).contextClick().build().perform(); // right click action
		pause(3);
		
		// From Line 775, not part of testing, just completed the scenario
		// Just keep below code, Can't find the web element for Edit at present, the line 779 is from my collection.
		// Below 2 is not relevant to right click, just doing some extra, which we know already
		// Next: I want to click on Edit link on the displayed menu options
		WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
		pause(3);
		edit.click(); // a regular click, not a right click
		pause(3);
		// Switch to the alert box and click on OK button
		Alert alert = driver.switchTo().alert();
		System.out.println("\nAlert Text:" + alert.getText());
		alert.accept();
		pause(3);
	}
	
	// only important for interview
	public void use_of_double_click_action () {
		pause(3);
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pause(3);
		WebElement dcButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		actions.doubleClick(dcButton).build().perform(); // double click action
		pause(3);
		// Not part of the double click action
		// Switch to the alert box and click on OK button
		Alert alert = driver.switchTo().alert();
		System.out.println("\nAlert Text:" + alert.getText());
		alert.accept();
		pause(3);
	}
	
	// not important
	public void use_of_drag_and_drop_action () {
		pause(3);
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Element which needs to drag (Bank)
		WebElement sourceLocator = driver.findElement(By.xpath("//a[text()=' BANK ']")); // Web element of the Bank button, it will be dragged
		// Element where need to be dropped.(In 'Account' field of debit side)
		WebElement targetLocator = driver.findElement(By.xpath("//ol[@id='bank']")); // and it will be dropped here
		// We Use Actions class for drag and drop.
		actions.dragAndDrop(sourceLocator, targetLocator).build().perform();
		pause(3);
	}
	
	// not important
	public void use_of_slider_action () {
		pause(3);	
		driver.get("https://demoqa.com/slider/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Retrieve WebElemnt 'slider' to perform mouse hover
		// This is the field where volume is increased
		WebElement slider = driver.findElement(By.cssSelector("input.range-slider.range-slider--primary"));
		// Move mouse to x offset 50 i.e. in horizontal direction
		pause(3);
		// to test the slider is working or not
		// dragAndDropBy (element, int xoffset, int yoffset)
		actions.dragAndDropBy(slider, 50, 0).build().perform(); 
		// learn from here, 50 is in pixel which might not match with real volume change, real volume 60
		pause(3);
		// slider.click();
		System.out.println("Moved slider in horizontal directions");
	}
		
	
	// not important (alternate), also tough
	public void use_of_slider_action_alternate () {
		pause(3);
		driver.get("https://demoqa.com/slider/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Retrieve WebElemnt 'slider' to perform mouse hover
		// This is the field where volume is increased
		WebElement slider = driver.findElement(By.cssSelector("input.range-slider.range-slider--primary")); 
		// Move mouse to x offset 65 i.e. in horizontal direction
		pause(3);
		// More tough than above
		actions.clickAndHold(slider);
		pause(3);
		actions.moveByOffset(65, 0).build().perform(); // pixel 65, real volume 63
		pause(3);
		System.out.println("Moved slider in horizontal directions");
		
	}
	
	// How to read the content of a Table 
	public void read_table () {
		pause(5);	
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pause(5);	
		// Scrolled to the end of page
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		pause(5);	
		// WebElement table = driver.findElement(By.tagName("table"));  // we can use tag name too, i have to check if we can follow below methods with this
		WebElement table = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon"));
		System.out.println(table.getText());
		pause(5);	
		
	}
	
	// How to read the row of a Table 
	public void read_any_row_of_the_table () {
		pause(5);	
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pause(5);	
		actions = new Actions(driver); 
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		pause(5);	
		WebElement row = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon tr:nth-child(1)"));
		System.out.println(row.getText());
		pause(5);	
	}
	
	// How to read any cell of a row of the Table 
	public void read_any_cell_of_a_row_of_the_table () {
		pause(5);	
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pause(5);	
		//actions = new Actions(driver); 
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		pause(5);
		WebElement cell = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon tr:nth-child(3) td:nth-child(1)"));
		System.out.println(cell.getText());	
		pause(5);	
	}
	
	
	
	
	
	
	
	
	
	

}