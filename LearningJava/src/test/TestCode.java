package test;
import java.util.*;
public class TestCode {
	
	public static char highestOccuringCharacter(String str) {
		int[] arr = new int[256];
		
		int maxFrequency = 0;
		int AsciiValueMaxChar = -1;
		
		for(int i=0; i<str.length()-1; i++) {
			int ascii = str.charAt(i);
			arr[ascii] = arr[ascii] + 1;
			if(arr[ascii] > maxFrequency) {
				maxFrequency = arr[ascii];
				AsciiValueMaxChar = ascii;
			}
		}
		
		char temp = (char) AsciiValueMaxChar;
		return temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		System.out.println(highestOccuringCharacter(str));
	}
	
}
