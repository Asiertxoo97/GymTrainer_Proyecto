package Datos;

import java.util.ArrayList;

public class Rutina {

	private ArrayList<Ejercicio> Ejercicios;
	private Usuario usuario;
	private int numero;

	
	/**
	 *MÉTODO CON PARÁMETROS 
	 * 
	 */
	
	public Rutina(ArrayList<Ejercicio> ejercicios, Usuario usuario,int numero) {
		super();
		Ejercicios = ejercicios;
		this.usuario = usuario;
		this.numero = numero;
	}
	
	/**
	 * GET Y SET
	 * @return
	 */
	
	public ArrayList<Ejercicio> getEjercicios() {
		return Ejercicios;
	}
	
	public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
		Ejercicios = ejercicios;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * TOSTRING
	 */

	@Override
	public String toString() {
		return "Rutina [Ejercicios=" + Ejercicios + ", usuario=" + usuario + "]";
	}
	
	
	
	
}