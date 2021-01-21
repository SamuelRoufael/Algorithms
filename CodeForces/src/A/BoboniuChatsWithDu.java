package A;
// https://codeforces.com/contest/1394/problem/A
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BoboniuChatsWithDu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		long m = scanner.nextLong();
		long totalFun = 0;
		ArrayList<Long> numbers = new ArrayList<Long>();
		for (long i = 0 ; i < n ; i++) {
			long number = scanner.nextLong();
			numbers.add(number);
		}
		scanner.close();
		Collections.sort(numbers);
		int rightPointer = n-1;
		int leftPointger  = 0;
		ArrayList<Long> sums = getSums(numbers, d);
		while (rightPointer > leftPointger+d && numbers.get((int) rightPointer) > sums.get(leftPointger) && numbers.get(rightPointer) > m) {
			totalFun += numbers.get(rightPointer);
			leftPointger += d;
			rightPointer--;
		}
		
		if(numbers.get(rightPointer) <= m)
			leftPointger = (leftPointger-d >= 0) ?leftPointger-d :0;
		
		for (int i = leftPointger ;i <= rightPointer;i++) {
			if (numbers.get(i) <= m) {
				totalFun += numbers.get(i);
			}
			else {
				totalFun += numbers.get(rightPointer);
				rightPointer--;
				i+=(d-1);
			}
		}
		System.out.println(totalFun);

	}

	public static ArrayList<Long> getSums(ArrayList<Long> numbers, int d){
		ArrayList<Long> sums = new ArrayList<Long>();
		long currentSum = 0;
		for (int i = 0; i <= numbers.size() - (d) ; i++) {
			if(i==0) {
				for (int j = 0 ; j<d ;j++) {
					currentSum+=numbers.get(j);
				}
			}
			else {
				currentSum-=numbers.get(i-1);
				currentSum+=numbers.get(i+d-1);
			}
			sums.add(currentSum);
		}
		return sums;
	}

	public static void prlongList(ArrayList<Long> list) {
		for (Long number : list) {
			System.out.print(number + " ");
		}
		System.out.println();
	}
}
