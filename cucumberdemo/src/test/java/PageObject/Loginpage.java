
package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver ldriver;

	public Loginpage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "Email")
	WebElement email;
	@FindBy(id = "Password")
	WebElement password;
	@FindBy(className = "login-button")
	WebElement loginbtn;
	@FindBy(linkText ="Logout")
	WebElement logoutbtn;

	public void enterEmail(String emailid) {
		email.clear();
		email.sendKeys(emailid);

	}

	
	public void enterpassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}

	public void clickonLogin() {
		loginbtn.click();
	}

	public void clickonLogout() {
		logoutbtn.click();
	}

}
