import java.util.ArrayList;

public class Parser {
	public static InputReader in;
	
	public Parser(){
		in = new InputReader(System.in);
	}
	
	public void readNodes(){
		
		ArrayList<String> nodes = new ArrayList<String>();
		
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
				nodes.add(actual);
				actual = "";
			}else{
				actual += (char)c;
			}
		}while(c != '\n');
		
		for(int i = 0; i < nodes.size(); i++){
			System.out.println(nodes.get(i));
		}
	}
	
	public void readProbabilities(){
		ArrayList<String> probabilities = new ArrayList<String>();
		ArrayList<Double> probabilitiesNumber = new ArrayList<Double>();
		
		// Wait until the string Nodes Appear
		String nodeText;
		do{
			 nodeText = in.readString();
		}while(!nodeText.contains("Probabilities"));
		
		int c;
		String actual = ""; 
		do{
			c = in.read();
			if(c == '|'){
				actual = "";
			}
			if(c == '='){
				probabilities.add(actual);
				actual = "";
			}else if(c == '\n'){
				probabilitiesNumber.add(Double.parseDouble(actual));
			}else{
				actual += (char) c;
			}
		}while(c != '[');
		
		for(int i = 0; i < probabilities.size(); i++){
			System.out.println(probabilities.get(i));
		}
		
		for(int i = 0; i < probabilitiesNumber.size(); i++){
			System.out.println(probabilitiesNumber.get(i));
		}
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
		}
		
		return queries;
	}
	
}
