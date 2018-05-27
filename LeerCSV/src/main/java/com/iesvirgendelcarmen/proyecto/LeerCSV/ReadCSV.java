package com.iesvirgendelcarmen.proyecto.LeerCSV;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


public class ReadCSV {
	private static final String CSV_FILE_PATH = "ficherosCSV/MOCK_DATA.csv";
	private static List<Cars> carList = new ArrayList<>();
	
	private List<Cars> getCarListFromCSV(String csvFilePath) {
		try(
				Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			) {
				// Para construir el csvReaderBuilder se necesitará el CsvParserBuilder, ya que este csv usa como delimitador el
				// caracter ; y no la coma (usada por defecto).
				
				CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
				
				// CsvReaderBuilder se encargará de la lectura del fichero, se obvian las dos primeras lineas y se parsea con
				// el delimitador ; designado anteriormente
				
				CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
				String nextRecord[];
				while((nextRecord=csvReader.readNext())!=null) {
					carList.add(new Cars(nextRecord[0], nextRecord[1], nextRecord[2], nextRecord[3], nextRecord[4]));
				}
			} catch (IOException e) {
				System.out.println("IO Exception");		
				}
			return carList;
	}
	public static void main(String[] args) {
		ReadCSV reader = new ReadCSV();
		List<Cars> listaCoches = reader.getCarListFromCSV(CSV_FILE_PATH);
		System.out.println(listaCoches.get(0).getCar());
	}
}
