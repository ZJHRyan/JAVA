package polymorphism.emyloyee;
// Fig. 10.8: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class extends CommissionEmployee.

public class BasePlusCommissionEmployee extends CommissionEmployee {
   private double baseSalary; // base salary per week
   private double extraHourRate;

   // constructor
   public BasePlusCommissionEmployee(String _firstName, String _lastName, 
      String _socialSecurityNumber,boolean _isSimpleFormate, double _grossSales,
      double _commissionRate, double _baseSalary) {
      super(_firstName, _lastName, _socialSecurityNumber, _isSimpleFormate,
         _grossSales, _commissionRate);

      if (_baseSalary < 0.0) { // validate baseSalary                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }      
             
      this.baseSalary = _baseSalary;

   }

   // set base salary
   public void setBaseSalary(double baseSalary) {
      if (baseSalary < 0.0) { // validate baseSalary                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }
            
      this.baseSalary = baseSalary;                
   } 

   // return base salary
   public double getBaseSalary() {return baseSalary;}
   

   // calculate earnings; override method earnings in CommissionEmployee
   @Override                                                            
   public double earnings() {return getBaseSalary() + super.earnings();}

   // return String representation of BasePlusCommissionEmployee object
   @Override                                                   
   public String toString() {                                  
      return String.format(
    		  isSimpleFormate ? ("\r\n%12s\t%15s\t%15s\t%15s\t,%15.2f\t%15.2f\t15.2f\t%15.2f")
    				          : ("\r\n%12s\t%15s\t%15s\t%15s\t%15.2f\t%15.2f\t15.2f\t%15.2f"),     
              "B+C-Employee", getFirstName(),getLastName(),getSocialSecurityNumber(),getGrossSales(),
              getCommissionRate(),getBaseSalary(),earnings());              
   } 
   @Override                                                   
   public String toString2() {                                  
      return String.format("%s %s; %s: $%,.2f",     
         "base-salaried", super.toString(),"base salary",getBaseSalary());            
   } 
   @Override                                                   
   public String toString3() {                                  
      return String.format("\r\n%12s, %15s,%15s, % , 15.2f, %15.2f, %15.2f",     
         "B+C-Employee",getFirstName(),getLastName(),getSocialSecurityNumber(),getGrossSales(),getCommissionRate(),
         getBaseSalary(),earnings());              
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
