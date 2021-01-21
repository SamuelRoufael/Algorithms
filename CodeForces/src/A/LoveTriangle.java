package A;
// https://codeforces.com/problemset/problem/939/A
import java.util.Scanner;

public class LoveTriangle {
	
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int [] list = new int [size+1];
		
		for (int i = 1 ; i<list.length ; i++) 
			list[i] = scanner.nextInt();
		
		scanner.close();
		
		for (int i = 1 ; i < list.length ; i++) {
			if (i == list[list[list[i]]]) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
		
	}
}