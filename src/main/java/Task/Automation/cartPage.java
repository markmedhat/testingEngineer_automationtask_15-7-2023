package Task.Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartPage extends PageBase {

	public cartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// elements

	@FindBy(xpath = "(//button[@class = 'btn _prim _qty -paxs'])[2]")
	WebElement incrementfromcart;
	@FindBy(xpath = "//article[@class = 'prd _cl']/a/div[2]/h3")
	WebElement titleincart;
	@FindBy(xpath = "//div[@class = '__ps-to-header -ptm']/article/div[1]/p[2]")
	WebElement totalaPricetxt;

	// methods

	public Object[] incrementNoOfItemFromCart() {
		clikOnItem(incrementfromcart);

		wait_seconds(2000);
		String shirttitle = titleincart.getText();
		String pricetxt = totalaPricetxt.getText();
		pricetxt = pricetxt.replace("EGP ", "");
		pricetxt = pricetxt.replace(",", "");
		Float price = Float.parseFloat(pricetxt);
		Object[] titleandprice = new Object[2];
		titleandprice[0] = shirttitle;
		titleandprice[1] = price;
		System.out.println("price= " + price);

		return titleandprice;

	}

}
