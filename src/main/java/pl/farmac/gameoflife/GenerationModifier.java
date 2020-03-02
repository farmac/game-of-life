package pl.farmac.gameoflife;

public class GenerationModifier {
    private int numberOfGenerations;
    private int size;
    private Universe universe;
    
    public GenerationModifier(int numberOfGenerations, Universe universe) {
        this.numberOfGenerations = numberOfGenerations;
        this.universe = new Universe(universe.getSize(), universe.getSeed());
        this.universe.setMap(universe.getMap());
        this.size = universe.getSize();
    }
    
    public Universe getNewGeneration() {
        boolean[][] currentState = universe.getMap();
        
        for (int i = 0; i < numberOfGenerations; i++) {
            universe.printUniverse();
            makeNewGeneration(currentState);
            System.out.println("---------------------");
        }
        
        return universe;
    }
    
    private void makeNewGeneration(boolean[][] currentState) {
        boolean[][] copy = copyArray(currentState);
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int aliveToDeadNeighboursRatio = getAliveToDeadNeighboursRatio(copy, i, j);
                if (currentState[j][j]) {
                    currentState[i][j] = aliveToDeadNeighboursRatio == -4 || aliveToDeadNeighboursRatio == -2;
                } else {
                    currentState[i][j] = aliveToDeadNeighboursRatio == -2;
                }
            }
        }
    }
    
    private int getAliveToDeadNeighboursRatio(boolean[][] currentState, int i, int j) {
        int aliveToDeadNeighboursRatio = 0;
        aliveToDeadNeighboursRatio = currentState[findNeighbour(i - 1)][j] ? aliveToDeadNeighboursRatio + 1
                : aliveToDeadNeighboursRatio - 1; // North neighbour
        aliveToDeadNeighboursRatio = currentState[findNeighbour(i - 1)][findNeighbour(j + 1)]
                ? aliveToDeadNeighboursRatio + 1 : aliveToDeadNeighboursRatio - 1; // North-East neighbour
        aliveToDeadNeighboursRatio = currentState[i][findNeighbour(j + 1)]
                ? aliveToDeadNeighboursRatio + 1 : aliveToDeadNeighboursRatio - 1; // East
        aliveToDeadNeighboursRatio = currentState[findNeighbour(i + 1)][findNeighbour(j + 1)]
                ? aliveToDeadNeighboursRatio + 1 : aliveToDeadNeighboursRatio - 1; // South-East
        aliveToDeadNeighboursRatio = currentState[findNeighbour(i + 1)][j] ? aliveToDeadNeighboursRatio + 1
                : aliveToDeadNeighboursRatio - 1; // South neighbour
        aliveToDeadNeighboursRatio = currentState[findNeighbour(i + 1)][findNeighbour(j - 1)]
                ? aliveToDeadNeighboursRatio + 1 : aliveToDeadNeighboursRatio - 1; // South-West neighbour
        aliveToDeadNeighboursRatio = currentState[i][findNeighbour(j - 1)]
                ? aliveToDeadNeighboursRatio + 1 : aliveToDeadNeighboursRatio - 1; // West neighbour
        aliveToDeadNeighboursRatio = currentState[findNeighbour(i - 1)][findNeighbour(j - 1)]
                ? aliveToDeadNeighboursRatio + 1 : aliveToDeadNeighboursRatio - 1; // North-West neighbour
        return aliveToDeadNeighboursRatio;
        
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
