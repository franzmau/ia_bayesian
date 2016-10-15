import java.util.ArrayList;
import java.util.Stack;

public class State {
	
	public ArrayList <Stack<String>> stateMatrix;
	private int height;
	private int heuristic;
	
	public State(ArrayList <Stack<String>> stateMatrix, int height){
		this.stateMatrix = stateMatrix;
		this.height = height;
		this.heuristic = 0;
	}
	
	public State(State state){
		this.height = state.height;
		this.heuristic = state.heuristic;
		this.stateMatrix = new ArrayList <Stack<String>> ();
		for(int i = 0; i < state.stateMatrix.size(); i++){
			Stack <String> stack = new Stack <String>();
			for(int j = 0; j < state.stateMatrix.get(i).size(); j++){
				stack.push(state.stateMatrix.get(i).get(j));
			}
			stateMatrix.add(stack);
		}
	}
	
	public State move(int from, int to){
		State newState = null;
		if(stateMatrix.get(from).size() > 0 && 
			stateMatrix.get(from).size() < height &&
			from != to){
			newState = new State(this);
			ArrayList <Stack<String>> newMatrix= newState.stateMatrix;
			String temp = newMatrix.get(from).pop();
			newMatrix.get(to).push(temp);
			newState = new State(newMatrix, this.height);
			
		}
		return newState;
	}
	public int getHeuristic(){
		return heuristic;
	}
	
	
	public void calculateHeuristic_consistent(State final_state, State initial){
		//ArrayList <Stack<String>> final_state_matrix = final_state.stateMatrix;
		int acum = 0;
		State final_state_matrix= new State(final_state);
		State current_state_matrix= new State(initial);
		for(int i = 0; i < current_state_matrix.stateMatrix.size(); i++){
			if(current_state_matrix.stateMatrix.get(i).size() != 0){ // Stack is not empty
				Stack<String> current_stack = current_state_matrix.stateMatrix.get(i);
				while(!current_stack.empty()){
					String current_value = current_stack.pop();
					for(int j = 0; j < final_state_matrix.stateMatrix.size(); j++ ){
						if(final_state_matrix.stateMatrix.get(j).contains(current_value)){
							if(i != j){
								acum += 1 + Math.abs(i-j);
							}
							break;
						}
					}
				}
			}
		}
		this.heuristic =(int) acum;
	}
	
	public void prettyPrint(){
		for(int i = 0; i < height; i++){
			for(int j = 0; j < stateMatrix.size(); j++){
				int myIndex = height - i - 1;
				if(stateMatrix.get(j).size() > myIndex){
					System.out.print(stateMatrix.get(j).get(height - i - 1) +"\t");
				}else{
					System.out.print("x\t");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
}