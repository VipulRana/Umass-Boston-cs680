package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class MileageComparatorTest {

	LinkedList<Car> carsList = new LinkedList<Car>();

	@Test
	public void verifyMileageComparator() {
		carsList.add(new Car("Audi", "A4", 2014, 16, 45000));
		carsList.add(new Car("BMW", "M3", 2015, 8, 100000));
		carsList.add(new Car("Toyota", "Fortuner", 2016, 10, 30000));

		Collections.sort(carsList, new MileageComparator());

		assertEquals(16, carsList.get(0).getMileage());
		assertEquals(10, carsList.get(1).getMileage());
		assertEquals(8, carsList.get(2).getMileage());

	}
}
