package assignment_One;

public class P_1_12 {
	int [] array;

	public P_1_12(int[] array) {
		this.array = array;
	}
	
	public int rec(int low,int high) {
		if (low > high)
			return 0;
		else if (high == low)
			return array[low];
		else if (high == low + 1)
			return Math.max(array[low] + array[high], array[low]*array[high]);
		else {
			int mid = ((high-low)/2) + low;
			
			if (array[mid]*array[mid+1] >= array[mid]*array[mid-1]) 
				return array[mid]*array[mid+1] + rec(low, mid-1) + rec(mid+2, high);
			
			else
				return array[mid]*array[mid-1] + rec(low,mid-2) + rec(mid+1, high);
		}
	}
	
	public static void main(String[] args) {
		int [] array = {2, 2, 1, 3, 2, 1, 2, 2, 1, 2};
		P_1_12 test = new P_1_12(array);
		System.out.println(test.rec(0,array.length-1));
	}
	
}
