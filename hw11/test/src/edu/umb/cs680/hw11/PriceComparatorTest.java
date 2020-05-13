package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PriceComparatorTest {

static LinkedList<Car> carList = new LinkedList<Car>();
	
	@BeforeAll
	public static void initialize() {
		Car car1 = new Car("Toyota", "RAV4", 2018, 50000, 100000);
		Car car2 = new Car("BMW", "XYZ", 2017, 35000, 50000);
		Car car3 = new Car("Ford", "ABC", 2016, 30000, 30000);
		Car car4 = new Car("KIA", "UVW", 2015, 10000, 10000);
		carList.add(car1);carList.add(car2);carList.add(car3);
		carList.add(car4);
	}
	@Test
	void testforcar3() {
		Car car3 = new Car("Ford", "ABC", 2016, 30000, 30000);
		carList.sort(new PriceComparator());
		assertEquals(car3, carList.get(2));
	}
	@Test
	void testforcar1() {
		Car car1 = new Car("Toyota", "RAV4", 2018, 50000, 100000);
		carList.sort(new PriceComparator());
		assertEquals(car1, carList.get(0));
	}
	
	@Test
	void testforcar2() {
		Car car2 = new Car("BMW", "XYZ", 2017, 35000, 50000);
		carList.sort(new PriceComparator());
		assertEquals(car2, carList.get(1));
	}
	
	
	
	@Test
	void testforcar4() {
		Car car4 = new Car("KIA", "UVW", 2015, 10000, 10000);
		carList.sort(new PriceComparator());
		assertEquals(car4, carList.get(3));
	}
	
	

}
