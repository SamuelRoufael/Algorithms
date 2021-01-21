package assignment_One;

import java.util.ArrayList;

public class P_1_8 {
	int items [];
	boolean takenItems [];
	ArrayList<ArrayList<ArrayList<Integer>>> matrix;
	int [][] matrixSum; 
	int weight;
	
	public P_1_8(int[] items, int totalWeight) {
		this.items = items;
		this.takenItems = new boolean [items.length];
		this.matrix = new ArrayList<ArrayList<ArrayList<Integer>>>();
		weight = totalWeight /3;
		
		for (int i = 0; i <= items.length ; i++) {
			matrix.set(i, new ArrayList<ArrayList<Integer>>());
			for (int j = 0 ; j <= weight ; j++) {
				matrix.get(i).set(j, new ArrayList<Integer>());
			}
		}
		
		matrixSum = new int [items.length+1][weight+1];
		
		for (int i = 0 ; i <= items.length ; i++) {
			matrixSum[i][0] = 0;
		}
		
		for (int j = 0 ; j <= weight ; j++) {
			matrixSum[0][j] = 0;
		}
	}
	
	public void solve() {
		for (int i = 1 ; i <= items.length ; i++) {
			for (int j = 1 ; j<=weight ; j++) {
				int currentItem = items[i-1];
				if (currentItem <= j) {
					matrixSum[i][j] = matrixSum[i-1][j-currentItem];
					matrix.get(i).get(j).add(currentItem);
				}
				
				if (j == weight && matrixSum[i][j]==weight && allFree(matrix.get(i).get(j))) {
					setTaken(matrix.get(i).get(j));
					printlist(matrix.get(i).get(j));
				}
			}
		}
	}
	
	private void printlist(ArrayList<Integer> list) {
		for (Integer i : list) {
			System.out.println(i + " ");
		}
		System.out.println();
	}
	
	private boolean allFree(ArrayList<Integer> list) {
		
		for (int i = 0 ; i < takenItems.length ; i ++) {
			if (takenItems[i]== true && list.contains((items[i])))
				return false;
		}
		return true;
	}
	
	private void setTaken(ArrayList<Integer> list) {
		for (int i = 0 ; i < takenItems.length ; i ++) {
			if (takenItems[i]== true && list.contains(items[i]))
				takenItems[i] = true;
		}
	}
}
