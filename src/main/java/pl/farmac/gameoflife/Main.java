package pl.farmac.gameoflife;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int size = scanner.nextInt();
        long seed = scanner.nextLong();
        int numberOfGenerations = scanner.nextInt();
        
        Universe universe = new Universe(size, seed);
        universe.createUniverse();
        
        Universe newUniverse = new GenerationModifier(numberOfGenerations, universe)
                .getNewGeneration();
        newUniverse.printUniverse();
    }
    
}
