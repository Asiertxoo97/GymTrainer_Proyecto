package Datos;

public class Profesor {

	private String dni_prof;
	private String nombre;
	private String apellidos;
	private int salario;
	public Profesor(String dni_prof, String nombre, String apellidos, int salario) {
		
		this.dni_prof = dni_prof;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
	}
	public String getDni_prof() {
		return dni_prof;
	}
	public void setDni_prof(String dni_prof) {
		this.dni_prof = dni_prof;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Profesor [dni_prof=" + dni_prof + ", nombre=" + nombre + ", apellidos=" + apellidos + ", salario="
				+ salario + "]";
	}
	
	
	
	
}