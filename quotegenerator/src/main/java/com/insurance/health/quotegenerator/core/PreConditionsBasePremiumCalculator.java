package com.insurance.health.quotegenerator.core;

import com.insurance.health.quotegenerator.pojos.PreHealthConditions;
import com.insurance.health.quotegenerator.util.AppProperties;

public class PreConditionsBasePremiumCalculator {

	private AppProperties props = new AppProperties();
	
	private int PRE_COND_PREMIUM_INCREASE = Integer.parseInt(props.getProperty("PRE_COND_PREMIUM_INCREASE"));
	
	public int countPreConditions(PreHealthConditions phc){
		int count = 0;
		
		if(phc.isBloodPressure()){
			count = count +1;
		}
		
		if(phc.isBloodSugar()){
			count = count +1;
		}
		
		if(phc.isHypertension()){
			count = count +1;
		}
		
		if(phc.isOverWeight()){
			count = count +1;
		}
		
		return count;
	}
	
	public double premiumWithPreConditions(PreHealthConditions phc, double quoteValue){
		
		if (countPreConditions(phc) >0){
			return Math.round((quoteValue + (quoteValue*countPreConditions(phc)*PRE_COND_PREMIUM_INCREASE)/100)*100.0)/100.0;
		}else{
			return quoteValue;
		}
	}
	
}
