package common;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import constants.Attribute;
import reports.Loggers;

public class CommonActions {
	WebDriver driver;
	
	public static void clickElement(WebElement element) {
		try {
			element.click();
			Loggers.logTheTest(element + "<---------> has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			System.out.println("Exception is: " + e);
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() ); 
			// getMessage() Returns the detail message string of this throwable.
			Assert.fail();
		}
	}
	
	// Alternate of above code
	/*
	public static void clickElement1(WebElement element) throws NullPointerException, NoSuchElementException {
		element.click();
	}
	*/
	
	public static void pause(long sec) {
		try {
			Thread.sleep(sec * 1000);
			Loggers.logTheTest("Sleeping ... zZz " + sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Loggers.logTheTest("Sleep interrupted");
		}
	}
	
	public static void inputText(WebElement element, String input) {
		try {
			element.sendKeys(input);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element);
		} catch (NoSuchElementException | NullPointerException e) {
			// System.out.println("Exception is: " + e);
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() );
			Assert.fail();
		}
		
	}
	
	public static boolean elementDisplayed (WebElement element){
		try {
			boolean flag = element.isDisplayed();
			Loggers.logTheTest(element + "<---------> is Displayed, " + flag);
			Assert.assertTrue(true);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is not Displayed\n" + e.getMessage() );
			Assert.fail();
		}
		return true;				
	}
	
	public static boolean elementEnabled(WebElement element) {
		try {
			boolean flag = element.isEnabled();
			Loggers.logTheTest(element + "<---------> is Enabled, " + flag);
			Assert.assertTrue(true);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is Disabled\n" + e.getMessage() ); 
			Assert.fail();
		}
		return true;
	}
	
	public static boolean elementSelected (WebElement element){
		try {
			boolean flag = element.isSelected();
			Loggers.logTheTest(element + "<---------> is Selected, " + flag);
			Assert.assertTrue(true);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is not Selected\n" + e.getMessage() );
			Assert.fail();
		}
		return true;				
	}
	
	public static void verifyTitle(WebDriver driver, String expectedTitle) {
		try {
			String actualTitle = driver.getTitle();
			Loggers.logTheTest("Actual Title is : " + actualTitle + " ---> And Expected Title is :" + expectedTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
		} catch (NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest("Driver is not initiated properly Or Home Page Title doesn't match");
			Assert.fail();
		}
	}
	
	// Need to add some code inside
	public static String verifyCurrentUrl(WebDriver driver) {
		Loggers.logTheTest("Current URL is : " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
	
	public static void verifyTextInTheWebElement(WebElement element, String expected) {
		String actual = element.getText();
		Loggers.logTheTest(element + " ---> Actual text : " + actual + ". Expected text : " + expected);
		Assert.assertEquals(actual, expected, "Text In the WebElement doesn't match");
	}
	
	public static void clearTextFromTheField(WebElement element) {
		try {
			element.clear();
			Loggers.logTheTest("The Text from the " + element + " ---> is cleared");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}
	
	// Attribute is coming from package constants, we will check the outcome later
	public static String getAttributeValue(WebElement element, Attribute attribute) {
		return element.getAttribute(attribute.toString());
	}
	
	public static void verifyAttribute01(WebElement element, Attribute attribute, String expectedValue) {
		String actual = getAttributeValue(element, attribute);
		// element.getAttribute(attribute.toString());
		Loggers.logTheTest(element + " ---> We can Enter : " + actual + " Character in the field which was similar with the Expected as: " + expectedValue);
		Assert.assertEquals(actual, expectedValue);
	}
	
	public static void verifyLengthOfTheFieldContent(WebElement element, String expected) {
		verifyAttribute01(element, Attribute.MAX_LENGTH, expected);
	}
	
	public static void verifyAttribute02(WebElement element, String expectedErrorMsg, Attribute attribute) {
		String actual = getAttributeValue(element, attribute);
		// element.getAttribute(attribute.toString());
		Loggers.logTheTest(element + " ---> Actual Error Message is : " + actual + ". And Expected was: " + expectedErrorMsg);
		Assert.assertEquals(actual, expectedErrorMsg);
	}
	
	public static void verifyErrorMsgUnderTheField(WebElement element, String expectedErrorMsg) {
		verifyAttribute02(element, expectedErrorMsg, Attribute.INNER_TEXT); //"innerHTML"
	}
	
	public static void verifyErrorMsg(WebElement element, String expectedErrorMsg) {
		verifyAttribute02(element, expectedErrorMsg, Attribute.INNER_TEXT); //"innerHTML"
	}
	
	public static void inputTextThenClickEnter(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.ENTER);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element + " and then clicked by Enter Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() );
			Assert.fail();
		}
	}
	
	public static void inputTextThenClickReturn(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.RETURN);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element + " and then clicked by Enter Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() );
			Assert.fail();
		}
	}
	
	public static void selectDropdown(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
			Loggers.logTheTest(value + " has been selected from the dropdown of ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + " : This element Not Found");
			Assert.fail();
		}
	}
	
	
	
	
	
	
	
	
	
	

}
