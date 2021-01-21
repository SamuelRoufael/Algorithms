package B;
import java.util.Scanner;

//https://codeforces.com/problemset/problem/1373/B
public class BinaryGame {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		int numberCases = scanner.nextInt();
		scanner.nextLine();
		for (int j = 0 ; j < numberCases ; j++) {
			String binaryString = scanner.nextLine();
			solve(binaryString);
		}
		scanner.close();
	}
	
	public static void solve(String binaryString) {
		String output = "NET";
		for(int i = 0 ; i < binaryString.length()-1 ; i++) {
			if (binaryString.charAt(i) != binaryString.charAt(i+1)) {
				binaryString = binaryString.substring(0, i).concat(binaryString.substring(i+2, binaryString.length()));
				i = 0;
				if (output.compareTo("NET") == 0)
					output = "DA";
				else
					output = "NET";
			}
		}
		if (binaryString.length() >= 2 && binaryString.charAt(0) != binaryString.charAt(1)) {
			if (output.compareTo("NET") == 0)
				output = "DA";
			else
				output = "NET";
		}
		System.out.println(output);
	}
}
