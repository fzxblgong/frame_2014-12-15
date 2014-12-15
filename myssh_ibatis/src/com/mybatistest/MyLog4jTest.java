package com.mybatistest;

import org.apache.log4j.Logger;
import org.junit.Test;

public class MyLog4jTest {
	static Logger logger = null;
	@Test
	public void log4jTest(){
		  logger=Logger.getLogger(MyLog4jTest.class); 
		  logger.debug("debuge..." ) ; 
		  logger.info("Info...");
	        logger.warn("Warn ...");
	        logger.error("Error ..."); 
	}
}
