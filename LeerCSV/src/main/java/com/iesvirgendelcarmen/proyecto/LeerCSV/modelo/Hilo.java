package com.iesvirgendelcarmen.proyecto.LeerCSV.modelo;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Hilo implements Runnable {

	JFrame frame = new JFrame("Progreso");
	JProgressBar barra;
	public void ensamblar() {
		
		frame.setBounds(100, 100, 250, 250);
		barra = new JProgressBar(0,100);
		barra.setStringPainted(true);
		frame.add(barra);
		frame.pack();
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	@Override
	public void run() {
		ensamblar();
		for (int i = 0; i < 100; i++) {
			barra.setValue(i);
			barra.repaint();	
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				new CrearLog().crearLog("", null);
				
			}
			
		}
	}

	public void llamarHilo() {
		
		
	
		
	}
}
