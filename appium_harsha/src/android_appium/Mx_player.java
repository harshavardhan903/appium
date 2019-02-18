package android_appium;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Mx_player 
{
	public static void main(String[] args) throws Exception
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "4f94f551");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		dc.setCapability(MobileCapabilityType.NO_RESET, "true");
		dc.setCapability("appPackage", "com.mxtech.videoplayer.ad");
		dc.setCapability("appActivity", "com.mxtech.videoplayer.ad.OnlineActivityMediaList");
		AndroidDriver harsha;
		while(true)
		{
			try
			{
				harsha=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception ex)
			{
				
			}
		}
		try
		{
		WebDriverWait w=new WebDriverWait(harsha, 50);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Local']")));
		harsha.findElement(By.xpath("//*[@text='Local']")).click();
		String x=harsha.getCurrentPackage();
		System.out.println(x);
		String y=harsha.currentActivity();
		System.out.println(y);
		String z=harsha.getPageSource();
		harsha.findElement(By.xpath("//*[@resource-id='com.mxtech.videoplayer.ad:id/play_last']")).click();
		if(harsha.findElement(By.xpath("//*[@text='RESUME']")).isDisplayed())
		{
			harsha.findElement(By.xpath("//*[@text='RESUME']")).click();
		}
		else
		{
			KeyEvent k=new KeyEvent(AndroidKey.MEDIA_PLAY);
			harsha.pressKey(k);
		}
		Thread.sleep(10000);
		KeyEvent k1=new KeyEvent(AndroidKey.MEDIA_NEXT);
		harsha.pressKey(k1);
		Thread.sleep(5000);
		if(harsha.findElement(By.xpath("//*[@text='RESUME']")).isDisplayed())
		{
			harsha.findElement(By.xpath("//*[@text='RESUME']")).click();
		}
		else
		{
			KeyEvent k2=new KeyEvent(AndroidKey.MEDIA_PLAY);
			harsha.pressKey(k2);
		}
		Thread.sleep(5000);
		KeyEvent k3=new KeyEvent(AndroidKey.VOLUME_UP);
		harsha.pressKey(k3);
		Thread.sleep(5000);
		KeyEvent k4=new KeyEvent(AndroidKey.MEDIA_STEP_FORWARD);
		harsha.pressKey(k4);
		Thread.sleep(5000);
		KeyEvent k5=new KeyEvent(AndroidKey.MUSIC);
		harsha.pressKey(k5);
		Thread.sleep(5000);
		KeyEvent k6=new KeyEvent(AndroidKey.MEDIA_PLAY);
		harsha.pressKey(k6);
		Thread.sleep(10000);
		KeyEvent k7=new KeyEvent(AndroidKey.CALCULATOR);
		harsha.pressKey(k7);
		Thread.sleep(10000);
		//KeyEvent k8=new KeyEvent(AndroidKey.NOTIFICATION);
		harsha.openNotifications();
		
		}
		catch(Exception ex)
		{
			
		}
		harsha.closeApp();

	}

}
