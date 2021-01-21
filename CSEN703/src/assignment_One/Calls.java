package assignment_One;

public class Calls {
	
	private Calls() {
		
	}
	
	public static void printMatrix(int [][] matrix) {
		for (int i = 0 ; i < matrix.length ; i++) {
			for (int j = 0 ; j < matrix[i].length ; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
