package tech.digitalpoint.software.elementlocator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import tech.digitalpoint.software.utilities.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;
	Select select;
	By knowledgeCenter = By.xpath("//*[@id=\'bs-example-navbar-collapse-1\']/ul/li[3]/a");
	By cyberSecurity = By.xpath("//*[@id=\'customers\']/tbody/tr[2]/td[3]/a");
	By secureAgile = By.xpath("//*[@id=\'customers\']/tbody/tr[3]/td[3]/a");
	By softwareTesting = By.xpath("//*[@id=\'customers\']/tbody/tr[4]/td[3]/a");
	By devOps = By.xpath("//*[@id=\'customers\']/tbody/tr[5]/td[3]/a");
	By cyberAttack = By.xpath("//*[@id=\"customers\"]/tbody/tr[6]/td[3]/a");

	By freequto = By.xpath("(//a[text()='Get a Free Quote'])[2]");
	//By freequto= By.linkText("Get a Free Quote");
	By firstName = By.name("fname");
	By lastName = By.name("lname");
	By compEmail = By.name("cemail");
	By phoneNumber = By.name("pnumber");
	By service = By.name("services");
	By descriptiont = By.name("description");
	By submit = By.xpath("//*[@id=\'produce-qualitiy\']/div/div/div/div/form/table/tbody/tr[15]/td[3]/input");
	By links = By.tagName("a");
	
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
	}

	public String getTtile() {
		return driver.getTitle();
	}
	public void checkHomePageLinks() {
		List<WebElement> linkslist = driver.findElements(links);
		int linkCount = linkslist.size();
		System.out.println("Total number of link is " + linkCount);
		for (int i = 0; i < linkCount - 1; i++) {
			String linkName = linkslist.get(i).getText();
			System.out.println(linkName);
		}

	}

	public void knowledgeCenterFunctionality() {
		driver.findElement(knowledgeCenter).click();
		driver.findElement(cyberSecurity).click();
		driver.findElement(secureAgile).click();
		driver.findElement(softwareTesting).click();
		driver.findElement(devOps).click();
}

	public void doRegisration(String firstname, String lastname, String companyEmail,String phoneNum , Select text, String Des) {
		driver.findElement(freequto).click();
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(compEmail).sendKeys(companyEmail);
		driver.findElement(phoneNumber).sendKeys(phoneNum);
		
			WebElement serv =driver.findElement(service);
		Select select = new Select(serv);
		select.selectByVisibleText("Performance Testing ");
    	driver.findElement(descriptiont).sendKeys(Des);

//	try {
//    	driver.findElement(description).sendKeys(Des);
//
//	}
//		catch (Exception e) {
//			System.out.println("Exception occured ");
//		}

		driver.findElement(submit).click();
		
		
	}
}
