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
		this.probability = -1;
	}
	
	public void set_HashTable(Double Probab, String Previous){
		Conditional_Prob_Table.put(Previous, Probab);
		

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
	
	public double getPositiveProbability(ArrayList<String> jointNodes){
		if(this.probability != -1){
			return this.probability;
		}
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> copy_keys = new ArrayList<String>();
		for(String currentKey : this.Conditional_Prob_Table.keySet()){
			if(currentKey.contains((CharSequence) jointNodes)){
				keys.add(currentKey);
				copy_keys.add(currentKey);
			}
		}
		for(int i = 0; i < keys.size(); i++){
			copy_keys.remove(keys.get(i));
			if(!copy_keys.contains(keys.get(i))){
				return this.Conditional_Prob_Table.get(keys.get(i));
			}
			copy_keys = (ArrayList<String>) keys.clone();
		}
		return -1;
	}
	
	public double getNegativeProbability(ArrayList<String> jointNodes){
		if(this.probability != -1){
			return 1-this.probability;
		}
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> copy_keys = new ArrayList<String>();
		for(String currentKey : this.Conditional_Prob_Table.keySet()){
			if(currentKey.contains((CharSequence) jointNodes)){
				keys.add(currentKey);
				copy_keys.add(currentKey);
			}
		}
		for(int i = 0; i < keys.size(); i++){
			copy_keys.remove(keys.get(i));
			if(!copy_keys.contains(keys.get(i))){
				return (1-this.Conditional_Prob_Table.get(keys.get(i)));
			}
			copy_keys = (ArrayList<String>) keys.clone();
		}
		
		return -1;
	}
	
	
	
	
	
}