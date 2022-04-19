package com.bham.pij.assignments.a2a;

public class Individual {

	protected double fitness;
	private String chromosome;
	
	public Individual (String inp) {
		fitness = 0;
		chromosome = inp;
	}
		
	
	public double getFitness() {
		return fitness;
	}
	
	public String toString() {
		return chromosome;
	}
}
