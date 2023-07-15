package data;

import org.testng.annotations.DataProvider;

public class userDate {
   @DataProvider(name = "userData")
  public  Object[][] testDate() {
    return new Object[][] {
      new Object[] { "email", "TEMP@new123456789","fname","lname","1234567890","Male","11181993" },
      new Object[] { "email2", "TEMP@new123456789", "fname","lname","1234567890","Female","11181993" },
    };
  }
}
