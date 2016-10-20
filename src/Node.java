import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Stack;

public class Node {
	
	
	public Hashtable <String, Double> Conditional_Prob_Table; 
	public String name;
	public double probability;

	public Node(String name){
		this.set_name(name);
		this.Conditional_Prob_Table= new Hashtable<String, Double>();		
	}
	
	public void set_HashTAble(Double Probab, ArrayList<String> Parent){
	
		if(Parent.size()>1){
		String	aux="";	
				for(int i=0; i<Parent.size(); i++){
				
					aux+= Parent.get(i)+"  ";
				}
				Conditional_Prob_Table.put(aux, Probab);	
			
			}				
		else{
			Conditional_Prob_Table.put(Parent.get(0), Probab);
			
		}
		

	}
		
	
	public String toString(){
		String output="";
		output+= "Name= "+this.name+" Probability"+this.probability+" \n ";
				
				output += "\n HAsh table";
				for(String currentKey : this.Conditional_Prob_Table.keySet()){
					output+="[ "+currentKey+"] -> "+ this.Conditional_Prob_Table.get(currentKey)+" \n";
				}
		return output;		
	}
	
	
	public double get_probability(){
		return this.probability;
	}
	
	public void set_probability(double probability){
		this.probability=probability;
	}
	
	
	public double return_negative(double probability){
		return 1-probability;
	}
	
	
	
	public String get_name(){
		return this.name;
	}
	
	public void set_name(String name){
		 this.name=name;
	}
	
	
	
	
	
}