package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static UtilsLayer.UtilsClass.*;

import BaseLayer.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//img[@alt ='client brand banner']")
	private WebElement logo;

	@FindBy(xpath = "(//a[@class='oxd-main-menu-item'])[2]")
	private WebElement pimlink;

	@FindBy(xpath = "(//a[@class='oxd-main-menu-item'])[1]")
	private WebElement adminlink;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String getTitle() {
		return getDriver().getTitle();
	}

	public String getUrl() {
		return getDriver().getCurrentUrl();
	}

	public boolean getLogoDisplayStatus() {
		return displayStatus(logo);

	}

	public void clickOnPIMLink() {
		click(pimlink);
	}

	public void clickOnadminLink() {
		click(adminlink);
	}

}
