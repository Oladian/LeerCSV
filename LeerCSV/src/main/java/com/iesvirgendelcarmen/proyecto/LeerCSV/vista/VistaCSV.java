package com.iesvirgendelcarmen.proyecto.LeerCSV.vista;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

public class VistaCSV {

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

	public VistaCSV() {
		initialize();
		frame.setVisible(true);
	}

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
		tabbedPane.addTab("Filtros", null, splitPane, null);
		
		JPanel panelDerecho = new JPanel();
		splitPane.setRightComponent(panelDerecho);
		panelDerecho.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblMatricula = new JLabel("Matricula");
		panelDerecho.add(lblMatricula);
		
		textMatricula = new JTextField();
		panelDerecho.add(textMatricula);
		textMatricula.setColumns(10);
		
		JLabel lblCoche = new JLabel("Coche");
		panelDerecho.add(lblCoche);
		
		textCoche = new JTextField();
		panelDerecho.add(textCoche);
		textCoche.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		panelDerecho.add(lblColor);
		
		textFieldColor = new JTextField();
		panelDerecho.add(textFieldColor);
		textFieldColor.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		panelDerecho.add(lblModelo);
		
		textFieldModelo = new JTextField();
		panelDerecho.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		JLabel lblOrigen = new JLabel("Origen");
		panelDerecho.add(lblOrigen);
		
		textFieldOrigen = new JTextField();
		panelDerecho.add(textFieldOrigen);
		textFieldOrigen.setColumns(10);
		
		JPanel panelBotones = new JPanel();
		panelDerecho.add(panelBotones);
		
		buttonMenorMenor = new JButton("<<");
		panelBotones.add(buttonMenorMenor);
		
		buttonMenor = new JButton("<");
		panelBotones.add(buttonMenor);
		
		buttonMayor = new JButton(">");
		panelBotones.add(buttonMayor);
		
		buttonMayorMayor = new JButton(">>");
		panelBotones.add(buttonMayorMayor);
		
		JPanel panelIzquierdo = new JPanel();
		splitPane.setLeftComponent(panelIzquierdo);
		
		JPanel panelTablas = new JPanel();
		tabbedPane.addTab("Tablas", null, panelTablas, null);
		panelTablas.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneTablas = new JScrollPane();
		panelTablas.add(scrollPaneTablas,BorderLayout.NORTH);
		
		String[] columnNames = {"First Name", "Last Name", "Sport", "# of Years", "Vegetarian"};
		Object[][] data = {
		    {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
		    {"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)},
		    {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
		    {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
		    {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
		    {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
		    {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
		    {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
		    {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)}
		};
		
		JTable table = new JTable(data,columnNames);
		scrollPaneTablas.setViewportView(table);

		JPanel panelBotonesTablas = new JPanel();
		panelTablas.add(panelBotonesTablas);
		panelBotonesTablas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAadirDatos = new JButton("Añadir datos");
		panelBotonesTablas.add(btnAadirDatos);
		
		JButton btnBorrarDatos = new JButton("Borrar datos");
		panelBotonesTablas.add(btnBorrarDatos);
		
		JButton btnActualizarDatos = new JButton("Actualizar datos");
		panelBotonesTablas.add(btnActualizarDatos);
	}

}
