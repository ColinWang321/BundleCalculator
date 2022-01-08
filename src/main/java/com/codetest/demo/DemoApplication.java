package com.codetest.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DemoApplication {

    static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {

        Bundle bundle = new Bundle();

        String str = bundle.calBestBundlesFromTxtFile("bundle.txt");
        logger.info(str);


    }

}
