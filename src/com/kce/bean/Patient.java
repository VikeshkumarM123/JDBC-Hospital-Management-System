package com.kce.bean;
public class Patient {
     private int patient_id;
     private String patient_name;
     private int patient_age;
     private String patient_address;
     private String patient_Contactnumber;
	public Patient(int patient_id, String patient_name, int patient_age, String patient_address,
			String patient_Contactnumber) {
		super();
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.patient_age = patient_age;
		this.patient_address = patient_address;
		this.patient_Contactnumber = patient_Contactnumber;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public int getPatient_age() {
		return patient_age;
	}
	public void setPatient_age(int patient_age) {
		this.patient_age = patient_age;
	}
	public String getPatient_address() {
		return patient_address;
	}
	public void setPatient_address(String patient_address) {
		this.patient_address = patient_address;
	}
	public String getPatient_Contactnumber() {
		return patient_Contactnumber;
	}
	public void setPatient_Contactnumber(String patient_Contactnumber) {
		this.patient_Contactnumber = patient_Contactnumber;
	}
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", patient_name=" + patient_name + ", patient_age=" + patient_age
				+ ", patient_address=" + patient_address + ", patient_Contactnumber=" + patient_Contactnumber + "]";
	}
}