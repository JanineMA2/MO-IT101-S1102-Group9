/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.model;

import java.util.Date;

/**
 *
 * @author janin
 */
public class Employee {

    /**
     * @return the emplast
     */
    public String getEmplast() {
        return emplast;
    }

    /**
     * @param emplast the emplast to set
     */
    public void setEmplast(String emplast) {
        this.emplast = emplast;
    }

    /**
     * @return the empfirst
     */
    public String getEmpfirst() {
        return empfirst;
    }

    /**
     * @param empfirst the empfirst to set
     */
    public void setEmpfirst(String empfirst) {
        this.empfirst = empfirst;
    }

    /**
     * @return the birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phonenum
     */
    public String getPhonenum() {
        return phonenum;
    }

    /**
     * @param phonenum the phonenum to set
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    /**
     * @return the SSS
     */
    public String getSSS() {
        return SSS;
    }

    /**
     * @param SSS the SSS to set
     */
    public void setSSS(String SSS) {
        this.SSS = SSS;
    }

    /**
     * @return the PHIC
     */
    public String getPHIC() {
        return PHIC;
    }

    /**
     * @param PHIC the PHIC to set
     */
    public void setPHIC(String PHIC) {
        this.PHIC = PHIC;
    }

    /**
     * @return the HDMF
     */
    public String getHDMF() {
        return HDMF;
    }

    /**
     * @param HDMF the HDMF to set
     */
    public void setHDMF(String HDMF) {
        this.HDMF = HDMF;
    }

    /**
     * @return the TIN
     */
    public String getTIN() {
        return TIN;
    }

    /**
     * @param TIN the TIN to set
     */
    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the supervisor
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * @return the rice
     */
    public Double getRice() {
        return rice;
    }

    /**
     * @param rice the rice to set
     */
    public void setRice(Double rice) {
        this.rice = rice;
    }

    /**
     * @return the phoneallow
     */
    public Double getPhoneallow() {
        return phoneallow;
    }

    /**
     * @param phoneallow the phoneallow to set
     */
    public void setPhoneallow(Double phoneallow) {
        this.phoneallow = phoneallow;
    }

    /**
     * @return the clothallow
     */
    public Double getClothallow() {
        return clothallow;
    }

    /**
     * @param clothallow the clothallow to set
     */
    public void setClothallow(Double clothallow) {
        this.clothallow = clothallow;
    }

    /**
     * @return the hrrate
     */
    public Double getHrrate() {
        return hrrate;
    }

    /**
     * @param hrrate the hrrate to set
     */
    public void setHrrate(Double hrrate) {
        this.hrrate = hrrate;
    }

    /**
     * @return the basic
     */
    public Double getBasic() {
        return basic;
    }

    /**
     * @param basic the basic to set
     */
    public void setBasic(Double basic) {
        this.basic = basic;
    }

    /**
     * @return the employeeID
     */
    public Integer getEmployeeNum() {
        return employeeNum;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeNum(Integer employeeNum) {
        this.employeeNum = employeeNum;
    }
  private Integer employeeNum; 
  private String emplast;
  private String empfirst;
  private Date birthdate;
  private String address;
  private String phonenum;
  private String SSS;
  private String PHIC;
  private String HDMF;
  private String TIN;
  private String status;
  private String position;
  private String supervisor;
  private Double basic;
  private Double rice;
  private Double phoneallow;
  private Double clothallow;
  public Double computesemi(){
      return getBasic()/2;
  }
  private Double hrrate;
  
  
  
  
    
}
