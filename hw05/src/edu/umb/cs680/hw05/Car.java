package edu.umb.cs680.hw05;

public class Car {
	
	private String make, model;
	private int mileage, year;
	private float price;
	
	public Car(String make, String model, int year, int mileage, float price) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
		this.price = price;
	}
	// getter methods
	public String getmake() {
		return make;
	}
	public String getmodel() {
		return model;
	}
	public int getmileage() {
		return mileage;
	}
	public int getyear() {
		return year;
	}
	public float getprice() {
		return price;
	} 
	
	public static void main(String[] args) {
		System.out.println("The class car has completely run");
	}
}
