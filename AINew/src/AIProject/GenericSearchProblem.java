package AIProject;

import java.util.ArrayList;

public abstract class GenericSearchProblem {

	ArrayList<String> operators;
	ArrayList<String> initialState;
	ArrayList<String> stateSpace;
	
	
	abstract Boolean goalTest(ArrayList<String> state);
	abstract int pathCost(SearchTreeNode node);
}
