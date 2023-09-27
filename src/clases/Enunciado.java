package clases;

/**
 * Esta clase guarda temporalmente la informacion de los enunciados.
 *
 * @author Jason.
 */
public class Enunciado {

    private int id;

    private String descripcion;

    private Dificultad nivel;

    private boolean disponible;

    private String ruta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Dificultad getNivel() {
        return nivel;
    }

    public void setNivel(Dificultad nivel) {
        this.nivel = nivel;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDatos() {
        return "ID:\t\t" + id + "\n"
                + "Descripcion:\t\t" + descripcion + "\n"
                + "Nivel:\t\t" + nivel + "\n"
                + "Disponible:\t\t" + disponible + "\n"
                + "Ruta:\t\t" + ruta;
    }
}
