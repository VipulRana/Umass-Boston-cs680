package edu.umb.cs680.hw02;

public class Calculator {

	public float multiply(float x, float y) {
		return x * y;
	}

	public float divide(float x, float y) {
		if (y == 0) {
			throw new IllegalArgumentException("division by zero");
		}
		return x / y;
	}

	public static void main(String[] args)
	{
		Calculator c = new Calculator();
		System.out.println("Multiplicaion for 2 and 8 " + c.multiply(2, 8));
		System.out.println("Division for 2 and 8 " + c.divide(2, 8));
	}

}