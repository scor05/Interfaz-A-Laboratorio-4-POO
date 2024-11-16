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
        this.modo = 1;
        this.frecuencia = 0;
        this.emisora = 0;
        this.playlists = new ArrayList<>();
        this.telefono = false;
        this.speakerAuri = false;
        this.contactos = new ArrayList<>();
        this.viaje = "";

        ArrayList<String> rockSongs = new ArrayList<>(List.of(
            "Bohemian Rhapsody - Queen",
            "Stairway to Heaven - Led Zeppelin",
            "Hotel California - Eagles",
            "Sweet Child O' Mine - Guns N' Roses",
            "Smoke on the Water - Deep Purple",
            "Back in Black - AC/DC",
            "Livin' on a Prayer - Bon Jovi",
            "Comfortably Numb - Pink Floyd",
            "Wonderwall - Oasis",
            "November Rain - Guns N' Roses"
        ));

        ArrayList<String> hipHopSongs = new ArrayList<>(List.of(
            "Lose Yourself - Eminem",
            "Juicy - The Notorious B.I.G.",
            "N.Y. State of Mind - Nas",
            "HUMBLE. - Kendrick Lamar",
            "SICKO MODE - Travis Scott",
            "God's Plan - Drake",
            "99 Problems - JAY-Z",
            "C.R.E.A.M. - Wu-Tang Clan",
            "Alright - Kendrick Lamar",
            "Stan - Eminem"
        ));

        ArrayList<String> classicalSongs = new ArrayList<>(List.of(
            "Für Elise - Ludwig van Beethoven",
            "Clair de Lune - Claude Debussy",
            "The Four Seasons: Spring - Antonio Vivaldi",
            "Swan Lake Theme - Pyotr Ilyich Tchaikovsky",
            "Canon in D - Johann Pachelbel",
            "Symphony No. 9 (Ode to Joy) - Ludwig van Beethoven",
            "Requiem: Lacrimosa - Wolfgang Amadeus Mozart",
            "Prelude in C Major - Johann Sebastian Bach",
            "Moonlight Sonata - Ludwig van Beethoven",
            "Boléro - Maurice Ravel"
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
		else{
			return "Productividad";
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
