package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigFileReader {
	
	
	
	
	private String propertiesFile;
	private Properties prop;
	private OutputStream output;
	private InputStream input;

	
	
	
	
	
	//Constructor
	public ConfigFileReader(String propertiesFilePath) {
		propertiesFile = propertiesFilePath;
		prop = new Properties();
	}
	
	
	
	
	
	
	
	//Read file property
	public String readProperty(String key) {
		String value = null;
		try {
			input = new FileInputStream(propertiesFile);
			prop.load(input);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	
	
	
	
	
	
	//Write file property
	public void setProperty(String key, String value)
	{
		try
		{
			output = new FileOutputStream(propertiesFile);
			prop.setProperty(key, value);
			prop.store(output, null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
//public static void main(String[] args) {
//		JavaPropertiesManager propManager = new JavaPropertiesManager("config.properties");
//		propManager.setProperty("browserType", "Chrome");
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
