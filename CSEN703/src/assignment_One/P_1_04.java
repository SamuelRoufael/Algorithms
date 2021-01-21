package assignment_One;

public class P_1_4 {
	int [][] matrix;
	int moveDirection = 1; // 1 right , 2 left, 3 up , 4 down
	int centeri;
	int centerj;
	int toweri;
	int towerj;

	public P_1_4(int n) {
		matrix = new int [n][n];
		centerj = (matrix.length-1) / 2;
		if (n%2 ==0)
			centeri = ((matrix.length-1) / 2) +1 ;
		else 
			centeri = (matrix.length-1) / 2; 
	}

	public void solve() {
		while (toweri != centeri || towerj != centerj) {
			if (moveDirection == 1) {
				moveRight();
				moveDirection = 4;
			}
			else if (moveDirection == 2){
				moveLeft();
				moveDirection = 3;
			}
			else if (moveDirection == 3) {
				moveUp();
				moveDirection = 1;
			}
			else {
				moveDown();
				moveDirection = 2;
			}
		}
		matrix[toweri][towerj] = 1;
	}	
	
	private void moveRight() {
		while (towerj < matrix.length && matrix[toweri][towerj] == 0) {
			matrix[toweri][towerj] = 1;
			towerj++;
		}
		toweri++;
		towerj--;
	}
	
	private void moveLeft() {
		while ( towerj >= 0 && matrix[toweri][towerj] == 0) {
			matrix[toweri][ towerj] = 1;
			towerj--;
		}
		toweri--;
		towerj++;
	}
	
	private void moveDown() {
		while(toweri < matrix.length && matrix[toweri][ towerj] == 0) {
			matrix[toweri][towerj] = 1;
			toweri++;
		}
		toweri--;
		towerj--;
	}
	
	private void moveUp() {
		while (toweri >= 0 && matrix[toweri][towerj] == 0 ) {
			matrix[toweri][towerj] = 1; 
			toweri--;
		}
		toweri++;
		towerj++;
	}

	public static void main(String[] args) {
		P_1_4 test = new P_1_4(6);
		test.solve();
		Calls.printMatrix(test.matrix);
	}

}

