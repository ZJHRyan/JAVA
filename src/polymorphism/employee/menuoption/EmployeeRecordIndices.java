package polymorphism.employee.menuoption;

// Fig. 15.7: MenuOption.java
// enum type for the credit-inquiry program's options.
public enum EmployeeRecordIndices {
	// declare contents of enum type

	COMPANY_NAME (0, "Company Name"), 
	EMPLOYEE_NO (1, "No of Employees"), 
	SSN (2, "SSN" ), 
	FIRST_NAME (3, "First Name" ), 
	LAST_NAME (4, "Last Name"), 
	WEEKLY_SALARY (5, "weekly S."), //"Weekly Salary"; S.: Salary 
	HOURLY_WAGE (6, "Hourly W."), //"Hourly Wage"; W.: Wage 
	HOURS_WORKED (7, "Work Hours"),//"Hours Worked" 
	GROSS_SALES (8, "G. Sales"), //"Gross Sales" 
	COMMISSION_RATE (9, "C. Rate"), //"Commission Rate" 
	BASE_SALARY (10, "Base Salary"), 
	EARNINGS (11, "Earnings"), 
	EMPLOYEE_COUNTER (12, "Employee Counter"), 
	LOWEST_EEARNINGS (13, "Lowest E."),//"Lowest Earnings" 
	HIGHEST_EEARNINGS(14, "Highest E."),//"Highest Earnings" 
	AVERAGE_EEARNINGS(15, "Average E."), //"Average Earnings" 
	WAGE_LEVEL (16, "Wage Level"), 
	INDEX_COLOR (17, "Index Color"), 
	EXTRA_HOURS_RATE (18, "Rate_EH"), //"Rate4ExtraHours"; EH: Extra-Hours 
	NORMAL_WORKED (40, "Max worked-Hours"),//168=24"7(total hours in one week)
	MAX_WORKED_HOURS (168, "Max worked-Hours");//168=24"7(total hours in one week)
	
	private final int value; // current menu option 
	private final String recordIndexType; // current menu option
	
	EmployeeRecordIndices( int valueOption, String optionT )
	{ 
		value = valueOption; 
		recordIndexType=optionT; 
		} // end EmployeeRecordindices taw constructor 
	
	public int getvalue() 
	{ 
		return value; 
	} // end method getvalue 
	public String getRecordIndexType() 
	{ 
		return recordIndexType; 
	} // end method getRecordlndexType ) // end 'Auto EmployeeRecordIndices 

}

/*************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/