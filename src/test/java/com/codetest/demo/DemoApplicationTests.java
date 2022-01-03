package com.codetest.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class DemoApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());
	Bundle bundle = new Bundle();

	@Test
	void testCorrectOutput() {
		String str = bundle.bestBundle(14, "IMG");
		logger.info("Test Correct Output result: " + str);
	}

	@Test
	void testWrongNumber() {
		String str = bundle.bestBundle(-1, "IMG");
		logger.info("Test Wrong Number result: " + str);
	}

	@Test
	void testWrongType() {
		String str = bundle.bestBundle(23, "IMGG");
		logger.info("Test Wrong Type result: " + str);
	}

	@Test
	void testNullType() {
		String str = bundle.bestBundle(23, "");
		logger.info("Test Null Type result: " + str);
	}
}
