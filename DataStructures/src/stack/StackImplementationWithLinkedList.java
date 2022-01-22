package stack;

public class StackImplementationWithLinkedList {
	
	private Node<Integer> head;
	private Node<Integer> tail;
	
	public StackImplementationWithLinkedList() {
		head = null;
		tail = null;
	}
	
	public int size() {
		Node<Integer> temp = head;
		int i = 0;
		
		while(temp != null) {
			temp = temp.next;
			i++;
		}
		
		return i;
	}
	
	public boolean isEmpty() {
		if(size() == 0) return true;
		return false;
	}
	
	public void push(int element) {
		Node<Integer> toAdd = new Node<>(element);
		
		if(head == null) {
			head = toAdd;
			tail = toAdd;
		} else {
			tail.next = toAdd;
			tail = tail.next;
		}
	}
	
	public int pop() throws EmptyStackException {
		if(head == null) {
			EmptyStackException e = new EmptyStackException();
			throw e;
		}
		
		int temp = tail.data;
		
		if(head.next == null) {
			head = null;
			tail = null;
			return temp;
		}
		
		Node<Integer> currentNode = head;
		
		while(currentNode.next.next != null) {
			currentNode = currentNode.next;
		}
		
		tail = currentNode;
		tail.next = null;
		
		return temp;
	}
	
	public int peek() throws EmptyStackException {
		if(head == null) {
			EmptyStackException e = new EmptyStackException();
			throw e;
		}
		
		return tail.data;
	}
	
}
