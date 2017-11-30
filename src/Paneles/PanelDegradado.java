package Paneles;
/*
import java.awt.Dimension;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class PanelImagenRegistro extends javax.swing.JPanel {
	
	public PanelImagenRegistro(){
		this.setSize(400,280);
	}
	
	@Override
	public void paintComponent (Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagen/imagenElegirCasino.jpg"));
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}*/


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class PanelDegradado extends JPanel {
 
 public PanelDegradado(){
  setLayout(new BorderLayout());
  JLabel l=new JLabel("JAVA ZONE");
  l.setFont(new Font("Verdana", Font.BOLD, 16));
  l.setHorizontalAlignment(SwingConstants.CENTER);
  JLabel l2=new JLabel("JAVA ZONE");
  l2.setFont(new Font("Verdana", Font.BOLD, 16));
  l2.setForeground(Color.ORANGE);
  l2.setHorizontalAlignment(SwingConstants.CENTER);
  add(l,BorderLayout.NORTH);
  add(l2,BorderLayout.SOUTH);
 }
 
 public void paintComponent(Graphics g){
  super.paintComponents(g);
  Graphics2D g2d=(Graphics2D)g;
  g2d.setPaint(new GradientPaint(200, 0, Color.WHITE, 200, 450, Color.BLACK));
  g2d.fillRect(0, 0, 650, 450);
 }
}
