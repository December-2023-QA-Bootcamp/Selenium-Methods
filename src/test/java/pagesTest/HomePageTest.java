package pagesTest;

import static common.CommonActions.elementDisplayed;
import static common.CommonActions.elementEnabled;
import static common.CommonActions.elementSelected;
import static common.CommonActions.pause;
import static common.CommonActions.verifyTextInTheWebElement;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class HomePageTest extends BaseClass {
	
	// The test executed based on alphabetical order, if no priority given
	// (enabled = true) means The test case is not disable, it can run
	// (enabled = false) means The test case is disable, it is not running
	// priority = 1 means, this test case will run first, 2 means second .... ... so on
	
	@Test (enabled = false, priority = 2)
	public void clickLoginButtonTest(){
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
	
	
	@Test (enabled = false)
	public void clickForgotUserIdTest() {
		homePage.clickForgotUserId();
	}
	
	// Test for implicit wait and it shows "NoSuchElementException"
	@Test(enabled = false)
	public void clickWrongNewUserRegistrationTest() {
		homePage.clickWrongNewUserRegistration();
	}
	
	// This test case will fail, when you you do Java comments for PageFactory class (Constructor of HomePage)
	// When PageFactory class is absent, you will find NullPointerException
	@Test (enabled = false)
	public void nullPointerExceptionTest() throws InterruptedException {
		homePage.clickNewUserRegistration();
	}
	
	@Test(enabled = false)
	public void clickUnlockTest() {
		homePage.clickUnlock();
	}
	
	@Test(enabled = false)
	public void inputTextInUserIdFieldTest() {
		homePage.inputTextInUserIdField();
	}
	
	@Test(enabled = false)
	public void inputTextInUserIdAndPasswordFieldThenClickLoginButtonTest() throws InterruptedException {
		homePage.inputTextInUserIdAndPasswordFieldThenClickLoginButton();
	}
	
	@Test(enabled = false)
	public void useOfByClassInLoginTest() {
		homePage.useOfByClassInLogin();
	}
	
	@Test(enabled = false)
	public void use_of_linkText_as_locator_in_forgot_passowrd_hyperlink_test() {
		homePage.use_of_linkText_as_locator_in_forgot_passowrd_hyperlink();
	}
	
	@Test(enabled = false)
	public void use_of_partialLinkText_as_locator_in_terms_and_conditions_hyperlink_test() {
		homePage.use_of_partialLinkText_as_locator_in_terms_and_conditions_hyperlink();
	}
	
	@Test(enabled = false)
	public void why_we_use_cssSelector_as_locator_in_logo_test () {
		homePage.why_we_use_cssSelector_as_locator_in_logo ();
	}
	
	@Test(enabled = false)
	public void role1_use_of_cssSelector_by_class_name_value_test() {
		homePage.role1_use_of_cssSelector_by_class_name_value();
	}
	
	@Test(enabled = false)
	public void role2_use_of_cssSelector_by_id_value_test() {
		homePage.role2_use_of_cssSelector_by_id_value();
	}

	@Test(enabled = false)
	public void role3_use_of_cssSelector_by_compund_class_name_value_test () {
		homePage.role3_use_of_cssSelector_by_compund_class_name_value ();
	}
	
	@Test(enabled = false)
	public void role4_use_of_cssSelector_by_attribute_and_its_value_test () {
		homePage.role4_use_of_cssSelector_by_attribute_and_its_value ();
	}
	
	@Test(enabled = false)
	public void role5_use_of_cssSelector_by_class_name_value_and_attribute_and_its_value_test() {
		homePage.role5_use_of_cssSelector_by_class_name_value_and_attribute_and_its_value();
	}
	
	@Test(enabled = false)
	public void role6_use_of_cssSelector_by_id_value_and_attribute_and_its_value_test() {
		homePage.role6_use_of_cssSelector_by_id_value_and_attribute_and_its_value();
	}
	
	@Test(enabled = false)
	public void use_of_tagName_as_locator_test() {
		homePage.use_of_tagName_as_locator();
	}
	
	@Test(enabled = false)
	public void use_of_isDisplayed_test() {
		homePage.use_of_isDisplayed(); // Actual Outcome by selenium
		Assert.assertTrue(true, "Application logo is not suppose to displayed"); // Expected Outcome
	}
	
	@Test(enabled = false)
	public void use_of_isDisplayed_in_login_test() {
		homePage.use_of_isDisplayed_in_login();
	}
	
	@Test(enabled = false)
	public void use_of_isEnabled_in_login_test() {
		homePage.use_of_isEnabled_in_login();
	}
	
	@Test(enabled = false)
	public void use_of_isSelected_in_login() {
		homePage.use_of_isSelected_in_login();
	}
	
	@Test(enabled = false)
	public void logoDisplayed01Test() {
		homePage.logoDisplayed01();
	}
	
	@Test(enabled = false)
	public void logoDisplayed02Test() {
		homePage.logoDisplayed02();
	}
	
	@Test(enabled = false)
	public void logoDisplayed03Test() {
		homePage.logoDisplayed03();
	}
	
	@Test(enabled = false)
	public void logoDisplayed04Test() {
		homePage.logoDisplayed04();
	}
	
	@Test(enabled = false)
	public void getMethodsOfThePageTest01() {
		homePage.getMethodsOfThePage01();
	}
	
	@Test(enabled = false)
	public void getMethodsOfThePageTest02() {
		homePage.getMethodsOfThePage02();
	}
	
	@Test(enabled = false)
	public void newUserRegistrationPageValidationTest() {
		homePage.newUserRegistrationPageValidation();
	}
	
	@Test(enabled = false)
	public void use_of_clear_in_login_test() {
		homePage.use_of_clear_in_login();
	}
	
	@Test(enabled = false)
	public void use_of_getAttribute_method_01_Test () {
		homePage.use_of_getAttribute_method_01();
	}
	
	@Test(enabled = false)
	public void use_of_getAttribute_method_02_Test () {
		homePage.use_of_getAttribute_method_02();
	}

	@Test(enabled = false)
	public void use_of_sendKeys_method_then_click_by_enter_key_of_the_laptop_test () {
		homePage.use_of_sendKeys_method_then_click_by_enter_key_of_the_laptop();
	}
	
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_click_by_return_key_of_the_laptop_test () {
		homePage.use_of_sendKeys_method_then_click_by_return_key_of_the_laptop();
	}
	
	@Test(enabled = false)
	public void use_of_navigate_method_test () {
		homePage.use_of_navigate_method ();
	}
	
	@Test(enabled = false)
	public void use_of_mouse_hoverAction_on_ourLocations_test () {
		homePage.use_of_mouse_hoverAction_on_ourLocations ();
	}
	
	@Test(enabled = false)
	public void alternate_of_click_method_test() {
		homePage.alternate_of_click_method();
	}
	
	@Test(enabled = false)
	public void alternate_of_send_keys_method_test() {
		homePage.alternate_of_send_keys_method();
	}
	
	@Test(enabled = false)
	public void login_process_by_JavascriptExecutor_test() {
		homePage.login_process_by_JavascriptExecutor();
	}
	
	// it will fail
	@Test(enabled = false)
	public void how_to_handle_hidden_element_by_regular_selenium_method_test() {
		homePage.how_to_handle_hidden_element_by_regular_selenium_method();
	}
	
	@Test(enabled = false)
	public void how_to_handle_hidden_element_by_javascriptExecutor_test() {
		homePage.how_to_handle_hidden_element_by_javascriptExecutor();
	}
	
	@Test(enabled = false)
	public void use_of_explicitly_wait_01_test() {
		homePage.use_of_explicitly_wait_01();
	}
	
	@Test(enabled = false)
	public void use_of_explicitly_wait_02_test() {
		homePage.use_of_explicitly_wait_02();
	}
	
	@Test(enabled = false)
	public void use_of_explicitly_wait_03_test(){
		homePage.use_of_explicitly_wait_03();
	}
	
	@Test(enabled = false)
	public void use_of_explicitly_wait_04_test(){
		homePage.use_of_explicitly_wait_04();
	}
	
	@Test(enabled = false)
	public void use_of_explicitly_wait_05_test(){
		homePage.use_of_explicitly_wait_05();
	}
	
	@Test(enabled = false)
	public void use_of_scroll_down_and_up_by_actions_class_Test () {
		homePage.use_of_scroll_down_and_up_by_actions_class();
	}
	
	@Test(enabled = false)
	public void use_of_scroll_down_and_up_by_javascriptExecutor_test () {
		homePage.use_of_scroll_down_and_up_by_javascriptExecutor ();
	}
	
	@Test(enabled = false)
	public void use_of_scroll_down_and_scroll_up_by_robot_class () throws InterruptedException, AWTException {
		homePage.use_of_scroll_down_and_scroll_up_by_robot_class ();
	}
	
	@Test(enabled = false)
	public void scroll_into_view_the_element_test() {
		homePage.scroll_into_view_the_element();
	}
	
	@Test(enabled = false)
	public void web_based_alert_accept_test () {
		homePage.web_based_alert_accept();		
	}
	
	@Test(enabled = false)
	public void web_based_alert_dismiss_test () {
		homePage.web_based_alert_dismiss();		
	}
	
	@Test(enabled = false)
	public void  authentication_pop_up_test () throws InterruptedException {
		homePage. authentication_pop_up ();
	}
	
	@Test(enabled = false)
	public void use_of_right_click_action_test () {
		homePage.use_of_right_click_action ();
	}
	
	@Test(enabled = false)
	public void use_of_double_click_action_test () throws InterruptedException {
		homePage.use_of_double_click_action ();
	}
	
	@Test(enabled = false)
	public void use_of_drag_and_drop_action_test () throws InterruptedException {
		homePage.use_of_drag_and_drop_action ();
	}
	
	@Test(enabled = false)
	public void use_of_slider_action_test () {
		homePage.use_of_slider_action ();
	}
	
	@Test(enabled = false)
	public void use_of_slider_action_alternate_test () {
		homePage.use_of_slider_action_alternate ();
	}
	
	@Test(enabled = true)
	public void read_table_test () {
		homePage.read_table ();
	}
	
	@Test(enabled = true)
	public void read_any_row_of_the_table_test ()  {
		homePage.read_any_row_of_the_table ();
	}
	
	@Test(enabled = true)
	public void read_any_cell_of_a_row_of_the_table () {
		homePage.read_any_cell_of_a_row_of_the_table ();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
