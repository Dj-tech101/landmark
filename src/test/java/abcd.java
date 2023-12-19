import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class abcd {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		driver.get("http://omayo.blogspot.com/");

		// driver.findElement(By.linkText("http://www.Selenium143.blogspot.com"));

		WebElement dropDown = driver.findElement(By.id("multiselect1"));

		Select s1 = new Select(dropDown);

//               s1.selectByIndex(2);
//               
//               
//               
//              s1.selectByValue("def");
//               
//               
//               
//               s1.selectByVisibleText("doc 1");

		boolean condition = s1.isMultiple();

		// multi selected ====>True

		// false

		if (condition == true) {

			List<WebElement> box = s1.getOptions();

			int size = box.size();

			//System.out.println(size);
			
			for (int i = 0; i <size ; i++) {
				
				s1.selectByIndex(i);
				
				
			}
			
			//s1.deselectByIndex(3);
			
			s1.deselectByVisibleText("Swift");
			
			

		}

	}
}
