import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class checkBoxes {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		
		
		
		
		WebElement penOption=driver.findElement(By.xpath("(//input[@value='Pen'])[2]"));
		
		
		Select s1= new Select(penOption);
		
		
		List<WebElement>box=driver.findElements(By.xpath("//input[@type='checkbox' and @ name='accessories']"));
		    
		
		int size=box.size();
		
		for (int i = 0; i <size; i++) {
			
			WebElement e1=box.get(i);
			
			
			
			String text=e1.getText();
			
			System.out.println(text);
			
			
			if (text.equals("Edit")) {
				
				
				e1.click();
				
				
				break;
				
			}
			
			//e1.click();
			
			
		}
		
		
		
		
		
	}
}
