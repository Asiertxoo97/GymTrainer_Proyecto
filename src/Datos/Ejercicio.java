package Datos;

import java.awt.Image;

public class Ejercicio {

	private String cod_ejercicio;
	private String nombre;
	private String descripcion;
	private double tiempo_estimado;
	private String gif;
	
	/**
	 * Constructor vacío de Clase Ejercicio
	 */
	public Ejercicio() {
		super();
	}
	
	/**
	 * Constructor con parámetros de Clase Ejercicio
	 * @param id_eje : Identificador de Ejercicio.
	 * @param nombre : Nombre de Ejercicio.
	 * @param descripcion : Descripcion de ejercicio:
	 * @param tiempo_estimado : Tiempo estimado para ejecutar correctamente el Ejercicio.
	 * @param gif : Un GIF que muestra como se hace el Ejercicio  mediante ayuda visual.
	 */
	public Ejercicio(String cod_ejercicio, String nombre, String descripcion, double tiempo_estimado, String gif) {
		super();
		this.cod_ejercicio = cod_ejercicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempo_estimado = tiempo_estimado;
		gif = gif;
	}
	
	
	
	/**
	 * Métodos Get y Set de Clase Ejercicio
	 * @return
	 */
	public String getId_eje() {
		return cod_ejercicio;
	}
	public void setId_eje(String cod_ejercicio) {
		this.cod_ejercicio = cod_ejercicio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getTiempo_estimado() {
		return tiempo_estimado;
	}
	public void setTiempo_estimado(double tiempo_estimado) {
		this.tiempo_estimado = tiempo_estimado;
	}
	public String getGIF() {
		return gif;
	}
	public void setGIF(String GIF) {
		gif = GIF;
	}
	
	
	/**
	 * Método toString de Clase Ejercicio
	 */
	
	@Override
	public String toString() {
		return "Ejercicio [cod_ejercicio=" + cod_ejercicio + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", tiempo_estimado=" + tiempo_estimado + ", GIF=" + gif + "]";
	}
	
	

	
	
}


