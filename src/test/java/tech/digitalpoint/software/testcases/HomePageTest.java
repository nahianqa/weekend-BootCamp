package tech.digitalpoint.software.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import tech.digitalpoint.software.elementlocator.HomePage;
import tech.digitalpoint.software.utilities.BasePage;
import tech.digitalpoint.software.utilities.Constant;
import tech.digitalpoint.software.utilities.LogCollection;

public class HomePageTest {
	private static final Select Select = null;
	WebDriver driver;
BasePage basepage;
HomePage homepage;
Properties prop;

@BeforeMethod
public void browserSetup() {
basepage= new BasePage();
prop=basepage.init_properties();
driver =basepage.getBrowser(prop);
homepage =new HomePage(driver);
LogCollection.debug("Open browser Successfully");

}

@Test
public void verifyHomePageTitle() {
	String title= homepage.getTtile();
	System.out.println("Home Page title is " + title);
	Assert.assertEquals(title, Constant.Home_Page_title);
	LogCollection.debug("Validate Home page title");

}
@Test
public void regPageValidation() {
	homepage.doRegisration(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("companyEmail"),prop.getProperty("phoneNum"), Select,prop.getProperty("Descrip"));
	LogCollection.debug("Reg process successfull");

}
@Test
public void linkfunctiolality() {
	homepage.checkHomePageLinks();
	LogCollection.debug("Printed All link on home page");

}
@Test
public void checkKnowledgecenter() {
	homepage.knowledgeCenterFunctionality();
	LogCollection.debug("Download all file from Knowledge Center");

}


@AfterMethod
public void see() {
driver.quit();
}
}
