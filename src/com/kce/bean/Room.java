package com.kce.bean;
public class Room {
 private int patient_id;
 private int room_no;
 private String room_type;
 private int room_cost;
public Room(int patient_id, int room_no, String room_type, int room_cost) {
	super();
	this.patient_id = patient_id;
	this.room_no = room_no;
	this.room_type = room_type;
	this.room_cost = room_cost;
}
public int getPatient_id() {
	return patient_id;
}
public void setPatient_id(int patient_id) {
	this.patient_id = patient_id;
}
public int getRoom_no() {
	return room_no;
}
public void setRoom_no(int room_no) {
	this.room_no = room_no;
}
public String getRoom_type() {
	return room_type;
}
public void setRoom_type(String room_type) {
	this.room_type = room_type;
}
public int getRoom_cost() {
	return room_cost;
}
public void setRoom_cost(int room_cost) {
	this.room_cost = room_cost;
}
public String toString() {
	return "Room [patient_id=" + patient_id + ", room_no=" + room_no + ", room_type=" + room_type + ", room_cost="
			+ room_cost + "]";
}
 
}
