package polymorphism.employee.frame;


import java.awt.EventQueue;

public class CommissionEmployJFame_a0001 extends EmployeeBaseJFrame_a0001 {

	public CommissionEmployJFame_a0001(String employeeType) {
		super(employeeType);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		employeeType = "Comission-Emplyee (by RyanZa107230001)";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommissionEmployJFame_a0001 frame = new CommissionEmployJFame_a0001(employeeType);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
