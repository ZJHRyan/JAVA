package polymorphism.employee.menuoption;

// Fig. 15.7: MenuOption.java
// enum type for the credit-inquiry program's options.
public enum EmployeeType_MenuOption {
	// declare contents of enum type

	BaseEmpLoyee ( 0, "Base-Employee"), 
	SalariedEmpLoyee ( 1, "Salaried-Employee" ), 
	HourlyEmpLoyee ( 2, "Hourly-Employee" ), 
	CommissionEmployee ( 3, "Commission-Employee" ), 
	BasePLusCommissionEmpIoyee( 4,  "BasePlusCommission-Employee" ), 
    Quit ( 5,"Quit" );
	
	private final int value; // current menu option 
	private final String employeeType; // current menu option 
	EmployeeType_MenuOption( int valueOption, String optionType ) 
	{ 
		value = valueOption; 
		employeeType=optionType; 
		} // end menuOptions vio* constructor 
	public int getValue() 
	{ 
		return value; // end method getvalue 
	}
	public String getEmployeeType() 
	{ 
		return employeeType;  // end method getvalue // end gaga EmployeeTypeMenuOption 
	}

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