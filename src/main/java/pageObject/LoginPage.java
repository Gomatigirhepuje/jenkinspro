package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By Email= By.cssSelector("input[id='user_email']");
	By Password= By.cssSelector("input[id='user_password']");
	By Login= By.cssSelector("input[type='submit']");


	public WebElement getEmail() {
		return driver.findElement(Email);
	}
	public WebElement getPassword() {
		return driver.findElement(Password);
	}
	public WebElement getLogin() {
		return driver.findElement(Login);
	}

}
