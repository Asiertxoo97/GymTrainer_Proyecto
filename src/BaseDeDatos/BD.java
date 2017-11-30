package BaseDeDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import Datos.Charla;
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

	
	
	
	/**
	 * Método para crear Tabla Usuario
	 */
public Statement createTable(Connection con){
		
	
	//CREAR TABLA USUARIO
	try {
		stmt.setQueryTimeout(30);
		String Usuario = "CREATE TABLE Usuario (DNI string,nombre string, nick string,contrasenia string"
				+ ",apellido string,cuenta_bancaria string)";
		stmt.executeUpdate(Usuario);
	} catch (SQLException e) {} // Tabla ya existe. Nada que hacer.
	
	//CREAR TABLA PARTICIPANTE
		try {
			stmt.setQueryTimeout(30);
			String Participante = "CREATE TABLE Participante (DNI string,nombre string,apellido string,"
					+ "cuenta_bancaria string,codigo string)";
			stmt.executeUpdate(Participante);
		} catch (SQLException e) {} // Tabla ya existe. Nada que hacer.
	
	//CREAR TABLA EJERCICIO
	try {
		stmt.setQueryTimeout(30);
		String Ejercicio = "CREATE TABLE Ejercicio (cod_ejercicio string,nombre string,descripción string,"
			+ "tiempo_estimado double,GIF string)";
			stmt.executeUpdate(Ejercicio);
		} catch (SQLException e) {}// Tabla ya existe. Nada que hacer.

	//CREAR TABLA TIPO
	try {
		stmt.setQueryTimeout(30);
		String Tipo = "CREATE TABLE Tipo (cod_tipo string,nombre string)";
			stmt.executeUpdate(Tipo);
		} catch (SQLException e) {}// Tabla ya existe. Nada que hacer.
	
	//CREAR TABLA CLASE
	try {
		stmt.setQueryTimeout(30);
		String Clase = "CREATE TABLE Clase (cod_clase string,nombre string,dni_profesor string,"
			+ "fecha string,tiempo double)";
			stmt.executeUpdate(Clase);
		} catch (SQLException e) {}// Tabla ya existe. Nada que hacer.
	
	//CREAR TABLA CHARLA
	try {
		stmt.setQueryTimeout(30);
		String Charla = "CREATE TABLE Charla (cod_charla string,nombre string,dni_impartidor string,"
			+ "fecha date,tiempo double)";
			stmt.executeUpdate(Charla);
		} catch (SQLException e) {}// Tabla ya existe. Nada que hacer.
	
	//CREAR TABLA IMPARTIDOR
	try {
		stmt.setQueryTimeout(30);
		String Impartidor = "CREATE TABLE Impartidor (dni_impartidor string,nombre string,"
			+ "apellidos string,salario int)";
			stmt.executeUpdate(Impartidor);
		} catch (SQLException e) {}// Tabla ya existe. Nada que hacer.
	
	//CREAR TABLA PROFESOR
	try {
		stmt.setQueryTimeout(30);
		String Profesor = "CREATE TABLE Profesor (dni_profesor string,nombre string,"
			+ "apellidos string,salario int)";
			stmt.executeUpdate(Profesor);
		} catch (SQLException e) {}// Tabla ya existe. Nada que hacer.
		

	//CREAR TABLA RUTINA
	try {
		stmt.setQueryTimeout(30);
		String Profesor = "CREATE TABLE Rutina (dni_usuario string,cod_ejercicio string";
			stmt.executeUpdate(Profesor);
		} catch (SQLException e) {}// Tabla ya existe. Nada que hacer.
		
		
		
		return null;
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
		
		String query = "SELECT * FROM Usuario WHERE nick = '"+nic+"'";
		ResultSet rs = null;
		int resul=0;
		try {
			rs = stmt.executeQuery(query);
			if(rs.next()){ 
				String n = rs.getString("nick");
				String c = rs.getString("contrasenia");
				if(!n.equals(nic))
					resul=0;	//El Nick es ERRÓNEO
				else if(!c.equals(con))
					resul=1;	//La Contraseña es ERRÓNEA
				else
					resul=2; //Nick Y Contraseña BIEN INTRODUCIDAS.
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
	public void registrarUsuario(String dNI, String nom, String nic, String con, String ape,String cuen){
		String query= "INSERT INTO Usuario(DNI,nombre, nick,contrasenia,apellido,cuenta_bancaria) "
				+ "VALUES('"+dNI+"','"+nom+"','"+nic+"','"+con+"','"+ape+"','"+cuen+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	
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
	 * @param ape : Apellido del usuario.
	 * @param cuen: Cuenta bancaria del usuario.
	 * @param cod : Código aleatoriamente creado para cada Participante con el fin de identificar a cada Participante.
	 */
	public void registrarParticipante(String dNI, String nom, String ape,String cuen){
		/**
		 * Crear el código personal para cada Participante. 
		 * Seguidamente, comprobar que el código no existe, y en caso de existir crear uno nuevo.
		 */
		RandomString codigoAleatorio=null;
		do{
			 codigoAleatorio = new RandomString(8, ThreadLocalRandom.current());
		}while(participanteAlistado(codigoAleatorio));
		
		String query= "INSERT INTO Usuario(DNI,nombre, nick,constrasenia,apellido,cuenta_bancaria,codigo) "
				+ "VALUES('"+dNI+"','"+nom+"','"+ape+"','"+cuen+"','"+codigoAleatorio+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 						MÉTODOS PARA CLASE
	 * 
	 */

	//TODO
	public int existeClases(String cod_clase){
		
		String query = "SELECT * FROM Clase WHERE cod_clase = '"+cod_clase+"'";
		ResultSet rs = null;
		boolean resul=false;
		int resp = 0;
		
			try {
				rs = stmt.executeQuery(query);
				if(rs.next()){ 
				String c = rs.getString("cod_clase");
				if(!c.equals(cod_clase))
					resp=0;	//La Clase existe 
				else 
					resp=1; //La clase NO existe.
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resp;
	}
	
	public void introducirClase(String cod_clase ,String nombre ,String dni_profesor ,String fecha ,double tiempo ){
		
		String query= "INSERT INTO Clase(cod_clase ,nombre ,dni_profesor ,fecha ,tiempo ) "
				+ "VALUES('"+cod_clase+"','"+nombre+"','"+dni_profesor+"','"+fecha+"','"+tiempo+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 						MÉTODOS PARA CHARLAS
	 * 
	 */

/**
 * Método para verificiar que una charla no existe para poder crearla. 
 * Una charla se puede impartir N veces con la única condición de no poder impartir la MISMA CHARLA el MISMO DÍA.
 * @param cod_charla: Código de la charla que deseamos verificar.
 * @param fecha: Fecha en la que se impartirá la charla.
 * @return
 */
public int existeCharla(String cod_charla,Date fecha){
	
	String query = "SELECT * FROM Charla WHERE cod_charla = '"+cod_charla+"'";
	ResultSet rs = null;
	boolean resul=false;
	int resp = 0;
	
		try {
			rs = stmt.executeQuery(query);
			if(rs.next()){ 
			String c = rs.getString("cod_charla");
			Date f =rs.getDate("fecha");
			if(!c.equals(cod_charla))
				resp=0;	//La Charla existe 
			else if(!f.equals(fecha))
				resp=1; //La Charla existe, porque no puede haber la misma charla el mismo día. 
						//Aunque una charla se puede impartir en varios dias.
						//La única condición es que una CHARLA NO se imparta el MISMO DÍA.
			else
				resp=2;			//La charla no existe->puede crearse.
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
}

public ArrayList<Charla> mostrarCharlas(){
	
	ArrayList<Charla> charlas = new ArrayList<Charla>();
	String query = "SELECT COUNT(*) FROM Charla";
	ResultSet rs;
	try {
		rs = stmt.executeQuery(query);
		int numCharlas = 0;
		while(rs.next()){
			String c = rs.getString("cod_charla");
			String n = rs.getString("nombre");
			String d = rs.getString("dni_impartidor");
			Date f = rs.getDate("fecha");
			double t = rs.getDouble("tiempo");
			Charla charla = new Charla(c,n,d,f,t);
			charlas.add(charla);
			numCharlas++;
		}	
	}catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return charlas;
}

public void introducirCharla(String cod_charla ,String nombre ,String dni_impartidor ,Date fecha ,double tiempo ){
	
	String query= "INSERT INTO Charla(cod_charla ,nombre ,dni_impartidor ,fecha ,tiempo ) "
			+ "VALUES('"+cod_charla+"','"+nombre+"','"+dni_impartidor+"','"+fecha+"','"+tiempo+"')";
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
public int existeEjercicio(String cod_ejercicio){
	
	String query = "SELECT * FROM Ejercicio WHERE cod_ejercicio = '"+cod_ejercicio+"'";
	ResultSet rs = null;
	int resp = 0;
	
		try {
			rs = stmt.executeQuery(query);
			if(rs.next()){ 
			String c = rs.getString("cod_ejercicio");
			if(!c.equals(cod_ejercicio))
				resp=0;	//El ejercicio existe.
			else
				resp=2;	//El ejercicio NO existe.
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
}

	public void insertarEjercicio(String cod_ejercicio ,String nombre ,String descripción ,
		double tiempo_estimado , String GIF  ){
	
	String query= "INSERT INTO Ejercicio(cod_ejercicio ,nombre ,descripción ,"
			+ "tiempo_estimado ,GIF  ) VALUES('"+cod_ejercicio+"','"+nombre+"','"+nombre+"','"+descripción+"','"
			+descripción+"','"+GIF+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}



	////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	* 						MÉTODOS PARA RUTINA
	* 
	*/
	
	public int existeRutina(String cod_rutina){
	
		String query = "SELECT * FROM Rutina WHERE cod_ejercicio = '"+cod_rutina+"'";
		ResultSet rs = null;
		int resp = 0;
	
		try {
			rs = stmt.executeQuery(query);
			if(rs.next()){ 
			String c = rs.getString("cod_rutina");
				if(!c.equals(cod_rutina))
					resp=0;	//La rutina existe.
				else
					resp=2;	//La rutina NO existe.
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return resp;
	}	

	public void insertarEjercicioEnRutina(String cod_ejercicio ,String cod_rutina ){
		
		String query= "INSERT INTO Rutina(cod_ejercicio ,cod_rutina) "
				+ "VALUES('"+cod_ejercicio+"','"+cod_rutina+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
	
	
	
	
		


