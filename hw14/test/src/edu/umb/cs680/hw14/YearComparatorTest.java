package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class YearComparatorTest {

static LinkedList<Car> carList = new LinkedList<Car>();
	
	@BeforeAll
	public static void initialize() {
		Car car1 = new Car("Toyota", "RAV4", 2018, 50000, 100000);
		Car car2 = new Car("Beamer", "3series", 2017, 35000, 50000);
		Car car3 = new Car("Ford", "Mustang", 2016, 30000, 30000);
		Car car4 = new Car("KIA", "Soul", 2015, 10000, 10000);
		carList.add(car1);carList.add(car2);carList.add(car3);
		carList.add(car4);
		Collections.sort(carList,(Car arg0, Car arg1) -> arg0.getYear()-arg1.getYear());
	}
	@Test
	void testforcar3() {
		Car car3 = new Car("Ford", "Mustang", 2016, 30000, 30000);
		assertEquals(car3, carList.get(1));
	}
	
	@Test
	void testforcar1() {
		Car car1 = new Car("Toyota", "RAV4", 2018, 50000, 100000);
		assertEquals(car1, carList.get(3));
	}
	
	@Test
	void testforcar2() {
		Car car2 = new Car("Beamer", "3series", 2017, 35000, 50000);
		assertEquals(car2, carList.get(2));
	}
	
	
	@Test
	void testforcar4() {
		Car car4 = new Car("KIA", "Soul", 2015, 10000, 10000);
		assertEquals(car4, carList.get(0));
	}
	
	

}
