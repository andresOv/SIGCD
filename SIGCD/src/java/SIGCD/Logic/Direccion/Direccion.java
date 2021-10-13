package SIGCD.Logic.Direccion;

public class Direccion {

    private int distrito;
    private int barrio;
    private String direccionExacta;

    public Direccion() {
    }

    public Direccion(int distrito, int barrio, String direccionExacta) {
        this.distrito = distrito;
        this.barrio = barrio;
        this.direccionExacta = direccionExacta;
    }

    public int getDistrito() {
        return distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public int getBarrio() {
        return barrio;
    }

    public void setBarrio(int barrio) {
        this.barrio = barrio;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    @Override
    public String toString() {
        return "Direccion{" + "distrito=" + distrito + ", barrio=" + barrio + ", direccionExacta=" + direccionExacta + '}';
    }
}
