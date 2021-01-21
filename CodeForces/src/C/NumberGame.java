package C;
import java.util.Scanner;

public class NumberGame {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for (int i = 0 ; i < cases ; i++) {
			int number = scanner.nextInt();
			boolean winning = false;
			
			while(number > 1) {
				
				if (winning == false)
					winning = true;
				else
					winning = false;
				
				int reulst = (int) (Math.log(number) / Math.log(2));
				if ((number & 1) != 0 || (2^reulst) == number) {
					break;
				}
		
				int div = leastDiv(number);
				if (div == -1) {
					number--;
				}
				else
					break;
			}
			if (winning == true)
				System.out.println("Ashishgup");
			else
				System.out.println("FastestFinger");
		}
		scanner.close();
	}
	
	public static int leastDivOdd(int number) {
		int div = 3;
		while (div < number) {
			if (number % div == 0)
				return number/div;
			div +=2;
		}
		return -1;
	}
	
	public static int leastDiv(int number) {
		int div = number;
		while (div % 2 == 0) {
			div = div/2;
		}
		if (div == 1)
			return -1;
		if (number / div != 2)
			return div;
		else
			return leastDivOdd(div);
	}
}
