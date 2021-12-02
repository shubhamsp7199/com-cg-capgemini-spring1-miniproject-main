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
@Table(name = "reading")
public class Reading {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long readingId;

	@Column
	private int unitsConsumed;

	@Column
	private String readingPhoto;

	@Column
	private LocalDate readingDate;

	@Column
	private int pricePerUnits;

	@OneToOne
	@JoinColumn(name = "billId")
	private Bill bill;

	public Reading() {
		super();
	}

	public Reading(Long readingId, Connection readingForConnection, int unitsConsumed, String readingPhoto,
			LocalDate readingDate, int pricePerUnits, Bill bill) {
		super();
		this.readingId = readingId;
		this.unitsConsumed = unitsConsumed;
		this.readingPhoto = readingPhoto;
		this.readingDate = readingDate;
		this.pricePerUnits = pricePerUnits;
		this.bill = bill;
	}

	public Long getReadingId() {
		return readingId;
	}

	public void setReadingId(Long readingId) {
		this.readingId = readingId;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public String getReadingPhoto() {
		return readingPhoto;
	}

	public void setReadingPhoto(String readingPhoto) {
		this.readingPhoto = readingPhoto;
	}

	public LocalDate getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(LocalDate readingDate) {
		this.readingDate = readingDate;
	}

	public int getPricePerUnits() {
		return pricePerUnits;
	}

	public void setPricePerUnits(int pricePerUnits) {
		this.pricePerUnits = pricePerUnits;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "Reading [readingId=" + readingId + ", unitsConsumed=" + unitsConsumed + ", readingPhoto=" + readingPhoto
				+ ", readingDate=" + readingDate + ", pricePerUnits=" + pricePerUnits + ", bill=" + bill + "]";
	}

}
