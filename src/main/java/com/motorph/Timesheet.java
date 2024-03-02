/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
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
        
 /*  List all     
        //OR USE ITERATOR. 
        //loop for row:
        int RowTotal= empAttendance.getLastRowNum();
        int ColTotal= empAttendance.getRow(0).getLastCellNum();

        for(int r=0; r<=RowTotal; r++)
            {XSSFRow ROW= empAttendance.getRow(r); 
                
                //loop for columns:
                for(int c=0; c<ColTotal; c++)
                {XSSFCell COL= ROW.getCell(c);
                
                    switch(COL.getCellType())
                    {case STRING: System.out.print(COL.getStringCellValue()); break;
                    case NUMERIC: System.out.print(COL.getNumericCellValue()); break;
                    case BOOLEAN: System.out.print(COL.getBooleanCellValue()); break; 
                    }
                System.out.print(" | " );   
                }
            System.out.println();   
            }
    */
 
 //H//shMap
            int RowTotal= empAttendance.getLastRowNum(); 
            int ColTotal= empAttendance.getRow(0).getLastCellNum();
            
                  //P.key, value
            HashMap<Integer,Employee> DTR= new HashMap<> ();
            
            
            for(int r=1; r<=RowTotal; r++)
            { 
                int EmpNum = (int)empAttendance.getRow(r).getCell(0).getNumericCellValue();
                String LastName= empAttendance.getRow(r).getCell(1).getStringCellValue();
                String FirstName= empAttendance.getRow(r).getCell(2).getStringCellValue();
                Double Date= empAttendance.getRow(r).getCell(3).getNumericCellValue();
                Double TimeIn= empAttendance.getRow(r).getCell(4).getNumericCellValue();
                Double TimeOut= empAttendance.getRow(r).getCell(5).getNumericCellValue();
                Employee EmpData;
                
                //shortcut ng if else, ung "!" opposite ng condition
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
/* temp            System.out.println("Try== "+ DTR.size());
            
    //        for(Employee EmpData : DTR.values())
    
             Employee EmpData = DTR.get(2);
             System.out.println("Employee Name"+ EmpData.getLastName());
           
                    for (AttendanceSheet attendancesheet: EmpData.getAttendance())
                    { System.out.print(" Date: " + attendancesheet.getDate());
                      System.out.print(" In: " + attendancesheet.getTimeIn());
                      System.out.print(" Out: " + attendancesheet.getTimeOut());
                      System.out.print(" WH: " + attendancesheet.ComputeWorkHours());  
                    }
            System.out.println();
            System.out.println(" TWH: " + EmpData.TotalWH());
*/ 
            
    //        }
            //variable: Array
                    
//            for(Map.Entry EEEE: DTR.entrySet())
//            {System.out.println("List ng nahashmap: "+EEEE.getKey()+" "+EEEE.getValue());  
//             System.out.println("==DAILY TIMESHEETS==");
//             
             /*
                    for(int rr=0; rr<=RowTotal; rr++)
                       {XSSFRow ROW= empAttendance.getRow(rr);
                     for(int c=3; c<ColTotal; c++)
                     {  XSSFCell COL= ROW.getCell(c);
                
                     switch(COL.getCellType())
                        {  case STRING: System.out.print(COL.getStringCellValue()); break;
                            case NUMERIC: System.out.print(COL.getNumericCellValue()); break;
                            case BOOLEAN: System.out.print(COL.getBooleanCellValue()); break; 
                        }
                System.out.print(" |");   
                     }
                System.out.println();     
                }*/
   
   return DTR.get(EmployeeNumb).TotalWH();
    
    }
}
