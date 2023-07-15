package Task.Automation;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.DataProvider;

public class secondTask extends TestBase{
	HomePage homepage;
	registeration_page1 page1;
	shirtsPage shirt_page;
	cartPage cart_page;
	@Test(dataProvider = "logindata")
	public void secondAutomationTask(String email, String password)  {
		
		//page objects 
		homepage = new HomePage(driver);
		page1=  new registeration_page1(driver);
		shirt_page =new  shirtsPage(driver);
		cart_page = new cartPage(driver);
		Object[] titleAndPrice = new Object[2];
		Object[] carttitleAndPrice = new Object[2];


		
		//steps
		homepage.closePopFromHomeThenPressOnSignInBtn();
		page1.sendAnEmail(email);
		page1.sendPasswordThenPressLoginButton(password);
		homepage.hoverOnFasionSectionThenPressOnShirts();
		titleAndPrice = shirt_page.scrollDownTillReachToSecondRowThenGetTitleAndPriceThenHoverOnItem();
		shirt_page.addTwoItems();
		carttitleAndPrice = cart_page.incrementNoOfItemFromCart();
		
		//assertion
		


	    
	    SoftAssert softassert = new SoftAssert();
	    softassert.assertEquals(titleAndPrice[0], carttitleAndPrice[0]);
	    softassert.assertEquals(titleAndPrice[1], carttitleAndPrice[1]);
	    softassert.assertAll();
		
		
	}

	@DataProvider(name = "logindata")
	public Object[][] logindata() {
		return new Object[][] { new Object[] { "test_automation@gmail.com", "TEMP@new123456789" }, };
	}
}
