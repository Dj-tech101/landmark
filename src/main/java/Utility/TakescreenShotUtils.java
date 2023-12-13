package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakescreenShotUtils {

	public static String path = "C:\\Users\\webca\\eclipse-workspace\\Laphotoparty\\ScreenShot\\";

	public static void GetScreenShot(WebDriver driver) throws IOException {

		Date date = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yy");
		String dateFormate = formatter.format(date);

		String pathdesti=path+"ScreenShot"+dateFormate+".png";
		
		TakesScreenshot tc=(TakesScreenshot)driver;
		
		File source =tc.getScreenshotAs(OutputType.FILE);
		
		File destination=new File(pathdesti);
		
		FileHandler.copy(source, destination);
		
	}
}
