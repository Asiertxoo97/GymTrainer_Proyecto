package Datos;

public class Clase {

	private String nombre;
	private String horario;
	private float tiempo;
	
	/**
	 * Constructor Vacío de Clase Clase
	 */
	public Clase() {
		super();
	}
	/**
	 * Constructor con parámetros de Clase Clase
	 * @param nombre: Nombre de la clase.
	 * @param horario: Horario en el que se impartirá la clase. Teniendo en cuenta que el horario será el mismo durante el año.
	 * @param tiempo: Tiempo total de duración de la clase.
	 */
	public Clase(String nombre, String horario, float tiempo) {
		super();
		this.nombre = nombre;
		this.horario = horario;
		this.tiempo = tiempo;
	}
	
	/**
	 * Métodos Get y Set de Clase Clase
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public float getTiempo() {
		return tiempo;
	}
	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}
	
	/**
	 * Método toString de Clase Clase
	 */

	@Override
	public String toString() {
		return "Clase [nombre=" + nombre + ", horario=" + horario + ", tiempo=" + tiempo + "]";
	}
	
	
}
