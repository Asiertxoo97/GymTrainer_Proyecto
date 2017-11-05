package BaseDeDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;

import Datos.RandomString;


public class BD {
	
	private Connection con;
	private static Statement stmt;
	
	/**
	 * Metodo que crea una sentencia para acceder a la base de datos 
	 */
	public void crearSentencia()
	{
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Método para conectarse a la base de datos
	 */

	public void conectar()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			con= DriverManager.getConnection("jdbc:sqlite:BaseDeDatos.db");
			crearSentencia();
		}catch(Exception e)
		{
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que cierra una sentencia 
	 */
	public void cerrarSentencia()
	{
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método para desconectarse de la base de datos
	 */
	public void desconectar()
	{
		try {
			cerrarSentencia();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Método para conectarse de la base de datos
	 */
	public BD(){
		conectar();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 						MÉTODOS PARA USUARIO
	 * 
	 */
	
	/** 
	 * Método para comprobar la existencia del Usuario.
	 * 
	 * @param nom: Nombre introducido por el usuario
	 * @param con: Contraseña introducida por el usuario
	 * @return : 
	 * 			0 - Si no existe el usuario
	 * 			1 - Si sí existe el usuario pero la contraseña no es correcta
	 * 			2 - Si el nombre de usuario es correcto y la contraseña también
	 */
	public int existeUsuario(String nic, String con){
		
		String query = "SELECT * FROM Usuario WHERE nick='"+nic+"'";
		ResultSet rs = null;
		int resul=0;
		try {
			rs = stmt.executeQuery(query);
			if(rs.next()){ 
				String n = rs.getString("nombre");
				String c = rs.getString("contrasenia");
				if(!n.equals(nic))
					resul=0;
				else if(!c.equals(con))
					resul=1;
				else
					resul=2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resul;
	}
	
	/**
	 * Método para Registrar Usuario.
	 *
	 * @param dNI
	 * @param nom : Nombre del usuario
	 * @param nic : Nick del usuario. Se usará para acceder al perfil.
	 * @param con : Contraseña del usuario.
	 * @param ape1: Primer apellido del usuario.
	 * @param ape2: Segundo apellido del usuario.
	 * @param cuen: Cuenta bancaria del usuario.
	 */
	public void registrarUsuario(String dNI, String nom, String nic, String con, String ape1, 
			String ape2,String cuen){
		String query= "INSERT INTO Usuario(DNI,nombre, nick,constrasenia,apellido1,apellido2,cuenta_bancaria) "
				+ "VALUES('"+dNI+"','"+nom+"','"+nic+"','"+con+"','"+ape1+"','"+ape2+"','"+cuen+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * 						MÉTODOS PARA EJERCICIO
	 * 
	 */
	
	/*
	 * TODO
	 * 
	 **/
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 						MÉTODOS PARA PARTICIPANTE
	 * 
	 */
	
	

	/** 
	 * Método para comprobar si un Participante está alistado a un charla.
	 * Si un Participante está alistado a un charla no puede volver a alistarse.
	 * 
	 * @param dni: Nombre introducido por el usuario
	 * @return : 
	 * 			0 - Participante NO alistado a una charla.
	 * 			1 - Participante SI alistado a una charla.
	 */
	public boolean participanteAlistado(RandomString codigoAleatorio){
		
		String query = "SELECT * FROM Participante WHERE codigo='"+codigoAleatorio+"'";
		ResultSet rs = null;
		boolean resul=false;
		try {
			rs = stmt.executeQuery(query);
			if(rs.next()){ 
				String c = rs.getString("codigo");
				if(!c.equals(codigoAleatorio))
					resul=false;	//No hay ningun Particiapante Alistado con ese Código.
				else
					resul=true;		//Ya hay un Perticipante Alistado con ese Código
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resul;
	}
	
	/**
	 * Método para Registrar Participante.
	 *
	 * @param dNI
	 * @param nom : Nombre del usuario
	 * @param nic : Nick del usuario. Se usará para acceder al perfil.
	 * @param con : Contraseña del usuario.
	 * @param ape1: Primer apellido del usuario.
	 * @param ape2: Segundo apellido del usuario.
	 * @param cuen: Cuenta bancaria del usuario.
	 * @param cod : Código aleatoriamente creado para cada Participante con el fin de identificar a cada Participante.
	 */
	public void registrarParticipante(String dNI, String nom, String ape1, 
			String ape2,String cuen,String cod){
		/**
		 * Crear el código personal para cada Participante. 
		 * Seguidamente, comprobar que el código no existe, y en caso de existir crear uno nuevo.
		 */
		RandomString codigoAleatorio=null;
		do{
			 codigoAleatorio = new RandomString(8, ThreadLocalRandom.current());
		}while(participanteAlistado(codigoAleatorio));
		
		String query= "INSERT INTO Usuario(DNI,nombre, nick,constrasenia,apellido1,apellido2,cuenta_bancaria) "
				+ "VALUES('"+dNI+"','"+nom+"','"+ape1+"','"+ape2+"','"+cuen+"','"+codigoAleatorio+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	
	
	
	
	
	
	
	

}
