package Game.GUI;

import Game.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainWindow extends JFrame {

    private String[][] boardArray = new String[8][8];
    private JPanel panel;
    private JButton start, stop;
    private final int width, height;

    public MainWindow(int w, int h) {
        height = h;
        width = w;

        setSize(width, height);
        panel = new JPanel();
        ActionListener listener = new ButtonsListener();
        start = new JButton("start");
        start.setActionCommand("start1");
        start.addActionListener(listener);
        stop = new JButton("stop");
        stop.setActionCommand("stop1");
        stop.addActionListener(listener);
        panel.add(start);
        panel.add(stop);
        getContentPane().add(BorderLayout.SOUTH, panel);
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

