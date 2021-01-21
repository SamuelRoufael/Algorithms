package B;
import java.util.Scanner;
//https://codeforces.com/contest/1399/problem/B
public class GiftsFixing {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for (int i = 0 ; i < cases ; i++) {
			int size = scanner.nextInt();
			int [] candiesMoves = new int [size];
			int [] orangesMoves = new int [size];
			int candiesMin=0;
			int orangesMin=0;
			int currentNumber;
			int diff=0;
			long moves = 0;
			for (int j = 0 ; j < size ; j++) {
				currentNumber = scanner.nextInt();
				if (j==0) {
					candiesMin = currentNumber;
					continue;
				}
				diff = Math.abs(currentNumber-candiesMin);
				if (currentNumber > candiesMin) {
					candiesMoves[j]+=(diff);
				}
				else if (candiesMin > currentNumber) {
					for (int m = 0 ; m < j ; m++) {
						candiesMoves[m] += (diff);
						candiesMin = currentNumber;
					}
				}
			}
			for (int j = 0 ; j < size ; j++) {
				currentNumber = scanner.nextInt();
				if (j==0) {
					orangesMin = currentNumber;
					continue;
				}
				diff = Math.abs(currentNumber-orangesMin);
				if (currentNumber > orangesMin) {
					orangesMoves[j]+=(diff);
				}
				else if (orangesMin > currentNumber) {
					for (int m = 0 ; m < j ; m++) {
						orangesMoves[m] += (diff);
						orangesMin = currentNumber;
					}
				}
			}
			for (int j = 0 ; j < size ; j++) {
				if (orangesMoves[j] > candiesMoves[j])
					moves += orangesMoves[j];
				else
					moves += candiesMoves[j];
			}
			System.out.println(moves);
		}
		scanner.close();
	}


}
