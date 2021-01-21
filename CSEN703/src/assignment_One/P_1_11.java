package assignment_One;

import java.util.ArrayList;

public class P_1_11 {
	ArrayList<Integer> floors; // each cell contains the maximum number of floors for which the problem can be solved in k drops.
	int maxFloor; // maximum floor

	public P_1_11(int maxFloor) {
		this.floors = new ArrayList<Integer>();
		this.maxFloor = maxFloor;
	}

	public int solve() {
		// base case having no drops 
		floors.add(0);
		
		int k = 1;
		while(floors.get(floors.size()-1) < maxFloor){
			
			floors.add(k + floors.get(k-1));
			k++;
		}
		
		return floors.size() - 1;
	}

	public static void main(String[] args) {
		P_1_11 test = new P_1_11(10);
		System.out.println(test.solve());
	}


}
