package polymorphism.emyloyee.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.api.message.Message;

import Z.library.guidesign.FileChoosing4WriteOrRead_27Oct20_V2;
import Z.library.guidesign.FileChoosing4WriteOrRead_27Oct20_a0001;
import library.checkandvailidation_a0001.InputNumberValidation_GUI_CONSOLE;
import library.components.jtable.TableDialogEditDemoWithLevels2_bya001;
import library.components.jtable.app_extends.TableDialogEditDemo_newBya001_UsingExtends;
import library.enummenu.Btns4UniversalProcess_MenuOpAdv;
import library.enummenu.FileStreamType_MenuOption;
import library.enummenu.NumberType_MenuOption;
import library.filestream.Choice4FileStreamType;
import library.filestream.OpenFileRecord;
import orsonchart.PieChart3DFXDemo_a0001;
import library.filestream.*;
import polymorphism.emyloyee.earningBook.EmployeeBaseBook;
import polymorphism.employee.frame.EmployeeBaseJFrame;

import polymorphism.employee.menuoption.EarningLevelEnum;
import polymorphism.employee.menuoption.EmployeeRecordIndices;
import polymorphism.emyloyee.BasePlusCommissionEmployee;
import polymorphism.emyloyee.CommissionEmployee;
import polymorphism.emyloyee.Employee;
import polymorphism.emyloyee.HourlyEmployee;
import polymorphism.emyloyee.SalariedEmployee;

public class Helper4SuperEmployeeBase {
	// TODO Auto-generated constructor stub
	EmployeeBaseJFrame frameEmployee;

	public int EmployeeNo = 0;
	public String CompanyName = "";

	// initialize variables for grade record used in SuperEmployeeBase.
	String _SSN = "";
	String _firstName = "";
	String _lastName = "";

	// Commission Employee
	public double _grossSales = 0;
	public double _commissionRate = 0.0;

	public int employeeCounter = 0;
	public static DecimalFormat twoDigits = new DecimalFormat("0.00");

	protected boolean checkON = true;
//	protected InputNumberValidation validation_GUI = new InputNumberValidation(false, true);// OK 
	protected InputNumberValidation_GUI_CONSOLE validationNumber_GUI = new InputNumberValidation_GUI_CONSOLE(false,
			true);
	public boolean checkProfile = false;
	boolean checkRecord = false;;

	 EmployeeBaseJFrame empLoyeebaseJrame = null;
	// public EmployeeBaseBook employeeBook;//kept for reminder--> better not use
	// this one

	public String filePath = "./filePath";
	public FileChoosing4WriteOrRead_27Oct20_V2 fileChoosing4WriteOrRead;
	public ObjectOutputStream outputO;
	public Formatter outputT;
	protected ObjectInputStream inputO;
	protected Scanner inputT;
	public File fileWritten = null/* , fileRead = null */;

	String compannyString;
	String employeeNoString;
	public boolean isReadFile = false;
	static FileStreamType_MenuOption streamType_MenuOption = null;
	public boolean isJOptionPaneUsed = false;
	public boolean useSimpleOne = true;
	public JList<Object> listArea4RecordListArea;
	
//week14

//	protected PieChart2DMemoO pieChartDemo;// old one from last year 
	// protected PieChartDemo4Employee pieChartDemo4Employee;
	ArrayList<CommissionEmployee> eList_Commission = new ArrayList<CommissionEmployee>();
	ArrayList<BasePlusCommissionEmployee> eList_BasePlusCommission = new ArrayList<BasePlusCommissionEmployee>();
	ArrayList<SalariedEmployee> eList_Salaried = new ArrayList<SalariedEmployee>();// this is for creating
	ArrayList<HourlyEmployee> eList_Hourly = new ArrayList<HourlyEmployee>();// this is for creating file.

	// initialize variables for grade record used in SuperEmployeeBase.
	// Commission Employee

	public double _baseSalary = 0;
	// Salaried Employee
	public double _weekSalary = 0;
	// Hourly Employee
	public double _hourlyWage = 0.0;
	public double _rate4ExtraHours = 0.0;
	public double _hoursWorked = 0;
	public double _maxHoursPerWeek = 80.0;
	public double _min4rate0fExtraHours = 1.0;
	public double _max4rateOfExtraHours = 2.0;

