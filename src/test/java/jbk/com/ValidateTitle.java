package jbk.com;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	private static Logger log=org.apache.logging.log4j.LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {
		driver = InitialiseDriver();
		log.info("Driver is initialise");
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");

	}

	@Test
	public void ValidateAppTitle() throws IOException {

		LandingPage l = new LandingPage(driver);
		assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("succesfully valitedted text msg");


	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver=null;
	}

}
