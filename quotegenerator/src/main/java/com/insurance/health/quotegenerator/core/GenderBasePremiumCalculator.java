package com.insurance.health.quotegenerator.core;

import com.insurance.health.quotegenerator.exceptions.QuoteGeneratorException;
import com.insurance.health.quotegenerator.pojos.Person;
import com.insurance.health.quotegenerator.util.AppProperties;

public class GenderBasePremiumCalculator {
	
	AppProperties props = new AppProperties();
	
	private int MALE_PREMIUM_INCREASE = Integer.parseInt(props.getProperty("GENDER_MALE_PREMIUM_INCREASE"));
	
	private int FEMAIL_PREMIUM_INCREASE = Integer.parseInt(props.getProperty("GENDER_FEMALE_PREMIUM_INCREASE"));
	
	private int OTHERS_PREMIUM_INCREASE = Integer.parseInt(props.getProperty("GENDER_OTHER_PREMIUM_INCREASE"));
	
	
	public int getPremiumIncreaseWithGender(Person person) throws QuoteGeneratorException{
		int premium = 0;
		
		if(person.getGender().equalsIgnoreCase("male")){
			premium = MALE_PREMIUM_INCREASE;
		}else if (person.getGender().equalsIgnoreCase("female")){
			premium = FEMAIL_PREMIUM_INCREASE;
		}else if(person.getGender().equalsIgnoreCase("others")){
			premium = OTHERS_PREMIUM_INCREASE;
		}else{
			throw new QuoteGeneratorException("Unknow Gender Type detected");
		}
		
		return premium;
	}

	public double premiumWithGenderBase(Person person,double quoteValue) throws QuoteGeneratorException{
		if (getPremiumIncreaseWithGender(person)>0){
			return quoteValue + (quoteValue * getPremiumIncreaseWithGender(person))/100;
		}else{
			return quoteValue;
		}
	}
	
}
