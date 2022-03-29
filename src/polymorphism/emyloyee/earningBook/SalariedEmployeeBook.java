package polymorphism.emyloyee.earningBook;

public class SalariedEmployeeBook extends EmployeeBaseBook {

	public SalariedEmployeeBook(String _companyName,int _employeeNo,boolean _isGUI) 
	{
		super(_companyName,_employeeNo,_isGUI)

		formatTitle4EmployeeBook+= 
				String.format("%15s\t%15s\n", "weeklySalary", "Rarnings" ); 
		header4WageBook+=formatTitle4EmployeeBook; 
	}

}
