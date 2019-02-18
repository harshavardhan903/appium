package android_appium;

import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class U_tube 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter platform");
		String x=sc.nextLine();
		if(x.equalsIgnoreCase("computer"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\harsha\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://www.youtube.com/");
		}
		else
		{
			Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
			URL u=new URL("http://127.0.0.1:4723/wd/hub");
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			dc.setCapability("deviceName", "4f94f551");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion", "8.1.0");
			AndroidDriver harsha;
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
			harsha.get("http://youtube.com");
			harsha.context("NATIVE_APP");
			String d=harsha.getContext();
			System.out.println(d);
			TouchAction t=new TouchAction(harsha);
			t.tap(ElementOption.point(900, 290)).perform();
			harsha.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("f2 trailer");
			harsha.findElement(By.xpath("//*[@text='Search YouTube']")).click();
			Thread.sleep(3000);
			//harsha.findElement(By.xpath("//*[contains(@text,'F2 Trailer')]")).click();
			TouchAction t1=new TouchAction(harsha);
			t1.tap(ElementOption.point(650,640)).perform();
			Thread.sleep(5000);
			harsha.findElementByAndroidUIAutomator("new UiSelector().text(\"enter full screen\")").click();
			
						
		}
		

	}

}
