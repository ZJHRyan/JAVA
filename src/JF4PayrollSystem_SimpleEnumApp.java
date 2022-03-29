 import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import polymorphism.employee.btncontroller.BtnController4SuperEmployeeBase;
import polymorphism.employee.frame.BasePlusCommissionEmployeeJFrame;
import polymorphism.employee.frame.CommissionEmployJFame;
import polymorphism.employee.frame.EmployeeBaseJFrame;
import polymorphism.employee.frame.HourlyEmployeeJFrame;
import polymorphism.employee.frame.SalariedEmployeeJFrame;
import polymorphism.employee.menuoption.EmployeeType_MenuOption;
import polymorphism.emyloyee.helper.Helper4CommissionEmployee;
import polymorphism.emyloyee.helper.Helper4SuperEmployeeBase;

public class JF4PayrollSystem_SimpleEnumApp extends JFrame implements ActionListener { 
	JDesktopPane theDesktop; 
	EmployeeBaseJFrame baseEmployee; 
	CommissionEmployJFame commissionEmployee; 
	BasePlusCommissionEmployeeJFrame basePlusCommissionEmployee; 
	HourlyEmployeeJFrame hourlyEmployee; 
	SalariedEmployeeJFrame salariedEmployee; 

	public static Helper4SuperEmployeeBase heLper4EmpLoyee; 
	// public static Verifier4SuperEmployeeBase verifier4Employee; 

	public EmployeeType_MenuOption[] employeeChoices = { EmployeeType_MenuOption.BaseEmpLoyee, 
			EmployeeType_MenuOption.SalariedEmpLoyee, EmployeeType_MenuOption.HourlyEmpLoyee, 
			EmployeeType_MenuOption.CommissionEmployee, EmployeeType_MenuOption.BasePLusCommissionEmpIoyee, 
			EmployeeType_MenuOption.Quit }; 
	
