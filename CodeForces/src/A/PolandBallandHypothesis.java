package A;
//https://codeforces.com/problemset/problem/755/A
import java.util.Scanner;

public class PolandBallandHypothesis {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		if (number == 1) 
			System.out.println(3);
		else if (number == 2)
			System.out.println(4);
		else
			System.out.println(number-2);
		scanner.close();
	}
}
