package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import org.jvnet.substance.SubstanceComboBoxUI.ComboBoxPropertyChangeHandler;


import Datos.Ejercicio;
import Datos.Impartidor;
import Datos.Profesor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.FlowLayout;
import javax.swing.JEditorPane;

public class VentanaAdministrador extends JFrame {

	private String OPC;
	private String COD;
	private JPanel contentPane;
	private JMenu mnModificarClase;
	private JMenuItem mntmEliminarClase;
	private JMenuItem mntmAadirClase;
	private JMenuItem mntmAlterarClase;
	private JMenuItem mntmAadirCharla;
	private JMenuItem mntmAlterarCharla;
	private static  JMenu mnModificarRutina;
	private static  JMenuItem mntmEliminarRutina;
	private static  JComboBox<String> comboBoxProfesores;
	private static  JPanel panel_8 = new JPanel();
	private static  JTextField textCodigo = new JTextField();
	private static  JTextField textNombre = new JTextField();
	private static  JTextField textDuracion = new JTextField();
	private static  JTextField textPlazas = new JTextField(); 
	private static  JLabel lblCodigo = new JLabel(); 
	private static  JLabel lblNombre = new JLabel(); 
	private static  JLabel lblDuracion= new JLabel(); 
	private static  JLabel lblPlazas= new JLabel();  
	private static  JLabel lblProfesor= new JLabel(); 
	private static  JDateChooser Fecha= new JDateChooser(); 
	private static  JLabel lblFecha= new JLabel(); 
	private static  JButton btnCrear;
	private static  JComboBox<String> comboBoxImpartidores;
	private static 	JComboBox <String> comboBox_EJERCICIO_1;
	private static 	JComboBox <String> comboBox_EJERCICIO_2;
	private static  JComboBox <String> comboBox_EJERCICIO_3;
	private static  JComboBox <String> comboBox_EJERCICIO_4;
	private static  JComboBox <String> comboBox_EJERCICIO_5;
	private static  JMenu mnMo;
	private static  JMenuItem mntmElim;
	private static  JMenuItem mntmAadirEjercicio;
	private static JMenuItem mntmAlterarEjercicio;
	private static  JEditorPane editorPaneDescripcion = new JEditorPane();
	private static JTextField textGif;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdministrador frame = new VentanaAdministrador();
					frame.setVisible(true);
					panel_8.setVisible(true);
					textCodigo.setVisible(false);
					textDuracion.setVisible(false);
					textNombre.setVisible(false);
					textPlazas.setVisible(false);
					Fecha.setVisible(false);
					lblNombre.setVisible(false);
					lblProfesor.setVisible(false);
					lblDuracion.setVisible(false);
					lblPlazas.setVisible(false);
					lblFecha.setVisible(false);
					btnCrear.setVisible(false);
					editorPaneDescripcion.setVisible(false);
					textGif.setVisible(false);
					comboBox_EJERCICIO_1.setVisible(false);
					comboBox_EJERCICIO_2.setVisible(false);
					comboBox_EJERCICIO_3.setVisible(false);
					comboBox_EJERCICIO_4.setVisible(false);
					comboBox_EJERCICIO_5.setVisible(false);
					comboBoxProfesores.setVisible(false);
					comboBoxImpartidores.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblAdministrador = new JLabel("ADMINISTRADOR");
		lblAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblAdministrador);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAdministrador.this.dispose();
				VentanaInicio frame = new VentanaInicio();
				frame.setVisible(true);
			}
		});
		panel_1.add(btnAtras);
		
		btnCrear = new JButton("CREAR ");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OPC.equalsIgnoreCase("introducir_clase")){
					//INTRODUCIR CLASE
					String profesorDNI = ((String)comboBoxProfesores.getSelectedItem()).substring(3, 14);
					String fecha =  String.valueOf(Fecha.getDate().toString().substring(8, 10))+"/"+String.valueOf(Fecha.getDate().getMonth()+1)+"/"+String.valueOf(Fecha.getDate().getYear()+1900);
					VentanaDecision.bd.introducirClase(textCodigo.getText(), textNombre.getText(), profesorDNI, fecha , Double.parseDouble(textDuracion.getText()),Integer.parseInt(textPlazas.getText()));
					System.out.println("Clase introducida correctamente.");
					
				}else if(OPC.equalsIgnoreCase("introducir_charla")){
					//INTRODUCIR CHARLA
					String ImpartidorDNI = ((String)comboBoxImpartidores.getSelectedItem()).substring(3, 14);
					String fecha =  String.valueOf(Fecha.getDate().toString().substring(8, 10))+"/"+String.valueOf(Fecha.getDate().getMonth()+1)+"/"+String.valueOf(Fecha.getDate().getYear()+1900);
					VentanaDecision.bd.introducirCharla(textCodigo.getText(), textNombre.getText(), ImpartidorDNI, fecha , Double.parseDouble(textDuracion.getText()),Integer.parseInt(textPlazas.getText()));
					System.out.println("Charla introducida correctamente.");
					System.out.println(fecha);
				}else if(OPC.equalsIgnoreCase("introducir_rutina")){
					//INTRODUCIR RUTINA
					//Crear una lista con los ejercicios seleccionados
					List<String> ejercicios = new ArrayList<String>(5);
					
					
					ejercicios.add(comboBox_EJERCICIO_1.getSelectedItem().toString().substring(0,4));
					ejercicios.add(comboBox_EJERCICIO_2.getSelectedItem().toString().substring(0,4));
					ejercicios.add(comboBox_EJERCICIO_3.getSelectedItem().toString().substring(0,4));
					ejercicios.add(comboBox_EJERCICIO_4.getSelectedItem().toString().substring(0,4));
					ejercicios.add(comboBox_EJERCICIO_5.getSelectedItem().toString().substring(0,4));
					
					
					String opc= JOptionPane.showInputDialog(null, "Introduzca el DNI del usuario al que desea crear una rutina:");
					
					if(opc!=null&&VentanaDecision.bd.existeUsuario(opc)==1){
						
							int conf = JOptionPane.showConfirmDialog(null, "Recuerde que al crear una nueva rutina se eliminara automaticamente la anterior rutina que corresponda a este usuario."
								+ "\n Desea de todo modos continuar y crear una nueva rutina?");
						if(conf==0){
							VentanaDecision.bd.eliminarRutina(opc);
							introducirRutina(opc,ejercicios);
							System.out.println("Rutina introducida correctamente.");
						}else{
							System.out.println("Rutina introducida INcorrectamente.");
						}
					}else{
						JOptionPane.showMessageDialog(null,"El DNI introducido no corresponde con ningun usuario.");
					}
					
					
				}else if(OPC.equalsIgnoreCase("introducir_ejercicio")){
					//INTRODUCIR EJERCICIO
					VentanaDecision.bd.introducirEjercicio(textCodigo.getText(),textNombre.getText(),editorPaneDescripcion.getText(),Double.parseDouble(textDuracion.getText()),textGif.getText());
					System.out.println("Ejercicio introducido correctamente.");
				
				}else if(OPC.equalsIgnoreCase("alterar_clase")){
					//ALTERAR CLASE
					String profesorDNI = ((String)comboBoxProfesores.getSelectedItem()).substring(3, 14);
					String fecha =  String.valueOf(Fecha.getDate().toString().substring(8, 10))+"/"+String.valueOf(Fecha.getDate().getMonth()+1)+"/"+String.valueOf(Fecha.getDate().getYear()+1900);
					VentanaDecision.bd.alterarClase(COD, textNombre.getText(), profesorDNI, fecha , Double.parseDouble(textDuracion.getText()),Integer.parseInt(textPlazas.getText()));
					System.out.println("Clase alterada con exito.");
					
				}else if(OPC.equalsIgnoreCase("alterar_charla")){
					//ALTERAR CHARLA
					String ImpartidorDNI = ((String)comboBoxImpartidores.getSelectedItem()).substring(3, 14);
					String fecha =  String.valueOf(Fecha.getDate().toString().substring(8, 10))+"/"+String.valueOf(Fecha.getDate().getMonth()+1)+"/"+String.valueOf(Fecha.getDate().getYear()+1900);
					VentanaDecision.bd.alterarCharla(COD, textNombre.getText(), ImpartidorDNI, fecha , Double.parseDouble(textDuracion.getText()),Integer.parseInt(textPlazas.getText()));
					System.out.println("Charla alterada con exito.");
					
				}else if(OPC.equalsIgnoreCase("alterar_ejercicio")){
					//ALTERAR EJERCICIO
					VentanaDecision.bd.alterarEjercicio(COD,textNombre.getText(),editorPaneDescripcion.getText(),Double.parseDouble(textDuracion.getText()),textGif.getText());
					System.out.println("Ejercicio alterado con exito.");
				}else {
					
				}
			
				
			}
		});
		panel_1.add(btnCrear);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panel_7.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnModificarCharla = new JMenu("MODIFICAR CHARLA");
		menuBar.add(mnModificarCharla);
		
		JMenuItem mntmEliminarCharla = new JMenuItem("ELIMINAR CHARLA");
		mntmEliminarCharla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cod = JOptionPane.showInputDialog("Introduzca el codigo de la charla que deseas eliminar:");
				if(!cod.equals(null)){
					int opc =JOptionPane.showConfirmDialog(null, "Estas seguro de querer eliminar la charla con codigo "+cod);
				if(opc==0){
					VentanaDecision.bd.eliminarCharla(cod);
					System.out.println("Charla con codigo "+cod+" eliminada.");
				}
				}
				
				
			}
		});
		mnModificarCharla.add(mntmEliminarCharla);
		
		mntmAadirCharla = new JMenuItem("AÑADIR CHARLA");
		mntmAadirCharla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCrear.setText("AÑADIR");
				panel_8.setVisible(true);
				textCodigo.setVisible(true);
				textDuracion.setVisible(true);
				textNombre.setVisible(true);
				textPlazas.setVisible(true);
				lblProfesor.setText("IMPARTIDOR");
				lblPlazas.setText("PLAZAS");
				comboBoxProfesores.setVisible(false);
				comboBoxImpartidores.setVisible(true);
				Fecha.setVisible(true);
				lblCodigo.setText("CODIGO");
				lblNombre.setText("NOMBRE");
				lblProfesor.setText("IMPARTIDOR");
				lblDuracion.setText("DURACION");
				lblPlazas.setText("PLAZAS");
				lblFecha.setText("FECHA");
				lblCodigo.setVisible(true);
				lblNombre.setVisible(true);
				lblProfesor.setVisible(true);
				lblDuracion.setVisible(true);
				lblPlazas.setVisible(true);
				lblFecha.setVisible(true);
				btnCrear.setVisible(true);
				editorPaneDescripcion.setVisible(false);
				textGif.setVisible(false);
				comboBox_EJERCICIO_1.setVisible(false);
				comboBox_EJERCICIO_2.setVisible(false);
				comboBox_EJERCICIO_3.setVisible(false);
				comboBox_EJERCICIO_4.setVisible(false);
				comboBox_EJERCICIO_5.setVisible(false);
				OPC="introducir_charla";
				
			}
		});
		mnModificarCharla.add(mntmAadirCharla);
		
		mntmAlterarCharla = new JMenuItem("ALTERAR CHARLA");
		mntmAlterarCharla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cod = JOptionPane.showInputDialog("Introduzca el codigo de la charla que deseas alterar:");
				
				if(cod!=null){
					btnCrear.setText("ALTERAR");
					panel_8.setVisible(true);
					textCodigo.setVisible(false);
					textDuracion.setVisible(true);
					textNombre.setVisible(true);
					textPlazas.setVisible(true);
					lblProfesor.setText("IMPARTIDOR");
					lblPlazas.setText("PLAZAS");
					comboBoxProfesores.setVisible(false);
					comboBoxImpartidores.setVisible(true);
					Fecha.setVisible(true);
					lblCodigo.setText("CODIGO");
					lblNombre.setText("NOMBRE");
					lblProfesor.setText("IMPARTIDOR");
					lblDuracion.setText("DURACION");
					lblPlazas.setText("PLAZAS");
					lblFecha.setText("FECHA");
					lblCodigo.setVisible(false);
					lblNombre.setVisible(true);
					lblProfesor.setVisible(true);
					lblDuracion.setVisible(true);
					lblPlazas.setVisible(true);
					lblFecha.setVisible(true);
					btnCrear.setVisible(true);
					editorPaneDescripcion.setVisible(false);
					textGif.setVisible(false);
					comboBox_EJERCICIO_1.setVisible(false);
					comboBox_EJERCICIO_2.setVisible(false);
					comboBox_EJERCICIO_3.setVisible(false);
					comboBox_EJERCICIO_4.setVisible(false);
					comboBox_EJERCICIO_5.setVisible(false);
					OPC="alterar_charla";
					COD = cod;
				}
				
			}
		});
		mnModificarCharla.add(mntmAlterarCharla);
		
		mnModificarClase = new JMenu("MODIFICAR CLASE");
		menuBar.add(mnModificarClase);
		
		mntmEliminarClase = new JMenuItem("ELIMINAR CLASE");
		mntmEliminarClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cod = JOptionPane.showInputDialog("Introduzca el codigo de la clase que deseas eliminar:");
			if(!cod.equals(null)){
				int opc =JOptionPane.showConfirmDialog(null, "Esta seguro de querer eliminar la clase con codigo "+cod);
				if(opc==0){
					VentanaDecision.bd.eliminarClase(cod);
					System.out.println("Clase con codigo "+cod+" eliminada.");
				}
			}
			}
		});
		mnModificarClase.add(mntmEliminarClase);
		
		mntmAadirClase = new JMenuItem("AÑADIR CLASE");
		mntmAadirClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCrear.setText("AÑADIR");
				panel_8.setVisible(true);
				textCodigo.setVisible(true);
				textDuracion.setVisible(true);
				textNombre.setVisible(true);
				textPlazas.setVisible(true);
				lblProfesor.setText("PROFESOR");
				lblPlazas.setText("PLAZAS");
				comboBoxProfesores.setVisible(true);
				comboBoxImpartidores.setVisible(false);
				Fecha.setVisible(true);
				lblCodigo.setText("CODIGO");
				lblNombre.setText("NOMBRE");
				lblProfesor.setText("PROFESOR");
				lblDuracion.setText("DURACION");
				lblPlazas.setText("PLAZAS");
				lblFecha.setText("FECHA");
				lblCodigo.setVisible(true);
				lblNombre.setVisible(true);
				lblProfesor.setVisible(true);
				lblDuracion.setVisible(true);
				lblPlazas.setVisible(true);
				lblFecha.setVisible(true);
				btnCrear.setVisible(true);
				editorPaneDescripcion.setVisible(false);
				textGif.setVisible(false);
				comboBox_EJERCICIO_1.setVisible(false);
				comboBox_EJERCICIO_2.setVisible(false);
				comboBox_EJERCICIO_3.setVisible(false);
				comboBox_EJERCICIO_4.setVisible(false);
				comboBox_EJERCICIO_5.setVisible(false);
				OPC="introducir_clase";
				
			}
		});
		
		
		mnModificarClase.add(mntmAadirClase);
		
		mntmAlterarClase = new JMenuItem("ALTERAR CLASE");
		mntmAlterarClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cod = JOptionPane.showInputDialog("Introduzca el codigo de la clase que deseas alterar:");
				
				if(cod!=null){
					btnCrear.setText("ALTERAR");
					panel_8.setVisible(true);
					textCodigo.setVisible(false);
					textDuracion.setVisible(true);
					textNombre.setVisible(true);
					textPlazas.setVisible(true);
					lblProfesor.setText("PROFESOR");
					lblPlazas.setText("PLAZAS");
					comboBoxProfesores.setVisible(true);
					comboBoxImpartidores.setVisible(false);
					Fecha.setVisible(true);
					lblCodigo.setText("CODIGO");
					lblNombre.setText("NOMBRE");
					lblProfesor.setText("PROFESOR");
					lblDuracion.setText("DURACION");
					lblPlazas.setText("PLAZAS");
					lblFecha.setText("FECHA");
					lblCodigo.setVisible(false);
					lblNombre.setVisible(true);
					lblProfesor.setVisible(true);
					lblDuracion.setVisible(true);
					lblPlazas.setVisible(true);
					lblFecha.setVisible(true);
					btnCrear.setVisible(true);
					editorPaneDescripcion.setVisible(false);
					textGif.setVisible(false);
					comboBox_EJERCICIO_1.setVisible(false);
					comboBox_EJERCICIO_2.setVisible(false);
					comboBox_EJERCICIO_3.setVisible(false);
					comboBox_EJERCICIO_4.setVisible(false);
					comboBox_EJERCICIO_5.setVisible(false);
					OPC="alterar_clase";
					COD = cod;
				}
				
			}
		});
		mnModificarClase.add(mntmAlterarClase);
		
		mnMo = new JMenu("MODIFICAR EJERCICIO");
		menuBar.add(mnMo);
		
		mntmElim = new JMenuItem("ELIMINAR EJERCICIO");
		mntmElim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cod = JOptionPane.showInputDialog("Introduzca el codigo del ejercicio que deseas eliminar:");
			if(!cod.equals(null)){
				int opc =JOptionPane.showConfirmDialog(null, "Esta seguro de querer eliminar el ejercicio con codigo "+cod);
				if(opc==0){
					VentanaDecision.bd.eliminarEjercicio(cod);
					System.out.println("Ejercicio con codigo "+cod+" eliminado.");
				}
			}
			}
		});
		mnMo.add(mntmElim);
		
		mntmAadirEjercicio = new JMenuItem("AÑADIR EJERCICIO");
		mntmAadirEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				btnCrear.setText("AÑADIR");
				panel_8.setVisible(true);
				textCodigo.setVisible(true);
				textDuracion.setVisible(true);
				textNombre.setVisible(true);
				textPlazas.setVisible(false);
				lblDuracion.setText("DURACION EJERCICIO");
				lblProfesor.setText("DESCRIPCION");
				lblPlazas.setText("GIF");
				comboBoxProfesores.setVisible(false);
				comboBoxImpartidores.setVisible(false);
				Fecha.setVisible(false);
				lblCodigo.setVisible(true);
				lblNombre.setVisible(true);
				lblProfesor.setVisible(true);
				lblDuracion.setVisible(true);
				lblPlazas.setVisible(true);
				lblFecha.setVisible(false);
				btnCrear.setVisible(true);
				editorPaneDescripcion.setVisible(true);
				textGif.setVisible(true);
				comboBox_EJERCICIO_1.setVisible(false);
				comboBox_EJERCICIO_2.setVisible(false);
				comboBox_EJERCICIO_3.setVisible(false);
				comboBox_EJERCICIO_4.setVisible(false);
				comboBox_EJERCICIO_5.setVisible(false);
				OPC="introducir_ejercicio";
			}
		});
		mnMo.add(mntmAadirEjercicio);
		
		mntmAlterarEjercicio = new JMenuItem("ALTERAR EJERCICIO");
		mntmAlterarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String cod = JOptionPane.showInputDialog("Introduzca el codigo del ejercicio que deseas alterar:");
				
				if(cod!=null){
				btnCrear.setText("ALTERAR");
				panel_8.setVisible(true);
				textCodigo.setVisible(true);
				textDuracion.setVisible(true);
				textNombre.setVisible(true);
				textPlazas.setVisible(false);
				lblDuracion.setText("DURACION EJERCICIO");
				lblProfesor.setText("DESCRIPCION");
				lblPlazas.setText("GIF");
				comboBoxProfesores.setVisible(false);
				comboBoxImpartidores.setVisible(false);
				Fecha.setVisible(false);
				lblCodigo.setVisible(true);
				lblNombre.setVisible(true);
				lblProfesor.setVisible(true);
				lblDuracion.setVisible(true);
				lblPlazas.setVisible(true);
				lblFecha.setVisible(false);
				btnCrear.setVisible(true);
				editorPaneDescripcion.setVisible(true);
				textGif.setVisible(true);
				comboBox_EJERCICIO_1.setVisible(false);
				comboBox_EJERCICIO_2.setVisible(false);
				comboBox_EJERCICIO_3.setVisible(false);
				comboBox_EJERCICIO_4.setVisible(false);
				comboBox_EJERCICIO_5.setVisible(false);
				OPC="introducir_ejercicio";
				}
			}
		});
		mnMo.add(mntmAlterarEjercicio);
		
		mnModificarRutina = new JMenu("MODIFICAR RUTINA");
		menuBar.add(mnModificarRutina);
		
		mntmEliminarRutina = new JMenuItem("ELIMINAR RUTINA");
		mntmEliminarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cod = JOptionPane.showInputDialog("Introduzca el dni del usuario al que desea eliminar la rutina:");
				if(!cod.equals(null)){
				int opc =JOptionPane.showConfirmDialog(null, "Esta seguro de querer eliminar la rutina del usuario con DNI "+cod);
				if(opc==0){
					VentanaDecision.bd.eliminarRutina(cod);
					System.out.println("Rutinad el usuario "+cod+" eliminada.");
				}
				}
			}
		});
		mnModificarRutina.add(mntmEliminarRutina);
		
		JMenuItem mntmAadirRutina = new JMenuItem("AÑADIR RUTINA");
		mntmAadirRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCrear.setText("AÑADIR");
				panel_8.setVisible(true);
				textCodigo.setVisible(false);
				textDuracion.setVisible(false);
				textNombre.setVisible(false);
				textPlazas.setVisible(false);
				lblProfesor.setText("PROFESOR");
				comboBoxProfesores.setVisible(false);
				comboBoxImpartidores.setVisible(false);
				Fecha.setVisible(false);
				lblNombre.setVisible(true);
				lblProfesor.setVisible(true);
				lblDuracion.setVisible(true);
				lblPlazas.setVisible(false);
				lblFecha.setVisible(true);
				lblCodigo.setText("EJERCICIO Nº1");
				lblNombre.setText("EJERCICIO Nº2");
				lblProfesor.setText("EJERCICIO Nº3");
				lblDuracion.setText("EJERCICIO Nº4");
				lblFecha.setText("EJERCICIO Nº5");
				btnCrear.setVisible(true);
				editorPaneDescripcion.setVisible(false);
				textGif.setVisible(false);
				comboBox_EJERCICIO_1.setVisible(true);
				comboBox_EJERCICIO_2.setVisible(true);
				comboBox_EJERCICIO_3.setVisible(true);
				comboBox_EJERCICIO_4.setVisible(true);
				comboBox_EJERCICIO_5.setVisible(true);
				OPC="introducir_rutina";
				
			}
		});
		mnModificarRutina.add(mntmAadirRutina);
		panel_3.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(null);
		panel_8.setVisible(false);
		
		lblCodigo = new JLabel("CODIGO :");
		lblCodigo.setBounds(10, 11, 100, 19);
		panel_8.add(lblCodigo);
		
		
		
		textCodigo.setBounds(120, 10, 231, 20);
		panel_8.add(textCodigo);
		textCodigo.setColumns(10);
		
		
		textNombre.setColumns(10);
		textNombre.setBounds(120, 57, 231, 20);
		panel_8.add(textNombre);
		
		
		textDuracion.setColumns(10);
		textDuracion.setBounds(118, 99, 63, 20);
		panel_8.add(textDuracion);
		
		lblNombre = new JLabel("NOMBRE :");
		lblNombre.setBounds(10, 59, 100, 19);
		panel_8.add(lblNombre);
		
		lblDuracion = new JLabel("DURACION:");
		lblDuracion.setBounds(10, 100, 100, 19);
		panel_8.add(lblDuracion);
		
		lblPlazas = new JLabel("PLAZAS :");
		lblPlazas.setBounds(211, 100, 63, 19);
		panel_8.add(lblPlazas);
		
		textPlazas = new JTextField();
		textPlazas.setColumns(10);
		textPlazas.setBounds(284, 99, 63, 20);
		panel_8.add(textPlazas);
		
		lblProfesor = new JLabel("PROFESOR :");
		lblProfesor.setBounds(10, 143, 100, 19);
		panel_8.add(lblProfesor);
		
		comboBoxProfesores = new JComboBox<String>();
		
			comboBoxImpartidores = new JComboBox<String>();
			
		
		comboBoxImpartidores.setBounds(120, 142, 231, 21);
		panel_8.add(comboBoxImpartidores);	
		
		comboBoxProfesores.setBounds(120, 142, 231, 21);
		panel_8.add(comboBoxProfesores);
		
		lblFecha = new JLabel("FECHA :");
		lblFecha.setBounds(10, 183, 100, 19);
		panel_8.add(lblFecha);
		
		
		Fecha.setBounds(123, 183, 228, 19);
		panel_8.add(Fecha);
		
		
		editorPaneDescripcion.setBounds(120, 130, 241, 97);
		panel_8.add(editorPaneDescripcion);
		
		textGif = new JTextField();
		textGif.setBounds(263, 99, 152, 20);
		panel_8.add(textGif);
		textGif.setColumns(10);
		
		comboBox_EJERCICIO_1 = new JComboBox<String>();
		comboBox_EJERCICIO_1.setBounds(129, 10, 286, 20);
		panel_8.add(comboBox_EJERCICIO_1);
		
		comboBox_EJERCICIO_2 = new JComboBox<String>();
		comboBox_EJERCICIO_2.setBounds(129, 57, 286, 20);
		panel_8.add(comboBox_EJERCICIO_2);
		
		comboBox_EJERCICIO_3 = new JComboBox<String>();
		comboBox_EJERCICIO_3.setBounds(129, 99, 286, 20);
		panel_8.add(comboBox_EJERCICIO_3);
		
		comboBox_EJERCICIO_4 = new JComboBox<String>();
		comboBox_EJERCICIO_4.setBounds(129, 142, 286, 20);
		panel_8.add(comboBox_EJERCICIO_4);
		
		comboBox_EJERCICIO_5 = new JComboBox<String>();
		comboBox_EJERCICIO_5.setBounds(130, 182, 285, 20);
		panel_8.add(comboBox_EJERCICIO_5);
		
		List<Ejercicio> listaEjercicios = VentanaDecision.bd.obtenerEjercicios();
		for(Ejercicio e:listaEjercicios){
			String ejercicio= e.getId_eje()+"    "+e.getNombre()+"    "+e.getDescripcion()+"    "+e.getTiempo_estimado();
			comboBox_EJERCICIO_1.addItem(ejercicio);
			comboBox_EJERCICIO_2.addItem(ejercicio);
			comboBox_EJERCICIO_3.addItem(ejercicio);
			comboBox_EJERCICIO_4.addItem(ejercicio);
			comboBox_EJERCICIO_5.addItem(ejercicio);
		}
		
		List<Profesor> listaProfesor = VentanaDecision.bd.obtenerProfesores();
		for(Profesor p:listaProfesor){
			String profesor= "    "+p.getDni_prof()+"    "+p.getNombre()+"    "+p.getApellidos();
			comboBoxProfesores.addItem(profesor);
		}
		
		List<Impartidor> listaImpartidor = VentanaDecision.bd.obtenerImpartidores();
		for(Impartidor p:listaImpartidor){
			String impartidor= "    "+p.getDni_impar()+"    "+p.getNombre()+"    "+p.getApellidos();
			comboBoxImpartidores.addItem(impartidor);
		}
		
		
		
	}
	public void introducirRutina(String dni,List<String>ej){
		
		for(int i=0; i <ej.size();i++){
			VentanaDecision.bd.introducirRutina(i,dni,ej.get(i).toString());		
		}
		
		
	}
}