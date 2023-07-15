package Task.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registeration_page1 extends PageBase {

	public registeration_page1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// page 1
	// elements
	@FindBy(xpath = "//h2[contains(text(),'Welcome')]")
	public WebElement welcometext;
	@FindBy(id = "input_identifierValue")
	public WebElement email;
	@FindBy(xpath = "//button[@type = 'submit']")
	public WebElement contBtn1;

	// elements to login
	@FindBy(xpath = "//input[@type = 'password' and @name = 'password']")
	WebElement passwordtxt;
	@FindBy(id = "loginButton")
	WebElement loginBtn;

	public void generateAnRandomemailThenSendIt(String txt, WebElement element) {
		int random_int = (int) Math.floor(Math.random() * (987654321 - 123456789 + 1) + 123456789);
		String emailAddress = txt + random_int + "@gmail.com";
		sendTxtToAnElement(element, emailAddress);

	}

	public void pressOncontinueBtn() {
		clikOnItem(contBtn1);
	}

	public void sendEmailTxtThenPressContinue(String txt) {
		generateAnRandomemailThenSendIt(txt, email);
		pressOncontinueBtn();
	}

	public void sendAnEmail(String emailtxt) {
		sendTxtToAnElement(email, emailtxt);

	}

	public void sendPasswordThenPressLoginButton(String password) {
		pressOncontinueBtn();
		sendTxtToAnElement(passwordtxt, password);
		clikOnItem(loginBtn);
		wait_seconds(2000);
	}
}
