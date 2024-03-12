package com.kce.service;
import java.util.*;
import com.kce.bean.Doctor;
import com.kce.bean.Medicine;
import com.kce.bean.Patient;
import com.kce.bean.Room;
import com.kce.dao.DoctorDAO;
import com.kce.dao.MedicineDAO;
import com.kce.dao.PatientDAO;
import com.kce.dao.RoomDAO;
public class Hospital {
	public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("***********************************Welcome to Hospital Management System*************************************");
	  while(true) 
	  {
		  System.out.println("Enter 1 For Knowing the Patient's Details");
		  System.out.println("Enter 2 For Knowing the Doctor's Details");
		  System.out.println("Enter 3 For Knowing the Medicine's Details");
		  System.out.println("Enter 4 For Knowing the Room's Details");
		  System.out.println("Enter 5 For Exiting Application");
		  int n=sc.nextInt();
		  if(n==1)
		  {
			  while(true)
			  {
			  System.out.println("Enter 1 For Adding the Patient's Details:");
			  System.out.println("Enter 2 For Display All the Patient's Details:");
			  System.out.println("Enter 3 For Updating the Patient's Details:");
			  System.out.println("Enter 4 For Deleting the Patient's Details:");
			  System.out.println("Enter 5 For Displaying One Patient's Details:");
			  System.out.println("Enter 6 For Exiting From Patient's Details");
			  int s=sc.nextInt();
			  if(s==1) 
			  {
			  System.out.println("---------------------------------------------------------------------------------");
			  System.out.println("***************************Adding the Patient's Details************************************");
			  System.out.println("Enter the Patient's ID:");
			  int a=sc.nextInt();
			  sc.nextLine();
			  if(PatientDAO.checkPatient(a))
			  {
			  System.out.println("Enter the Patient's Name:");
			  String b=sc.nextLine();
			  System.out.println("Enter the Patient's Age:");
			  int c=sc.nextInt();
			  sc.nextLine();
			  System.out.println("Enter the Patient's Address:");
			  String d=sc.nextLine();
			  System.out.println("Enter the Patient's ContactNumber:");
			  String e=sc.nextLine();
			  Patient p=new Patient(a,b,c,d,e);
			  if(PatientDAO.addPatientDetails(p))
			  {
				  System.out.println("Patient Details are Entered Successfully");
			  }
			 }
			  else
			  {
				  System.out.println("!!!!!!!!!!!!Patient's Details Already Existed!!!!!!!!!!!!!!!");
			  }
			  System.out.println("---------------------------------------------------------------------------------");
			  }
			  else if(s==2)
			  {
				  System.out.println("---------------------------------------------------------------------------------");
            	  PatientDAO.displayAllPatientDetails();
			  }
			  else if(s==3)
			  {
				 System.out.println("---------------------------------------------------------------------------------");
				 PatientDAO.UpdatePatient();
				 System.out.println("---------------------------------------------------------------------------------");
			  }
			  else if(s==4)
			  {
				  System.out.println("---------------------------------------------------------------------------------");
				  PatientDAO.deletePatient();
				  System.out.println("---------------------------------------------------------------------------------");
			  }
			  else if(s==5)
			  {
				  System.out.println("---------------------------------------------------------------------------------");
				  PatientDAO.DisplayOneDetail();
				  System.out.println("---------------------------------------------------------------------------------");
			  }
			  else if(s==6)
			  {
				  System.out.println("All Changes are Saved.\nExited From Patient Table");
				  break;
			  }
		  }
		}
		  if(n==2)
		  {
			  while(true)
			  {
			  System.out.println("Enter 1 For Adding the Doctor's Details:");
			  System.out.println("Enter 2 For Display All the Doctor's Details:");
			  System.out.println("Enter 3 For Updating the Doctor's Details:");
			  System.out.println("Enter 4 For Deleting the Doctor's Details:");
			  System.out.println("Enter 5 For Displaying One Doctor's Details:");
			  System.out.println("Enter 6 For Exiting From Doctor's Details");
			  int s=sc.nextInt();
			  if(s==1) 
			  {
		      System.out.println("******************Adding the Doctor's Details***********************************");
			  System.out.println("Enter the Doctor_ID:");
			  int a1=sc.nextInt();
			  sc.nextLine();
			  if(DoctorDAO.checkDoctor(a1))
			  {
			  System.out.println("Enter the Doctor_Name:");
			  String b2=sc.nextLine();
			  System.out.println("Enter the Doctor_Age:");
			  int c2=sc.nextInt();
			  sc.nextLine();
			  System.out.println("Enter the Doctor_Specialist:");
			  String d2=sc.nextLine();
			  System.out.println("Enter the Doctor_Experience:");
			  int e2=sc.nextInt();
			  Doctor d3=new Doctor(a1,b2,c2,d2,e2);
			  if(DoctorDAO.addDoctorDetails(d3))
			  {
				  System.out.println("Doctor's are Entered Successfully");
			  }
			  }
			  else
			  {
				  System.out.println("Doctor's details are Already Existed");
			  }
			  }
			  else if(s==2)
			  {
            	  DoctorDAO.displayAllDoctorDetails();
            	  System.out.println("---------------------------------------------------------------------------------");
			  }
			  else if(s==3)
			  {
				 DoctorDAO.UpdateDoctor(); 
			  }
			  else if(s==4)
			  {
				  DoctorDAO.deleteDoctorDetail();
			  }
			  else if(s==5)
			  {
				  DoctorDAO.DisplayOneDetail();
			  }
			  else if(s==6)
			  {
				  System.out.println("All Changes are Saved.\nExited From Doctor Table");
				  break;
			  }
		      }
			  }
	         if(n==3)
			  {
	        	 while(true)
				  {
				  System.out.println("Enter 1 For Adding the Medicine Details:");
				  System.out.println("Enter 2 For Display All the Medicine Details:");
				  System.out.println("Enter 3 For Updating the Medicine Details:");
				  System.out.println("Enter 4 For Deleting the Medicine Details:");
				  System.out.println("Enter 5 For Displaying One Medicine Details:");
				  System.out.println("Enter 6 For Exiting From Medicine Details");
				  int s=sc.nextInt();
				  if(s==1) 
				  {
			      System.out.println("******************Adding the Medicine Details***********************************");
				  System.out.println("Enter the Patient_ID:");
				  int a1=sc.nextInt();
				  sc.nextLine();
				  if(MedicineDAO.checkMedicine(a1))
				  {
				  System.out.println("Enter the Disease:");
				  String b2=sc.nextLine();
				  System.out.println("Enter the Health_Status:");
				  String c2=sc.nextLine();
				  System.out.println("Enter the Cost:");
				  int d2=sc.nextInt();
				  sc.nextLine();
				  Medicine m3=new Medicine(a1,b2,c2,d2);
				  if(MedicineDAO.addMedicineDetails(m3))
				  {
					  System.out.println("Medicine Details are Entered Successfully");
				  }
				  }
				  else
				  {
					  System.out.println("Medicine details are Already Existed");
				  }
				  }
				  else if(s==2)
				  {
	            	  MedicineDAO.displayAllMedicineDetails();
	            	  System.out.println("---------------------------------------------------------------------------------");
				  }
				  else if(s==3)
				  {
					 MedicineDAO.UpdateMedicine();; 
				  }
				  else if(s==4)
				  {
					  MedicineDAO.deleteMedicineDetails();;
				  }
				  else if(s==5)
				  {
					  MedicineDAO.DisplayOneMedicineDetail();;
				  }
				  else if(s==6)
				  {
					  System.out.println("All Changes are Saved.\nExited From Medicine Table");
					  break;
				  }
			      }
			  }
	         if(n==4)
	         {
	        	 while(true)
				  {
				  System.out.println("Enter 1 For Adding the Room Details:");
				  System.out.println("Enter 2 For Display All the Room Details:");
				  System.out.println("Enter 3 For Updating the Room Details:");
				  System.out.println("Enter 4 For Deleting the Room Details:");
				  System.out.println("Enter 5 For Displaying One Room Detail:");
				  System.out.println("Enter 6 For Exiting From Room Details");
				  int s=sc.nextInt();
				  if(s==1) 
				  {
			      System.out.println("******************Adding the Room Details***********************************");
				  System.out.println("Enter the Patient_ID:");
				  int a1=sc.nextInt();
				  if(RoomDAO.checkRoom(a1))
				  {
				  System.out.println("Enter the Room_No:");
				  int b2=sc.nextInt();
				  sc.nextLine();
				  System.out.println("Enter the Room_Type:");
				  String c2=sc.nextLine();
				  System.out.println("Enter the Cost:");
				  int d2=sc.nextInt();
				  Room m3=new Room(a1,b2,c2,d2);
				  if(RoomDAO.addRoomDetails(m3))
				  {
					  System.out.println("Room Details are Entered Successfully");
				  }
				  }
				  else
				  {
					  System.out.println("Room details are Already Existed");
				  }
				  }
				  else if(s==2)
				  {
	            	  RoomDAO.displayAllRoomDetails();
	            	  System.out.println("---------------------------------------------------------------------------------");
				  }
				  else if(s==3)
				  {
					 RoomDAO.UpdateRoom();; 
				  }
				  else if(s==4)
				  {
					  RoomDAO.deleteRoomDetails();;
				  }
				  else if(s==5)
				  {
					  RoomDAO.DisplayOneRoomDetail();;
				  }
				  else if(s==6)
				  {
					  System.out.println("All Changes are Saved.\nExited From Room Table");
					  break;
				  }
			      }
	         }
		  }//while Loop
	  }
	}