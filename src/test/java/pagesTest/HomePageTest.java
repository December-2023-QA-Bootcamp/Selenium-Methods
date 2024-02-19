package pagesTest;


import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class HomePageTest extends BaseClass {
	
	// The test executed based on alphabetical order, if no priority given
	// (enabled = true) means The test case is not disable, it can run
	// (enabled = false) means The test case is disable, it is not running
	// priority = 1 means, this test case will run first, 2 means second .... ... so on
	
	@Test (enabled = false, priority = 2)
	public void clickLoginButtonTest() throws InterruptedException {
		homePage.clickLoginButton();		
	}
	
	@Test (enabled = false, priority = 1)
	public void clickUserIdFieldTest() {
		homePage.clickUserIdField();
	}
	
	@Test(enabled = false)
	public void clickPasswordFieldTest() {
		homePage.clickPasswordField();
	}
	
	@Test (enabled = false)
	public void clickNewUserRegistrationTest() {
		homePage.clickNewUserRegistration();
	}
	
	@Test (enabled = false)
	public void clickLogoTest() { // This test case will fail
		homePage.clickLogo();
	}
	
	
	@Test (enabled = true)
	public void clickForgotUserIdTest() {
		homePage.clickForgotUserId();
	}
	
	// Test for implicit wait and it shows "NoSuchElementException"
	@Test(enabled = false)
	public void clickWrongNewUserRegistrationTest() {
		homePage.clickWrongNewUserRegistration();
	}

	
	
	
	
	

}
