package com.parkinglot.stretagy;

import java.util.HashMap;
import java.util.Map;

import com.parkinglot.model.parkingslot.SlotType;

public class HourlyCostCalculate implements CostCalCulator {
	 private Map<SlotType, Double> hourlyCosts = new HashMap<>();

	    public HourlyCostCalculate() {
	        hourlyCosts.put(SlotType.MEDIUM, 20.0);
	        hourlyCosts.put(SlotType.LARGE, 30.0);
	        hourlyCosts.put(SlotType.ELECTRIC, 25.0);
	       // hourlyCosts.put(SlotType.MOTORBIKE, 10.0);
	        hourlyCosts.put(SlotType.SMALL, 25.0);
	    }
	    public double getCost(SlotType parkingSpotType) {
	        return hourlyCosts.get(parkingSpotType);
	    }
}
