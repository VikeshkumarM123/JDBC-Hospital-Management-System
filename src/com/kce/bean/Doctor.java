package com.kce.bean;
public class Doctor {
  private int doctor_id;
  private String doctor_name;
  private int doctor_age;
  private String doctor_specialist;
  private int doctor_Experience;
public Doctor(int doctor_id, String doctor_name, int doctor_age, String doctor_specialist, int doctor_Experience) {
	super();
	this.doctor_id = doctor_id;
	this.doctor_name = doctor_name;
	this.doctor_age = doctor_age;
	this.doctor_specialist = doctor_specialist;
	this.doctor_Experience = doctor_Experience;
}
public int getDoctor_id() {
	return doctor_id;
}
public void setDoctor_id(int doctor_id) {
	this.doctor_id = doctor_id;
}
public String getDoctor_name() {
	return doctor_name;
}
public void setDoctor_name(String doctor_name) {
	this.doctor_name = doctor_name;
}
public int getDoctor_age() {
	return doctor_age;
}
public void setDoctor_age(int doctor_age) {
	this.doctor_age = doctor_age;
}
public String getDoctor_specialist() {
	return doctor_specialist;
}
public void setDoctor_specialist(String doctor_specialist) {
	this.doctor_specialist = doctor_specialist;
}
public int getDoctor_Experience() {
	return doctor_Experience;
}
public void setDoctor_Experience(int doctor_Experience) {
	this.doctor_Experience = doctor_Experience;
}
public String toString() {
	return "Doctor [doctor_id=" + doctor_id + ", doctor_name=" + doctor_name + ", doctor_age=" + doctor_age
			+ ", doctor_specialist=" + doctor_specialist + ", doctor_Experience=" + doctor_Experience + "]";
}
}