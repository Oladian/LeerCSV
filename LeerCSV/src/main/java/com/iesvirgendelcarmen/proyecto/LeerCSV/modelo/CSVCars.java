ackage com.iesvirgendelcarmen.proyecto.LeerCSV.modelo;

import com.opencsv.bean.CsvBindByName;

public class CSVCars {
	
	@CsvBindByName
	private String name;
	
	@CsvBindByName(column="MPG", required=true)
	private double MPG;
	
	@CsvBindByName(column="Cylinders")
	private int Cylinders;
	
	@CsvBindByName(column="Displacement")
	private double Displacement;
	
	@CsvBindByName(column="Horsepower")
	private double Horsepower;
	
	@CsvBindByName(column="Weight")
	private double Weight;
	
	@CsvBindByName(column="Acceleration")
	private double Acceleration;
	
	@CsvBindByName(column="Model")
	private int Model;

	@CsvBindByName(column="Origin")
	private String Origin;
	
}
