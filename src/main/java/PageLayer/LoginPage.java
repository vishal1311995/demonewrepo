package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static UtilsLayer.UtilsClass.*;

import BaseLayer.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement login;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void loginFunctionality(String Username, String Password) {

		sendKeys(username, Username);
		sendKeys(password, Password);
		click(login);
	}

}
