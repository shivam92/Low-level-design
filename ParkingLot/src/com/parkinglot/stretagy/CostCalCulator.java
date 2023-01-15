package com.parkinglot.stretagy;

import com.parkinglot.model.parkingslot.SlotType;

public interface CostCalCulator {
	public double getCost(SlotType parkingSpotType);
}
