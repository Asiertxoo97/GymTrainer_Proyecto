package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import BaseDeDatos.BD;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class VentanaRutina extends JFrame {

	private JPanel contentPane,panelDerecha;
	private static BD bd;
	private JLabel lblGIF;
	private String nombre;
	private JProgressBar progressBar;
	private double tiempo;
	private Thread th;
	public static boolean reanudar;
	public static String DNI;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRutina frame = new VentanaRutina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private ImageIcon redimensionarImagen(URL location, int anchura, int altura) {
		ImageIcon icon = new ImageIcon(location);
		Image img = icon.getImage(); //convertimos icon en una imagen
		Image otraimg = img.getScaledInstance(anchura,altura,java.awt.Image.SCALE_SMOOTH);
		ImageIcon otroicon = new ImageIcon(otraimg);
		return otroicon;
	}

	/**
	 * Create the frame.
	 */
	public VentanaRutina() {
		reanudar = false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblRutina = new JLabel("RUTINA");
		panelNorte.add(lblRutina);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtrs = new JButton("ATRÃ�S");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaMenu(bd);
				VentanaRutina.this.dispose();
			}
		});
		panelSur.add(btnAtrs);
		
		JButton btnComenzarRutina = new JButton("COMENZAR EJERCICIO");
		panelSur.add(btnComenzarRutina);
		
		JButton btnPausa = new JButton("PAUSA");
		panelSur.add(btnPausa);
		
		JPanel panelCentro = new JPanel();
		JScrollPane scroll = new JScrollPane(panelCentro);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scroll, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelIzquierda = new JPanel();
		panelCentro.add(panelIzquierda);
		String nombresColumnas[] = {"NOMBRE","DESCRIPCIÃ“N","TIEMPO ESTIMADO"};
		BD bd = new BD();
		bd.conectar();
		Object datos[][] = bd.obtenerTablaEjercicios();
		JTable tablaArriba = new JTable(datos,nombresColumnas);

		panelIzquierda.setLayout(new BorderLayout());
		panelIzquierda.add(tablaArriba.getTableHeader(), BorderLayout.PAGE_START); //PodrÃŒamos poner NORTH
		panelIzquierda.add(tablaArriba, BorderLayout.CENTER);
		panelCentro.add(panelIzquierda);
		tablaArriba.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				progressBar.setValue(0);
				int filaSeleccionada = tablaArriba.getSelectedRow();
				if(filaSeleccionada!=-1){
					TableModel modelo = tablaArriba.getModel();
					nombre = (String)modelo.getValueAt(filaSeleccionada, 0);
					String gif = bd.obtenerRuta(nombre);
					ImageIcon im = new ImageIcon(gif);
					lblGIF.setIcon(redimensionarImagen(VentanaRutina.class.getResource("/"+gif), 312, 283));
					lblGIF.setIcon(im);
					
					tiempo = bd.obtenerTiempoRutina(nombre);
					progressBar.setMaximum((int)tiempo);
					
					panelDerecha.updateUI();
				}
			}
		});
		
		panelDerecha = new JPanel();
		panelCentro.add(panelDerecha);
		panelDerecha.setLayout(null);
		
		lblGIF = new JLabel("");
		lblGIF.setBounds(0, 6, 312, 283);
		panelDerecha.add(lblGIF);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(44, 301, 230, 25);
		panelDerecha.add(progressBar);
	
		btnComenzarRutina.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Runnable r = new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						for(int i=1;i<=tiempo;i++){
							progressBar.setValue(i);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				};
				th = new Thread(r);
				th.start();
				
			}
		});
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
				{
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(reanudar){
						reanudar=false;
						
						th.resume();
						
					}
				}
			}
		};
		Thread th2 = new Thread(r2);
		th2.start();
		
		btnPausa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				th.suspend();
				
				VentanaPausa frame= new VentanaPausa();
				frame.setVisible(true);
			}
		});
		
		this.setVisible(true);
		
	
	}
}
