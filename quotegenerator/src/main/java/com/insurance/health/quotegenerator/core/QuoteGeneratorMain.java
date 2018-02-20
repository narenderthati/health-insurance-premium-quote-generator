package com.insurance.health.quotegenerator.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.insurance.health.quotegenerator.exceptions.QuoteGeneratorException;
import com.insurance.health.quotegenerator.pojos.Habits;
import com.insurance.health.quotegenerator.pojos.Person;
import com.insurance.health.quotegenerator.pojos.PreHealthConditions;

public class QuoteGeneratorMain {
	
	
	private static Logger log = Logger.getLogger( QuoteGeneratorMain.class.getName() );
	
	
	public static void main(String[] args){
		QuoteGenerator quoteGenerator = new QuoteGenerator();
		Person person = new Person("Norman Gomes","male",34);
		
		PreHealthConditions phc = new PreHealthConditions(false, false, false, true);
		
		Habits habits = new Habits(false, true, true, false);
		
		try{
			double quoteValue = quoteGenerator.getPremiumWithAgeBase(person);
			
			quoteValue = quoteGenerator.getPremiumWithGenderBase(person, quoteValue);
			
			quoteValue = quoteGenerator.getPremiumWithPreConditionsBase(phc, quoteValue);
			
			quoteValue = quoteGenerator.getPremiumWithHabitsBase(habits, quoteValue);
			
			quoteValue = quoteGenerator.getTotalPremium(quoteValue);
			
			System.out.println("Health Insurance Quote for "+person.getFullName()+" = "+quoteValue);
		
		}catch(QuoteGeneratorException qge){
			log.log(Level.SEVERE,"Exception thrown while calculating premium", qge);
			
			
			
		}
		
	}
	

}
