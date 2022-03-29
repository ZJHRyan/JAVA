package polymorphism.employee.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import library.enummenu.Btns4UniversalProcess_MenuOpAdv;
import polymorphism.employee.menuoption.EmployeeRecordIndices;

import javax.swing.Box;

public class EmployeeBaseJFrane_v3 extends JFrame {

	public JPanel contentPane;
	public JTextField txtFieldCN;
	public JTextField txtFieldEN;
	public JTextField txtFieldEarnings;
	public JTextField txtFieldSSN;
	public JTextField txtFieldFN;
	public JTextField txtFieldLN;
	public JTextField txtFieldEmpCounter;
	public JTextField txtFieldHighestE;
	public JTextField txtFieldLowestE;
	public JTextField txtFieldAverageE;
	public JTextField txtFieldLA;
	public JTextField txtFieldLB;
	public JTextField txtFieldLC;
	public JButton btnSetProfile;
	public JButton btnClearProfile;
	public JLabel lblCompanyName;
	public JLabel lblTotalEmployees;
	public JLabel lblEarnings;
	public JButton btnClearRecord;
	public JLabel lblSSN;
	public JLabel lblFirstName;
	public JLabel lblLastName;
	public JLabel lblEmpCounter;
	public JLabel lblHighestEarnings;
	public JLabel lblLowestEarnings;
	public JLabel lblAverageEarnings;
	public JLabel lblAlevel;
	public JLabel lblBlevel;
	public JLabel lblClevel;
	public JLabel lblUnit;
	public JLabel lblUnitSymbol;
	public JButton btnRefresh;
	public JButton btnPieChartDemo;
	public JButton btnOutputAll;
	public JButton btnCalculate;
	public JButton btnOpenFile;
	public JButton btnWriteFile;
	public JButton btnReadFile;
	public JButton btnCloseFile;
	public JButton btnExit;
	public JLabel lblResultArea;
	public JSeparator separatorResultTop;
	public JSeparator separatorResultBottom;
	public JSeparator separator_1;
	public JLabel lblRange;
	public JLabel lblCUpperThreshold;
	public JLabel lblDistribution;
	public JSeparator separator;
	public JSeparator separator_2;
	public JLabel lblBUpperThreshold;
	public JLabel lblALowerThreshold;
	public JLabel lblBLowerThreshold;

	public static String employeeType;
	
	JTabbedPane tabbedPane;
	public String title4InputArea="Main Frame Area", tip4InputArea="Input and Calculate"; //i.e. JPanel (contentPane) 
	public String title4TextArea="Report Output Area", tip4TextArea="Output Final Report"; 
	public String title4JList="Record List Area", tip4JList="Output Record List";
	public String title4JTable="Record Output Table", tip4JTable="Output Records to Table"; 
	
	public JTextArea txtArea4RecordTextArea; 
	public JList<Object> listArea4RecordListArea; 
	public JTable table4RecordTableArea; 
	public Box box1, box2, box3; 
	//public DefaultListModel<Object> listModel = new DefaultListModel<Object>();
	//need to figure out later //https://stackoverflow.com/questions/5212983/jlist-add-remove-item 
	
	public JButton[] optionButtons;
	public Btns4UniversalProcess_MenuOpAdv[] basicChoices= {
			Btns4UniversalProcess_MenuOpAdv.Process_Data,
			Btns4UniversalProcess_MenuOpAdv.Refresh,
			Btns4UniversalProcess_MenuOpAdv.Clear_Record,
			Btns4UniversalProcess_MenuOpAdv.Set_ProfiLe,
			Btns4UniversalProcess_MenuOpAdv.CLear_ProfiLe_and_ResuLts,
			Btns4UniversalProcess_MenuOpAdv.Output_ResuLts,
			Btns4UniversalProcess_MenuOpAdv.Exit,
			Btns4UniversalProcess_MenuOpAdv.OpenFiLe,
			Btns4UniversalProcess_MenuOpAdv.ReadFiLe,
			Btns4UniversalProcess_MenuOpAdv.WriteFiLe,
			Btns4UniversalProcess_MenuOpAdv.CLoseFiLe,
			Btns4UniversalProcess_MenuOpAdv.PieChartDemo
	};

	
	
