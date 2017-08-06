package com.ak.spring4.controller;

import org.apache.log4j.Logger;

public class BaseController {  
	
	private static final Logger logger = Logger.getLogger(BaseController.class);
	
	public void catchException(String _errMsg, Throwable _errCause){
		logger.error(_errMsg);
	}
}
