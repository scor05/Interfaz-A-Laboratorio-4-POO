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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

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
        
        JLabel modeLbl = new JLabel("Modo actual: " + radio.getModoConvertido());
        modeLbl.setFont(STATUSFONT);
        modeLbl.setForeground(Color.RED);
        modeLbl.setBounds(660, 200, 800, 141);
		modeLbl.setBackground(Color.BLACK);
		modeLbl.setOpaque(true);
        componentes.add(modeLbl);

        JLabel eventLabel = new JLabel(radio.frecuenciaConvertida()+" | Esta sonando: ");
        eventLabel.setFont(EVENTFONT);
        eventLabel.setForeground(Color.RED);
        eventLabel.setBackground(Color.BLACK);
        eventLabel.setOpaque(true); 
		
		//Boton am y fm
		JButton am = new JButton("AM/FM");
		am.setFont(BUTTONFONT);
		am.setContentAreaFilled(true);
		am.setForeground(Color.RED);
		am.setBounds(1350,375,200,100);
		componentes.add(am);
		am.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radio.getFrecuencia()==1){ //Se cambia de am a fm 
					radio.amFm(false);
				}
				else{
					radio.amFm(true);
				}
				eventLabel.setText(radio.frecuenciaConvertida()+" | Esta sonando: ");
				eventLabel.setFont(EVENTFONT);
				eventLabel.setForeground(Color.RED);
				eventLabel.setBackground(Color.BLACK);
				eventLabel.setOpaque(true); 
			}
		});
		
		JButton nextStation = new JButton(">");
        nextStation.setFont(BUTTONFONT);
        nextStation.setContentAreaFilled(true);
        nextStation.setForeground(Color.RED);
        nextStation.setBounds(1300, 300, 80, 60);
        componentes.add(nextStation);
        nextStation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                radio.siguienteEmisora();
                eventLabel.setText(radio.frecuenciaConvertida() + " | Esta sonando: ");
            }
        });

        JButton prevStation = new JButton("<");
        prevStation.setFont(BUTTONFONT);
        prevStation.setContentAreaFilled(true);
        prevStation.setForeground(Color.RED);
        prevStation.setBounds(1200, 300, 80, 60);
        componentes.add(prevStation);
        prevStation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                radio.anteriorEmisora();
                eventLabel.setText(radio.frecuenciaConvertida() + " | Esta sonando: ");
            }
        });

        // Botones para guardar y cargar emisoras
        JButton saveStation = new JButton("Guardar");
        saveStation.setFont(BUTTONFONT);
        saveStation.setContentAreaFilled(true);
        saveStation.setForeground(Color.RED);
        saveStation.setBounds(460, 375, 180, 60);
        componentes.add(saveStation);
        saveStation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                radio.guardarEmisora();
            }
        });

        JButton loadStation = new JButton("Cargar");
        loadStation.setFont(BUTTONFONT);
        loadStation.setContentAreaFilled(true);
        loadStation.setForeground(Color.RED);
        loadStation.setBounds(460, 450, 180, 60);
        componentes.add(loadStation);
        loadStation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoEmisoras(frame);
            }
        });
		
		
        JScrollPane eventTextPane = new JScrollPane(eventLabel);
		eventTextPane.setBounds(665, 359, 588, 125);
		componentes.add(eventTextPane);

        JButton btnModoRadio = new JButton("Radio");
        btnModoRadio.setFont(BUTTONFONT);
		btnModoRadio.setContentAreaFilled(true);
        btnModoRadio.setForeground(Color.RED);
		btnModoRadio.setBounds(460, 524, 201, 85);
		componentes.add(btnModoRadio);
		btnModoRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radio.setModo(1);
				modeLbl.setText("Modo actual: " + radio.getModoConvertido());
				modeLbl.setFont(STATUSFONT);
				modeLbl.setForeground(Color.RED);
				modeLbl.setBounds(660, 200, 800, 141);
				modeLbl.setBackground(Color.BLACK);
				modeLbl.setOpaque(true);
				componentes.add(modeLbl);
			}
		});
		
		JButton btnModoRep = new JButton("Reproducción");
        btnModoRep.setFont(BUTTONFONT);
		btnModoRep.setBackground(Color.BLACK);
        btnModoRep.setContentAreaFilled(true);
        btnModoRep.setForeground(Color.RED);
		btnModoRep.setBounds(670, 524, 300, 85);
		componentes.add(btnModoRep);
		btnModoRep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radio.setModo(2);
				modeLbl.setText("Modo actual: " + radio.getModoConvertido());
				modeLbl.setFont(STATUSFONT);
				modeLbl.setForeground(Color.RED);
				modeLbl.setBounds(660, 200, 800, 141);
				modeLbl.setBackground(Color.BLACK);
				modeLbl.setOpaque(true);
				componentes.add(modeLbl);
			}
		});
		
		JButton btnModoProductividad = new JButton("Productividad");
		btnModoProductividad.setFont(BUTTONFONT);
		btnModoProductividad.setBackground(Color.BLACK); 
		btnModoProductividad.setContentAreaFilled(true); // Similar al resto
		btnModoProductividad.setForeground(Color.RED);
		btnModoProductividad.setBounds(1220, 524, 315, 85);
		componentes.add(btnModoProductividad);
		btnModoProductividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radio.setModo(4);
				modeLbl.setText("Modo actual: " + radio.getModoConvertido());
				modeLbl.setFont(STATUSFONT);
				modeLbl.setForeground(Color.RED);
				modeLbl.setBounds(660, 200, 800, 141);
				modeLbl.setBackground(Color.BLACK);
				modeLbl.setOpaque(true);
				componentes.add(modeLbl);
			}
		});
		
		JButton btnModoTelfono = new JButton("Telefono");
        btnModoTelfono.setFont(BUTTONFONT);
		btnModoTelfono.setBackground(Color.BLACK);
        btnModoTelfono.setContentAreaFilled(true);
        btnModoTelfono.setForeground(Color.RED);
		btnModoTelfono.setBounds(980, 524, 230, 85);
		componentes.add(btnModoTelfono);
		btnModoTelfono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radio.setModo(3);
				modeLbl.setText("Modo actual: " + radio.getModoConvertido());
				modeLbl.setFont(STATUSFONT);
				modeLbl.setForeground(Color.RED);
				modeLbl.setBounds(660, 200, 800, 141);
				modeLbl.setBackground(Color.BLACK);
				modeLbl.setOpaque(true);
				componentes.add(modeLbl);
			}
		});
		
        //Funcionamiento del botón on/off
        onBtn.setIcon(new ImageIcon(offBtnImg));
        onBtn.setOpaque(false);
        onBtn.setContentAreaFilled(false);
        onBtn.setBorderPainted(false);
        onBtn.setRolloverIcon(new ImageIcon(offBtnImgHover));
        onBtn.setPressedIcon(new ImageIcon(offBtnImgHover));
		onBtn.setBounds(780, 49, 360, 141);
        onBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
                radio.onOff(true); //Cada vez que se presione el botón se cambia su estado
                if (radio.isEncendido()){ //Si la radio se encendió 'true', se presenta toda la interfaz gráfica de la radio
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
	
	private void mostrarDialogoEmisoras(JFrame parentFrame) {
        if (radio.getEmisorasGuardadas().isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame, 
                "No hay emisoras guardadas", 
                "Error", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Crear diálogo personalizado
        JDialog dialog = new JDialog(parentFrame, "Seleccionar Emisora", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(300, 400);
        dialog.setLocationRelativeTo(parentFrame);

        // Panel principal con scroll
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(Color.BLACK);

        // Título
        JLabel titleLabel = new JLabel("Emisoras Guardadas");
        titleLabel.setFont(BUTTONFONT);
        titleLabel.setForeground(Color.RED);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Crear botones para cada emisora guardada
        for (Double emisora : radio.getEmisorasGuardadas()) {
            JButton emisoraBtn = new JButton(formatearEmisora(emisora));
            emisoraBtn.setFont(BUTTONFONT);
            emisoraBtn.setForeground(Color.RED);
            emisoraBtn.setBackground(Color.BLACK);
            emisoraBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            emisoraBtn.setMaximumSize(new Dimension(200, 50));
            
            emisoraBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    radio.cargarEmisoraEspecifica(emisora);
                    actualizarInterfaz();
                    dialog.dispose();
                }
            });

            mainPanel.add(emisoraBtn);
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // Botón de cerrar
        JButton closeButton = new JButton("Cerrar");
        closeButton.setFont(BUTTONFONT);
        closeButton.setForeground(Color.RED);
        closeButton.setBackground(Color.BLACK);
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(e -> dialog.dispose());
        
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(closeButton);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBackground(Color.BLACK);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        dialog.add(scrollPane);

        dialog.setVisible(true);
    }

    private String formatearEmisora(double emisora) {
        if (radio.getFrecuencia() == 1) {
            return String.format("AM %.0f", emisora);
        } else {
            return String.format("FM %.1f", emisora);
        }
    }

    private void actualizarInterfaz() {
        for (Component c : componentes) {
            if (c instanceof JLabel && ((JLabel) c).getText().startsWith(radio.frecuenciaConvertida())) {
                ((JLabel) c).setText(radio.frecuenciaConvertida() + " | Esta sonando: ");
            }
        }
    }
}
