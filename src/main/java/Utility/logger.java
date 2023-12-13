package Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class logger {

	public  static Logger log;

	public static String path = "C:\\Users\\webca\\eclipse-workspace\\Laphotoparty\\properties\\log4j.properties";

	public static Logger getlogger() {

		try {
			FileInputStream file = new FileInputStream(new File(path));

			log = LogManager.getLogger(logger.class);

			PropertyConfigurator.configure(file);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return log;

	}

}
