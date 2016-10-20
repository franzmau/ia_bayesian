import java.util.ArrayList;

public class Query {
	public ArrayList<String> queries;
	public ArrayList<String> evidence;
	
	
	public Query(){
		this.queries= new ArrayList<String>();
		this.evidence = new ArrayList<String>();
	}
	
	public void addEvidence(String name){
		name = name.replaceAll("\\s+","");
		evidence.add(name);
	}
	
	public void addQuery(String name){
		name = name.replaceAll("\\s+","");
		queries.add(name);
	}
	
	public String toString(){
		String output = "";
		output += "QUERIES : \n";
		for(int i = 0; i < this.queries.size(); i++){
			output += this.queries.get(i)+"\n";
		}
		output += "DEPENDENCIES:\n";
		for(int i = 0; i < this.evidence.size(); i++){
			output += this.evidence.get(i)+"\n";
		}
		return output;
	}
	
}
