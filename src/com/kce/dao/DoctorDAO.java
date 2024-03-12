package com.kce.dao;
import java.sql.*;
import java.util.Scanner;

import com.kce.bean.Doctor;
import com.kce.util.HospitalManagementConnection;
public class DoctorDAO {
	static Connection con=HospitalManagementConnection.DBconnect();
	public static boolean addDoctorDetails(Doctor d)
    {

   	 try {
   		 int count=0;
   		 Statement st=con.createStatement();
   		 ResultSet rs=st.executeQuery("select doctor_id from doctor");
   		 while(rs.next())
   		 {
   			 if(rs.getInt(1)==d.getDoctor_id())
   			 {
   				 count++;
   			 }
   		 }
   		 if(count==0)
   		 {
   		 PreparedStatement ps1=con.prepareStatement("insert into Doctor values(?,?,?,?,?)");
   		 ps1.setInt(1,d.getDoctor_id());
   		 ps1.setString(2,d.getDoctor_name());
   		 ps1.setInt(3,d.getDoctor_age());
   		 ps1.setString(4,d.getDoctor_specialist());
   		 ps1.setInt(5,d.getDoctor_Experience());
   		 ps1.execute();
   		 return true;
   		 }
   		 else
   		 {
   			 return false;
   		 }
   	 }catch(Exception e)
   	 {
   		 System.out.println(e);
   	 }
   	 return false;
    }
	 public static void displayAllDoctorDetails()
     {
    	try {
    		Statement st=con.createStatement();
    		 ResultSet rs=st.executeQuery("select * from Doctor");
    		 while(rs.next())
    		 {
    			 System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getInt(5));
    		 }
    	 }catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
     public static  boolean checkDoctor(int id)
     {
    	 try {
    		 int count=0;
    	 Statement st=con.createStatement();
    	ResultSet rs=st.executeQuery("select * from Doctor");
    	while(rs.next())
    	{
    		if(rs.getInt(1)==id) 
    			{
    			count++;
    			}
    		if(count==0)
    		return true;
    	}
    	 }catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
		return false;
     }
     public static void deleteDoctorDetail()
     {
    	 try {
        	 System.out.println("Enter the Doctor_ID:");
        	 Scanner sc=new Scanner(System.in);
        	 int n=sc.nextInt();
        	 Statement st=con.createStatement();
        	 ResultSet rs=st.executeQuery("select doctor_id from doctor");
        	 int count=0;
        	 while(rs.next())
        	 {
        		 if(rs.getInt(1)==n)
        			 count++;
        	 }
        	 if(count!=0)
        	 {
        		PreparedStatement ps=con.prepareStatement("delete doctor where doctor_id=?");
        		ps.setInt(1,n);
        		ps.execute();
        		System.out.println("Deleted Successfully.");
        	 }
        	 else
        	 {
        		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!---No Data Found To Delete---!!!!!!!!!!!!!!!!!!");
        	 }
    	 }catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
     public static void DisplayOneDetail()
     {
    	 try {
    	 System.out.println("Enter the Doctor_ID:");
    	 Scanner sc=new Scanner(System.in);
    	 int n=sc.nextInt();
    	 Statement st=con.createStatement();
    	 ResultSet rs1=st.executeQuery("select doctor_id from doctor");
    	 int count=0;
    	 while(rs1.next())
    	 {
    		 if(rs1.getInt(1)==n)
    			 count++;
    	 }
    	 if(count!=0)
    	 {
    		 PreparedStatement ps=con.prepareStatement("select * from doctor where doctor_id=?");
 		     ps.setInt(1,n);
    		 ResultSet rs=ps.executeQuery();
    		 System.out.println("Doctor_ID/t/tDoctor_Name/t/tDoctor_Age/t/tDoctor_Specialist/t/tDoctor_Experience");
    		while(rs.next())
    		{
    			System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getInt(5));
    		}
    	 }
    	 else
    	 {
    		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!---No Data Found To Display---!!!!!!!!!!!!!!!!!!");
    	 }
    	 }catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
     public static void displayAllPatientDetails()
     {
    	try {
    		Statement st=con.createStatement();
    		 ResultSet rs=st.executeQuery("select * from doctor");
    		 System.out.println("Doctor_ID/t/tDoctor_Name/t/tDoctor_Age/t/tDoctor_Specialist/t/tDoctor_Experience");
    		 while(rs.next())
    		 {
    			 System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getInt(5));
    		 }
    	 }catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
     public static void UpdateDoctor()
     {
    	 try {
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("Enter the Option For Updating:");
    	 System.out.println("Enter 1 For Updating the Doctor's ID");
    	 System.out.println("Enter 2 For Updating the Doctor's Name");
    	 System.out.println("Enter 3 For Updating the Doctor's Age");
    	 System.out.println("Enter 4 For Updating the Doctor's Specialist");
    	 System.out.println("Enter 5 For Updating the Doctor's Experience");
    	 System.out.println("Enter 6 For Completing the Updates");
    	 int n=sc.nextInt();
    	 sc.nextLine();
    	 while(true) 
    	 {
    	 if(n==1)
    	 {
    	 System.out.println("You Have Entered 1 For Updating the Doctor's ID:");
    	 System.out.println("Enter the New Doctor's IDto Update:");
    	 int a=sc.nextInt();
    	 System.out.println("Enter the Doctor's ID to Update:");
    	 int b=sc.nextInt();
    	 PreparedStatement ps1=con.prepareStatement("Update Doctor set doctor_id=? where doctor_id=?");
   		 ps1.setInt(1,a);
   		 ps1.setInt(2,b);
   		 ps1.execute();
    	 }
    	 else if(n==2)
    	 {
    		 System.out.println("You Have Entered 2 For Updating the Doctor's Name:");
        	 System.out.println("Enter the New Doctor's Name to Update:");
        	 String a=sc.nextLine();
        	 System.out.println("Enter the Doctor's ID to Update:");
        	 int b=sc.nextInt();
        	 PreparedStatement ps1=con.prepareStatement("Update Doctor set doctor_name=? where doctor_id=?");
       		 ps1.setString(1,a);
       		 ps1.setInt(2,b);
       		 ps1.execute(); 
    	 }
    	 else if(n==3)
    	 {
    		 System.out.println("You Have Entered 3 For Updating the Doctor's Age:");
        	 System.out.println("Enter the New Doctor's Age to Update:");
        	 int a=sc.nextInt();
        	 System.out.println("Enter the Doctor's ID to Update:");
        	 int b=sc.nextInt();
        	 PreparedStatement ps1=con.prepareStatement("Update Doctor set doctor_age=? where doctor_id=?");
       		 ps1.setInt(1,a);
       		 ps1.setInt(2,b);
       		 ps1.execute();  
    	 }
    	 else if(n==4)
    	 {
    		 System.out.println("You Have Entered 4 For Updating the Doctor's Specialist:");
        	 System.out.println("Enter the New Doctor's Specialist to Update:");
        	 String a=sc.nextLine();
        	 System.out.println("Enter the Doctor's ID to Update:");
        	 String b=sc.nextLine();
        	 PreparedStatement ps1=con.prepareStatement("Update Doctor set doctor_specialist=? where doctor_id=?");
       		 ps1.setString(1,a);
       		 ps1.setString(2,b);
       		 ps1.execute(); 
    	 }
    	 else if(n==5)
    	 {
    		 System.out.println("You Have Entered 5 For Updating the Patient_ContactNumber:");
        	 System.out.println("Enter the New Doctor's Experience to Update:");
        	 int a=sc.nextInt();
        	 System.out.println("Enter the Doctor's ID to Update:");
        	 int b=sc.nextInt();
        	 PreparedStatement ps1=con.prepareStatement("Update Doctor set doctor_experience=? where doctor_id=?");
       		 ps1.setInt(1,a);
       		 ps1.setInt(2,b);
       		 ps1.execute(); 
    	 }
    	 else if(n==6)
    	 {
    		 System.out.println("All Changes are Saved.");
             break;
    	 }
    	 }
    	 }catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
}
