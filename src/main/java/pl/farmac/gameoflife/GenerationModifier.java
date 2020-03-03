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
    
    public void getNewGenerations() {
        boolean[][] currentState = universe.getMap();
        universe.printUniverse(1);
        
        for (int i = 0; i < numberOfGenerations; i++) {
            makeNewGeneration(currentState);
            universe.printUniverse(i + 2);
        }
        
    }
    
    private void makeNewGeneration(boolean[][] next) {
        boolean[][] current = copyArray(next);
        
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                int numberOfAliveNeighbours = getNumberOfAliveNeighbours(current, i, j);
                if (next[i][j]) next[i][j] = numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3;
                else next[i][j] = numberOfAliveNeighbours == 3;
            }
    }
    
    private int getNumberOfAliveNeighbours(boolean[][] currentState, int i, int j) {
        int aliveNeighboursCount = 0;
        // North neighbour
        if (currentState[findNeighbour(i - 1)][j]) aliveNeighboursCount++;
        // North-East neighbour
        if (currentState[findNeighbour(i - 1)][findNeighbour(j + 1)]) aliveNeighboursCount++;
        // East neighbour
        if (currentState[i][findNeighbour(j + 1)]) aliveNeighboursCount++;
        // // South-East neighbour
        if (currentState[findNeighbour(i + 1)][findNeighbour(j + 1)]) aliveNeighboursCount++;
        // South neighbour
        if (currentState[findNeighbour(i + 1)][j]) aliveNeighboursCount++;
        // South-West neighbour
        if (currentState[findNeighbour(i + 1)][findNeighbour(j - 1)]) aliveNeighboursCount++;
        // West neighbour
        if (currentState[i][findNeighbour(j - 1)]) aliveNeighboursCount++;
        // North-West neighbour
        if (currentState[findNeighbour(i - 1)][findNeighbour(j - 1)]) aliveNeighboursCount++;
        
        return aliveNeighboursCount;
        
    }
    
    private int findNeighbour(int index) {
        int i = index % size;
        if (i < 0) i += size;
        
        return i;
    }
    
    private boolean[][] copyArray(boolean[][] array) {
        boolean[][] copy = new boolean[size][size];
        for (int i = 0; i < size; i++) System.arraycopy(array[i], 0, copy[i], 0, size);
        return copy;
    }
    
}
