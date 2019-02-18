package android_appium;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.file.DataTransferItemList;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class Vodqa {

	public static void main(String[] args) throws Exception
	{
		//start appium
				Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
				URL u=new URL("http://127.0.0.1:4723/wd/hub");
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setCapability(CapabilityType.BROWSER_NAME, "");
				dc.setCapability("deviceName", "4f94f551");
				dc.setCapability("platformName", "android");
				dc.setCapability("platformVersion", "8.1.0");
				dc.setCapability("appPackage", "com.vodqareactnative");
				dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
				// 
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
			//automation 
			try
			{
				WebDriverWait wait=new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='LOG IN']")));
				driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				TouchAction ta=new TouchAction(driver);
				//
				while(true)
				{
					try
					{
						driver.findElement(By.xpath("//*[@text='Wheel Picker']")).click();
						break;
					}
					catch(Exception ex)
					{
						ta.press(ElementOption.point(400, 1900)).moveTo(ElementOption.point(400, 790)).release().perform();
					}
				}
				driver.findElement(By.xpath("//*[@class='android.widget.Spinner']")).click();
				
				List<WebElement> l=driver.findElements(By.xpath("//*[@resource-id='android:id/text1']"));
				System.out.println(l.size());
				for(int i=0;i<l.size();i++)
				{
					l.get(4).click();
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			


	}

}
