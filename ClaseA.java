/**
 * @version 14/10/2024
 */

import java.util.ArrayList;

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
