package test;

public class LinkedListVariations extends LinkedListUse {

	public static Node<Integer> takeInputSinglyCircularLL() {
		Node<Integer> head = takeInput();
		Node<Integer> temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = head;
		return head;
	}
	
	
}
