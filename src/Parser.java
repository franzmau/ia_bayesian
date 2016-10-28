import java.util.ArrayList;
import java.util.Hashtable;

public class Parser {
	public static InputReader in;
	private ArrayList<String> nodes_strings;
	public ArrayList<Node> nodes;
	public Hashtable <String, Node> nodes_hash;
	private String plus;
	private String neg;
	
	public Parser(){
		in = new InputReader(System.in);
	}
	
	
	public void readNodes(){
		
		nodes = new ArrayList<Node>();
		nodes_strings = new ArrayList<String>();
		nodes_hash = new Hashtable<String, Node>();
		
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
				actual = actual.replaceAll("\\s+","");
				Node n = new Node(actual);
				nodes.add(n);
				nodes_strings.add(actual);
				nodes_hash.put(actual, n);
				actual = "";
			}else{
				actual += (char)c;
			}
		}while(c != '\n');
		
	}
	
	
	public void readProbabilities(){
		ArrayList<String> probabilities = new ArrayList<String>();
		ArrayList<String> queries = new ArrayList<String>();
		ArrayList<Double> probabilitiesNumber = new ArrayList<Double>();
		// Wait until the string Nodes Appear
		String nodeText;
		do{
			 nodeText = in.readString();
		}while(!nodeText.contains("Probabilities"));
		
		int c;
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
			}else{
				evidence = true;
				actualQuery = actualLine.split("\\|")[0];
				String temp = actualLine.split("\\|")[1];
				actualEvidence = temp.split("=")[0];
				actualProbability = Double.parseDouble(actualLine.split("=")[1]);
			}
			
			for(int i = 0; i < nodes.size(); i++){
				Node actualNode = nodes.get(i);
				if(actualQuery.toLowerCase().contains(actualNode.name.toLowerCase())){
					if(evidence){
						actualNode.set_HashTable( actualProbability,actualEvidence);
					}else{
						actualNode.probability = actualProbability;
					}
				}
			}
			
			actualLine = in.readLine();
		}
	
		
	}
	
	
	public void printArrayList(ArrayList<String> array, String title){
		/*
		System.out.println(title);
		for(int i = 0; i < array.size(); i++){
			System.out.println(array.get(i));
		}*/
	}
	
	public ArrayList<Query> readQuerys(){
		ArrayList<Query> queries = new ArrayList<Query>();
		
		// Wait until the string Nodes Appear
		String actualLine = in.readLine();
		String actualQuery = "";
		while(!actualLine.isEmpty()){
			Query q = new Query();
			actualLine = actualLine.replaceAll("\\s+","");
			if(!actualLine.contains("|")){
				q.addQuery(actualLine);
			}else{
				actualQuery = actualLine.split("\\|")[0];
				String queriesArray [] = actualQuery.split(",");
				for(int i = 0; i < queriesArray.length; i++){
					q.addQuery(queriesArray[i]);
				}
				
				String temp = actualLine.split("\\|")[1];
				String evidences [] = temp.split(",");
				for(int i = 0; i < evidences.length; i++){
					q.addEvidence(evidences[i]);
				}				
			}
			
			queries.add(q);
			actualLine = in.readLine();
		}
		queries.remove(0);
				
		for(int i = 0; i < queries.size(); i++){
			//System.out.println(queries.get(i).toString()+"\n\n");
			// Create total numerator
			Query curQuery = queries.get(i);
			ArrayList<String> query_strings = curQuery.queries;
			ArrayList<String> evidence_strings = curQuery.evidence;
			if(evidence_strings.size() == 0){
				ArrayList<String> numeratorHiddenVariables = getHiddenVariables(query_strings);
				double result = getTotalJointProbability(query_strings, numeratorHiddenVariables);
				double output = Math.round(result*10000000.0)/10000000.0;
				System.out.println(output);
			} else {
				ArrayList<String> numerator_string = (ArrayList<String>) query_strings.clone();
				
				
				for(int j = 0; j < evidence_strings.size(); j++){
					numerator_string.add(evidence_strings.get(j));
				}
				printArrayList(numerator_string, "NUMERATOR STRING");
				ArrayList<String> numeratorHiddenVariables = getHiddenVariables(numerator_string);
				printArrayList(numeratorHiddenVariables, "HIDDEN VARIABLES");
				double numeratorValue = getTotalJointProbability(numerator_string, numeratorHiddenVariables);
				// Calculate denominator
				ArrayList<String> denominatorHiddenVariables = getHiddenVariables(evidence_strings);
				printArrayList(denominatorHiddenVariables, "DENOMINATOR HIDDEN VARIABLES");
				printArrayList(evidence_strings, "EVIDENCE STRING");
				double denominatorValue = getTotalJointProbability(evidence_strings, denominatorHiddenVariables);
				double output = Math.round(numeratorValue/denominatorValue*10000000.0)/10000000.0;
				System.out.println(output);
			}
		}
		
		return queries;
	}
	
	public ArrayList<String> getHiddenVariables(ArrayList<String> jointNodes){
		ArrayList<String> hiddenVariables = new ArrayList<String>();
		plus = "+";
		neg = "-";
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
			printArrayList(jointNodes, "JOINT NODES");
			return getJointProbability(jointNodes);
		} else {
			String nodeToAdd = hiddenVariables.get(0);
			String plusConcat = plus;
			String negConcat = neg;
			ArrayList<String> positiveOne = (ArrayList<String>) jointNodes.clone();
			ArrayList<String> negativeOne = (ArrayList<String>)jointNodes.clone();
			positiveOne.add(plusConcat.concat(nodeToAdd));
			negativeOne.add(negConcat.concat(nodeToAdd));
			ArrayList<String> hiddenClonePos = (ArrayList<String>) hiddenVariables.clone();
			ArrayList<String> hiddenCloneNeg = (ArrayList<String>) hiddenVariables.clone();
			hiddenClonePos.remove(nodeToAdd);
			hiddenCloneNeg.remove(nodeToAdd);
			return getTotalJointProbability(positiveOne, hiddenClonePos) + getTotalJointProbability(negativeOne, hiddenCloneNeg);
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
