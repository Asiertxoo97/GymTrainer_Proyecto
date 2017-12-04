package Datos;

public class Charla {

	private String cod_charla;
	private String nombre;
	private Impartidor impartidor;
	private String fecha;
	private double tiempo;
	private int numPlazas;
	
	
	/**
	 * Constructor con par�metros de Clase Charla
	 * @param nombre: Nombre de la clase.
	 * @param horario: Horario en el que se impartir� la clase. Teniendo en cuenta que el horario ser� el mismo durante el a�o.
	 * @param tiempo: Tiempo total de duraci�n de la clase.
	 */
	public Charla(String cod_charla,Impartidor impar,String nombre, String fecha, double tiempo, int numPlazas) {
		super();
		this.cod_charla=cod_charla;
		this.nombre = nombre;
		this.impartidor=impar;
		this.fecha = fecha;
		this.tiempo = tiempo;
		this.numPlazas=numPlazas;
	}
	

	/**
	 * M�todos Get y Set de Clase Charla
	 * @return
	 */
	
	public Impartidor getImpartidor() {
		return impartidor;
	}
	
	public void setImpartidor(Impartidor impartidor) {
		this.impartidor = impartidor;
	}
	
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
	public String getfecha() {
		return fecha;
	}
	public void setfecha(String fecha) {
		this.fecha = fecha;
	}
	public double getTiempo() {
		return tiempo;
	}
	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}
	
	public int getNumPlazas() {
		return numPlazas;
	}
	
	public void setNumPlazas(int numPlazas) {
		this.numPlazas=numPlazas;
	}


	
	
	/**
	 * M�todo toString de Clase Charla
	 */
	@Override
	public String toString() {
		return "Charla [cod_charla=" + cod_charla + ", nombre=" + nombre + ", impartidor=" + impartidor + ", fecha="
				+ fecha + ", tiempo=" + tiempo + ", numPlazas=" + numPlazas + "]";
	}
	
	
	
	
}
