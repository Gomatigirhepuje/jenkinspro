package jbk.com;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base {
	private static Logger log=org.apache.logging.log4j.LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {
		driver = InitialiseDriver();
		
	}

	@Test(dataProvider = "getData")

	public void basePageNavigation(String username, String pass, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(pass);
		log.info(text);

		lp.getLogin().click();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		// 1st data
		data[0][0] = "goma@qa.com";
		data[0][1] = "132423";
		data[0][2] = "1st data";

		data[1][0] = "gomati@qa.com";
		data[1][1] = "161616";
		data[1][2] = "2nd dta";

		return data;

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver=null;
	}

}
