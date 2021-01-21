package C;
// https://codeforces.com/contest/1374/problem/C
import java.util.ArrayList;
import java.util.Scanner;

public class MoveBrackets {
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int numberOfCases = s.nextInt();
		ArrayList<String> strings = new ArrayList<String>();
		for (int i = 0 ; i< numberOfCases ; i++) {
			s.nextInt();
			s.nextLine();
			String string = s.nextLine();
			strings.add(string);
		}
		s.close();
		for(String string : strings) {
			int invalidCounter = 0 ;
			int counter = 0;
			for (int i = 0 ; i < string.length() ; i++) {
				if (string.charAt(i) == '(')
					counter++;
				else {
					counter--;
					if (counter == -1) {
						invalidCounter++;
						counter = 0;
					}
				}
			}
			System.out.println(invalidCounter);
		}
	}
}
