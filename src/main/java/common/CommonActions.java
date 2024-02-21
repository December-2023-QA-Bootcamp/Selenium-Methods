package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CommonActions {
	
	public static void clickElement(WebElement element) {
		try {
			element.click();
		} catch (NoSuchElementException | NullPointerException e) {
			System.out.println("Exception is: " + e);
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
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void inputText(WebElement element, String input) {
		try {
			element.sendKeys(input);
		} catch (NoSuchElementException | NullPointerException e) {
			// System.out.println("Exception is: " + e);
			e.printStackTrace();
		}
		
	}
	
	

}
