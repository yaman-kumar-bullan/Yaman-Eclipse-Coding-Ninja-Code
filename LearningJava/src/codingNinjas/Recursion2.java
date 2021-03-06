package codingNinjas;
import java.util.*;
public class Recursion2 {

	public static String replacePi(String str) {
		int n = str.length();
		String output = "";
		
		for(int i=0; i<n; i++) {
			
			if(i<n-1 && str.charAt(i)=='p' && str.charAt(i+1)=='i') {     //substring is checking when we are at upto last second index
				output = output + "3.14";
				i++;
			} else {
				output = output + str.charAt(i);    //If the character and its next is not forming pi then append the character in the string
			}
		}
		
		return output;
	}
	
	public static String replacePiRecursion(String str, String output, int startIndex) {
		if(startIndex == str.length()) return output;
		if(startIndex == str.length()-1) {
			output += str.charAt(startIndex);
			return output;
		}
		
		if(str.charAt(startIndex)=='p' && str.charAt(startIndex+1)=='i') {
			output += "3.14";
			return replacePiRecursion(str, output, startIndex+2);
		} else {
			output += str.charAt(startIndex);
			return replacePiRecursion(str, output, startIndex+1);
		}
	}
	
	public static String removeX(String str, String output, int startIndex) {
		if(startIndex == str.length()-1) {
			if(str.charAt(startIndex)=='x') return output;
			else {
				output += str.charAt(startIndex);
				return output;
			}
		}
		
		if(str.charAt(startIndex) == 'x') return removeX(str, output, startIndex+1);
		else {
			output += str.charAt(startIndex);
			return removeX(str, output, startIndex+1);
		}
	}
	
	public static int stringToInt(String str, int num, int startIndex) {
		if(startIndex == str.length()-1) {
			int b = str.charAt(startIndex) - '0';
			num = num*10 + b;
			return num;
		}
		
		int a = str.charAt(startIndex) - '0';
		num = num * 10 + a;
		return stringToInt(str, num, startIndex+1);
	}
	
	public static String pairStar(String str, String output, int startIndex) {
		if(startIndex == str.length()-1) {
			output = output + str.charAt(startIndex);
			return output;
		}
		
		if(str.charAt(startIndex) == str.charAt(startIndex+1)) {
			output = output + str.charAt(startIndex) + '*';
			return pairStar(str,output,startIndex+1);
		} else {
			output = output + str.charAt(startIndex);
			return pairStar(str, output, startIndex+1);
		}
	}

	public static boolean checkPalindrome(String str, int start, int end) {
		if(start==end) return true;
		
		if(start == end-1) {
			if(str.charAt(start) == str.charAt(end)) return true;
			else return false;
		}
		
		if(str.charAt(start) != str.charAt(end)) return false;
		
		return checkPalindrome(str, start+1, end-1);
	}
	
	public static void towerOfHanoi(int n, char a, char c, char b) {
		if(n==1) {
			System.out.println(a + " " + c);
			return;
		}
		
		towerOfHanoi(n-1, a, b, c);
		System.out.println(a + " " + c);
		towerOfHanoi(n-1, b, c, a);
	}

	public static void towerOfHanoi4(char a, char b, char c, char d, int n) {
		if(n==1) {
			System.out.println(a + " " + b);
			return;
		}
		if(n==2) {
			System.out.println(a + " " + c);
			System.out.println(a + " " + b);
			System.out.println(c + " " + b);
			return;
		}
		
		towerOfHanoi4(a, d, b, c, n-2);
		System.out.println(a + " " + c);
		System.out.println(a + " " + b);
		System.out.println(c + " " + b);
		towerOfHanoi4(d, b, a, c, n-2);
	}
	
