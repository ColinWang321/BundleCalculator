package com.codetest.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

class DemoApplicationTests {

	Bundle bundle;

	@BeforeEach
	void setUp() {
		bundle = new Bundle();
	}




	@Test
	void testIndexOfFunction() {
		String[] strArray = {"Jan", "Feb", "March", "Apr", "May"};

		Assertions.assertEquals(0, bundle.indexOf(strArray, "Jan"));
		Assertions.assertEquals(4, bundle.indexOf(strArray, "May"));
		Assertions.assertEquals(2, bundle.indexOf(strArray, "March"));
		Assertions.assertEquals(3, bundle.indexOf(strArray, "Apr"));
		Assertions.assertEquals(1, bundle.indexOf(strArray, "Feb"));

	}

	@Test
	void testCalBundleFunction() {
		Order order = new Order();
		ArrayList<Integer> calculatedNumbers = new ArrayList<>();
		calculatedNumbers.add(2);
		calculatedNumbers.add(1);

		Assertions.assertEquals(calculatedNumbers, bundle.calBundle(23, "IMG", order));

	}

}
