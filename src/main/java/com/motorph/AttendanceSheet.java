/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph;

/**
 *
 * @author janin
 */
public class AttendanceSheet {
    

    private Double Date;
    private Double TimeIn;
    private Double TimeOut;
    
    public Double ComputeWorkHours(){
        return (TimeOut - TimeIn)*24;
    } 

    public Double getDate() {
        return Date;
    }

    public void setDate(Double Date) {
        this.Date = Date;
    }

    public Double getTimeIn() {
        return TimeIn;
    }

    public void setTimeIn(Double TimeIn) {
        this.TimeIn = TimeIn;
    }

    public Double getTimeOut() {
        return TimeOut;
    }

    public void setTimeOut(Double TimeOut) {
        this.TimeOut = TimeOut;
    }
    
    
    
           
    
    
}
