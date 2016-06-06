package yskj.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import yskj.bean.DataBaseConfigInfo;

public class PropertiesXmlFileUtil {

//	public static void main(String[] args) {
//		readXML("master_database.xml");
//
//	}

	public static void writeXML(String xmlName, DataBaseConfigInfo confing) {
		try {
			Properties properties = new Properties();
			properties.setProperty("url", confing.url);
			properties.setProperty("username", confing.username);
			properties.setProperty("password", confing.password);

			File file = new File(xmlName);
			FileOutputStream fileOut = new FileOutputStream(file);
			properties.storeToXML(fileOut, confing.comment);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取xml 信息
	 */
	public static DataBaseConfigInfo readXML(String xmlName) {
		DataBaseConfigInfo configInfo = null;
		try {
			File file = new File(xmlName);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.loadFromXML(fileInput);
			fileInput.close();

			Enumeration enuKeys = properties.keys();
			configInfo = new DataBaseConfigInfo();
			while (enuKeys.hasMoreElements()) {

				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				System.out.println(key + ": " + value);

				if (key.equals("comment")) {
					configInfo.comment = value;
				} else if (key.equals("url")) {
					configInfo.url = value;
				} else if (key.equals("username")) {
					configInfo.username = value;
				} else if (key.equals("password")) {
					configInfo.password = value;
				}else if (key.equals("first")) {
					configInfo.first = key;
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return configInfo;
	}

}
