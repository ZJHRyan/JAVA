package polymorphism.emyloyee.earningBook;

public class BasePlusCommissionEmployeeBook extends EmployeeBaseBook{

	public BasePlusCommissionEmployeeBook(String _companyName,int _employeeNo,boolean _isGUI) {
		// TODO Auto-generated constructor stub
		super(_companyName,_employeeNo,_isGUI)
		formatTitle4EmployeeBook+= String.format("%10s\t%10s\t%10s\t%10s\n", "GrossSale", "Rate", "BaseSalary", "Rarnings" ); 
		header4WageBook+=formatTitle4EmployeeBook; 

		
	}

}
