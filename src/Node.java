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
	
	public void addToHash( String hashKey , Double probab){
		Conditional_Prob_Table.put(hashKey, probab);
	}
		
	
	public String toString(){
		String output="";
		output+= "Name: '"+this.name+ "'\n" +
				"Probability: "+this.probability+"\n\n";
		output+="Hash table:\n";
		for(String currentKey : this.Conditional_Prob_Table.keySet()){
			output+="'"+currentKey+"': "+ this.Conditional_Prob_Table.get(currentKey)+" \n";
		}
		output += "\n";
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