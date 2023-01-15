package com.parkinglot.model.parkinglot;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

import com.parkinglot.model.parkingslot.ParkingSlot;
import com.parkinglot.model.parkingslot.SlotType;
import com.parkinglot.model.vhecle.Vhecle;

public class Floor extends Base {

	
	private Map<SlotType,Deque<ParkingSlot>>parkingSlot;
	private Map<String,ParkingSlot>usedParkingSlot;
	
	public Map<SlotType, Deque<ParkingSlot>> getParkingSlot() {
		return parkingSlot;
	}
	public void setParkingSlot(Map<SlotType, Deque<ParkingSlot>> parkingSlot) {
		this.parkingSlot = parkingSlot;
	}
	public Map<String, ParkingSlot> getUsedParkingSlot() {
		return usedParkingSlot;
	}
	public void setUsedParkingSlot(Map<String, ParkingSlot> usedParkingSlot) {
		this.usedParkingSlot = usedParkingSlot;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	private int floorNumber;
	
	public Floor(String id) {
		parkingSlot=new HashMap<SlotType,Deque<ParkingSlot>>();
		usedParkingSlot=new HashMap<String,ParkingSlot>();
		this.setId(id);//=id;
		parkingSlot.put(SlotType.LARGE, new ConcurrentLinkedDeque<ParkingSlot>());
		parkingSlot.put(SlotType.ELECTRIC, new ConcurrentLinkedDeque<ParkingSlot>());
		parkingSlot.put(SlotType.MEDIUM, new ConcurrentLinkedDeque<ParkingSlot>());
		parkingSlot.put(SlotType.SMALL, new ConcurrentLinkedDeque<ParkingSlot>());
	}
	public boolean isFloorFull() {
		boolean isFull=true;
		for(Map.Entry<SlotType,Deque<ParkingSlot>>entry:parkingSlot.entrySet()) {
			if(entry.getValue().size()==0)isFull=false;
		}
		return isFull;
	}
	public SlotType getSlotTypeForVhecle(Vhecle vhecle){
		
		switch(vhecle.getVhecleType()) {
		
		case ELECTRIC: return SlotType.ELECTRIC;
		case LARGE: return SlotType.LARGE;
		case MEDIUM: return SlotType.MEDIUM;
		case SMALL: return SlotType.SMALL;
		
		}
		return null;
	}
	public ParkingSlot getSpot(Vhecle vhecle) {
		
		if(!canPark(vhecle))return null;
		SlotType slotType=getSlotTypeForVhecle(vhecle);
		ParkingSlot freeSpot=parkingSlot.get(slotType).poll();
		usedParkingSlot.put(freeSpot.getId(),freeSpot);
		return freeSpot;
	}
	public boolean canPark(SlotType type) {
		return parkingSlot.get(type).size()>0;
	}
	public boolean canPark(Vhecle vhecle) {
		return canPark(getSlotTypeForVhecle(vhecle));
	}
	public ParkingSlot vacateSpot(String spotId) {
		ParkingSlot spot=usedParkingSlot.remove(spotId);
		if(spot!=null) {
			parkingSlot.get(spot.getSlotType()).addFirst(spot);	
			return spot;
		}
		return null;
	}
	
	
	
	
	
	
	
}
