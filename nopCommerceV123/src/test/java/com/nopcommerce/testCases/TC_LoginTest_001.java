package com.nopcommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;



public class TC_LoginTest_001 extends BaseClass
{
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		logger.info("..........TC_LoginTest_001 Started...........");
		logger.info("..........Opening URL of Application...........");
		
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		
		logger.info("..........Providing Login Details...........");
		
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		logger.info("..........Validating User Login with valid credentials...........");
	Thread.sleep(5000);
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title))
		{
			logger.info("..........Login Test is passed...........");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"loginTest");
			logger.error("..........Login Test is failed...........");
			Assert.assertTrue(false);

		}
		
		
		
	

logger.info("..........TC_LoginTest_001 is finished...........");
}
}