package android_appium;

import java.awt.Color;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Colorrec {

	public static void main(String[] args) throws Exception
	{
		//get data from keyboard
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter expected colour name");
				String ecn=sc.nextLine();
				ecn=ecn.toLowerCase();
				Color ec=null;
				switch(ecn)
				{
				case "red":
					ec=Color.RED;
					break;
				case "green":
					ec=new Color(0,128,0);
					break;
				case "blue":
					ec=Color.BLUE;
					break;
				case "black":
					ec=Color.BLACK;
					break;
				default:
				    System.out.println("wrong color");	
				    System.exit(0);
				}
				//start appium server
				Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
				URL u=new URL("http://127.0.0.1:4723/wd/hub");
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setCapability(CapabilityType.BROWSER_NAME, "");
				dc.setCapability("deviceName", "4f94f551");
				dc.setCapability("platformName", "android");
				dc.setCapability("platformVersion", "8.1.0");
				dc.setCapability("appPackage", "com.vodqareactnative");
				dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
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
				WebDriverWait w=new WebDriverWait(harsha,20);
				w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='LOG IN']")));
				harsha.findElement(By.xpath("//*[@text='LOG IN']")).click();
				TouchAction t=new TouchAction(harsha);
				WaitOptions wo=new WaitOptions();
				wo.withDuration(Duration.ofSeconds(5));
				while(2>1)
				{
					try
					{
						harsha.findElement(By.xpath("//*[@text='Wheel Picker']")).click();
						break;
					}
					catch(Exception ex)
					{
						t.press(ElementOption.point(500,1700)).waitAction(wo).moveTo(ElementOption.point(500,600)).release().perform();
					}
				}
				

				
	}

}
