package com.insurance.health.quotegenerator.core;

import com.insurance.health.quotegenerator.exceptions.QuoteGeneratorException;
import com.insurance.health.quotegenerator.pojos.Habits;
import com.insurance.health.quotegenerator.pojos.Person;
import com.insurance.health.quotegenerator.pojos.PreHealthConditions;

public class QuoteGenerator {
	
	public AgeBasePremiumCalculator abpCalculator = new AgeBasePremiumCalculator();
	
	public GenderBasePremiumCalculator gbpCalculator = new GenderBasePremiumCalculator();
	
	public HabitsBasePremiumCaluculator hbpCalculator = new HabitsBasePremiumCaluculator();
	
	public PreConditionsBasePremiumCalculator pcbpCalculator = new PreConditionsBasePremiumCalculator();
	
	private double quoteValue ;
	
	/**
	 * Step 1 - Find the Premium based on Age
	 * @param person
	 * @return double
	 * @throws QuoteGeneratorException
	 */
	public double getPremiumWithAgeBase(Person person) throws QuoteGeneratorException{
		switch(abpCalculator.getAgeGroup(person.getAge())){
			case "baseage" : return quoteValue = abpCalculator.basePremium();
			
			case "agegroup1" : return quoteValue = abpCalculator.ageGroup1Premium();
			
			case "agegroup2" : return quoteValue = abpCalculator.ageGroup2Premium();
			
			case "agegroup3" : return quoteValue = abpCalculator.ageGroup3Premium();
			
			case "agegroup4" : return quoteValue = abpCalculator.ageGroup4Premium();
			
			case "agegroup5" : return quoteValue = abpCalculator.ageGroup5Premium();
			
		}
		return quoteValue;
	}

	
	/**
	 * Step 2 - Find the Premium Increase based on Gender
	 * @param person
	 * @param quoteValue
	 * @return
	 * @throws QuoteGeneratorException
	 */
	public double getPremiumWithGenderBase(Person person, double quoteValue) throws QuoteGeneratorException{
		return gbpCalculator.premiumWithGenderBase(person, quoteValue);
	}
	
	
	/**
	 * Step 3 - Find the premium Increase based on Pre Existing Health condition
	 * @param phc
	 * @param quoteValue
	 * @return
	 */
	public double getPremiumWithPreConditionsBase(PreHealthConditions phc, double quoteValue){
		return pcbpCalculator.premiumWithPreConditions(phc, quoteValue);
	}
	
	
	/**
	 * Step 4 - Find the Premium Increase based on Good and Bad Habits
	 * @param habits
	 * @param quoteValue
	 * @return
	 * @throws QuoteGeneratorException
	 */
	public double getPremiumWithHabitsBase(Habits habits, double quoteValue) throws QuoteGeneratorException{
		return hbpCalculator.premiumWithHabits(habits, quoteValue);
	}
	
	
	public double getTotalPremium(double quoteValue){
		return Math.ceil(quoteValue);
	}
}
