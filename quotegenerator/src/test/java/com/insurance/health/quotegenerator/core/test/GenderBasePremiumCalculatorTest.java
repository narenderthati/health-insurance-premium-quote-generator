package com.insurance.health.quotegenerator.core.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.insurance.health.quotegenerator.core.GenderBasePremiumCalculator;
import com.insurance.health.quotegenerator.exceptions.QuoteGeneratorException;
import com.insurance.health.quotegenerator.pojos.Person;

public class GenderBasePremiumCalculatorTest {
	
	GenderBasePremiumCalculator gbpCalculator = new GenderBasePremiumCalculator();

	@Test
	public void getPremiumIncreaseWithMaleTest() throws QuoteGeneratorException {
		Person person = new Person("test name","male",34);
		assertEquals(2,gbpCalculator.getPremiumIncreaseWithGender(person));
	}
	
	@Test
	public void getPremiumIncreaseWithFemaleTest() throws QuoteGeneratorException {
		Person person = new Person("test name","female",34);
		assertEquals(0,gbpCalculator.getPremiumIncreaseWithGender(person));
	}
	
	@Test
	public void getPremiumIncreaseWithOtherTest() throws QuoteGeneratorException {
		Person person = new Person("test name","others",34);
		assertEquals(0,gbpCalculator.getPremiumIncreaseWithGender(person));
	}
	
	@Test(expected = QuoteGeneratorException.class)
	public void invalidGenderTest() throws QuoteGeneratorException{
		Person person = new Person("test name","unknow",34);
		assertEquals(0,gbpCalculator.getPremiumIncreaseWithGender(person));
	}
	
	@Test
	public void premiumWithGenderBaseTest() throws QuoteGeneratorException{
		Person person = new Person("test name","male",34);
		assertEquals(6788.1,gbpCalculator.premiumWithGenderBase(person,6655),0);
	}
	
}
