package com.parkinglot.model.vhecle;

import com.parkinglot.model.parkinglot.Base;

public class Vhecle extends Base{
private String number;
private VhecleType vhecleType;
public Vhecle(String licienceNumver,VhecleType type) {
	this.number=number;
	this.vhecleType=type;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public VhecleType getVhecleType() {
	return vhecleType;
}
public void setVhecleType(VhecleType vhecleType) {
	this.vhecleType = vhecleType;
}
}
