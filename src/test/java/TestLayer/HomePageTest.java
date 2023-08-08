package TestLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.HomePage;


@Test(groups = { "EndToEndTesting", "HomePage" }, dependsOnGroups = "LoginPage")
public class HomePageTest extends BaseClass {

	private HomePage homepage;

	@Test(priority=1)
	public void validateHomePageUrl() {

		homepage = new HomePage();
		Assert.assertEquals(homepage.getUrl().contains("hrm"), true);

	}

	@Test(priority=2)
	public void validateHomePageTitle() {

		Assert.assertEquals(homepage.getTitle(), "OrangeHRM");

	}
	
	@Test(priority=3)
	public void validateHomePageLogo() {

	Assert.assertEquals(homepage.getLogoDisplayStatus(),true);

	}

}
