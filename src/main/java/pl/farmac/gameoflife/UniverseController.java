package pl.farmac.gameoflife;

// Controller

public class UniverseController {
    private Universe universe;
    private GameOfLife gameOfLife;
    
    public UniverseController(Universe universe, GameOfLife gameOfLife) {
        this.universe = universe;
        this.gameOfLife = gameOfLife;
    }
    
    public void start() {
        while (universe.getCurrentGeneration() <= universe.getNumberOfGenerations()) {
            gameOfLife.getFields().setWorld(universe.getWorld());
            gameOfLife.getGenerationCountLabel().setText("Generation #" + universe.getCurrentGeneration());
            gameOfLife.getAliveCellsLabel().setText("Alive: " + universe.countAliveCells());
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
            
            universe.getNewGeneration();
        }
    }
}
