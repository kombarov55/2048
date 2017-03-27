package view;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

public class MainFrame extends JFrame {
    private Controller controller;
    private List<JButton> buttons = createButtons(16);
    private JPanel grid = setupGrid();
    private JPanel upperPanel = setupUpperPanel();
    KeyListener keyListener;

    public JLabel label;

    public MainFrame() {
        super("2048");
        setupFrame();
    }

    public void updateCell(int position, Color color, String label) {
        JButton button = buttons.get(position);
        button.setBackground(color);
        button.setText(label);
    }
    
    private void setupFrame() {
        setVisible(true);
        setPreferredSize(new Dimension(500, 600));
        getContentPane().add(grid, BorderLayout.CENTER);
        getContentPane().add(upperPanel, BorderLayout.NORTH);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(false);
        setResizable(false);
    }
    private JPanel setupGrid() {
        JPanel ret = new JPanel();
        ret.setLayout(new GridLayout(4,4));
        buttons.forEach(ret::add);
        return ret;
    }

    public List<JButton> getButtons() {
        return Collections.unmodifiableList(buttons);
    }

    private List<JButton> createButtons(int amount) {
        List<JButton> ret = new ArrayList<>();
        for (int i = 0; i < amount; i++) ret.add(createButton());
        return ret;
    }

    private JButton createButton() {
        JButton button = new JButton();
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setOpaque(true);
        button.setEnabled(false);
        return button;
    }

    private JPanel setupUpperPanel() {
        JPanel ret = new JPanel();
        ret.setPreferredSize(new Dimension(500, 150));
        label = new JLabel("2048");
        ret.add(label);
        ret.addKeyListener(keyListener);
        return ret;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public JLabel getAmountLabel() {
        return label;
    }
    
    public void setKeyListener(KeyAdapter keyListener) {
        this.keyListener = keyListener;
    }
    
    
    
}
