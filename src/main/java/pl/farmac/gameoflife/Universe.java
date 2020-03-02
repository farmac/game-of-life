package pl.farmac.gameoflife;

import java.util.Random;

public class Universe {
    private boolean[][] map;
    private long seed;
    private int size;
    private Random random;
    
    public Universe(int size, long seed) {
        this.size = size;
        this.map = new boolean[size][size];
        this.seed = seed;
        this.random = new Random(seed);
    }
    
    public void createUniverse() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = random.nextBoolean();
            }
        }
    }
    
    public void printUniverse() {
        for (boolean[] row: map) {
            for (boolean col: row) {
                System.out.print(col ? "O" : " ");
            }
            System.out.println();
        }
    }
    
    public int getSize() {
        return size;
    }
    
    public void setMap(boolean[][] map) {
        this.map = map;
    }
    
    public boolean[][] getMap() {
        return map;
    }
    
    public long getSeed() {
        return seed;
    }
    
}
