package Task.Automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.userDate;

public class Registeration extends TestBase {
	HomePage homepage;
	registeration_page1 page1;
	registeration_page2 page2;
	registeration_page3 page3;
	registeration_submit submitpage;

	@Test(dataProvider = "userData", dataProviderClass = userDate.class)
	public void RegisterationNewUser(String testemail, String password, String fname, String lname, String phone,
			String gender, String birthdate) {
		// object from pages
		homepage = new HomePage(driver);
		page1 = new registeration_page1(driver);
		page2 = new registeration_page2(driver);
		page3 = new registeration_page3(driver);
		submitpage = new registeration_submit(driver);
		

		// steps
		homepage.closePopFromHomeThenPressOnSignInBtn();
		page1.sendEmailTxtThenPressContinue(testemail);
		page2.sendPasswordThenPressContinousBtn(password);
		page3.enterFnameLnamePhoneThenPressContinue(fname, lname, phone);
		submitpage.selectGenderThenEnterBirthDateThenPressOnSubmitButton(gender, birthdate);

		
		//assertion
		Assert.assertEquals(submitpage.sucsessPage.getText().contains("Your account"), true);

	}

}
