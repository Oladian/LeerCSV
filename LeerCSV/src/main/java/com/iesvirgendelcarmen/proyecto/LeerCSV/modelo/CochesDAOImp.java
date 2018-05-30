package com.iesvirgendelcarmen.proyecto.LeerCSV.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CochesDAOImp implements CochesDAO {
	Connection conexion = Conexion.getConexion();
	private String[] cabeceras = {"Matricula", "Marca", "Color", "Modelo", "Origen"};
	private Object[][] datos;


	@Override
	public boolean crearBaseDatos() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void completarArrays(List<CochesDTO> lista) {
		datos = new Object[lista.size()][5];
		int contador = 0;
		
		for (CochesDTO coche : listarCoches()) {
			datos[contador][0] = coche.getMatricula();
			datos[contador][1] = coche.getMarca();
			datos[contador][2] = coche.getColor();
			datos[contador][3] = coche.getModelo();
			datos[contador][4] = coche.getOrigen();
			contador++;
		}
	}
	
	@Override
	public List<CochesDTO> listarCoches() {
		List<CochesDTO> listaDeCoches = new ArrayList<>();
		String sql = "SELECT * FROM coches;";
		
		try(PreparedStatement statement = conexion.prepareStatement(sql);
				ResultSet result = statement.executeQuery();) {
			while(result.next()) {
				CochesDTO coche = new CochesDTO(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
				listaDeCoches.add(coche);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDeCoches;
	}

	
	@Override
	public boolean borrarCoches(List<CochesDTO> lista) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarCoches(List<CochesDTO> lista) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertarCoche(CochesDTO coche) {
		String sql = "INSERT INTO coches (matricula, coche, color, modelo, origen) VALUES (?,?,?,?,?);";
		try (PreparedStatement statement = conexion.prepareStatement(sql);){
			statement.setString(1, coche.getMatricula());
			statement.setString(2, coche.getMarca());
			statement.setString(3, coche.getColor());
			statement.setString(4, coche.getModelo());
			statement.setString(5, coche.getOrigen());
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean insertarListaCoches(List<CochesDTO> lista) {
		try {
			conexion.setAutoCommit(false);
			for (CochesDTO cochesDTO : lista) {
				insertarCoche(cochesDTO);
			}
			return true;
		} catch (SQLException e1) {
			try {
				conexion.rollback();
				return false;
			} catch (SQLException e) {
				return false;
			}
		} 
	}

	public String[] getCabeceras() {
		return cabeceras;
	}

	public void setCabeceras(String[] cabeceras) {
		this.cabeceras = cabeceras;
	}

	public Object[][] getDatos() {
		return datos;
	}

	public void setDatos(Object[][] datos) {
		this.datos = datos;
	}




}
