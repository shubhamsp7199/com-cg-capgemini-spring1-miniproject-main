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
@Table(name = "payment_table")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	
	@OneToOne
	@JoinColumn(name = "billId")
	private Bill billPayment;
	
	@Column
	private LocalDate paymentDate;
	
//	@OneToOne (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name= "payment",referencedColumnName = "paymentId")
	@Column
	private PaymentMode paymentMode;
	
	@Column
	private double latePaymentCharges;
	
	@Column
	private double totalPaid;
	
	@Column
	private PaymentStatus status;

	public Payment() {
		super();
	}

	public Payment(Long paymentId, Bill billPayment, LocalDate paymentDate, PaymentMode paymentMode,
			double latePaymentCharges, double totalPaid, PaymentStatus status) {
		super();
		this.paymentId = paymentId;
		this.billPayment = billPayment;
		this.paymentDate = paymentDate;
		this.paymentMode = paymentMode;
		this.latePaymentCharges = latePaymentCharges;
		this.totalPaid = totalPaid;
		this.status = status;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Bill getBillPayment() {
		return billPayment;
	}

	public void setBillPayment(Bill billPayment) {
		this.billPayment = billPayment;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double getLatePaymentCharges() {
		return latePaymentCharges;
	}

	public void setLatePaymentCharges(double latePaymentCharges) {
		this.latePaymentCharges = latePaymentCharges;
	}

	public double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", billPayment=" + billPayment + ", paymentDate=" + paymentDate
				+ ", paymentMode=" + paymentMode + ", latePaymentCharges=" + latePaymentCharges + ", totalPaid="
				+ totalPaid + ", status=" + status + "]";
	}
	
	
	
	}
