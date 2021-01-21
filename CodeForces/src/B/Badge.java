package B;
// https://codeforces.com/problemset/problem/1020/B
import java.util.Scanner;
public class Badge {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int [] list = new int [size+1];
		for (int i = 1 ; i < list.length ; i++)
			list[i] = scanner.nextInt();
		scanner.close();
		for (int i =1 ; i < list.length ; i++) {
			int next = list[i];
			boolean [] visited = new boolean [size+1];
			visited[i] = true;
			while(visited[next] != true) {
				visited[next] = true;
				next = list[next];
			}
			System.out.println(next);
		}
	}
}
