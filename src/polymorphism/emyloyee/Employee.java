package polymorphism.emyloyee;
import java.awt.Color;
import java.io.Serializable;

// Fig. 10.4: Employee.java
// Employee abstract superclass.

public abstract class Employee implements Serializable {
   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;
   
   private String levelLetter;
   private Color  indexColor ;
   public boolean isSimpleFormate = true;
   
   // constructor
   public Employee(String _firstName, String _lastName, 
      String _socialSecurityNumber,boolean _isSimpleFormate) {
      firstName = _firstName;
      lastName = _lastName;
      socialSecurityNumber = _socialSecurityNumber;
      isSimpleFormate=_isSimpleFormate;
   } 

   // return first name
   public String getFirstName() {return firstName;}

   // return last name
   public String getLastName() {return lastName;}

   // return social security number
   public String getSocialSecurityNumber() {return socialSecurityNumber;}

   // return String representation of Employee object
   public void setLevel(String _levelLetter) {
	   levelLetter = _levelLetter ;
	}
   public String getLevel() {
	   return levelLetter ;
	
}
   
  public void setColor(Color _index4cColor) {
	indexColor = _index4cColor;
}
  public Color getColor() {
	return indexColor;
}
   
   
   @Override
   public String toString() {
      return String.format("%15s\t%15s\\t%15s", 
         getFirstName(), getLastName(), getSocialSecurityNumber());
   }
   public String toString2() {
	      return String.format("\r%15s %15s%nsocial security number: %s", 
	         getFirstName(), getLastName(), getSocialSecurityNumber());
	   }
   public String toString3() {
	      return String.format("%15s, %15s,%15s", 
	         getFirstName(), getLastName(), getSocialSecurityNumber());
	   }

   // abstract method must be overridden by concrete subclasses
   public abstract double earnings(); // no implementation here
} 



/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
