package com.capgemini.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "bill_table")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billId;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "reading", referencedColumnName = "readingId")
	private Reading billForReading;

	@Column
	private LocalDate billDate;

	@Column
	private LocalDate billDueDate;

	@Column
	private int unitsConsumed;

	@Column
	private int billAmount;

	@ManyToOne
	@JoinColumn(name = "paymentId")
	private Payment payment;

	@ManyToOne
	@JoinColumn(name = "connectionId")
	private Connection connection;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Bill() {
		super();
	}

	public Bill(Long billId, Reading billForReading, LocalDate billDate, LocalDate billDueDate, int unitsConsumed,
			int billAmount, Payment payment, Connection connection, Customer customer) {
		super();
		this.billId = billId;
		this.billForReading = billForReading;
		this.billDate = billDate;
		this.billDueDate = billDueDate;
		this.unitsConsumed = unitsConsumed;
		this.billAmount = billAmount;
		this.payment = payment;
		this.connection = connection;
		this.customer = customer;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Reading getBillForReading() {
		return billForReading;
	}

	public void setBillForReading(Reading billForReading) {
		this.billForReading = billForReading;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public LocalDate getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(LocalDate billDueDate) {
		this.billDueDate = billDueDate;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billForReading=" + billForReading + ", billDate=" + billDate
				+ ", billDueDate=" + billDueDate + ", unitsConsumed=" + unitsConsumed + ", billAmount=" + billAmount
				+ ", payment=" + payment + ", connection=" + connection + ", customer=" + customer + "]";
	}

}
