package android_appium;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Call 
{
	public static void main(String[]args) throws Exception
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
		WebDriverWait w=new WebDriverWait(harsha, 500);
		for(int i=0;i<x.length();i++)
		{
			char d=x.charAt(i);
			String w1="";
			switch(d)
			{
				case '0':
				w1="zero";
				break;
				case '1':
					w1="one";
					break;
				case '2':
					w1="two";
					break;
				case '3':
				    w1="three";
				    break;
				case '4':
					w1="four";
					break;
				case '5':
					w1="five";
					break;
				case '6':
					w1="six";
					break;
				case '7':
					w1="seven";
					break;
				case '8':
					w1="eight";
					break;
				case '9':
					w1="nine";
					break;
			}
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='"+w1+"']")));
			harsha.findElement(By.xpath("//*[@content-desc='"+w1+"']")).click();
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Delete phone number']")));
		harsha.findElement(By.xpath("//*[@content-desc='Dial using SIM1']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='01:10']")));
		harsha.findElement(By.xpath("//*[@content-desc='End']")).click();
	}
	catch(Exception ex)
	{
		
	}
}

}
