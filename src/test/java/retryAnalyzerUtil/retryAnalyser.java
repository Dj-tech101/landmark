package retryAnalyzerUtil;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.*;
import org.testng.ITestResult;


public class retryAnalyser implements IRetryAnalyzer {
	
	private int maxCount = 3;

	private int startCount = 0;

	public boolean retry(ITestResult result) {

		if (startCount < maxCount) {

			startCount++;
			return true;

		}
		return false;
	}

}
