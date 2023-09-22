package clases;

/**
 * Esta clase guarda la informacion de los enunciados.
 *
 * @author Jason.
 */
public class Enunciado {

    /**
     * El identificador unico del enunciado.
     */
    private int id;

    /**
     * La descripcion del enunciado.
     */
    private String descripcion;
    /**
     * La dificultad que tiene el enunciado. Es un enum con tres posibilidades
     * (Alta, Media y Baja).
     */
    private Dificultad nivel;

    /**
     * Si esta dispionible o no.
     */
    private boolean disponible;

    /**
     * La ruta en la que esta guardada el enunciado.
     */
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

    /**
     * Muestra todos los datos del enunciado.
     *
     * @return todos los datos del enunciado.
     */
    public String getDatos() {
        return "ID:\t\t" + id + "\n"
                + "Descripcion:\t\t" + descripcion + "\n"
                + "Nivel:\t\t" + nivel + "\n"
                + "Disponible:\t\t" + disponible + "\n"
                + "Ruta:\t\t" + ruta;
    }
}
