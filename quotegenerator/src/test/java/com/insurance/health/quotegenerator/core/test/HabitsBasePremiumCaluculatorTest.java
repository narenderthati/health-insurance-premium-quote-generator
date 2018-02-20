package com.insurance.health.quotegenerator.core.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.insurance.health.quotegenerator.core.HabitsBasePremiumCaluculator;
import com.insurance.health.quotegenerator.pojos.Habits;

public class HabitsBasePremiumCaluculatorTest {

	HabitsBasePremiumCaluculator hbpCalculator = new HabitsBasePremiumCaluculator();
	
	@Test
	public void goodHabitsCountTest() {
		Habits habits = new Habits(false, true, true, false);
		assertEquals(1, hbpCalculator.goodHabitsCount(habits));	
	}
	
	@Test
	public void badHabitsCountTest() {
		Habits habits = new Habits(false, true, false, true);
		assertEquals(2, hbpCalculator.badHabitsCount(habits));	
	}
	
	

}
