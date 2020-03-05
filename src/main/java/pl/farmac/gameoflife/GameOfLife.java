package pl.farmac.gameoflife;

import javax.swing.*;
import java.awt.*;

//View
public class GameOfLife extends JFrame {
    private JLabel generationCountLabel;
    private JLabel aliveCellsLabel;
    private FieldPanel fields;
    
    public GameOfLife() {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel infoPanel = new JPanel();
        infoPanel.setSize(500, 100);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        
        Font font = new Font(Font.SANS_SERIF,  Font.BOLD, 16);
        
        generationCountLabel = new JLabel();
        generationCountLabel.setName("GenerationLabel");
        generationCountLabel.setFont(font);
        generationCountLabel.setText("Generation #1");
        infoPanel.add(generationCountLabel);
        
        aliveCellsLabel = new JLabel();
        aliveCellsLabel.setName("AliveLabel");
        aliveCellsLabel.setFont(font);
        aliveCellsLabel.setText("Alive: ");
        infoPanel.add(aliveCellsLabel);
        
        fields = new FieldPanel();
        fields.setPreferredSize(new Dimension(500, 500));
        fields.setMaximumSize(new Dimension(500, 500));
        
        add(infoPanel, BorderLayout.PAGE_START);
        add(fields, BorderLayout.CENTER);
        
        setVisible(true);
        
    }
    
    public JLabel getAliveCellsLabel() {
        return aliveCellsLabel;
    }
    
    public FieldPanel getFields() {
        return fields;
    }
    
    public JLabel getGenerationCountLabel() {
        return generationCountLabel;
    }
}
