
public class Entreperneur implements Person {

	public void income(int i,int v) {
		// TODO Auto-generated method stub
		
		System.out.println("You will earn  "+(i*v*1.5)+" of dlls per month \n ");

	}

	public void income(int i) {
		// TODO Auto-generated method stub
		income(i,i*2);
	}

}
