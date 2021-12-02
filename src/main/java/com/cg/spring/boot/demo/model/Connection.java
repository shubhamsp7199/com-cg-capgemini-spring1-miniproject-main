package com.cg.spring.boot.demo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "connection_table") 
public class Connection{
	// should be auto-generated for internal purpose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long connectionId;
	
	// customerId auto-generated
    @OneToOne (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name= "customerConnection",referencedColumnName = "customerId")
	private Customer customer;
	
   
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name= "address",referencedColumnName = "addressId")
    private Address address;
	
    @Column
	private Long consumerNumber;
    
    @Enumerated(EnumType.STRING)
	private ConnectionType connectionType;
	
    @Column
	private LocalDate applicationDate;
	
    @Column
	private LocalDate connectionDate;
	
    @Column(name = "connectionStatus")
    @Pattern(regexp = "^[A|I]{1}$", message ="Must be Active or Inactive")
	private boolean connectionStatus;
	
	public Connection()
	{
		super();
	}


	public Connection(Long connectionId, Customer customer, Address address, ConnectionType connectionType,
			LocalDate applicationDate, LocalDate connectionDate,
			@Pattern(regexp = "^[A|I]{1}$", message = "Must be Active or Inactive") boolean connectionStatus) {
		super();
		this.connectionId = connectionId;
		this.customer = customer;
		this.address = address;
		this.connectionType = connectionType;
		this.applicationDate = applicationDate;
		this.connectionDate = connectionDate;
		this.connectionStatus = connectionStatus;
	}


	public Long getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address getaddress() {
		return address;
	}
	public void setConnectionAddress(Address address) {
		this.address = address;
	}
	public ConnectionType getConnectionType() {
		return connectionType;
	}
	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}
	public LocalDate getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}
	public LocalDate getConnectionDate() {
		return connectionDate;
	}
	public void setConnectionDate(LocalDate connectionDate) {
		this.connectionDate = connectionDate;
	}

	@Override
	public String toString() {
		return "Connection [connectionId=" + connectionId + ", customer=" + customer + ", address=" + address
				+ ", connectionType=" + connectionType + ", applicationDate=" + applicationDate + ", connectionDate="
				+ connectionDate + ", connectionStatus=" + connectionStatus + "]";
	}

	
}
