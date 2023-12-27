package Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakescreenShotUtils {

	protected static String path="C:\\Users\\webca\\eclipse-workspace\\Laphotoparty\\screen\\";
		//	System.getProperty("user.dir")+"\\ScreenShotlist\\ShotScreen";
	
	

	public static void GetScreenShot(WebDriver driver,String name) throws IOException {

		
		try {
			
			Date date = new Date();

			SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
			String dateFormate = formatter.format(date);

			String pathdesti=path+name+".png";
			
			TakesScreenshot tc=(TakesScreenshot)driver;
			
			File source =tc.getScreenshotAs(OutputType.FILE);
			
			File destination=new File(pathdesti);
			
			FileHandler.copy(source, destination);
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
}
