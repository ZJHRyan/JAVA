package polymorphism.employee.frame;


import java.awt.EventQueue;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

import polymorphism.employee.btncontroller.BtnController4SuperEmployeeBase;
import polymorphism.employee.menuoption.EmployeeRecordIndices;
import polymorphism.emyloyee.BasePlusCommissionEmployee;
import polymorphism.emyloyee.earningBook.CommissionEmployeeBook;
import polymorphism.emyloyee.earningBook.EmployeeBaseBook;
import polymorphism.emyloyee.helper.Helper4BasePlusCommissionEmployee;
import polymorphism.emyloyee.helper.Helper4CommissionEmployee;
import polymorphism.emyloyee.helper.Helper4SuperEmployeeBase;

import javax.swing.border.BevelBorder;
import java.awt.Color;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class BasePlusCommissionEmployeeJFrame extends CommissionEmployJFame {
	private static final JTextField txtFielBaseSalary = null;

	public BasePlusCommissionEmployeeJFrame(String employeeType) {
		super(employeeType);
		// TODO Auto-generated constructor stub
	}
	public JTextField txtFieldBaseSalary;
//	public JTextField txtFieldCommisssionRate;
//	public JLabel lblCommisssionRate;
	public JLabel lblBaseSalary;

	public static void main(String[] args) {
//		employeeType = "SuperBase Emplyee (by RyanZa107230001)";
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EmployeeBaseJFrame frame = new EmployeeBaseJFrame(employeeType);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		employeeType = "BasePlusCommission Emplyee (by RyanZa107230001)";
		BasePlusCommissionEmployeeJFrame component = new BasePlusCommissionEmployeeJFrame(employeeType);
		
		Main_Run(component, employeeType, new BtnController4SuperEmployeeBase(component, null));
	}
	public void BasePlusCommissionEmployeeJFrame(String employeeType,JDesktopPane theDesktop) {
		super(employeeType);
		helper4Employee = new Helper4BasePlusCommissionEmployee(this);
	}
	
@Override	
protected void setupComponent4JPanel() 
{
	super.setupComponent4JPanel();
	contentPane.setLayout(null);
	
	txtFieldBaseSalary = new JTextField();
	txtFieldBaseSalary.setColumns(10);
	txtFieldBaseSalary.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),

							new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
	txtFieldBaseSalary.setBounds(172, 411, 96, 21);
	contentPane.add(txtFieldBaseSalary);
	
	lblBaseSalary = new JLabel("Gross Salea");
	lblBaseSalary.setHorizontalAlignment(SwingConstants.RIGHT);
	lblBaseSalary.setFont(new Font("Times New Roman", Font.BOLD, 12));
	lblBaseSalary.setBounds(10, 406, 96, 29);
	contentPane.add(lblBaseSalary);
	
//	txtFieldCommisssionRate = new JTextField();
//	txtFieldCommisssionRate.setColumns(10);
//	txtFieldCommisssionRate.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
//
//							new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
//	txtFieldCommisssionRate.setBounds(575, 411, 96, 21);
//	contentPane.add(txtFieldCommisssionRate);
//	
//	lblCommisssionRate = new JLabel("Commisssion Rate");
//	lblCommisssionRate.setHorizontalAlignment(SwingConstants.RIGHT);
//	lblCommisssionRate.setFont(new Font("Times New Roman", Font.BOLD, 12));
//	lblCommisssionRate.setBounds(392, 410, 165, 29);
//	contentPane.add(lblCommisssionRate);
//	
}
@Override
public void initialize4TitleNamesString4JTable() {
	// TODO Auto-generated method stub
	super.initialize4TitleNamesString4JTable();
//	listTitleName4Table.add(EmployeeRecordIndices.GROSS_SALES.getRecordIndexType());// EmployeeRecordlndices 
//	listTitleName4Table.add(EmployeeRecordIndices.COMMISSION_RATE.getRecordIndexType()); 
//	listTitleName4Table.add(EmployeeRecordIndices.EARNINGS.getRecordIndexType()); 
//	listTitleName4Table.add(EmployeeRecordIndices.WAGE_LEVEL.getRecordIndexType()); 
//	listTitleName4Table.add(EmployeeRecordIndices.INDEX_COLOR.getRecordIndexType()); 
	listTitleName4Table.add(EmployeeRecordIndices.BASE_SALARY.getRecordIndexType());
	
}

@Override
protected void initializeTextFieldArrayList() {
	super.initializeTextFieldArrayList();
//	listTxtFieLdsEmpLoyeeG.add(txtFieldGrossSales);
//	listTxtFieLdsEmpLoyeeG.add(txtFieldCommisssionRate);
	listTxtFieLdsEmpLoyeeG.add(txtFielBaseSalary);
	
}
@Override
public EmployeeBaseBook setBasics2StartBookingEmployee()
{
	employeeBaseBook = new CommissionEmployeeBook(helper4Employee.CompanyName,helper4Employee.EmployeeNo, true);
	return employeeBaseBook;
	}
@Override
public EmployeeBaseJFrame refreshJFrame() {
	EmployeeBaseJFrame component= new CommissionEmployJFame(employeeType4Jframe);
	
	btnController = new BtnController4SuperEmployeeBase(component, theDesktop);
	Main_Run(component, employeeType4Jframe, btnController);
	return component;
}
}
