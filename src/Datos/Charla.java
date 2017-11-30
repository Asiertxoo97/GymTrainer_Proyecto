package Datos;

public class Charla {

	private String cod_charla;
	private String nombre;
	private String horario;
	private float tiempo;
	private int numPlazas;
	
	
	/**
	 * Constructor con par�metros de Clase Charla
	 * @param nombre: Nombre de la clase.
	 * @param horario: Horario en el que se impartir� la clase. Teniendo en cuenta que el horario ser� el mismo durante el a�o.
	 * @param tiempo: Tiempo total de duraci�n de la clase.
	 */
	public Charla(String cod_charla,String nombre, String horario, float tiempo, int numPlazas) {
		super();
		this.cod_charla=cod_charla;
		this.nombre = nombre;
		this.horario = horario;
		this.tiempo = tiempo;
		this.numPlazas=numPlazas;
	}
	

	/**
	 * M�todos Get y Set de Clase Charla
	 * @return
	 */
	
	public String getCod_charla() {
		return cod_charla;
	}
	
	public void setCod_charla(String cod_charla) {
		this.cod_charla = cod_charla;
	}
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
	
	public int getNumPlazas() {
		return numPlazas;
	}
	
	public void setNumPlazas() {
		this.numPlazas=numPlazas;
	}
	
	/**
	 * M�todo toString de Clase Charla
	 */

	@Override
	public String toString() {
		return "Charla [nombre=" + nombre + ", horario=" + horario + ", tiempo=" + tiempo + "]";
	}
	
	
	
}
