package Datos;

public class Participante {

		private String DNI;
		private String nombre;
		private String apellido1;
		private String apellido2;
		private String cuenta_bancaria;
		private String codigo;
		
		/**
		 * Constructor vacío de Clase Participante
		 * 
		 */
		public Participante() {
				super();
		 }
		/**
		 * Constructor con parámetros de Clase Participante
		 * @param dNI
		 * @param nombre : Nombre del usuario
		 * @param apellido1 : Primer apellido del usuario.
		 * @param apellido2 : Segundo apellido del usuario.
		 * @param cuenta_bancaria : Cuenta bancaria del usuario.
		 * @param codigo : Codigo String de 10 dígitos que será unico para cada participante 
 		 *				   será creado aleatoriamentee cada vez que un participante se aliste a una charla.
		 */
		public Participante(String dNI, String nombre, String apellido1, String apellido2, String cuenta_bancaria,
				String codigo) {
			super();
			DNI = dNI;
			this.nombre = nombre;
			this.apellido1 = apellido1;
			this.apellido2 = apellido2;
			this.cuenta_bancaria = cuenta_bancaria;
			this.codigo = codigo;
		}

		/**
		 * Métodos Get y Set de Clase Participante
		 * 
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


		public String getCodigo() {
			return codigo;
		}


		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		/**
		 * Método toString de Clase Participante
		 * 
		 */

		@Override
		public String toString() {
			return "Participante [DNI=" + DNI + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
					+ apellido2 + ", cuenta_bancaria=" + cuenta_bancaria + ", codigo=" + codigo + "]";
		}

		
		
}
