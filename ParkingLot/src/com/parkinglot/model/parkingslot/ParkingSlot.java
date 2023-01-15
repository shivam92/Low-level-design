package com.parkinglot.model.parkingslot;

import com.parkinglot.model.parkinglot.Base;

public class ParkingSlot extends Base{

	 private ParkingSlotStatus status;
	   
	  private SlotType slotType;
	  private String vhecleId;
	  
	public   ParkingSlot(String id,SlotType type) {
		this.setId(id);
		this.slotType=type;
	}
	
	public ParkingSlotStatus getStatus() {
		return status;
	}

	public void setStatus(ParkingSlotStatus status) {
		this.status = status;
	}

	public SlotType getSlotType() {
		return slotType;
	}
	public void setSlotType(SlotType slotType) {
		this.slotType = slotType;
	}
	public String getVhecleId() {
		return vhecleId;
	}
	public void setVhecleId(String vhecleId) {
		this.vhecleId = vhecleId;
	}
	  
	public void freeSpot() {
		this.status=ParkingSlotStatus.AVAILABLE;
		this.vhecleId=null;
	}
	
	public void assignedVhecle(String vhecleId) {
		this.vhecleId=vhecleId;
	}
	
}
