/**
 * @version 14/10/2024
 */

import java.util.ArrayList;

public class ClaseA implements IRadio {
    private boolean encendido;
    private int volumen;
    private int modo;
	// (1 modo radio, 2 reproducción, 3 teléfono, 4 productividad)
    private int frecuencia;
    private double emisora;
    private ArrayList<Double> emisorasGuardadas;
    private ArrayList<ArrayList<String>> playlists;
    private boolean telefono;
    private boolean speakerAuri;
    private ArrayList<String> contactos;
    private String viaje;
    private static final int MAX_EMISORAS = 50;

    
    public ClaseA() {
        this.encendido = false;
        this.volumen = 0;
        this.modo = 1;
        this.frecuencia = 2; // Comienza en FM
        this.emisora = 87.9; // Frecuencia FM inicial
        this.emisorasGuardadas = new ArrayList<>();  // Inicialización de la lista
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
	
	public void siguienteEmisora() {
        if (frecuencia == 1) { // AM
            emisora = Math.min(1610, emisora + 10);
        } else { // FM
            emisora = Math.min(107.9, emisora + 0.5);
        }
    }

    public void anteriorEmisora() {
        if (frecuencia == 1) { // AM
            emisora = Math.max(530, emisora - 10);
        } else { // FM
            emisora = Math.max(87.9, emisora - 0.5);
        }
    }

    public void guardarEmisora() {
        if (emisorasGuardadas.size() < MAX_EMISORAS && !emisorasGuardadas.contains(emisora)) {
            emisorasGuardadas.add(emisora);
        }
    }

    public void cargarEmisora() {
        if (!emisorasGuardadas.isEmpty()) {
            // Encuentra la siguiente emisora guardada más cercana a la actual
            double emisoraCercana = emisorasGuardadas.get(0);
            double diferenciaMínima = Math.abs(emisora - emisoraCercana);

            for (double emisoraGuardada : emisorasGuardadas) {
                double diferencia = Math.abs(emisora - emisoraGuardada);
                if (diferencia < diferenciaMínima) {
                    diferenciaMínima = diferencia;
                    emisoraCercana = emisoraGuardada;
                }
            }
            emisora = emisoraCercana;
        }
    }
	
	public void cargarEmisoraEspecifica(double emisoraSeleccionada) {
        if (modo == 1) {
            this.emisora = emisoraSeleccionada;
        }
    }

    // Método para obtener la lista de emisoras guardadas
    public ArrayList<Double> getEmisorasGuardadas() {
        return this.emisorasGuardadas;
    }
	public void cambiarEmi(double emisora) {
        setEmisora(emisora);
    }

    public void amFm(boolean value) {
        if (value) {
            setFrecuencia(1);
            emisora = 530; // Frecuencia AM inicial
        } else {
            setFrecuencia(2);
            emisora = 87.9; // Frecuencia FM inicial
        }
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
	
	public String frecuenciaConvertida() {
        if (frecuencia == 1) {
            return "AM " + String.format("%.0f", emisora);
        } else {
            return "FM " + String.format("%.1f", emisora);
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
