package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class readConfigureProperties {
	public static Object getConfigurationProperties(String key) throws IOException {

		FileReader reader = new FileReader(
				System.getProperty("user.dir") + "/src/main/java/configure/configure.Properties");
		Properties property = new Properties();
		property.load(reader);
		return property.getProperty(key);
}
}