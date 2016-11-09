
public class main_Flyweight {

	private static final String deparment[] = { "Accounting", "Developer", "Janitor", "Boss", "Finance","Marketing" };
	   public static void main(String[] args) {

	      for(int i=0; i < 20; ++i) {
	         Employee employee = (Employee)Department.getEmployee(getRandomDepartment());
	         switch(employee.getdepartment()){
	         case "Accounting":
	        	 employee.setIncome((getRandomIncome()*10)%300+200);
	        	System.out.print("Accountant: ");
	        	 break;
	         case "Developer":
	        	 employee.setIncome((getRandomIncome()*30)%400+200);
	        	 System.out.print("Developer: ");
	        	 break;
	         case "Janitor":
	        	 employee.setIncome((getRandomIncome()*2)%100+100);
	        	 System.out.print("Janitor: ");
	        	 break;
	         case "Boss":
	        	 employee.setIncome(getRandomIncome()*100);
	        	 System.out.print("Boss: ");
	        	 break;
	         case "Finance":
	        	 employee.setIncome((getRandomIncome()*20)%300+200);
	        	 System.out.print("Finance: ");
	        	 break;
	         case "Marketing":
	        	 employee.setIncome((getRandomIncome()*5)%200+150);
	        	 System.out.print("Marketing: ");
	        	 break;
	        	 
	         }
	         
	         
	         employee.income(employee.getIncome());
	      }
	   }
	   private static String getRandomDepartment() {
	      return deparment[(int)(Math.random()*deparment.length)];
	   }
	   private static int getRandomIncome() {
	      return (int)(Math.random()*100 );
	   }
	  
}
