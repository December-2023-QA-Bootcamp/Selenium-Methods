package baseUtil;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ForgotUserId;
import pages.HomePage;
import pages.NewUserRegistration;
import utils.Configuration;
import static utils.IConstant.*;

public class BaseClass {
	public WebDriver driver;
	public HomePage homePage;
	Configuration configuration;
	public NewUserRegistration newUserRegistration;
	public ForgotUserId forgotUserId;
	public Select select;
	
	// Before start a test what need to do?
	@BeforeMethod
	public void setUp() {
		configuration = new Configuration();
		initDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(configuration.getProperties(URL));
		// How can we convert a String to Long type
		long pageLoadWait = Long.parseLong(configuration.getProperties(PAGELOAD_WAIT));
		long implicitlyWait = Long.parseLong(configuration.getProperties(IMPLICITLY_WAIT));		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
		initClass();
	}
	
	public void initDriver() {
		String browserName = configuration.getProperties(BROWSER);
		
		switch (browserName) {
		
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	
			driver = new ChromeDriver();
			break;

		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		
		case "EDGE":
			System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
			
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
	}
	
	public void initClass() {
		homePage = new HomePage(driver);
		newUserRegistration = new NewUserRegistration();	
		forgotUserId = new ForgotUserId(driver);
	}	
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	// config.properties file in src/main/resoures
	// util package
	// Constant
	// IConstant
	// Configuration
	// change in Base class
	// import static utils.IConstant.*; necessary
	
	
	
	
	
	

}