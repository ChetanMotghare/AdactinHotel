package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtil {
	
	public static String getValueForKey(String Key) throws Throwable
	{
		
		Properties confi = new Properties();
		confi.load(new FileInputStream("D:\\OJTSelenium\\Adactin\\PropertyFile\\Envirnment.properties"));
		return confi.getProperty(Key);
		
	}

}
