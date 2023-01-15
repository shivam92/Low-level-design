package com.parkinglot.model.account;

import java.util.Optional;

import com.parkinglot.model.parkinglot.EntryGate;
import com.parkinglot.model.parkinglot.ExitGate;
import com.parkinglot.model.parkinglot.Floor;
import com.parkinglot.model.parkinglot.ParkingLot;
import com.parkinglot.model.parkingslot.ParkingSlot;

public class Admin extends Account{

	
	public void addParkingFloor(Floor floor) {
		Optional<Floor>parkingFloor=ParkingLot.INSTANCE.getFloors().stream().filter(pf->pf.getId().equalsIgnoreCase(floor.getId())).findFirst();
		if(parkingFloor.isPresent())return;
		ParkingLot.INSTANCE.getFloors().add(floor);
		
	}
	public void addParkingSlot(String floorId,ParkingSlot spot) throws Exception {
		Optional<Floor>parkingFloor=ParkingLot.INSTANCE.getFloors().stream().filter(pf->pf.getId().equalsIgnoreCase(floorId)).findFirst();	
	   if(!parkingFloor.isPresent())throw new Exception("Parking floor is not available");
	   
	   Optional<ParkingSlot>parkingspot=parkingFloor.get().getParkingSlot().get(spot.getSlotType()).stream().
			   filter(pf->pf.getId().equalsIgnoreCase(spot.getId())).findFirst();
	   if(parkingspot.isPresent())return;
	   parkingFloor.get().getParkingSlot().get(spot.getSlotType()).add(spot);
	   
			   
	}
	public void addEntryGate(EntryGate gate) {
		Optional<EntryGate>entryGate=ParkingLot.INSTANCE.getEntryGate().stream().filter(pf->pf.getId().equalsIgnoreCase(gate.getId())).findFirst();
		if(entryGate.isPresent())return;
		ParkingLot.INSTANCE.getEntryGate().add(gate);
	}
	public void addExitGate(ExitGate gate) {
		Optional<ExitGate>entryGate=ParkingLot.INSTANCE.getExitGate().stream().filter(pf->pf.getId().equalsIgnoreCase(gate.getId())).findFirst();
		if(entryGate.isPresent())return;
		ParkingLot.INSTANCE.getExitGate().add(gate);
	}
}
