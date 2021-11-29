package linkedList;

public class LinkedListVariations extends LinkedListUse {
	
	public static Node<Integer> insertInCircularSinglyLinkedlist(Node<Integer> head, int data, int pos) {
		
		Node<Integer> toAdd = new Node<>(data);
		
		if(pos == 0) {
			Node<Integer> currentNode = head;
			while(currentNode.next != head) {
				currentNode = currentNode.next;
			}
			toAdd.next = head;
			currentNode.next = toAdd;
			return toAdd;
		}
		
		Node<Integer> currentNode = head;
		int i= 0;
		
		while(i<pos-1) {
			currentNode = currentNode.next;
			i++;
		}
		
		Node<Integer> nextNode = currentNode.next;
		currentNode.next = toAdd;
		toAdd.next = nextNode;
		return head;
	}
	
	public static Node<Integer> deleteInCircularSinglyLinkedList(Node<Integer> head, int pos) {
		if(pos==0) {
			Node<Integer> newHead = head.next;
			Node<Integer> temp = head;
			while(temp.next != head) {
				temp = temp.next;
			}
			temp.next = newHead;
			return newHead;
		}
		
		Node<Integer> currentNode = head;
		int i= 0;
		
		while(i<pos-1) {
			currentNode = currentNode.next;
			i++;
		}
		currentNode.next = currentNode.next.next;
		return head;
	}
	
	public static void printCircularSinglyLinkedList(Node<Integer> head) {
		Node<Integer> temp = head.next;
		System.out.print(head.data + " ");
		
		while(temp != head) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
	}

	public static Node<Integer> takeInputCircularSinglyLinkedList() {
		Node<Integer> head = takeInput();
		
		Node<Integer> currentNode = head;
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = head;
		return head;
	}

	public static Node<Integer> insertInDoublyLinkedList(Node<Integer> head, int data, int pos) {
		Node<Integer> toAdd = new Node<>(data);
		
		if(pos==0) {
			toAdd.next = head;
			head.prev = toAdd;
			return toAdd;
		}
		
		Node<Integer> temp = head;
		int i=0;
		
		while(i<pos-1) {
			temp=temp.next;
			i++;
		}
		Node<Integer> nextNode = temp.next;
		temp.next = toAdd;
		toAdd.prev = temp;
		toAdd.next = nextNode;
		nextNode.prev = toAdd;
		return head;
	}

	public static Node<Integer> deleteInDoublyLinkedList(Node<Integer> head, int pos) {
		if(pos == 0) {
			Node<Integer> newHead = head.next;
			newHead.prev = null;
			return newHead;
		}
		
		Node<Integer> temp = head;
		int i=0;
		
		while(i<pos-1) {
			temp = temp.next;
			i++;
		}
		
		temp.next = temp.next.next;
		temp.next.prev = temp;
		return head;
	}

	public static void printDoublyLinkedList(Node<Integer> head) {
		Node<Integer> temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> takeInputDoublyLinkedList() {
		Node<Integer> head = takeInput();
		Node<Integer> currentNode = head;
		Node<Integer> prevNode = null;
		
		while(currentNode != null) {
			currentNode.prev = prevNode;
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		return head;
	}
	
	public static Node<Integer> insertInCircularDoublyLinkedList(Node<Integer> head, int data, int pos) {
		Node<Integer> toAdd = new Node<>(data);
		
		if(pos==0) {
			Node<Integer> tail = head.prev;
			toAdd.next = head;
			head.prev = toAdd;
			tail.next = toAdd;
			toAdd.prev = tail;
			return toAdd;
		}
		
		Node<Integer> temp = head;
		int i=0;
		
		while(i<pos-1) {
			temp=temp.next;
			i++;
		}
		
		Node<Integer> nextNode = temp.next;
		temp.next = toAdd;
		toAdd.prev = temp;
		toAdd.next = nextNode;
		nextNode.prev = toAdd;
		return head;
	}

	public static Node<Integer> deleteinCircularDoublyLinkedList(Node<Integer> head, int pos) {
		if(pos==0) {
			Node<Integer> newHead = head.next;
			Node<Integer> tail = head.prev;
			tail.next = newHead;
			newHead.prev = tail;
			return newHead;
		}
		
		Node<Integer> temp = head;
		int i=0;
		
		while(i<pos-1) {
			temp = temp.next;
			i++;
		}
		
		temp.next = temp.next.next;
		temp.next.prev = temp;
		return head;
	}
	
	public static void printCircularDoublyLinkedList(Node<Integer> head) {
		Node<Integer> temp = head.next;
		System.out.print(head.data + " ");
		
		while(temp != head) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		System.out.println();
	}
	
	public static Node<Integer> takeInputCircularDoublyLinkedList() {
		Node<Integer> head = takeInputDoublyLinkedList();
		
		Node<Integer> currentNode = head;
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = head;
		head.prev = currentNode;
		
		return head;
	}

}
