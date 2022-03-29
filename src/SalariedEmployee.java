

public class SalariedEmployee extends Employee {
   private double weeklySalary;

   // constructor
   public SalariedEmployee(String _firstName, String _lastName, 
      String _socialSecurityNumber,boolean _isSimpleFormate ,double weeklySalary) {
      super(_firstName, _lastName, _socialSecurityNumber,_isSimpleFormate); 

      if (weeklySalary < 0.0) {
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");
      }

      this.weeklySalary = weeklySalary;
   } 

   // set salary
   public void setWeeklySalary(double weeklySalary) {
      if (weeklySalary < 0.0) {
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");
      }

      this.weeklySalary = weeklySalary;
   } 

   // return salary
   public double getWeeklySalary() {return weeklySalary;}

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() {return getWeeklySalary();}                

   // return String representation of SalariedEmployee object  
   @Override                                                   
   public String toString() {                                  
      return String.format(
    		  isSimpleFormate ? ("\r\n%10s\t%50s\t,%15.2f\t%15.2f")
    				          : ("\r\n%10s\t%50s\t%15.2f\t%15.2f"),     
              "S-Employee", super.toString(), getWeeklySalary(),earnings());              
   } 
   @Override                                                   
   public String toString2() {                                  
      return String.format("salary employee:%s%n%s: $%,.2f",     
         super.toString(),              
         "week salary",getWeeklySalary());              
   } 
   @Override                                                   
   public String toString3() {                                  
      return String.format("\r\n%12s, %s, %-15.2f, %-15.2f",     
         "S-Employee", super.toString3(),getWeeklySalary(),earnings());              
   }                                                            
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
