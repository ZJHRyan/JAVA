package polymorphism.employee.frame;


import java.awt.EventQueue;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CommissionEmployJFame_v6 extends EmployeeBaseJFrane_v4 {
	public JTextField txtFieldGrossSales;
	public JTextField txtFieldCommisssionRate;
	public JLabel lblCommisssionRate;
	public JLabel lblGrossSales;

	public CommissionEmployJFame_v6(String employeeType) {
		super(employeeType);
	}
	
@Override	
protected void setupComponent4JPanel() 
{
	super.setupComponent4JPanel();
	txtFieldGrossSales = new JTextField();
	txtFieldGrossSales.setColumns(10);
	txtFieldGrossSales.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),

							new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
	txtFieldGrossSales.setBounds(172, 411, 96, 21);
	contentPane.add(txtFieldGrossSales);
	
	lblGrossSales = new JLabel("Gross Salea");
	lblGrossSales.setHorizontalAlignment(SwingConstants.RIGHT);
	lblGrossSales.setFont(new Font("Times New Roman", Font.BOLD, 12));
	lblGrossSales.setBounds(10, 406, 96, 29);
	contentPane.add(lblGrossSales);
	
	txtFieldCommisssionRate = new JTextField();
	txtFieldCommisssionRate.setColumns(10);
	txtFieldCommisssionRate.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),

							new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
	txtFieldCommisssionRate.setBounds(575, 411, 96, 21);
	contentPane.add(txtFieldCommisssionRate);
	
	lblCommisssionRate = new JLabel("Commisssion Rate");
	lblCommisssionRate.setHorizontalAlignment(SwingConstants.RIGHT);
	lblCommisssionRate.setFont(new Font("Times New Roman", Font.BOLD, 12));
	lblCommisssionRate.setBounds(392, 410, 165, 29);
	contentPane.add(lblCommisssionRate);
	
}

protected void initializeTextFieldArrayList() {
	super.initializeTextFieldArrayList();
	
	listTxtFieLdsEmpLoyeeG.add(txtFieldGrossSales);
	listTxtFieLdsEmpLoyeeG.add(txtFieldCommisssionRate);
	
}
public void addJTable2Box() {
	box3.add(tableAggregate);		
}
	
	
	public static void main(String[] args) {
		employeeType = "Comission-Emplyee (by RyanZa107230001)";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommissionEmployJFame_v6 frame = new CommissionEmployJFame_v6(employeeType);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		employeeType = "Comission-Emplyee (by RyanZa107230001)";
//		CommissionEmployJFame_v6 component = new CommissionEmployJFame_v6(employeeType);
	}
	
}
