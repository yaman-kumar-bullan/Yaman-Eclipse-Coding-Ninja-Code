package codingNinjas;
import java.util.*;
public class Revision {

	public static int noOfWords(String str) {
		if(str.length()==0) return 0;
		
		String[] array = str.split(" ");
		
		if(array.length==0) return 1;
		else {
			return array.length;
		}
	}
	
	public static boolean palindrome(String str) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=str.length()-1; i>=0; i--) {
			sb.append(str.charAt(i));
		}
		
		String rev = sb.toString();
		
		if(str.equals(rev)) return true;
		else return false;
	}
	
	public static void printPrefix(String str) {
		for(int i=0; i<str.length(); i++) {
			System.out.println(str.substring(0,i+1));
		}
	}

	public static void printAllSubStrings(String str) {
		for(int i=0; i<str.length(); i++) {
			for(int j=i; j<str.length(); j++) {
				System.out.println(str.substring(i,j+1));
			}
		}
	}

	public static String reverseStringWordWise(String str) {
		if(str.length() == 0) return str;
		
		String[] array = str.split(" ");
		
		if(array.length == 0) return str;
		else {
			String rev = "";
			for(int i=array.length-1; i>=0; i--) {
				rev = rev + array[i] + " ";
			}
			rev = rev.trim();
			return rev;
		}
	}
	
	public static boolean permutation(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		
		for(int i=0; i<char1.length; i++) {
			if(char1[i] != char2[i]) return false;
		}
		
		return true;
	}
	
	public static String removeConsecutiveDuplicates(String str) {
		StringBuilder sb = new StringBuilder();
		int n = str.length();
		
		for(int i=0; i<n-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				if(i==n-2) sb.append(str.charAt(i));
				continue;
			}
			else {
				sb.append(str.charAt(i));
				if(i==n-2) sb.append(str.charAt(i+1));
			}
		}
		return sb.toString();
	}
	
	public static String reverseString(String str) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=str.length()-1; i>=0; i--) {
			sb.append(str.charAt(i));
		}
		
		return sb.toString();
	}

	public static String reverseEachWord(String str) {
		if(str.length() == 0) return str;
		
		String[] array = str.split(" ");
		
		if(array.length == 0) return reverseString(str);
		else {
			String rev = "";
			for(int i=0; i<array.length; i++) {
				rev = rev + reverseString(array[i]) + " ";
			}
			rev = rev.trim();
			return rev;
		}
	}

	public static String removeCharacter(String str, char x) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == x) continue;
			else sb.append(str.charAt(i));
		}
		
		str = sb.toString();
		return str;
	}
	
	public static String compressTheString(String str) {
		if(str.length() == 0) return str;
		
		int n = str.length();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n-1; i++) {
			int count = 1;
			
			while(str.charAt(i+1) == str.charAt(i)) {
				count++;
				i++;
				if(i==n-1) break;
			}
			
			sb.append(str.charAt(i));
			if(count > 1) {
				sb.append(count);
			}
			
			if(i==n-2) sb.append(str.charAt(i+1));
		}
		
		return sb.toString();
	}
	
	public static char highestOccuringCharacter(String str) {
		int n = str.length();
		int[] freq = new int[256];
		
		for(int i=0; i<n; i++) {
			freq[str.charAt(i)]++;
		}
		
		int max = -1;
		char result = ' ';
		
		for(int i=0; i<n; i++) {
			if(freq[str.charAt(i)] > max) {
				max = freq[str.charAt(i)];
				result = str.charAt(i);
			}
		}
		return result;
	}

	public static int[][] takeInput() {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int[][] input = new int[rows][cols];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		return input;
	}

	public static void print2DArray(int[][] input) {
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[i].length; j++) {
				System.out.println(input[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[] rowWiseSum(int[][] input) {
		int[] ans = new int[input.length];
		int index = 0;
		
		for(int i=0; i<input.length; i++) {
			int sum = 0;
			for(int j=0; j<input[i].length; j++) {
				sum += input[i][j];
			}
			ans[index++] = sum;
		}
		
		return ans;
	}
	
	public static int findMaxInArray(int[] a) {
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<a.length; i++) {
			max = Math.max(max, a[i]);
		}
		return max;
	}
	
	public static String largestRowOrColumn(int[][] input) {
		int rows = input.length;
		int cols = input[0].length;
		
		int rowSum[] = new int[rows];
		int colSum[] = new int[cols];
		
		for(int i=0; i<rows; i++) {
			int sum = 0;
			for(int j=0; j<cols; j++) {
				sum += input[i][j];
			}
			rowSum[i] = sum;
		}
		
		for(int i=0; i<cols; i++) {
			int sum = 0;
			for(int j=0; j<rows; j++) {
				sum += input[j][i];
			}
			colSum[i] = sum;
		}
		
		int maximumSumInRow = rowSum[0];
		int maxRowIndex = 0;
		
		for(int i=1; i<rows; i++) {
			if(rowSum[i] > maximumSumInRow) {
				maximumSumInRow = rowSum[i];
				maxRowIndex = i;
			}
		}
		
		int maximumSumInCol = colSum[0];
		int maxColIndex = 0;
		
		for(int i=0; i<cols; i++) {
			if(colSum[i] > maximumSumInCol) {
				maximumSumInCol = colSum[i];
				maxColIndex = i;
			}
		}
		
		String ans = "";
		
		if(maximumSumInRow >= maximumSumInCol) {
			ans = "row " + Integer.toString(maxRowIndex) + " " + Integer.toString(maximumSumInRow);
			return ans;
		} else {
			ans = "column " + Integer.toString(maxColIndex) + " " + Integer.toString(maximumSumInCol);
			return ans;
		}
	}
	
	public static int[] printLikeAWave(int[][] input) {
		int row = input.length;
		int col = input[0].length;
		
		int ans[] = new int[row*col];
		int index = 0;
		
		for(int i=0; i<col; i++) {
			if(i%2==0) {
				for(int j=0; j<row; j++) ans[index++] = input[j][i];
			} else {
				for(int j=row-1; j>=0; j--) ans[index++] = input[j][i];
			}
		}
		return ans;
	}
	
	public static int[] printSpiral(int[][] input) {
		int row=input.length, col = input[0].length;
		int top=0, left=0, down=row-1, right=col-1;
		int dir=0;
		int ans[] = new int[row*col];
		int index = 0;
		
		while(top<=down && left<=right) {
			if(dir==0) {
				for(int i=left; i<=right; i++) {
					ans[index++] = input[top][i];
				}
				top++;
			} else if(dir==1) {
				for(int i=top; i<=down; i++) {
					ans[index++] = input[i][right];
				}
				right--;
			} else if(dir==2) {
				for(int i=right; i>=left; i--) {
					ans[index++] = input[down][i];
				}
				down--;
			} else if(dir==3) {
				for(int i=down; i>=top; i--) {
					ans[index++] = input[i][left];
				}
				left++;
			}
			
			dir = (dir+1)%4;
		}
		return ans;
	}
	
	public static int BinarySearch(int[] a, int x) {
		int s=0, e=a.length-1;
		while(s<=e) {
			int mid = (s+e)/2;
			if(a[mid]==x) return mid;
			else if(a[mid]>x) e=mid-1;
			else if(a[mid]<x) s=mid+1;
		}
		return -1;
	}
	
	public static void selectionSort(int[] a) {
		int n = a.length;
		
		for(int i=0; i<n-1; i++) {
			int min = a[i];
			int index = i;
			for(int j=i; j<n; j++) {
				if(a[j] < min) {
					min = a[j];
					index = j;
				}
			}
			if(index != i) {
				int temp = a[i];
				a[i] = a[index];
				a[index] = temp;
			}
		}
	}
	
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-i-1; j++) {
				if(arr[j+1]<arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void insertionSort(int[] arr) {
		int n = arr.length;
		
		for(int i=1; i<n; i++) {
			int j = i-1;
			int temp = arr[i];
			while(j>=0 && temp<arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	public static boolean isPrime(int n) {
		if(n<=1) return false;
	
		for(int i=2; i<n; i++) {
			if(n%i==0) return false;
		}
		
		return true;
	}
	
	/* 
	 * Recursion Problems
	 */
	
	public static int fact(int n) {
		if(n==0) return 1;
		
		return n*fact(n-1);
	}
	
	public static int sumOfNNaturalNumbers(int n) {
		if(n==1) return 1;
		return n + sumOfNNaturalNumbers(n-1);
	}
	
	public static int fib(int n) {
		if(n==1 || n==2) {
			return n-1;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static int power(int a, int b) {
		if(b==0) return 1;
		return a * power(a, b-1);
	}
	
	public static int fastPower(int a, int b) {
		if(b==0) return 1;
		
		if(b%2==0) return fastPower(a*a, b/2);
		else return a * fastPower(a,b-1);
	}
	
	public static void printUptoN(int n) {
		if(n>=1) {
			printUptoN(n-1);
			System.out.print(n + " ");
		}
	}

	public static int noofDigits(int n) {
		if(n/10==0) return 1;            //If n is a single digit number
		return 1 + noofDigits(n/10);
	}
	
	//Check array sorted, sum of array, find x in array, find first occurrence of x, find last occurrence of x, print all occurrences of x
	
	public static boolean checkSorted(int[] input, int startIndex) {
		if(startIndex == input.length-1) return true;
		
		if(input[startIndex] > input[startIndex+1]) return false;
		
		return checkSorted(input, startIndex+1); 
	}
	
	public static boolean checkSorted(int[] input) {
		return checkSorted(input, 0);
	}
	
	public static int sumOfArray(int[] input, int startIndex) {
		if(startIndex == input.length-1) return input[startIndex];
		
		return input[startIndex] + sumOfArray(input, startIndex+1);
	}
	
	public static int sumOfArray(int[] input) {
		return sumOfArray(input, 0);
	}
	
	public static boolean findX(int[] input, int x, int startIndex) {
		if(startIndex == input.length-1) {
			if(input[startIndex] == x) return true;
			else return false;
		}
		
		if(input[startIndex] == x) return true;
		
		return findX(input, x, startIndex+1);
	}
	
	public static boolean findX(int[] input, int x) {
		return findX(input, x, 0);
	}
	
	public static int firstX(int[] input, int x, int startIndex) {
		if(startIndex == input.length-1) {
			if(input[startIndex] == x) return startIndex;
			return -1;
		}
		
		if(input[startIndex] == x) return startIndex;
		
		return firstX(input, x, startIndex+1);
	}
	
	public static int firstX(int[] input, int x) {
		return firstX(input, x, 0);
	}
	
	public static int lastX(int[] input, int x, int startIndex, int lastIndex) {
		if(startIndex == input.length-1) {
			if(input[startIndex] == x) {
				lastIndex = startIndex;
				return lastIndex;
			}
			return lastIndex;
		}
		
		if(input[startIndex] == x) lastIndex = startIndex;
		
		return lastX(input, x, startIndex+1, lastIndex);
	}
	
	public static int lastX(int[] input, int x) {
		return lastX(input, x, 0, -1);
	}
	
	public static void printX(int[] input, int x, int startIndex) {
		if(startIndex == input.length-1) {
			if(input[startIndex] == x) {
				System.out.print(startIndex + " ");
				return;
			}
			else return;
		}
		
		if(input[startIndex] == x) System.out.print(startIndex + " ");
		
		printX(input, x, startIndex+1);
	}
	
	public static void printX(int[] input, int x) {
		printX(input, x, 0);
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input[] = {1,2,3,4,5,3};
		int x = 3;
		printX(input, x);
		
	}
}

