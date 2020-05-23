package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class YearComparatorTest {

	LinkedList<Car> carsList = new LinkedList<Car>();

	@Test
	void verifyYearComparator() {

		carsList.add(new Car("Audi", "A4", 2014, 16, 45000));
		carsList.add(new Car("BMW", "M3", 2015, 8, 100000));
		carsList.add(new Car("Toyota", "Fortuner", 2016, 10, 30000));

		Collections.sort(carsList, new YearComparator());

		assertEquals(2014, carsList.get(0).getYear());
		assertEquals(2015, carsList.get(1).getYear());
		assertEquals(2016, carsList.get(2).getYear());

	}

}
