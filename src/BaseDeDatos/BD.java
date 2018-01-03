package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import Datos.Charla;
import Datos.Clase;
import Datos.Ejercicio;
import Datos.Impartidor;
import Datos.Profesor;
import Datos.RandomString;
import Datos.Rutina;
import Datos.Usuario;

public class BD {

	private Connection con;
	private static Statement stmt;

	/**
	 * Metodo que crea una sentencia para acceder a la base de datos
	 */
	public void crearSentencia() {
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que permite conectarse a la base de datos
	 */

	public void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:BaseDeDatos.db");
			crearSentencia();
		} catch (Exception e) {
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que cierra una sentencia
	 */
	public void cerrarSentencia() {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite desconectarse de la base de datos
	 */
	public void desconectar() {
		try {
			cerrarSentencia();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BD() {
		conectar();
	}

	public Statement createTable(Connection con) {

		// CREAR TABLA USUARIO
		try {
			stmt.setQueryTimeout(30);
			String Usuario = "CREATE TABLE Usuario (DNI string,nombre string, nick string,contrasenia string"
					+ ",apellido string,cuenta_bancaria string)";
			stmt.executeUpdate(Usuario);
		} catch (SQLException e) {
		} // Tabla ya existe. Nada que hacer.

		// CREAR TABLA PARTICIPANTE
		try {
			stmt.setQueryTimeout(30);
			String Participante = "CREATE TABLE Participante (DNI string,nombre string,apellido string,"
					+ "cuenta_bancaria string,codigo string)";
			stmt.executeUpdate(Participante);
		} catch (SQLException e) {
		} // Tabla ya existe. Nada que hacer.

		// CREAR TABLA EJERCICIO
		try {
			stmt.setQueryTimeout(30);
			String Ejercicio = "CREATE TABLE Ejercicio (cod_ejercicio string,nombre string,descripcion string,"
					+ "tiempo_estimado double,GIF string)";
			stmt.executeUpdate(Ejercicio);
		} catch (SQLException e) {
		} // Tabla ya existe. Nada que hacer.

		// CREAR TABLA TIPO
		try {
			stmt.setQueryTimeout(30);
			String Tipo = "CREATE TABLE Tipo (cod_tipo string,nombre string)";
			stmt.executeUpdate(Tipo);
		} catch (SQLException e) {
		} // Tabla ya existe. Nada que hacer.

		// CREAR TABLA CLASE
		try {
			stmt.setQueryTimeout(30);
			String Clase = "CREATE TABLE Clase (cod_clase string,nombre string,dni_profesor string,"
					+ "fecha string,tiempo double, numPlazas int)";
			stmt.executeUpdate(Clase);
		} catch (SQLException e) {
		} // Tabla ya existe. Nada que hacer.

		// CREAR TABLA CHARLA
		try {
			stmt.setQueryTimeout(30);
			String Charla = "CREATE TABLE Charla (cod_charla string,nombre string,dni_impartidor string,"
					+ "fecha string,tiempo double,numPlazas int)";
			stmt.executeUpdate(Charla);
		} catch (SQLException e) {
		} // Tabla ya existe. Nada que hacer.

		// CREAR TABLA IMPARTIDOR
		try {
			stmt.setQueryTimeout(30);
			String Impartidor = "CREATE TABLE Impartidor (dni_impartidor string,nombre string,"
					+ "apellidos string,salario int)";
			stmt.executeUpdate(Impartidor);
		} catch (SQLException e) {
		} // Tabla ya existe. Nada que hacer.

		// CREAR TABLA IMAGEN
		try {
			stmt.setQueryTimeout(30);
			String imagen = "CREATE TABLE imagen (idImagen int, ruta string)";
			stmt.executeUpdate(imagen);
		} catch (SQLException e) {
		} // Tabla ya existe. Nada que hacer.

		// CREAR TABLA PROFESOR
		try {
			stmt.setQueryTimeout(30);
			String Profesor = "CREATE TABLE Profesor (dni_profesor string,nombre string,"
					+ "apellidos string,salario int)";
			stmt.executeUpdate(Profesor);
		} catch (SQLException e) {
		} // Tabla ya existe. Nada que hacer.
		
		// CREAR TABLA RUTINA
				try {
					stmt.setQueryTimeout(30);
					String Profesor = "CREATE TABLE Rutina (dni_usuario string,numero int,"
							+ "cod_ejercicio string)";
					stmt.executeUpdate(Profesor);
				} catch (SQLException e) {
				} // Tabla ya existe. Nada que hacer.

		return null;
	}
	

	
	

	/* A partir de aquÌ hacemos las consultas especÌficas de cada proyecto */

	/**
	 * 
	 * @param nom:
	 *            Nombre introducido por el usuario
	 * @param con:
	 *            ContraseÒa introducida por el usuario
	 * @return : 0 - Si no existe el usuario 1 - Si sÌ existe el usuario pero la
	 *         contraseÒa no es correcta 2 - Si el nombre de usuario es correcto y
	 *         la contraseÒa tambiÈn
	 */
	public int existeUsuario(String nic, String con) {

		String query = "SELECT * FROM Usuario WHERE nick = '" + nic + "'";
		ResultSet rs = null;
		int resul = 0;
		try {
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				String n = rs.getString("nick");
				String c = rs.getString("contrasenia");
				if (!n.equals(nic))
					resul = 0; // El Nick es ERR�NEO
				else if (!c.equals(con))
					resul = 1; // La Contrase�a es ERR�NEA
				else
					resul = 2; // Nick Y Contrase�a BIEN INTRODUCIDAS.
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

	
	public int existeUsuario(String DNI) {

		String query = "SELECT * FROM Usuario WHERE DNI = '" + DNI + "'";
		ResultSet rs = null;
		int resul = 0;
		try {
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				String dni = rs.getString("DNI");
				if (!DNI.equals(dni))
					resul = 0; // El DNI es ERR�NEO
			
				else
					resul = 1; // DNI NO EXISTE.
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
	 * M�todo para Registrar Usuario.
	 *
	 * @param dNI
	 * @param nom
	 *            : Nombre del usuario
	 * @param nic
	 *            : Nick del usuario. Se usar� para acceder al perfil.
	 * @param con
	 *            : Contrase�a del usuario.
	 * @param ape1:
	 *            Primer apellido del usuario.
	 * @param ape2:
	 *            Segundo apellido del usuario.
	 * @param cuen:
	 *            Cuenta bancaria del usuario.
	 */
	public void registrarUsuario(String dNI, String nom, String nic, String con, String ape, String cuen) {
		String query = "INSERT INTO Usuario(DNI,nombre, nick,contrasenia,apellido,cuenta_bancaria) " + "VALUES('" + dNI
				+ "','" + nom + "','" + nic + "','" + con + "','" + ape + "','" + cuen + "')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

	/**
	 * M�todo para comprobar si un Participante est� alistado a un charla. Si un
	 * Participante est� alistado a un charla no puede volver a alistarse.
	 * 
	 * @param dni:
	 *            Nombre introducido por el usuario
	 * @return : 0 - Participante NO alistado a una charla. 1 - Participante SI
	 *         alistado a una charla.
	 */
	public boolean participanteAlistado(RandomString codigoAleatorio) {

		String query = "SELECT * FROM Participante WHERE codigo='" + codigoAleatorio + "'";
		ResultSet rs = null;
		boolean resul = false;
		try {
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				String c = rs.getString("codigo");
				if (!c.equals(codigoAleatorio))
					resul = false; // No hay ningun Particiapante Alistado con ese C�digo.
				else
					resul = true; // Ya hay un Perticipante Alistado con ese C�digo
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

	public ArrayList<String> obtenerRutasFotos() {
		System.out.println("Vamos a obtener las rutas de las fotos");
		ArrayList<String> aRutas = new ArrayList<String>();
		String query = "SELECT * FROM imagen WHERE idImagen";
		try {
			ResultSet rs = stmt.executeQuery(query);
			String ruta = rs.getString("ruta");
			aRutas.add(ruta);
			System.out.println(ruta);
			if (!rs.next())
				System.out.println("No se han obtenido resultados de la select");
			while (rs.next()) { // Mientras el ResultSet tenga datos
				ruta = rs.getString("ruta");
				aRutas.add(ruta);
				System.out.println(ruta);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aRutas;
	}

	public List<Clase> obtenerClases() {
		List<Clase> listaClases = new ArrayList<Clase>();
		List<Profesor> listaProfesores = obtenerProfesores();
		String query = "SELECT * FROM Clase";
		String queryNum = "SELECT COUNT(*) FROM Clase";
		String cod_clase;
		String nombre;
		String dni_profesor;
		String fecha;
		double tiempo;
		int numPlazas;

		try {
			ResultSet rs = stmt.executeQuery(query);
			ResultSet rsNum = stmt.executeQuery(queryNum);
			cod_clase = rs.getString("cod_clase");
			nombre = rs.getString("nombre");
			dni_profesor = rs.getString("dni_profesor");
			fecha = rs.getString("fecha");
			tiempo = rs.getDouble("tiempo");
			numPlazas = rs.getInt("numPlazas");

			for (int i = 0; i < rsNum.getFetchSize(); i++) {
				if (listaProfesores.get(i).getDni_prof().equals(dni_profesor)) {
					listaClases.add(new Clase(cod_clase, listaProfesores.get(i), nombre, fecha, tiempo, numPlazas));
				}
			}
			System.out.println(listaClases.get(0).toString());
			
			if (!rs.next())
				System.out.println("No se han obtenido resultados de la select");
			while (rs.next()) { // Mientras el ResultSet tenga datos
				cod_clase = rs.getString("cod_clase");
				nombre = rs.getString("nombre");
				dni_profesor = rs.getString("dni_profesor");
				fecha = rs.getString("fecha");
				tiempo = rs.getDouble("tiempo");

				for (int i = 0; i < rsNum.getFetchSize(); i++) {
					if (listaProfesores.get(i).getDni_prof().equals(dni_profesor)) {
						listaClases.add(new Clase(cod_clase, listaProfesores.get(i), nombre, fecha, tiempo, numPlazas));
					}
				}	
			}

			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaClases;
	}

	public void eliminarClase(String cod_clase){

		String query = "DELETE FROM Clase WHERE cod_clase ='" +cod_clase+ "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		
	}
	public void eliminarCharla(String cod_charla){

		String query = "DELETE FROM Charla WHERE cod_charla ='" +cod_charla+ "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		
	}
	public void eliminarRutina(String dni){

		String query = "DELETE FROM Rutina WHERE dni_usuario ='" +dni+ "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		
	}
	public List<Profesor> obtenerProfesores() {
		List<Profesor> listaProfesores = new ArrayList<Profesor>();
		String query = "SELECT * FROM Profesor";
		String nombre;
		String dni;
		String apellidos;
		int salario;
		try {
			ResultSet rs = stmt.executeQuery(query);
			dni = rs.getString("dni_profesor");
			nombre = rs.getString("nombre");
			apellidos = rs.getString("apellidos");
			salario = rs.getInt("salario");
			listaProfesores.add(new Profesor(dni, nombre, apellidos, salario));
			System.out.println(listaProfesores.get(0).toString());
			if (!rs.next())
				System.out.println("No se han obtenido resultados de la select");
			while (rs.next()) { // Mientras el ResultSet tenga datos
				dni = rs.getString("dni_profesor");
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				salario = rs.getInt("salario");
				listaProfesores.add(new Profesor(dni, nombre, apellidos, salario));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaProfesores;
	}

	 public List<Charla> obtenerCharlas() {
		List<Charla> listaCharlas= new ArrayList<Charla>();
		List<Impartidor> listaImpartidores = obtenerImpartidores();
		String query = "SELECT * FROM Charla";
		String cod_charla;
		String nombre;
		String dni_impartidor;
		String fecha;
		double tiempo;
		int numPlazas;

		try {
			ResultSet rs = stmt.executeQuery(query);
			cod_charla = rs.getString("cod_charla");
			nombre = rs.getString("nombre");
			dni_impartidor = rs.getString("dni_impartidor");
			fecha = rs.getString("fecha");
			tiempo = rs.getDouble("tiempo");
			numPlazas = rs.getInt("numPlazas");

			for (int i = 0; i < listaImpartidores.size(); i++) {
				if (listaImpartidores.get(i).getDni_impar().equals(dni_impartidor)) {
					listaCharlas.add(new Charla(cod_charla, listaImpartidores.get(i), nombre, fecha, tiempo, numPlazas));
				}
			}
			System.out.println(listaCharlas.get(0).toString());
			if (!rs.next())
				System.out.println("No se han obtenido resultados de la select");
			while (rs.next()) { // Mientras el ResultSet tenga datos
				cod_charla = rs.getString("cod_charla");
				nombre = rs.getString("nombre");
				dni_impartidor = rs.getString("dni_impartidor");
				fecha = rs.getString("fecha");
				tiempo = rs.getDouble("tiempo");

				for (int i = 0; i < listaImpartidores.size(); i++) {
					if (listaImpartidores.get(i).getDni_impar().equals(dni_impartidor)) {
						listaCharlas.add(new Charla(cod_charla, listaImpartidores.get(i), nombre, fecha, tiempo, numPlazas));
					}
				}
			}

			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaCharlas;
	}

	public List<Impartidor> obtenerImpartidores() {
		List<Impartidor> listaImpartidores = new ArrayList<Impartidor>();
		String query = "SELECT * FROM Impartidor";
		String nombre;
		String dni;
		String apellidos;
		int salario;
		try {
			ResultSet rs = stmt.executeQuery(query);
			dni = rs.getString("dni_impartidor");
			nombre = rs.getString("nombre");
			apellidos = rs.getString("apellidos");
			salario = rs.getInt("salario");
			listaImpartidores.add(new Impartidor(dni, nombre, apellidos, salario));
			System.out.println(listaImpartidores.get(0).toString());
			if (!rs.next())
				System.out.println("No se han obtenido resultados de la select");
			while (rs.next()) { // Mientras el ResultSet tenga datos
				dni = rs.getString("dni_impartidor");
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				salario = rs.getInt("salario");
				listaImpartidores.add(new Impartidor(dni, nombre, apellidos, salario));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaImpartidores;
	}

	public void registrarParticipante(String dNI, String nom, String ape, String cuen) {
		/**
		 * Crear el c�digo personal para cada Participante. Seguidamente, comprobar que
		 * el c�digo no existe, y en caso de existir crear uno nuevo.
		 */
		

		String query = "INSERT INTO Participante(DNI,nombre,apellido,cuenta_bancaria,codigo) "
				+ "VALUES('" + dNI + "','" + nom + "','" + ape + "','" + cuen + "','" + "CODIGO" + "')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int existeClases(String cod_clase) {

		String query = "SELECT * FROM Clase WHERE cod_clase = '" + cod_clase + "'";
		ResultSet rs = null;
		boolean resul = false;
		int resp = 0;

		try {
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				String c = rs.getString("cod_clase");
				if (!c.equals(cod_clase))
					resp = 0; // La Clase existe
				else
					resp = 1; // La clase NO existe.
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}

	public void introducirClase(String cod_clase, String nombre, String dni_profesor, String fecha, double tiempo,int numPlazas) {

		String query = "INSERT INTO Clase(cod_clase ,nombre ,dni_profesor ,fecha ,tiempo,numPlazas ) " + "VALUES('" + cod_clase
				+ "','" + nombre + "','" + dni_profesor + "','" + fecha + "','" + tiempo +"','"+numPlazas+ "')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

	public int existeCharla(String cod_charla, Date fecha) {

		String query = "SELECT * FROM Charla WHERE cod_charla = '" + cod_charla + "'";
		ResultSet rs = null;
		boolean resul = false;
		int resp = 0;

		try {
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				String c = rs.getString("cod_charla");
				Date f = rs.getDate("fecha");
				if (!c.equals(cod_charla))
					resp = 0; // La Charla existe
				else if (!f.equals(fecha))
					resp = 1; // La Charla existe, porque no puede haber la misma charla el mismo d�a.
								// Aunque una charla se puede impartir en varios dias.
								// La �nica condici�n es que una CHARLA NO se imparta el MISMO D�A.
				else
					resp = 2; // La charla no existe->puede crearse.
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}

	public void introducirCharla(String cod_charla, String nombre, String dni_impartidor, String fecha, double tiempo,int numPlazas) {

		String query = "INSERT INTO Charla(cod_charla ,nombre ,dni_impartidor ,fecha ,tiempo,numPlazas ) " + "VALUES('"
				+ cod_charla + "','" + nombre + "','" + dni_impartidor + "','" + fecha + "','" + tiempo +"','"+numPlazas+ "')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}
	
	public void alterarCharla(String cod,String nombre, String dni_impartidor, String fecha, double tiempo,int numPlazas){
		String query = "UPDATE Charla SET nombre = '"+ nombre +"' ,dni_impartidor= '"+ dni_impartidor +"' ,fecha = '"+ fecha +"'"
				+ ",tiempo= '"+ tiempo +"',numPlazas= '"+ numPlazas +"' WHERE cod_charla ='"+cod+"'";
				 
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

	public void alterarClase(String cod,String nombre, String dni_profesor, String fecha, double tiempo,int numPlazas){
		String query = "UPDATE Clase SET nombre = '"+ nombre +"' ,dni_profesor= '"+ dni_profesor +"' ,fecha = '"+ fecha +"'"
				+ ",tiempo= '"+ tiempo +"',numPlazas= '"+ numPlazas +"' WHERE cod_clase ='"+cod+"'";
				 
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		
		
	}
	
	  public ArrayList<String> obtenerRutasFotosAbdominales(){
	  System.out.println("Vamos a obtener las rutas de las fotos");
	  ArrayList<String> aRutas = new ArrayList<String>(); 
	  String query =
	  "SELECT * FROM imagen WHERE idImagen BETWEEN 4 AND 8"; try { ResultSet rs =
	  stmt.executeQuery(query); 
	  if(!rs.next()){
		  System.out.println("No se han obtenido resultados de la select");
		  }
	  while(rs.next()){ //Mientras el ResultSet tenga datos 
	  String ruta = rs.getString("ruta");
	  aRutas.add(ruta); 
	  System.out.println(ruta); }
	  rs.close(); } 
	  catch (SQLException e) { 
		  // TODO Auto-generated catch block
	  e.printStackTrace(); } 
	  return aRutas; }
	  
	  public ArrayList<String> obtenerRutasFotosBiceps(){
	  System.out.println("Vamos a obtener las rutas de las fotos");
	  ArrayList<String> aRutas = new ArrayList<String>(); String query =
	  "SELECT * FROM imagen WHERE idImagen BETWEEN 8 AND 12"; try { ResultSet rs =
	  stmt.executeQuery(query); if(!rs.next())
	  System.out.println("No se han obtenido resultados de la select");
	  while(rs.next()){ //Mientras el ResultSet tenga datos 
	String ruta = rs.getString("ruta"); aRutas.add(ruta); System.out.println(ruta); }
	  rs.close(); } catch (SQLException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); } return aRutas; }
	  
	  public ArrayList<String> obtenerRutasFotosCuadricepsDelante(){
	  System.out.println("Vamos a obtener las rutas de las fotos");
	  ArrayList<String> aRutas = new ArrayList<String>(); String query =
	  "SELECT * FROM imagen WHERE idImagen BETWEEN 12 AND 16"; try { ResultSet rs =
	  stmt.executeQuery(query); if(!rs.next())
	  System.out.println("No se han obtenido resultados de la select");
	  while(rs.next()){ //Mientras el ResultSet tenga datos 
		  String ruta = rs.getString("ruta"); aRutas.add(ruta); System.out.println(ruta); }
	  rs.close(); } catch (SQLException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); } return aRutas; }
	  
	  public ArrayList<String> obtenerRutasFotosCuadricepsDetras(){
	  System.out.println("Vamos a obtener las rutas de las fotos");
	  ArrayList<String> aRutas = new ArrayList<String>(); String query =
	  "SELECT * FROM imagen WHERE idImagen BETWEEN 16 AND 20"; try { ResultSet rs =
	  stmt.executeQuery(query); if(!rs.next())
	  System.out.println("No se han obtenido resultados de la select");
	  while(rs.next()){ //Mientras el ResultSet tenga datos 
		  String ruta = rs.getString("ruta"); aRutas.add(ruta); System.out.println(ruta); }
	  rs.close(); } catch (SQLException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); } return aRutas;
	  
	  }
	  
	  public ArrayList<String> obtenerRutasFotosEspalda(){
	  System.out.println("Vamos a obtener las rutas de las fotos");
	  ArrayList<String> aRutas = new ArrayList<String>(); String query =
	  "SELECT * FROM imagen WHERE idImagen BETWEEN 20 AND 24"; try { ResultSet rs =
	  stmt.executeQuery(query); if(!rs.next())
	  System.out.println("No se han obtenido resultados de la select");
	  while(rs.next()){ //Mientras el ResultSet tenga datos 
		  String ruta = rs.getString("ruta"); aRutas.add(ruta); System.out.println(ruta); }
	  rs.close(); } catch (SQLException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); } return aRutas; }
	  
	  public ArrayList<String> obtenerRutasFotosGemelos(){
	  System.out.println("Vamos a obtener las rutas de las fotos");
	  ArrayList<String> aRutas = new ArrayList<String>(); String query =
	  "SELECT * FROM imagen WHERE idImagen BETWEEN 24 AND 28"; try { ResultSet rs =
	  stmt.executeQuery(query); if(!rs.next())
	  System.out.println("No se han obtenido resultados de la select");
	  while(rs.next()){ //Mientras el ResultSet tenga datos
		  String ruta = rs.getString("ruta"); aRutas.add(ruta); System.out.println(ruta); }
	  rs.close(); } catch (SQLException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); } return aRutas; }
	  
	 public ArrayList<String> obtenerRutasFotosGluteos(){
	 System.out.println("Vamos a obtener las rutas de las fotos");
	  ArrayList<String> aRutas = new ArrayList<String>(); String query =
	  "SELECT * FROM imagen WHERE idImagen BETWEEN 28 AND 32"; try { ResultSet rs =
	  stmt.executeQuery(query); if(!rs.next())
	  System.out.println("No se han obtenido resultados de la select");
	  while(rs.next()){ //Mientras el ResultSet tenga datos 
		  String ruta = rs.getString("ruta"); aRutas.add(ruta); System.out.println(ruta); }
	  rs.close(); } catch (SQLException e) { // TODO Auto-generated catch block
	 e.printStackTrace(); } return aRutas; }
	 
	  public ArrayList<String> obtenerRutasFotosHombros(){
	  System.out.println("Vamos a obtener las rutas de las fotos");
	  ArrayList<String> aRutas = new ArrayList<String>(); String query =
	  "SELECT * FROM imagen WHERE idImagen BETWEEN 32 AND 36"; try { ResultSet rs =
	  stmt.executeQuery(query); if(!rs.next())
	  System.out.println("No se han obtenido resultados de la select");
	  while(rs.next()){ //Mientras el ResultSet tenga datos 
		  String ruta = rs.getString("ruta"); aRutas.add(ruta); System.out.println(ruta); }
	  rs.close(); } catch (SQLException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); } return aRutas; }
	  
	  public ArrayList<String> obtenerRutasFotosLumbares(){
	  System.out.println("Vamos a obtener las rutas de las fotos");
	  ArrayList<String> aRutas = new ArrayList<String>(); String query =
	  "SELECT * FROM imagen WHERE idImagen BETWEEN 36 AND 40"; try { ResultSet rs =
	  stmt.executeQuery(query); if(!rs.next())
	  System.out.println("No se han obtenido resultados de la select");
	  while(rs.next()){ //Mientras el ResultSet tenga datos 
		  String ruta = rs.getString("ruta"); aRutas.add(ruta); System.out.println(ruta); }
	  rs.close(); } catch (SQLException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); } return aRutas; }
	  
	  public ArrayList<String> obtenerRutasFotosTriceps(){
	  System.out.println("Vamos a obtener las rutas de las fotos");
	  ArrayList<String> aRutas = new ArrayList<String>(); String query =
	  "SELECT * FROM imagen WHERE idImagen>=40"; try { ResultSet rs =
	  stmt.executeQuery(query); if(!rs.next())
	  System.out.println("No se han obtenido resultados de la select");
	  while(rs.next()){ //Mientras el ResultSet tenga datos 
		  String ruta = rs.getString("ruta"); aRutas.add(ruta); System.out.println(ruta); }
	  rs.close(); } catch (SQLException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); } return aRutas; }
	
	  public List<Usuario> obtenerUsuarios(){
		  List<Usuario> listaUsuarios= new ArrayList<Usuario>();
		  String query = "SELECT * FROM Usuario";
			String nombre;
			String dni;
			String apellidos;
			String nic;
			String con;
			String cuent;
			
			try {
				ResultSet rs = stmt.executeQuery(query);
				dni = rs.getString("DNI");
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				nic = rs.getString("nick");
				cuent = rs.getString("cuenta_bancaria");
				con = rs.getString("contrasenia");
				listaUsuarios.add(new Usuario(dni, nombre,nic,con, apellidos, cuent));
				System.out.println(listaUsuarios.get(0).toString());
				if (!rs.next())
					System.out.println("No se han obtenido resultados de la select");
				while (rs.next()) { // Mientras el ResultSet tenga datos
					dni = rs.getString("DNI");
					nombre = rs.getString("nombre");
					apellidos = rs.getString("apellidos");
					nic = rs.getString("nick");
					cuent = rs.getString("cuenta_bancaria");
					con = rs.getString("contrasenia");
					listaUsuarios.add(new Usuario(dni, nombre,nic,con, apellidos, cuent));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return listaUsuarios;
	  }
	  
	  
	  public List<Rutina> obtenerRutina(){
		  
	  List<Rutina> Rutina= new ArrayList<Rutina>();
	  List<Usuario> Usuarios = obtenerUsuarios();
		String query = "SELECT * FROM Rutina";
		
		ArrayList<Ejercicio> listaEjercicio = null;
		String DNI;
		String cod_ejercicio;
		int numero;
		

		try {
			ResultSet rs = stmt.executeQuery(query);
			cod_ejercicio = rs.getString("cod_ejercicio");
			DNI = rs.getString("DNI");
			numero = rs.getInt("numero");
			
			for (int i = 0; i < Usuarios.size(); i++) {
				if (Usuarios.get(i).getDNI().equals(DNI)) {
					for(int j = 0;j < listaEjercicio.size();j++){
						if(listaEjercicio.get(i).getId_eje().equals(cod_ejercicio)){
							Rutina.add(new Rutina(listaEjercicio, Usuarios.get(i), numero));
						}
						
					}
					
				}
			}
			System.out.println(Usuarios.get(0).toString());
			if (!rs.next())
				System.out.println("No se han obtenido resultados de la select");
			while (rs.next()) { // Mientras el ResultSet tenga datos
				cod_ejercicio = rs.getString("cod_ejercicio");
				DNI = rs.getString("DNI");
				numero = rs.getInt("numero");

				for (int i = 0; i < Usuarios.size(); i++) {
					if (Usuarios.get(i).getDNI().equals(DNI)) {
						for(int j = 0;j < listaEjercicio.size();j++){
							if(listaEjercicio.get(i).getId_eje().equals(cod_ejercicio)){
								Rutina.add(new Rutina(listaEjercicio, Usuarios.get(i), numero));
							}
							
						}
						
					}
				}
			}

			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rutina;
	}
	  
	  public void introducirEjercicio(String Codigo,String Nombre, String Descripcion,double Duracion,String Gif){
		  
		 
		String query = "INSERT INTO Ejercicio(cod_ejercicio ,nombre ,descripcion ,tiempo_estimado, GIF ) " + "VALUES('" 
						 + Codigo + "','" + Nombre + "','" + Descripcion + "','" + Duracion +"','"+Gif+ "')";
		try {
				stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
			
	  }
	  
	  public void eliminarEjercicio(String cod_ejercicio){
		 
		  String query = "DELETE FROM Ejercicio WHERE cod_ejercicio ='" +cod_ejercicio+ "'";
			try {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	  }
	  
	  public void introducirRutina(int orden,String dni,String cod_ejercicio){
		  
			String query = "INSERT INTO Rutina(dni_usuario,numero,cod_ejercicio ) " 
			+ "VALUES('" + dni + "','" + orden + "','" + cod_ejercicio +  "')";
			try {
					stmt.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		  
	  }
	  
	  
	  public int contarEjercicios(String dni){
		  String query = "SELECT * FROM Rutina WHERE dni_usuario= '"+dni+"'";
		  int num=0;
		  
		  try {
			  System.out.println("ENTRA EN CONTAR EJERCICIOS");
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				num++;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		  return num;
	  }
	  
	  public Object[][]obtenerTablaRutina(String dni){
		  System.out.println("DENTRO DE PRIMERO");
		  int num = contarEjercicios(dni);
		  Object tabla[][]= new Object [num][3];
		  ResultSet rs1,rs2;
		  String cod_ejercicio,nombre,descripcion;
		  double tiempo_estimado;
		  String query1 ="SELECT * FROM Rutina WHERE dni_usuario='"+dni+"'";
		  try {
			rs1 = stmt.executeQuery(query1);
			System.out.println("DENTRO DE algo");
			while(rs1.next()){
				System.out.println("DENTRO DE RUTINA");
				cod_ejercicio = rs1.getString("cod_ejercicio");
				String query2 = "SELECT * FROM Ejercicio  WHERE cod_ejercicio= '"+cod_ejercicio+"'";
				rs2=stmt.executeQuery(query2);
				int i = 0;
				System.out.println("DENTRO DE WWWWWWWWWWW");
				while(rs2.next()){
					System.out.println("COD_EJERCICIO DENTRO");
					nombre=rs2.getString("nombre");
					descripcion=rs2.getString("descripcion");
					tiempo_estimado=rs2.getDouble("tiempo_estimado");
					tabla[i][0] =nombre;
		  			tabla[i][1] = descripcion;
		  			tabla[i][2] = tiempo_estimado;
					i++;
				}rs2.close();	
			}rs1.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  return tabla;
	  }
	
	  /**
	  public Object[][] obtenerTablaEjercicios(String dni){
		  int num = contarEjercicios(dni);
		  String query = "SELECT cod_ejercicio FROM RUTINA WHERE dni_usuario="+dni;
		  ResultSet rs,rs1;
		  String cod_ejercicio=null;
		  Object tabla[][]=null;
		
			try {
				rs = stmt.executeQuery(query);
				while(rs.next()){
					cod_ejercicio = rs.getString("cod_ejercicio");
				
				  
					tabla = new Object[num][3];
					String query1 = "SELECT * FROM Ejercicio WHERE cod_ejercicio = "+cod_ejercicio;
				  	
				  		 rs1 = stmt.executeQuery(query1);
				  		int i=0;
				  		while(rs1.next()){
				  			tabla[i][0] = rs1.getString("nombre");
				  			tabla[i][1] = rs1.getString("descripcion");
				  			tabla[i][2] = rs1.getDouble("tiempo_estimado");
				  			i++;
				  		}
				  		rs1.close();
				}rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
				  	
			return tabla;
	  }
	  */
	  public List<Ejercicio> obtenerEjercicios(){
		  List<Ejercicio> listaEjercicios = new ArrayList<Ejercicio>();
			String query = "SELECT * FROM Ejercicio";
			String cod_ejercicio;
			String nombre;
			String descripcion;
			double tiempo_estimado;
			String GIF;
			
			try {
				ResultSet rs = stmt.executeQuery(query);
				cod_ejercicio = rs.getString("cod_ejercicio");
				nombre = rs.getString("nombre");
				descripcion = rs.getString("descripcion");
				tiempo_estimado = rs.getDouble("tiempo_estimado");
				GIF = rs.getString("GIF");
				listaEjercicios.add(new Ejercicio(cod_ejercicio, nombre, descripcion, tiempo_estimado,GIF));
				System.out.println(listaEjercicios.get(0).toString());
				if (!rs.next())
					System.out.println("No se han obtenido resultados de la select");
				while (rs.next()) { // Mientras el ResultSet tenga datos
					cod_ejercicio = rs.getString("cod_ejercicio");
					nombre = rs.getString("nombre");
					descripcion = rs.getString("descripcion");
					tiempo_estimado = rs.getDouble("tiempo_estimado");
					GIF = rs.getString("GIF");
					listaEjercicios.add(new Ejercicio(cod_ejercicio, nombre, descripcion, tiempo_estimado,GIF));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listaEjercicios;
	  }
	  
	  public String obtenerDNIUsuario(String nick,String pass){
		  
		  String dni="";
		  String query="SELECT * FROM Usuario WHERE nick ='"+nick+"' AND contrasenia= '"+pass+"'";
		  try {
			  
			ResultSet rs = stmt.executeQuery(query);
			dni = rs.getString("DNI");
			System.out.println("EL PUTO DNI ES: "+dni);
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return dni;
	  }
	  
	  public String obtenerRuta(String nombreEjercicio){
		  String query = "SELECT GIF FROM Ejercicio WHERE nombre='"+nombreEjercicio+"'";
		  String gif="";
		  try {
			ResultSet rs = stmt.executeQuery(query);
			gif = rs.getString("GIF");
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return gif;
	  }
	  
	  public double obtenerTiempoRutina(String nombreEjercicio){
		  String query = "SELECT tiempo_estimado FROM Ejercicio WHERE nombre='"+nombreEjercicio+"'";
		  double tiempo=0;
		  try {
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
				tiempo = rs.getDouble("tiempo_estimado");
			rs.close();
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		  
		  return tiempo;
	  }

}
