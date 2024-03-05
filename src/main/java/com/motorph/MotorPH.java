/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.motorph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author janin
 */
public class MotorPH {
   
    public static void main(String[] args) throws FileNotFoundException, IOException {    
        //to read excel file
        FileInputStream empdatafile = new FileInputStream(new File("C:\\Users\\janin\\Documents\\JAVA\\MotorPH\\MotorPH Requirements and documents\\MotorPH Employee Data.xlsx"));
        Workbook empDataWorkbook = new XSSFWorkbook(empdatafile);
        XSSFSheet empDataSheet = (XSSFSheet) empDataWorkbook.getSheet("Employee Details");
        XSSFSheet empAttendance = (XSSFSheet) empDataWorkbook.getSheet("Attendance Record");

        Scanner EmployeeNum = new Scanner(System.in);
        System.out.println("Input Employee Number:");               
        int line = EmployeeNum.nextInt(); //input desire employee number
        System.out.println();
        System.out.println();
        
        XSSFCell EmpNum = empDataSheet.getRow(line).getCell(0);
        XSSFCell EmpLast = empDataSheet.getRow(line).getCell(1);
        XSSFCell EmpName = empDataSheet.getRow(line).getCell(2);
        XSSFCell EmpBday = empDataSheet.getRow(line).getCell(3);
        XSSFCell EmpAddress = empDataSheet.getRow(line).getCell(4);
        XSSFCell EmpStatus = empDataSheet.getRow(line).getCell(10);
        XSSFCell EmpPosition = empDataSheet.getRow(line).getCell(11);
        XSSFCell EmpBasic = empDataSheet.getRow(line).getCell(13);
              String EmpBasic2 =EmpBasic.toString();
              Double EmpBasic3 = Double.valueOf(EmpBasic2);
        XSSFCell EmpRice = empDataSheet.getRow(line).getCell(14);
              String EmpRice2 =EmpRice.toString();
              Double EmpRice3 = Double.valueOf(EmpRice2);
        XSSFCell EmpPhone = empDataSheet.getRow(line).getCell(15);
              String EmpPhone2 =EmpPhone.toString();
              Double EmpPhone3= Double.valueOf(EmpPhone2);
        XSSFCell EmpCloth = empDataSheet.getRow(line).getCell(16);
              String EmpCloth2 =EmpCloth.toString();
              Double EmpCloth3= Double.valueOf(EmpCloth2);
        XSSFCell EmpHrl = empDataSheet.getRow(line).getCell(18);
              String EmpHrl2 =EmpHrl.toString();
              Double EmpHrl3= Double.valueOf(EmpHrl2);//or use .getNumericValue() see line73
        
        System.out.println("Employeee Information" );
        System.out.println("---------------------" );
        System.out.println("Employeee Number: "+ EmpNum );
        System.out.println("Last Name: "+ EmpLast);
        System.out.println("First Name: "+ EmpName);
        System.out.println("Birthday: "+ EmpBday);
        System.out.println("Address: "+ EmpAddress);
        System.out.println("Status: "+ EmpStatus);
        System.out.println("Position: "+ EmpPosition);
        System.out.println("Montly Basic Salary: "+ EmpBasic);
        System.out.println("Hourly rate: "+ EmpHrl);
        System.out.println();
  
       System.out.println("Paylip" );
       System.out.println("---------------------" );
       
        //Amount basis of contributions [HourlyRate * Total WorkHours] !!(should not include allowances)!! 
       Double ContributionBasis = EmpHrl.getNumericCellValue()*Timesheet.GetTotalWHperEmp((int)EmpNum.getNumericCellValue());
       
       //SSS Computation base on total salary
       Double MultiplierSSS= ((ContributionBasis - 3249.99999)/500);
       Double Multi2SSS= (MultiplierSSS > 43.0)? 44.00: MultiplierSSS;
       Double SSSresult = Math.ceil(Multi2SSS)*22.5+135;
      
       //Philhealth Computation base on Basic Salary
       Double PHICExcessof10K= ((ContributionBasis- 10000) * (0.03/2));
       Double PHICLimit = (PHICExcessof10K > ((1800-300)/2))? ((1800-300)/2): PHICExcessof10K;
       Double PHICLimit2 =(PHICLimit <= 0)? 0: PHICLimit;
       Double PHICresult = PHICLimit2 +(300/2);
   
       //HDMF Computation base on Basic Salary
       Double HDMFTest= (ContributionBasis > 1500)? (ContributionBasis * .02): (ContributionBasis * 0.01) ;
       Double HDMFresult = (HDMFTest > 100)? 100 : HDMFTest;
       
       //Withholding Tax Computaion
       Double GrossIncome = ContributionBasis + EmpRice3 + EmpPhone3 + EmpCloth3; //pending Late Awol deductions
       Double TotalContri = SSSresult + PHICresult + HDMFresult;
       Double TaxableInc = GrossIncome - TotalContri;
       Double Wtax;
            if (TaxableInc < 20833){
                Wtax = 0.0;
            }else if (TaxableInc >=20833 && TaxableInc <33333){
                Wtax = ((TaxableInc-20833)*.20);
            }else if (TaxableInc >=33333 && TaxableInc <66667){
                Wtax = ((TaxableInc-33333)*.25 + 2500); 
            }else if (TaxableInc >=66667 && TaxableInc <166667){
                Wtax = ((TaxableInc-66667)*.30 + 10833);               
            }else if (TaxableInc >=166667 && TaxableInc <666667){
                Wtax = ((TaxableInc-166667)*.32 + 40833.33);               
            }else {
                Wtax = ((TaxableInc-666667)*.25 + 200833.33);
            }
       System.out.println("Earning:");
       System.out.println("Basic Salary " + ContributionBasis);
       System.out.println("Rice Subsidy "+ EmpRice);
       System.out.println("Phone Allowance "+ EmpPhone);
       System.out.println("Clothing Allowance "+ EmpCloth);
       System.out.println("Total Earning:"+ GrossIncome);
       System.out.println();
       System.out.println("Deductions:");
       System.out.println("SSS Contribution " + SSSresult);
       System.out.println("Philhealth Contribution " + PHICresult);
       System.out.println("HDMF Contribution " + HDMFresult);
       System.out.println("Withholding Tax " + Wtax); 
       System.out.println("Total Deductions: " + (TotalContri+Wtax));
       System.out.println();
       System.out.println("Net Pay: " + (GrossIncome-TotalContri-Wtax));       
    }    
}
