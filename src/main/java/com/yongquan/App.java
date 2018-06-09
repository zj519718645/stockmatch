package com.yongquan;

import org.apache.log4j.Logger;
public class App {

	  final static Logger logger = Logger.getLogger(App.class);

	  public static void main(String[] args) {

	    App obj = new App();

	    try {
	      obj.divide();
	    } catch (ArithmeticException ex) {
	      logger.error("Sorry, something wrong!", ex);
	    }
	  }

	  private void divide() {
	    int i = 10 / 0;

	  }

	}
