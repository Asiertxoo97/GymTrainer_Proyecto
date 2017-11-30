package Paneles;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class PanelHombros extends javax.swing.JPanel {
	
	public PanelHombros(){
		this.setSize(400,280);
	}
	
	@Override
	public void paintComponent (Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/IMAGEN/fondohombros.jpg"));
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
