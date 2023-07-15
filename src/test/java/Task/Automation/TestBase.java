package Task.Automation;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestBase {
	static public  WebDriver driver;
	HomePage homepage;
  @BeforeMethod
  public void beforeMethod() {
	   WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://www.jumia.com.eg/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20 ,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
		driver.quit();
  }

}
