package assignment_One;
 
public class P_1_10 { 
	public static void main (String[] args) { 
		int n = 7; 
		printPascal(n); 
	} 

	public static void printPascal(int n) {  
		int[][] arr = new int[n][n]; 
 
		for (int line = 0; line < n; line++) 	{ 
			for (int i = 0; i <= line; i++) {  
				if (line == i || i == 0) 
					arr[line][i] = 1; 
				else 
					arr[line][i] = arr[line-1][i-1] + arr[line-1][i]; 
			} 
		}
		int totalSum = 0;
		for (int i = 0 ; i < n ; i++) {
			totalSum += arr[n-1][i];
		}
		System.out.println((int)Math.pow(((4*totalSum)-4), 2));
		
	} 
}