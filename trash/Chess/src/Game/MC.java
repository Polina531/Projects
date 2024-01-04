package Game;

import Game.GUI.MainWindow;

import  java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;

public class MC {
    public static void main(String[] args) {


    MainWindow mainWindow = new MainWindow(600, 600);
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setLocationRelativeTo(null);
    mainWindow.setVisible(true);
    Board b = new Board();
    b.getPawns();


    }

}