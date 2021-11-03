package AIProject;

import java.util.ArrayList;

public class NeoSearchProblem extends GenericSearchProblem {
	
	public ArrayList<Operator> operatorss;
	String initialState;
	
	//need to set the operators list and their cost
	
	public void assignOperators() {
		
	}

	@Override
	int pathCost(SearchTreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	String stateSpace(String state, Operator operator) {
		// TODO Auto-generated method stub
		//cases for the state after applying operators
		return null;
	}

	@Override
	Boolean goalTest(String state) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
		
	}
		

}
