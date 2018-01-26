package Datos;

public class Clase {

	private String codClase;
	private Profesor profesor;
	private String nombre;
	private String fecha;
	private double tiempo;
	private int numPlazas;
	
	public Clase(String codClase, Profesor profesor, String nombre, String fecha, double tiempo, int numPlazas) {
		
		this.codClase = codClase;
		this.profesor = profesor;
		this.nombre = nombre;
		this.fecha = fecha;
		this.tiempo = tiempo;
		this.numPlazas= numPlazas;
	}
	public String getCodClase() {
		return codClase;
	}
	public void setCodClase(String codClase) {
		this.codClase = codClase;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getTiempo() {
		return tiempo;
	}
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	
	public int getNumPlazas() {
		return numPlazas;
	}
	
	public void setNumPlazas(int numPlazas) {
		this.numPlazas=numPlazas;
	}
	
	
	
	@Override
	public String toString() {
		return "Clase [codClase=" + codClase + ", profesor=" + profesor.toString() + ", nombre=" + nombre + ", fecha=" + fecha
				+ ", tiempo=" + tiempo + "]";
	}
	
	
	
	
	
}