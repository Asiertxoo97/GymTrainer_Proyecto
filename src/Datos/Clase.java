package Datos;

public class Clase {

	private String nombre;
	private String horario;
	private float tiempo;
	
	/**
	 * Constructor Vac�o de Clase Clase
	 */
	public Clase() {
		super();
	}
	/**
	 * Constructor con par�metros de Clase Clase
	 * @param nombre: Nombre de la clase.
	 * @param horario: Horario en el que se impartir� la clase. Teniendo en cuenta que el horario ser� el mismo durante el a�o.
	 * @param tiempo: Tiempo total de duraci�n de la clase.
	 */
	public Clase(String nombre, String horario, float tiempo) {
		super();
		this.nombre = nombre;
		this.horario = horario;
		this.tiempo = tiempo;
	}
	
	/**
	 * M�todos Get y Set de Clase Clase
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
	 * M�todo toString de Clase Clase
	 */

	@Override
	public String toString() {
		return "Clase [nombre=" + nombre + ", horario=" + horario + ", tiempo=" + tiempo + "]";
	}
	
	
}
