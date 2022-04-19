import java.util.Random;

package com.bham.pij.assignments.a2a;

public class GAApplication {
	
	public final int population_size = 100;
	public int dNA_size;
	public final double mutation_prob = 0.01;
	public final double crossover_prob = 0.02;
	public final int Percent = 10;
	public int n0Parents = population_size/Percent; //Used 2 integers here so that integer division occurs and I would not get a decimal
	public Individual [] population = new Individual [population_size];
	public Individual parents[] = new Individual[n0Parents];
	public Individual children[] = new Individual[n0Parents];
	public String dNA = "";
	public Random rnd = new Random();
	
	public void run() {	//Runs all the methods for BinaryMaximiser or Weasel
		mutation();
		fitnessBest();
		crossover();
	}

	public Individual getBest() {
		return population[0]; //Since the population is sorted from best to worse, the first item in the array is the best individual 
	}
	
	public void mutation() {
		
	}
	
	public void fitnessBest() {
		
	}
	
	public Individual[] popCreate() {
		return population;
	}
	
	public void crossover() {
		
		double x = rnd.nextDouble();	
		
		for (int i = 0; i < n0Parents; i++) {
			parents[i] = population[i]; //Populates the parent array with the fittest of the population 
		}
		for (int j = 0; j < (n0Parents/2); j = j + 2) { //Increments of 2 at a time since were comparing 2 at a time 
			if (x < crossover_prob) { //if the random double value that is between 0 and 1 is
				int y = rnd.nextInt((dNA_size - 1) + 1) + 1; //random integer between 1 and the dna size
				String child1 = parents[j].toString().substring(0, y) + parents[j+1].toString().substring(y); //crossover occurs over these 2 lines
				String child2 = parents[j+1].toString().substring(0, y) + parents[j].toString().substring(y);
				String child1Ind = new String(child1);
				children[j] = new Individual(child1Ind);
				String child2Ind = new String(child2);
				children[j+1] = new Individual(child2Ind);
				//the above changes the strings into Individuals and stores them into the children array
			} else {
				children[j] = parents[j];
				children[j+1] = parents[j+1];
			}
		}
		for (int k = 0; k < n0Parents; k++) { //Populates the worst of the population array with the children
			population[population_size - 1 - k] = children[k];
		}
	}
	
}
