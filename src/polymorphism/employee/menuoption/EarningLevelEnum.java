package polymorphism.employee.menuoption;

import java.awt.Color;

// Fig. 15.7: MenuOption.java
// enum type for the credit-inquiry program's options.
public enum EarningLevelEnum {
	// declare contents of enum type

	LeveLA ( 15, "Level A", "A", new Color(255, 0, 0) ), 
	LevelB ( 8, "Level B", "B" , new Color(0, 1255, 0) ), 
	LeveLC ( 0, "Level C", "C" , new Color(0, 0, 255) ), 
	UNIT (1000,"Thousand", "", new Color(255, 255, 255) ), 
	MAX_WORKED_NOURS(80, " max worked hours", "", new Color(255, 255, 255 )); 

	private final int value; // current menu value 
	private final String levelOrUnitType; // current menu level-type or unit considered 
	private final String levelCharacter; // current menu level-Character represented 
	private final Color indexColor; 
	
	EarningLevelEnum( int valueOption, String _levelOrUnitType, String _levelCharacter, Color _indexColor) 
	{ 
	value = valueOption; 
	levelOrUnitType=_levelOrUnitType; 
	levelCharacter= _levelCharacter; 
	indexColor= _indexColor; 
	} // end EarningLevelEnum mm constructor 
	public int getvalue() 
	{ 
		return value; 
		} // end method getvalue 
	public String getLevelType() 
	{ 
		return levelOrUnitType; 
	} // end method getLevelType 
	public String getLevelCharacter() 
	{ 
	return levelCharacter; 
	} // end method getLevelCharacter 
	public Color getColor() 
	{ 
	return indexColor; 
	} // end method getvalue 
	//end got EarningLevelEnum 


}

/*************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/