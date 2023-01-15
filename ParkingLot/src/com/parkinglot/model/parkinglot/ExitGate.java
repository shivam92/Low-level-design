package com.parkinglot.model.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

import com.parkinglot.model.parkingslot.ParkingSlot;
import com.parkinglot.model.parkingslot.SlotType;
import com.parkinglot.model.ticket.Ticket;
import com.parkinglot.model.ticket.TicketStatus;
import com.parkinglot.stretagy.CostCalCulator;

public class ExitGate extends Gate{

	private CostCalCulator costCalCulator;
	
	public ExitGate(CostCalCulator costCalCulator ) {
		this.costCalCulator=costCalCulator;
	}
	public void initiatePayment() {
		
	}
	
	public Ticket scanAndVacat(Ticket ticket) {
		ParkingSlot slot=ParkingLot.INSTANCE.vacateSpot(ticket.getParkingSlot().getId());
		double charge=calCulateCharge(ticket,slot.getSlotType());
		ticket.setTicketStatus(TicketStatus.INACTIVE);
		ticket.setCharge(charge);
		ticket.setExitTime(LocalDateTime.now());
		return ticket;
	}
	
	double calCulateCharge(Ticket ticket,SlotType type) {
		 Duration duration = Duration.between(ticket.getEntryTime(), LocalDateTime.now());
	        long hours = duration.toHours();
	        if (hours == 0)
	            hours = 1;
	        double amount = hours *  costCalCulator.getCost(type);
	        return amount;
	}
}
