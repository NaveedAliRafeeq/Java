package com.bham.pij.assignments.a2a;

public class GATester {
    
    /* Change this constant to change the goal */
    private static final int BINARY_GOAL = 8;
    
    /* Change this constant to change the maximum number of runs of the GA */
    private static final int MAX_GENERATIONS = 3;

    /* Change this constant to change the maximum number of runs of the GA */
    private static final int MIN_GENERATIONS = 3;

    public static void main(String[] args) {
        BinaryMaximiser bm = new BinaryMaximiser(BINARY_GOAL);
        int gens = 1;
        do {
            bm.run();
            
            /* Prints out the fitness of the current best individual */
            System.out.println(bm.getBest().getFitness());
            
            /* while the goal is not reached and the number of generations has not exceeded the maximum */
        }while (bm.getBest().getFitness() != BINARY_GOAL && (gens++) < MAX_GENERATIONS);
        
        if (gens <= MIN_GENERATIONS) {
            System.out.println("The GA might not be working if it finds the goal that quickly.");
        }
        
        System.out.println("Num generations: " + gens);
    }
}

