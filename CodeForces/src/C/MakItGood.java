//https://codeforces.com/problemset/problem/1385/C
package C;
import java.util.Scanner;

public class MakItGood {
	public static void main(String []args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		int size;
		for (int a = 0 ; a < cases ; a++) {
			size = scanner.nextInt();
			int [] array = new int [size];
			for (int i = 0 ; i < size ; i++) {
				array[i] = scanner.nextInt();
			}
			int pointer = array.length-1;
			while (pointer > 0 && array[pointer] <= array[pointer-1])
				pointer--;
			while (pointer > 0 && array[pointer] >= array[pointer-1])
				pointer--;
			System.out.println(pointer);
		}
		scanner.close();
	}
}
