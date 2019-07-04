package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.PortalHomePage;
import resources.Base;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefiniation extends Base {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = InitialiseDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^click on login Link in home page to land on secure sign in page$")
	public void click_on_login_Link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
	}
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
    
	}

	@Then("^Verify that user is succesefully logged in$")
	public void verify_that_user_is_succesefully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    PortalHomePage p=new PortalHomePage(driver);
	    p.getSearchBox();
	}
	  @And("^close browser$")
	    public void close_browser() throws Throwable {
	        driver.quit();
	    }}