package com.insurance.health.quotegenerator.core;

import com.insurance.health.quotegenerator.exceptions.QuoteGeneratorException;
import com.insurance.health.quotegenerator.util.AppProperties;

public class AgeBasePremiumCalculator {
	
	private AppProperties props = new AppProperties();
	
	private int BASE_QUOTE_VALUE = Integer.parseInt(props.getProperty("INSURANCE_BASE_PRIMIUM"));
	
	private int AGE_GROUP1_PERMIUM_INCREASE = Integer.parseInt(props.getProperty("AGE_GROUP1_PERMIUM_INCREASE"));
	
	private int AGE_GROUP2_PERMIUM_INCREASE = Integer.parseInt(props.getProperty("AGE_GROUP2_PERMIUM_INCREASE"));
	
	private int AGE_GROUP3_PERMIUM_INCREASE = Integer.parseInt(props.getProperty("AGE_GROUP3_PERMIUM_INCREASE"));
	
	private int AGE_GROUP4_PERMIUM_INCREASE = Integer.parseInt(props.getProperty("AGE_GROUP4_PERMIUM_INCREASE"));
	
	private int AGE_GROUP5_PERMIUM_INCREASE = Integer.parseInt(props.getProperty("AGE_GROUP5_PERMIUM_INCREASE"));
	
	public String getAgeGroup(int age) throws QuoteGeneratorException{
		if(age >=0 && age <18){
			return "baseage";
		}else if (age >=18 && age <25){
			return "agegroup1";
		}else if (age >=25 && age <30){
			return "agegroup2";
		}else if (age>=30 && age < 35){
			return "agegroup3";
		}else if (age >=35 && age <40){
			return "agegroup4";
		}else if(age >=40 && age <150){
			return "agegroup5";
		}else{
			throw new QuoteGeneratorException("Invalid customer age Input detected");
		}
	}
	
	
	public double basePremium(){
		return (double)BASE_QUOTE_VALUE;
	}
	
	public double ageGroup1Premium(){
		return basePremium() + (basePremium()*AGE_GROUP1_PERMIUM_INCREASE)/100;
	}
	
	public double ageGroup2Premium(){
		return ageGroup1Premium() + (ageGroup1Premium()*AGE_GROUP2_PERMIUM_INCREASE)/100;
	}
	
	public double ageGroup3Premium(){
		return ageGroup2Premium() + (ageGroup2Premium()*AGE_GROUP3_PERMIUM_INCREASE)/100;
	}
	
	public double ageGroup4Premium(){
		return ageGroup4Premium() + (ageGroup4Premium()*AGE_GROUP4_PERMIUM_INCREASE)/100;
	}
	
	public double ageGroup5Premium(){
		return ageGroup4Premium() + (ageGroup4Premium()*AGE_GROUP5_PERMIUM_INCREASE)/100;
	}
}
