import java.util.HashMap;


public class Department {
private static final HashMap<String,Person> EmployeeMap = new HashMap<String, Person>();

	   public static Person getEmployee(String department) {
	      Employee employee = (Employee)EmployeeMap.get(department);

	      if(employee == null) {
	         employee = new Employee(department);
	         EmployeeMap.put(department, employee);
	      }
	      return employee;
	   }
}