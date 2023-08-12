package PageObject;

import java.util.List;

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

public class SearchCustomerByEmail {
	WebDriver ldriver;

	public SearchCustomerByEmail(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(id = "SearchEmail")
	WebElement email;
	@FindBy(id = "search-customers")
	WebElement searchbtn;
//	@FindBy(xpath="//table[@role='grid']")
//	WebElement searchresult;
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement>tablerow;
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement>tablecol ;
	@FindBy(id="SearchFirstName")
	WebElement firstName;

	@FindBy(id="SearchLastName")
	WebElement lastName;





	//	public String getpagetitle()
	//	{
	//		return ldriver.getTitle();
	//
	//	}
	public void enterEmailid(String email1)
	{

		email.sendKeys(email1);
	}
	public void clickonserchbtn()
	{

		searchbtn.click();
	}
	public boolean searchbyEmail(String email1)
	
	{
		boolean found=false;
		int total_rows= tablerow.size();
		//int total_col=tablecol.size();
		
		for(int i=1;i<=total_rows;i++)
		{
			// for(int j=1;i<total_col;j++)
				   WebElement find=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[2]"));
				   String actualemail=find.getText();
				   System.out.println(actualemail);
				   if (actualemail.equals(email1))
				   {
					   return found=true;
				   }
				  
		}
		 return found; 
		
	}
	public static void main(String[] args) {
		
	}

}


