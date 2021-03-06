import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Node {
	
	public State myState;
	public ArrayList <Node> childs;
	public Pair moves;
	public Node parent;
	public int cost;
	public int cost_heuristic;
	
	public Node(State s, int cost){
		this.myState = s;
		this.childs = new ArrayList<Node>();
		this.cost = cost;
		this.cost_heuristic = cost;
		this.parent = null;
		this.moves = null;
		
	}
	
	public Node(State s, int cost,Node parent, Pair moves){
		this.myState = s;
		this.moves = moves;
		this.parent = parent;
		this.childs = new ArrayList<Node>();
		this.cost = cost;
		this.cost_heuristic = cost;
	}
	
	
	public void addChild(Node n){
		this.childs.add(n);
	}
	
	public void addHeuristic2(){
		this.cost_heuristic = this.cost *0;
	}
	
	
	public void addHeuristic(State final_state){
		this.myState.calculateHeuristic_consistent(final_state,this.myState);
		this.cost_heuristic = this.cost + this.myState.getHeuristic();
	}
	
	public void sortChilds(){
		Collections.sort(childs, new Comparator<Node>() {
	        public int compare(Node node1, Node node2)
	        {
	        	if(node1.cost > node2.cost){
	        		return 1;
	        	}
	        	return -1;
	        }
	    });
	}
	
	
	public boolean isEqual(State myState){
		ArrayList <Stack<String>> compareArraylist = myState.stateMatrix;
		ArrayList <Stack<String>> myArraylist = this.myState.stateMatrix;
		for(int i = 0; i < myArraylist.size(); i++){
			for(int j = 0; j < myArraylist.get(i).size();j++){
				if(compareArraylist.get(i).size() <= j ||
						!myArraylist.get(i).get(j).equalsIgnoreCase(compareArraylist.get(i).get(j))
						){
					return false;
				}
			}
		}
		return true;
	}
	
}