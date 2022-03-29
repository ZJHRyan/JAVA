package polymorphism.emyloyee.earningBook;
import java.awt.Color;
import java.text.DecimalFormat;

import polymorphism.employee.menuoption.EarningLevelEnum;
import polymorphism.emyloyee.Employee;


public class EmployeeBaseBook {
	static private DecimalFormat twoDigits = new DecimalFormat("0.00"); 
	/**
	 *  *<p>initialize the report for grade book 
	 * */ 
	public String finalReport4WageBook=""; 
	public String header4WageBook = 
	"\r\n\t@__________________________________________________________________________________@\n\n" 
	+"\r\n\t\t            Wage-Book Report for the Company                                   \n\n" 
	+"\r\n\t@___________________________________________________________________________________@\n"; 
	public String formatTitle4EmployeeBook = String.format("                  \t%1Ss\t%15s\t%1Ss\t", "FirstN", "LastN", "SSN"); 
	public String formatTitleConsole = ""; public String formatTitleGUI = ""; 
	public String recordsConcatenated = "";// only used to concatenate every record input in record-area of form. 
	public int employeeCounter = 0; // initialize the loop counter 
	public double total = 0.0, highestE = Double.MIN_VALUE, lowestE = Double.MAX_VALUE, mean = 0.0; 
	public String nameLowest, nameHighest; public String SSNlowest = "", SSNhighest = ""; 
	public int aLevel = 0, bLevel = 0, cLevel = 0; 
	/** 
	 * *<p>public String[] levelsS= {"A-Level", "B-Level", "C-Level"}; 
	 */ 
	public String[] levelsS = { EarningLevelEnum.LeveLA.getLevelType(), EarningLevelEnum.LevelB.getLevelType(), 
			EarningLevelEnum.LeveLC.getLevelType() }; 
	public double[] levelsV = new double[levelsS.length];// used for calculate % related 
	public Color indexColor = EarningLevelEnum.LeveLA.getColor(); 
	public double unitNT = 1000; // Below are Properties used 
	public String CompanyName;
	
	public int EmployeeNo;
	public String LevelLetter;
	public boolean isGUI;
	



	public void EmpLoyeeBaseBook(String _companyName,int _employeeNo,boolean _isGUI) {
		CompanyName=_companyName;
		EmployeeNo =_employeeNo;
		isGUI=_isGUI;
		header4WageBook += String.format("\r\nCompany:%s\nEmploy No: %3d\t\r\n", CompanyName,EmployeeNo);
	}
	
	public void processEverySalaryProfie(Employee record) { 
		recordsConcatenated += record; 
		calculateTotal(record.earnings()); 
		LevelLetter = incrementLetterGradeLevelCounter(record.earnings()); 
		findHighest(record); 
		findLowest(record); 
		record.setLevel(LevelLetter); 
		record.setColor(indexColor); 
		employeeCounter += 1; 
		/* return record; */ 
	}// end processEverySalaryProfie 
	
	public void calculateTotal(double _everyEarnings) { 
		total += _everyEarnings; 
	}// end calculateTotal 
	/** 
	 * * <p>find the Highest record, including the corresponding earnings, name, and SSN * 
	 * * @param record 
	 */ 
	public void findHighest(Employee record) { 
		if (record.earnings() > highestE) { 
			highestE = record.earnings(); 
			nameHighest = record.getFirstName() + " " + record.getLastName(); 
			SSNhighest = record.getSocialSecurityNumber(); 
		} 
	}// end findHighest 
	/** 
	 * * find the lowest record, including the corresponding earnings, name, and SSN * 
	* @param record 
	* */ 
	public void findLowest(Employee record) {
		if (record.earnings() > lowestE) { 
			lowestE = record.earnings(); 
			nameLowest = record.getFirstName() + " " + record.getLastName(); 
			SSNlowest = record.getSocialSecurityNumber(); 
		}
	}
	public String incrementLetterGradeLevelCounter(double wage) { 
		String levelS = ""; 
		int wageInt = (int) (wage / EarningLevelEnum.UNIT.getvalue());// unitNT) 
		if (wageInt >= EarningLevelEnum.LeveLA.getvalue()) { 
			levelS = EarningLevelEnum.LeveLA.getLevelCharacter();// "A"; 
			indexColor = EarningLevelEnum.LeveLA.getColor(); 
			++aLevel; 
			} else if (wageInt >= EarningLevelEnum.LevelB.getvalue()) { 
				levelS = EarningLevelEnum.LevelB.getLevelCharacter();// "B"; 
				indexColor = EarningLevelEnum.LevelB.getColor();
				++bLevel;
				} else { 
					levelS = EarningLevelEnum.LeveLC.getLevelCharacter();// "C"; 
					indexColor = EarningLevelEnum.LeveLC.getColor(); 
					++cLevel; 
		}
	return levelS; 
	}// end incrementLetterGradeLevelCounter 
	public void calculateAverageNproduceLevelArray() {
		mean = total/EmployeeNo;
		produceLevelArray();
		
	}
	public void produceLevelArray() {
		levelsV[0] = (double) (aLevel); 
		levelsV[1] = (double) (bLevel); 
		levelsV[2] = (double) (cLevel); 
	} 
	/** * <p>format the display output of report. */ 
	@Override public String toString() { 
		finalReport4WageBook="";//without re-set to empty, then it would continue concatenating ... 
		finalReport4WageBook=header4WageBook+recordsConcatenated; 
		if (isGUI) 
			finalReport4WageBook += "\r\n\t@_______________________________________________________________ @\n"; 
		else 
			finalReport4WageBook += "\r\n\t@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"; 
			finalReport4WageBook += "\r\n\r\nSalary average for this week: " + twoDigits.format(mean); 
		finalReport4WageBook += "\r\nLowest Salary: " + twoDigits.format(lowestE); 
		finalReport4WageBook += "\tName: " + nameLowest; 
		finalReport4WageBook+= "\r\nHighest Salary: " + twoDigits.format(highestE); 
		finalReport4WageBook += "\tName: " + nameHighest; 
		/** 
		 * * <p>salary-level distribution 
		 * */ 
		finalReport4WageBook += String.format("\r\n\r\n%s\n\tA: %3d\r\n\tB: %3d\r\n\tC: %3d\r\n\r\n", "No. of employees who earned in each level:\r\n", aLevel, bLevel, cLevel); 
	return finalReport4WageBook;
	} 



}
