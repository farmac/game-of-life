package pl.farmac.gameoflife;

import java.util.Arrays;
import java.util.Random;

public class Universe {
    private boolean[][] map;
    private int size;
    private Random random;
    
    public Universe(int size) {
        this.size = size;
        this.map = new boolean[size][size];
        this.random = new Random();
    }
    
    public void createUniverse() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = random.nextBoolean();
            }
        }
    }
    
    public void printUniverse(int generation) {
        System.out.println("Generation #" + generation);
        System.out.println("Alive: " + countAliveCells());
        for (boolean[] row : map) {
            for (boolean col : row) {
                System.out.print(col ? "0" : " ");
            }
            System.out.println();
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    public int countAliveCells() {
        return Arrays.stream(map)
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
    
    public boolean[][] getMap() {
        return map;
    }
    
}
