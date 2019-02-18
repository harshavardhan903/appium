package android_appium;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;

public class Navigete 
{
	public static void main(String[] args) throws Exception
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		 //provide details of app & device
		 DesiredCapabilities dc=new DesiredCapabilities();
		 dc.setCapability(CapabilityType.BROWSER_NAME,"");
		 dc.setCapability("deviceName","emulator-5554");
		 dc.setCapability("platformName","android");
		 dc.setCapability("platformVersion","4.2.2");
		 dc.setCapability("appPackage","com.android.contacts");
		 dc.setCapability("appActivity","com.android.contacts.activities.DialtactsActivity");
		 //create driver object to launch app in avd
		 AndroidDriver driver;
		 while(true) 
		 {
			 try 
			 {
				 driver=new AndroidDriver(u,dc);
				 break;
			 }
			 catch(Exception ex)
			 {
				 
			 }
		 }
		Activity a=new Activity("com.android.speechrecorder", "com.android.speechrecorder.SpeechRecorderActivity");
		 driver.startActivity(a);
		driver.activateApp("com.android.music");
		 ApplicationState as=driver.queryAppState("com.android.speechrecorder");
		 System.out.println(as.toString());
		 driver.terminateApp("com.android.music");
		 driver.terminateApp("com.android.speechrecorder");
		

	}

}
