package com.demo.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("./src/test/resources/config/cofig.properties");
			prop.load(file);
			
		
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}
	
	
}
