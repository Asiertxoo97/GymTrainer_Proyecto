package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

public class VentanaPausa extends JFrame {

	private JPanel contentPane;
	private Thread th;
	private JLabel lblTiempoPausa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPausa frame = new VentanaPausa();
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
	public VentanaPausa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		lblTiempoPausa = new JLabel("00:10");
		lblTiempoPausa.setFont(new Font("Yu Gothic", Font.PLAIN, 43));
		lblTiempoPausa.setBounds(125, 11, 140, 55);
		panel_2.add(lblTiempoPausa);
		
		pausar();
		if(!th.isAlive()){
			VentanaPausa.this.dispose();
		}
		
	}
	
	public void pausar(){
		Runnable r = new Runnable() {
			int seg = 9;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<10;i++){
					try {
						Thread.sleep(1000);
						lblTiempoPausa.setText("00:0"+seg);
						seg--;
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				VentanaRutina.reanudar=true;
				Window w[] = getWindows();
				w[w.length-1].dispose();
				
			}
		};
		th = new Thread(r);
		th.start();
		
	}
		
	}

