package Task.Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registeration_page2 extends PageBase {

	public registeration_page2(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// page 2
	// elements
	@FindBy(xpath = "//input[@type='password']")
	public List<WebElement> passwordInput;
	@FindBy(id = "password-strength-text")
	public WebElement strongPasswordLabel;
	@FindBy(xpath = "//button[@type = 'button' and @class = 'mdc-button mdc-button--touch mdc-button--raised to-personal-details mdc-ripple-upgraded']")
	public WebElement contBtn2;

	// methods

	public void sendPasswordThenPressContinousBtn(String password) {
		
		sendTxtToAnElement(passwordInput.get(1), password);
		sendTxtToAnElement(passwordInput.get(0), password);
		HomePage homepage = new HomePage(driver);
		homepage.waitUntilBeThisElenemtBeVisible(strongPasswordLabel);
		wait_seconds(2000);
		clikOnItem(contBtn2);
		
	}
}
