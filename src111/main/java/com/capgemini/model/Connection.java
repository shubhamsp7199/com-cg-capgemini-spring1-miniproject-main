package com.capgemini.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "connection")
public class Connection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long connectionId;

	@Column
	private Long consumerNumber;

	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customerConnection;

	@OneToOne
	@JoinColumn(name = "addressId")
	private Address connectionAddress;

	@Column
	private ConnectionType connectionType;

	@Column
	private LocalDate applicationDate;

	@Column
	private LocalDate connectionDate;
	// connectionStatus will be active or inactive
	@Column
	private boolean connectionStatus;

	@OneToOne
	@JoinColumn(name = "readingId")
	private Reading reading;

	public Connection() {
		super();
	}

	public Connection(Long connectionId, Long consumerNumber, Customer customerConnection, Address connectionAddress,
			ConnectionType connectionType, LocalDate applicationDate, LocalDate connectionDate,
			boolean connectionStatus, Reading reading) {
		super();
		this.connectionId = connectionId;
		this.consumerNumber = consumerNumber;
		this.customerConnection = customerConnection;
		this.connectionAddress = connectionAddress;
		this.connectionType = connectionType;
		this.applicationDate = applicationDate;
		this.connectionDate = connectionDate;
		this.connectionStatus = connectionStatus;
		this.reading = reading;
	}

	public Long getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}

	public Long getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(Long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public Customer getCustomerConnection() {
		return customerConnection;
	}

	public void setCustomerConnection(Customer customerConnection) {
		this.customerConnection = customerConnection;
	}

	public Address getConnectionAddress() {
		return connectionAddress;
	}

	public void setConnectionAddress(Address connectionAddress) {
		this.connectionAddress = connectionAddress;
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

	public boolean isConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public Reading getReading() {
		return reading;
	}

	public void setReading(Reading reading) {
		this.reading = reading;
	}

	@Override
	public String toString() {
		return "Connection [connectionId=" + connectionId + ", consumerNumber=" + consumerNumber
				+ ", customerConnection=" + customerConnection + ", connectionAddress=" + connectionAddress
				+ ", connectionType=" + connectionType + ", applicationDate=" + applicationDate + ", connectionDate="
				+ connectionDate + ", connectionStatus=" + connectionStatus + ", reading=" + reading + "]";
	}

}
