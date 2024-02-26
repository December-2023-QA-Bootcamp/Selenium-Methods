package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import reports.Loggers;

public class CommonActions {
	
	public static void clickElement(WebElement element) {
		try {
			element.click();
			Loggers.logTheTest(element + "<---------> has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			System.out.println("Exception is: " + e);
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() ); 
			// getMessage() Returns the detail message string of this throwable.
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
		}
		
	}
	
	public static boolean elementDisplayed (WebElement element){
		try {
			boolean flag = element.isDisplayed();
			Loggers.logTheTest(element + "<---------> is Displayed, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is not Displayed\n" + e.getMessage() );
		}
		return true;				
	}
	
	public static boolean elementEnabled(WebElement element) {
		try {
			boolean flag = element.isEnabled();
			Loggers.logTheTest(element + "<---------> is Enabled, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is Disabled\n" + e.getMessage() ); 
		}
		return true;
	}
	
	public static boolean elementSelected (WebElement element){
		try {
			boolean flag = element.isSelected();
			Loggers.logTheTest(element + "<---------> is Selected, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is not Selected\n" + e.getMessage() );
		}
		return true;				
	}
	
	
	
	
	

}