	public static List<JTextField> listTxtFieLdsProfiLeG= new LinkedList<>(); 
	public static List<JTextField> listTxtFieLdsEmpLoyeeG= new LinkedList<>(); 
	public List<JTextField> listTxtFieldsResultsG= new LinkedList<>(); 
	public List<String> listTitleName4Table = new LinkedList<>(); 
	public String[] namesUsed; 
	
	public JScrollPane tableAggregate;
	
	public static void main(String[] args) {
		employeeType = "SuperBase Emplyee (by RyanZa107230001)";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeBaseJFrane_v3 frame = new EmployeeBaseJFrane_v3(employeeType);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeBaseJFrane_v3(String employeeType) {
		setTitle("Employee-Book Application("+employeeType+")");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 787);

//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		
		createAndSetupCoreComponents4JTabbedPane();
		
		setupComponent4JPanel();//%100 needed
		
		initializeButtonArray(); 
		initializeTextFieldArrayList(); 
		initializeTitleNamesList4JTable(); 
		initialize4TitleNamesString4JTable(); 
		

	}
	protected void setupComponent4JPanel()//%100 needed
	{
		lblTotalEmployees = new JLabel("Total Employees:");
		lblTotalEmployees.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalEmployees.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTotalEmployees.setBounds(446, 124, 104, 15);
		contentPane.add(lblTotalEmployees);

		lblCompanyName = new JLabel("Company:");
		lblCompanyName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompanyName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCompanyName.setBounds(30, 117, 69, 29);
		contentPane.add(lblCompanyName);

		txtFieldCN = new JTextField();
		txtFieldCN.setColumns(10);
		txtFieldCN.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldCN.setBounds(109, 128, 131, 21);
		contentPane.add(txtFieldCN);

		txtFieldEN = new JTextField();
		txtFieldEN.setColumns(10);
		txtFieldEN.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldEN.setBounds(560, 125, 96, 21);
		contentPane.add(txtFieldEN);

		separator = new JSeparator();
		separator.setOpaque(true);
		separator.setForeground(Color.GREEN);
		separator.setBounds(new Rectangle(7, 7, 16, 16));
		separator.setBackground(new Color(75, 0, 130));
		separator.setBounds(30, 183, 626, 2);
		contentPane.add(separator);

		lblEarnings = new JLabel("Earnings:");
		lblEarnings.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblEarnings.setOpaque(true);
		lblEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEarnings.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblEarnings.setBackground(new Color(250, 250, 210));
		lblEarnings.setBounds(30, 215, 69, 29);
		contentPane.add(lblEarnings);

		txtFieldEarnings = new JTextField();
		txtFieldEarnings.setColumns(10);
		txtFieldEarnings.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldEarnings.setBounds(109, 219, 96, 21);
		contentPane.add(txtFieldEarnings);

		lblSSN = new JLabel("SSN:");
		lblSSN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSSN.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSSN.setBounds(30, 294, 69, 29);
		contentPane.add(lblSSN);

		txtFieldSSN = new JTextField();
		txtFieldSSN.setColumns(10);
		txtFieldSSN.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldSSN.setBounds(109, 298, 96, 21);
		contentPane.add(txtFieldSSN);

		lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblFirstName.setBounds(30, 324, 69, 29);
		contentPane.add(lblFirstName);

		txtFieldFN = new JTextField();
		txtFieldFN.setColumns(10);
		txtFieldFN.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldFN.setBounds(109, 328, 96, 21);
		contentPane.add(txtFieldFN);

		lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLastName.setBounds(30, 359, 69, 29);
		contentPane.add(lblLastName);

		txtFieldLN = new JTextField();
		txtFieldLN.setColumns(10);
		txtFieldLN.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldLN.setBounds(109, 363, 96, 21);
		contentPane.add(txtFieldLN);

		lblEmpCounter = new JLabel("Employee Counter:");
		lblEmpCounter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpCounter.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEmpCounter.setBounds(446, 257, 104, 29);
		contentPane.add(lblEmpCounter);

		txtFieldEmpCounter = new JTextField();
		txtFieldEmpCounter.setEditable(false);
		txtFieldEmpCounter.setColumns(10);
		txtFieldEmpCounter.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldEmpCounter.setBounds(560, 261, 96, 21);
		contentPane.add(txtFieldEmpCounter);

		lblHighestEarnings = new JLabel("Highest Earnings:");
		lblHighestEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHighestEarnings.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblHighestEarnings.setBounds(446, 291, 104, 29);
		contentPane.add(lblHighestEarnings);

		txtFieldHighestE = new JTextField();
		txtFieldHighestE.setEditable(false);
		txtFieldHighestE.setColumns(10);
		txtFieldHighestE.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldHighestE.setBounds(560, 295, 96, 21);
		contentPane.add(txtFieldHighestE);

		lblLowestEarnings = new JLabel("Lowest Earnings:");
		lblLowestEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLowestEarnings.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLowestEarnings.setBounds(446, 324, 104, 29);
		contentPane.add(lblLowestEarnings);

		txtFieldLowestE = new JTextField();
		txtFieldLowestE.setEditable(false);
		txtFieldLowestE.setColumns(10);
		txtFieldLowestE.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldLowestE.setBounds(560, 328, 96, 21);
		contentPane.add(txtFieldLowestE);

		txtFieldAverageE = new JTextField();
		txtFieldAverageE.setEditable(false);
		txtFieldAverageE.setColumns(10);
		txtFieldAverageE.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldAverageE.setBounds(560, 363, 96, 21);
		contentPane.add(txtFieldAverageE);

		lblAverageEarnings = new JLabel("Average Earnings:");
		lblAverageEarnings.setHorizontalTextPosition(SwingConstants.LEFT);
		lblAverageEarnings.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAverageEarnings.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAverageEarnings.setBounds(446, 359, 104, 29);
		contentPane.add(lblAverageEarnings);

		separator_1 = new JSeparator();
		separator_1.setOpaque(true);
		separator_1.setForeground(Color.GREEN);
		separator_1.setBounds(new Rectangle(7, 7, 16, 16));
		separator_1.setBackground(new Color(75, 0, 130));
		separator_1.setBounds(30, 460, 626, 2);
		contentPane.add(separator_1);

		lblDistribution = new JLabel("Distribution of Wage-Levels");
		lblDistribution.setOpaque(true);
		lblDistribution.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistribution.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblDistribution.setBounds(new Rectangle(2, 2, 2, 2));
		lblDistribution.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 0), null, null, null));
		lblDistribution.setBackground(new Color(175, 238, 238));
		lblDistribution.setBounds(30, 475, 626, 29);
		contentPane.add(lblDistribution);

		lblAlevel = new JLabel("A_Level  >=");
		lblAlevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlevel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAlevel.setBounds(239, 514, 69, 29);
		contentPane.add(lblAlevel);

		txtFieldLA = new JTextField();
		txtFieldLA.setEditable(false);
		txtFieldLA.setColumns(10);
		txtFieldLA.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldLA.setBackground(new Color(255, 228, 225));
		txtFieldLA.setBounds(506, 518, 96, 21);
		contentPane.add(txtFieldLA);

		lblBlevel = new JLabel("B_Level    =");
		lblBlevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBlevel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblBlevel.setBounds(239, 553, 69, 29);
		contentPane.add(lblBlevel);

		txtFieldLB = new JTextField();
		txtFieldLB.setEditable(false);
		txtFieldLB.setColumns(10);
		txtFieldLB.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldLB.setBackground(new Color(255, 228, 225));
		txtFieldLB.setBounds(506, 557, 96, 21);
		contentPane.add(txtFieldLB);

		lblClevel = new JLabel("C_Level <=");
		lblClevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClevel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblClevel.setBounds(239, 586, 69, 29);
		contentPane.add(lblClevel);

		txtFieldLC = new JTextField();
		txtFieldLC.setEditable(false);
		txtFieldLC.setColumns(10);
		txtFieldLC.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 175, 175), null, null, null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), null, null, null)));
		txtFieldLC.setBackground(new Color(255, 228, 225));
		txtFieldLC.setBounds(506, 590, 96, 21);
		contentPane.add(txtFieldLC);

		lblALowerThreshold = new JLabel("");
		lblALowerThreshold.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblALowerThreshold.setOpaque(true);
		lblALowerThreshold.setHorizontalAlignment(SwingConstants.CENTER);
		lblALowerThreshold.setForeground(Color.BLACK);
		lblALowerThreshold.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblALowerThreshold.setBackground(new Color(250, 250, 210));
		lblALowerThreshold.setBounds(345, 514, 119, 29);
		contentPane.add(lblALowerThreshold);

		lblBLowerThreshold = new JLabel("");
		lblBLowerThreshold.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblBLowerThreshold.setOpaque(true);
		lblBLowerThreshold.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBLowerThreshold.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblBLowerThreshold.setBackground(new Color(250, 250, 210));
		lblBLowerThreshold.setBounds(345, 551, 33, 29);
		contentPane.add(lblBLowerThreshold);

		lblCUpperThreshold = new JLabel("");
		lblCUpperThreshold.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblCUpperThreshold.setOpaque(true);
		lblCUpperThreshold.setHorizontalAlignment(SwingConstants.CENTER);
		lblCUpperThreshold.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCUpperThreshold.setBackground(new Color(250, 250, 210));
		lblCUpperThreshold.setBounds(345, 586, 119, 29);
		contentPane.add(lblCUpperThreshold);

		lblBUpperThreshold = new JLabel("");
		lblBUpperThreshold.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblBUpperThreshold.setOpaque(true);
		lblBUpperThreshold.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBUpperThreshold.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblBUpperThreshold.setBackground(new Color(250, 250, 210));
		lblBUpperThreshold.setBounds(431, 551, 33, 29);
		contentPane.add(lblBUpperThreshold);

		lblRange = new JLabel("~");
		lblRange.setOpaque(true);
		lblRange.setHorizontalAlignment(SwingConstants.CENTER);
		lblRange.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblRange.setBackground(new Color(250, 250, 210));
		lblRange.setBounds(388, 551, 33, 29);
		contentPane.add(lblRange);

		lblUnitSymbol = new JLabel("Unit:");
		lblUnitSymbol.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnitSymbol.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUnitSymbol.setBounds(47, 551, 43, 33);
		contentPane.add(lblUnitSymbol);

		separator_2 = new JSeparator();
		separator_2.setOpaque(true);
		separator_2.setForeground(Color.GREEN);
		separator_2.setBounds(new Rectangle(7, 7, 16, 16));
		separator_2.setBackground(new Color(75, 0, 130));
		separator_2.setBounds(30, 625, 626, 2);
		contentPane.add(separator_2);

		btnCalculate = new JButton("Calculate");
		btnCalculate.setForeground(Color.BLACK);
		btnCalculate.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnCalculate.setBackground(new Color(135, 206, 250));
		btnCalculate.setBounds(30, 652, 96, 30);
		contentPane.add(btnCalculate);

		btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(Color.BLACK);
		btnRefresh.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnRefresh.setBackground(new Color(135, 206, 250));
		btnRefresh.setBounds(560, 652, 96, 30);
		contentPane.add(btnRefresh);

		btnOutputAll = new JButton("Output to TextArea");
		btnOutputAll.setForeground(Color.BLACK);
		btnOutputAll.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnOutputAll.setBackground(new Color(135, 206, 250));
		btnOutputAll.setBounds(162, 652, 167, 30);
		contentPane.add(btnOutputAll);

		btnOpenFile = new JButton("Open File");
		btnOpenFile.setForeground(Color.BLACK);
		btnOpenFile.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnOpenFile.setBackground(new Color(135, 206, 250));
		btnOpenFile.setBounds(30, 706, 96, 30);
		contentPane.add(btnOpenFile);

		btnWriteFile = new JButton("Write File");
		btnWriteFile.setForeground(Color.BLACK);
		btnWriteFile.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnWriteFile.setBackground(new Color(135, 206, 250));
		btnWriteFile.setBounds(162, 706, 96, 30);
		contentPane.add(btnWriteFile);

		btnReadFile = new JButton("Read File");
		btnReadFile.setForeground(Color.BLACK);
		btnReadFile.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnReadFile.setBackground(new Color(135, 206, 250));
		btnReadFile.setBounds(297, 706, 96, 30);
		contentPane.add(btnReadFile);

		btnCloseFile = new JButton("Close File");
		btnCloseFile.setForeground(Color.BLACK);
		btnCloseFile.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnCloseFile.setBackground(new Color(135, 206, 250));
		btnCloseFile.setBounds(429, 706, 96, 30);
		contentPane.add(btnCloseFile);

		btnPieChartDemo = new JButton("Pie-Chart Demo");
		btnPieChartDemo.setForeground(Color.BLACK);
		btnPieChartDemo.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnPieChartDemo.setBackground(new Color(135, 206, 250));
		btnPieChartDemo.setBounds(367, 652, 158, 30);
		contentPane.add(btnPieChartDemo);

		btnExit = new JButton("Exit");
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnExit.setBackground(new Color(135, 206, 250));
		btnExit.setBounds(560, 706, 96, 30);
		contentPane.add(btnExit);

		btnClearRecord = new JButton("Clear Record");
		btnClearRecord.setForeground(Color.BLACK);
		btnClearRecord.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnClearRecord.setBackground(new Color(135, 206, 250));
		btnClearRecord.setBounds(215, 219, 127, 30);
		contentPane.add(btnClearRecord);

		lblResultArea = new JLabel("Results Area");
		lblResultArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultArea.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblResultArea.setBounds(446, 218, 210, 29);
		contentPane.add(lblResultArea);

		separatorResultTop = new JSeparator();
		separatorResultTop.setOrientation(SwingConstants.VERTICAL);
		separatorResultTop.setOpaque(true);
		separatorResultTop.setForeground(Color.GREEN);
		separatorResultTop.setBounds(new Rectangle(7, 7, 16, 16));
		separatorResultTop.setBackground(new Color(75, 0, 130));
		separatorResultTop.setBounds(446, 215, 210, 3);
		contentPane.add(separatorResultTop);

		separatorResultBottom = new JSeparator();
		separatorResultBottom.setOrientation(SwingConstants.VERTICAL);
		separatorResultBottom.setOpaque(true);
		separatorResultBottom.setForeground(Color.GREEN);
		separatorResultBottom.setBounds(new Rectangle(7, 7, 16, 16));
		separatorResultBottom.setBackground(new Color(75, 0, 130));
		separatorResultBottom.setBounds(446, 252, 210, 3);
		contentPane.add(separatorResultBottom);

		btnSetProfile = new JButton("Set Profile");
		btnSetProfile.setForeground(Color.BLACK);
		btnSetProfile.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnSetProfile.setBackground(new Color(135, 206, 250));
		btnSetProfile.setBounds(30, 72, 210, 30);
		contentPane.add(btnSetProfile);

		btnClearProfile = new JButton("Clear Profile/Results");
		btnClearProfile.setForeground(Color.BLACK);
		btnClearProfile.setFont(new Font("Yu Gothic Light", Font.BOLD, 12));
		btnClearProfile.setBackground(new Color(135, 206, 250));
		btnClearProfile.setBounds(446, 72, 210, 30);
		contentPane.add(btnClearProfile);

		lblUnit = new JLabel("Thousand");
		lblUnit.setOpaque(true);
		lblUnit.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUnit.setBackground(Color.YELLOW);
		lblUnit.setBounds(97, 553, 96, 29);
		contentPane.add(lblUnit);
		
	}
	
	protected void createAndSetupCoreComponents4JTabbedPane() { 
		contentPane=new JPanel(); // contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//original 
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, Color.CYAN, null));//modified 
		// setContentPane(contentPane);(try not commenting out to see how it goes) 
		/** * added above line, then it will produce IllegalArgumentException 
		 * * (i.e. java.lang.IllegalArgumentException: adding container's parent to itself) 
		 * * Because it was replaced by "getContentPane().add(tabbedPane);
		 */
		contentPane.setLayout(null);//without this line, layout is funny!(you try commenting out to see how it goes) 
		
		box1=Box.createHorizontalBox();
		box2=Box.createHorizontalBox(); 
		box3=Box.createHorizontalBox(); 
		
		txtArea4RecordTextArea=new JTextArea(500, 650);//original (500, 400) 
		txtArea4RecordTextArea.setEditable(false); 
		// txtArea4RecordTextArea.setLineWrap(true);//with this line on--> no horizontal 15crollPane 
		box1.add(new JScrollPane(txtArea4RecordTextArea));
		
		listArea4RecordListArea= new JList<>(); 
		listArea4RecordListArea.setBounds(10, 10, 500, 600); 
		listArea4RecordListArea.setAutoscrolls(true); 
		//add(box);//Can be deleted 
		
		box2.add(new JScrollPane(listArea4RecordListArea)); 
		
		//Add both core-components of panel (for RecordBasic) and box to TrabbedPane 
		tabbedPane=new JTabbedPane();//Create DTabbedPane(); 
		tabbedPane.addTab(title4InputArea, null, contentPane, tip4InputArea);
		tabbedPane.addTab(title4TextArea, null,box1,tip4TextArea);
		tabbedPane.addTab(title4JList, null,box2,title4JList);
		tabbedPane.addTab(title4JTable, null,box3,tip4JTable);
		
		getContentPane().add(tabbedPane); //OK 
		// contentPane.add(tabbedPane);//not OK; has to use 'getContentPane().add(tabbedPane);' 
		/* * below 2 lines needed when using extending 1InternalFrame; * AND those 2 lines maybe can be commented out when back for using extending Frame * However, still not 100% sure, needs to try out more later. */ 
		// setsize( 704, 785 ); 
		// setvisible( true ); 

		
	}
	protected void initializeButtonArray() 
	{ 
		JButton [] buttonsInitialized={btnCalculate, btnRefresh, btnClearRecord, btnSetProfile, btnClearProfile, btnOutputAll, btnExit, 
				btnOpenFile, btnReadFile, btnWriteFile, btnCloseFile, btnPieChartDemo}; 
		
		optionButtons=buttonsInitialized; 
		for(int i=0; i< basicChoices.length; i++) 
		{ 
			optionButtons[i].setText(basicChoices[i].getButtonType()); 
//		contentPane.add(optionButtons[i]);//I believe this line is no need. Confirm later 
		} 
	}//end initializeButtonArray() 

	
	protected void initializeTextFieldArrayList() 
	{ 
		
		JTextField[] txtFieldsProfile={txtFieldCN, txtFieldEN}; 
		JTextField[] txtFieldsEmployee={txtFieldSSN,txtFieldFN,txtFieldLN,txtFieldEarnings}; 
		JTextField[] txtFieldsOutput={txtFieldEmpCounter,txtFieldLowestE,txtFieldHighestE,txtFieldAverageE, 
				txtFieldLA,txtFieldLB,txtFieldLC}; 
	for (JTextField txtField: txtFieldsProfile) 
	{ 
//		txtField.setInputVerifier(verifier4SuperEmployeeBase);//for verification 
		listTxtFieLdsProfiLeG.add(txtField); 
//		contentPane.add(txtField); 
	} 
	for (JTextField txtField: txtFieldsEmployee) 
	{ 
//		txtField.setInputVerifier(verifier4SuperEmployeeBase);//for verification 
		listTxtFieLdsEmpLoyeeG.add(txtField); 
//		contentPane.add(txtField); 
	}
	for (JTextField textField: txtFieldsOutput) 
	{ 
		listTxtFieldsResultsG.add(textField); 
//		contentPane.add(txtField); 
	}
	}//end initializeTextFieldArrayList() 
	
	public void initializeTitleNamesList4JTable()
	{
		String[] titleNames4Table = {EmployeeRecordIndices.SSN.getRecordIndexType(),EmployeeRecordIndices.FIRST_NAME.getRecordIndexType(), 
				EmployeeRecordIndices.LAST_NAME.getRecordIndexType()}; 
		for(String titleName: titleNames4Table) 
		{ 
			listTitleName4Table.add(titleName); 	 
		}
	} 
	
	public void initialize4TitleNamesString4JTable(/* List<String> listTitleName4Table*/) 
	{ 
		namesUsed= new String[listTitleName4Table.size()]; 
		
		for(int i=0; i< namesUsed.length; i++) 
		{ 
			namesUsed[i]=listTitleName4Table.get(i).toString(); 
		}
	} 
	
	
 }//end class EmployeeBaseJFrame_V2 

	
	

