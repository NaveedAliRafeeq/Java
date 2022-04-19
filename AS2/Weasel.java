
package com.bham.pij.assignments.a2a;

public class Weasel extends GAApplication { //daughter class of GAApplication
	
	public final int ASCII_Max = 122; //the max for the non control characters 
	public final int ASCII_Min = 32; //the min for the non control characters
	public String givenString;
	double upOrDown = 0.5; //when a mutation occurs there's a half chance that it would mover the character up or down
	
	public Weasel (String str_inp) { //Constructor
		givenString = str_inp; //String input given by Ian
		popCreate();
	}
	
	@Override 
	public Individual [] popCreate() {
		
		for (int x = 0; x < population_size; x++) {
			char[] quote = givenString.toString().toCharArray();
			
			for (int z = 0; z < givenString.length(); z++) {
				quote[z] = (char)(rnd.nextInt(ASCII_Min - ASCII_Min + 1) + ASCII_Min);
				//random number between 32 and 122 then converts it to its ASCII character equivalent
			}
			
			String fillPop = new String(quote);
			population[x] = new Individual (fillPop);
		}
		
		return population;
	}
	
	@Override
	public void mutation( ) {
		
		double r = rnd.nextDouble();
		double x = rnd.nextDouble();
		
		for (int i = 0; i < population_size; i++) {
			char[] letter = population[i].toString().toCharArray();
			
			for (int j = 0; j < givenString.length(); j++) {
				char character = letter[j];
				
				if (x < mutation_prob) {
					if (r > upOrDown) {
						letter[j] = (char)(int)(character + 1); //if mutation occurs and the r value is above 0.5 then it increments the character along the ASCII alphabet
						if (letter[j] > 122) { //Unless it goes above 122 then it returns it to the min
							letter[j] = ASCII_Min;
						}
					} else {
						letter[j] = (char)(int)(character - 1); //vice versa
						if (letter[j] < 22) { //vice versa
							letter[j] = ASCII_Max;
						}
					}
				}
				
				String fillPop = new String(letter);
				population[i] = new Individual(fillPop);
			}
		}	
	}
	
}
