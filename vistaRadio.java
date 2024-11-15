/*
 * @version 14/10/2024
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class vistaRadio {
    private ClaseA radio;
    private ArrayList<Component> componentes = new ArrayList<>();
    private final Font STATUSFONT = cargarFuente("/resources/font/digital-7.ttf", Font.PLAIN, 80);
    private final Font EVENTFONT = cargarFuente("/resources/font/digital-7.ttf", Font.PLAIN, 60);
    private final Font BUTTONFONT = cargarFuente("/resources/font/digital-7.ttf", Font.PLAIN, 50);

    public vistaRadio(ClaseA radio) {
        this.radio = radio;
    }
    public void drawMainButtons(JFrame frame){
		JButton onBtn = new JButton("");
        Image offBtnImg = new ImageIcon(getClass().getResource("/resources/img/offBtn.png")).getImage();
        Image offBtnImgHover = new ImageIcon(getClass().getResource("/resources/img/offBtnHover.png")).getImage();
        Image onBtnImg = new ImageIcon(getClass().getResource("/resources/img/onBtn.png")).getImage();
        Image onBtnImgHover = new ImageIcon(getClass().getResource("/resources/img/onBtnHover.png")).getImage();

        String modoString;
        switch (radio.getModo()){
            case 1:
                modoString = "Radio";
                break;
            case 2:
                modoString = "Reproducción";
                break;
            case 3:
                modoString = "Teléfono";
                break;
            case 4:
                modoString = "Productividad";
                break;
            default:
                modoString = "Radio";
        }
        JLabel modeLbl = new JLabel("Modo actual: " + modoString);
        modeLbl.setFont(STATUSFONT);
        modeLbl.setForeground(Color.RED);
        modeLbl.setBounds(660, 200, 800, 141);
        componentes.add(modeLbl);

        JLabel eventLabel = new JLabel("Llamando a: ");
        eventLabel.setFont(EVENTFONT);
        eventLabel.setForeground(Color.RED);
        eventLabel.setBackground(Color.BLACK);
        eventLabel.setOpaque(true); 

        JScrollPane eventTextPane = new JScrollPane(eventLabel);
		eventTextPane.setBounds(665, 359, 588, 125);
		componentes.add(eventTextPane);

        JButton btnModoRadio = new JButton("Radio");
        btnModoRadio.setFont(BUTTONFONT);
		btnModoRadio.setBackground(Color.BLACK);
        btnModoRadio.setContentAreaFilled(false);
        btnModoRadio.setForeground(Color.RED);
		btnModoRadio.setBounds(460, 524, 201, 85);
		componentes.add(btnModoRadio);
		
		JButton btnModoRep = new JButton("Reproducción");
        btnModoRep.setFont(BUTTONFONT);
		btnModoRep.setBackground(Color.BLACK);
        btnModoRep.setContentAreaFilled(false);
        btnModoRep.setForeground(Color.RED);
		btnModoRep.setBounds(670, 524, 300, 85);
		componentes.add(btnModoRep);
		
		JButton btnModoTelfono = new JButton("Telefono");
        btnModoTelfono.setFont(BUTTONFONT);
		btnModoTelfono.setBackground(Color.BLACK);
        btnModoTelfono.setContentAreaFilled(false);
        btnModoTelfono.setForeground(Color.RED);
		btnModoTelfono.setBounds(980, 524, 230, 85);
		componentes.add(btnModoTelfono);
		
		JButton btnModoProductividad = new JButton("Productividad");
        btnModoProductividad.setFont(BUTTONFONT);
		btnModoProductividad.setBackground(Color.DARK_GRAY);
        btnModoProductividad.setOpaque(true);   
        btnModoProductividad.setForeground(Color.RED);
		btnModoProductividad.setBounds(1220, 524, 315, 85);
		componentes.add(btnModoProductividad);
        
        onBtn.setIcon(new ImageIcon(offBtnImg));
        onBtn.setOpaque(false);
        onBtn.setContentAreaFilled(false);
        onBtn.setBorderPainted(false);
        onBtn.setRolloverIcon(new ImageIcon(offBtnImgHover));
        onBtn.setPressedIcon(new ImageIcon(offBtnImgHover));
		onBtn.setBounds(780, 49, 360, 141);
        onBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
                radio.onOff(true);
                if (radio.isEncendido()){
                    onBtn.setIcon(new ImageIcon(onBtnImg));
                    onBtn.setRolloverIcon(new ImageIcon(onBtnImgHover));
                    onBtn.setPressedIcon(new ImageIcon(onBtnImgHover));
                    for (Component c : componentes){
                        frame.add(c);
                    }
                }else{
                    onBtn.setIcon(new ImageIcon(offBtnImg));
                    onBtn.setRolloverIcon(new ImageIcon(offBtnImgHover));
                    onBtn.setPressedIcon(new ImageIcon(offBtnImgHover));
                    for (Component c : frame.getContentPane().getComponents()){
                        if (c != onBtn){
                            frame.remove(c);
                        }
                    }
                }
                frame.revalidate();
                frame.repaint();
            }
		});
        frame.getContentPane().add(onBtn);
        frame.getContentPane().repaint();
    }

    private static Font cargarFuente(String fontPath, int style, int size) {
        try (InputStream fontStream = vistaRadio.class.getResourceAsStream(fontPath)) {
            if (fontStream == null) {
                throw new IllegalArgumentException("Fuente no encontrada en la ruta " + fontPath);
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            return font.deriveFont(style, size);
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("Serif", style, size);
        }
    }
}
