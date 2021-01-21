package assignment_One;
import java.lang.Math;
public class P_1_6 {

	public static void solve(int W,int type) {  
		int power = 0; 
		int maxNumber = 1; 
		int output = 0;

		while (maxNumber < W) {  
			power++; 
			maxNumber *= 3;
		} 
		if (type == 0)
			output = 2;
		else
			output = 3;

		for (int i = 0; i <= power; i++) {  

			System.out.print((int)Math.pow(output, i) + " "); 
		} 
	} 

	public static void main (String[] args) {  
//		 solve(MaxWeight,type)
//		 type : 0 --> part.(a) , 1 --> part.(b)
//		(a) weights can be put only on the free pan of the scale.
//		(b) weights can be put on both pans of the scale.
		solve(6,0); 
		
	}	
}