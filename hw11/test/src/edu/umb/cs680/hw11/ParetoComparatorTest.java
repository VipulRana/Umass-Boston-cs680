package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class ParetoComparatorTest {

	LinkedList<Car> carsList = new LinkedList<Car>();

	@Test
	public void verifyParetoCompare1() {
		carsList.add(new Car("Audi", "A4", 2014, 16, 45000));
		carsList.add(new Car("BMW", "M3", 2015, 8, 100000));
		carsList.add(new Car("Toyota", "Fortuner", 2016, 10, 30000));

		for (Car car : carsList) {
			car.setDominationCount(carsList);
		}
		Collections.sort(carsList, new ParetoComparator());

		assertEquals(30000, carsList.get(0).getPrice());
		assertEquals(45000, carsList.get(1).getPrice());
		assertEquals(100000, carsList.get(2).getPrice());

	}
}
