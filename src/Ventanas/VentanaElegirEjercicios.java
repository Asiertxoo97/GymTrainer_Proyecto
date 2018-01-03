package Ventanas;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDeDatos.BD;
import Paneles.PanelEjercicios;
import Ventanas.VentanasEjercicios.VentanaAbdominales;
import Ventanas.VentanasEjercicios.VentanaBiceps;
import Ventanas.VentanasEjercicios.VentanaCuadriA;
import Ventanas.VentanasEjercicios.VentanaCuadriceps;
import Ventanas.VentanasEjercicios.VentanaEspalda;
import Ventanas.VentanasEjercicios.VentanaGemelo;
import Ventanas.VentanasEjercicios.VentanaGluteos;
import Ventanas.VentanasEjercicios.VentanaHombros;
import Ventanas.VentanasEjercicios.VentanaLumbares;
import Ventanas.VentanasEjercicios.VentanaPecho;
import Ventanas.VentanasEjercicios.VentanaTriceps;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class VentanaElegirEjercicios extends JFrame {

	private JPanel contentPane;
	public static BD bd; //Declaramos el atributo BD (public) para poder usarlo en todo el proyecto


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaElegirEjercicios frame = new VentanaElegirEjercicios();
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
	public VentanaElegirEjercicios() { 
		
		//Creamos el objeto BD
		bd = new BD(); //Dentro del constructor se conecta a la base de datos y crea la sentencia

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		PanelEjercicios e = new PanelEjercicios();
		e.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(e);
		e.setLayout(null);
		
		
		//Funciona
		JButton btnSalir = new JButton("ATR¡S");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaElegirEjercicios.this.dispose();
				VentanaMenu frame = new VentanaMenu(bd, null);
				frame.setVisible(true);
			}
		});
		btnSalir.setBounds(565, 392, 79, 29);
		e.add(btnSalir);
		
		//Funciona
		JButton btnAbdo = new JButton("");
		btnAbdo.setOpaque(false);
		btnAbdo.setContentAreaFilled(false);
		btnAbdo.setBorderPainted(false);
		btnAbdo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnAbdo){
					VentanaAbdominales nuevaVentana = new VentanaAbdominales();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnAbdo.setBounds(165, 128, 48, 67);
		e.add(btnAbdo);
		
		//Funciona
		JButton btnPecho = new JButton("");
		btnPecho.setOpaque(false);
		btnPecho.setContentAreaFilled(false);
		btnPecho.setBorderPainted(false);
		btnPecho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnPecho){
					VentanaPecho nuevaVentana = new VentanaPecho();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		
		
		btnPecho.setBounds(149, 93, 85, 36);
		e.add(btnPecho);
		
		//Funciona
		JButton btnGluteos = new JButton("");
		btnGluteos.setOpaque(false);
		btnGluteos.setContentAreaFilled(false);
		btnGluteos.setBorderPainted(false);
		btnGluteos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnGluteos){
					VentanaGluteos nuevaVentana = new VentanaGluteos();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnGluteos.setBounds(423, 190, 102, 36);
		e.add(btnGluteos);
		
		JButton btngem1 = new JButton("");
		btngem1.setOpaque(false);
		btngem1.setContentAreaFilled(false);
		btngem1.setBorderPainted(false);
		btngem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btngem1){
					VentanaGemelo nuevaVentana = new VentanaGemelo();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btngem1.setBounds(423, 306, 34, 36);
		e.add(btngem1);
		
		JButton btngem2 = new JButton("");
		btngem2.setOpaque(false);
		btngem2.setContentAreaFilled(false);
		btngem2.setBorderPainted(false);
		btngem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btngem2){
					VentanaGemelo nuevaVentana = new VentanaGemelo();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btngem2.setBounds(486, 306, 39, 36);
		e.add(btngem2);
		
		JButton btnCuadriAtras1 = new JButton("");
		btnCuadriAtras1.setOpaque(false);
		btnCuadriAtras1.setContentAreaFilled(false);
		btnCuadriAtras1.setBorderPainted(false);
		btnCuadriAtras1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnCuadriAtras1){
					VentanaCuadriceps nuevaVentana = new VentanaCuadriceps();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnCuadriAtras1.setBounds(423, 238, 34, 56);
		e.add(btnCuadriAtras1);
		
		JButton btnCuadriAtras2 = new JButton("");
		btnCuadriAtras2.setOpaque(false);
		btnCuadriAtras2.setContentAreaFilled(false);
		btnCuadriAtras2.setBorderPainted(false);
		btnCuadriAtras2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnCuadriAtras2){
					VentanaCuadriceps nuevaVentana = new VentanaCuadriceps();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnCuadriAtras2.setBounds(491, 238, 34, 59);
		e.add(btnCuadriAtras2);
		
		JLabel lblHagaClickSobre = new JLabel("Haga click sobre el ");
		lblHagaClickSobre.setBounds(262, 6, 219, 16);
		e.add(lblHagaClickSobre);
		
		JLabel lblMsculoParaVer = new JLabel("m√∫sculo para ver los");
		lblMsculoParaVer.setBounds(261, 20, 140, 16);
		e.add(lblMsculoParaVer);
		
		JLabel lblDiferentes = new JLabel("diferentes");
		lblDiferentes.setBounds(262, 34, 85, 16);
		e.add(lblDiferentes);
		
		JLabel lblTiposDe = new JLabel("tipos de");
		lblTiposDe.setBounds(328, 34, 61, 16);
		e.add(lblTiposDe);
		
		JLabel lblEjercicios = new JLabel("ejercicios");
		lblEjercicios.setBounds(286, 48, 61, 16);
		e.add(lblEjercicios);
		
		JButton btnBiceps1 = new JButton("");
		btnBiceps1.setOpaque(false);
		btnBiceps1.setContentAreaFilled(false);
		btnBiceps1.setBorderPainted(false);
		btnBiceps1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnBiceps1){
					VentanaBiceps nuevaVentana = new VentanaBiceps();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnBiceps1.setBounds(113, 113, 24, 34);
		e.add(btnBiceps1);
		
		JButton btnBiceps2 = new JButton("");
		btnBiceps2.setOpaque(false);
		btnBiceps2.setContentAreaFilled(false);
		btnBiceps2.setBorderPainted(false);
		btnBiceps2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnBiceps2){
					VentanaBiceps nuevaVentana = new VentanaBiceps();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnBiceps2.setBounds(246, 118, 30, 29);
		e.add(btnBiceps2);
		
		JButton btnTriceps1 = new JButton("");
		btnTriceps1.setOpaque(false);
		btnTriceps1.setContentAreaFilled(false);
		btnTriceps1.setBorderPainted(false);
		btnTriceps1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnTriceps1){
					VentanaTriceps nuevaVentana = new VentanaTriceps();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnTriceps1.setBounds(394, 113, 24, 34);
		e.add(btnTriceps1);
		
		JButton btnTriceps2 = new JButton("");
		btnTriceps2.setOpaque(false);
		btnTriceps2.setContentAreaFilled(false);
		btnTriceps2.setBorderPainted(false);
		btnTriceps2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnTriceps2){
					VentanaTriceps nuevaVentana = new VentanaTriceps();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		/*Practica1-2017
		 * paquete base de datos
		 * 	bd
		 * paquete contenedores
		 * paquete test
		 * paquete tipos de
		 * paquete ventanas
		 * 	8 ventanas
		 * jre system
		 * junit 4
		 * referenced
		 * doc
		 * imagenes
		 * meta
		 * nueva carpeta
		 * org
		 * productos
		 * base de datos.db
		 * prueba.log
		 * ---
		 */
		btnTriceps2.setBounds(527, 113, 24, 34);
		e.add(btnTriceps2);
		
		JButton btnCuadriDelante1 = new JButton("");
		btnCuadriDelante1.setOpaque(false);
		btnCuadriDelante1.setContentAreaFilled(false);
		btnCuadriDelante1.setBorderPainted(false);
		btnCuadriDelante1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnCuadriDelante1){
					VentanaCuadriA nuevaVentana = new VentanaCuadriA();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnCuadriDelante1.setBounds(137, 217, 39, 60);
		e.add(btnCuadriDelante1);
		
		JButton btnCuadriDelante2 = new JButton("");
		btnCuadriDelante2.setOpaque(false);
		btnCuadriDelante2.setContentAreaFilled(false);
		btnCuadriDelante2.setBorderPainted(false);
		btnCuadriDelante2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnCuadriDelante2){
					VentanaCuadriA nuevaVentana = new VentanaCuadriA();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnCuadriDelante2.setBounds(204, 215, 39, 62);
		e.add(btnCuadriDelante2);
		
		JButton btnLumbares = new JButton("");
		btnLumbares.setOpaque(false);
		btnLumbares.setContentAreaFilled(false);
		btnLumbares.setBorderPainted(false);
		btnLumbares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnLumbares){
					VentanaLumbares nuevaVentana = new VentanaLumbares();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnLumbares.setBounds(446, 152, 48, 32);
		e.add(btnLumbares);
		
		JButton btnEspalda = new JButton("");
		btnEspalda.setOpaque(false);
		btnEspalda.setContentAreaFilled(false);
		btnEspalda.setBorderPainted(false);
		btnEspalda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnEspalda){
					VentanaEspalda nuevaVentana = new VentanaEspalda();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnEspalda.setBounds(423, 86, 92, 43);
		e.add(btnEspalda);
		
		JButton btnHombros1 = new JButton("");
		btnHombros1.setOpaque(false);
		btnHombros1.setContentAreaFilled(false);
		btnHombros1.setBorderPainted(false);
		btnHombros1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnHombros1){
					VentanaHombros nuevaVentana = new VentanaHombros();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnHombros1.setBounds(113, 78, 24, 36);
		e.add(btnHombros1);
		
		JButton btnHombros2 = new JButton("");
		btnHombros2.setOpaque(false);
		btnHombros2.setContentAreaFilled(false);
		btnHombros2.setBorderPainted(false);
		btnHombros2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnHombros2){
					VentanaHombros nuevaVentana = new VentanaHombros();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnHombros2.setBounds(246, 83, 24, 31);
		e.add(btnHombros2);
		
		JButton btnHombros3 = new JButton("");
		btnHombros3.setOpaque(false);
		btnHombros3.setContentAreaFilled(false);
		btnHombros3.setBorderPainted(false);
		btnHombros3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnHombros3){
					VentanaHombros nuevaVentana = new VentanaHombros();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnHombros3.setBounds(394, 78, 24, 36);
		e.add(btnHombros3);
		
		JButton btnHombros4 = new JButton("");
		btnHombros4.setOpaque(false);
		btnHombros4.setContentAreaFilled(false);
		btnHombros4.setBorderPainted(false);
		btnHombros4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton botonPulsado=(JButton)e.getSource();
				if(botonPulsado==btnHombros4){
					VentanaHombros nuevaVentana = new VentanaHombros();
					nuevaVentana.setVisible(true);
					VentanaElegirEjercicios.this.dispose();
				}
			}
		});
		btnHombros4.setBounds(527, 78, 24, 36);
		e.add(btnHombros4);

		
	}
}
