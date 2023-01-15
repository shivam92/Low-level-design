package com.parkinglot.model.parkinglot;

public class Gate extends Base{

	private int number;
	private GateType gateType;
	private GateStatus gateStatus;
	private Operator operator;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public GateType getGateType() {
		return gateType;
	}
	public void setGateType(GateType gateType) {
		this.gateType = gateType;
	}
	public GateStatus getGateStatus() {
		return gateStatus;
	}
	public void setGateStatus(GateStatus gateStatus) {
		this.gateStatus = gateStatus;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
}
