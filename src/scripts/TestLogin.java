package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.Login;

public class TestLogin extends BaseTest
{
	@Test
	public void testLogin() throws InterruptedException{
		
	
	Login l= new Login(driver);
	String un = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 0);
	String pw = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 1);
	String expectedTitle = Lib.getCellValue(EXCEL_PATH,"ValidLogin", 1, 2);
	l.setUsername(un);
	l.SetPassword(pw);
	l.clickLogin();
Thread.sleep(2000);
	String actualtitle= driver.getTitle();
	SoftAssert s= new SoftAssert();
	s.assertEquals(actualtitle,expectedTitle);
	s.assertAll();

}
}
