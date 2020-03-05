package pl.farmac.gameoflife;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

//View
public class GameOfLife extends JFrame {
    private JLabel generationCountLabel;
    private JLabel aliveCellsLabel;
    private FieldPanel fields;
    private JToggleButton pauseResumeButton;
    
    public GameOfLife(Universe universe) {
        super("Game of Life");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 650);
        setLocationRelativeTo(null);
        
        JPanel infoPanel = new JPanel();
        infoPanel.setSize(500, 100);
        infoPanel.setLayout(new GridLayout(2, 2, 2, 2));
        infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 18);
        
        generationCountLabel = new JLabel();
        generationCountLabel.setName("GenerationLabel");
        generationCountLabel.setFont(font);
        generationCountLabel.setText("Generation #0");
        infoPanel.add(generationCountLabel);
        
        pauseResumeButton = new JToggleButton();
        pauseResumeButton.setName("PlayToggleButton");
        pauseResumeButton.setText("Pause");
        pauseResumeButton.addActionListener(l -> {
            universe.pauseResume();
            if(pauseResumeButton.getText().equals("Pause")) {
                pauseResumeButton.setText("Resume");
            } else {
                pauseResumeButton.setText("Pause");
            }
        });
        infoPanel.add(pauseResumeButton);
        
        aliveCellsLabel = new JLabel();
        aliveCellsLabel.setName("AliveLabel");
        aliveCellsLabel.setFont(font);
        aliveCellsLabel.setText("Alive: 0");
        infoPanel.add(aliveCellsLabel);
    
    
        JButton restart = new JButton();
        restart.setName("ResetButton");
        restart.setText("Restart");
        restart.addActionListener((l) -> {
            universe.setCurrentGeneration(0);
            universe.createUniverse();
        });
        infoPanel.add(restart);
        
        
        fields = new FieldPanel();
        fields.setPreferredSize(new Dimension(501, 501));
        
        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        wrapperPanel.setPreferredSize(new Dimension(550, 550));
        wrapperPanel.add(fields);
        
        add(infoPanel, BorderLayout.PAGE_START);
        add(wrapperPanel);
        
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
