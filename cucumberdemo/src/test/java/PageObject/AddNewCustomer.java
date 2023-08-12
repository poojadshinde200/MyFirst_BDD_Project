package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.util.AsciiString;

public class AddNewCustomer {
	WebDriver ldriver;

	public AddNewCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement Customersmenu;
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement CustomersmenuItem;

	@FindBy(linkText =  "Add new")
	WebElement AddNew;

	@FindBy(id = "Email")
	WebElement email;
	@FindBy(id = "Password")
	WebElement password;
	@FindBy(id = "FirstName")
	WebElement firstname;
	@FindBy(id ="LastName")
	WebElement lastname;
	@FindBy(id = "Gender_Male")
	WebElement gender_male;
	@FindBy(id = "Gender_Female")
	WebElement gender_female;
	@FindBy(id = "DateOfBirth")
	WebElement dob;
	@FindBy(id ="Company")
	WebElement company_name;
	@FindBy(id ="IsTaxExempt")
	WebElement tax;
	@FindBy(xpath = ".//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div")
	WebElement newsletter;
	@FindBy(css = ".k-button.k-state-hover")
	WebElement customer_roles;
	@FindBy(className = "VendorId")
	WebElement manager_vendor;
	@FindBy(id ="Active")
	WebElement Active;
	@FindBy(id ="AdminComment")
	WebElement comment;
	@FindBy(xpath="//button[@name='save']")
	WebElement Save;

	public String getpagetitle()
	{
		return ldriver.getTitle();

	}
	public void clickOnCustomersMenu()
	{
		//		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		//		jse.executeScript("arguments[0].click();", Customersmenu);
		Customersmenu.click();
	}
	public void clickOnCustomersMenuItem()
	{
		
		//	  JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		//      jse.executeScript("arguments[0].click();", CustomersmenuItem);
		CustomersmenuItem.click();
	}
	public void clickOnAddnew() {
		AddNew.click();
	}

	public void enterEmail(String emailid) {
		//email.clear();
		email.sendKeys(emailid);

	}

	public void enterpassword(String pass) {
		//password.clear();
		password.sendKeys(pass);
	}
	public void enterFirstName(String firstName)
	{
		firstname.sendKeys(firstName);
	}

	public void enterLastName(String lastName)
	{
		lastname.sendKeys(lastName);
	}
	public void enterDob(String dob2)
	{
		dob.sendKeys(dob2);
	}

	public void enterCompanyName(String coName)
	{
		company_name.sendKeys(coName);
	}

	public void entertax(String tax1)  
	{
		tax.sendKeys(tax1);

	}
	public void newsletter(String news)  
	{
		Select drp1=new Select(newsletter);
		drp1.selectByVisibleText(news);

	}

	public void enterCustomerRoles(String role)  
	{
		Select drp=new Select(customer_roles);
		drp.selectByVisibleText(role);

	}

	public void enterManagerOfVendor(String value)
	{
		Select drp=new Select(manager_vendor);
		drp.selectByVisibleText(value);
	}

	public void enterGender(String gender)
	{
		if(gender.equals("Male"))
		{
			gender_male.click();
		}
		else if(gender.equals("Female"))
		{
			gender_female.click();
		}
		else//default set Male gender
		{
			gender_male.click();
		}

	}
	public void enterActive(String active1)  
	{
		Active.sendKeys(active1);

	}

	public void enterAdminContent(String content)
	{
		comment.sendKeys(content);
	}

	public void clickOnSave()
	{
		Save.click();
	}
	public String getconfirmationmsg()
	{
		String text  = ldriver.findElement(By.tagName("Body")).getText();
		return text;
	}
}