	public JF4PayrollSystem_SimpleEnumApp() { 
		super("Grade-Book Applicaion - Using InternalFrameDemo (by Zhang a107230001)"); 
	

		// Make the big window be indented 50 pixels from each edge 
		// of the screen. 
		int inset = 50; 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset * 2); 
		// Set up the GUI. 
		theDesktop = new JDesktopPane(); // a specialized layered pane 
//		createFrame(); // create first "window"; here is no need. 
		setContentPane(theDesktop); 
		setJMenuBar(createMenuBar()); 
		// Make dragging a little faster but perhaps uglier. 
		theDesktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE); 
	}
	protected JMenuBar createMenuBar() { 
		JMenuBar menuBar = new JMenuBar(); 
		// Set up the lone menu. 
		JMenu menu = new JMenu("Employee"); 
		menu.setMnemonic(KeyEvent.VK_E); 
		menuBar.add(menu); 
		// Set up the Base Employee menu item. 
		JMenuItem menuItem = new JMenuItem(EmployeeType_MenuOption.BaseEmpLoyee.getEmployeeType()); 
		menuItem.setMnemonic(KeyEvent.VK_8); 
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8, ActionEvent.ALT_MASK)); 
		menuItem.setActionCommand(EmployeeType_MenuOption.BaseEmpLoyee.getEmployeeType()); 
		menuItem. addActionListener(this); 
		menu.add(menuItem); 
		// Set up the Base Employee menu item. 
		menuItem = new JMenuItem(EmployeeType_MenuOption.SalariedEmpLoyee.getEmployeeType()); 
		menuItem.setMnemonic(KeyEvent.VK_S); 
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK)); 
		menuItem.setActionCommand(EmployeeType_MenuOption.SalariedEmpLoyee.getEmployeeType()); 
		menuItem. addActionListener(this); 
		menu.add(menuItem); 
		// Set up the Hourly Employee menu item. 
		menuItem = new JMenuItem(EmployeeType_MenuOption.HourlyEmpLoyee.getEmployeeType()); 
		menuItem.setMnemonic(KeyEvent.VK_H); 
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.ALT_MASK)); 
		menuItem.setActionCommand(EmployeeType_MenuOption.HourlyEmpLoyee.getEmployeeType()); 
		menuItem. addActionListener(this); 
		menu.add(menuItem); 
		// Set up the Commission Employee menu item. 
		menuItem = new JMenuItem(EmployeeType_MenuOption.CommissionEmployee.getEmployeeType()); 
		menuItem.setMnemonic(KeyEvent.VK_C); 
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK)); 
		menuItem.setActionCommand(EmployeeType_MenuOption.CommissionEmployee.getEmployeeType()); 
		menuItem. addActionListener(this); 
		menu.add(menuItem); 
		// Set up the BasePlusCommission Employee menu item. 
		menuItem = new JMenuItem(EmployeeType_MenuOption.BasePLusCommissionEmpIoyee.getEmployeeType()); 
		menuItem.setMnemonic(KeyEvent.VK_P); 
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK)); 
		menuItem.setActionCommand(EmployeeType_MenuOption.BasePLusCommissionEmpIoyee.getEmployeeType()); 
		menuItem.addActionListener(this); 
		menu.add(menuItem); 
		// Set up the second menu item. 
		menuItem = new JMenuItem(EmployeeType_MenuOption.Quit.getEmployeeType()); 
		menuItem.setMnemonic(KeyEvent.VK_Q); 
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK)); 
		menuItem.setActionCommand(EmployeeType_MenuOption.Quit.getEmployeeType());  
		menuItem. addActionListener(this); 
		menu.add(menuItem); 
		return menuBar; 
	} 
	// React to menu selections. 
	public void actionPerformed(ActionEvent e) { 
	EmployeeType_MenuOption choice = null; 
	String taskChoiceType_S = e.getActionCommand(); 
	JOptionPane.showMessageDialog(null, taskChoiceType_S); 
	for (int i = 0; i < employeeChoices.length; i++) { 
		if (employeeChoices[i].getEmployeeType()==taskChoiceType_S) { 
//			JOptionPane.showMessageDialog(null,basicChoices[i].getButtonType());//Keep it for debug 
			choice = employeeChoices[i]; 
			break; 
	}
	} 
	createFrame(taskChoiceType_S, choice); 

	}
	protected void createFrame(String actionS, EmployeeType_MenuOption _employeeTypeEnum) { 
		switch ( _employeeTypeEnum) { 
		case BaseEmpLoyee: 
			baseEmployee = new EmployeeBaseJFrame(EmployeeType_MenuOption.BaseEmpLoyee.getEmployeeType()); 
			EmployeeBaseJFrame.Main_Run(baseEmployee, _employeeTypeEnum.getEmployeeType(), 
					new BtnController4SuperEmployeeBase(baseEmployee, theDesktop)); 
		
			baseEmployee.setVisible(true); 
			theDesktop.add(baseEmployee); // attach internal frame 
			try { 
				baseEmployee.setSelected(true); 
			} catch (java.beans.PropertyVetoException eC) {
			} 
			
			
		break; 

		case CommissionEmployee: 
			commissionEmployee = new CommissionEmployJFame( 
					EmployeeType_MenuOption.CommissionEmployee.getEmployeeType()); 
			// verifier4Employee = new Verifier4CommissionEmployee(commissionEmployee); 
			heLper4EmpLoyee = new Helper4CommissionEmployee(commissionEmployee); 
			
			 CommissionEmployJFame.Main_Run(commissionEmployee, _employeeTypeEnum.getEmployeeType(), 
					 new BtnController4SuperEmployeeBase(commissionEmployee, theDesktop)); 
			 commissionEmployee.setVisible(true); 
			 theDesktop.add(commissionEmployee); // attach internal frame 
		try { 
			commissionEmployee.setSelected(true); 
			} catch (java.beans.PropertyVetoException eC) { 
		} 
		break; 
	case BasePLusCommissionEmpIoyee: 
		basePlusCommissionEmployee = new BasePlusCommissionEmployeeJFrame( 
				EmployeeType_MenuOption.BasePLusCommissionEmpIoyee.getEmployeeType()); 
		BasePlusCommissionEmployeeJFrame.Main_Run(basePlusCommissionEmployee, _employeeTypeEnum.getEmployeeType(), 
				new BtnController4SuperEmployeeBase(basePlusCommissionEmployee, theDesktop)); 
		basePlusCommissionEmployee.setVisible(true); 
		theDesktop.add(basePlusCommissionEmployee); // attach internal frame 
		try { 
			basePlusCommissionEmployee.setSelected(true); 
			} catch (java.beans.PropertyVetoException eC) { 
		} 
		break; 
		case Quit: 
			quit(); 
			} 
		} 
	
	protected void quit() {
		System.exit(0);
	}
	private static void creatAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JF4PayrollSystem_SimpleEnumApp frame = new JF4PayrollSystem_SimpleEnumApp();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				creatAndShowGUI();
				
			}
		});
		
	}
	

	
}
