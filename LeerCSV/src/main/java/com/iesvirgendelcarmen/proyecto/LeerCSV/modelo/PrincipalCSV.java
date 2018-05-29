package com.iesvirgendelcarmen.proyecto.LeerCSV.modelo;

import java.awt.EventQueue;
import java.util.List;

import com.iesvirgendelcarmen.proyecto.LeerCSV.vista.VistaCSV;

public class PrincipalCSV {
	public static void main(String[] args) {
		
		CochesDAOImp implementacion = new CochesDAOImp();
		ReadCSV readCsv = new ReadCSV();
		List<CochesDTO> listaCoches = readCsv.getCarListFromCSV("ficherosCSV/MOCK_DATA.csv");
		System.out.println(listaCoches);
		//implementacion.insertarListaCoches(listaCoches);
		System.out.println(implementacion.listarCoches());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new VistaCSV();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
		});
	}
}
