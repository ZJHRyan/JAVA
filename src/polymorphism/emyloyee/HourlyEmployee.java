package polymorphism.emyloyee;
// Fig. 10.6: HourlyEmployee.java
// HourlyEmployee class extends Employee.

public class HourlyEmployee extends Employee {
   private double hourlywage; // wage per hour
   private double hours; // hours worked for week
   private double extraHourRate;
   private double maxWorkedHours = 80;
   private double maxRate = 2.0;
   private double minRate = 1.0;
   private double normalWH = 40.0;
   // constructor
   public HourlyEmployee(String firstName, String lastName,
      String socialSecurityNumber,boolean _isSimpleFormate, double hourlyWage, double hours,double _extraHourRate) {
      super(firstName, lastName, socialSecurityNumber,_isSimpleFormate);

      if (hourlyWage < 0.0) { // validate wage
         throw new IllegalArgumentException("Hourly wage must be >= 0.0");
      }

      if ((hours < 0.0) || (hours > maxWorkedHours)) { // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= "+maxWorkedHours);
      }
      if ((_extraHourRate < minRate )||(_extraHourRate > maxRate )) { // validate wage
          throw new IllegalArgumentException("extraHourRate wage must be >= "+minRate+ "and <="+maxRate);
       }

      this.hourlywage = hourlyWage;
      this.hours = hours;
      this.extraHourRate = _extraHourRate;
   } 

   // set wage
   public void setWage(double wage) {
      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Hourly wage must be >= 0.0");
      }

      this.hourlywage = wage;
   } 

   // return wage
   public double getWage() {return hourlywage;}

   // set hours worked
   public void setHours(double hours) {
      if ((hours < 0.0) || (hours > maxWorkedHours)) { // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= "+maxWorkedHours);
      }

      this.hours = hours;
   } 

   // return hours worked
   public double getHours() {return hours;}

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() {                                          
      if (getHours() <= normalWH /*40*/) { // no overtime                           
         return getWage() * getHours();                                
      }                                                                
      else {                                                           
         return normalWH * getWage() + (getHours() - normalWH) * getWage() * getextraHourRate() ;  
      }                                                                
   }
   public void setextraHourRate(double _extraHourRate) {
	      if ((extraHourRate<1.0 ) ) { // validate baseSalary                  
	         throw new IllegalArgumentException("Extra HourRate must be > 1.0");
	      }
	            
	      this.extraHourRate = _extraHourRate;                
	   } 

	   // return base salary
   public double getextraHourRate() {return extraHourRate;}

   // return String representation of HourlyEmployee object              
   @Override                                                   
   public String toString() {                                  
      return String.format(
    		  isSimpleFormate ? ("\r\n%10s\t%50s\t%15.2f\t%15.2f\t%15.2f\t%15.2f")
    				          : ("\r\n%10s\t%50s\t%,15.2f\t%15.2f\t%15.2f\t%15.2f"),     
              "H-Employee", super.toString(),getWage(), getHours(),getextraHourRate(),earnings());              
   } 
   @Override                                                   
   public String toString2() {                                  
      return String.format("hourly employee: %s%n%s: $%,.2f; %s: %.2f %s: %.2f",     
         super.toString(),              
         "hourly wage", getWage(),"hours worked",getHours(),"rate",getextraHourRate());              
   } 
   @Override                                                   
   public String toString3() {                                  
      return String.format("\r\n%10s, %s, % , 15.2f, %15.2f, %15.2f,  %15.2f"  
         ,"H-Employee", super.toString3(),getWage(), getextraHourRate(),earnings());              
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
