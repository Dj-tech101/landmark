package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyFile {

	public Properties pro;

	public String path=System.getProperty("user.dir")+"\\propertiesDetails.properties";
	

	public propertyFile() throws IOException {

		pro = new Properties();

		File f1 = new File(path);

		FileInputStream file = new FileInputStream(f1);

		pro.load(file);

	}

	public String getusername() {

		return pro.getProperty("username");

	}

	public String getpassword() {

		return pro.getProperty("password");

	}
	
	public String getUrl() {

		return pro.getProperty("url");

	}
	
}
