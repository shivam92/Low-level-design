package com.parkinglot.model.account;

public class Contact {

	 private String phone;
	    private String email;
	    private Address address;
	    private PersonalInfo personalInfo;
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public PersonalInfo getPersonalInfo() {
			return personalInfo;
		}
		public void setPersonalInfo(PersonalInfo personalInfo) {
			this.personalInfo = personalInfo;
		}
	    
}
