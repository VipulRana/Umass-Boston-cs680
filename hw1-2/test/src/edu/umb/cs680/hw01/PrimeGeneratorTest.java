package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	void basecase() {
		PrimeGenerator gen = new PrimeGenerator(5, 23);
		gen.generatePrimes();
		LinkedList<Long> primevalues = new LinkedList<Long>();
		primevalues.add((long) 5);
		primevalues.add((long) 7);
		primevalues.add((long) 11);
		primevalues.add((long) 13);
		primevalues.add((long) 17);
		primevalues.add((long) 19);
		primevalues.add((long) 23);
		assertEquals(primevalues, gen.getPrimes());
	}

	@Test
	void neg0toneg30() {
		try {
			PrimeGenerator gen = new PrimeGenerator(-30, -30);
		} catch (Exception ex) {
			assertEquals("Wrong input values: from=-30 to=-30", ex.getMessage());
		}
	}
	
	@Test
	void neg30to1() {
		try { 
			PrimeGenerator gen = new PrimeGenerator(-30, 1);
		} catch (Exception ex) {
			assertEquals("Wrong input values: from=-30 to=1", ex.getMessage());
		}
	}
	
	@Test
	void desc30to1() {
		try {
			PrimeGenerator gen = new PrimeGenerator(30, 1);
		} catch (Exception ex) {
			assertEquals("Wrong input values: from=30 to=1", ex.getMessage());
		}
	}
	
}