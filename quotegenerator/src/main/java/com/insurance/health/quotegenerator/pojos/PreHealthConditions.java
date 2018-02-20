package com.insurance.health.quotegenerator.pojos;

public class PreHealthConditions {

	private boolean hypertension;
	
	private boolean bloodPressure;
	
	private boolean bloodSugar;
	
	private boolean overWeight;

	/**
	 * PreHealthConditios Constructor
	 * @param hypertension
	 * @param bloodPressure
	 * @param bloodSugar
	 * @param overWeight
	 */
	public PreHealthConditions(boolean hypertension, boolean bloodPressure, boolean bloodSugar, boolean overWeight) {
		super();
		this.hypertension = hypertension;
		this.bloodPressure = bloodPressure;
		this.bloodSugar = bloodSugar;
		this.overWeight = overWeight;
	}

	public boolean isHypertension() {
		return hypertension;
	}

	public void setHypertension(boolean hypertension) {
		this.hypertension = hypertension;
	}

	public boolean isBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(boolean bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public boolean isBloodSugar() {
		return bloodSugar;
	}

	public void setBloodSugar(boolean bloodSugar) {
		this.bloodSugar = bloodSugar;
	}

	public boolean isOverWeight() {
		return overWeight;
	}

	public void setOverWeight(boolean overWeight) {
		this.overWeight = overWeight;
	}

	@Override
	public String toString() {
		return "PreHealthConditions [hypertension=" + hypertension + ", bloodPressure=" + bloodPressure
				+ ", bloodSugar=" + bloodSugar + ", overWeight=" + overWeight + "]";
	}
	
	
	
	
	
}
