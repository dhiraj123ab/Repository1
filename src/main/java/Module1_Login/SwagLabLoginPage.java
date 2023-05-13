package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage 
{
	@FindBy(xpath="(//input[@class='input_error form_input'])[1]") private WebElement UN;
	@FindBy(xpath="//input[@placeholder='Password']") private WebElement pwd;
	@FindBy(xpath="//input[@class='submit-button btn_action']") private WebElement LoginBtn;
	
	public SwagLabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpSwagLabLoginPageUsername(String username)
	{
		UN.sendKeys(username);
	
	}
	
	public void inpSwagLabLoginPagePassword(String password)
	{
		pwd.sendKeys(password);
	}
	
	public void clickSwagLabLoginPageLoginBtn()
	{
		LoginBtn.click();
	}
	
	
}
