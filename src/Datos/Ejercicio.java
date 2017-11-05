package Datos;

import java.awt.Image;

public class Ejercicio {

	private int id_eje;
	private String nombre;
	private String descripcion;
	private double tiempo_estimado;
	private Image GIF;
	
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
	 * @param gIF : Un GIF que muestra como se hace el Ejercicio  mediante ayuda visual.
	 */
	public Ejercicio(int id_eje, String nombre, String descripcion, double tiempo_estimado, Image gIF) {
		super();
		this.id_eje = id_eje;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempo_estimado = tiempo_estimado;
		GIF = gIF;
	}
	
	
	
	/**
	 * Métodos Get y Set de Clase Ejercicio
	 * @return
	 */
	public int getId_eje() {
		return id_eje;
	}
	public void setId_eje(int id_eje) {
		this.id_eje = id_eje;
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
	public Image getGIF() {
		return GIF;
	}
	public void setGIF(Image gIF) {
		GIF = gIF;
	}
	
	
	/**
	 * Método toString de Clase Ejercicio
	 */
	
	@Override
	public String toString() {
		return "Ejercicio [id_eje=" + id_eje + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", tiempo_estimado=" + tiempo_estimado + ", GIF=" + GIF + "]";
	}
	
	

	
	
}


