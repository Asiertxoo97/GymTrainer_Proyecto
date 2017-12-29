package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import org.jvnet.substance.SubstanceComboBoxUI.ComboBoxPropertyChangeHandler;

import BaseDeDatos.BD;
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

	private JPanel contentPane;
	private static BD bd;
	private JMenu mnModificarClase;
	private JMenuItem mntmEliminarClase;
	private JMenuItem mntmAadirClase;
	private JMenuItem mntmAlterarClase;
	private JMenuItem mntmAadirCharla;
	private JMenuItem mntmAlterarCharla;
	private JMenu mnModificarRutina;
	private JMenuItem mntmEliminarRutina;
	private static JComboBox<String> comboBoxProfesores;
	private static 	JPanel panel_8 = new JPanel();
	private static JTextField textCodigo = new JTextField();
	private static JTextField textNombre = new JTextField();
	private static JTextField textDuracion = new JTextField();
	private static JTextField textPlazas = new JTextField(); 
	private static JLabel lblNombre = new JLabel(); 
	private static JLabel lblDuracion= new JLabel(); 
	private static JLabel lblPlazas= new JLabel();  
	private static JLabel lblProfesor= new JLabel(); 
	private static JDateChooser Fecha= new JDateChooser(); 
	private static JLabel lblFecha= new JLabel(); 
	private static JButton btnCrear;
	private static JComboBox<String> comboBoxImpartidores;
	private JMenu mnMo;
	private JMenuItem mntmElim;
	private JMenuItem mntmAadirEjercicio;
	private JMenuItem mntmAlterarEjercicio;
	private static  JEditorPane editorPaneDescripcion = new JEditorPane();
	private static JTextField textGif;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdministrador frame = new VentanaAdministrador(bd);
					frame.setVisible(true);
					panel_8.setVisible(true);
					textCodigo.setVisible(false);
					textDuracion.setVisible(false);
					textNombre.setVisible(false);
					textPlazas.setVisible(false);
					comboBoxProfesores.setVisible(false);
					comboBoxImpartidores.setVisible(false);
					Fecha.setVisible(false);
					lblNombre.setVisible(false);
					lblProfesor.setVisible(false);
					lblDuracion.setVisible(false);
					lblPlazas.setVisible(false);
					lblFecha.setVisible(false);
					btnCrear.setVisible(false);
					editorPaneDescripcion.setVisible(false);
					textGif.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAdministrador(BD bd) {
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
				VentanaInicio frame = new VentanaInicio(bd);
				frame.setVisible(true);
			}
		});
		panel_1.add(btnAtras);
		
		btnCrear = new JButton("CREAR ");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblProfesor.getText()=="PROFESOR"){
					String profesorDNI = ((String)comboBoxProfesores.getSelectedItem()).substring(3, 14);
					String fecha =  String.valueOf(Fecha.getDate().toString().substring(8, 10))+"/"+String.valueOf(Fecha.getDate().getMonth())+"/"+String.valueOf(Fecha.getDate().getYear()+1900);
					bd.introducirClase(textCodigo.getText(), textNombre.getText(), profesorDNI, fecha , Double.parseDouble(textDuracion.getText()),Integer.parseInt(textPlazas.getText()));
					System.out.println("Clase introducida correctamente. Enhorabuena eres el puto amo!");
				}else if(lblProfesor.getText()=="IMPARTIDOR"){
					String ImpartidorDNI = ((String)comboBoxImpartidores.getSelectedItem()).substring(3, 14);
					String fecha =  String.valueOf(Fecha.getDate().getDay())+"/"+String.valueOf(Fecha.getDate().getMonth())+"/"+String.valueOf(Fecha.getDate().getYear()+1900);
					bd.introducirCharla(textCodigo.getText(), textNombre.getText(), ImpartidorDNI, fecha , Double.parseDouble(textDuracion.getText()),Integer.parseInt(textPlazas.getText()));
					System.out.println("Charla introducida correctamente. Enhorabuena eres el puto amo!");
				}else{
					
					bd.introducirEjercicio(textCodigo.getText(),textNombre.getText(),editorPaneDescripcion.getText(),Double.parseDouble(textDuracion.getText()),textGif.getText());
					System.out.println("Ejercicio introducido correctamente. Enhorabuena eres el puto amo!");
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
				String cod = JOptionPane.showInputDialog("Introduzca el c�digo de la charla que deseas eliminar:");
				int opc =JOptionPane.showConfirmDialog(null, "Est� seguro de querer eliminar la charla con c�digo "+cod);
				if(opc==0){
					bd.eliminarCharla(cod);
					System.out.println("Charla con c�digo "+cod+" eliminada.");
				}
				
			}
		});
		mnModificarCharla.add(mntmEliminarCharla);
		
		mntmAadirCharla = new JMenuItem("A\u00D1ADIR CHARLA");
		mntmAadirCharla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_8.setVisible(true);
				textCodigo.setVisible(true);
				textDuracion.setVisible(true);
				textNombre.setVisible(true);
				textPlazas.setVisible(true);
				lblProfesor.setText("IMPARTIDOR");
				comboBoxProfesores.setVisible(false);
				comboBoxImpartidores.setVisible(true);
				Fecha.setVisible(true);
				lblNombre.setVisible(true);
				lblProfesor.setVisible(true);
				lblDuracion.setVisible(true);
				lblPlazas.setVisible(true);
				lblFecha.setVisible(true);
				btnCrear.setVisible(true);
				editorPaneDescripcion.setVisible(false);
				textGif.setVisible(false);
				
				
			}
		});
		mnModificarCharla.add(mntmAadirCharla);
		
		mntmAlterarCharla = new JMenuItem("ALTERAR CHARLA");
		mnModificarCharla.add(mntmAlterarCharla);
		
		mnModificarClase = new JMenu("MODIFICAR CLASE");
		menuBar.add(mnModificarClase);
		
		mntmEliminarClase = new JMenuItem("ELIMINAR CLASE");
		mntmEliminarClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cod = JOptionPane.showInputDialog("Introduzca el c�digo de la clase que deseas eliminar:");
				int opc =JOptionPane.showConfirmDialog(null, "Est� seguro de querer eliminar la clase con c�digo "+cod);
				if(opc==0){
					bd.eliminarClase(cod);
					System.out.println("Clase con c�digo "+cod+" eliminada.");
				}
				
			}
		});
		mnModificarClase.add(mntmEliminarClase);
		
		mntmAadirClase = new JMenuItem("A\u00D1ADIR CLASE");
		mntmAadirClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_8.setVisible(true);
				textCodigo.setVisible(true);
				textDuracion.setVisible(true);
				textNombre.setVisible(true);
				textPlazas.setVisible(true);
				lblProfesor.setText("PROFESOR");
				comboBoxProfesores.setVisible(true);
				comboBoxImpartidores.setVisible(false);
				Fecha.setVisible(true);
				lblNombre.setVisible(true);
				lblProfesor.setVisible(true);
				lblDuracion.setVisible(true);
				lblPlazas.setVisible(true);
				lblFecha.setVisible(true);
				btnCrear.setVisible(true);
				editorPaneDescripcion.setVisible(false);
				textGif.setVisible(false);
				
				
			}
		});
		
		
		mnModificarClase.add(mntmAadirClase);
		
		mntmAlterarClase = new JMenuItem("ALTERAR CLASE");
		mnModificarClase.add(mntmAlterarClase);
		
		mnMo = new JMenu("MODIFICAR EJERCICIO");
		menuBar.add(mnMo);
		
		mntmElim = new JMenuItem("ELIMINAR EJERCICIO");
		mntmElim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cod = JOptionPane.showInputDialog("Introduzca el c�digo del ejercicio que deseas eliminar:");
				int opc =JOptionPane.showConfirmDialog(null, "Est� seguro de querer eliminar el ejercicio con c�digo "+cod);
				if(opc==0){
					bd.eliminarEjercicio(cod);
					System.out.println("Ejercicio con c�digo "+cod+" eliminado.");
				}
				
			}
		});
		mnMo.add(mntmElim);
		
		mntmAadirEjercicio = new JMenuItem("A\u00D1ADIR EJERCICIO");
		mntmAadirEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				lblNombre.setVisible(true);
				lblProfesor.setVisible(true);
				lblDuracion.setVisible(true);
				lblPlazas.setVisible(true);
				lblFecha.setVisible(false);
				btnCrear.setVisible(true);
				editorPaneDescripcion.setVisible(true);
				textGif.setVisible(true);			
			}
		});
		mnMo.add(mntmAadirEjercicio);
		
		mntmAlterarEjercicio = new JMenuItem("ALTERAR EJERCICIO");
		mnMo.add(mntmAlterarEjercicio);
		
		mnModificarRutina = new JMenu("MODIFICAR RUTINA");
		menuBar.add(mnModificarRutina);
		
		mntmEliminarRutina = new JMenuItem("ELIMINAR RUTINA");
		mnModificarRutina.add(mntmEliminarRutina);
		panel_3.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(null);
		panel_8.setVisible(false);
		
		JLabel lblCodigo = new JLabel("CODIGO :");
		lblCodigo.setBounds(32, 11, 56, 19);
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
		lblNombre.setBounds(32, 59, 56, 19);
		panel_8.add(lblNombre);
		
		lblDuracion = new JLabel("DURACION:");
		lblDuracion.setBounds(32, 100, 78, 19);
		panel_8.add(lblDuracion);
		
		lblPlazas = new JLabel("PLAZAS :");
		lblPlazas.setBounds(211, 100, 63, 19);
		panel_8.add(lblPlazas);
		
		textPlazas = new JTextField();
		textPlazas.setColumns(10);
		textPlazas.setBounds(284, 99, 63, 20);
		panel_8.add(textPlazas);
		
		lblProfesor = new JLabel("PROFESOR :");
		lblProfesor.setBounds(32, 143, 78, 19);
		panel_8.add(lblProfesor);
		
		comboBoxProfesores = new JComboBox<String>();
		
			comboBoxImpartidores = new JComboBox<String>();
			
		
		comboBoxImpartidores.setBounds(120, 142, 231, 21);
		panel_8.add(comboBoxImpartidores);	
		
		comboBoxProfesores.setBounds(120, 142, 231, 21);
		panel_8.add(comboBoxProfesores);
		
		lblFecha = new JLabel("FECHA :");
		lblFecha.setBounds(32, 183, 78, 19);
		panel_8.add(lblFecha);
		
		
		Fecha.setBounds(123, 183, 228, 19);
		panel_8.add(Fecha);
		
		
		editorPaneDescripcion.setBounds(120, 130, 241, 97);
		panel_8.add(editorPaneDescripcion);
		
		textGif = new JTextField();
		textGif.setBounds(263, 99, 152, 20);
		panel_8.add(textGif);
		textGif.setColumns(10);
		List<Profesor> listaProfesor = bd.obtenerProfesores();
		for(Profesor p:listaProfesor){
			String profesor= "    "+p.getDni_prof()+"    "+p.getNombre()+"    "+p.getApellidos();
			comboBoxProfesores.addItem(profesor);
		}
		List<Impartidor> listaImpartidor = bd.obtenerImpartidores();
		for(Impartidor p:listaImpartidor){
			String impartidor= "    "+p.getDni_impar()+"    "+p.getNombre()+"    "+p.getApellidos();
			comboBoxImpartidores.addItem(impartidor);
		}
		
		
	}
}
