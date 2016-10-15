import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Stack;

public class Node {
	
	public double probability;
	public ArrayList <Node> Parent;
	public Hashtable <String, Double> Conditional_Prob_Table; 
	
	

	public Node(double probability, ArrayList <Node> Parent, ArrayList <Double> Probab  ){
	this.probability=probability;
	this.Parent=(ArrayList<Node>)Parent.clone();
	Conditional_Prob_Table= new Hashtable<String, Double>();
		if(Parent.size()>0){
			for(int i=0; i<Parent.size(); i++){
			String aux= Parent.get(i).toString();
			Conditional_Prob_Table.put(aux, Probab.get(i));
				
			}
		}
		
	}
	
	
	
}