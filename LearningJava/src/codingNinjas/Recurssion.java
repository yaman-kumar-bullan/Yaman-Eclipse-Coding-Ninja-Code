package codingNinjas;
import java.util.*;
public class Recurssion {
	
	public static int factorial(int n) {
		if(n==0) return 1;                    //Base case
		return n*factorial(n-1);                //If somehow we get the factorial of n-1
	}
	
	public static int sum(int n) {
		if(n==1) return 1;
		return n + sum(n-1);     //If somehow we get the sum of n-1 natural numbers
	}
	
	public static int power(int x, int n) { //Finding x^n
		if(n==0) return 1;
		return x * power(x,n-1);
	}
	
	public static int fastPower(int a, int n) {
		if(n==0) return 1;
		
		if(n%2==0) return fastPower(a*a,n/2);
		else return a * fastPower(a,n-1);
	}
	
	static int i =  0;
	
	public static void printUptoNInIncreasingOrder(int n) {   //I need to revise it
		if(n>=1) {
			printUptoNInIncreasingOrder(n-1);
			System.out.println(n);
		}
	}

	public static int noOfDigits(int n) {
		if(n/10==0) {
			return 1;
		}
		
		return 1 + noOfDigits(n/10);
	}
	
	public static int fib(int n) {   //Here we need to have two base cases because we are dealing with two different instances of the function
		if(n==1) {                          
			return 0;
		}
		if(n==2) {
			return 1;
		}
		
		return fib(n-1) + fib(n-2);
	}
	
	public static boolean checkSorted(int[] input) {
		if(input.length <= 1) return true;
		
		int[] smallArray = new int[input.length-1];
		for(int i=1; i<input.length; i++) {
			smallArray[i-1] = input[i];
		}
		
		boolean smallAns = checkSorted(smallArray);
		
		if(smallAns) {
			if(input[0] <= smallArray[0]) return true;
			else return false;
		} else return false;
	}
	
	public static boolean checkSorted_2(int[] input) {
		if(input.length <= 1) return true;
		
		if(input[0] > input[1]) return false;
		
		int[] smallinput = new int[input.length-1];
		for(int i=1; i<input.length; i++) {
			smallinput[i-1] = input[i];
		}
		
		boolean ans = checkSorted_2(smallinput);
		return ans;
	}
	
	public static boolean checkSortedBetter(int[] input, int startIndex) {
		if(startIndex == input.length-1) return true;
		
		if(input[startIndex] > input[startIndex+1]) return false;
		
		boolean ans = checkSortedBetter(input,startIndex+1);
		return ans;
	}
	
	public static int sumOfArray(int[] input) {
		if(input.length==1) return input[0];
		
		int[] smallInput = new int[input.length-1];
		for(int i=1; i<input.length; i++) {
			smallInput[i-1] = input[i];
		}
		
		return input[0] + sumOfArray(smallInput);
	}
	
	public static boolean findX(int[] input, int x) {
		if(input.length == 1) {
			if(input[0]==x) return true;
			else return false;
		}
		
		if(input[0] == x) return true;
		
		int[] smallInput = new int[input.length-1];
		for(int i=1; i<input.length; i++) {
			smallInput[i-1] = input[i];
		}
		
		boolean isPresent = findX(smallInput,x);
		return isPresent;
	}
	
	public static boolean findXBetter(int[] input, int x, int startIndex) {
		if(startIndex == input.length-1) {
			if(input[startIndex] == x) return true;
			else return false;
		}
		
		if(input[startIndex] == x) return true;
		
		boolean ans = findXBetter(input, x, startIndex+1);
		return ans;
	}
	
	public static int findIndexOfX(int[] input, int x, int startIndex) {
		if(startIndex == input.length-1) {
			if(input[startIndex] == x) return startIndex;
			else return -1;
		}
		
		if(input[startIndex] == x) return startIndex;
		
		return findIndexOfX(input, x, startIndex+1);
	}
	
	public static int findIndexOfX(int[] input, int x) {
		return findIndexOfX(input, x, 0);
	}
	
	public static int findLastIndexOfX(int[] input, int x, int startIndex, int lastIndex) {
		
		if(startIndex == input.length-1) {
			if(input[startIndex] == x) {
				lastIndex = startIndex;
				return lastIndex;
			}
			else return lastIndex;
		}
		
		if(input[startIndex] == x) lastIndex = startIndex;
		
		return findLastIndexOfX(input, x, startIndex+1, lastIndex);
	}

	public static int findLastIndexOfX(int[] input, int x) {
		
		return findLastIndexOfX(input, x, 0, -1);
		 
	}
	
	public static void printAllIndexesOfX(int[] input, int x, int startIndex) {
		
		if(startIndex == input.length-1) {
			if(input[startIndex] == x) {
				System.out.print(startIndex + " ");
				return;
			}
			else return;
		}
		
		if(input[startIndex] == x) System.out.print(startIndex + " ");
		
		printAllIndexesOfX(input, x, startIndex+1);
		
	}
	
	public static boolean findXBetter(int[] input, int x) {
		return findXBetter(input, x, 0);
	}
	
	public static boolean checkSortedBetter(int[] input) {
		return checkSortedBetter(input, 0);
	}
	
	public static int sumBetter(int[] input, int startIndex) {
		if(startIndex == input.length-1) return input[startIndex];
		
		return input[startIndex] + sumBetter(input, startIndex+1);
	}
	
	public static int sumBetter(int[] input) {
		return sumBetter(input, 0);
	}
	
	public static int product(int a, int b) {
		if(b==0) return 0;
		return a + product(a, b-1);
	}
	
	public static int countOfZeros(int n) {
		if(n/10==0) {
			if(n==0) return 1;
			else return 0;
		}
		
		if(n%10 == 0) return 1 + countOfZeros(n/10);
		else return countOfZeros(n/10);
	}
	
	public static double geometricSum(int k) {
		if(k==0) return 1;
		return geometricSum(k-1) + (1.0/fastPower(2,k));
	}

	public static int sumOfDigits(int n) {
		if(n/10==0) return n;
		
		return (n%10) + sumOfDigits(n/10);
	}

	/*
	 * public static boolean checkPalindrome(String str, int start, int end) {
		if(start<=end) {
			if(checkPalindrome(str, start+1, end-1)) {
				if(str.charAt(start) == str.charAt(end)) return true;
				else return false;
			} else return false;
		}
		return false;
	}
	
	public static boolean checkPalindrome(String str) {
		return checkPalindrome(str, 0, str.length()-1);
	}
	 */
	
	/* 
	 * Stack Overflow Error is when our storage to save function is filled and our function is getting called infinite times
	 */
	
	/*
	 * When one fun calls other it gets in paused state until it gets the called answer
	 * And in case of recursion all the called functions are stored separately
	 */
	
	/*
	 * Trial Run
	 */
	
	/*
	 * public static String replacePi(String str) {  
		StringBuilder sb = new StringBuilder();
		int n = str.length();
		
		for(int i=0; i<n-1; i++) {
			if(str.substring(i, i+2) == "pi") {
				sb.append(3.14);
				i = i+1;
//				if(i==n-2) {
//					sb.append(str.charAt(i+1));
//					break;
//				}
			} else {
				sb.append(str.charAt(i));
				if(i==n-2) {
					sb.append(str.charAt(i+1));
					break;
				}
			}
		}
		return sb.toString();
	}
	 */
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    String str = sc.nextLine();
		System.out.println();
		
		
		sc.close();
	}
}
