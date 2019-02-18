package android_appium;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Call_search
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter msg");
		String x=sc.nextLine();
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "4f94f551");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("appPackage", "com.android.contacts");
		dc.setCapability("appActivity", "com.android.contacts.activities.TwelveKeyDialer");
		dc.setCapability("noReset", "true");
		AndroidDriver harsha;
		WebDriverWait wait;
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
		try
		{
			wait=new WebDriverWait(harsha,50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Contacts']")));
			harsha.findElement(By.xpath("//*[@text='Contacts']")).click();
			harsha.findElement(By.xpath("//*[@content-desc='Search']")).click();
			harsha.findElement(By.xpath("//miui.widget.ClearableEditText[@resource-id='android:id/input']")).sendKeys(x);
			String temp=harsha.findElement(By.xpath("(//*[@class='android.widget.TextView'])[2]")).getAttribute("text");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+x+"']")));
			harsha.findElement(By.xpath("//android.widget.TextView[@text='"+x+"']")).click();
		
			
			
			
		}
		catch(Exception ex)
		{
			
		}

	}

}
