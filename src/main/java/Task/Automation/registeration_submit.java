package Task.Automation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registeration_submit extends PageBase {

	public registeration_submit(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// elements
	@FindBy(xpath = "//p[contains(text(),'Almost there')]")
	public WebElement thirdPagetxt;
	@FindBy(id = "gender")
	public WebElement genderdropdown;
	@FindBy(xpath = "//ul[@class='mdc-list mdc-deprecated-list' and @aria-label = 'Gender']/li")
	public List<WebElement> genderlist;
	@FindBy(id = "input_birth_date")
	public WebElement birthDatetxt;
	@FindBy(id = "acceptTC")
	public WebElement agreement;
	@FindBy(id = "confirmBtn")
	public WebElement submitButton;
	@FindBy(xpath = "//*[contains(text(),'Your account')]")
	public WebElement sucsessPage;

	// methods

	public void selectGenderThenEnterBirthDateThenPressOnSubmitButton(String gender, String birthDate) {
		HomePage homepage = new HomePage(driver);
		homepage.waitUntilBeThisElenemtBeVisible(thirdPagetxt);
		clikOnItem(genderdropdown);
		selectItemFromDropDownList(genderlist,gender);
		clikOnItem(birthDatetxt);
		wait_seconds(500);
		sendTxtToAnElement(birthDatetxt, birthDate);
		clikOnItem(agreement);
		homepage.waitUntilBeThisElenemtBeClickable(submitButton);
		clikOnItem(submitButton);
	}
}
