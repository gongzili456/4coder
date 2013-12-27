package cn.gongzili.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

	public static final String UPLOADIMAGE_SAVEPATH = "uploadImageUrl";

	public static String getValue(String field) {
		return getValue("main.properties", field);
	}

	public static String getValue(String file, String field) {
		String value = null;
		Properties properties = new Properties();
		try {
			properties.load(PropertyUtils.class.getClassLoader()
					.getResourceAsStream(file));
			value = properties.getProperty(field);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

}
