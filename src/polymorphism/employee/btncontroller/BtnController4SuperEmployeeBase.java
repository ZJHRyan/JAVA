package polymorphism.employee.btncontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import library.enummenu.Btns4UniversalProcess_MenuOpAdv;
import polymorphism.emyloyee.earningBook.EmployeeBaseBook;
import polymorphism.employee.frame.CommissionEmployJFame;
import polymorphism.employee.frame.EmployeeBaseJFrame;
import polymorphism.emyloyee.helper.Helper4SuperEmployeeBase;

public class BtnController4SuperEmployeeBase{
	EmployeeBaseJFrame frameEmployee; 
	Helper4SuperEmployeeBase helper; 
	public EmployeeBaseBook employeeBook; 
	
	public boolean checkBasicProfile = false; 
	
	public JButton[] optionButtons; 
	Btns4UniversalProcess_MenuOpAdv[] btnChoicesEnums;
	
	public File fileWrite = null, fileRead = null;
	private String filePath = "./filePath";
	JDesktopPane theDesktop;
	
	public BtnController4SuperEmployeeBase(EmployeeBaseJFrame _frameEmployee ) { 
		frameEmployee = _frameEmployee; 
		optionButtons = frameEmployee.optionButtons; 
		btnChoicesEnums = frameEmployee.basicChoices; 
		helper = EmployeeBaseJFrame.helper4Employee; 
		employeeBook = frameEmployee.employeeBaseBook; 
		
		//theDesktop=_theDesktop;
		
	}//end BtnController4SuperEmployeeBase with 1 parameter
	public BtnController4SuperEmployeeBase(EmployeeBaseJFrame _frameEmployee,JDesktopPane _theDesktop) { 
		frameEmployee = _frameEmployee; 
		optionButtons = frameEmployee.optionButtons; 
		btnChoicesEnums = frameEmployee.basicChoices; 
		helper = EmployeeBaseJFrame.helper4Employee; 
		employeeBook = frameEmployee.employeeBaseBook; 
		
		theDesktop=_theDesktop;
		
	}//end BtnController4SuperEmployeeBase with 1 parameter
	
	public void addActionListenerOnButtons() {
		for (int task = 0; task < optionButtons.length; task++) {
			optionButtons[task].addActionListener(new ButtonHandlerBySwitch());
		}// end for
		
	}
	
	private class ButtonHandlerBySwitch implements ActionListener{ 
		private String taskChoiceType_S; 
		private Btns4UniversalProcess_MenuOpAdv btnChoice;
		
		public void actionPerformed(ActionEvent event) {
			taskChoiceType_S = event.getActionCommand(); 
			JOptionPane.showMessageDialog(null, taskChoiceType_S); 
	
			for (int i = 0; i < optionButtons.length; i++) { 
				if (btnChoicesEnums[i].getButtonType() == taskChoiceType_S) { 
//					JOptionPane.showMessageDialog(null,btnChoicesEnums[i].getButtonType());//Keep it for debug 
					btnChoice = btnChoicesEnums[i]; 
					break; 
				}
			}
			
			try { 
				switchChoices(btnChoice); 
				} catch (FileNotFoundException e) {
					e.printStackTrace(); 
					JOptionPane.showMessageDialog(null, e.getMessage()); 
				}
			}
	} // end actionPerformed // end class ButtonHandlerBySwitch 

	
	public void switchChoices(Btns4UniversalProcess_MenuOpAdv choiceEnum) throws FileNotFoundException { 
		switch (choiceEnum) {
		case Set_ProfiLe: 
			clickBtnToSetProfile();
			break; 
		case Process_Data: 
			clickBtnToCalculateProcessAll();
			break; 
		case Refresh: 
			refreshJFrame();
			break; 
		case Output_ResuLts: 
			outputFinalReport();
			break; 
		case Clear_Record: 
			clearRecordTextFields();
			break; 
		case CLear_ProfiLe_and_ResuLts: 
			clearProfileAndResults();
			break; 
		case OpenFiLe: 
			openfile();
			break; 
		case ReadFiLe: 
			readFile();
			break; 
		case PieChartDemo: 
			showPieChartOfWageDistribution();
			break; 
		case Exit: default: 
			exitAppInQuestion();
		
			break; 
		}
	}//end switchChoices
	
