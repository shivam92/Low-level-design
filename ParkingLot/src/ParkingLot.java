import java.util.Date;
import java.util.List;
import java.util.Map;


public class ParkingLot {
	
	List<ParkingFloor> parkingFloors;
	List<Entrance> entrances;
	List<Exit> exits;

	Address address; 

	String parkingLotName;

	public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle){
		return false;}
	public boolean updateParkingAttndant(ParkingAttendant parkingAttendant, int gateId){
		return false;}

}

class ParkingFloor {
	
	int levelId;
	List<ParkingSpace> parkingSpaces;

	ParkingDisplayBoard parkingDisplayBoard;

}

class Gate {

	int gateId;
	ParkingAttendant parkingAttendant;

}

class Entrance extends Gate {

	public ParkingTicket getParkingTicket(Vehicle vehicle){
		return null;
		}

}

class Exit extends Gate {

	public ParkingTicket payForParking(ParkingTicket parkingTicket, PaymentType paymentType){
		return parkingTicket;
		}

}


class Address {

	String country;
	String state;
	String city;
	String street;
	String pinCode; //ZipCode
}

class ParkingSpace {
	
	int spaceId;
	boolean isFree;
	double costPerHour;
	Vehicle vehicle;
	ParkingSpaceType parkingSpaceType;

}

class ParkingDisplayBoard {

	Map<ParkingSpaceType, Integer> freeSpotsAvailableMap;

	public void updateFreeSpotsAvailable(ParkingSpaceType parkingSpaceType, int spaces){}

}


class Account {

	String name;
	String email;
	String password;
	String empId;
	Address address;

}

class Admin extends Account {

	public boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor floor){
		return false;}
	public boolean addParkingSpace(ParkingFloor floor, ParkingSpace parkingSpace){
		return false;}
	public boolean addParkingDisplayBoard(ParkingFloor floor, ParkingDisplayBoard parkingDisplayBoard){
		return false;}
	

}

class ParkingAttendant extends Account {

	Payment paymentService;

	public boolean processVehicleEntry(Vehicle vehicle){
		return false;}
	public PaymentInfo processPayment(ParkingTicket parkingTicket, PaymentType paymentType){
		return null;}

}

class Vehicle {
	
	String licenseNumber;
	VehicleType vehicleType;
	ParkingTicket parkingTicket;
	PaymentInfo paymentInfo;

}

class ParkingTicket {
	
	int ticketId;
	int levelId;
	int spaceId;
	Date vehicleEntryDateTime;
	Date vehicleExitDateTime;
	ParkingSpaceType parkingSpaceType;
	double totalCost;
	ParkingTicketStatus parkingTicketStatus;

	public void updateTotalCost(){}
	public void updateVehicleExitTime(Date vehicleExitDateTime){}

} 

 enum PaymentType {

	CASH, CEDIT_CARD, DEBIT_CARD, UPI;
}

 enum ParkingSpaceType {
	
	BIKE_PARKING, CAR_PARKING, TRUCK_PARKING

}

class Payment {

	public PaymentInfo makePayment(ParkingTicket parkingTicket, PaymentType paymentType){
		return null;
		}
}

 class PaymentInfo {

	double amount;
	Date paymentDate;
	int transactionId;
	ParkingTicket parkingTicket;
	PaymentStatus paymentStatus;

}

 enum VehicleType {
	
	BIKE, CAR, TRUCK;
}

 enum ParkingTicketStatus {
	
	PAID, ACTIVE;
}

 enum PaymentStatus {

	UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;

}
