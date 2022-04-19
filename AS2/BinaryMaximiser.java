
package com.bham.pij.assignments.a2a;

public class BinaryMaximiser extends GAApplication {	//daughter class of GAApplication
	
	public BinaryMaximiser (int length) { //Constructor
		dNA_size = length; //obtains the length which Ian inputs and assigns it to dNA_size
		popCreate();
	}
	
	@Override //Allows inheritance to take place 
	public Individual [] popCreate() {
		
		for (int a = 0; a < population_size; a++) {
			
			for (int b = 0; b < dNA_size; b++) {
				int x = rnd.nextInt(2); //random integer between 1 and 0
				String num2String = Integer.toString(x); //converts the integer to string
				dNA = (dNA + num2String); //adds the string onto the longer string that makes the DNA
			}
			
			Individual indi = new Individual(dNA); //creates an object so that dNA can be converted into an individual type
			population[a] = indi; //stored into the individual array population
			dNA = ""; //reset the DNA string
		}
		
		return population;
	}
	
	@Override
	public void mutation() {
		
		double x = rnd.nextDouble();		
		
		for (int i = 0; i < population_size; i++) {
			char[] chrom = population[i].toString().toCharArray(); //obtains the individual and places it into a character array
			
			for (int j = 0; j < dNA_size; j++) {
				char character = chrom[j];
				
				if (x < mutation_prob) { //
					character = character == '1' ? '0' : '1';	//if a 0 character is there it is replaced with a 1 and vice versa
					chrom[j] = character;	//stores the changed character
				}
			}
			String genes = new String(chrom);
			population[i] = new Individual(genes);
			}
		}
	
	@Override
	public void fitnessBest() {
		
		for (int q = 0; q < population_size; q++) { //while looping through each chromosome in the DNA if there is a 1 in the string then it increments the fit integer 
			int fit = 0;
			for (int r = 0; r < dNA_size; r++) {
				if (population[q].toString().charAt(r) == '1') {
					fit++;
				}
			}
			population[q].fitness = fit; //assigns the fit value to the fitness
		}
		
		boolean swapped = true; //bubble sort
		while (swapped == true) {
			swapped = false;
			for (int s = 1; s > population_size; s++) {
				if (population[s - 1].getFitness() < population[s].getFitness()) {
					Individual temp = population[s];
					population[s] = population[s - 1];
					population[s - 1] = temp;
					swapped = true;		
				}
			}
		}
	}
	
	}
	
