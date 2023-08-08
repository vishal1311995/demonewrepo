package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static UtilsLayer.UtilsClass.*;

import BaseLayer.BaseClass;

public class PIMPage extends BaseClass {

	@FindBy(xpath = "//a[text()='Add Employee']")
	private WebElement addemployeelink;

	@FindBy(name = "firstName")
	private WebElement firstname;

	@FindBy(name = "lastName")
	private WebElement lastname;

	@FindBy(name = "middleName")
	private WebElement middlename;

	@FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
	private WebElement empid;

	
	
	
	@FindBy(xpath = "//button[text() = ' Save ']")
	private WebElement savebutton;

	public PIMPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getPIMPageURL()
	{
		return getDriver().getCurrentUrl();
	}
	
	
	
	
	public String addEmployee(String fname, String mname, String lname) {
		click(addemployeelink);
		sendKeys(firstname, fname);
		sendKeys(middlename, mname);
		sendKeys(lastname, lname);
		String getEmpId = getAttribute(empid, "value");
		click(savebutton);
		return getEmpId;

	}
	
	
	public String addEmployee(String fname, String lname) {
		click(addemployeelink);
		sendKeys(firstname, fname);
		sendKeys(lastname, lname);
		String getEmpId = getAttribute(empid, "value");
		click(savebutton);
		return getEmpId;

	}

	@FindBy(xpath="//input[@name='firstName']/following::input[8]")
	private WebElement ssn;
	

	@FindBy(xpath="//input[@name='firstName']/following::input[9]")
	private WebElement sin;
	
	@FindBy(xpath="(//input[@name='firstName']/following::button)[1]")
	private WebElement saveButton;

	
	public void addPersonalInfo(String Ssn, String Sin)
	{
		sendKeys(ssn,Ssn);
		sendKeys(sin, Sin);
		click(saveButton);
	}
	
	
}
















