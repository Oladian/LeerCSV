package com.iesvirgendelcarmen.proyecto.LeerCSV.modelo;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;

public class ReadCSVFor {
	private static final String CSV_FILE_PATH = "ficherosCSV/cars.csv";
	public static void main(String[] args) {
		try(
				Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
				@SuppressWarnings("deprecation")
				CSVReader csvReader = new CSVReader(reader,';');
			) {
			
				List<String[]> records = csvReader.readAll();
				for (String[] record : records) {
					System.out.println("Coche: " + record[0]);
	                System.out.println("MPG: " + record[1]);
	                System.out.println("Cilindros: " + record[2]);
	                System.out.println("Desplazamiento: " + record[3]);
	                System.out.println("Cavallos: " + record[4]);
	                System.out.println("Peso: " + record[5]);
	                System.out.println("Aceleración: " + record[6]);
	                System.out.println("Modelo: " + record[7]);
	                System.out.println("Origen: " + record[8]);
	                System.out.println("==========================");
				}
				
			} catch (IOException e) {
				System.out.println("IO Exception");		
				}
	}
}
