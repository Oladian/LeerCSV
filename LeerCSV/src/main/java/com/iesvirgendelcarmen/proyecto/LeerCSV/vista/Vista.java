package com.iesvirgendelcarmen.proyecto.LeerCSV.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Vista {

	private JFrame frame;
	private JButton buttonMenorMenor;
	private JButton buttonMenor;
	private JButton buttonMayor;
	private JButton buttonMayorMayor;
	private JTextField textFieldOrigen;
	private JTextField textFieldModelo;
	private JTextField textFieldColor;
	private JTextField textCoche;
	private JTextField textMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCargarDatos = new JMenuItem("Cargar datos");
		mnArchivo.add(mntmCargarDatos);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JSplitPane splitPane = new JSplitPane();
		tabbedPane.addTab("Datos", null, splitPane, null);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblMatricula = new JLabel("Matricula");
		panel.add(lblMatricula);
		
		textMatricula = new JTextField();
		panel.add(textMatricula);
		textMatricula.setColumns(10);
		
		JLabel lblCoche = new JLabel("Coche");
		panel.add(lblCoche);
		
		textCoche = new JTextField();
		panel.add(textCoche);
		textCoche.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		panel.add(lblColor);
		
		textFieldColor = new JTextField();
		panel.add(textFieldColor);
		textFieldColor.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		panel.add(lblModelo);
		
		textFieldModelo = new JTextField();
		panel.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		JLabel lblOrigen = new JLabel("Origen");
		panel.add(lblOrigen);
		
		textFieldOrigen = new JTextField();
		panel.add(textFieldOrigen);
		textFieldOrigen.setColumns(10);
		
		JPanel panelBotones = new JPanel();
		panel.add(panelBotones);
		
		buttonMenorMenor = new JButton("<<");
		panelBotones.add(buttonMenorMenor);
		
		buttonMenor = new JButton("<");
		panelBotones.add(buttonMenor);
		
		buttonMayor = new JButton(">");
		panelBotones.add(buttonMayor);
		
		buttonMayorMayor = new JButton(">>");
		panelBotones.add(buttonMayorMayor);
	}

}
