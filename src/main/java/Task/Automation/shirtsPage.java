package Task.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shirtsPage extends PageBase {

	public shirtsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// elements
	@FindBy(xpath = "//article[@class = 'prd _fb col c-prd'][2]")
	WebElement secondrow;
	@FindBy(xpath = "//article[@class = 'prd _fb col c-prd'][2]/a/div[@class='info']/h3")
	WebElement firstshirttitle;
	@FindBy(xpath = "//article[@class = 'prd _fb col c-prd'][2]/a/div[@class = 'info']/div[@class = 'prc']")
	WebElement firstshirtprice;
	@FindBy(xpath = "//article[@class = 'prd _fb col c-prd'][2]/footer/div/button")
	WebElement firstshirtbtn;
	@FindBy(xpath = "//a[@class = 'btn _prim -fw']")
	WebElement checkout;
	// methods

	public Object[] scrollDownTillReachToSecondRowThenGetTitleAndPriceThenHoverOnItem() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait_seconds(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", secondrow);
		wait_seconds(2000);
		String shirttitle = firstshirttitle.getText();
		String pricetxt = firstshirtprice.getText();
		pricetxt = pricetxt.replace("EGP ", "");
		Float price = Float.parseFloat(pricetxt);
		Object[] titleandprice = new Object[2];
		titleandprice[0] = shirttitle;
		titleandprice[1] = price*3;
		System.out.println("total price= " + price);
		HomePage homepage = new HomePage(driver);
		homepage.hoverOnitem(secondrow);
		homepage.clickOnItem(firstshirtbtn);

		return titleandprice;

	}

	public void addTwoItems() {

		for (int i = 0; i <= 1; i++) {
			try {
				WebElement firstSizeAddBtn = driver
						.findElement(By.xpath("(//div[@class = '-df -i-ctr -j-bet -pvs']/form/button[2])[1]"));
				firstSizeAddBtn.click();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			wait_seconds(2000);
		}
		
		clikOnItem(checkout);
	}

}