	int PieChart2D_Typel = 0, PieChart2D_Type2 = 1, PieChart3D_Type3 = 2;
	int pieChartChoosen = PieChart2D_Typel;

//	static PieChart_MenuOption pieChartType_MenuOption = null; 

	protected boolean isFileChoosenOK = false;
	public boolean isCreateFile = false;
	public static boolean useJPane = true;

//week13

	public Helper4SuperEmployeeBase(EmployeeBaseJFrame _frmEmployee) {
		frameEmployee = _frmEmployee;
		//JOptionPane.showMessageDialog(null, "as");
		setUpNewStartUp4Buttons();
		//JOptionPane.showMessageDialog(null, "as");
		setupDistribution4WageLevels();
		//JOptionPane.showMessageDialog(null, "as");
	}// end class Helper4SuperEmployeeBase

	public void prepareBasicProfileUsingCheck() {

		checkProfile = validationNumber_GUI.checkStringNotEmpty(frameEmployee.txtFieldCN.getText(),
				EmployeeRecordIndices.COMPANY_NAME.getRecordIndexType());

		if (checkON)
			JOptionPane.showMessageDialog(null, "employee=" + frameEmployee.getClass());

		if (checkProfile) {
			CompanyName = validationNumber_GUI.stringInput;// obtain company name
			checkProfile = validationNumber_GUI.checkNumberValueByComparing_1flag(frameEmployee.txtFieldEN.getText(),
					EmployeeRecordIndices.EMPLOYEE_NO.getRecordIndexType(), 0, 1,
					NumberType_MenuOption.INT_NUMBER_TYPE.getValueIndex());
		}
		if (!checkProfile)
			frameEmployee.txtFieldEN.setText("");
		else {
			EmployeeNo = validationNumber_GUI.numberValue.intValue();// obtain number of employees
			frameEmployee.btnOpenFile.setEnabled(true);
		}

	}// prepareBaseProfileUsingCheck()

	public void enableProfileTextBoxs(boolean isEnable) {
		boolean condition = false;
		for (JTextField txtField : EmployeeBaseJFrame.listTxtFieLdsProfiLeG) {
			txtField.setEnabled(isEnable);
			condition = !isEnable;
		}

		for (JTextField txtField : frameEmployee.listTxtFieldsResultsG)
			txtField.setEnabled(!isEnable);
//		txtField.setEnabled(isEnable); 

		for (JTextField txtField : EmployeeBaseJFrame.listTxtFieLdsEmpLoyeeG)
			txtField.setEnabled(!isEnable);

		if (condition == true) //// ????if-else: need to confirm if there are something wrong..//
		{
//			frmEmployee.btnCalculate.setText(Button MenuOption.Process Data.name());

			frameEmployee.btnCalculate.setText(Btns4UniversalProcess_MenuOpAdv.Process_Data.getButtonType());
			frameEmployee.btnSetProfile.setEnabled(false);
		} else {
//			frmEmployee.btnCalculate.setText(Button_MenuOption.Process_Data.name()); 
			frameEmployee.btnCalculate.setText(Btns4UniversalProcess_MenuOpAdv.Process_Data.getButtonType());
			frameEmployee.btnSetProfile.setEnabled(true);// false
		}
	}// end enableProfileTextBoxs

	public void checkInputRecordData() {
		checkRecord = false;

		checkRecord = validationNumber_GUI.checkStringNotEmpty(frameEmployee.txtFieldSSN.getText(),
				EmployeeRecordIndices.SSN.getRecordIndexType());

		if (checkRecord) {
			checkRecord = validationNumber_GUI.checkStringNotEmpty(frameEmployee.txtFieldFN.getText(),
					EmployeeRecordIndices.FIRST_NAME.getRecordIndexType());
		}
		if (checkRecord) {
			checkRecord = validationNumber_GUI.checkStringNotEmpty(frameEmployee.txtFieldLN.getText(),
					EmployeeRecordIndices.LAST_NAME.getRecordIndexType());
		} // end checklnputRecordData
	}
	
	public void getInputDataReady(boolean _checkRecord) {
		if(_checkRecord) {
			_SSN = frameEmployee.txtFieldSSN.getText(); 
			_firstName = frameEmployee.txtFieldFN.getText(); 
			_lastName = frameEmployee.txtFieldLN.getText(); 
		}

		
	}

//week14	

