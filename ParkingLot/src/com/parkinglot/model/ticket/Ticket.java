package com.parkinglot.model.ticket;

import java.time.LocalDateTime;

import com.parkinglot.model.parkinglot.Base;
import com.parkinglot.model.parkinglot.Gate;
import com.parkinglot.model.parkinglot.Operator;
import com.parkinglot.model.parkinglot.ParkingLot;
import com.parkinglot.model.parkingslot.ParkingSlot;
import com.parkinglot.model.vhecle.Vhecle;

public class Ticket extends Base{
	
	private Vhecle vhecle;
	private Operator generatedBy;
	private Gate entryGate;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	public LocalDateTime getExitTime() {
		return exitTime;
	}
	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}
	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}
	
	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	private String owner;
	private ParkingSlot parkingSlot;
	private ParkingLot parkinglot;
	private TicketStatus ticketStatus;
	private double charge;
	
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public Vhecle getVhecle() {
		return vhecle;
	}
	public void setVhecle(Vhecle vhecle) {
		this.vhecle = vhecle;
	}
	public Operator getGeneratedBy() {
		return generatedBy;
	}
	public void setGeneratedBy(Operator generatedBy) {
		this.generatedBy = generatedBy;
	}
	public Gate getEntryGate() {
		return entryGate;
	}
	public void setEntryGate(Gate entryGate) {
		this.entryGate = entryGate;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}
	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}
	public ParkingLot getParkinglot() {
		return parkinglot;
	}
	public void setParkinglot(ParkingLot parkinglot) {
		this.parkinglot = parkinglot;
	}

}
