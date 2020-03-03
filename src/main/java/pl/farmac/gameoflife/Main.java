package pl.farmac.gameoflife;

import java.util.Scanner;

public class Main {
    private static final int NUMBER_OF_EXTRA_GENERATIONS = 50;
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int size = scanner.nextInt();
        
        Universe universe = new Universe(size);
        universe.createUniverse();
        
        new GenerationModifier(NUMBER_OF_EXTRA_GENERATIONS, universe)
                .getNewGenerations();
    }
}
