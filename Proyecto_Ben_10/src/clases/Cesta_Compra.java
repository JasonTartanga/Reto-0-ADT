package clases;

import java.sql.Date;
import java.time.LocalDate;

public class Cesta_Compra {
	// atributos
	private String numReferencia;
	private Date fecha_Inicio;
	private Date fecha_fin;
	private float peso_total;
	private float precio_total;

	// cosntructor
	public Cesta_Compra() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getters y setters
	public String getNumReferencia() {
		return numReferencia;
	}

	public void setNumReferencia(String numReferencia) {
		this.numReferencia = numReferencia;
	}

	public Date getFecha_Inicio() {
		return fecha_Inicio;
	}

	public void setFecha_Inicio(Date date) {
		this.fecha_Inicio = date;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public float getPeso_total() {
		return peso_total;
	}

	public void setPeso_total(float peso_total) {
		this.peso_total = peso_total;
	}

	public float getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}

}
