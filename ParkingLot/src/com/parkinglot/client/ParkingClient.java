package com.parkinglot.client;

import com.parkinglot.adapter.NetBanking;
import com.parkinglot.adapter.PaymentAdapter;
import com.parkinglot.model.account.Account;
import com.parkinglot.model.account.Address;
import com.parkinglot.model.account.Admin;
import com.parkinglot.model.parkinglot.EntryGate;
import com.parkinglot.model.parkinglot.ExitGate;
import com.parkinglot.model.parkinglot.Floor;
import com.parkinglot.model.parkinglot.ParkingLot;
import com.parkinglot.model.parkingslot.MediumParkingSlot;
import com.parkinglot.model.parkingslot.ParkingSlot;
import com.parkinglot.model.parkingslot.SlotType;
import com.parkinglot.model.parkingslot.SmallParkingSlot;
import com.parkinglot.model.payment.Payment;
import com.parkinglot.model.ticket.Ticket;
import com.parkinglot.model.vhecle.MediumVhecle;
import com.parkinglot.model.vhecle.SmallVhecle;
import com.parkinglot.model.vhecle.Vhecle;
import com.parkinglot.model.vhecle.VhecleType;
import com.parkinglot.stretagy.CostCalCulator;
import com.parkinglot.stretagy.HourlyCostCalculate;

