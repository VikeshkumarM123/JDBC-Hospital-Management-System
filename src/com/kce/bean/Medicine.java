package com.kce.bean;
public class Medicine {
 private int patient_id;
 private String disease;
 private String Health_status;
 private int cost;
public Medicine(int patient_id, String disease, String health_status, int cost) {
	super();
	this.patient_id = patient_id;
	this.disease = disease;
	Health_status = health_status;
	this.cost = cost;
}
public int getPatient_id() {
	return patient_id;
}
public void setPatient_id(int patient_id) {
	this.patient_id = patient_id;
}
public String getDisease() {
	return disease;
}
public void setDisease(String disease) {
	this.disease = disease;
}
public String getHealth_status() {
	return Health_status;
}
public void setHealth_status(String health_status) {
	Health_status = health_status;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
@Override
public String toString() {
	return "Medicine [patient_id=" + patient_id + ", disease=" + disease + ", Health_status=" + Health_status
			+ ", cost=" + cost + "]";
}
 
}
