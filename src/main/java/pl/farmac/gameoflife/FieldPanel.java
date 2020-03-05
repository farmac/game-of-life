package pl.farmac.gameoflife;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel {
    private boolean[][] world;
    
    public void setWorld(boolean[][] world) {
        this.world = world;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int dimension = 500;
        
        int size = (int) Math.ceil(dimension / (double) world.length);
        
        for (int i = 0, x = 0; i < dimension; i += size, x++) {
            for (int j = 0, y = 0; j < dimension; j += size, y++) {
                if (world[x][y]) {
                    g.setColor(Color.BLACK);
                    g.fillRect(j, i, size, size);
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                    g.drawRect(j, i, size, size);
                }
            }
        }
    }
}
