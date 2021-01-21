package C;
//https://codeforces.com/problemset/problem/1375/C
import java.util.Scanner;

public class ElementExtermination {

	public static void main(String []args) {
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		int first = 0;
		int last = 0;
		for (int i = 0 ; i < cases ; i++) {
			int length = s.nextInt();
			for (int j =0 ; j < length ; j++){
				if (j == 0)
					first = s.nextInt();
				else if (j== length -1)
					last = s.nextInt();
				else
					s.nextInt();
			}
			if (last > first)
				System.out.println("YES");
			else
				System.out.println("NO");
			first = 0;
			last = 0;
		}
		s.close();
	}

}
