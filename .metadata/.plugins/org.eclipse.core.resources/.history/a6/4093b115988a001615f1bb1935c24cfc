import java.util.ArrayList;
import java.util.Stack;

public class main {
	
	public static int MAX_HEIGHT = 0;
	public static InputReader in;
	
	public State initialState(){
		
    	MAX_HEIGHT = in.readInt();
		ArrayList <Stack<String>> initialStateMatrix = new ArrayList<Stack<String>>();
		Stack<String> newStack = new Stack<String>();
    	int c = in.read(); 
    	int prev = c;
    	while(c!='\n'){
			c = in.read();
			if(c == ',' || c == ')'){
				if(prev != 'X' && prev != 'x' && prev >= 'A' && prev <= 'Z'){
					newStack.push(""+(char)prev);
				}
			}
			if(c == ';'){
				initialStateMatrix.add(newStack);
				newStack = new Stack<String>();
			}
			prev = c;
		}
		initialStateMatrix.add(newStack);
		
		return new State(initialStateMatrix, MAX_HEIGHT);
	}
	
	public State finalState(){
		ArrayList <Stack<String>> initialStateMatrix = new ArrayList<Stack<String>>();
		Stack<String> newStack = new Stack<String>();
    	int c = in.read(); 
    	int prev = c;
    	while(c!='\n'){
			c = in.read();
			if(c == ',' || c == ')'){
				if(prev != 'X' && prev != 'x' && prev >= 'A' && prev <= 'Z'){
					newStack.push(""+(char)prev);
				}
			}
			if(c == ';'){
				initialStateMatrix.add(newStack);
				newStack = new Stack<String>();
			}
			prev = c;
		}
		initialStateMatrix.add(newStack);
		return new State(initialStateMatrix, MAX_HEIGHT);
	}
	
	 public boolean isInvalidChar(int c){
     	if(c > 'a' && c <'z' ||
     		c > 'A' && c <'Z'){
     		return false;
     	}
     	return true;
     }
     


	public static void main(String[] args) {
		in = new InputReader(System.in);
		main m = new main();
		State initialState = m.initialState();
		//initialState.prettyPrint();
		
		State finalState = m.finalState();
		
		//finalState.prettyPrint();
		
		Tree tree = new Tree(initialState);
		/*System.out.println("Uniform cost\n");
		boolean aux =tree.uniformCost(finalState, 100);
		if(!aux){
			System.out.println("No solution found");
		}
		System.out.println("\n a* Inconsistent\n");
		tree=new Tree (initialState);
		boolean aux2=tree.aStarInConsistent(finalState, 100);
		if(!aux2){
			System.out.println("No solution found");
		}*/
		tree=new Tree (initialState);
		//System.out.println("\n a* Consistent\n");
		boolean aux3 =tree.aStarConsistent(finalState);
		if(!aux3){
			System.out.println("No solution found");
		}
		/*
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
		*/
	}

}