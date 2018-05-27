package com.iesvirgendelcarmen.proyecto.LeerCSV;

public class Cars {
	private String id;
	private String car;
	private String color;
	private String modelo;
	private String origen;
	
	public Cars(String id, String car, String color, String modelo, String origen) {
		this.id = id;
		this.car = car;
		this.color = color;
		this.modelo = modelo;
		this.origen = origen;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return "Cars [id=" + id + ", car=" + car + ", color=" + color + ", modelo=" + modelo + ", origen=" + origen
				+ "]";
	}
	
	
	
	}