	// boolean isTableDialogEditVersion Oracle = true;// if 'false'--> isSwin:Set2
	// beautyeye

	public void resetButtons4NewStart(boolean _isEnable) {
		for (int i = 0; i < frameEmployee.basicChoices.length; i++) {
			frameEmployee.optionButtons[i].setEnabled(_isEnable);
		}
	}

	public void setUpNewStartUp4Buttons() {
		resetButtons4NewStart(false);
		frameEmployee.btnSetProfile.setEnabled(true);
		frameEmployee.btnExit.setEnabled(true);
		frameEmployee.btnRefresh.setEnabled(true);
		frameEmployee.btnReadFile.setEnabled(true);
	}

	/**
	 * * Setup/layout distributions' labels/wordings for wage levels.
	 */

	public void setupDistribution4WageLevels() {
		try {
		frameEmployee.lblALowerThreshold.setText("" +EarningLevelEnum.LeveLA.getvalue());
		frameEmployee.lblBLowerThreshold.setText("" +EarningLevelEnum.LevelB.getvalue());
		frameEmployee.lblAUpperThreshold.setText("" + EarningLevelEnum.LeveLA.getvalue());
		frameEmployee.lblBUpperThreshold.setText("" + EarningLevelEnum.LevelB.getvalue());
		frameEmployee.lblUnit
				.setText("");// + EarningLevelEnum.UNIT.getLevelType() + "(" + EarningLevelEnum.UNIT.getvalue() + ")");
		}
		catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e.toString());
				}
	}
	public void writeRecord2RepotFileNdisplayCompleteRecord(Employee record) {
		if (!isReadFile) {
			addEverRecord2FileStream(record);
		}
//		frameEmployee.txtArea4RecordTextArea.setText(frameEmployee.employeeBaseBook);
//		frameEmployee.listModel.addElement(record.toString3());

	}

	public void addEverRecord2FileStream(Employee record) {
		if (streamType_MenuOption == FileStreamType_MenuOption.BYTE_BASED) {
			try {
				outputO.writeObject(record);
				outputO.flush();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "ssomething wrong with your record data", "no data was added file",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			outputT.format("%s", record);
		}

	}

	public void addRecord2CorrespondingArrayList(Employee record) {
		if (record instanceof SalariedEmployee) {
			eList_Salaried.add((SalariedEmployee) record);
		} else if (record instanceof HourlyEmployee) {
			eList_Hourly.add((HourlyEmployee) record);
		} else if (record instanceof BasePlusCommissionEmployee) {
			System.out.println("I am in basepluscommissionemploye");
			eList_BasePlusCommission.add((BasePlusCommissionEmployee) record);
		} else if (record instanceof CommissionEmployee) {
			eList_Commission.add((CommissionEmployee) record);
			System.out.println("i am in commissionEmpioyee");
		} else {
			System.out.println("add nothing");
		}

	}
	/**
	 * 1. firstly check if employee counter equal to employeeNo (ie.e all record
	 * needed have heen done with input
	 * 2.if true -->go to final phase
	 * 2.1)add whole records to JTable
	 * 2.2)show whole Gradebook results in form
	 * 2.3)write a log file and close all file opened.
	 * 2.3)reset all btn's conditions for new start 
	 */

	public void go2FinalPhaseIfDoneAllRecordsInput() {
		/**
		 * 1. firstly check if employee counter equal to employeeNo (ie.e all record
	     * needed have heen done with input
		 */
		if (employeeCounter == EmployeeNo) {
			JOptionPane.showMessageDialog(null, "all employees' records have done input");
			if (!isReadFile)
//				WriteLogFile(frameEmployee.employeeBaseBook);
				if (!isReadFile) {
					WriteLogFile(frameEmployee.employeeBaseBook);
					closefile();
				}
//			displayNcomleteEarningBookResults(frameEmployee.employeeBaseBook);
			resetButtons4NewStart(true);
			frameEmployee.btnOpenFile.setEnabled(false);
			frameEmployee.btnCalculate.setEnabled(false);
			/**
			 * 2.1)add whole records to JTable
			 */
			addWholeRecords2JTable();
			/**
			 * show whole Gradebook results in form
			 * (make sure the augment of 'frameEmployee.employeeBook' is used ,instead of 
			 * ')')
			 */
			/**
			 *  * 2.3)write a log file and close all file opened.
			 */
			
			displayNcomleteEarningBookResults(frameEmployee.employeeBaseBook);
			/**
			 * 2.3)reset all btn's conditions for new start 
			 * disable 'open file' and 'calculate'btns
			 */
			if (!isReadFile) {
				WriteLogFile(frameEmployee.employeeBaseBook);
				closefile();
			}
			resetButtons4NewStart(true);
			frameEmployee.btnOpenFile.setEnabled(false);
			frameEmployee.btnCalculate.setEnabled(false);

		}
	}
	/** 
	1<p>1. Successively display earning-book results on form-related areas. 
	* <p>2. after done the last record, then: 13 * <p> 
	* 2.1) complete final earning-book by calculating mean earnings of company * 
	* <p> 2.2) display mean earnings on form. * 
	* <p> 2.3) show whole-records, obtained from earning-book, in JtextArea * 
	* */
	public void displayNcomleteEarningBookResults(EmployeeBaseBook _employeBook) { 
	/**
	 * 1. Successively display earning-book results on form-related areas ( 
	 */
		if (employeeCounter != 0) { 

	 // below 3 need to confirm... 
			frameEmployee.txtFieldLA.setText("" + frameEmployee.employeeBaseBook.aLevel); 
			frameEmployee.txtFieldLB.setText("" + frameEmployee.employeeBaseBook.bLevel); 
			frameEmployee.txtFieldLC.setText("" + frameEmployee.employeeBaseBook.cLevel); 

			frameEmployee.txtFieldEmpCounter.setText(String.format("%d", _employeBook.employeeCounter)); 
			frameEmployee.txtFieldHighestE.setText(twoDigits.format(_employeBook.highestE)); 
			frameEmployee.txtFieldLowestE.setText(twoDigits.format(_employeBook.lowestE)); 
			/**
			 * 2. after done the last record, then: 
			 * 2.1)complete final earning -book by calculating mean
			 *     considered(also the categories distrubution will be produced in
			 *     employee-book
			 * 2.2)display mean earnings on form
			 */
			_employeBook.calculateAverageNproduceLevelArray();
			frameEmployee.txtArea4RecordTextArea.setText(twoDigits.format(_employeBook.mean));
		}
		else {
			JOptionPane.showMessageDialog(null, "nothing","No preset-profile or input",JOptionPane.ERROR_MESSAGE);
		}
	}//end displayNcompleteEarningBookResults 

	public void addWholeRecords2JTable() {
		frameEmployee.dataUsed=returnObjectArray();
//		TableDialogEditDemoWithLevels2_bya001 demoTable = new TableDialogEditDemoWithLevels2_bya001(
//				frameEmployee.table4RecordTableArea,frameEmployee.namesUsed);
		TableDialogEditDemo_newBya001_UsingExtends demoTable =new TableDialogEditDemo_newBya001_UsingExtends(
				frameEmployee.table4RecordTableArea,frameEmployee.namesUsed,frameEmployee.dataUsed);
		frameEmployee.tableAggregate =demoTable.scrollPane;
	}

	public void outputFinalReport() {
		frameEmployee.txtArea4RecordTextArea.setText(frameEmployee.employeeBaseBook.toString());
		frameEmployee.listArea4RecordListArea.setModel(frameEmployee.listModel);
		frameEmployee.addJTable2Box();
	}

	public void clearRecordTextFields() {
		for (JTextField textField : EmployeeBaseJFrame.listTxtFieLdsEmpLoyeeG)
			textField.setText("");

	}

	public void clearProfileAndResults() {
		for (JTextField textField : EmployeeBaseJFrame.listTxtFieLdsEmpLoyeeG)
			textField.setText("");

		for (JTextField textField : frameEmployee.listTxtFieLdsEmpLoyeeG)
			textField.setText("");
	}

	public void openFile(String _filePath) throws FileNotFoundException, NullPointerException, IOException {
		isReadFile = false;
		isCreateFile = true;
		employeeCounter = 0;
		JOptionPane.showMessageDialog(null, "This file writer is for log report.", "Write a text-based report",
				JOptionPane.INFORMATION_MESSAGE);
		fileWritten = OpenFileRecord.getfile(_filePath, useJPane);
		if (fileWritten != null) {
			OpenFileRecord.openFile(fileWritten);
		}
		if (OpenFileRecord.output != null) {
			// Below is for choosing Stream-type used for writing accounts' profile
			JOptionPane.showMessageDialog(null, "The next file writer choosed is for recording every account record.",
					"Write Account Records", JOptionPane.INFORMATION_MESSAGE);
			ImageIcon icon = new ImageIcon("./resources/image/write1.png");
			streamType_MenuOption = Choice4FileStreamType.decideWhichFileStreamType(icon, false);

			JOptionPane.showMessageDialog(null, streamType_MenuOption, "Stream-type Chosen",
					JOptionPane.INFORMATION_MESSAGE);
			if (streamType_MenuOption != null) {
				fileChoosing4WriteOrRead = new FileChoosing4WriteOrRead_27Oct20_V2(true, false,
						streamType_MenuOption.getValue());
//				fileChoosing4WriteOrRead.chooseFile(_filePath);
				fileChoosing4WriteOrRead.chooseFile(_filePath, "Read file");
				fileChoosing4WriteOrRead.openFile2Read(streamType_MenuOption.getOptionType());
				if (fileChoosing4WriteOrRead.result == JFileChooser.APPROVE_OPTION) {
					fileChoosing4WriteOrRead.openFile2Read(streamType_MenuOption.getOptionType());
					String compannyString = String.format("%s\t%s\n", "Company", CompanyName);
					String employeeNoString = String.format("%s\t%s", "EmployeeNo", EmployeeNo);
					if (streamType_MenuOption == FileStreamType_MenuOption.BYTE_BASED
							|| streamType_MenuOption == FileStreamType_MenuOption.STANDARD_BASED) {
						outputO = fileChoosing4WriteOrRead.outputO;// here output has been implemented and not 'null'

						outputO.writeObject(compannyString);
						outputO.writeObject(employeeNoString);
					} else {
						outputT = fileChoosing4WriteOrRead.outputT;// here output has been implemented and not 'null'

						outputT.format(compannyString);
						outputT.format(employeeNoString);
					}
					frameEmployee.btnOpenFile.setEnabled(false);// New one
					frameEmployee.btnCalculate.setEnabled(true);// New one
					frameEmployee.btnClearRecord.setEnabled(true);
				}
			} else
				JOptionPane.showMessageDialog(null, "you just cancel the action!");
		} // end if (OpenFileRecord.output != null)
	}// end openFile


	public void closefile() {
		OpenFileRecord.closeFile();
		fileChoosing4WriteOrRead.closeFile();
		isFileChoosenOK=false;

	}

	public void readRecordData() throws ClassNotFoundException, IOException, NoSuchElementException, NullPointerException,
			/* NumberFormatException */ IllegalArgumentException, ClassCastException, ArrayIndexOutOfBoundsException {

		isReadFile = true;
		boolean isFileNeeded = false;

		if (frameEmployee.ifPreviewing) {

			JOptionPane.showMessageDialog(null, "This file reader is for previewing log report.",
					"Read a text-based log report", JOptionPane.INFORMATION_MESSAGE);
			isFileNeeded = OpenFileRecord.readFile2PreviewContent4ContinueOrNot(frameEmployee.txtArea4RecordTextArea,
					filePath, useSimpleOne);

			if (isFileNeeded)
				readFile_EmployeeAccount();
		} else {// just directly read account file without previewing file for confirmation.
			readFile_EmployeeAccount();
		}
	}// end readFile

	public void readFile_EmployeeAccount() throws ClassNotFoundException, IOException, ArrayIndexOutOfBoundsException {
		JOptionPane.showMessageDialog(null, "This file reader- choosen is for reading every account record.",
				"Read Account Records", JOptionPane.INFORMATION_MESSAGE);
		ImageIcon icon = new ImageIcon("./-esources//images/qustion_message_120x120.png");

		streamType_MenuOption = Choice4FileStreamType.decideWhichFileStreamType(icon, isJOptionPaneUsed);

		if (streamType_MenuOption != null) {

			fileChoosing4WriteOrRead = new FileChoosing4WriteOrRead_27Oct20_V2(false, true,
					streamType_MenuOption.getValue());
			fileChoosing4WriteOrRead.chooseFile(filePath,"create file");
			fileChoosing4WriteOrRead.openFile2Read(streamType_MenuOption.getOptionType());

			if (streamType_MenuOption == FileStreamType_MenuOption.BYTE_BASED) {
				inputO = fileChoosing4WriteOrRead.inputO;
				// Read basic profile into file
				compannyString = ((ObjectInput) inputO).readObject().toString();
				employeeNoString = ((ObjectInput) inputO).readObject().toString();
			} else {
				inputT = fileChoosing4WriteOrRead.inputT;// Here input has been implemented and not 'null'
				// Read basic profile into file
				compannyString = inputT.toString();
				employeeNoString = inputT.toString();
			}
			advancedlyProcessBasics();
			if (fileChoosing4WriteOrRead.result == JFileChooser.APPROVE_OPTION) {
				System.out.println("file shosen for read is succesfully opend!");
				
			}
		}else
			JOptionPane.showMessageDialog(null, "you just cancel the action!");
		
	}// end readFile EmploveeAccount()

	public void advancedlyProcessBasics() throws ArrayIndexOutOfBoundsException {
		String[] arrOfStr = compannyString.split("\t");
		CompanyName = arrOfStr[1];
		frameEmployee.txtFieldCN.setText(CompanyName);
		frameEmployee.txtFieldCN.setEditable(false);

		arrOfStr = employeeNoString.split("\t");
		EmployeeNo = Integer.parseInt(arrOfStr[1]);
		frameEmployee.txtFieldEN.setText(arrOfStr[1]);
		frameEmployee.txtFieldEN.setEditable(false);

		JOptionPane.showMessageDialog(null, "CompanyName=" + CompanyName + "\nEmployeeNo=" + EmployeeNo);

		frameEmployee.employeeBaseBook = frameEmployee.setBasics2StartBookingEmployee();// initialize a new employeeBook
																						// for
		// frameEmployee considered.
		employeeCounter = 0;// reset to zero
	}

	public void refreshJFrame() {
		if (frameEmployee != null) {
			frameEmployee.dispose();
			frameEmployee = frameEmployee.refreshJFrame();
		} else {
			JOptionPane.showMessageDialog(null, "you haven't srarted anything yet", "start input data first",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public static File geFile(String _filePath, boolean _useJPane) throws FileNotFoundException {
		useJPane = _useJPane;
		JFileChooser fileChooser = new JFileChooser(_filePath);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showOpenDialog(null);

		File FileName;
		if (result == JFileChooser.APPROVE_OPTION) {
			FileName = fileChooser.getSelectedFile().getAbsoluteFile();
		} else {// if user clicked Cancel button on dialog, return

			JOptionPane.showMessageDialog(null, "You just made:\r\n 'CANCEL_ or ERROR_ OPTION'!",
					"No file Chosen. Are you sure?", JOptionPane.INFORMATION_MESSAGE);
//    		System.exit(1); 
			return null;
		}
		return FileName;
	}// End getf4e

	public void exitAppInQuestion() {
		frameEmployee.dispose();

	}

	public String tosString() {
		return frameEmployee.employeeBaseBook.toString();

	}
	public static void runPieChart3DFX() {
		PieChart3DFXDemo_a0001.categories=new String[3];
    	PieChart3DFXDemo_a0001.categories=Stream.of(
    			EarningLevelEnum.LeveLA.getLevelType(),EarningLevelEnum.LevelB.getLevelType(),
    			EarningLevelEnum.LeveLC.getLevelType()).toArray(String[]::new);
    	PieChart3DFXDemo_a0001.valuse4categories=new double[PieChart3DFXDemo_a0001.categories.length];
    	
    	PieChart3DFXDemo_a0001.valuse4categories[0]=frameEmployee.employeeBaseBook.levelsV[0];
    	PieChart3DFXDemo_a0001.valuse4categories[1]=frameEmployee.employeeBaseBook.levelsV[1];
    	PieChart3DFXDemo_a0001.valuse4categories[2]=frameEmployee.employeeBaseBook.levelsV[2];
    	
    	PieChart3DFXDemo_a0001.title2Display="Grade_distribution";
        PieChart3DFXDemo_a0001.Launchmore(PieChart3DFXDemo_a0001.class);
   
	}
// Week15
	/** 
	 * * <p> 
	 * * three things are needed to be done in overridden method in inherited class 
	 * * <p> 
	 * * 1) check and validate input data (record) 
	 * * <p> 
	 * * checkInputRecordData() 
	 * * <p> 
	 * * 2) initialize every record after checked and validated 
	 * * <p> x 
	 * 3) add and process every new validated record, 
	 * <p> 
	 * addNprocessEveryNewRecord(Employee record) 
	*/
	public void addNprocessEveryNewRecord(Employee record) { 
		employeeCounter += 1; 
	/** 
	* 
	* 1. add every raw record to employee-book and further process and complete * Every Salary/record Profile 
	*/ 
	frameEmployee.employeeBaseBook.processEverySalaryProfie(record); 
	JOptionPane.showMessageDialog(null, "Employee: " + employeeCounter + ":\n" + record.toString2());
	/**
	 * 2.add/write wvwry record to report/file and show processed results
	 */
	writeRecord2ReportFileNdisplayCompleteRecord(record);
	/**
	 * 3.add every record to its correspponding arraylist
	 */
	addRecord2CorrespondingArrayList(record);
	/**
	 * 4.go final phase after confirmed all data have been input correctly
	 * 4.1)check if all record needed have been done with input
	 * 4.2)if true then go to final phase to both display whole results and reset
	 * all conditions for new start 
	 */
	go2FinalPhaseIfDoneAllRecordsInput();
	} 
	/**  
	 * * <p> 1. output/write every record into file-stream. 
	 * * <p> 2. display/set concatenated records to areas considered; and finally  * 
	 * <p> 3. set every formatted record to output RecordListArea * 
	 * grade book form
	 * <p> 4. display/show total processed results to a record-results area in the 
	 * 5.set tatal student number(already processed) in JTextField considered
	* * @param record 
	* * @throws I0Exception 
	*/ 
	public void writeRecord2ReportFileNdisplayCompleteRecord(Employee record) 
	{ 
		/**
		 * 1.add every record into file_stream
		 */
		if (!isReadFile) {
			addEverRecord2FileStream(record);
		}
		/**
		 * 2. display/set concatented records to text-area considered(JtextArea)
		 */
		frameEmployee.txtArea4RecordTextArea.setText(frameEmployee.employeeBaseBook.recordsConcatenated);
		/**
		 * 3.set every formated record to output RecordListArea(Jlist)
		 */
		frameEmployee.listModel.addElement(record.toString3());
		/**
		 * 4.display record results to a record-results area in the grade book form
		 * (including earnings and employeeCounter)
		 */
		if (!isReadFile) {
			frameEmployee.txtFieldEarnings.setText(twoDigits.format(record.earnings()));
		}
		/**
		 * 5.set tatal student number(already processed) in JTextField considered
		 */
		frameEmployee.txtFieldEmpCounter.setText(String.format("%d", employeeCounter));
	}//end writeRecord2ReportFileNdisplayCompleteRecord 
	public void addEveryRecord2FileStream(Employee record) { 
		// output record and flush buffer 
		if (streamType_MenuOption == FileStreamType_MenuOption.BYTE_BASED) { 
			try { 
				outputO.writeObject(record); 
				outputO.flush(); 
				} catch (IOException e) { 
					e.printStackTrace(); 
					JOptionPane.showMessageDialog(null, "Something wrong with your record data!", 
							"No data was added into file", JOptionPane.ERROR_MESSAGE); 
		}
		 } else { 
			 outputT.format("%s", record); 
		 }

	}
	public void WriteLogFile(EmployeeBaseBook _employeBook) {
		if (fileWritten != null && OpenFileRecord.output != null) {
			OpenFileRecord.output.format(frameEmployee.employeeBaseBook.toString()); 
		}else JOptionPane.showMessageDialog(null, "No file was choosen!", "Choose a file FIRST.",
				JOptionPane.INFORMATION_MESSAGE); 
		return;
	 
	}//end WriteLogFile 

	public Object[][] returnObjectArray() {
		return null;
		
	}
}// end class Helper4SuperEmployeeBase
