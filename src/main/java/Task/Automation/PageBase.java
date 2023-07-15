package Task.Automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// common methods
	public void sendTxtToAnElement(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void clikOnItem(WebElement element) {
		element.click();
	}

	public void wait_seconds(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectItemFromDropDownList(List<WebElement> list, String itemtxt) {
		int sizeOfList = list.size();
		for (int i = 0; i < sizeOfList; i++) {
			if (list.get(i).getText().contains(itemtxt)) {
				list.get(i).click();
				break;
			}
		}
	}

}
