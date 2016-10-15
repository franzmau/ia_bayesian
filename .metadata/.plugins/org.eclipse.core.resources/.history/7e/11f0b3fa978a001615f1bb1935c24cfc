import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	private ArrayList<Node> visitedNodes;
	private Node parentNode;
	public final int COLUMNS;
	
	public Tree(State s){
		this.visitedNodes = new ArrayList<Node>();
		this.parentNode = new Node(s, 0);
		this.COLUMNS = s.stateMatrix.size();
		
	}
	
	public boolean isAlreadyVisited(State s){
		for (int i=0;i<visitedNodes.size();i++){
			if(visitedNodes.get(i).isEqual(s)){
				return true;
			};
		}		
		return false;
	}
	
	public void printMoves(Node n){
		Node aux = n;
		Stack <Pair> moves = new Stack<Pair>();
		while(aux != null && aux.moves != null){
			moves.push(aux.moves);
			aux = aux.parent;
		}
		
		while(!moves.isEmpty()){
			Pair p = moves.pop();
			System.out.print("("+ p.from +", "+ p.to +")");
			if(moves.size() > 0){
				System.out.print("; ");
			}
		}
		System.out.println("");
	}
	
public boolean breadthFirstSearch(State finalState){
		
		
		if(parentNode.isEqual(finalState)){
			System.out.println("Cost: 0");
			System.out.println("Moves: None");
			return true;
		}
		
		Queue <Node> frontier = new LinkedList<Node>();
		
		frontier.add(parentNode);
		
		while(!frontier.isEmpty()){
			
			Node n = frontier.poll();
			
			visitedNodes.add(n);
			
			for(int i = 0; i < COLUMNS; i++ ){
				for(int j = 0; j < COLUMNS; j++ ){
					
					State  newNodeState = n.myState.move(i, j);
					
					if(newNodeState != null){		
						
						
						Node newNode = new Node(newNodeState, Math.abs(i-j) + 1 + n.cost, n, new Pair( i,j));
						

						if(!isAlreadyVisited(newNodeState)) {
							if(newNode.isEqual(finalState)){
								System.out.print("Cost: ");
								System.out.println(newNode.cost);
								System.out.print("Moves: ");
								printMoves(newNode);
								return true;
							}
							n.addChild(newNode);
							frontier.add(newNode);
						}
					}
				}
			}
			
			//n.sortChilds();
			
			//for(int i = 0; i < n.childs.size(); i++){
				//frontier.add(.childs.get(i));
			//}
		}
		return false;
	}
	
	public boolean depthFirstSearch(State finalState){
		
		
		Stack <Node> frontier = new Stack<Node>();
		
		frontier.add(parentNode);
		
		while(!frontier.isEmpty()){
			
			Node n = frontier.pop();
			
			visitedNodes.add(n);
			
			if(n.isEqual(finalState)){
				System.out.println(n.cost);
				printMoves(n);
				return true;
			}
			
			for(int i = 0; i < COLUMNS; i++ ){
				for(int j = 0; j < COLUMNS; j++ ){
					
					State  newNodeState = n.myState.move(i, j);
					
					if(newNodeState != null){		
						
						
						Node newNode = new Node(newNodeState, Math.abs(i-j) + 1 + n.cost, n, new Pair( i,j));
						
						if(!isAlreadyVisited(newNodeState)){
							n.addChild(newNode);
							frontier.push(newNode);
						}
					}
				}
			}
			
		}return false;
	}
	
	

public boolean uniformCost (State finalState){
	PriorityQueue <Node> frontier = new PriorityQueue<Node>(1,new Comparator<Node>() {
       
        public int compare(Node node1, Node node2)
        {
        	if(node1.cost > node2.cost){
        		return 1;
        	}
        	return -1;
        }
    });
	
	frontier.add(parentNode);
	
	while(!frontier.isEmpty()){
		
		Node n = frontier.poll();
		
		visitedNodes.add(n);
		
		if(n.isEqual(finalState)){
			System.out.println(n.cost);
			printMoves(n);
			return true;
		}
		
		for(int i = 0; i < COLUMNS; i++ ){
			for(int j = 0; j < COLUMNS; j++ ){
				
				State  newNodeState = n.myState.move(i, j);
				
				if(newNodeState != null){		
					
					
					Node newNode = new Node(newNodeState, Math.abs(i-j) + 1 + n.cost, n, new Pair( i,j));
					
					if(!isAlreadyVisited(newNodeState)){
						n.addChild(newNode);
						frontier.add(newNode);
					}
				}
			}
		}
		
	}return false;
}
	
	



public boolean aStarConsistent (State finalState){
	PriorityQueue <Node> frontier = new PriorityQueue<Node>(1,new Comparator<Node>() {
       
        public int compare(Node node1, Node node2)
        {
        	if(node1.cost_heuristic > node2.cost_heuristic){
        		return 1;
        	}
        	return -1;
        }
    });
	
	parentNode.addHeuristic(finalState);
	frontier.add(parentNode);
	
	while(!frontier.isEmpty()){
		
		Node n = frontier.poll();
		
		visitedNodes.add(n);
		
		if(n.isEqual(finalState)){
			System.out.println(n.cost);
			//n.myState.prettyPrint();
			printMoves(n);
			return true;
		}
		
		for(int i = 0; i < COLUMNS; i++ ){
			for(int j = 0; j < COLUMNS; j++ ){
				
				State  newNodeState = n.myState.move(i, j);
				
				if(newNodeState != null){		
					
					
					Node newNode = new Node(newNodeState, Math.abs(i-j) + 1 + n.cost, n, new Pair( i,j));
					
					if(!isAlreadyVisited(newNodeState)){
						n.addChild(newNode);
						newNode.addHeuristic(finalState);
						frontier.add(newNode);
					}
				}
			}
		}
	}
	return false;
}



public boolean aStarInConsistent (State finalState){
	PriorityQueue <Node> frontier = new PriorityQueue<Node>(1,new Comparator<Node>() {
       
        public int compare(Node node1, Node node2)
        {
        	if(node1.cost_heuristic > node2.cost_heuristic){
        		return 1;
        	}
        	return -1;
        }
    });
	
	parentNode.addHeuristic2();
	frontier.add(parentNode);
	
	while(!frontier.isEmpty()){
		
		Node n = frontier.poll();
		
		visitedNodes.add(n);
		
		if(n.isEqual(finalState)){
			System.out.println(n.cost);
			//n.myState.prettyPrint();
			printMoves(n);
			return true;
		}
		
		for(int i = 0; i < COLUMNS; i++ ){
			for(int j = 0; j < COLUMNS; j++ ){
				
				State  newNodeState = n.myState.move(i, j);
				
				if(newNodeState != null){		
					
					
					Node newNode = new Node(newNodeState, Math.abs(i-j) + 1 + n.cost, n, new Pair( i,j));
					
					if(!isAlreadyVisited(newNodeState)){
						n.addChild(newNode);
						newNode.addHeuristic2();
						frontier.add(newNode);
					}
				}
			}
		}
		
	}return false;
}





	
	
}