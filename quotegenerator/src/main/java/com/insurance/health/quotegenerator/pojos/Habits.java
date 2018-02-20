package com.insurance.health.quotegenerator.pojos;

public class Habits {
	
	private boolean smoking;
	
	private boolean alcohol;
	
	private boolean dailyExcercise;
	
	private boolean drugs;

	/**
	 * Habits Constructor
	 * @param smoking
	 * @param alcohol
	 * @param dailyExcercise
	 * @param drugs
	 */
	public Habits(boolean smoking, boolean alcohol, boolean dailyExcercise, boolean drugs) {
		super();
		this.smoking = smoking;
		this.alcohol = alcohol;
		this.dailyExcercise = dailyExcercise;
		this.drugs = drugs;
	}

	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}

	public boolean isAlcohol() {
		return alcohol;
	}

	public void setAlcohol(boolean alcohol) {
		this.alcohol = alcohol;
	}

	public boolean isDailyExcercise() {
		return dailyExcercise;
	}

	public void setDailyExcercise(boolean dailyExcercise) {
		this.dailyExcercise = dailyExcercise;
	}

	public boolean isDrugs() {
		return drugs;
	}

	public void setDrugs(boolean drugs) {
		this.drugs = drugs;
	}

	@Override
	public String toString() {
		return "Habits [smoking=" + smoking + ", alcohol=" + alcohol + ", dailyExcercise=" + dailyExcercise + ", drugs="
				+ drugs + "]";
	}
	
	
	

}
