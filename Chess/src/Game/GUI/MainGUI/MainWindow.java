package Game.GUI.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainWindow extends JFrame {

    private String[][] boardArray = new String[8][8];
    private JPanel panel;
    private JButton start, stop;
    private final int width, height;
    
    private JLabel label;

    public MainWindow(int w, int h) {
        height = h;
        width = w;
        setSize(width, height);
        
        ImageIcon image = new ImageIcon("Chessboard.png");
        
        JFrame frame = new JFrame();
        
        
        panel = new JPanel();
        
        label = new JLabel();
        label.setIcon(image);
        label.setText("please work");
        panel.add(label);
        
        ActionListener listener = new ButtonsListener();
        start = new JButton("start");
        start.setActionCommand("start1");
        start.addActionListener(listener);
        stop = new JButton("stop");
        stop.setActionCommand("stop1");
        stop.addActionListener(listener);
        panel.add(start);
        panel.add(stop);
        
        frame.setSize(600, 600);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panel);

//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(450,450);
//        frame.setVisible(true);
//        frame.add(label, CENTER_ALIGNMENT);
    
        
    
    }
    private class ButtonsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("stop1")) {
                start.setText("start");
                stop.setText("stop");
            }
            else if (command.equals("start1")) {
                start.setText("running");
                stop.setText("stop");

            }
        }
    }


}

