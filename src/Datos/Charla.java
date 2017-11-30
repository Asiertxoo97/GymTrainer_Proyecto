package Datos;

import java.util.Date;

public class Charla {

	private String cod_charla;
	private String nombre;
	private String dni_impartidor;
	private Date fecha;
	private double tiempo;
	
	/**
	 * Constructor Vacío de Clase Charla
	 */
	public Charla() {
		super();
	}
	/**
	 * Constructor con parámetros de Clase Charla
	 * @param nombre: Nombre de la clase.
	 * @param horario: Horario en el que se impartirá la clase. Teniendo en cuenta que el horario será el mismo durante el año.
	 * @param tiempo: Tiempo total de duración de la clase.
	 */
	public Charla(String cod_charla, String nombre, String dni_impartidor, Date fecha, double tiempo) {
		super();
		this.cod_charla = cod_charla;
		this.nombre = nombre;
		this.dni_impartidor = dni_impartidor;
		this.fecha = fecha;
		this.tiempo = tiempo;
	}
	

	/**
	 * Métodos Get y Set de Clase Charla
	 * @return
	
	}
	*/
	public String getCod_charla() {
		return cod_charla;
	}
	public void setCod_charla(String cod_charla) {
		this.cod_charla = cod_charla;
	}
	public String getDni_impartidor() {
		return dni_impartidor;
	}
	public void setDni_impartidor(String dni_impartidor) {
		this.dni_impartidor = dni_impartidor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getTiempo() {
		return tiempo;
	}
	
	
	/**
	 * Método toString de Clase Charla
	 */

	@Override
	public String toString() {
		return "Charla [cod_charla=" + cod_charla + ", nombre=" + nombre + ", dni_impartidor=" + dni_impartidor
				+ ", fecha=" + fecha + ", tiempo=" + tiempo + "]";
	}
	
	
	
}
