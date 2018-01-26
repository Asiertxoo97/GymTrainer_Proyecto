package Datos;

public class Usuario {
	
	private String DNI;
	private String nombre;
	private String nick;
	private String constrasenia;
	private String apellido;
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
	 * @param apellido :Apellido del usuario.
	 * @param cuenta_bancaria : Cuenta bancaria del usuario.
	 */
	public Usuario(String dNI, String nombre, String nick, String constrasenia, String apellido,
			String cuenta_bancaria) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.nick = nick;
		this.constrasenia = constrasenia;
		this.apellido = apellido;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
				+ ", apellido=" + apellido + ", cuenta_bancaria=" + cuenta_bancaria
				+ "]";
	}

	

}