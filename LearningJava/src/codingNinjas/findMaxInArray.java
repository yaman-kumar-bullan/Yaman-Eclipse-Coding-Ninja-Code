package codingNinjas;
import java.util.*;

public class findMaxInArray {
	
	public static void takeInput(int[] arr) {
		Scanner sc = new Scanner(System.in);
		int n = arr.length;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
	}
	
	public static int findMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		int n = arr.length;
		for(int i=0; i<n; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}
	
	public static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void swapAdjacent(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n-1; i=i+2) {
			int temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		}
	}
	
	public static void sort012(int[] arr) {
		int n = arr.length;
		int zero = 0;
		int one = 0;
		int two = 0;
		
		for(int i : arr) {
			if(i==0) zero++;
			else if(i==1) one++;
			else if(i==2) two++;
		}
		
		for(int i=0; i<n; i++) {
			if(i<zero) arr[i] = 0;
			else if(i<zero+one) arr[i] = 1;
			else arr[i] = 2;
		}
	}
	
	public static int secondLargest(int[] arr) {
		int n = arr.length;
		
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			first = Math.max(first, arr[i]);
		}
		
		for(int i=0; i<n; i++) {
			if(arr[i] == first) continue;
			second = Math.max(arr[i], second);
		}
		
		return second;
	}
	
	public static int[] findSumOfBothArrays(int[] arr1, int[] arr2) {
		int num1 = 0;
		for(int i=0; i<arr1.length; i++) {
			num1 = num1*10 + arr1[i];
		}
		
		int num2 = 0;
		for(int i=0; i<arr2.length; i++) {
			num2 = num2*10 + arr2[i];
		}
		
		int num3 = num1 + num2;
		
		ArrayList<Integer> al = new ArrayList<>();
		while(num3 > 0) {
			int lastDigit = num3 % 10;
			al.add(lastDigit);
			num3 = num3/10;
		}
		
		int temp = arr1.length>arr2.length ? arr1.length : arr2.length;
		
		if(al.size() == temp) al.add(0);
		
		int res[] = new int[al.size()];
		int index = 0;
		for(int i=al.size()-1; i>=0; i--) {
			res[index++] = al.get(i);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int ans[][] = new int[t][];
		int index = 0;
		
		while(t-->0) {
			int m = sc.nextInt();
			int[] arr1 = new int[m];
			takeInput(arr1);
			int n = sc.nextInt();
			int[] arr2 = new int[n];
			takeInput(arr2);
			ans[index++] = findSumOfBothArrays(arr1, arr2);
		}
		
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}
