package basepackage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseHRMClass {
public	static Properties prop=new Properties();

public static	WebDriver driver;
//step1 
	public BaseHRMClass() {
		try {
FileInputStream file=new FileInputStream("C:\\Users\\drash\\eclipse-workspace\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.rpoperties");
prop.load(file);			
	}
	catch(FileNotFoundException e) {
	e.printStackTrace();
	}
	catch(IOException a) {
		a.printStackTrace();
	}}
		//step 2 
		
	public static void initiate() throws InterruptedException {
		String browsername=	prop.getProperty("browser");
	if (browsername.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
	   driver=  new ChromeDriver(op);
		
		}
	
else if (browsername.equals("Firefox")) {
	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

	driver=new FirefoxDriver();}
	
	 driver.manage().window().maximize();
	 driver.manage().timeouts().pageLoadTimeout(TimeUtils.Timepage, TimeUnit.SECONDS);
	 Thread.sleep(5000);
	 driver.get(prop.getProperty("url"));
	}

}

   

	

