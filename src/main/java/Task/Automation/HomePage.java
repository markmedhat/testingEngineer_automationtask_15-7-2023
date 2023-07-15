package Task.Automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// elements

	@FindBy(xpath = "(//button[@class='cls'])[2]")
	public WebElement closePopUp;
	@FindBy(xpath = "//label[contains(text(),'Account')]")
	public WebElement accountBtn;
	@FindBy(xpath = "//a[@class='btn _prim -fw _md']")
	public WebElement signInBtn;
	@FindBy(xpath = "//h2[contains(text(),'Welcome')]")
	public WebElement welcometext;
	@FindBy(xpath = "//span[@class='text' and contains(text(),'Fashion')]")
	WebElement fashionSection;
	@FindBy(xpath = "//a[@class='s-itm' and contains(text(),'Shirts')]")
	WebElement shirtsItem;

	// methods

	public void close_poup() {

		clikOnItem(closePopUp);

	}

	public void press_on_signinbtn() {
		clikOnItem(accountBtn);
		clikOnItem(signInBtn);
	}

	public void waitUntilBeThisElenemtBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilBeThisElenemtBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void closePopFromHomeThenPressOnSignInBtn() {
		close_poup();
		press_on_signinbtn();
		waitUntilBeThisElenemtBeVisible(welcometext);

	}

	public void hoverOnitem(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}


	public void clickOnItem(WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).perform();
	}
	public void hoverOnFasionSectionThenPressOnShirts() {
		hoverOnitem(fashionSection);
		clikOnItem(shirtsItem);
		wait_seconds(2000);
	}

}
