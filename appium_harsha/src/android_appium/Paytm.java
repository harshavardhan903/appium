package android_appium;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Paytm {

	public static void main(String[] args) throws Exception
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "4f94f551");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("appPackage", "net.one97.paytm");
		dc.setCapability("appActivity", "net.one97.paytm.landingpage.activity.AJRMainActivity");
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

	}

}
