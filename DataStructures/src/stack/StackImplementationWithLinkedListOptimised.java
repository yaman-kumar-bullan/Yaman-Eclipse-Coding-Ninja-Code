package stack;

public class StackImplementationWithLinkedListOptimised<T> {
	
	private Node<T> head;
	private int size;
	
	public StackImplementationWithLinkedListOptimised() {
		head = null;
		size=0;
	}
	
	public void push(T element) {
		Node<T> toAdd = new Node<>(element);
		toAdd.next = head;
		head = toAdd;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if(size == 0) return true;
		return false;
	}
	
	public T pop() throws EmptyStackException {
		if(head == null) {
			throw new EmptyStackException();
		}
		
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}

	
	public T peek() throws EmptyStackException {
		if(head == null) {
			throw new EmptyStackException();
		}
		
		return head.data;
	}
	
}
