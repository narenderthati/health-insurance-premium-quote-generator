package com.insurance.health.quotegenerator.core;

import com.insurance.health.quotegenerator.pojos.Habits;
import com.insurance.health.quotegenerator.util.AppProperties;

public class HabitsBasePremiumCaluculator {
	
	private AppProperties props = new AppProperties();
	
	private int GOOD_HABITS_PREMIUM_DECREASE = Integer.parseInt(props.getProperty("GOOD_HABITS_PREMIUM_DECREASE"));
	
	private int BAD_HABITS_PREMIUM_DECREASE = Integer.parseInt(props.getProperty("BAD_HABITS_PREMIUM_DECREASE"));
	
	public int goodHabitsCount(Habits habits){
		int count = 0;
		
		if(habits.isDailyExcercise()){
			count = count+1;
		}
		
		return count;
	}
	
	public int badHabitsCount(Habits habits){
		int count = 0;
		
		if(habits.isAlcohol()){
			count = count +1;
		}
		
		if(habits.isDrugs()){
			count = count +1;
		}
		
		if(habits.isSmoking()){
			count = count +1;
		}
		
		return count;
	}
	
	public double premiumWithHabits(Habits habits,double quoteValue){
		
		double premiumChangeWithGoodHabits =  (quoteValue * goodHabitsCount(habits) * GOOD_HABITS_PREMIUM_DECREASE)/100;
		
		double premiumChangeWithBadHabits = (quoteValue * badHabitsCount(habits) * BAD_HABITS_PREMIUM_DECREASE)/100;
		
		return (quoteValue - premiumChangeWithGoodHabits ) + premiumChangeWithBadHabits;
		
	}
	
	
	

}
