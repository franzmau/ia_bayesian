import java.util.ArrayList;
import java.util.Stack;




public class main {
	
	public static final int COLUMNS = 3;
	public static final int MAX_HEIGHT = 3;
	
	
	public State initialState(){
		ArrayList <Stack<String>> stateMatrix = new ArrayList<Stack<String>>();
		for(int i = 0; i < COLUMNS; i++){
			Stack<String> newStack = new Stack<String>();
			if(i == 0){
				newStack.push("A");
				
			}
			
			if(i == 1){
				newStack.push("B");
			}
			
			if(i == 2){
				newStack.push("C");
			}
			stateMatrix.add(newStack);
		}
		return new State(stateMatrix, MAX_HEIGHT);
	}
	
	public State finalState(){
		ArrayList <Stack<String>> stateMatrix = new ArrayList<Stack<String>>();
		for(int i = 0; i < COLUMNS; i++){
			Stack<String> newStack = new Stack<String>();
			if(i == 0){
				newStack.push("B");
				newStack.push("A");
				
			}
			
			if(i == 1){
				newStack.push("C");			
			}
			
			if(i == 2){
				
			}
			stateMatrix.add(newStack);
		}
		return new State(stateMatrix, MAX_HEIGHT);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main m = new main();
		State initialState = m.initialState();
		//initialState.prettyPrint();
		State finalState = m.finalState();
		//finalState.prettyPrint();
		Tree tree = new Tree(initialState);
		System.out.println("Uniform cost\n");
		boolean aux =tree.uniformCost(finalState, 100);
		if(!aux){
			System.out.println("No solution found");
		}
		System.out.println("\n a* Inconsistent\n");
		tree=new Tree (initialState);
		boolean aux2=tree.aStarInConsistent(finalState, 100);
		if(!aux2){
			System.out.println("No solution found");
		}
		tree=new Tree (initialState);
		System.out.println("\n a* Consistent\n");
		boolean aux3 =tree.aStarConsistent(finalState , 100);
		if(!aux3){
			System.out.println("No solution found");
		}
		tree=new Tree (initialState);
		System.out.println("\n Breadth First\n");
		boolean aux4 =tree.breadthFirstSearch(finalState , 100);
		if(!aux4){
			System.out.println("No solution found");
		}
		tree=new Tree (initialState);
		System.out.println("\n Depth First\n");
		boolean aux5 =tree.depthFirstSearch(finalState , 100);
		if(!aux5){
			System.out.println("No solution found");
		}

		
	}

}