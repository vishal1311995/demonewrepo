package TestLayer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.LoginPage;

@Test(priority = 1)
public class LoginPageTest extends BaseClass {

	private LoginPage loginpage;

	@Parameters({ "browsername" })
	@BeforeTest(groups = {"EndToEndTesting","LoginPage"})
	public void setUp(String browsername) {
		initialization(browsername);
	}

	@Test(groups = {"EndToEndTesting","LoginPage"})
	public void validateLoginPageFunctionaliy() {
		loginpage = new LoginPage();
		loginpage.loginFunctionality("Admin", "admin123");
	}

}
