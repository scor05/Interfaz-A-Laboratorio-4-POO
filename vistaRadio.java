/*
 * @version 14/10/2024
 */

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class vistaRadio {
    public void offMenu(JFrame frame, ClaseA radio){
		JButton onBtn = new JButton("");
        Image onBtnImg = new ImageIcon(getClass().getResource("/resources/onBtn.png")).getImage();
		onBtn.setIcon(new ImageIcon(onBtnImg));
        onBtn.setOpaque(false);
        onBtn.setContentAreaFilled(false);
        onBtn.setBorderPainted(false);
		onBtn.setBounds(846, 49, 360, 141);
        frame.getContentPane().add(onBtn);

    }
}
