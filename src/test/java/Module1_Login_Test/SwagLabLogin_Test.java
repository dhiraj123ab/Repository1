package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.SwagLabHomePage;
import Module1_Login.SwagLabLoginPage;
import Module2_Menu.SwagLabMenuPage;

public class SwagLabLogin_Test extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabMenuPage menu;
	int TCID;
	@BeforeClass
	public void openBrowser() throws IOException
	{
		InitializeBrowser();
		login= new SwagLabLoginPage(driver);
		home= new SwagLabHomePage(driver);
	    menu= new SwagLabMenuPage(driver);
	}

	@BeforeMethod
	public void LoginToApp() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		login.inpSwagLabLoginPageUsername(UtilityClass.getPFdata("UN"));
		login.inpSwagLabLoginPagePassword(UtilityClass.getPFdata("PWD"));
		login.clickSwagLabLoginPageLoginBtn();
	
	}
	
	@Test
	public void verifyLog()
	{
		TCID=101;
		boolean actresult = home.GetSwagLabHomePageLogoResult();
		Assert.assertTrue(actresult, "Failed actual result is false");
	}
	
	@Test
	public void verifyAddToCartBtnConvertToRemoveBtn() throws EncryptedDocumentException, IOException
	{
		TCID=102;
		home.ClickSwagLabHomePageAddToCartBtn();
		String actResult = home.GetSwagLabHomePageRemoveBtn();
		String expectedResult = UtilityClass.getTD(1,3);
		Assert.assertEquals(actResult, expectedResult);
		
	}
	
	
	@AfterMethod
	public void LogoutFromApp(ITestResult s1) throws IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver, TCID);
		}
		
		home.clickSwagLabHomePageMenuBtn();
		menu.clickSwagLabMenuPageLogoutBtn();
	}
	
	
	@AfterClass
	public void closebrowser()
	{
		driver.close();
	}
	
	
}

