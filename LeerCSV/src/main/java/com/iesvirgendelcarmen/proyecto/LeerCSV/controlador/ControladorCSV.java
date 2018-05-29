package com.iesvirgendelcarmen.proyecto.LeerCSV.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import com.iesvirgendelcarmen.proyecto.LeerCSV.modelo.CochesDTO;
import com.iesvirgendelcarmen.proyecto.LeerCSV.modelo.ReadCSV;
import com.iesvirgendelcarmen.proyecto.LeerCSV.vista.VistaCSV;

//import com.iesvirgendelcarmen.proyecto.LeerCSV.vista.Vista;

public class ControladorCSV implements ActionListener {
	String path=".";
	ReadCSV reader = new ReadCSV();
	private List<CochesDTO> listaCoches;
	private VistaCSV vista;
	private int posicion=0;
	
	
	public ControladorCSV(VistaCSV vista) {
		this.vista = vista;
		registerComponent();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().getClass()==JButton.class) {
			JButton jButton = (JButton) e.getSource();
			String textoBoton = jButton.getText();
			switch (textoBoton) {
			case ">":
				posicion++;
				break;
			case ">>":
				posicion+=10;
				break;
			case "<":
				posicion--;
				break;
			case "<<":
				posicion-=10;
				break;
			default:
				break;
			}
			posicion%=listaCoches.size();
			if(posicion<0)
				posicion+=listaCoches.size();
			colocarFormularioCoche(posicion);
		}
		
		if (e.getSource().getClass() == JMenuItem.class) {
			
			if(e.getSource().getClass()==JMenuItem.class) {
				JMenuItem menuItem = (JMenuItem) e.getSource();
				String menuString = menuItem.getText();
				switch (menuString) {
				case "Salir":
					System.exit(0);
				case "About":
					//vista.messageAbout();
					break;
				case "Cargar datos":
					lanzarEleccionFichero();
					if (posicion>=0 && posicion<=1000)
						colocarFormularioCoche(posicion);
					break;
				default:
					break;
				}
			}
		}
	}
	
	public void registerComponent() {
		vista.getButtonMayor().addActionListener(this);
		vista.getButtonMayorMayor().addActionListener(this);
		vista.getButtonMenor().addActionListener(this);
		vista.getButtonMenorMenor().addActionListener(this);
		vista.getMntmCargarDatos().addActionListener(this);
		vista.getMntmSalir().addActionListener(this);
	}
	
	private void colocarFormularioCoche(int i) {
		vista.getTextMatricula().setText(listaCoches.get(i).getMatricula());
		vista.getTextMarca().setText(listaCoches.get(i).getMarca());
		vista.getTextFieldColor().setText(listaCoches.get(i).getColor());
		vista.getTextFieldModelo().setText(listaCoches.get(i).getModelo());
		vista.getTextFieldOrigen().setText(listaCoches.get(i).getOrigen());
	}
	
	private void lanzarEleccionFichero() {
		JFileChooser fileChooser = new JFileChooser(".");
		int resultado = fileChooser.showOpenDialog(vista.getFrame());
		if(resultado==fileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile().getPath();
		}	
		else if (resultado==fileChooser.CANCEL_OPTION)
			path = ".";
			
		listaCoches = reader.getCarListFromCSV(path);
	}

}
