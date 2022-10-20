package testLayerPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import basePackage.BaseClass;
import pomPackage.MyAccountPOM;
import utilityPackage.ListenersClass;
@Listeners(ListenersClass.class)
public class MyAccountTest extends BaseClass {
	/*4.To call methods in the test cases, create object 
	and declare it globally*/
MyAccountPOM myA;
SoftAssert Assert=new SoftAssert();
//1. create constructor of the RegisterTest class
public MyAccountTest() {
//2.Read all properties of the BaseClass(to call the constructor of parent class)
super();
}
@BeforeMethod
//3.Calling preMethod from the BaseClass
public void preSetup() {
//3.Calling preMethod from the BaseClass	
preMethod();
AmazonURL();
myA=new MyAccountPOM();
}
@AfterMethod
public void closeBrowser() {
driver.quit();
}
/*
Test: 1

Steps to Automate:
1. Launch the Browser
2. Navigate to the Amazon home page
3. Click on button 'Sign In'
4. Login to the account with the provided credentials
5. Search for a product and click on Search Icon
6. Filter the product by price
7. Sort the page by Price: Low to High
8. Perform Pagination
*/

@Test(priority=1)
public void AmazonLogin() throws InterruptedException {
myA.clickSignIn();
myA.typeEmail("chrisjoe@email.com");
myA.clickContinue();
myA.typePsswd("chrisjoe@2022");
myA.clickSignInSubmit();
myA.searchProduct("google nest mini holder");
myA.clickSearchIcon();
myA.clickFilterBy50To100();
myA.SortyByLowToHigh();
myA.Pagination();

//Thread.sleep(3000);
//FirstCommit
}
}
