package AIProject;

import java.util.ArrayList;

public abstract class GenericSearchProblem {

	public ArrayList<Operator> operators;
	String initialState;
	
	
	public void setOperators(ArrayList<Operator> operators) {
		this.operators = operators;
	}
	public void setInitialState(String initialState) {
		this.initialState = initialState;
	}
	abstract Boolean goalTest(String state);
	abstract int pathCost(SearchTreeNode node);
	abstract String stateSpace(String state, Operator operator);
}
