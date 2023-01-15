package com.parkinglot.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.parkinglot.model.parkinglot.EntryGate;
import com.parkinglot.model.parkinglot.ExitGate;
import com.parkinglot.model.parkinglot.Floor;
import com.parkinglot.model.parkinglot.ParkingLot;
import com.parkinglot.model.parkingslot.ParkingSlot;

public class ParkingLotRepository {

	 public static Map<String, ParkingLot> parkingLotMap = new HashMap<>();
	    public static List<ParkingLot> parkingLots = new ArrayList<>();
	    
	    
	    public ParkingLot addParkingLot(ParkingLot parkingLot) {
	    	parkingLotMap.putIfAbsent(parkingLot.getId(), parkingLot);
	    	return parkingLot;
	    }
	    public ParkingLot getParkingLot(String parkingId) {
	    return 	parkingLotMap.get(parkingId);
	    	//return parkingLot;
	    }
	    public Floor addParkingFloor(String parkingLotId, Floor parkingFloor) throws Exception {
	    	ParkingLot parkingLot=parkingLotMap.get(parkingLotId);
	    	if (parkingLot == null)
	            throw new Exception("Invalid parking lot");
	    	Optional<Floor> floor=parkingLot.getFloors().stream().filter(pf->pf.getId().equalsIgnoreCase(parkingFloor.getId())).findFirst();
	    	if(floor.isPresent())floor.get();
	    	parkingLot.getFloors().add(parkingFloor);
	    	return parkingFloor;
	    }
	    public ParkingSlot addParkingSlot(String parkingLotId,String parkingFloorId, ParkingSlot spot) throws Exception { 
	    	ParkingLot parkingLot=parkingLotMap.get(parkingLotId);
	    	if (parkingLot == null)
	            throw new Exception("Invalid parking lot");
	    	Optional<Floor> floor=parkingLot.getFloors().stream().filter(pf->pf.getId().equalsIgnoreCase(parkingFloorId)).findFirst();
	    	if(!floor.isPresent())throw new Exception("Invalid parking Floor");
	    	Optional<ParkingSlot> parkingSpot=floor.get().getParkingSlot().get(spot.getSlotType()).stream()
	    			.filter(pf->pf.getId().equalsIgnoreCase(spot.getId())).findFirst();
	    	if(parkingSpot.isPresent())return parkingSpot.get();
	    	floor.get().getParkingSlot().get(spot.getSlotType()).add(spot);
	    	return spot;
	    }
	    public EntryGate addEntryGate(String parkingLotId,EntryGate entryGate) throws Exception {
	    	ParkingLot parkingLot=parkingLotMap.get(parkingLotId);
	    	if (parkingLot == null)
	            throw new Exception("Invalid parking lot");
	    	Optional<EntryGate> entryGateOpt=parkingLot.getEntryGate().stream().filter(pf->pf.getId().equalsIgnoreCase(entryGate.getId())).findFirst();
	    	if(entryGateOpt.isPresent())return entryGateOpt.get();
	    	parkingLot.getEntryGate().add(entryGate);
	    	return entryGate;
	    	
	    }
	    public ExitGate addEXitGate(String parkingLotId,ExitGate exitGate) throws Exception {
	    	ParkingLot parkingLot=parkingLotMap.get(parkingLotId);
	    	if (parkingLot == null)
	            throw new Exception("Invalid parking lot");
	    	Optional<ExitGate> exitGateOpt=parkingLot.getExitGate().stream().filter(pf->pf.getId().equalsIgnoreCase(exitGate.getId())).findFirst();
	    	if(exitGateOpt.isPresent())return exitGateOpt.get();
	    	parkingLot.getExitGate().add(exitGate);
	    	return exitGate;
	    	
	    }
}
