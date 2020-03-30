package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	
	private String[] carToStringArray(Car car) {
		String[] strarr = {car.getmake(), car.getmodel(), Integer.toString(car.getyear())};// as obj cannot be compared
		return strarr;
	}
	
	@Test
	void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"Toyota", "RAV4", "2018"};
		Car actual = new Car("Toyota", "RAV4", 2018, 3, 3);
		assertArrayEquals(expected, carToStringArray(actual));
		}
}

