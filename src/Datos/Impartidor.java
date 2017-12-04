package Datos;

public class Impartidor {

	private String dni_impar;
	private String nombre;
	private String apellidos;
	private int salario;
	public Impartidor(String dni_impar, String nombre, String apellidos, int salario) {
		
		this.dni_impar = dni_impar;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
	}
	public String getDni_impar() {
		return dni_impar;
	}
	public void setDni_impar(String dni_impar) {
		this.dni_impar = dni_impar;
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
		return "Profesor [dni_impar=" + dni_impar + ", nombre=" + nombre + ", apellidos=" + apellidos + ", salario="
				+ salario + "]";
	}
	
	
	
}
