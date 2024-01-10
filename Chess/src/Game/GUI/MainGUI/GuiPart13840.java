package Game.GUI.MainGUI;
import Game.Board;
import Game.Pieces.Piece;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import static Game.Board.boardObjects;

public class GuiPart13840 extends JFrame {

private JPanel panelMain;
private JButton startButton;

public GuiPart13840() {
        setContentPane(panelMain);
        setTitle("ur gay");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        }
        
        
        
        private static class TablePieces extends JFrame {
                
                private final Object boardObjects = Board.boardObjects;
                
                public TablePieces() {
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                    JTable t1 = new JTable((TableModel) boardObjects);
                    JTable t2 = new JTable(8,8);
                    t2.setRowHeight(30);
                    t2.setRowHeight(1, 20);
                    t2.setIntercellSpacing(new Dimension(10, 10));
                    t2.setGridColor(Color.blue);
                    t2.setShowVerticalLines(false);
                        Vector<Vector<String>> data = new Vector<Vector<String>>();
                        // Вектор с заголовками столбцов
                        Vector<String> header = new Vector<String>();
                        // Формирование в цикле массива данных
                        for (int j = 0; j < boardObjects.length; j++) {
                                header.add((Piece)columnsHeader[j]);
                                Vector<Piece> row = new Vector<Piece>();
                                for (int i = 0; i < boardObjects[j].length; i++) {
                                        row.add((Piece)boardObjects[j][i]);
                                }
                                data.add(row);
                        }
                        // Таблица на основе вектора
                        JTable table3 = new JTable(data, header);
                        // Размещение таблиц в панели с блочным расположением
                        Box contents = new Box(BoxLayout.Y_AXIS);
                        contents.add(new JScrollPane(t1));
                        contents.add(new JScrollPane(t2));
                        
                        // Настройка таблицы table3 - цвет фона, цвет выделения
                        table3.setForeground(Color.red);
                        table3.setSelectionForeground(Color.yellow);
                        table3.setSelectionBackground(Color.blue);
                        // Скрытие сетки таблицы
                        table3.setShowGrid(false);
                        // contents.add(new JScrollPane(table3));
                        contents.add(table3);
                        // Вывод окна на экран
                        setContentPane(contents);
                        setSize(500, 400);
                        setVisible(true);
                }
                
                

        }

public static void main(String[] args) {
        TablePieces table = new TablePieces();
}
}