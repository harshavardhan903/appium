package android_appium;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Testng_paytm 
{
	public URL u;
	public AndroidDriver harsha;
	public WebDriverWait w;
	public DesiredCapabilities dc;
		@BeforeSuite
		public void launch_cmd() throws Exception
		{
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		u=new URL("http://127.0.0.1:4723/wd/hub");
		}
		@BeforeMethod
		public void launch()
		{
		dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "4f94f551");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability(MobileCapabilityType.NO_RESET, "true");
		dc.setCapability("appPackage", "net.one97.paytm");
		dc.setCapability("appActivity", "net.one97.paytm.landingpage.activity.AJRMainActivity");
		
		while(true)
		{
			
			try
			{
				harsha=new AndroidDriver(u, dc);
				break;
			}
			catch(Exception ex)
			{
				
			}
		}
		}
		@Test
		@Parameters({"mbno","mbnoc","pwd","pwdc"})
		public void login(String m,String mc,String p,String pc)
		{
		harsha.findElement(By.xpath("//*[@content-desc='Open navigation drawer']")).click();
		w=new WebDriverWait(harsha, 50);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Login']")));
		harsha.findElement(By.xpath("//*[@text='Login']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@resource-id='net.one97.paytm:id/edit_username']")));
		harsha.findElement(By.xpath("//android.widget.EditText[@resource-id='net.one97.paytm:id/edit_username']")).sendKeys(m);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@resource-id='net.one97.paytm:id/edit_password']")));
		harsha.findElement(By.xpath("//android.widget.EditText[@resource-id='net.one97.paytm:id/edit_password']")).sendKeys(p);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Login Securely']")));
		harsha.findElement(By.xpath("//*[@text='Login Securely']")).click();
		}
		
}





































