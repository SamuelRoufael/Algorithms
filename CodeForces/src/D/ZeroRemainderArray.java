package D;

import java.util.ArrayList;
import java.util.Scanner;

//https://codeforces.com/problemset/problem/1374/D
public class ZeroRemainderArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfCases = scanner.nextInt();
		for (int i =0 ; i < numberOfCases ; i++) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(k);
			for (int j = 0 ; j < n ; j++) {
				int number = scanner.nextInt();
				int remainder = number%k;
				
				if (list.get(remainder) == null) 
					list.add(new ArrayList<Integer>());
				
				list.get(remainder).add(number);
			}
		}
		scanner.close();
	}
}
