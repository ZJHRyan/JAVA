package polymorphism.emyloyee.earningBook;

public class CommissionEmployeeBook  extends EmployeeBaseBook{

	public CommissionEmployeeBook(String _companyName,int _employeeNo,boolean _isGUI) {
		super(_companyName,_employeeNo,_isGUI)
		formatTitle4EmployeeBook+= String.format("%10s\t%10s\t%10s\t%10s\n", "GrossSale", "Rate", "Rarnings" ); 
		header4WageBook+=formatTitle4EmployeeBook; 
		// TODO Auto-generated constructor stub
	}

}
