package Datos;

public class Usuario {
	
	private String DNI;
	private String nombre;
	private String nick;
	private String constrasenia;
	private String apellido1;
	private String apellido2;
	private String cuenta_bancaria;
	
	/**
	 * Constructor vacío de Clase Usuario
	 */
	
	public Usuario() {
		super();
	}
	/**
	 * Constructor con parámetros de Clase Usuario.
	 * @param dNI
	 * @param nombre : Nombre del usuario
	 * @param nick : Nick del usuario. Se usará para acceder al perfil.
	 * @param constrasenia : Contraseña del usuario.
	 * @param apellido1 : Primer apellido del usuario.
	 * @param apellido2 : Segundo apellido del usuario.
	 * @param cuenta_bancaria : Cuenta bancaria del usuario.
	 */
	public Usuario(String dNI, String nombre, String nick, String constrasenia, String apellido1, String apellido2,
			String cuenta_bancaria) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.nick = nick;
		this.constrasenia = constrasenia;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.cuenta_bancaria = cuenta_bancaria;
	}
	/**
	 * Métodos Get y Set de Clase Usuario
	 * @return
	 */
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getConstrasenia() {
		return constrasenia;
	}
	public void setConstrasenia(String constrasenia) {
		this.constrasenia = constrasenia;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getCuenta_bancaria() {
		return cuenta_bancaria;
	}
	public void setCuenta_bancaria(String cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}
	
	/**
	 * Método toString de Clase Usuario
	 */
	
	@Override
	public String toString() {
		return "Usuario [DNI=" + DNI + ", nombre=" + nombre + ", nick=" + nick + ", constrasenia=" + constrasenia
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", cuenta_bancaria=" + cuenta_bancaria
				+ "]";
	}

	

}
