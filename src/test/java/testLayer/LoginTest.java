package testLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseHRMClass;
import pompackage.Pomlogin;

public class LoginTest extends BaseHRMClass {
	Pomlogin Log;
	public LoginTest() throws IOException {
		super();
		}
	@BeforeMethod
	public void initsetup() throws IOException, InterruptedException {
		initiate();
		Log=new Pomlogin();
	}
	
	@Test (priority=1)
	public void Title() {
		
	String actual=Log.verify();
	System.out.println(actual);
	Assert.assertEquals(actual, "OrangeHRM");
	}
	//@DataProvider
	//public Object[][] Details(){
	//	Object result[][]=ExcelSheet.readdata("Sheet1");
	//}
	@Test(priority=2)
	public void Login() throws InterruptedException  {
		Log.typeusername(prop.getProperty("username"));
		Thread.sleep(3000);
		Log.typepassword(prop.getProperty("password"));
		Thread.sleep(3000);
		Log.clickbtn();
	}
	//@AfterMethod
	//public void close() {
	//	driver.close();
//	}
	
	
}
