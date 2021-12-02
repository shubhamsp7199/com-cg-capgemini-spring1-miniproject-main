package com.cg.spring.boot.demo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reading_table")
public class Reading {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long readingId;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "connection_reading", referencedColumnName = "connectionId")
	private Connection readingForConnection;
	@Column
	private int unitsConsumed;
	@Column
	private Long reading;


	@Column
	private LocalDate readingDate;

	public Reading(Long readingId, Connection readingForConnection, int unitsConsumed, Long reading,
			LocalDate readingDate, int pricePerUnits) {
		super();
		this.readingId = readingId;
		this.readingForConnection = readingForConnection;
		this.unitsConsumed = unitsConsumed;
		this.reading = reading;
		this.readingDate = readingDate;

	}

	public Reading() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getReadingId() {
		return readingId;
	}

	public void setReadingId(Long readingId) {
		this.readingId = readingId;
	}

	public Connection getReadingForConnection() {
		return readingForConnection;
	}

	public void setReadingForConnection(Connection readingForConnection) {
		this.readingForConnection = readingForConnection;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}



	public Long getReadingPhoto() {
		return reading;
	}

	public void setReadingPhoto(Long readingPhoto) {
		this.reading = readingPhoto;
	}

	public LocalDate getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(LocalDate readingDate) {
		this.readingDate = readingDate;
	}

	@Override
	public String toString() {
		return "Reading [readingId=" + readingId + ", readingForConnection=" + readingForConnection + ", unitsConsumed="
				+ unitsConsumed + ", readingPhoto=" + reading + ", readingDate=" + readingDate + "]";
	}

}
