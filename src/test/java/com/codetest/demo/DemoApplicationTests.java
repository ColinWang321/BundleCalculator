package com.codetest.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class DemoApplicationTests {

	BundleCalculator bundleCalculator = new BundleCalculator();
	Logger logger = LoggerFactory.getLogger(getClass());


	@Test
	void testCorrectOutput() {
		String bestBundle = bundleCalculator.bestBundle("26 IMG");

		logger.info(" : Best bundle test result for '26 IMG' is: " + bestBundle);

//		logger.trace("This is trace log...");
//		logger.debug("This is debug log...");
//		logger.info("This is info log...");
//		logger.warn("This is warn log...");
//		logger.error("This is error log...");

//		System.out.println(bestBundle);
	}

	@Test
	void testWrongInput(){
		String bestBundleWrongInput = bundleCalculator.bestBundle("26 IMGslkdjflkasj");

		logger.info(" : Test for '26 IMGslkdjflkasj', result is: " + bestBundleWrongInput);
	}

	@Test
	void testRedundantInput(){
		String bestBundleRedundantInput = bundleCalculator.bestBundle("26 IMG slkdjflkasj");

		logger.info(" : Test for '26 IMG slkdjflkasj', result is: " + bestBundleRedundantInput);
	}

	@Test
	void testZeroNumberInput(){
		String bestBundleZeroNumber = bundleCalculator.bestBundle("0 IMG");

		logger.info(" : Test for '0 IMG', result is: " + bestBundleZeroNumber);
	}

	@Test
	void testWrongNumberInput(){
		String bestBundleWrongNumber = bundleCalculator.bestBundle("-55 IMG");

		logger.info(" : Test for '-55 IMG', result is: " + bestBundleWrongNumber);
	}
}
