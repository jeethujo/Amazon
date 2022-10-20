package testLayerPackage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import basePackage.BaseClass;
import pomPackage.AmazonPOM;
import utilityPackage.ListenersClass;
@Listeners(ListenersClass.class)
public class AmazonCreateAccountTest extends BaseClass{
/*4.To call methods in the test cases, create object 
	and declare it globally*/
AmazonPOM am;
SoftAssert Assert=new SoftAssert();
//1. create constructor of the RegisterTest class
public AmazonCreateAccountTest() {
//2.Read all properties of the BaseClass(to call the constructor of parent class)
super();
}

@BeforeMethod
//3.Calling preMethod from the BaseClass
public void preSetup() {
//3.Calling preMethod from the BaseClass	
preMethod();
AmazonURL();
am=new AmazonPOM();
}
@AfterMethod
public void closeBrowser() {
//driver.quit();
}

/*
Assignment: 1

Steps to Automate:
1. Launch the Browser
2. Navigate to the Amazon home page
3. Click on button 'Sign In'
4. Click on Create Yours Amazon Account
5. Enter the new user details
6. Click on button 'Verify email'
7. Provide sufficient hard wait time in order to enter the OTP
8. Once timeout is over, click on button 'Create Amazon Account'

*/

@Test(priority=1)
public void AmazonAccountCreation() throws InterruptedException {
am.clickSignIn();
am.clickCreateAmazonAccount();
am.typeFname("Alyssa Brandt");
am.typeEmail("AlyssaBrandt@mail.com");
am.typePsswd("AlyssaBrandt@2022");
am.typeCnfrmPswd("AlyssaBrandt@2022");
am.clickVerifyEmail();
Thread.sleep(35000);
am.clickCreateAmazonAccountButton();
Thread.sleep(3000);
}
}
