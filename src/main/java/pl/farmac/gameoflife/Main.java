package pl.farmac.gameoflife;

public class Main {
    private static final int NUMBER_OF_GENERATIONS = 10000;
    private static final int SIZE = 20;
    
    public static void main(String[] args) {
        Universe universe = new Universe(SIZE, NUMBER_OF_GENERATIONS);
        GameOfLife gameOfLife = new GameOfLife();
        UniverseController universeController = new UniverseController(universe, gameOfLife);
        universeController.start();
    }
}
