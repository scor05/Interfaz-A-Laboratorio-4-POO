/*
 * @version 14/10/2024
 */

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

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
