package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StockQuoteObservableTest {

	@Test
	void checkDijaQuote() {
		PiechartObserver PiechartObserver = new PiechartObserver();
		TableObserver TableObserver = new TableObserver();
		ThreeDObserver THREEDObserver = new ThreeDObserver();

		StockQuoteObservable djiaObserver = new StockQuoteObservable();
		djiaObserver.addObserver(PiechartObserver);
		djiaObserver.addObserver(TableObserver);
		djiaObserver.addObserver(THREEDObserver);
// randomly changing quote to notifiy the observer
		djiaObserver.changeQuote("VIPUL",35);
		djiaObserver.changeQuote("ASDF",50);
	}
}

