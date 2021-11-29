package codingNinjas;
import java.util.*;
public class QuestionsToPractice {
	
	public static int fastPower(int a, int b) {
        if(b==0) return 1;
        
        if(b%2==0) return fastPower(a*a,b/2);
        else return a * fastPower(a,b-1);
    }
	
	public static void A(int n) {
		if(n<1) return;
		A(n-1);
		System.out.print(n);
		A(n-1);
		A(n-1);
	}

	public static int chocoDistributionProblem(int[] choco, int n, int m) {
		Arrays.sort(choco);
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i+m-1<n; i++) {
			int diff = choco[i+m-1] - choco[i];
			if(diff < min) min = diff;
		}
		
		return min;
	}

	
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	        int a = sc.nextInt();
	        int b = sc.nextInt();
	        
	        System.out.println(fastPower(a,b));
	}
}
