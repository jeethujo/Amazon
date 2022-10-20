package pomPackage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basePackage.BaseClass;
public class AmazonPOM extends BaseClass {
/*1. create object repository by adding 
	 all elements from the Your Store Sign up Page*/	
//sendKeys fields
@FindBy(id="nav-link-accountList-nav-line-1") WebElement SignIn;
@FindBy(id="createAccountSubmit") WebElement CreateAmazonAccount;
@FindBy(id="ap_customer_name") WebElement fName;
@FindBy(id="ap_email") WebElement eMail;
@FindBy(id="ap_password") WebElement pSwd;
@FindBy(id="ap_password_check") WebElement cnfmPswd;
@FindBy(id="continue") WebElement verifyEmail;
@FindBy(id="cvf-submit-otp-button") WebElement CreateAmazonAccountButton;



//initiate page elements
//inheriting the base class to call the driver
public AmazonPOM() {
PageFactory.initElements(driver,this);
}

//keyboard and mouse actions
public void pressEnter() {
	Actions action;
	action=new Actions(driver);
	action.sendKeys(Keys.ENTER).build().perform();
}
public void refresh(WebDriver driver) {
	driver.navigate().refresh();
}
public void scrollDown(WebDriver driver) {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("window.scrollBy(0,2500)", "");
}

//Element actions
public void clickSignIn() {
	SignIn.click();
}
public void clickCreateAmazonAccount() {
	CreateAmazonAccount.click();
}
public void typeFname(String firstName) {
	fName.sendKeys(firstName);
}
public void typeEmail(String email) {
	eMail.sendKeys(email);
}
public void typePsswd(String pswd) {
	pSwd.sendKeys(pswd);
}
public void typeCnfrmPswd(String cnfpswd) {
	cnfmPswd.sendKeys(cnfpswd);
}
public void clickVerifyEmail() {
	verifyEmail.click();
}
public void clickCreateAmazonAccountButton() {
	CreateAmazonAccountButton.click();
}

}
