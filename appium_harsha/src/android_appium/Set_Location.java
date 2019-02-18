package android_appium;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.html5.Location;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Set_Location
{
	public static void main(String[] args) throws Exception
	{
		Location l=new Location(15.299326,74.123993,1000);
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "4f94f551");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		//dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		dc.setCapability("appPackage", "com.mxtech.videoplayer.ad");
		dc.setCapability("appActivity", "com.mxtech.videoplayer.ad.OnlineActivityMediaList");
		dc.setCapability("locationServicesEnabled", "true");
		dc.setCapability("locationServicesAuthorized","true");
		dc.setCapability(MobileCapabilityType.FULL_RESET, "false");
		dc.setCapability(MobileCapabilityType.NO_RESET, "true");
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
		
		harsha.activateApp("com.google.android.apps.maps");
		
		Thread.sleep(2000);
		harsha.setLocation(l);
		Thread.sleep(5000);

	}

}
