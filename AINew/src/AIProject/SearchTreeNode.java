package AIProject;

import java.util.ArrayList;

public class SearchTreeNode implements Operator {
	ArrayList<String> state = new ArrayList<String>(); //generic 7agat
	SearchTreeNode parent = new SearchTreeNode();
	Operator operator;
	int depth;
	int pathCost;
}
