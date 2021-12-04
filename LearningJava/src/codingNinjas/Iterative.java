package codingNinjas;

public class Iterative {
	
	public static int noOfDigits(int n) {
		int count = 0;
		
		if(n==0) return 1;
		
		while(n!=0) {
			count++;
			n=n/10;
		}
		
		return count;
	}

}
