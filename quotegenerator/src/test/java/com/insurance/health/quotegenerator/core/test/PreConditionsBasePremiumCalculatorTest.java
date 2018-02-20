package com.insurance.health.quotegenerator.core.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.insurance.health.quotegenerator.core.PreConditionsBasePremiumCalculator;
import com.insurance.health.quotegenerator.pojos.PreHealthConditions;

public class PreConditionsBasePremiumCalculatorTest {
	PreConditionsBasePremiumCalculator pcbpCalculator = new PreConditionsBasePremiumCalculator();
	
	@Test
	public void countPreCondition0Test(){
		PreHealthConditions phc = new PreHealthConditions(false, false, false, false);
		assertEquals(0, pcbpCalculator.countPreConditions(phc));
		
	}
	
	@Test
	public void countPreCondition1Test(){
		PreHealthConditions phc = new PreHealthConditions(false, false, false, true);
		assertEquals(1, pcbpCalculator.countPreConditions(phc));
		
	}
	
	@Test
	public void countPreCondition2Test(){
		PreHealthConditions phc = new PreHealthConditions(false, false, true, true);
		assertEquals(2, pcbpCalculator.countPreConditions(phc));
		
	}
	
	@Test
	public void countPreCondition3Test(){
		PreHealthConditions phc = new PreHealthConditions(false, true, true, true);
		assertEquals(3, pcbpCalculator.countPreConditions(phc));
		
	}
	
	@Test
	public void countPreCondition4Test(){
		PreHealthConditions phc = new PreHealthConditions(true, true, true, true);
		assertEquals(4, pcbpCalculator.countPreConditions(phc));
		
	}
	
	
	@Test
	public void premiumWithPreConditionsTest(){
		PreHealthConditions phc = new PreHealthConditions(false, false, false, true);
		assertEquals(6855.98,pcbpCalculator.premiumWithPreConditions(phc, 6788.1),0);
	}

	
}
