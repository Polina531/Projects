package Game.GUI.MainGUI;

import Game.Pieces.Pawn;
import Game.Pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

import static Game.Board.boardObjects;
import static Game.GUI.MainGUI.GUIFrame.Labels.getPawnLabels;

public class GUIFrame {

private static JFrame frame;
private final int width, height;


public GUIFrame(int width, int height) {
    this.width = width;
    this.height = height;
    
    frame = new JFrame();
    frame.setSize(width, height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setBackground(Color.DARK_GRAY);
//    frame.setLayout(null);

//        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
    
    JLabel label = new JLabel();
    ImageIcon image = new ImageIcon("C:\\p\\Projects\\v_control\\Chess\\src\\Game\\GUI\\Images\\Chessboard.png");
    label.setIcon(image);
//    label.setBounds(600,600);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);
    label.setBackground(Color.DARK_GRAY);
    label.setOpaque(true);
//        label.setBorder(border);
    frame.setLayout(new GridLayout(8,8,0,0));
    
//    HashMap
    
//    for (int i = 0; i<64; i++) {
//
////        JButton b1 = new JButton(String.valueOf(i));
////        JButton b2 = new JButton(String.valueOf(i));
////        b1.setIcon();
////        b2.setIcon();
//
//
//        ImageIcon image1 = new ImageIcon
//                ("C:\\p\\Projects\\v_control\\Chess\\src\\Game\\GUI\\Images\\brown1.png");
//        JLabel l1 = new JLabel();
//        l1.setIcon(image1);
//        frame.add(l1);
//        ImageIcon image2 = new ImageIcon
//                ("C:\\p\\Projects\\v_control\\Chess\\src\\Game\\GUI\\Images\\brown2.png");
//        JLabel l2 = new JLabel();
//        l2.setIcon(image2);
//        frame.add(l2);
//    }
    frame.add(label);
//    getPawnLabels();
    frame.pack();
}
// pieces as buttons?

public static class Labels {
    
    static HashMap<Piece, JLabel> pieceLabels = new HashMap<>();
    
    public static void getPawnLabels() {
        
        for (int i = 0; i < 8; i++) {
            Pawn p1 = new Pawn(i, i, 1, 1);
            JLabel label1 = new JLabel();
            label1.setBounds(600+i*60,700,100,100);
            ImageIcon icon1 = new ImageIcon("C:\\p\\Projects\\v_control\\Chess\\src\\Game\\GUI\\Images\\pawnW.png");
            label1.setIcon(icon1);
            pieceLabels.put(p1, label1);
            frame.add(label1);
            JLabel label2 = new JLabel();
            label2.setBounds(630+i*60,200,100,100);
            Pawn p2 = new Pawn(i, i, 7, 2);
            ImageIcon icon2 = new ImageIcon("C:\\p\\Projects\\v_control\\Chess\\src\\Game\\GUI\\Images\\pawnB.png");
            label2.setIcon(icon2);
            pieceLabels.put(p2, label1);
            frame.add(label2);
            boardObjects[i][1] = p1;
            boardObjects[i][7] = p2;
            
            System.out.println(i);
        
        }
        
        
    }
    
}
}