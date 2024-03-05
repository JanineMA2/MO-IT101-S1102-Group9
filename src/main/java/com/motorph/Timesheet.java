/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author janin
 */
public class Timesheet {

    

    public static Double GetTotalWHperEmp(int EmployeeNumb) throws FileNotFoundException, IOException {    
        FileInputStream empdatafile = new FileInputStream(new File("C:\\Users\\janin\\Documents\\JAVA\\MotorPH\\MotorPH Requirements and documents\\MotorPH Employee Data.xlsx"));
        Workbook empDataWorkbook = new XSSFWorkbook(empdatafile);
        XSSFSheet empAttendance = (XSSFSheet) empDataWorkbook.getSheet("Attendance Record");
 
 //Hashmap
        int RowTotal= empAttendance.getLastRowNum(); 
        int ColTotal= empAttendance.getRow(0).getLastCellNum();
        
                //P.key, value
        HashMap<Integer,Employee> DTR= new HashMap<> ();
            
        //1st loop
        for(int r=1; r<=RowTotal; r++){ 
            int EmpNum = (int)empAttendance.getRow(r).getCell(0).getNumericCellValue();
            String LastName= empAttendance.getRow(r).getCell(1).getStringCellValue();
            String FirstName= empAttendance.getRow(r).getCell(2).getStringCellValue();
            Double Date= empAttendance.getRow(r).getCell(3).getNumericCellValue();
            Double TimeIn= empAttendance.getRow(r).getCell(4).getNumericCellValue();
            Double TimeOut= empAttendance.getRow(r).getCell(5).getNumericCellValue();
            Employee EmpData;
                
                //shortcut of if else, "!" opposite of condition
                if (!DTR.containsKey(EmpNum)){
                    EmpData = new Employee();
                    EmpData.setEmpNum(EmpNum);
                    EmpData.setFirstName(FirstName);
                    EmpData.setLastName(LastName);
                    DTR.put(EmpNum, EmpData);    
                }
                 EmpData = DTR.get(EmpNum);
                
            AttendanceSheet attendancesheet= new AttendanceSheet();
            attendancesheet.setDate(Date);
            attendancesheet.setTimeIn(TimeIn);
            attendancesheet.setTimeOut(TimeOut);
            EmpData.getAttendance().add(attendancesheet);          
        }
            
        Employee EmpData = DTR.get(2);
           
        //2nd loop- Attendance list
        for (AttendanceSheet attendancesheet: EmpData.getAttendance()){ 
            /*  System.out.print(" Date: " + attendancesheet.getDate());
            System.out.print(" In: " + attendancesheet.getTimeIn());
            System.out.print(" Out: " + attendancesheet.getTimeOut());
            System.out.print(" WH: " + attendancesheet.ComputeWorkHours());
            */
        }
        
        return DTR.get(EmployeeNumb).TotalWH();
    }
}
