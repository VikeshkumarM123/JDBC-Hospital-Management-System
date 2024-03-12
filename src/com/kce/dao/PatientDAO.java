package com.kce.dao;
import java.sql.*;
import java.util.*;
import com.kce.bean.Patient;
import com.kce.util.HospitalManagementConnection;
public class PatientDAO {
	static Connection con=HospitalManagementConnection.DBconnect();
     public static boolean addPatientDetails(Patient a)
     {
    	 try {
    		 int count=0;
    		 Statement st=con.createStatement();
    		 ResultSet rs=st.executeQuery("select patient_id from patient");
    		 while(rs.next())
    		 {
    			 if(rs.getInt(1)==a.getPatient_id())
    			 {
    				 count++;
    			 }
    		 }
    		 if(count==0)
    		 {
    		 PreparedStatement ps1=con.prepareStatement("insert into Patient values(?,?,?,?,?)");
    		 ps1.setInt(1,a.getPatient_id());
    		 ps1.setString(2,a.getPatient_name());
    		 ps1.setInt(3,a.getPatient_age());
    		 ps1.setString(4,a.getPatient_address());
    		 ps1.setString(5,a.getPatient_Contactnumber());
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
     public static  boolean checkPatient(int id)
     {
    	 try {
    		 int count1=0;
    	 Statement st=con.createStatement();
    	ResultSet rs=st.executeQuery("select * from patient");
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
     public static void displayAllPatientDetails()
     {
    	try {
    		Statement st=con.createStatement();
    		 ResultSet rs=st.executeQuery("select * from patient");
    		 System.out.println("Patient_ID       Patient_Name      Patient_Age      Patient_Address      Patient_ContactNumber");
    		 System.out.println("---------------------------------------------------------------------------------");
    		 while(rs.next())
    		 {
    			 System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5));
    		 }
    		 System.out.println("---------------------------------------------------------------------------------");
    	 }catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
     public static void DisplayOneDetail()
     {
    	 try {
    	 System.out.println("Enter the Patient_ID:");
    	 Scanner sc=new Scanner(System.in);
    	 int n=sc.nextInt();
    	 Statement st=con.createStatement();
    	 ResultSet rs1=st.executeQuery("select patient_id from patient");
    	 int count=0;
    	 while(rs1.next())
    	 {
    		 if(rs1.getInt(1)==n)
    			 count++;
    	 }
    	 if(count!=0)
    	 {
    		 PreparedStatement ps=con.prepareStatement("select * from patient where patient_id=?");
 		     ps.setInt(1,n);
    		 ResultSet rs=ps.executeQuery();
    		 System.out.println("Patient_ID       Patient_Name      Patient_Age      Patient_Address      Patient_ContactNumber");
    		 System.out.println("---------------------------------------------------------------------------------");
    		 while(rs.next())
    		{
    			System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5));
    		}
    		 System.out.println("---------------------------------------------------------------------------------");
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
     public static void deletePatient()
     {
    	 try {
        	 System.out.println("Enter the Patient_ID:");
        	 Scanner sc=new Scanner(System.in);
        	 int n=sc.nextInt();
        	 Statement st=con.createStatement();
        	 ResultSet rs=st.executeQuery("select patient_id from patient");
        	 int count=0;
        	 while(rs.next())
        	 {
        		 if(rs.getInt(1)==n)
        			 count++;
        	 }
        	 if(count!=0)
        	 {
        		PreparedStatement ps=con.prepareStatement("delete patient where patient_id=?");
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
     public static void UpdatePatient()
     {
    	 try {
    	 while(true) {
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("Enter the Option For Updating:");
    	 System.out.println("Enter 1 For Updating the Patient_ID");
    	 System.out.println("Enter 2 For Updating the Patient_Name");
    	 System.out.println("Enter 3 For Updating the Patient_Age");
    	 System.out.println("Enter 4 For Updating the Patient_Address");
    	 System.out.println("Enter 5 For Updating the Patient_ContactNumber");
    	 System.out.println("Enter 6 For Completing the Updates");
    	 int n=sc.nextInt();
    	 sc.nextLine();
    	 if(n==1)
    	 {
    	 System.out.println("You Have Entered 1 For Updating the Patient_ID:");
    	 System.out.println("Enter the New Patient_ID to Update:");
    	 int a=sc.nextInt();
    	 System.out.println("Enter the Patient_ID to Update:");
    	 int b=sc.nextInt();
    	 PreparedStatement ps1=con.prepareStatement("Update Patient set patient_id=? where patient_id=?");
   		 ps1.setInt(1,a);
   		 ps1.setInt(2,b);
   		 ps1.execute();
    	 }
    	 else if(n==2)
    	 {
    		 System.out.println("You Have Entered 2 For Updating the Patient_Name:");
        	 System.out.println("Enter the New Patient_Name to Update:");
        	 String a=sc.nextLine();
        	 System.out.println("Enter the Patient_ID to Update:");
        	 int b=sc.nextInt();
        	 PreparedStatement ps1=con.prepareStatement("Update Patient set patient_name=? where patient_id=?");
       		 ps1.setString(1,a);
       		 ps1.setInt(2,b);
       		 ps1.execute(); 
    	 }
    	 else if(n==3)
    	 {
    		 System.out.println("You Have Entered 3 For Updating the Patient_Name:");
        	 System.out.println("Enter the New Patient_Age to Update:");
        	 int a=sc.nextInt();
        	 System.out.println("Enter the Patient_ID to Update:");
        	 int b=sc.nextInt();
        	 PreparedStatement ps1=con.prepareStatement("Update Patient set patient_age=? where patient_id=?");
       		 ps1.setInt(1,a);
       		 ps1.setInt(2,b);
       		 ps1.execute();  
    	 }
    	 else if(n==4)
    	 {
    		 System.out.println("You Have Entered 4 For Updating the Patient_Address:");
        	 System.out.println("Enter the New Patient_Address to Update:");
        	 String a=sc.nextLine();
        	 System.out.println("Enter the Patient_ID to Update:");
        	 int b=sc.nextInt();
        	 PreparedStatement ps1=con.prepareStatement("Update Patient set patient_address=? where patient_id=?");
       		 ps1.setString(1,a);
       		 ps1.setInt(2,b);
       		 ps1.execute(); 
    	 }
    	 else if(n==5)
    	 {
    		 System.out.println("You Have Entered 5 For Updating the Patient_ContactNumber:");
        	 System.out.println("Enter the New Patient_ContactNumber to Update:");
        	 String a=sc.nextLine();
        	 System.out.println("Enter the Patient_ID to Update:");
        	 int b=sc.nextInt();
        	 PreparedStatement ps1=con.prepareStatement("Update Patient set patient_contactnumber=? where patient_id=?");
       		 ps1.setString(1,a);
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
