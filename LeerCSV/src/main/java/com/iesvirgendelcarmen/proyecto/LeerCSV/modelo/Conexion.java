package com.iesvirgendelcarmen.proyecto.LeerCSV.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.SQLiteConfig;

public class Conexion {

	private static Connection conexion = null;
	private Conexion(){}
	
	public static Connection getConexion() {
		if (conexion == null) {
			try {

				final String DB_URL = "jdbc:sqlite:";
				final String DRIVER = "org.sqlite.JDBC"; 
				final String BD = "BD/coches";
				

				Class.forName(DRIVER);
				
				SQLiteConfig config = new SQLiteConfig();
				config.enforceForeignKeys(true);
				conexion = DriverManager.getConnection(DB_URL+BD,config.toProperties());

			} catch ( ClassNotFoundException | SQLException e ) {
				e.printStackTrace ();
			}
			Runtime.getRuntime().addShutdownHook(new MiShutdownHuk());
		}
		return conexion;
	}

	public static void desconectar () {
		if ( conexion != null )
			try {
				conexion.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		
	}
	
	static class MiShutdownHuk extends Thread {
		@Override
		public void run(){
			Connection con = Conexion.getConexion();
			if (con!=null) {
				try {
					con.close();
				} catch ( SQLException e ) {
					e.printStackTrace () ;
				}
			}
		}
	}
}