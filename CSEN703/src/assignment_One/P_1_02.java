package assignment_One;
import java.lang.Math; 

public class P_1_2 {
	int [][] matrix;

	public P_1_2(int n) {
		int length = (int) Math.pow(2, n);
		this.matrix = new int [length][length];
	}

	public void solve() {
		recMethod(0, matrix.length-1, 0, matrix.length-1, 3,false);
	}
	// location 1 --> TopLeft, 2 --> TopRight, 3 --> BottomLeft, 4 --> BottomRight
	// color 1 1 --> Red, 2 --> Green, 3 --> Blue
	private void recMethod(int li, int hi, int lj, int hj, int location, boolean containsMissingCell) {
		int midi = (hi-li)/2 + li;
		int midj = (hj-lj)/2 + lj;

		// baseCase --> if there is a matrix of type 2x2
		if (midi == li && midj == lj) {

			if (location == 1) {
				if (matrix[midi][midj] !=0)
					drawL(midi, midj, 4, 2);
				else
					drawL(midi, midj, location, 2);
			}
			else if (location == 2) {
				if (matrix[midi][midj+1] != 0)
					drawL(midi, midj, 3, 3);
				else
					drawL(midi, midj, location, 3);
			}
			else if (location == 3) {
				if (matrix[midi+1][midj] != 0)
					drawL(midi, midj, 2, 3);
				else
					drawL(midi, midj, location, 3);
			}
			else {
				if (matrix[midi+1][midj+1] != 0)
					drawL(midi, midj, 1, 2);
				else
					drawL(midi, midj, location, 2);
			}
			return;
		}
		
		// inverts the middle L shape if this square contains the missing cell.
		if (containsMissingCell) {
			if (location == 1)
				drawL(midi, midj, 4, 1);
			else if (location == 2)
				drawL(midi, midj, 3, 1);
			else if (location == 3)
				drawL(midi, midj, 2, 1);
			else
				drawL(midi, midj, 1, 1);
		}
		else
			drawL(midi, midj, location, 1); // draws a L shape at center of the square

		// divide 
		if (location == 4 && !containsMissingCell)
			recMethod(li, midi, lj, midj, 1,true); // TopLeft with a missing cell
		else if (location == 1 && containsMissingCell)
			recMethod(li, midi, lj, midj, 1,true); // TopLeft with a missing cell as the current mid L is inverted
		else
			recMethod(li, midi, lj, midj, 1,false); // TopLeft 

		if (location == 3 && !containsMissingCell)
			recMethod(li, midi, midj+1, hj, 2,true); // TopRight with a missing cell
		else if (location == 2 && containsMissingCell)
			recMethod(li, midi, midj+1, hj, 2,true); // TopRight with a missing cell as the current mid L is inverted
		else 
			recMethod(li, midi, midj+1, hj, 2,false); // TopRight 

		if (location == 2 && !containsMissingCell)
			recMethod(midi + 1, hi, lj, midj, 3,true); // BottomLeft with a missing cell
		else 	if (location == 3 && containsMissingCell)
			recMethod(midi + 1, hi, lj, midj, 3,true); // BottomLeft with a missing cell as the current mid L is inverted
		else
			recMethod(midi + 1, hi, lj, midj, 3,false); // BottomLeft 

		if (location == 1 && !containsMissingCell)
			recMethod(midi+1, hi, midj+1, hj, 4,true); // BottomRight with a missing cell
		else if (location == 4 && containsMissingCell)
			recMethod(midi+1, hi, midj+1, hj, 4,true); // // BottomRight with a missing cell as the current mid L is inverted
		else
			recMethod(midi+1, hi, midj+1, hj, 4,false); // BottomRight 

	}

	private void drawL(int midi, int midj, int location,int color) {
		if (location == 1) {
			matrix[midi][midj] = color;
			matrix[midi+1][midj] = color;
			matrix[midi][midj+1] = color;
		}
		else if (location == 2) {
			matrix[midi][midj] = color;
			matrix[midi][midj+1] = color;
			matrix[midi+1][midj+1] = color;
		}
		else if (location == 3) {
			matrix[midi][midj] = color;
			matrix[midi+1][midj] = color;
			matrix[midi+1][midj+1] = color;
		}
		else {
			matrix[midi+1][midj] = color;
			matrix[midi+1][midj+1] = color;
			matrix[midi][midj+1] = color;

		}
	}

	public static void main(String[] args) {
		P_1_2 test = new P_1_2(3);
		test.solve();
		Calls.printMatrix(test.matrix);
	}
}
