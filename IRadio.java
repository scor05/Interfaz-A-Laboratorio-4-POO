/**
 * @version 14/10/2024
 */

public interface IRadio {
    public void onOff(boolean value);
    public void cambiarVolumen(boolean value);
    public void cambiarModo(int mode);
    public void amFm(boolean value);
    public void cambiarEmi(double emisora);
}
