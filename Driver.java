/*
 * @version 14/10/2024
 */

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Driver {
    public static void main(String[] args) {
        ClaseA radio = new ClaseA();

        JFrame frame = new JFrame("Interfaz A Laboratorio 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);

        UIManager.put("Button.select", Color.BLACK);
		UIManager.put("Button.focus", Color.BLACK);
        UIManager.put("ScrollPane.border", new LineBorder(Color.RED, 4));
        UIManager.put("TextField.border", new LineBorder(Color.RED, 4));
        UIManager.put("ScrollPane.border", new LineBorder(Color.RED, 4));
        UIManager.put("ScrollPane.background", Color.BLACK);
        UIManager.put("ComboBox.background", Color.BLACK);
        UIManager.put("ComboBox.foreground", Color.RED);
        UIManager.put("ComboBox.selectionBackground", Color.DARK_GRAY);
        UIManager.put("ComboBox.selectionForeground", Color.RED);
        UIManager.put("ComboBox.border", new LineBorder(Color.RED, 4));
        UIManager.put("List.background", Color.BLACK);
        UIManager.put("List.foreground", Color.RED);
        UIManager.put("List.selectionBackground", Color.DARK_GRAY);
        UIManager.put("List.selectionForeground", Color.RED);
        UIManager.put("List.border", new LineBorder(Color.RED, 2));

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    vistaRadio vista = new vistaRadio(radio);
                    vista.drawMainButtons(frame);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}
