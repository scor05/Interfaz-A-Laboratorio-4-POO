/**
 * @version 14/10/2024
 */

import java.util.ArrayList;
import java.util.List;

public class ClaseA implements IRadio {
    private boolean encendido;
    private int volumen;
    // (1 modo radio, 2 reproducción, 3 teléfono, 4 productividad)
    private int modo;
    private int frecuencia;
    private double emisora;
    private ArrayList<ArrayList<String>> playlists;
    private boolean telefono;
    private boolean speakerAuri;
    private ArrayList<String> contactos;
    private String viaje;
    
    public ClaseA() {
        this.encendido = false;
        this.volumen = 0;
        this.modo = 0;
        this.frecuencia = 0;
        this.emisora = 0;
        this.playlists = new ArrayList<>();
        this.telefono = false;
        this.speakerAuri = false;
        this.contactos = new ArrayList<>();
        this.viaje = "";

        ArrayList<String> rockSongs = new ArrayList<>(List.of(
            "Bohemian Rhapsody - Queen | Duración: 5:55",
            "Stairway to Heaven - Led Zeppelin | Duración: 8:02",
            "Hotel California - Eagles | Duración: 6:30",
            "Sweet Child O' Mine - Guns N' Roses | Duración: 5:56",
            "Back in Black - AC/DC | Duración: 4:15",
            "Smoke on the Water - Deep Purple | Duración: 5:40",
            "Livin' on a Prayer - Bon Jovi | Duración: 4:09",
            "Born to Run - Bruce Springsteen | Duración: 4:31",
            "Purple Haze - Jimi Hendrix | Duración: 2:50",
            "Paranoid - Black Sabbath | Duración: 2:48"
        ));

        ArrayList<String> hipHopSongs = new ArrayList<>(List.of(
            "Lose Yourself - Eminem | Duración: 5:26",
            "Juicy - The Notorious B.I.G. | Duración: 5:02",
            "N.Y. State of Mind - Nas | Duración: 4:54",
            "C.R.E.A.M. - Wu-Tang Clan | Duración: 4:12",
            "California Love - 2Pac | Duración: 4:45",
            "HUMBLE. - Kendrick Lamar | Duración: 2:57",
            "99 Problems - Jay-Z | Duración: 3:54",
            "Still D.R.E. - Dr. Dre | Duración: 4:34",
            "Sicko Mode - Travis Scott | Duración: 5:12",
            "God's Plan - Drake | Duración: 3:18"
        ));

        ArrayList<String> classicalSongs = new ArrayList<>(List.of(
            "Symphony No. 9 - Beethoven | Duración: 12:33",
            "The Four Seasons: Spring - Vivaldi | Duración: 3:30",
            "Clair de Lune - Debussy | Duración: 5:15",
            "Canon in D - Pachelbel | Duración: 6:03",
            "Eine kleine Nachtmusik - Mozart | Duración: 5:52",
            "Swan Lake Theme - Tchaikovsky | Duración: 8:47",
            "The Planets: Jupiter - Holst | Duración: 7:12",
            "Boléro - Ravel | Duración: 15:10",
            "Carmina Burana: O Fortuna - Orff | Duración: 2:48",
            "Moonlight Sonata - Beethoven | Duración: 14:15"
        ));

        this.playlists.add(rockSongs);
        this.playlists.add(hipHopSongs);
        this.playlists.add(classicalSongs);
    }

    @Override
    public void onOff(boolean value) {
        this.encendido = !this.encendido;
    }

    public void cambiarVolumen(boolean value) {
        if (value) {
            this.volumen++;
        } else {
            this.volumen--;
        }
    }

    public void cambiarModo(int mode) {
        if (!(mode < 0 || mode > 4)) {
            this.modo = mode;
        }
    }

    public void amFm(boolean value) {
        if (value) {
            setFrecuencia(1);
        }else {
            setFrecuencia(2);
        }
    }
	
    public void cambiarEmi(double emisora) {
        setEmisora(emisora);
    }

    public boolean isEncendido() {
        return this.encendido;
    }

    public boolean getEncendido() {
        return this.encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public int getVolumen() {
        return this.volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getModo() {
        return this.modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public int getFrecuencia() {
        return this.frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public double getEmisora() {
        return this.emisora;
    }

    public void setEmisora(double emisora) {
        this.emisora = emisora;
    }

    public ArrayList<ArrayList<String>> getPlaylists() {
        return this.playlists;
    }

    public void setPlaylists(ArrayList<ArrayList<String>> playlists) {
        this.playlists = playlists;
    }

    public boolean isTelefono() {
        return this.telefono;
    }

    public boolean getTelefono() {
        return this.telefono;
    }

    public void setTelefono(boolean telefono) {
        this.telefono = telefono;
    }

    public boolean isSpeakerAuri() {
        return this.speakerAuri;
    }

    public boolean getSpeakerAuri() {
        return this.speakerAuri;
    }

    public void setSpeakerAuri(boolean speakerAuri) {
        this.speakerAuri = speakerAuri;
    }

    public ArrayList<String> getContactos() {
        return this.contactos;
    }

    public void setContactos(ArrayList<String> contactos) {
        this.contactos = contactos;
    }

    public String getViaje() {
        return this.viaje;
    }

    public void setViaje(String viaje) {
        this.viaje = viaje;
    }
	
	public String getModoConvertido(){
		if(modo==1){
			return "Radio";
		}
		else if(modo==2){
			return "Reproducción";
		}
		else if(modo==3){
			return "Telefono";
		}
		else if(modo==4){
			return "Productividad";
		}else{
            return "Ninguno";
        }
	}
	
	public String frecuenciaConvertida(){
		if(frecuencia ==1){
			return "AM";
		}
		else{	
			return "FM";
		}
		
	}

    @Override
    public String toString() {
        return "{" +
            " encendido='" + encendido + "'" +
            ", volumen='" + volumen + "'" +
            ", modo='" + modo + "'" +
            ", frecuencia='" + frecuencia + "'" +
            ", emisora='" + emisora + "'" +
            ", playlists='" + playlists + "'" +
            ", telefono='" + telefono + "'" +
            ", speakerAuri='" + speakerAuri + "'" +
            ", contactos='" + contactos + "'" +
            ", viaje='" + viaje + "'" +
            "}";
    }


}
