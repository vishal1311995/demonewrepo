package TestLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.HomePage;
import PageLayer.PIMPage;

@Test(groups = { "EndToEndTesting", "PIMpage"}, dependsOnGroups = "HomePage")
public class PIMPageTest extends BaseClass {

	private PIMPage pimpage;
	String EID;

	@Test(priority = 1)
	public void validateUserOnPIMPage() {
		HomePage homepage = new HomePage();
		homepage.clickOnPIMLink();

		pimpage = new PIMPage();
		Assert.assertEquals(pimpage.getPIMPageURL().contains("pim"), true);

	}
	
	@Test(priority=2)
	public void validateaddEmployeeFunctionality() {
		EID = pimpage.addEmployee("gauri", "chawathe");

	}

	@Test(priority=3)
	public void validateAddPersonalDetails() throws InterruptedException
	{
		Thread.sleep(5000);
		pimpage.addPersonalInfo("11111", "22222");
		
	}
	
	
	
}
