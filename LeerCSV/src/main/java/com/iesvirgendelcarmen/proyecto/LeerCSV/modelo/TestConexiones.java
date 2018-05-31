package com.iesvirgendelcarmen.proyecto.LeerCSV.modelo;

public class TestConexiones {
	public static void main(String[] args) {
		CochesDAOImp imp = new CochesDAOImp();
		
		System.out.println(imp.crearBaseDatos());
	}
}
