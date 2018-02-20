package com.insurance.health.quotegenerator.core.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.insurance.health.quotegenerator.core.QuoteGenerator;
import com.insurance.health.quotegenerator.exceptions.QuoteGeneratorException;
import com.insurance.health.quotegenerator.pojos.Habits;
import com.insurance.health.quotegenerator.pojos.Person;
import com.insurance.health.quotegenerator.pojos.PreHealthConditions;

public class QuoteGeneratorTest {
	
	QuoteGenerator quoteGenerator = new QuoteGenerator();
	
	@Test
	public void getPremiumWithAgeBaseTest() throws QuoteGeneratorException{
		
		Person person = new Person("Norman Gomes","male",34);
		assertEquals(6655,quoteGenerator.getPremiumWithAgeBase(person),0);
	}

	@Test
	public void getPremiumWithGenderBaseTest() throws QuoteGeneratorException{
		Person person = new Person("Norman Gomes","male",34);
		assertEquals(6788.1,quoteGenerator.getPremiumWithGenderBase(person,6655),0);
		
	}
	
	@Test
	public void getPremiumWithPreConditionsBaseTest() throws QuoteGeneratorException{
		PreHealthConditions phc = new PreHealthConditions(false, false, false, true);
		assertEquals(6855.98,quoteGenerator.getPremiumWithPreConditionsBase(phc,6788.1),0);
	}
	
	@Test
	public void getPremiumWithHabitsBaseTest() throws QuoteGeneratorException{
		Habits habits = new Habits(false, true, true, false);
		assertEquals(6855.98,quoteGenerator.getPremiumWithHabitsBase(habits,6855.98),0);
	}
	
	@Test
	public void getTotalPremiumTest() throws QuoteGeneratorException{
		assertEquals(6856, quoteGenerator.getTotalPremium(6855.98),0);
	}
	
	
}
