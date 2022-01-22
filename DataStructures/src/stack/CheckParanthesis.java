package stack;
import java.util.*;
public class CheckParanthesis {

	
	public static boolean checkParanthesis(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char temp = str.charAt(i);
			if(temp == '(' || temp == '{' || temp == '[') {
				stack.push(temp);
			} else if(temp == ')' || temp == '}' || temp == ']') {
				if(stack.isEmpty()) return false;
				char peeked = stack.peek();
				if((temp == ')' && peeked == '(') || (temp == '}' && peeked == '{') || (temp == ']' && peeked == '[')) stack.pop();
				else return false;
			}
		}
		
		if(stack.isEmpty()) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		System.out.println(checkParanthesis(str));

	}

}
