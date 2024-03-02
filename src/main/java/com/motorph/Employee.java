/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janin
 */
public class Employee {
    
    //dblclk- refactor- encapsulate, select all, refactor
    private int EmpNum;
    private String LastName;
    private String FirstName;
    
    private List<AttendanceSheet> Attendance; 
    //ctr shft I= for import
    
    public Double TotalWH(){
        Double Total=0.0;
        for(AttendanceSheet x : Attendance ){
            Total=Total + x.ComputeWorkHours();
        }
        return Total;        
    }

    //Constructor
    public Employee() {
		Attendance = new ArrayList<AttendanceSheet>();
	}
    
    public int getEmpNum() {
        return EmpNum;
    }

    public void setEmpNum(int EmpNum) {
        this.EmpNum = EmpNum;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public List<AttendanceSheet> getAttendance() {
        return Attendance;
    }

    public void setAttendance(List<AttendanceSheet> Attendance) {
        this.Attendance = Attendance;
    }
}
