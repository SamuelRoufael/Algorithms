package assignment_One;

public class P_1_7 {
	int [] a;
	int [] b;

	public P_1_7(int[] a, int[] b) {
		this.a = a;
		this.b = b;
	}

	public int solve() {
		int [][] matrix = new int [a.length+1][a.length+1];

		for (int i = 0 ; i < matrix.length ; i++) {
			matrix[0][i] = 0;
		}

		for (int i = 0 ; i < matrix.length ; i++) {
			matrix[i][0] = 0;
		}

		for (int i = 1 ; i < matrix.length ; i++) {
			for (int j = 1 ; j < matrix.length ; j++) {
				if (b[i-1]==a[j-1]) {
					matrix[i][j] = 1 + Math.max(matrix[i][j-1], matrix[i-1][j]);
				}
				else
					matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
			}
		}
		Calls.printMatrix(matrix);
		return matrix[matrix.length-1][matrix.length-1];
	}
	public static void main(String[] args) {
		int [] a = {1,3,2,4,5};
		int [] b = {2,1,3,5,4};

		P_1_7 test = new P_1_7(a, b);

		System.out.println(test.solve());
		
		
	}


}