	public void clickBtnToSetProfile() { 
		if (helper.isReadFile) { 
			JOptionPane.showMessageDialog(null, "Please re-input data.", "GUI needs to be Refleshed !", 
					JOptionPane.INFORMATION_MESSAGE); 
			refreshJFrame(); 
		} else {
			
			helper.prepareBasicProfileUsingCheck();
			checkBasicProfile = helper.checkProfile; 
	 		JOptionPane.showMessageDialog(null, "checkBasicProfile=" + helper.checkProfile); 
	 		if (checkBasicProfile) { 
	 			helper.enableProfileTextBoxs(false); 
	 			setProfile(); 
	 			JOptionPane.showMessageDialog(null, "Start Inputting Record", "Basic-Profie OK!", 
	 					JOptionPane.INFORMATION_MESSAGE);
	 		}
		}
	}
	public void setProfile() { 
		frameEmployee.btnOpenFile.setEnabled(true);// added on 01Aug19 
		frameEmployee.btnCalculate.setEnabled(false);// old one 
		employeeBook = frameEmployee.setBasics2StartBookingEmployee(); 
	}// end setProfilF() 

	

	
	public void clickBtnToCalculateProcessAll() { 
		if (checkBasicProfile) {
			helper.prepareBasicProfileUsingCheck();
		}
		
	} 
	public void refreshJFrame() { 
		helper.refreshJFrame();
		
	} 
	public void outputFinalReport() { 
		helper.outputFinalReport();
	} 
	public void clearRecordTextFields() { 
		helper.clearRecordTextFields();
	} 
	public void clearProfileAndResults() { 
		for(JTextField txtField:EmployeeBaseJFrame.listTxtFieLdsEmpLoyeeG)
			txtField.setText("");
		for(JTextField txTextField:frameEmployee.listTxtFieldsResultsG)
			txTextField.setText("");
	} 
	public void openfile() { 
		try { 
			helper.openFile(filePath); 
		} catch (FileNotFoundException e) {  
	
			JOptionPane.showMessageDialog(null, e.getMessage(), "FileNotFoundExcepticn", 
					JOptionPane.INFORMATION_MESSAGE); 
		} catch (NullPointerException e) {  
			e.printStackTrace(); 
	
			JOptionPane.showMessageDialog(null, e.getMessage(), "NullPointerException", 
					JOptionPane.INFORMATION_MESSAGE); 
		} catch (IOException e) { 
			JOptionPane.showMessageDialog(null, "The Basic Profile\ndidn't saved as needed!", "No profile Saved ", 
					JOptionPane.ERROR_MESSAGE); 
		}
	}

	public void readFile() {
		try { 
			if (helper.isCreateFile || helper.isReadFile) { 
				refreshJFrame(); 
				helper.isCreateFile = false;
				
			} else 
				helper.readRecordData(); 
		} catch (ClassNotFoundException | IOException | NoSuchElementException 
				| NullPointerException | ClassCastException | IllegalArgumentException 
				| ArrayIndexOutOfBoundsException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage()+ "\n" 
			+ e.toString()+ "\n" 
			+ "\n                                ClassNotFoundException" 
			+ "\n                                    I0Exception" 
			+ "\n NoSuchElementException" 
			+ "\n IllegalArgumentException" 
			+ "\n NuliPointerException" 
			+ "\n ClassCastException" 
			+ "\n ArraylndexOutOfBoundsException", 
			"Maybe Re-Open Another File to Read?", JOptionPane.INFORMATION_MESSAGE); 
			} 

		
	} 
	public void showPieChartOfWageDistribution() { 
		helper.runPieChart3DFX();
		
	}
	public void exitAppInQuestion() { 
		helper.exitAppInQuestion();
	} 
	


	
}//end class BtnController4SuperEmployeeBase 
