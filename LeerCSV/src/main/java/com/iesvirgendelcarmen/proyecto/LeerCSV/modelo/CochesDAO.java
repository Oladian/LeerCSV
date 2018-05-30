package com.iesvirgendelcarmen.proyecto.LeerCSV.modelo;

import java.util.List;

public interface CochesDAO {
	List<CochesDTO> listarCoches();
	public void completarArrays(List<CochesDTO> lista);
	boolean borrarCoches(List<CochesDTO> lista);
	boolean actualizarCoches(List<CochesDTO> lista);
	boolean insertarCoche(CochesDTO coche);
	boolean insertarListaCoches(List<CochesDTO> lista);
	boolean crearBaseDatos();
}