	public static void towerOfHanoi5(char a, char b, char c, char d, char e, int n) {
		if(n==3) {
			System.out.println(a + " " + c);
			System.out.println(a + " " + d);
			System.out.println(a + " " + b);
			System.out.println(d + " " + b);
			System.out.println(c + " " + b);
			return;
		} else if(n==2) {
			System.out.println(a + " " + c);
			System.out.println(a + " " + b);
			System.out.println(c + " " + b);
			return;
		} else if(n==1) {
			System.out.println(a + " " + b);
			return;
		} else {
			towerOfHanoi5(a, e, b, c, d, n-3);
			System.out.println(a + " " + c);
			System.out.println(a + " " + d);
			System.out.println(a + " " + b);
			System.out.println(d + " " + b);
			System.out.println(c + " " + b);
			towerOfHanoi5(e, b, a, c, d, n-3);
		}
		
	}
	
	public static void mergeSort(int[] input, int s, int e) {
		if(s>=e) return;
		
		int mid = (s+e)/2;
		
		mergeSort(input, s, mid);
		mergeSort(input, mid+1, e);
		
		merge(input, s, e);
	}
	
	public static void merge(int[] input, int s, int e) {
		int[] ans = new int[e-s+1];
		int index = 0;
		int mid = (s+e)/2;
		int s1 = s, e1=mid, s2=mid+1, e2=e;
		
		while(s1<=e1 && s2<=e2) {
			if(input[s1] < input[s2]) {
				ans[index++] = input[s1];
				s1 = s1 +1;
			}
			else {
				ans[index++] = input[s2];
				s2 = s2+1;
			}
		}
		
		while(s1<=e1) {
			ans[index++] = input[s1];
			s1=s1+1;
		}
		
		while(s2<=e2) {
			ans[index++] = input[s2];
			s2=s2+1;
		}
		
		for(int i=0; i<ans.length; i++) {
			input[s+i] = ans[i];
		}
	}
	
	public static void mergeSort_2(int[] input, int s, int e) {
		if(s>=e) return;
		
		int mid = (s+e)/2;
		
		mergeSort_2(input, s, mid);
		mergeSort_2(input, mid+1, e);
		
		merge_2(input, s, e);
	}
	
	public static void merge_2(int[] input, int s, int e) {
		int[] ans = new int[e-s+1];
		int index = 0;
		
		int mid = (s+e)/2;
		int i = s;
		int j = mid+1;
		
		while(i<=mid && j<=e) {
			if(input[i] < input[j]) ans[index++] = input[i++];
			else ans[index++] = input[j++];
		}
		
		while(i<=mid) {
			ans[index++] = input[i++];
		}
		
		while(j<=e) {
			ans[index++] = input[j++];
		}
		
		for(int k=0; k<ans.length; k++) {
			input[s+k] = ans[k]; 
		}
	}
	
	public static void quickSort(int[] input, int s, int e) {
		if(s>=e) return;
		
		int pivotPos = partition(input, s, e);
		
		quickSort(input, s, pivotPos-1);
		quickSort(input, pivotPos+1, e);
	}
	
	public static int partition(int[] input, int s, int e) {
		int pivotElement = input[s];
		int count = 0;
		
		for(int i=s+1; i<=e; i++) {
			if(input[i] <= pivotElement) count++;
		}
		
		int pivotPos = s + count;
		
		input[s] = input[pivotPos];
		input[pivotPos] = pivotElement;
		
		int i=s, j=e;
		
		while(i<pivotPos && j>pivotPos) {
			if(input[i]>pivotElement) {
				int temp = input[j];
				input[j] = input[i];
				input[i] = temp;
				j--;
			}
			if(input[j]<pivotElement) {
				int temp = input[j];
				input[j] = input[i];
				input[i] = temp;
				i++;
			}
		}
		
		return pivotPos;
	}
	
