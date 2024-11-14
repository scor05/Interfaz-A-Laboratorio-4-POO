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
        frame.setBackground(new Color(0, 0, 0));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    vistaRadio vista = new vistaRadio();
                    vista.offMenu(frame, radio);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}
