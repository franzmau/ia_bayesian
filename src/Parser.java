import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Stack;

public class Parser {
	public static InputReader in;
	public ArrayList<Node> nodes;
	
	private ArrayList<String> nodes_strings;
	private ArrayList<Node> nodes;
	public Hashtable <String, Node> nodes_hash;
	private String plus;
	private String neg;
	
	
	public Parser(){
		in = new InputReader(System.in);
	}
	
	
	public void readNodes(){
		
<<<<<<< HEAD
		nodes_strings = new ArrayList<String>();
		nodes = new ArrayList<Node>();
		nodes_hash = new Hashtable<String, Node>();
=======
		nodes = new ArrayList<Node>();
>>>>>>> 583db8ac81e8a488348571191cfb8c42740c9f07
		
		// Wait until the string Nodes Appear
		String nodeText;
		do{
			 nodeText = in.readLine();
		}while(!nodeText.contains("Nodes"));
		
		int c;
		String actual = ""; 
		do{
			c = in.read();
			if(c == ',' || c == '\n'){
<<<<<<< HEAD
				nodes_strings.add(actual);
				
=======
				actual = actual.replaceAll("\\s+","");
				nodes.add(new Node(actual));
>>>>>>> 583db8ac81e8a488348571191cfb8c42740c9f07
				actual = "";
			}else{
				actual += (char)c;
			}
		}while(c != '\n');
		
<<<<<<< HEAD
		for(int i = 0; i < nodes_strings.size(); i++){
			System.out.println(nodes_strings.get(i));
			
			// Create node
			nodes.add(new Node(nodes_strings.get(i)));
			
			nodes_hash.put(nodes_strings.get(i), nodes.get(i));
			
		}
		
=======
>>>>>>> 583db8ac81e8a488348571191cfb8c42740c9f07
	}
	
	
	public void readProbabilities(){
		ArrayList<String> probabilities = new ArrayList<String>();
		ArrayList<String> queries = new ArrayList<String>();
		ArrayList<Double> probabilitiesNumber = new ArrayList<Double>();
<<<<<<< HEAD
		ArrayList<String> node_probabilities = new ArrayList<String>();
		Node to_save;
		boolean compound_flag = false;
		
=======
>>>>>>> 583db8ac81e8a488348571191cfb8c42740c9f07
		// Wait until the string Nodes Appear
		String nodeText;
		do{
			 nodeText = in.readString();
		}while(!nodeText.contains("Probabilities"));
		
		int c;
<<<<<<< HEAD
		String actual = ""; 
		do{
			c = in.read();
			if(c == '|'){
				actual = actual.replaceAll("\\s+","");
				node_probabilities.add(actual.substring(1)); 
				compound_flag = true;
				actual = "";
			} else if(c == '='){
				if(compound_flag){
					probabilities.add(actual.replaceAll("\\s+",""));
				} else {
					actual = actual.replaceAll("\\s+","");
					node_probabilities.add(actual.substring(1));
					probabilities.add("");
				}
				actual = "";
			}else if(c == '\n'){
				probabilitiesNumber.add(Double.parseDouble(actual));
=======
		String actualLine = ""; 
		String actualQuery = "";
		String actualEvidence = "";
		double actualProbability = 0;
		Boolean evidence = false;
		actualLine = in.readLine();
		while(!actualLine.isEmpty()){
			actualLine = actualLine.replaceAll("\\s+","");
			if(!actualLine.contains("|")){
				evidence = false;
				actualQuery = actualLine.split("=")[0];
				actualProbability = Double.parseDouble(actualLine.split("=")[1]);
>>>>>>> 583db8ac81e8a488348571191cfb8c42740c9f07
			}else{
				evidence = true;
				actualQuery = actualLine.split("\\|")[0];
				String temp = actualLine.split("\\|")[1];
				actualEvidence = temp.split("=")[0];
				actualProbability = Double.parseDouble(actualLine.split("=")[1]);
			}
<<<<<<< HEAD
		}while(c != '[');
		
		for(int i = 0; i < node_probabilities.size(); i++){
			to_save = nodes_hash.get(node_probabilities.get(i));
			String predecesors = probabilities.get(i);
			if(predecesors.contentEquals("")){
				to_save.set_probability(probabilitiesNumber.get(i));
			} else {
				to_save.set_HashTable(probabilitiesNumber.get(i), predecesors);
			}
		}
		
		/*for(int i = 0; i < probabilities.size(); i++){
			System.out.println(probabilities.get(i));
		}
		
		for(int i = 0; i < probabilitiesNumber.size(); i++){
			System.out.println(probabilitiesNumber.get(i));
		}*/
=======
			
			for(int i = 0; i < nodes.size(); i++){
				Node actualNode = nodes.get(i);
				if(actualQuery.toLowerCase().contains(actualNode.name.toLowerCase())){
					if(evidence){
						actualNode.addToHash(actualEvidence, actualProbability);
					}else{
						actualNode.probability = actualProbability;
					}
				}
			}
			
			actualLine = in.readLine();
		}
		
		
		for(int i = 0; i < nodes.size(); i++){
			System.out.println(nodes.get(i).toString());
		}
		
		
>>>>>>> 583db8ac81e8a488348571191cfb8c42740c9f07
	}
	
	
	public ArrayList<Query> readQuerys(){
		ArrayList<Query> queries = new ArrayList<Query>();
		
		// Wait until the string Nodes Appear
		String nodeText;
		do{
			 nodeText = in.readString();
			 System.out.println(nodeText);
		}while(!nodeText.contains("Queries"));
		
		String actual = ""; 
		do{
			actual = in.readLine();
			actual = actual.replaceAll("\\s+","");
			if(!actual.isEmpty()){
				Query q = new Query();
				String element = "";
				Boolean parsingQueries = true;
				for(int i = 0; i < actual.length(); i++){
					char c = actual.charAt(i);
					if(c == ',' || c == '|' ){
						if(parsingQueries){
							q.addQuery(element);
						}else{
							q.addEvidence(element);
						}
						if(c == '|'){
							parsingQueries = false;
						}
						element = "";
					}else{
						element += c;
					}
				}
				queries.add(q);
			}
		}while(!actual.isEmpty());
		
		for(int i = 0; i < queries.size(); i++){
			System.out.println(queries.get(i).toString()+"\n\n");
			// Create total numerator
			Query curQuery = queries.get(i);
			ArrayList<String> query_strings = curQuery.queries;
			ArrayList<String> evidence_strings = curQuery.evidence;
			
			if(evidence_strings.size() == 0){
				getTotalJointProbability(query_strings, new ArrayList<String>());
			} else {
				ArrayList<String> numerator_string = (ArrayList<String>) query_strings.clone();
				
				
				for(int j = 0; j < evidence_strings.size(); j++){
					numerator_string.add(evidence_strings.get(i));
				}
				ArrayList<String> numeratorHiddenVariables = getHiddenVariables(numerator_string);
				double numeratorValue = getTotalJointProbability(numerator_string, numeratorHiddenVariables);
				// Calculate denominator
				ArrayList<String> denominatorHiddenVariables = getHiddenVariables(evidence_strings);
				double denominatorValue = getTotalJointProbability(evidence_strings, denominatorHiddenVariables);
				
				System.out.println((char)(numeratorValue/denominatorValue) + "\n\r");
			}
		}
		
		return queries;
	}
	
	public ArrayList<String> getHiddenVariables(ArrayList<String> jointNodes){
		ArrayList<String> hiddenVariables = new ArrayList<String>();
		ArrayList<String> forJointProb = jointNodes;
		String	plus = "+";
		String neg = "-";
		String plusConcat = plus;
		String negConcat = neg;
		
		
		for(int i = 0; i < nodes_strings.size(); i++){
			if(!jointNodes.contains(plusConcat.concat(nodes_strings.get(i))) && !jointNodes.contains(negConcat.concat(nodes_strings.get(i)))){
				hiddenVariables.add(nodes_strings.get(i));
			}
			plusConcat = plus;
			negConcat = neg;
		}
		return hiddenVariables;

		
		
	}
	
	
	
	
	public double getTotalJointProbability(ArrayList<String> jointNodes, ArrayList<String> hiddenVariables){
		if(hiddenVariables.size() == 0){
			return getJointProbability(jointNodes);
		} else {
			String nodeToAdd = hiddenVariables.get(0);
			String plusConcat = plus;
			String negConcat = neg;
			ArrayList<String> positiveOne = (ArrayList<String>) jointNodes.clone();
			ArrayList<String> negativeOne = (ArrayList<String>)jointNodes.clone();
			positiveOne.add(plusConcat.concat(nodeToAdd));
			negativeOne.add(negConcat.concat(nodeToAdd));
			hiddenVariables.remove(nodeToAdd);
			return getTotalJointProbability(positiveOne, hiddenVariables) + getTotalJointProbability(negativeOne, hiddenVariables);
		}
	}
	
	
	
	
	
	
	
	public double getJointProbability(ArrayList<String> jointNodes){
		//ArrayList<String> copyNodes = jointNodes.clone();
		double prod = 1;
		for(int i = 0; i < jointNodes.size(); i ++){
			String curNode = jointNodes.get(i);
			char sign = curNode.charAt(0);
			Node nodeProb = nodes_hash.get(curNode.substring(1));
			if(sign == '+'){
				prod *= nodeProb.getPositiveProbability(jointNodes);
			} else {
				prod *= nodeProb.getNegativeProbability(jointNodes);
			}
		}
		return prod;
	}
	
}
