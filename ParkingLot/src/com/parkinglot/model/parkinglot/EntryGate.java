package com.parkinglot.model.parkinglot;

import java.time.LocalDateTime;
import java.util.UUID;

import com.parkinglot.model.parkingslot.ParkingSlot;
import com.parkinglot.model.ticket.Ticket;
import com.parkinglot.model.ticket.TicketStatus;
import com.parkinglot.model.vhecle.Vhecle;

public class EntryGate extends Gate{

	private DisplayBoard displayBoard;

	public DisplayBoard getDisplayBoard() {
		return displayBoard;
	}

	public void setDisplayBoard(DisplayBoard displayBoard) {
		this.displayBoard = displayBoard;
	}
	
	public Ticket generateToken(Vhecle vhecle) {
		if(!ParkingLot.INSTANCE.canPark(vhecle))return null;
		ParkingSlot slot=ParkingLot.INSTANCE.getParkingSpot(vhecle);
		if(slot==null)return null;
		
		return buildTicket(slot,vhecle,ParkingLot.INSTANCE);
	}
	private Ticket buildTicket(ParkingSlot slot,Vhecle vhecle,ParkingLot lot) {
		Ticket ticket=new Ticket();
		ticket.setParkinglot(lot);
		ticket.setParkingSlot(slot);
		ticket.setVhecle(vhecle);
		ticket.setGeneratedBy(this.getOperator());
		ticket.setEntryTime(LocalDateTime.now());
		ticket.setEntryGate(this);
		ticket.setId(UUID.randomUUID().toString());
		ticket.setTicketStatus(TicketStatus.ACTIVE);
		return ticket;
	}
	public void updateParkingSpot() {
		
	}
	
	
}
