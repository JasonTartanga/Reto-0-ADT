package clases;

import java.io.Serializable;

public class Convocatoria implements Serializable {

    private int id;
    private String convocatoria;
    private String descripcion;
    private String fecha;
    private String curso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConvocatoria() {

        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Convocatoria{" + "id=" + id + ", convocatoria=" + convocatoria + ", descripcion=" + descripcion + ", fecha=" + fecha + ", curso=" + curso + '}';
    }

}