public class ParkingClient {
public static void main(String[] args) throws Exception {
	 ParkingLot parkingLot = ParkingLot.INSTANCE;

     Address address = new Address();
     address.setAddressLine1("Ram parking Complex");
     address.setStreet("BG Road");
     address.setCity("Bangalore");
     address.setState("Karnataka");
     address.setCountry("India");
     address.setPinCode("560075");

     parkingLot.setAddress(address);
     //Admin tests
     Account adminAccount = new Admin();
     //Admin Case 1 - should be able to add parking floor case
     ((Admin) adminAccount).addParkingFloor(new Floor("1"));
     //Admin Case 2 - should be able to add parking floor case
     ((Admin) adminAccount).addParkingFloor(new Floor("2"));

     //Admin Case 3 - should be able to add entrance panel
     EntryGate entrancePanel = new EntryGate();
     entrancePanel.setId("1");;
     ((Admin) adminAccount).addEntryGate(entrancePanel);

     //Admin Case 4 - should be able to add exit panel
     CostCalCulator costCalCulator=new HourlyCostCalculate();
     ExitGate exitPanel = new ExitGate(costCalCulator);
     exitPanel.setId("1");
     ((Admin) adminAccount).addExitGate(exitPanel);

     String floorId = parkingLot.getFloors().get(0).getId();

     ///Admin case 5 - should be able to add car parking spot
     ParkingSlot carSpot1 = new ParkingSlot("c1",SlotType.MEDIUM);
     ((Admin) adminAccount).addParkingSlot(floorId, carSpot1);
     ///Admin case 6 - should be able to add bike parking spot
     ParkingSlot bikeSport = new SmallParkingSlot("b1",SlotType.SMALL);
     ((Admin) adminAccount).addParkingSlot(floorId, bikeSport);
     ParkingSlot bikeSport1 = new SmallParkingSlot("b2",SlotType.SMALL);
     ((Admin) adminAccount).addParkingSlot(floorId, bikeSport1);
     ///Admin case 7 - should be able to add car parking spot
     ParkingSlot carSpot2 = new MediumParkingSlot("c2",SlotType.MEDIUM);
     ((Admin) adminAccount).addParkingSlot(floorId, carSpot2);

     // Test case 1 - check for availability of parking lot - TRUE
     Vhecle medium=new Vhecle(null, VhecleType.MEDIUM);
     System.out.print("MEDIUM CAN PARK: ");
     System.out.println(ParkingLot.INSTANCE.canPark(medium));

     // Test case 2 - check for availability of parking lot - FALSE
     System.out.print("SMALL CAN PARK: ");
     Vhecle small=new Vhecle(null, VhecleType.SMALL);
     System.out.println(ParkingLot.INSTANCE.canPark(small));

     // Test case 3 - check for availability of parking lot - FALSE
     System.out.print("eLECTRIC CAN PARK: ");
     Vhecle elect=new Vhecle(null, VhecleType.ELECTRIC);
     System.out.println(ParkingLot.INSTANCE.canPark(elect));

     // TEST case 4 - Check if full
     System.out.println(ParkingLot.INSTANCE.isFull());

     // Test case 5 - get parking spot
     Vhecle vehicle = new MediumVhecle("KA05MR2311",VhecleType.MEDIUM);
     ParkingSlot availableSpot = ParkingLot.INSTANCE.getParkingSpot(vehicle);
     System.out.println(availableSpot.getSlotType());
     System.out.println(availableSpot.getId());

     // Test case 6 - should not be able to get spot
     Vhecle van = new SmallVhecle("KA01MR7804",VhecleType.SMALL);
     ParkingSlot vanSpot = ParkingLot.INSTANCE.getParkingSpot(van);
     System.out.println(null == vanSpot);

     //Test case 7 - Entrance Panel - 1
     System.out.println(ParkingLot.INSTANCE.getEntryGate().size());

     // Test case - 8 - Should be able to get parking ticket
     Ticket parkingTicket = entrancePanel.generateToken(vehicle);
     System.out.println(parkingTicket.getParkinglot().getId());

     ((Admin) adminAccount).addParkingSlot(floorId, carSpot1);
     // Test case - 9 - Should be able to get parking ticket
     Vhecle car = new MediumVhecle("KA02MR6355",VhecleType.MEDIUM);
     Ticket parkingTicket1 = entrancePanel.generateToken(car);

     // Test case 10 - Should not be able to get ticket
     Ticket tkt = entrancePanel.generateToken(new MediumVhecle("ka04rb8458",VhecleType.MEDIUM));
     System.out.println(null == tkt);

     // Test case 11 - Should be able to get ticket
     Ticket mtrTkt = entrancePanel.generateToken(new SmallVhecle("ka01ee4901",VhecleType.SMALL));
     System.out.println(mtrTkt.getParkingSlot().getId());

     //Test case 12 - vacate parking spot
     mtrTkt = exitPanel.scanAndVacat(mtrTkt);
     System.out.println(mtrTkt.getCharge());
     System.out.println(mtrTkt.getCharge() > 0);

     // Test case 13 - park on vacated spot
     Ticket mtrTkt1 = entrancePanel.generateToken(new SmallVhecle("ka01ee7791",VhecleType.SMALL));
     System.out.println(mtrTkt.getParkingSlot().getId());

     // Test case 14 - park when spot is not available
     Ticket unavaialbemTkt =
             entrancePanel.generateToken(new SmallVhecle("ka01ee4455",VhecleType.SMALL));
     System.out.println(null == unavaialbemTkt);

     // Test cast 15 - vacate car
     parkingTicket = exitPanel.scanAndVacat(parkingTicket);
     System.out.println(parkingTicket.getCharge());
     System.out.println(parkingTicket.getCharge() > 0);

     //Test case 16 - Now should be able to park car
     Vhecle medium1=new Vhecle(null, VhecleType.MEDIUM);
     System.out.println(ParkingLot.INSTANCE.canPark(medium1));

     //Test case 17 - Should be able to vacate parked vehicle
     parkingTicket1 = exitPanel.scanAndVacat(parkingTicket1);
     System.out.println(parkingTicket1.getCharge());
     System.out.println(parkingTicket1.getCharge() > 0);

     //Test case 18 - check for slots count
     System.out.println(ParkingLot.INSTANCE.getFloors()
             .get(0).getParkingSlot().  get(SlotType.MEDIUM).size());

     //Test case 19 - Payment
     PaymentAdapter PaymentAdapter=new NetBanking();
     Payment payment = new Payment(PaymentAdapter);
     payment.makePayment(parkingTicket1);
     System.out.println(payment.getPaymentStatus());

     //Test case 20 - vacate motorbike spot
     mtrTkt = exitPanel.scanAndVacat(mtrTkt);
     System.out.println(ParkingLot.INSTANCE.getFloors()
             .get(0).getParkingSlot().get(SlotType.SMALL).size());
     System.out.println(mtrTkt.getCharge());
}
}
