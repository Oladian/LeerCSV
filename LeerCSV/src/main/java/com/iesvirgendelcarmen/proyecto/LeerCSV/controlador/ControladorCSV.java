package com.iesvirgendelcarmen.proyecto.LeerCSV.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.iesvirgendelcarmen.proyecto.LeerCSV.modelo.CochesDAOImp;
import com.iesvirgendelcarmen.proyecto.LeerCSV.modelo.CochesDTO;
import com.iesvirgendelcarmen.proyecto.LeerCSV.modelo.ReadCSV;
import com.iesvirgendelcarmen.proyecto.LeerCSV.vista.VistaCSV;

public class ControladorCSV implements ActionListener {
	String path=".";
	List<CochesDTO> listaCochesActualizados = new ArrayList<>();
	ReadCSV reader = new ReadCSV();
	CochesDAOImp manipular = new CochesDAOImp();
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
			case "Anadir datos":
				lanzarInputRecogerDatos();
				break;
			case "Actualizar datos":
				System.out.println("Actualizar");
				break;
			case "Borrar datos":
				System.out.println("Borrar");
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
		
		// Botones
		vista.getButtonMayor().addActionListener(this);
		vista.getButtonMayorMayor().addActionListener(this);
		vista.getButtonMenor().addActionListener(this);
		vista.getButtonMenorMenor().addActionListener(this);
		vista.getBtnAnadirDatos().addActionListener(this);
		vista.getBtnActualizarDatos().addActionListener(this);
		vista.getBtnBorrarDatos().addActionListener(this);
		
		// Menús
		vista.getMntmCargarDatos().addActionListener(this);
		vista.getMntmSalir().addActionListener(this);
	}
	
		// Formulario para CSV
	private void colocarFormularioCoche(int i) {
		if(listaCoches.size()>0) {
			vista.getTextMatricula().setText(listaCoches.get(i).getMatricula());
			vista.getTextMarca().setText(listaCoches.get(i).getMarca());
			vista.getTextFieldColor().setText(listaCoches.get(i).getColor());
			vista.getTextFieldModelo().setText(listaCoches.get(i).getModelo());
			vista.getTextFieldOrigen().setText(listaCoches.get(i).getOrigen());
		}
	}
	
		//Metodo que escoge el fichero
	private void lanzarEleccionFichero() {
		JFileChooser fileChooser = new JFileChooser("./ficherosCSV");
		int resultado = fileChooser.showOpenDialog(vista.getFrame());
		if(resultado==JFileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile().getPath();
		}	
		else if (resultado==JFileChooser.CANCEL_OPTION)
			path = ".";
		
		if(listaCoches==null) {
			listaCoches = reader.getCarListFromCSV(path);
			manipular.insertarListaCoches(listaCoches);
			manipular.completarArrays(listaCoches);
			vista.getButtonMayor().setEnabled(true);
			vista.getButtonMayorMayor().setEnabled(true);
			vista.getButtonMenor().setEnabled(true);
			vista.getButtonMenorMenor().setEnabled(true);
			vista.getBtnAnadirDatos().setEnabled(true);
			vista.getBtnBorrarDatos().setEnabled(true);
			vista.getBtnActualizarDatos().setEnabled(true);
			vista.getTable().setEnabled(true);
			vista.getScrollPaneTablas().setViewportView(new JTable(manipular.getDatos(),manipular.getCabeceras()));
		} 
	}
	
	private void lanzarInputRecogerDatos() {
		Object[] textFields = {
				"Matricula", vista.getTextAnadirMatricula(),
				"Marca", vista.getTextAnadirMarca(),
				"Color", vista.getTextAnadirColor(),
				"Modelo", vista.getTextAnadirModelo(),
				"Origen", vista.getTextAnadirOrigen()
		};
		int resultado = JOptionPane.showConfirmDialog(null, textFields, "Añadir datos", JOptionPane.OK_CANCEL_OPTION);
		CochesDTO coche = new CochesDTO(vista.getTextAnadirMatricula().getText(), vista.getTextAnadirMarca().getText(), 
				vista.getTextAnadirColor().getText(), vista.getTextAnadirModelo().getText(),
				vista.getTextAnadirOrigen().getText());
		if(resultado==JOptionPane.OK_OPTION) {
			manipular.insertarCoche(coche);
			listaCochesActualizados = manipular.listarCoches();
			manipular.completarArrays(listaCochesActualizados);
			
			// El siguiente trozo de código hace que la primera columna de la tabla no sea manipular 
			DefaultTableModel model = new DefaultTableModel(manipular.getDatos(),manipular.getCabeceras()){
				private static final long serialVersionUID = 1L;

				@Override 
			    public boolean isCellEditable(int row, int column)
			    {
			    	return column!=0;
			    }
			};
			JTable tabla = new JTable();
			tabla.setModel(model);
			vista.getScrollPaneTablas().setViewportView(tabla);
		}
	}
}
