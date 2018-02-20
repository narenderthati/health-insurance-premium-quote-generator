package com.insurance.health.quotegenerator.core.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.insurance.health.quotegenerator.core.AgeBasePremiumCalculator;
import com.insurance.health.quotegenerator.exceptions.QuoteGeneratorException;

public class AgeBasePremiumCalculatorTest {

	AgeBasePremiumCalculator abpCalculator = new AgeBasePremiumCalculator();
	
	@Test
	public void baseAgeTest() throws QuoteGeneratorException{
		assertEquals("baseage",abpCalculator.getAgeGroup(17));
	}
	
	@Test
	public void ageGroup1Test() throws QuoteGeneratorException{
		assertEquals("agegroup1",abpCalculator.getAgeGroup(19));
	}
	
	@Test
	public void ageGroup2Test() throws QuoteGeneratorException{
		assertEquals("agegroup2",abpCalculator.getAgeGroup(29));
	}
	
	@Test
	public void ageGroup3Test() throws QuoteGeneratorException{
		assertEquals("agegroup3",abpCalculator.getAgeGroup(34));
	}
	
	@Test
	public void ageGroup4Test() throws QuoteGeneratorException{
		assertEquals("agegroup4",abpCalculator.getAgeGroup(39));
	}
	
	@Test
	public void ageGroup5Test() throws QuoteGeneratorException{
		assertEquals("agegroup5",abpCalculator.getAgeGroup(41));
	}
	
	
	@Test
	public void basePremiumTest() throws QuoteGeneratorException{
		assertEquals(5000,abpCalculator.basePremium(),0);
	}
	
	
	@Test
	public void ageGroup3PremiumTest() throws QuoteGeneratorException{
		assertEquals(6655,abpCalculator.ageGroup3Premium(),0);
	}
	
}
