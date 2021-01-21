package C;
import java.util.Scanner;
//https://codeforces.com/problemset/problem/1399/C
public class BoatsCompetition {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		int n;
		int maxSum;
		int k;
		int currentK;
		for (int j = 0 ; j < cases ; j++) {
			n = scanner.nextInt();
			int [] numbers = new int [n+1];
			maxSum = n*2;
			k = 0;
			currentK = 0; 
			for(int i = 0 ; i < n; i++) {
				numbers[scanner.nextInt()]++;
			}
			for (int m =2; m<=maxSum; m++) {
				for(int i = 1 ; i < (m/2)+1 ; i++) {
					int counterOne = numbers[i];
					if(m-i > n)
						continue;
					int counterTwo = 0;
					if (m-i == i)
						counterTwo = numbers[m-i]/2;
					else
						counterTwo = numbers[m-i];
					currentK += (counterOne>=counterTwo) ? counterTwo : counterOne;
				}
				k = (currentK>k)?currentK:k;
				currentK = 0;
			}
			System.out.println(k);
		}
		scanner.close();
	}
	public static void printArray(int [] array) {
		for (Integer i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
