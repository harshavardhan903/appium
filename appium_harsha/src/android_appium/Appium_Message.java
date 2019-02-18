package android_appium;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Alignment;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Appium_Message {

	public static void main(String[] args) throws Exception{
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "5200e639b4b484c9");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("appPackage", "com.samsung.android.messaging");
		dc.setCapability("appActivity", "com.android.mms.ui.ConversationComposer");
		//dc.setCapability("noReset", "true");
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
		File f=new File("F:\\Book2.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0);
		int nour=rsh.getRows();
		int nouc=rsh.getColumns();
		//for names of columns
		WritableFont wf=new WritableFont(WritableFont.TIMES,12,WritableFont.BOLD);
		wf.setColour(Colour.RED);
		wf.setItalic(true);
		WritableCellFormat cf=new WritableCellFormat(wf);
		cf.setAlignment(Alignment.JUSTIFY);
		//for test passed
		WritableFont wpf=new WritableFont(WritableFont.TIMES,12,WritableFont.NO_BOLD);
		wpf.setColour(Colour.GREEN);
		wpf.setItalic(true);
		WritableCellFormat cpf=new WritableCellFormat(wpf);
		cpf.setAlignment(Alignment.CENTRE);
		Date d1=new Date();
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String cname=df.format(d1);
		Label l=new Label(nouc, 0, cname, cf);
		wsh.addCell(l);
		WebDriverWait w=new WebDriverWait(harsha, 200);
		for(int i=1;i<nour;i++)
		{
			String number=rsh.getCell(0,i).getContents();
			String msg=rsh.getCell(1,i).getContents();

		WebDriverWait w1=new WebDriverWait(harsha,20);
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Recipient']")));
		harsha.findElement(By.xpath("//*[@text='Recipient']")).sendKeys(number);
		/*String x=harsha.findElement(By.xpath("//*[@class='android.widget.ListView']")).getTagName();
		System.out.println(x)*/;
		w1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@text='Enter message']")));
		harsha.findElement(By.xpath("//*[@text='Enter message']")).sendKeys(msg);
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Send sim 2']")));
		harsha.findElement(By.xpath("//*[@content-desc='Send sim 2']")).click();
		}
		
		
		

	}

}
