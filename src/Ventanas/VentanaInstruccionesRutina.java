package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import BaseDeDatos.BD;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class VentanaInstruccionesRutina extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInstruccionesRutina frame = new VentanaInstruccionesRutina();
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
	public VentanaInstruccionesRutina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblInstrucciones = new JLabel("INSTRUCCIONES");
		panelNorte.add(lblInstrucciones);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtrs = new JButton("ATRAS");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new VentanaMenu();
				VentanaInstruccionesRutina.this.dispose();
			}
		});
			
		panelSur.add(btnAtrs);
		
			
		
		
		JButton btnIrRutina = new JButton("IR A LA RUTINA");
		btnIrRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRutina f =	new VentanaRutina();
				f.setVisible(true);
				VentanaInstruccionesRutina.this.dispose();
			}
		});
			
		panelSur.add(btnIrRutina);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		
		
		panelCentro.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a tu rutina para este mes " +VentanaInicio.nick+"\n");
		lblNewLabel.setBounds(114, 5, 195, 14);
		panelCentro.add(lblNewLabel);
		
		JTextPane txtpnLaRutinaConsta = new JTextPane();
		txtpnLaRutinaConsta.setText("La rutina consta de cinco ejercicios propuestos por el monitor que en este caso es el administrador de la aplicacion. Cada ejercicio se compone con un nombre, una descripcion, duracion, un GIF del ejercicio que muestra la forma correcta de realizar dicho ejercicio. \r\n\r\nPara comenzar cada ejercicio el usuario deber\u00E1 seleccionar un ejercicio (pinchar en una fila de la tabla) y pulsar el bot\u00F3n COMENZAR. En ese momento la barra que se muestra debajo del GIF del ejercicio comenzar\u00E1 a llenarse cada segundo. \r\n\r\nEn caso de que el usuario quiera pausar por un instante deber\u00E1 pulsar el bot\u00F3n PAUSA y autom\u00E1ticamente una nueva ventana se abrir\u00E1 y coomenzar\u00E1 una cuenta atr\u00E1s de 10 segundos. Nada m\u00E1s finalize la cuenta atr\u00E1s el ejercicio reanudar\u00E1 su curso y podr\u00E1 acabar.\r\n\r\nSer grande no es una cuesti\u00F3n de tama\u00F1o sino de actitud. \t\t\t\t\t\t\t\r\n\t\t\t\t\t\t      \tDESEAR\u00C1S RENDIRTE. \r\n\t\t\t\t\t\t\t    \u00A1NO LO HAGAS! ");
		txtpnLaRutinaConsta.setBounds(40, 30, 425, 304);
		panelCentro.add(txtpnLaRutinaConsta);
		
		
		this.setVisible(true);
	}
}
	