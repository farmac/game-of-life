package pl.farmac.gameoflife;

public class GenerationModifier {
    private int numberOfGenerations;
    private int size;
    private Universe universe;
    
    public GenerationModifier(int numberOfGenerations, Universe universe) {
        this.numberOfGenerations = numberOfGenerations;
        this.universe = universe;
        this.size = universe.getSize();
    }
    
    public Universe getNewGeneration() {
        boolean[][] currentState = universe.getMap();
        
        for (int i = 0; i < numberOfGenerations; i++) {
            makeNewGeneration(currentState);
        }
        
        return universe;
    }
    
    private void makeNewGeneration(boolean[][] next) {
        boolean[][] current = copyArray(next);
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int numberOfAliveNeighbours = getNumberOfAliveNeighbours(current, i, j);
                if (next[i][j]) {
                    next[i][j] = numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3;
                } else {
                    next[i][j] = numberOfAliveNeighbours == 3;
                }
            }
        }
    }
    
    private int getNumberOfAliveNeighbours(boolean[][] currentState, int i, int j) {
        int aliveNeighboursCount = 0;
        if (currentState[findNeighbour(i - 1)][j]) { // North neighbour
            aliveNeighboursCount++;
        }
        if (currentState[findNeighbour(i - 1)][findNeighbour(j + 1)]) { // North-East neighbour
            aliveNeighboursCount++;
        }
        if (currentState[i][findNeighbour(j + 1)]) { // East neighbour
            aliveNeighboursCount++;
        }
        if (currentState[findNeighbour(i + 1)][findNeighbour(j + 1)]) { // // South-East neighbour
            aliveNeighboursCount++;
        }
        if (currentState[findNeighbour(i + 1)][j]) { // South neighbour
            aliveNeighboursCount++;
        }
        if (currentState[findNeighbour(i + 1)][findNeighbour(j - 1)]) { // South-West neighbour
            aliveNeighboursCount++;
        }
        if (currentState[i][findNeighbour(j - 1)]) { // West neighbour
            aliveNeighboursCount++;
        }
        if (currentState[findNeighbour(i - 1)][findNeighbour(j - 1)]) { // North-West neighbour
            aliveNeighboursCount++;
        }
        
        return aliveNeighboursCount;
        
    }
    
    private int findNeighbour(int index) {
        int i = index % size;
        if (i < 0) {
            i += size;
        }
        
        return i;
    }
    
    private boolean[][] copyArray(boolean[][] array) {
        boolean[][] copy = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                copy[i][j] = array[i][j];
            }
        }
        return copy;
    }
    
}
