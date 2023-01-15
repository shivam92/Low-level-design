package com.parkinglot.model.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.parkinglot.model.account.Address;
import com.parkinglot.model.parkingslot.ParkingSlot;
import com.parkinglot.model.vhecle.Vhecle;
import com.parkinglot.model.vhecle.VheclePrice;
import com.parkinglot.model.vhecle.VhecleType;

public class ParkingLot extends Base {
	private Address address;
	private List<Floor> floors;
	private Map<VhecleType,VheclePrice>VhecleTypePrice;
	List<EntryGate>entryGate;
	List<ExitGate>exitGate;
	public static ParkingLot INSTANCE = new ParkingLot();
	
	public ParkingLot(){
		this.setId( UUID.randomUUID().toString());
		entryGate=new ArrayList<EntryGate>();
		exitGate=new ArrayList<ExitGate>();
		floors=new ArrayList<Floor>();
	}
	
	public boolean isFull() {
		boolean flag=true;
		for(Floor floor:floors) {
			if(!floor.isFloorFull())flag=false;
		}
		return flag;
		
	}
	
	public boolean canPark(Vhecle vhecle) {
		for(Floor floor:floors) {
			if(floor.canPark(vhecle))return true;
		}
		return false;
	}
	
	public ParkingSlot getParkingSpot(Vhecle vhecle) {
		for(Floor floor:floors) {
			ParkingSlot slot=floor.getSpot(vhecle);
			if(slot!=null)return slot;
		}
		return null;
	}
	
	
	public ParkingSlot  vacateSpot(String id) {
		for(Floor floor:floors) {
			ParkingSlot slot=floor.vacateSpot(id);
			if(slot!=null)return slot;
		}
		return null;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Floor> getFloors() {
		return floors;
	}
	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}
	public Map<VhecleType, VheclePrice> getVhecleTypePrice() {
		return VhecleTypePrice;
	}
	public void setVhecleTypePrice(Map<VhecleType, VheclePrice> vhecleTypePrice) {
		VhecleTypePrice = vhecleTypePrice;
	}
	public List<EntryGate> getEntryGate() {
		return entryGate;
	}
	public void setEntryGate(List<EntryGate> entryGate) {
		this.entryGate = entryGate;
	}
	public List<ExitGate> getExitGate() {
		return exitGate;
	}
	public void setExitGate(List<ExitGate> exitGate) {
		this.exitGate = exitGate;
	}
	
	

}
