package android_appium;

import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class Whatsapp_chat 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name");
		String x=sc.nextLine();
		System.out.println("enter msg");
		String m=sc.nextLine();
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "4f94f551");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("appPackage", "com.whatsapp");
		dc.setCapability("appActivity", "com.whatsapp.HomeActivity");
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
		WebDriverWait w=new WebDriverWait(harsha, 20);
		try
		{
		
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc='Search']")));
			harsha.findElement(By.xpath("//android.widget.TextView[@content-desc='Search']")).click();
			Thread.sleep(1000);
			harsha.findElement(By.xpath("//*[@text='Search…']")).sendKeys(x);
			String e=harsha.findElement(By.xpath("(//*[@class='android.widget.TextView'])[2]")).getAttribute("text");
			System.out.println(e);
			if(e.equalsIgnoreCase(x))
			{
				harsha.findElement(By.xpath("//android.widget.TextView[@text='"+e+"']")).click();
			}
			else
			{
				System.out.println("not matched");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Type a message']")));
		harsha.findElement(By.xpath("//android.widget.EditText[@text='Type a message']")).sendKeys(m);	
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Attach']")));
		harsha.findElement(By.xpath("//*[@content-desc='Attach']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Gallery']")));
		harsha.findElement(By.xpath("//*[@content-desc='Gallery']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='All media']")));
		harsha.findElement(By.xpath("//android.widget.TextView[@text='All media']")).click();
		List<MobileElement> l=harsha.findElements(By.xpath("//*[@content-desc='Photo']"));
		int e=l.size();
		System.out.println(e);
		for(int i=0;i<l.size();i++)
		{
			l.get(5).click();
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc='Send']")));
		harsha.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Send']")).click();
		harsha.pressKeyCode(AndroidKeyCode.BACK);
		harsha.findElement(By.xpath("//*[@content-desc='Navigate up']")).click();
	}
}
