package Task.Automation;

import java.util.List;

import org.checkerframework.checker.index.qual.IndexFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registeration_page3 extends PageBase {

	public registeration_page3(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// page 3
	//elements
	@FindBy(xpath = "//p[contains(text(),'fill in some details')]")
	public WebElement secondPagetxt ;
	@FindBy(id = "input_first_name")
	public WebElement fnametxt;
	@FindBy(id = "input_last_name")
	public WebElement lnametxt;
	@FindBy(xpath = "//input[@type= 'tel']")
	public WebElement phonetxt;
	@FindBy(xpath = "//button[@type = 'button' and @class = 'mdc-button mdc-button--touch mdc-button--raised to-personal-details-part-2 mdc-ripple-upgraded']")
	public WebElement contBtn3;
	
	//methods
	public void enterFnameLnamePhoneThenPressContinue(String fname , String lname , String phone)
	{

		HomePage homepage = new HomePage(driver);
		homepage.waitUntilBeThisElenemtBeVisible(secondPagetxt);
		
		sendTxtToAnElement(fnametxt, fname);
		sendTxtToAnElement(lnametxt, lname);
		sendTxtToAnElement(phonetxt, phone);
		wait_seconds(2000);
		clikOnItem(contBtn3);



		
	}
}
