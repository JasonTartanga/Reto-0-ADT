package clases;

import java.io.Serializable;

/**
 * Esta clase gurada temporalemente la informacion de una convocatoria.
 *
 * @author Jason.
 */
public class Convocatoria implements Serializable {

    private String convocatoria;
    private String descripcion;
    private String fecha;
    private String curso;
    private int idEnunciado;

    public int getIdEnunciado() {
        return idEnunciado;
    }

    public void setIdEnunciado(int idEnunciado) {
        this.idEnunciado = idEnunciado;
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
        return "Convocatoria{" + "idEnunciado=" + idEnunciado + ", convocatoria=" + convocatoria + ", descripcion=" + descripcion + ", fecha=" + fecha + ", curso=" + curso + '}';
    }

}
