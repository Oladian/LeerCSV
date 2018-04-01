package com.iesvirgendelcarmen.proyecto.LeerCSV;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


public class ReadCSV {
	private static final String CSV_FILE_PATH = "ficherosCSV/cars.csv";
	
	
	public static void main(String[] args) {
		try(
			Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
			
		) {
			// Para construir el csvReaderBuilder se necesitará el CsvParserBuilder, ya que este csv usa como delimitador el
			// caracter ; y no la coma (usada por defecto).
			
			CSVParser parser = new CSVParserBuilder().withSeparator(';').withIgnoreQuotations(true).build();
			
			// CsvReaderBuilder se encargará de la lectura del fichero, se obvian las dos primeras lineas y se parsea con
			// el delimitador ; designado anteriormente
			
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(2).withCSVParser(parser).build();
			String nextRecord[];
			while((nextRecord=csvReader.readNext())!=null) {
				System.out.println("Coche: " + nextRecord[0]);
                System.out.println("MPG: " + nextRecord[1]);
                System.out.println("Cilindros: " + nextRecord[2]);
                System.out.println("Desplazamiento: " + nextRecord[3]);
                System.out.println("Cavallos: " + nextRecord[4]);
                System.out.println("Peso: " + nextRecord[5]);
                System.out.println("Aceleración: " + nextRecord[6]);
                System.out.println("Modelo: " + nextRecord[7]);
                System.out.println("Origen: " + nextRecord[8]);
                System.out.println("==========================");
			}
			
		} catch (IOException e) {
			System.out.println("IO Exception");		
			}
	}
}
