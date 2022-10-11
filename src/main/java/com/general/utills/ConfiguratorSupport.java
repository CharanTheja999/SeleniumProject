package com.general.utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfiguratorSupport 
{
	private static String info=System.getProperty("user.dir");
	private static String propFilePath = info+"\\ConfigProperties\\global.properties";
	private static Properties props;
	
	/**
	 * Function to load framework configuration file
	 * @return
	 * @throws IOException 
	 */
	public static Properties loadPropertiesFile() throws IOException
	{
		File propFile = new File(propFilePath);
		FileInputStream fileInput = null;
		
		try{
			fileInput = new FileInputStream(propFile);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		Properties paramPropFile = new Properties();
		//load properties file
		try
		{
			paramPropFile.load(fileInput);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		fileInput.close();
		return paramPropFile;
	}
	
	public static String getProperty(String strKey)
	{
		String value = null;
		
		try {
			value = loadPropertiesFile().getProperty(strKey);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
