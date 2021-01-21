// https://codeforces.com/problemset/problem/1399/A
package A;
import java.util.Scanner;

public class RemoveSmallest {

	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int testcases = scanner.nextInt();
		boolean flag = false;
		String output = "YES";
		for (int j = 0 ; j < testcases ; j++) {
			output = "YES";
			flag = false;
			int [] numbers = new int [101];
			int size = scanner.nextInt();
			for (int i = 0 ; i<size;i++) {
				numbers[scanner.nextInt()]++;
			}
			for (int i =1 ; i < numbers.length ; i++) {
				if (i == numbers.length-1 && numbers[i]>0 && flag == true) {
					output = "NO";
					break;
				}
				if(i != numbers.length-1 && numbers[i]>0 && numbers[i+1] == 0) {
					if(flag == true) {
						output = "NO";
						break;
					}
					else
						flag = true;
				}
			}
			System.out.println(output);
		}
		scanner.close();
	}
}
