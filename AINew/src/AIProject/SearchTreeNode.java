package AIProject;

import java.util.ArrayList;

public class SearchTreeNode {
	String state; //generic 7agat
	SearchTreeNode parent = new SearchTreeNode();
	Operator operator;
	int depth;
	int pathCost;
	
	
	public static void main(String[] args) {
		//int cost  = operators.DOWN.cost;
		
		operators.CARRY.setCost(10);
		System.out.println(operators.CARRY.getCost());
		
	}
	
	
	
	
}

