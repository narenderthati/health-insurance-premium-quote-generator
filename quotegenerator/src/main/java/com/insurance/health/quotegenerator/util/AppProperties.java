package com.insurance.health.quotegenerator.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.insurance.health.quotegenerator.exceptions.QuoteGeneratorConfigException;

public class AppProperties {
	
	private static final String PROP_FILE_LOCATION = "appconfig.properties";
	
	private Logger log = Logger.getLogger( AppProperties.class.getName() );
	
	private Properties props = new Properties();;
	
	public AppProperties(){
		load();
	}
	
	private void load (){
		try(InputStream inputFile =  getClass().getClassLoader().getResourceAsStream(PROP_FILE_LOCATION)){
			props.load(inputFile);
		}catch(IOException e){
			log.log(Level.SEVERE, "Unable to read the Properties file ", e);
		}
	}
	
	public String getProperty(String property) {
		String propValue = null;
		
		try{
			return propValue=props.getProperty(property);
		}catch(NullPointerException ex){
			try {
				throw new QuoteGeneratorConfigException(property +" Property not found in properties file");
			} catch (QuoteGeneratorConfigException e) {
				
				log.log(Level.SEVERE, "Exception occured while reading properties from properties file ", e);
			}
		}
		return propValue;
	}
	
	
}
