package polymorphism.emyloyee.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.sun.xml.internal.ws.api.Component;

import library.checkandvailidation_a0001.InputNumberValidation_GUI_CONSOLE;
import library.enummenu.FileStreamType_MenuOption;
import library.enummenu.NumberType_MenuOption;
import polymorphism.employee.frame.CommissionEmployJFame_a0001;
import polymorphism.employee.frame.CommissionEmployJFame;
import polymorphism.employee.menuoption.EmployeeRecordIndices;
import polymorphism.emyloyee.CommissionEmployee;

public class Helper4CommissionEmployee extends Helper4SuperEmployeeBase {

	public Helper4CommissionEmployee(/* Component component */CommissionEmployJFame component) {

		super(component);
		frameEmployee = (CommissionEmployJFame) component;
	}

	@Override
	public void checkInputRecordData() {
		super.checkInputRecordData();
		if (checkRecord) {
			checkRecord = validationNumber_GUI.checkNumberValueByComparing_1flag(
					((CommissionEmployJFame) frameEmployee).txtFieldGrossSales.getText(),
					EmployeeRecordIndices.GROSS_SALES.getRecordIndexType(), 0, 1,
					NumberType_MenuOption.DOUBLE_NUMBER_TYPE.getValueIndex());

			if (!checkRecord)
				((CommissionEmployJFame) frameEmployee).txtFieldGrossSales.setText("");
		}
		if (checkRecord) {
			checkRecord = validationNumber_GUI.checkNumberValueInRange_min0P1max0N1(

					((CommissionEmployJFame) frameEmployee).txtFieldCommisssionRate.getText(),
					EmployeeRecordIndices.COMMISSION_RATE.getRecordIndexType(), 8.0, 1.0,
					NumberType_MenuOption.DOUBLE_NUMBER_TYPE.getValueIndex());
			if (!checkRecord)
				((CommissionEmployJFame) frameEmployee).txtFieldCommisssionRate.setText("");
		}
//		 finally-> if everything is ready--> get all input data from Record-area
//		if (checkRecord) {
//			_SSN = frameEmployee.txtFieldSSN.getText();
//			_firstName = frameEmployee.txtFieldFN.getText();
//			_lastName = frameEmployee.txtFieldLN.getText();
//			_grossSales = Double.parseDouble(((CommissionEmployJFame) frameEmployee).txtFieldGrossSales.getText());
//			_commissionRate = Double
//					.parseDouble(((CommissionEmployJFame) frameEmployee).txtFieldCommisssionRate.getText());
//		}
	}// end checkInputRecordData()
	
	@Override
	public void getInputDataReady(boolean _checkRecord)
	{
		super.getInputDataReady(_checkRecord);
//		_grossSales = Double.parseDouble(((CommissionEmployJFame) frameEmployee).txtFieldGrossSales.getText());
//		_commissionRate = Double
//				.parseDouble(((CommissionEmployJFame) frameEmployee).txtFieldCommisssionRate.getText());
		
	}
	
	
//	@Override 
	public void processAndShowWageRecordsUsingCheck() {
	if (employeeCounter < EmployeeNo) { 
		checkInputRecordData(); 
		if (checkRecord) { 
			CommissionEmployee record = new CommissionEmployee(_firstName, _lastName, _SSN, 
					frameEmployee.isSimpleFprmat, _grossSales, _commissionRate); 
			addNprocessEveryNewRecord(record); 
			} // end inner if 
		} // end outer if 
	}// end processAndShowWageRecordsUsingCheck 
	/**
	 * Initially, below method was overridden here. After carefully tried out, it was found that 
	 * it could be just done in base-helper (Helper4SuperEmployeeBase), no need to be overridden 
	 * in any inherited classes. Therefore, below method has been moved to base helper(Helper4SuperEmployeeBase) and 
	 * modified there. 

	 */
	@Override 
	public Object[][] returnObjectArray(){ 
		Object[][] data = new Object[eList_Commission.size()][frameEmployee.listTitleName4Table.size()]; 
		
		for (int i = 0; i < eList_Commission.size(); i++) { 
			Object[] object = { eList_Commission.get(i).getSocialSecurityNumber(), 
					eList_Commission.get(i).getFirstName(), 
					eList_Commission.get(i).getLastName(), 
					eList_Commission.get(i).getGrossSales(), 
					eList_Commission.get(i).getCommissionRate(), 
					eList_Commission.get(i).earnings(), 
					eList_Commission.get(i).getLevel(), 
					eList_Commission.get(i).getColor() }; 
		
			data[i] = object; 
			} return data; 
		}// returnObjectArray(N 

//	@Override 
	public void readFile() throws NumberFormatException, ClassNotFoundException, NoSuchElementException, 
		NullPointerException, ClassCastException, IOException { 
		super.readFile(); 
	
		CommissionEmployee record = null; 
		if (isFileChoosenOK) { 
			eList_Commission = new ArrayList<CommissionEmployee>(); 
		
			if (streamType_MenuOption == FileStreamType_MenuOption.STANDARD_BASED) { 
				while (inputT.hasNext()) { // while there is more to read 
					inputT.next(); 
					record = new CommissionEmployee(inputT.next(), inputT.next(), inputT.next(), true, 
							inputT.nextDouble(), inputT.nextDouble()); 
					inputT.nextDouble(); 
					System.out.println("record=" + record); 
				
					addNprocessEveryNewRecord(record); 
				} // end while 1 
			}else {// FileStreamType_MenuOption.BYTE_BASED 
				for (int i = 0; i < EmployeeNo; i++) { 
					record = (CommissionEmployee) inputO.readObject(); 
					record = new CommissionEmployee(record.getFirstName(), record.getLastName(), 
							record.getSocialSecurityNumber(), frameEmployee.isSimpleFprmat, record.getGrossSales(), 
							record.getCommissionRate()); 
					addNprocessEveryNewRecord(record); 
					}// end for 
				} // end else 
			}//end outer if 

	fileChoosing4WriteOrRead.closeFile();// MAKE SURE to Close File Opened. 

	}
}// end class He1per4CommissionEmployee
