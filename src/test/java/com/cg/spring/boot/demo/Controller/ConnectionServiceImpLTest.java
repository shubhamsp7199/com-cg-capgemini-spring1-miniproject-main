package com.cg.spring.boot.demo.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.cg.spring.boot.demo.controller.ConnectionController;
import com.cg.spring.boot.demo.exception.NoSuchConnectionException;
@SpringBootTest
public class ConnectionServiceImpLTest {
	
	
    @Autowired
    private ConnectionController connectionController;
   
    
    @Test
	public void testToNewConnection() throws NoSuchConnectionException {
    	
		HttpStatus expected = connectionController.findConnectionById((long) 2).getStatusCode();
		HttpStatus actual = HttpStatus.OK;
		
//		equals(actual,expected);
		    					
	}


}
