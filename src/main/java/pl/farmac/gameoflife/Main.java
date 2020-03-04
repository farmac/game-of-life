package pl.farmac.gameoflife;

public class Main {
    private static final int NUMBER_OF_GENERATIONS = 10;
    private static final int SIZE = 10;
    
    public static void main(String[] args) {
        Universe universe = new Universe(SIZE, NUMBER_OF_GENERATIONS);
        universe.getNewGenerations();
    }
    
}
