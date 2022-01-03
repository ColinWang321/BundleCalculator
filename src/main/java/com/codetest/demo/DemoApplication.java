package com.codetest.demo;

// (Auto create from https://start.spring.io/)It seems we won't use spring web here.
//import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//@SpringBootApplication
public class DemoApplication {

	static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {

		Bundle bundle = new Bundle();

		String str = bundle.bestBundle(26, "IMG");
		System.out.println(str);


	}

}
