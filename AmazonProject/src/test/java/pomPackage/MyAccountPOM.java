package pomPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseClass;

public class MyAccountPOM extends BaseClass {
@FindBy(id="nav-link-accountList-nav-line-1") WebElement SignIn;
@FindBy(id="ap_email") WebElement eMail;
@FindBy(id="continue") WebElement Continue;
@FindBy(id="ap_password") WebElement pSwd;
@FindBy(id="signInSubmit") WebElement SignInSubmit;
@FindBy(id="twotabsearchtextbox") WebElement SearchBox;
@FindBy(id="nav-search-submit-button") WebElement SearchIcon;
@FindBy(xpath="//*[text() = '$50 to $100']") WebElement FilterBy50To100;
@FindBy(id="a-autoid-0-announce") WebElement SortBy;
@FindBy(xpath="//div[@class='a-popover-inner']/ul/li[2]") WebElement PriceLowToHigh;
@FindBy(xpath="//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']") WebElement nextButton;
@FindBy(id="") WebElement c;
@FindBy(id="") WebElement v;
@FindBy(id="") WebElement b;

//initiate page elements
//inheriting the base class to call the driver	
public MyAccountPOM() {
PageFactory.initElements(driver,this);
}

//Element actions
public void SortyByLowToHigh() throws InterruptedException {
SortBy.click();
PriceLowToHigh.click();

//Select selectBox=new Select(SortBy);
//selectBox.selectByVisibleText("Price: High to Low");
//System.out.println("");
}
public void Pagination() throws InterruptedException {
	JavascriptExecutor jsE=(JavascriptExecutor)driver; 
	//Thread.sleep(4000);
	jsE.executeScript("window.scrollBy(0,10000);");
	//Thread.sleep(4000);
	List<WebElement> products= driver.findElements(By.xpath("//div[@class='a-section a-spacing-none s-padding-right-small s-title-instructions-style']"));
	//create empty arrayList
	List<String>productNames=new ArrayList<String>();
	//form a for loop:add all the products that have listed down inside the 'products'
	for(WebElement NAMES:products) {
		productNames.add(NAMES.getText());
		System.out.println(NAMES.getText());
	}
	int TotalNames=products.size();
	System.out.println("Total products in the current page: "+TotalNames);
	System.out.println("***********************************************************************************************************************************************************************");
	while(true) {
		Thread.sleep(2000);
		nextButton.click();
		//Thread.sleep(3000);
		jsE.executeScript("window.scrollBy(0,10000);");
		Thread.sleep(2000);
		products= driver.findElements(By.xpath("//div[@class='a-section a-spacing-none s-padding-right-small s-title-instructions-style']"));
		for(WebElement NAMES:products) {
			productNames.add(NAMES.getText());
			System.out.println(NAMES.getText());
		}
		int TotalNames1=products.size();
		System.out.println("Total products in the current page: "+TotalNames1);
		System.out.println("************************************************************************************************************************************************************************");
		try {
			nextButton.click();
		} catch (Exception e) {
			System.out.println("No more products now!");
			break;
		}
	}
	System.out.println("************************************************************************************************************************************************************************");
}

public void clickFilterBy50To100() {
	FilterBy50To100.click();
}
public void clickSearchIcon() {
	SearchIcon.click();
}
public void searchProduct(String sProd) {
	SearchBox.sendKeys(sProd);
}
public void clickSignInSubmit() {
	SignInSubmit.click();
}
public void typePsswd(String pswd) {
	pSwd.sendKeys(pswd);
}
public void clickContinue() {
	Continue.click();
}
public void typeEmail(String email) {
	eMail.sendKeys(email);
}
public void clickSignIn() {
	SignIn.click();
}

	
	
}
