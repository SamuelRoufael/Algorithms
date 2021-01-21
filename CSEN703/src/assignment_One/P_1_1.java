package assignment_One;

public class P_1_1 {
	int [][] matrix;
	int type = 0;
	public P_1_1(int n) {
		this.matrix = new int [n][n];
	}

	public void solve() {
		if (matrix.length % 3 == 1) {
			divideVertical(0, matrix.length - 2, 0, matrix.length -1);
			divideHorizontal(matrix.length -1, matrix.length -1, 0 , matrix.length -2);
		}
		else if (matrix.length % 3 ==2) {
			int mid = (matrix.length) /2;
			if (matrix.length % 2 == 0)
				mid++;
			divideHorizontal(0, mid -1, 0, mid); // TopLeft
			divideVertical(mid, matrix.length-1, 0, mid-1); // BottomLeft
			divideHorizontal(mid+1, matrix.length-1, mid, matrix.length-1); // BottomRight
			divideVertical(0, mid, mid+1, matrix.length-1); // TopRight
			type = 1;
		}
	}

	private void divideHorizontal(int li, int hi, int lj, int hj) {
		if (hi==li) {
			tileCellsHorizontal(li, lj, hj);
			return;
		}

		int midi = (hi - li) / 2 + li;
		divideHorizontal(li, midi, lj, hj);
		divideHorizontal(midi+1, hi, lj, hj);

	}

	private void divideVertical(int li, int hi, int lj, int hj) {

		if (lj == hj) {
			tileCellsVertical(lj, li, hi);
			return;
		}
		int midj = (hj - lj) / 2 + lj;
		divideVertical(li, hi, lj, midj);
		divideVertical(li, hi, midj+1, hj);


	}

	private void tileCellsHorizontal(int i, int lj, int hj) {
		if (hj - lj == 2) {
			for (int j = lj ; j <= hj ; j++) {
				matrix[i][j] = 1;
			}
			return;
		}
		
		int midj = (hj-lj) / 2 + lj;
		
		if ((hj-lj)%2==0 && type == 0) {
			tileCellsHorizontal(i, midj-1, midj+1);
			tileCellsHorizontal(i, lj, midj-2);
			tileCellsHorizontal(i, midj+2, hj);
			return;
		}
		
		tileCellsHorizontal(i, lj, midj);
		tileCellsHorizontal(i, midj+1, hj);
	}

	private void tileCellsVertical(int j, int li, int hi) {

		if (hi - li == 2) {
			for (int i = li ; i <= hi ; i++) {
				matrix[i][j] = 1;
			}
			return;
		}

		int midi = (hi-li) /2 + li;

		if ((hi- li)%2==0 ) {
			tileCellsVertical(j, midi-1, midi+1);
			tileCellsVertical(j, li, midi-2);
			tileCellsVertical(j, midi+2, hi);
			return;
		}
		tileCellsVertical(j, li, midi);
		tileCellsVertical(j, midi+1, hi);

	}

	public static void main(String[] args) {
		P_1_1 test = new P_1_1(22);
		test.solve();
		Calls.printMatrix(test.matrix);
	}
}

