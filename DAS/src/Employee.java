
public class Employee implements Person {
	String department;
	int x;
	int y;
	int radius;
	public Employee(String department) {
		// TODO Auto-generated constructor stub
	this.department=department;
	}
	public Employee(){
		
	}
	
	public String getdepartment(){
		return this.department;
	}
	
	public void income(int i) {
		// TODO Auto-generated method stub
		System.out.println("You will earn "+(i*1.15)+" of dlls per month \n ");
	}

	public void income(int i, int j) {
		// TODO Auto-generated method stub
		income(i);
	}

	public void setIncome(int x) {
		// TODO Auto-generated method stub
		this.x=x;
	}

	
	
	public int getIncome() {
		// TODO Auto-generated method stub
		return this.x;
	}
	
	  

}
