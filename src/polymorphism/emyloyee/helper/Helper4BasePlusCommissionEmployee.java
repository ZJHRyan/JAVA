package polymorphism.emyloyee.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import library.enummenu.FileStreamType_MenuOption;
import library.enummenu.NumberType_MenuOption;
import polymorphism.employee.frame.BasePlusCommissionEmployeeJFrame;
import polymorphism.employee.frame.CommissionEmployJFame;
import polymorphism.employee.menuoption.EmployeeRecordIndices;
import polymorphism.emyloyee.BasePlusCommissionEmployee;
import polymorphism.emyloyee.CommissionEmployee;

public class Helper4BasePlusCommissionEmployee extends Helper4CommissionEmployee {

	public Helper4BasePlusCommissionEmployee( BasePlusCommissionEmployeeJFrame compoent) {
		super(compoent);
		frameEmployee= compoent;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void checkInputRecordData() {
		super.checkInputRecordData();
//		if (checkRecord) {
//			checkRecord = validationNumber_GUI.checkNumberValueByComparing_1flag(
//					((CommissionEmployJFame) frameEmployee).txtFieldGrossSales.getText(),
//					EmployeeRecordIndices.GROSS_SALES.getRecordIndexType(), 0, 1,
//					NumberType_MenuOption.DOUBLE_NUMBER_TYPE.getValueIndex());
//
//			if (!checkRecord)
//				((CommissionEmployJFame) frameEmployee).txtFieldGrossSales.setText("");
//		}
		if (checkRecord) {
			checkRecord = validationNumber_GUI.checkNumberValueInRange_min0P1max0N1(

					((CommissionEmployJFame) frameEmployee).txtFieldCommisssionRate.getText(),
					EmployeeRecordIndices.COMMISSION_RATE.getRecordIndexType(), 8.0, 1.0,
					NumberType_MenuOption.DOUBLE_NUMBER_TYPE.getValueIndex());
			if (!checkRecord)
				((CommissionEmployJFame) frameEmployee).txtFieldCommisssionRate.setText("");
		}
		// finally-> if everything is ready--> get all input data from Record-area
//		if (checkRecord) {
//			_SSN = frameEmployee.txtFieldSSN.getText();
//			_firstName = frameEmployee.txtFieldFN.getText();
//			_lastName = frameEmployee.txtFieldLN.getText();
//			_grossSales = Double.parseDouble(((CommissionEmployJFame) frameEmployee).txtFieldGrossSales.getText());
//			_commissionRate = Double
//					.parseDouble(((CommissionEmployJFame) frameEmployee).txtFieldCommisssionRate.getText());
//		}
	}// end checkInputRecordData()
	public void getInputDataReady(boolean _checkRecord)
	{
		super.getInputDataReady(_checkRecord);
//		_grossSales = Double.parseDouble(((CommissionEmployJFame) frameEmployee).txtFieldGrossSales.getText());
//		_commissionRate = Double
//				.parseDouble(((CommissionEmployJFame) frameEmployee).txtFieldCommisssionRate.getText());
		_baseSalary = Double
				.parseDouble(((CommissionEmployJFame) frameEmployee).txtFieldCommisssionRate.getText());
		
	}
	@Override 
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
	@Override 
	public Object[][] returnObjectArray(){ 
		Object[][] data = new Object[eList_BasePlusCommission.size()][frameEmployee.listTitleName4Table.size()]; 
		
		for (int i = 0; i < eList_BasePlusCommission.size(); i++) { 
			Object[] object = { eList_BasePlusCommission.get(i).getSocialSecurityNumber(), 
					eList_BasePlusCommission.get(i).getFirstName(), 
					eList_BasePlusCommission.get(i).getLastName(), 
					eList_BasePlusCommission.get(i).getGrossSales(), 
					eList_BasePlusCommission.get(i).getCommissionRate(), 
					eList_BasePlusCommission.get(i).earnings(), 
					eList_BasePlusCommission.get(i).getLevel(), 
					eList_BasePlusCommission.get(i).getColor(),
					eList_BasePlusCommission.get(i).getBaseSalary()}; 
			
		
			data[i] = object; 
			} return data; 
		}// returnObjectArray(N 
	@Override
	public void readFile() throws NumberFormatException, ClassNotFoundException, NoSuchElementException, 
		NullPointerException, ClassCastException, IOException { 
		super.readFile(); 
	
//		CommissionEmployee record = null; 
//		if (isFileChoosenOK) { 
//			eList_Commission = new ArrayList<CommissionEmployee>(); 
//		
//			if (streamType_MenuOption == FileStreamType_MenuOption.STANDARD_BASED) { 
//				while (inputT.hasNext()) { // while there is more to read 
//					inputT.next(); 
//					record = new CommissionEmployee(inputT.next(), inputT.next(), inputT.next(), true, 
//							inputT.nextDouble(), inputT.nextDouble()); 
//					inputT.nextDouble(); 
//					System.out.println("record=" + record); 
//				
//					addNprocessEveryNewRecord(record); 
//				} // end while 1 
//			}else {// FileStreamType_MenuOption.BYTE_BASED 
//				for (int i = 0; i < EmployeeNo; i++) { 
//					record = (CommissionEmployee) inputO.readObject(); 
//					record = new CommissionEmployee(record.getFirstName(), record.getLastName(), 
//							record.getSocialSecurityNumber(), frameEmployee.isSimpleFprmat, record.getGrossSales(), 
//							record.getCommissionRate()); 
//					addNprocessEveryNewRecord(record); 
//					}// end for 
//				} // end else 
//			}//end outer if 
//
//	fileChoosing4WriteOrRead.closeFile();// MAKE SURE to Close File Opened. 

	}

	@Override 
	public void readRecordData() throws NumberFormatException, ClassNotFoundException, NoSuchElementException, 
		NullPointerException, ClassCastException, IOException { 
		super.readRecordData(); 
	
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

    closefile();// MAKE SURE to Close File Opened. 

	}

}
