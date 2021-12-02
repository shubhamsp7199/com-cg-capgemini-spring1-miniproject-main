package com.cg.spring.boot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.cg.spring.boot.demo.exception.NoSuchConnectionException;
import com.cg.spring.boot.demo.model.Connection;
import com.cg.spring.boot.demo.repository.AddressRespository;
import com.cg.spring.boot.demo.repository.ConnectionRespository;

@Service
class ConnectionServiceImpliment implements  ConnectionService
{
	private static final Logger LOG = LoggerFactory.getLogger(ConnectionServiceImpliment.class);
	
	 @Autowired
	    private ConnectionRespository connectionRepository;
	 
	 @Autowired
	    private AddressRespository addressRepository;
	 

  @Override
	public Connection newConnectionRequest(Connection newConnection) throws NoSuchConnectionException 
	{
	  LOG.info("Add new Connection");
	  if (!connectionRepository.existsById(newConnection.getConnectionId()))
	  	{
		  	return connectionRepository.save(newConnection);   
	  	}
	  else
	  {
		  LOG.info(" connection already exists.");
		  throw new NoSuchConnectionException (newConnection.getConnectionId() + " already exists.");
	  } 
  
	}

	@Override
	public Connection modifyConnection(Connection connection) throws NoSuchConnectionException {
		
		LOG.info("Service Modify Connection");
		if (connectionRepository.existsById(connection.getConnectionId()))
		{
			return connectionRepository.save(connection);	
		}
		else
		{
			LOG.info( "Connection does not exist.");
			throw new NoSuchConnectionException(connection.getConnectionId()+"does not exits");		
		}

	}


	@Override
	
	public Connection modifyConnectionAddress(Connection connection) {
		
		
			if (connectionRepository.existsById(connection.getConnectionId()))
			{
				 LOG.info("Service update Connection Address");
				return connectionRepository.save(connection);	
			}
			else
			{
				LOG.info(connection.getConnectionId() + " does not exist.");
			}		
			return null;
		
	}
	@Override
	public List<Connection> findConnectionsByPincode(Long pincode) throws NoSuchConnectionException {
		System.out.println("getConnectionsByPincode");
		Optional custOpt = addressRepository.findById(pincode);
		if (custOpt.isPresent()) {
			System.out.println("Cunsumer is available.");
			return (List<Connection>) custOpt.get();
		} else {
			
			throw new NoSuchConnectionException( " this cunsumer is not found.");
		}
	
     }

	@Override
	public Connection findConnectionById(Long connectionId) throws NoSuchConnectionException {
			LOG.info("getConnectionIdById");
			Optional<Connection> empOpt = connectionRepository.findById(connectionId);
			if (empOpt.isPresent()) {
				LOG.info("Connection is available.");
				return empOpt.get();
			} else {
				LOG.info("connection is NOT available.");
				throw new NoSuchConnectionException(connectionId + " this connection is not found.");
			}		

	}	
}