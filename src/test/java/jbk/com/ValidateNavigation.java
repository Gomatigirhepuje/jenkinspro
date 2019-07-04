package jbk.com;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class ValidateNavigation extends Base {
	private static Logger log=org.apache.logging.log4j.LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {
		driver = InitialiseDriver();
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");

	}

	@Test
	public void ValidateAppNavigationBar() throws IOException {

		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("navigation bar is displayed");


	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver=null;
	}

}
