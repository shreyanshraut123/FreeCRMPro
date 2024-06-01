package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabels;

//	@FindBy(xpath="//a[text()='test2 test']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
//	WebElement contactdetail;

	// Initializing the Page Object
	public ContactPage() {
		PageFactory.initElements(driver, this);// this: current class object
	}

	public boolean verifyContactsLebel() {
		return contactsLabels.isDisplayed();
	}

	public void  selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
	+"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}

}
