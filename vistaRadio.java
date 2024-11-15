/*
 * @version 14/10/2024
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class vistaRadio {
    private ClaseA radio;
    private ArrayList<Component> componentes = new ArrayList<>();

    public vistaRadio(ClaseA radio) {
        this.radio = radio;
    }
    public void drawMainButtons(JFrame frame){
		JButton onBtn = new JButton("");
        Image offBtnImg = new ImageIcon(getClass().getResource("/resources/offBtn.png")).getImage();
        Image offBtnImgHover = new ImageIcon(getClass().getResource("/resources/offBtnHover.png")).getImage();
        Image onBtnImg = new ImageIcon(getClass().getResource("/resources/onBtn.png")).getImage();
        Image onBtnImgHover = new ImageIcon(getClass().getResource("/resources/onBtnHover.png")).getImage();

        JLabel prueba123 = new JLabel("Texto prueba");
        prueba123.setFont(new Font("Arial", Font.BOLD, 50));
        prueba123.setForeground(Color.WHITE);
        prueba123.setBounds(800, 10, 360, 141);
        componentes.add(prueba123);
        frame.getContentPane().add(prueba123);
        
        onBtn.setIcon(new ImageIcon(offBtnImg));
        onBtn.setOpaque(false);
        onBtn.setContentAreaFilled(false);
        onBtn.setBorderPainted(false);
        onBtn.setRolloverIcon(new ImageIcon(offBtnImgHover));
		onBtn.setBounds(800, 49, 360, 141);
        onBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
                radio.onOff(true);
                if (radio.isEncendido()){
                    onBtn.setIcon(new ImageIcon(onBtnImg));
                    onBtn.setRolloverIcon(new ImageIcon(onBtnImgHover));
                    for (Component c : componentes){
                        frame.add(c);
                    }
                }else{
                    onBtn.setIcon(new ImageIcon(offBtnImg));
                    onBtn.setRolloverIcon(new ImageIcon(offBtnImgHover));
                    for (Component c : frame.getContentPane().getComponents()){
                        if (c != onBtn){
                            frame.remove(c);
                        }
                    }
                }
            }
		});
        frame.getContentPane().add(onBtn);
        frame.getContentPane().repaint();

    }
}
