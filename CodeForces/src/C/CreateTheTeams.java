package C;
//https://codeforces.com/problemset/problem/1380/C
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CreateTheTeams {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		int size;
		int numberTeams;
		int x;
		int teamSize;
		for (int j = 0 ; j < cases ; j++) {
			size = scanner.nextInt();
			x = scanner.nextInt();
			numberTeams = 0;
			teamSize = 2;
			ArrayList<Integer> numbers = new ArrayList<Integer>(); 
			for (int i = 0 ; i < size ; i++) {
				int number = scanner.nextInt();
				if (number >=x) {
					numberTeams++;
					continue;
				}
				numbers.add(number);
			}
			Collections.sort(numbers);
			while (teamSize <= numbers.size()) {
				while (true) {
					if (teamSize <= numbers.size() && numbers.get(numbers.size()-teamSize)*teamSize >= x) {
						numberTeams++;
						for (int a = 0 ; a < teamSize ; a++)
							numbers.remove(numbers.size()-1);
					}
					else
						break;
				}
				teamSize++;
			}
			System.out.println(numberTeams);
		}
		scanner.close();
	}
}
