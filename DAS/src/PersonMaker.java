public class PersonMaker {
   private Person employee;
   private Person entreperneur;
   private Person freelance;
   //this is facade class
   public PersonMaker() {
      employee = new Employee();
      entreperneur = new Entreperneur();
      freelance = new Freelance();
   }

   public void payEmployee(int i){
      employee.income(i);
   }
   public void payEntreperneur(int i,int j){
      entreperneur.income(i,j);
   }
   public void payfreelance(int i){
      freelance.income(i);
   }
}