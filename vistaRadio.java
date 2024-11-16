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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class vistaRadio {
    private ClaseA radio;
    private ArrayList<Component> componentes = new ArrayList<>();
    private ArrayList<Component> componentesEspecificos = new ArrayList<>();
    private final Font STATUSFONT = cargarFuente("/resources/font/digital-7.ttf", Font.PLAIN, 80);
    private final Font EVENTFONT = cargarFuente("/resources/font/digital-7.ttf", Font.PLAIN, 60);
    private final Font BUTTONFONT = cargarFuente("/resources/font/digital-7.ttf", Font.PLAIN, 50);
    private final Font TEXTFONT = cargarFuente("/resources/font/digital-7.ttf", Font.PLAIN, 30);

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
        modeLbl.setBounds(600, 200, 900, 141);
		modeLbl.setBackground(Color.BLACK);
		modeLbl.setOpaque(true);
        componentes.add(modeLbl);

        JLabel eventLabel = new JLabel();
        eventLabel.setFont(EVENTFONT);
        eventLabel.setForeground(Color.RED);
        eventLabel.setBackground(Color.BLACK);
        eventLabel.setOpaque(true); 
		
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
                if (radio.getModo() != 1){
                    if (!componentesEspecificos.isEmpty()) {
                        ArrayList<Component> copiaEspecificos = new ArrayList<>(componentesEspecificos);
                        for (Component c : copiaEspecificos) {
                            componentes.remove(c);
                            componentesEspecificos.remove(c);
                            frame.remove(c);
                        }
                    }
                    eventLabel.setText("");
                    frame.repaint();
                    radio.setModo(1);
                    modeLbl.setText("Modo actual: " + radio.getModoConvertido());
                    modoRadio(frame, eventLabel);
                }
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
                if (radio.getModo() != 2){
                    if (!componentesEspecificos.isEmpty()) {
                        ArrayList<Component> copiaEspecificos = new ArrayList<>(componentesEspecificos);
                        for (Component c : copiaEspecificos) {
                            componentes.remove(c);
                            componentesEspecificos.remove(c);
                            frame.remove(c);
                        }
                    }
                    eventLabel.setText("");
                    frame.repaint();
                    radio.setModo(2);
                    modeLbl.setText("Modo actual: " + radio.getModoConvertido());
                    modoReproduccion(frame, eventLabel);
                }
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
                if (radio.getModo() != 3){
                    if (!componentesEspecificos.isEmpty()) {
                        ArrayList<Component> copiaEspecificos = new ArrayList<>(componentesEspecificos);
                        for (Component c : copiaEspecificos) {
                            componentes.remove(c);
                            componentesEspecificos.remove(c);
                            frame.remove(c);
                        }
                    }
                    eventLabel.setText("");
                    frame.repaint();
                    radio.setModo(3);
                    modeLbl.setText("Modo actual: " + radio.getModoConvertido());
                }
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
                if (radio.getModo() != 4){
                    if (!componentesEspecificos.isEmpty()) {
                        ArrayList<Component> copiaEspecificos = new ArrayList<>(componentesEspecificos);
                        for (Component c : copiaEspecificos) {
                            componentes.remove(c);
                            componentesEspecificos.remove(c);
                            frame.remove(c);
                        }
                    }
                    eventLabel.setText("");
                    frame.repaint();
                    radio.setModo(4);
                    modeLbl.setText("Modo actual: " + radio.getModoConvertido());
                    componentes.add(modeLbl);
                }
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

    public void modoReproduccion(JFrame frame, JLabel eventLabel){

        Image leftBtnImg = new ImageIcon(getClass().getResource("/resources/img/backPlaylistBtn.png")).getImage();
        Image leftBtnImgHover = new ImageIcon(getClass().getResource("/resources/img/backPlaylistBtnHover.png")).getImage();
        Image rightBtnImg = new ImageIcon(getClass().getResource("/resources/img/backPlaylistBtnRight.png")).getImage();
        Image rightBtnImgHover = new ImageIcon(getClass().getResource("/resources/img/backPlaylistBtnHoverRight.png")).getImage();

        JLabel playlistsLbl = new JLabel("Listas de reproducción:");
        playlistsLbl.setFont(BUTTONFONT);
        playlistsLbl.setForeground(Color.RED);
        playlistsLbl.setBackground(Color.BLACK);
        playlistsLbl.setBounds(720, 600, 800, 141);
        componentesEspecificos.add(playlistsLbl);
        componentes.add(playlistsLbl);
        frame.getContentPane().add(playlistsLbl);
        frame.repaint();

        JList<String> playlistsList = new JList<String>();
        playlistsList.setFont(TEXTFONT);
        playlistsList.setForeground(Color.RED);
        

        JScrollPane playlistsScrollPane = new JScrollPane(playlistsList);
        playlistsScrollPane.setViewportView(playlistsList);
        playlistsScrollPane.setBounds(700, 700, 500, 200);
        playlistsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        playlistsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        componentes.add(playlistsScrollPane);
        componentesEspecificos.add(playlistsScrollPane);
        frame.getContentPane().add(playlistsScrollPane);
        frame.repaint(); 

        JComboBox<String> playlistTitlesComboBox = new JComboBox<String>();
        playlistTitlesComboBox.setToolTipText("Escoja una de las opciones siguientes");
		playlistTitlesComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Rock", "Hip Hop", "Clásicas"}));
		playlistTitlesComboBox.setFont(TEXTFONT);
        playlistTitlesComboBox.setForeground(Color.RED);
        playlistTitlesComboBox.setBackground(Color.BLACK);
		playlistTitlesComboBox.setBounds(1210, 655, 150, 30);
		playlistTitlesComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String seleccionada = (String) playlistTitlesComboBox.getSelectedItem();
                String[] rockPlaylist = new String[10];
                String[] hipHopPlaylist = new String[10];
                String[] classicalPlaylist = new String[10];

                for (int i = 0; i < 10; i++) {
                    rockPlaylist[i] = radio.getPlaylists().get(0).get(i);
                    hipHopPlaylist[i] = radio.getPlaylists().get(1).get(i);
                    classicalPlaylist[i] = radio.getPlaylists().get(2).get(i);
                }

                if (seleccionada.equals("Rock")){
                    playlistsList.setListData(rockPlaylist);
                }
                else if (seleccionada.equals("Hip Hop")){
                    playlistsList.setListData(hipHopPlaylist);
                }
                else if (seleccionada.equals("Clásicas")){
                    playlistsList.setListData(classicalPlaylist);
                }
            }
        });

        playlistsList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (playlistsList.getSelectedIndex() != -1){
                    String seleccionada = (String) playlistsList.getSelectedValue();
                    eventLabel.setText("Esta sonando: " + seleccionada);
                }
            }
        });

        JButton backPlaylistBtn = new JButton("");
        backPlaylistBtn.setIcon(new ImageIcon(leftBtnImg));
        backPlaylistBtn.setOpaque(false);
        backPlaylistBtn.setContentAreaFilled(false);
        backPlaylistBtn.setBorderPainted(false);
        backPlaylistBtn.setRolloverIcon(new ImageIcon(leftBtnImgHover));
        backPlaylistBtn.setPressedIcon(new ImageIcon(leftBtnImgHover));
        backPlaylistBtn.setBounds(580, 390, 70, 70);
        componentes.add(backPlaylistBtn);
        componentesEspecificos.add(backPlaylistBtn);
        frame.getContentPane().add(backPlaylistBtn);
        frame.repaint();
        backPlaylistBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (playlistsList.getSelectedIndex() > 0){
                    playlistsList.setSelectedIndex(playlistsList.getSelectedIndex() - 1);
                }else{
                    JOptionPane.showMessageDialog(null, "Ya está en la primera canción.");
                }
            }
        });


        JButton nextPlaylistBtn = new JButton("");
        nextPlaylistBtn.setIcon(new ImageIcon(rightBtnImg));
        nextPlaylistBtn.setOpaque(false);
        nextPlaylistBtn.setContentAreaFilled(false);
        nextPlaylistBtn.setBorderPainted(false);
        nextPlaylistBtn.setRolloverIcon(new ImageIcon(rightBtnImgHover));
        nextPlaylistBtn.setPressedIcon(new ImageIcon(rightBtnImgHover));
        nextPlaylistBtn.setBounds(1268, 390, 70, 70);
        componentes.add(nextPlaylistBtn);
        componentesEspecificos.add(nextPlaylistBtn);
        frame.getContentPane().add(nextPlaylistBtn);
        frame.repaint();
        nextPlaylistBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (playlistsList.getSelectedIndex() < playlistsList.getModel().getSize() - 1){
                    playlistsList.setSelectedIndex(playlistsList.getSelectedIndex() + 1);
                }else{
                    JOptionPane.showMessageDialog(null, "Ya está en la última canción.");
                }
            }
        });

        componentesEspecificos.add(playlistTitlesComboBox);
        componentes.add(playlistTitlesComboBox);
        frame.getContentPane().add(playlistTitlesComboBox);
        frame.repaint();
        

        
    }

    public void modoRadio(JFrame frame, JLabel eventLabel){
        //Boton am y fm
		JButton am = new JButton("AM/FM");
		am.setFont(BUTTONFONT);
		am.setContentAreaFilled(true);
		am.setForeground(Color.RED);
		am.setBounds(1300,375,200,100);
        componentes.add(am);
		componentesEspecificos.add(am);
        frame.getContentPane().add(am);
        frame.repaint();
		am.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radio.getFrecuencia()==1){ //Se cambia de am a fm 
					radio.amFm(false);
				}
				else{
					radio.amFm(true);
				}
				eventLabel.setText(radio.frecuenciaConvertida()+" | Esta sonando: ");
			}
		});
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
