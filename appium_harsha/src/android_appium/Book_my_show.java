package android_appium;

import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Book_my_show 
{
	public static void main(String[] args) throws Exception
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "4f94f551");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		
		dc.setCapability("appPackage", "com.mxtech.videoplayer.ad");
		dc.setCapability("appActivity", "com.mxtech.videoplayer.ad.OnlineActivityMediaList");
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
		KeyEvent k=new KeyEvent(AndroidKey.HOME);
		harsha.pressKey(k);
		Thread.sleep(2000);
		harsha.activateApp("com.bt.bms");
		WebDriverWait w=new WebDriverWait(harsha, 100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='All']")));
		harsha.findElement(By.xpath("//*[@text='View All']")).click();
		TouchAction t=new TouchAction(harsha);
		WaitOptions wo=new WaitOptions();
		wo.withDuration(Duration.ofMillis(5000));
		while(true)
		{
			try
			{
				if(harsha.findElement(By.xpath("//*[@text='Hushaaru']")).isDisplayed())
				{
					break;
				}
			}
			catch(Exception ex)
			{
				t.press(ElementOption.point(530, 1680)).waitAction(wo).moveTo(ElementOption.point(530, 350)).release().perform();
			}
		}
		harsha.findElement(By.xpath("//*[@text='Hushaaru']")).click();


	}

}
