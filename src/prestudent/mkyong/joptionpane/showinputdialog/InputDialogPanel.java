package prestudent.mkyong.joptionpane.showinputdialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class InputDialogPanel { 
	public static void main(String[] args) { 
		
		JPanel panel = new JPanel(); 
		panel.setBackground(new Color(0, 0, 0)); 
		panel.setSize(new Dimension(250, 32)); 
		panel.setLayout(null); 

		JLabel label = new JLabel("It's your choice! :)"); 
		label.setForeground(new Color(255, 255, 0)); 
		label.setHorizontalAlignment(SwingConstants.CENTER); 
		label.setFont(new Font("Arial", Font.BOLD, 11)); 
		label.setBounds(0, 0, 20, 32); panel.add(label); 

		UIManager.put("OptionPane.minimumSize",new Dimension(270, 120)); 

		Object[] options = {2, "No", 5.6, true}; 
		Object l = JOptionPane.showInputDialog(null, panel, 
				"Mix & !•latch", JOptionPane.PLAIN_MESSAGE, null, options, options[3]); 
		
		if(l instanceof Integer){ 
			System.out.println("You picked an Integer!"); 
		}else if(l instanceof String){ 
			System.out.println("You picked a String!"); 
		}else if(l instanceof Double){ 
			System.out.println("You picked a Double!"); 
		}else if(l instanceof Boolean){ 
			System.out.println("You picked a Boclean!"); 
		}
			
		}//end main 
}//end InputDialogPanel 

