package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configReader {

	public static Properties initializeProperties() {
		Properties prop = new Properties();
		File proFile = new File(System.getProperty("user.dir") + "\\src\\test\\resource\\config\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(proFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return prop;
	}

}
