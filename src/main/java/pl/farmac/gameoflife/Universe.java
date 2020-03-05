package pl.farmac.gameoflife;

import java.util.Arrays;
import java.util.Random;

// Model

public class Universe {
    private boolean[][] world;
    private int size;
    private int numberOfGenerations;
    private int currentGeneration;
    private int currentlyAlive;
    private Random random;
    private GenerationModifier generationModifier;
    
    public Universe(int size, int numberOfGenerations) {
        this.size = size;
        this.world = new boolean[size][size];
        this.random = new Random();
        this.numberOfGenerations = numberOfGenerations;
        createUniverse();
        this.currentGeneration = 1;
        this.currentlyAlive = countAliveCells();
        this.generationModifier = new GenerationModifier(this);
        
    }
    
    private void createUniverse() {
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                world[i][j] = random.nextBoolean();
            }
        }
        printUniverse();
    }
    
    public void getNewGeneration() {
        generationModifier.makeNewGeneration();
        this.currentlyAlive = countAliveCells();
        this.currentGeneration++;
        printUniverse();
    }
    
    public void printUniverse() {
        System.out.println("Generation #" + currentGeneration);
        System.out.println("Alive: " + currentlyAlive);
        for (boolean[] row : world) {
            for (boolean col : row) {
                System.out.print(col ? "0" : " ");
            }
            System.out.println();
        }
    }
    
    public int countAliveCells() {
        return Arrays.stream(world)
                .mapToInt(i -> {
                    int count = 0;
                    for (boolean b : i) {
                        if (b) {
                            count++;
                        }
                    }
                    return count;
                })
                .sum();
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean[][] getWorld() {
        return world;
    }
    
    public int getNumberOfGenerations() {
        return numberOfGenerations;
    }
    
    public int getCurrentGeneration() {
        return currentGeneration;
    }
}
