package mx.edu.ittepic.judamedranoba.a51deteccionsensores;

public class Lista_entrada {

    private String Nombre;
    private String Fabricante;
    private String Version;
    private String Rango;
    private String Delay;
    private String Power;

    public Lista_entrada(String nombre, String fabricante, String version, String rango, String delay, String power) {

        this.Nombre = nombre;
        this.Fabricante = fabricante;
        this.Version = version;
        this.Rango = rango;
        this.Delay = delay;
        this.Power = power;

    }

    public String getNombre() {
        return Nombre;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public String getVersion() {
        return Version;
    }

    public String getRango() {
        return Rango;
    }

    public String getDelay() {
        return Delay;
    }

    public String getPower() {
        return Power;
    }

}
