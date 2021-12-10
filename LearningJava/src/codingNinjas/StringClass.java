package codingNinjas;
import java.util.*;
public class StringClass {

	public static int numberOfWords(String str) {
		if(str.length() == 0) return 0;
		
		String[] arr = str.split(" ");
		return arr.length;
	}
	
	public static boolean palindrome(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--) {
			sb.append(str.charAt(i));
		}
		String revString = sb.toString();
		if(str.equals(revString)) return true;
		else return false;
	}
	
	public static void printPrefix(String str) {
		for(int i=0; i<str.length(); i++) {
			System.out.println(str.substring(0, i+1));  // In the case of substring functions in string index n is a valid index.
		}
	}
	
	public static void printAllSubStrings(String str) {
		for(int i=0; i<str.length(); i++) {
			for(int j=i; j<str.length(); j++) {
				System.out.println(str.substring(i, j+1));
			}
		}
	}
	
	public static String reverseStringWordWise(String str) {
		if(str.length() == 0) return str;
		
		String[] arr = str.split(" ");
		
		String output = "";
		
		for(int i=arr.length-1; i>=0; i--) {
			output += arr[i] + " ";	
		}
		
		output = output.trim();
		return output;
	} 

	public static boolean permutation(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		for(int i=0; i<c1.length; i++) {
			if(c1[i] != c2[i]) return false;
		}
		
		return true;
	}

	public static String removeConsecutiveDuplicates(String str) {
		StringBuilder sb = new StringBuilder();
		int n = str.length();
		
		for(int i=0; i<n-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				if(i==n-2) {
					sb.append(str.charAt(i));
				}
				continue;
			} else {
				sb.append(str.charAt(i));
				if(i==n-2) sb.append(str.charAt(i+1));
			}
		}
		
		return sb.toString();
	}

	public static String reverseEachWord(String str) {
		if(str.length()==0) return str;
		
		String[] arr = str.split(" ");
		
		String output = "";
		
		for(int i=0; i<arr.length; i++) {
			output += reverseAString(arr[i]) + " ";	
		}
		
		output = output.trim();
		return output;
	}
	
	public static String reverseAString(String str) {
		int n = str.length();
		String ans = "";
		
		for(int i=n-1; i>=0; i--) {
			ans += str.charAt(i);	
		}
		
		return ans;
	}
	
	public static String removeCharacter(String str, char x) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == x) continue;
			else sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	public static String compressTheString(String str) {
		StringBuilder sb = new StringBuilder();
		int n = str.length();
		
		for(int i=0; i<n-1; i++) {
			int count = 1;
			while(str.charAt(i) == str.charAt(i+1)) {
				count++;
				i++;
				if(i==n-1) break;
			}
			sb.append(str.charAt(i));
			if(count > 1) {
				sb.append(count);
			}
			
			if(i==n-2) {
				if(str.charAt(i) != str.charAt(i+1)) sb.append(str.charAt(i+1));
				return sb.toString();
			}
		}
		
		return sb.toString();
	}

	public static char highestOccuringCharacter(String str) {
		int[] freq = new int[256];   //Here I'm using the technique called Hashing
		int n = str.length();
		
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		boolean[] ans = new boolean[t];
//		int index = 0;
//		sc.nextLine();
//		
//		while(t-->0) {
//			String s1 = sc.nextLine();
//			String s2 = sc.nextLine();
//			ans[index++] = permutation(s1, s2);
//		}
//		
//		for(boolean i : ans) {
//			System.out.println(i);
//		}
		
		String str = sc.nextLine();
//		char c = sc.next().charAt(0);
		System.out.println(highestOccuringCharacter(str));
		
		int i = 'a';
	}
}
