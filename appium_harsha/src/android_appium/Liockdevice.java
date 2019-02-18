package android_appium;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Liockdevice 
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
				System.out.println(ex.getMessage());
			}
		}
	KeyEvent k=new KeyEvent(AndroidKey.HOME);
		harsha.pressKey(k);
		harsha.openNotifications();
		harsha.lockDevice();
		Thread.sleep(5000);
		harsha.unlockDevice();
		TouchAction t1=new TouchAction(harsha);
		WaitOptions wo=new WaitOptions();
		wo.withDuration(Duration.ofMillis(500));
		t1.press(ElementOption.point(560,1740)).waitAction(wo).moveTo(ElementOption.point(560,300)).release().perform();
		Thread.sleep(5000);
		TouchAction t=new TouchAction(harsha);
		t.press(ElementOption.point(290, 1840)).moveTo(ElementOption.point(540, 1540)).
		moveTo(ElementOption.point(540,1830)).moveTo(ElementOption.point(840,1550)).moveTo(ElementOption.point(830,1830)).release().perform();

	}

}
