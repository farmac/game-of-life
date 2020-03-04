package pl.farmac.gameoflife;

public class GenerationModifier {
    private int size;
    private Universe universe;
    
    public GenerationModifier(Universe universe) {
        this.universe = universe;
        this.size = universe.getSize();
    }
    
    
    public void makeNewGeneration() {
        boolean[][] next = universe.getWorld();
        boolean[][] current = copyArray(next);
        
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                int numberOfAliveNeighbours = countAliveNeighbours(current, i, j);
                if (next[i][j]) next[i][j] = numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3;
                else next[i][j] = numberOfAliveNeighbours == 3;
            }
    }
    
    private int countAliveNeighbours(boolean[][] currentState, int i, int j) {
        int aliveNeighboursCount = 0;
        // North neighbour
        if (currentState[getIndexOfNeighbour(i - 1)][j]) aliveNeighboursCount++;
        // North-East neighbour
        if (currentState[getIndexOfNeighbour(i - 1)][getIndexOfNeighbour(j + 1)]) aliveNeighboursCount++;
        // East neighbour
        if (currentState[i][getIndexOfNeighbour(j + 1)]) aliveNeighboursCount++;
        // // South-East neighbour
        if (currentState[getIndexOfNeighbour(i + 1)][getIndexOfNeighbour(j + 1)]) aliveNeighboursCount++;
        // South neighbour
        if (currentState[getIndexOfNeighbour(i + 1)][j]) aliveNeighboursCount++;
        // South-West neighbour
        if (currentState[getIndexOfNeighbour(i + 1)][getIndexOfNeighbour(j - 1)]) aliveNeighboursCount++;
        // West neighbour
        if (currentState[i][getIndexOfNeighbour(j - 1)]) aliveNeighboursCount++;
        // North-West neighbour
        if (currentState[getIndexOfNeighbour(i - 1)][getIndexOfNeighbour(j - 1)]) aliveNeighboursCount++;
        
        return aliveNeighboursCount;
        
    }
    
    private int getIndexOfNeighbour(int index) {
        int i = index % size;
        if (i < 0) i += size;
        
        return i;
    }
    
    private boolean[][] copyArray(boolean[][] orginalArray) {
        boolean[][] copy = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(orginalArray[i], 0, copy[i], 0, size);
        }
        return copy;
    }
    
}
