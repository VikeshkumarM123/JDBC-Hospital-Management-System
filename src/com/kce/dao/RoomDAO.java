package com.kce.dao;
import java.sql.*;
import java.util.Scanner;

import com.kce.bean.Room;
import com.kce.util.HospitalManagementConnection;
public class RoomDAO {
	static Connection con=HospitalManagementConnection.DBconnect();
    public static boolean addRoomDetails(Room a)
    {
   	 try {
   		 int count=0;
   		 Statement st=con.createStatement();
   		 ResultSet rs=st.executeQuery("select patient_id from room");
   		 while(rs.next())
   		 {
   			 if(rs.getInt(1)==a.getPatient_id())
   			 {
   				 count++;
   			 }
   		 }
   		 if(count==0)
   		 {
   		 PreparedStatement ps1=con.prepareStatement("insert into room values(?,?,?,?)");
   		 ps1.setInt(1,a.getPatient_id());
   		 ps1.setInt(2,a.getRoom_no());
   		 ps1.setString(3,a.getRoom_type());
   		 ps1.setInt(4,a.getRoom_cost());
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
    public static  boolean checkRoom(int id)
    {
   	 try {
   		 int count1=0;
   	 Statement st=con.createStatement();
   	ResultSet rs=st.executeQuery("select * from room");
   	while(rs.next())
   	{
   		if(rs.getInt(1)==id) 
   			{
   			count1++;
   			}
   	}
   	if(count1==0)
   		return true;
   	else 
   		return false;
   	 }catch(Exception e)
   	 {
   		 System.out.println(e);
   	 }
		return false;
    }
    public static void displayAllRoomDetails()
    {
   	try {
   		Statement st=con.createStatement();
   		 ResultSet rs=st.executeQuery("select * from room");
   		System.out.println("Patient_ID/t/tRoom_No/t/tRoom_Type/t/tCost");
   		 System.out.println("---------------------------------------------------------------------------------");
   		 while(rs.next())
   		 {
   			 System.out.println(rs.getInt(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt(4));
   		 }
   	 }catch(Exception e)
   	 {
   		 System.out.println(e);
   	 }
    }
    public static void DisplayOneRoomDetail()
    {
   	 try {
   	 System.out.println("Enter the Patient_ID:");
   	 Scanner sc=new Scanner(System.in);
   	 int n=sc.nextInt();
   	 Statement st=con.createStatement();
   	 ResultSet rs1=st.executeQuery("select patient_id from room");
   	 int count=0;
   	 while(rs1.next())
   	 {
   		 if(rs1.getInt(1)==n)
   			 count++;
   	 }
   	 if(count!=0)
   	 {
   		 PreparedStatement ps=con.prepareStatement("select * from room where patient_id=?");
		     ps.setInt(1,n);
   		 ResultSet rs=ps.executeQuery();
   		System.out.println("Patient_ID/t/tRoom_No/t/tRoom_Type/t/tCost");
   		while(rs.next())
   		{
   			System.out.println(rs.getInt(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt(4));
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
    public static void deleteRoomDetails()
    {
   	 try {
       	 System.out.println("Enter the Patient_ID:");
       	 Scanner sc=new Scanner(System.in);
       	 int n=sc.nextInt();
       	 Statement st=con.createStatement();
       	 ResultSet rs=st.executeQuery("select patient_id from room");
       	 int count=0;
       	 while(rs.next())
       	 {
       		 if(rs.getInt(1)==n)
       			 count++;
       	 }
       	 if(count!=0)
       	 {
       		PreparedStatement ps=con.prepareStatement("delete room where patient_id=?");
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
    public static void UpdateRoom()
    {
   	 try {
   	 while(true) {
   	 Scanner sc=new Scanner(System.in);
   	 System.out.println("Enter the Option For Updating:");
   	 System.out.println("Enter 1 For Updating the Patient_ID");
   	 System.out.println("Enter 2 For Updating the Room_No");
   	 System.out.println("Enter 3 For Updating the Room_Type");
   	 System.out.println("Enter 4 For Updating the Cost");
   	 int n=sc.nextInt();
   	 sc.nextLine();
   	 if(n==1)
   	 {
   	 System.out.println("You Have Entered 1 For Updating the Patient_ID:");
   	 System.out.println("Enter the New Patient_ID to Update:");
   	 int a=sc.nextInt();
   	 System.out.println("Enter the Patient_ID to Update:");
   	 int b=sc.nextInt();
   	 PreparedStatement ps1=con.prepareStatement("Update room set patient_id=? where patient_id=?");
  		 ps1.setInt(1,a);
  		 ps1.setInt(2,b);
  		 ps1.execute();
   	 }
   	 else if(n==2)
   	 {
   		 System.out.println("You Have Entered 2 For Updating the Room_No:");
       	 System.out.println("Enter the New Room_No to Update:");
       	 String a=sc.nextLine();
       	 System.out.println("Enter the Patient_ID to Update:");
       	 int b=sc.nextInt();
       	 PreparedStatement ps1=con.prepareStatement("Update room set room_no=? where patient_id=?");
      		 ps1.setString(1,a);
      		 ps1.setInt(2,b);
      		 ps1.execute(); 
   	 }
   	 else if(n==3)
   	 {
   		 System.out.println("You Have Entered 3 For Updating the Room_Type:");
       	 System.out.println("Enter the New Room_Type to Update:");
       	 int a=sc.nextInt();
       	 System.out.println("Enter the Patient_ID to Update:");
       	 int b=sc.nextInt();
       	 PreparedStatement ps1=con.prepareStatement("Update room set room_type=? where patient_id=?");
      		 ps1.setInt(1,a);
      		 ps1.setInt(2,b);
      		 ps1.execute();  
   	 }
   	 else if(n==4)
   	 {
   		 System.out.println("You Have Entered 4 For Updating the Cost:");
       	 System.out.println("Enter the New Cost to Update:");
       	 String a=sc.nextLine();
       	 System.out.println("Enter the Patient_ID to Update:");
       	 int b=sc.nextInt();
       	 PreparedStatement ps1=con.prepareStatement("Update room set Cost=? where patient_id=?");
      		 ps1.setString(1,a);
      		 ps1.setInt(2,b);
      		 ps1.execute(); 
   	 }
   	 else if(n==5)
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