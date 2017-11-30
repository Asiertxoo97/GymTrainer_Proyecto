package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDeDatos.BD;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class VentanaDecision extends JFrame implements ActionListener {

	ImageIcon Imagen;
	private JPanel contentPane;

	private static BD bd;
	private static Connection con;
//github.com/Asiertxoo97/GymTrainer_Proyecto.git

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Creamos la Base de Datos
		bd = new BD();
		//Creamos las tablas
		bd.createTable(con);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDecision frame = new VentanaDecision();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaDecision() {

			//Creamos la Base de Datos
				bd = new BD();
				//Creamos las tablas
				bd.createTable(con);
//github.com/Asiertxoo97/GymTrainer_Proyecto.git
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblBienvenido = new JLabel("Bienvenido a GymTrainerUD");
		panelNorte.add(lblBienvenido);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		
		JButton btnGimnasio = new JButton(redimensionarImagen(VentanaMenu.class.getResource("/Imagen/Gimnasio.jpg"), 375, 185));
		btnGimnasio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				

				new VentanaInicio(bd);

				VentanaDecision.this.dispose();
			}
		});
		btnGimnasio.setBounds(6, 6, 375, 185);
		panelCentro.add(btnGimnasio);
		
		
		
		JButton btnCharlas = new JButton(redimensionarImagen(VentanaMenu.class.getResource("/Imagen/Charlas.jpg"), 375, 185));
		btnCharlas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaCharlas();
				VentanaDecision.this.dispose();
			}
		});
		btnCharlas.setBounds(259, 203, 375, 185);
		panelCentro.add(btnCharlas);
		
		///////////////////////////////////////////////////////////////////////////////////


		JTextPane txtpnGimnasio = new JTextPane();
		txtpnGimnasio.setBackground(Color.LIGHT_GRAY);
		txtpnGimnasio.setText("   Pulsa en el botón \"Gimnasio\" para poder acceder a nuestro gimnasio \"GymTrainerUD\" en el que podrás realizar muchos tipos de ejercicios, como ejercicios de pecho, abdominales, tren inferior... hasta poder realizar tus propias rutinas. Todo eso solo registrandote de una forma sencilla y así uniéndote a nosotros.");
		txtpnGimnasio.setBounds(393, 6, 228, 185);
		panelCentro.add(txtpnGimnasio);
		
		JTextPane txtpnCharlas = new JTextPane();
		txtpnCharlas.setBackground(Color.LIGHT_GRAY);
		txtpnCharlas.setText("   Pulsa en el botón \"Charlas\" para poder acceder a nuestra sección de charlas en las que tendrás la posibilidad de inscribirte a diferentes tipos de charlas como charlas sobre el ejercicio físico, sobre la nutrición, sobre deportistas de élite... una forma interesante de informarte sobre estos temas. ¡Inscríbete!");
		txtpnCharlas.setBounds(16, 203, 228, 185);
		panelCentro.add(txtpnCharlas);
		
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private ImageIcon redimensionarImagen(URL location, int anchura, int altura) {
		ImageIcon icon = new ImageIcon(location);
		Image img = icon.getImage(); //convertimos icon en una imagen
		Image otraimg = img.getScaledInstance(anchura,altura,java.awt.Image.SCALE_SMOOTH);
		ImageIcon otroicon = new ImageIcon(otraimg);
		return otroicon;
	}
}