	public static String[] findSubSequence(String str) {
		if(str.length()==0) {
			String[] ans = {""};
			return ans;
		}
		
		String[] smallAns = findSubSequence(str.substring(1));
		String[] ans = new String[smallAns.length*2];
		int index = 0;
		
		for(int i=0; i<smallAns.length; i++) {
			ans[index++] = smallAns[i];                  //Adding subsequences of smaller string in ans array
		}
		
		for(int i=0; i<smallAns.length; i++) {
			ans[index++] = str.charAt(0) + smallAns[i];    //Appending the first character to get the subsequences of the larger string also
		}
		
		return ans;
	}
	
	public static String[] keypadCombinations(int n) {
	    if(n == 0 || n == 1) {
	        String[] ans = {""};
	        return ans;
	    }
	    
	    char[] lastDigitArray = charArray(n%10);
	    String[] smallAns = keypadCombinations(n/10);
	    
	    String[] ans = new String[lastDigitArray.length * smallAns.length];
	    int index = 0;
	    
	    for(int i=0; i<smallAns.length; i++) {
	        for(int j=0; j<lastDigitArray.length; j++) {
	            ans[index++] = smallAns[i] + lastDigitArray[j];
	        }
	    }
	    
	    return ans;
	}
	
	public static char[] charArray(int n) {
	    if(n==2) {
	        char[] temp = {'a','b','c'};
	        return temp;
	    } else if(n==3) {
	        char[] temp = {'d','e','f'};
	        return temp;
	    } else if(n==4) {
	        char[] temp = {'g','h','i'};
	        return temp;
	    } else if(n==5) {
	        char[] temp = {'j','k','l'};
	        return temp;
	    } else if(n==6) {
	        char[] temp = {'m','n','o'};
	        return temp;
	    } else if(n==7) {
	        char[] temp = {'p','q','r','s'};
	        return temp;
	    } else if(n==8) {
	        char[] temp = {'t','u','v'};
	        return temp;
	    } else {
	        char[] temp = {'w','x','y','z'};
	        return temp;
	    }
	}
	
	public static void removeConsecutiveDuplicatesFromString(String str, String temp) {  //Strings do not get changed or updated when passed to a function
		if(str.length() <= 1) {
			temp = temp + str;
			return;
		}
		
		if(str.charAt(0) != str.charAt(1)) temp += str.charAt(0);
		
		removeConsecutiveDuplicatesFromString(str.substring(1), temp);
		
		str = temp;
	}
	
	public static String removeDuplicates(String str) {
		int n = str.length();
		String output = "";
		
		for(int i=0; i<n; i++) {
			if(i<n-1 && (str.charAt(i) == str.charAt(i+1) ) ) continue;
			else {
				output += str.charAt(i);
			}
		}
		return output;
	}
	
	public static String replaceCharacterRecursively(String str, char c1, char c2) {
		if(str.length() == 0) return "";
		
		String smallAns = replaceCharacterRecursively(str.substring(1), c1, c2);
		
		if(str.charAt(0) == c1) smallAns = c2 + smallAns;
		else smallAns = str.charAt(0) + smallAns;
		
		return smallAns;
	}
	
	public static void printSubSequencesOfString(String input, String output) {
		if(input.length() == 0) {
			System.out.println(output);
			return;
		}
		
		printSubSequencesOfString(input.substring(1), output);
		printSubSequencesOfString(input.substring(1), output + input.charAt(0));
	}
	
	public static void printSubSequencesOfString(String input) {
		printSubSequencesOfString(input, "");
	}
	
	public static void printKeypadCombinations(int n, String output) {
		if(n==0) {
			System.out.println(output);
			return;
		}
		
		char[] characters = charArray(n%10);
		for(int i=0; i<characters.length; i++) {
			printKeypadCombinations(n/10, characters[i] + output);
		}
	}
	
	public static void printKeypadCombinations(int n) {
		printKeypadCombinations(n, "");
	}
	
	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			int min = arr[i];
			int minIndex = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j]<min) {
					min = arr[j];
					minIndex = j;
				}
			}
			if(minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
	}
}