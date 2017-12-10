package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
//declartion
	@FindBy(id="username")
	private WebElement unTB;
	@FindBy(name="pwd")
	private WebElement pwTB;
	@FindBy(xpath="//div[.='Login ']")
	private WebElement LoginBtn;
	//initiatlisation
	public Login(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}
		
	//utilisation
	public void setUsername(String un){
		unTB.sendKeys(un);
	}
	public void SetPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	public void clickLogin(){
		LoginBtn.click();
	}
}
