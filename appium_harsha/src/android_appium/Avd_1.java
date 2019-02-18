package android_appium;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Avd_1 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter mbno no");
		String x=sc.nextLine();
		System.out.println("enter msg");
		String y=sc.nextLine();
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "4.2.2");
		dc.setCapability("appPackage", "com.android.mms");
		dc.setCapability("appActivity", "com.android.mms.ui.ConversationList");
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
		WebDriverWait w=new WebDriverWait(harsha, 50);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='New message']")));
		harsha.findElement(By.xpath("//*[@content-desc='New message']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='To']")));
		harsha.findElement(By.xpath("//*[@text='To']")).sendKeys(x);
		harsha.findElement(By.xpath("//*[@text='Type message']")).sendKeys(y);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@focusable='true']")));
		harsha.findElement(By.xpath("//*[@content-desc='Send']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@NAF='true']")));
		Thread.sleep(2000);
		KeyEvent k=new KeyEvent(AndroidKey.HOME);
		harsha.pressKey(k);
		harsha.lockDevice();
		harsha.unlockDevice();
		//harsha.closeApp();

	}
}