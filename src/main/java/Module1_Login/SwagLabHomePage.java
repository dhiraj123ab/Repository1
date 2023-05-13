package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage 
{

	@FindBy(xpath="//div[@class='app_logo']") private WebElement logo;
	@FindBy(xpath="//div[@class='bm-burger-button']") private WebElement MenuBtn;
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory']") private WebElement AddToCart;
	@FindBy(xpath="//button[@class='btn btn_secondary btn_small btn_inventory']") private WebElement Remove;
	
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean GetSwagLabHomePageLogoResult()
	{
		boolean result = logo.isDisplayed();
		return result;
		
	}
	
	public void clickSwagLabHomePageMenuBtn()
	{
		MenuBtn.click();
	}
	
	public void ClickSwagLabHomePageAddToCartBtn()
	{
		AddToCart.click();
	}
	
	public String GetSwagLabHomePageRemoveBtn()
	{
		String actresult = Remove.getText();
		return actresult;
	}
	
	
	
}
