package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



class DominationComparatorTest {

	static LinkedList<Car> carList = new LinkedList<Car>();
	
	@BeforeAll
	public static void initialize() {
		Car car1 = new Car("Toyota", "RAV4", 2018, 50000, 100000);
		Car car2 = new Car("BMW", "XYZ", 2017, 35000, 50000);
		Car car3 = new Car("Ford", "ABC", 2016, 30000, 30000);
		Car car4 = new Car("KIA", "UVW", 2015, 10000, 10000);
		carList.add(car1);carList.add(car2);carList.add(car3);
		carList.add(car4);
		for(int i=0 ; i<carList.size() ; i++) {
			carList.get(i).setDominationCount(i);
		}
		Collections.sort(carList,(Car arg0, Car arg1) -> arg1.getDominationCount()-arg0.getDominationCount());
	}
	@Test
	void testforcar3() {
		assertSame(1, carList.get(2).getDominationCount());
	}
	
	@Test
	void testforcar1() {
		assertSame(3, carList.get(0).getDominationCount());
	}
	
	@Test
	void testforcar2() {
		assertSame(2, carList.get(1).getDominationCount());
	}
	
	
	
	@Test
	void testforcar4() {
		assertSame(0, carList.get(3).getDominationCount());
	}
	
	

}
