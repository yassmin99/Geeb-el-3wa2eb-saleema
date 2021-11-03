package AIProject;

public enum operators implements Operator {
	UP, DOWN, LEFT, RIGHT, CARRY, DROP, TAKEPILL, KILL, FLY;
	
	int cost;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	

}
