package test;
import java.util.*;

public class LinkedListUse {
	
	public static Node<Integer> takeInput() {
		Node<Integer> head = null;
		Node<Integer> tail = null;
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		
		while(data != -1) {
			Node<Integer> newNode = new Node<>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = tail.next;
			}
			
			data = sc.nextInt();
		}
		
		return head;
	}
	
	public static void print(Node<Integer> head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static Node<Integer> insertNode(Node<Integer> head, int data, int pos) { //Here we can add elements from first index starting to last index and one more than that
		Node<Integer> newNode = new Node<>(data);
		if(pos == 0) {
			newNode.next = head;
			return newNode;
		}
		
		int i=0;
		Node<Integer> temp = head;
		
		while(i<pos-1) {
			temp = temp.next;
			i++;
		}
		
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}
	
	public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
		if(head == null) return head;
		if(pos==0) return head.next;
		
		int i = 0;
		Node<Integer> temp = head;
		
		while(i<pos-1) {
			temp = temp.next;
			i++;
		}
		
		temp.next = temp.next.next;
		return head;
	}
	
	public static int size(Node<Integer> head) {
		Node<Integer> temp = head;
		int i=0;
		
		while(temp != null) {
			temp = temp.next;
			i++;
		}
		
		return i;
	}
	
	public static int nodeAtIthIndex(Node<Integer> head, int pos) {
		int i=0;
		Node<Integer> temp = head;
		
		while(i<pos) {
			temp = temp.next;
			i++;
		}
		return temp.data;
	}
	
	public static int findNode(Node<Integer> head, int n) {
		Node<Integer> temp = head;
		int i = 0;
		
		while(temp != null) {
			if(temp.data == n) return i;
			temp = temp.next;
			i++;
		}
		
		return -1;
	}
	
	public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
		Node<Integer> temp = head;
		int i = 0;
		
		while(temp.next != null) {
			temp = temp.next;
			i++;
		}
		
		int size = i+1;
		Node<Integer> tail = temp;
		int pos = size - n - 1;
		i = 0;
		temp = head;
		
		while(i<pos) {
			temp = temp.next;
			i++;
		}
		
		Node<Integer> newHead = temp.next;
		temp.next = null;
		tail.next = head;
		return newHead;
		
	}
	
	public static Node<Integer> removeDuplicates(Node<Integer> head) {
//		if(head == null) return head;  //This statement is not necessary as long as we check the temp and temp.next
		
		Node<Integer> temp = head;
		
		while(temp != null && temp.next != null) {
			if(temp.data == temp.next.data) temp.next = temp.next.next;
			else temp = temp.next;
		}
		
		return head;
	}
	
	public static Node<Integer> reverseLinkedList(Node<Integer> head) {
		Node<Integer> temp = head;
		Node<Integer> prev = null;
		
		while(temp != null) {
			Node<Integer> nextNode = temp.next;
			temp.next = prev;
			prev = temp;
			temp = nextNode;
		}
		
		return prev;
		
	}
	
	public static boolean checkPalindromeString(String str, int s, int e) {
		if(s>=e) return true;
		
		if(str.charAt(s) == str.charAt(e)) return checkPalindromeString(str, s+1, e-1);
		else return false;
	}
	
	public static boolean checkPalindromeLinkedList(Node<Integer> head) {
		StringBuilder sb = new StringBuilder();
		
		Node<Integer> temp = head;
		
		while(temp != null) {
			int data = temp.data;
			sb.append(data);
			temp = temp.next;
		}
		
		String str = sb.toString();
		
		return checkPalindromeString(str, 0, str.length()-1);
	}
	
	public static Node<Integer> mid(Node<Integer> head) { 
		
		/*
		 * When size is even mid element is (size/2)th element and when size is odd mid element is ((size+1)/2)th element
		 */
		int size = size(head);
		
		int pos = size%2 == 0 ? (size/2)-1 : ((size+1)/2)-1;
		
		Node<Integer> temp = head;
		int i = 0;
		
		while(i<pos) {
			temp = temp.next;
			i++;
		}
		
		return temp;
	}
	
	public static Node<Integer> midNode(Node<Integer> head) {
		
		if(head == null) return head;
		
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static Node<Integer> mergeTwoSortedLinkedList(Node<Integer> head1, Node<Integer> head2) {
		
//		if(head1 == null && head2 == null) return head1;   //This line is not needed because if both of them are null then remaining below two lines will handle 
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		
		Node<Integer> head = null;
		Node<Integer> tail = null;
		
		if(head1.data <= head2.data) {
			head = head1;
			tail = head1;
			head1 = head1.next;
		} else {
			head = head2;
			tail = head2;
			head2 = head2.next;
		}
		
		while(head1 != null && head2 != null) {
			if(head1.data <= head2.data) {
				tail.next = head1;
				head1 = head1.next;
			} else {
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}
		
		if(head1 != null) {
			tail.next = head1;
		}
		
		if(head2 != null) {
			tail.next = head2;
		}
		
		return head;
	}
	
	public static Node<Integer> mergeSort(Node<Integer> head) {
		if(head == null || head.next == null) return head;
		
		Node<Integer> midNode = midNode(head);
		Node<Integer> first = head;
		Node<Integer> second = midNode.next;
		midNode.next = null;
		
		first = mergeSort(first);
		second = mergeSort(second);
		head = mergeTwoSortedLinkedList(first, second);
		return head;
	}
	
	public static Node<Integer> reverseRecursively(Node<Integer> head) {
		if(head == null || head.next == null) return head;
		
		Node<Integer> newHead = reverseRecursively(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	public static DoubleNode reverseUsingDoubleNode(Node<Integer> head) {
		if(head == null || head.next == null) {
			DoubleNode db = new DoubleNode();
			db.head = head;
			db.tail = head;
			return db;
		}
		
		DoubleNode smallAns = reverseUsingDoubleNode(head.next);
		smallAns.tail.next = head;
		head.next = null;
		
		DoubleNode ans = new DoubleNode();
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
	}
	
	public static Node<Integer> insertRecursively(Node<Integer> head, int data, int pos) {
		if(pos == 0) {
			Node<Integer> toAdd = new Node<>(data);
			toAdd.next = head;
			return toAdd;
		}
		
		if(head == null) return head;
		
		Node<Integer> smallAns = insertRecursively(head.next, data, pos-1);
		head.next = smallAns;
		return head;
	}
	
	public static Node<Integer> deleteRecursively(Node<Integer> head, int pos) {
		if(pos==0 && head != null) return head.next;
		
		if(head == null) return head;
		
		Node<Integer> smallAns = deleteRecursively(head.next, pos-1);
		head.next = smallAns;
		return head;
	}

	public static int findNodeRecursively(Node<Integer> head, int index, int n) {
		if(head == null) return -1;
		
		if(head.data == n) return index;
		
		return findNodeRecursively(head.next, index+1, n);
	}

	public static Node<Integer> evenAfterOdd(Node<Integer> head) {
		if(head == null) return head;
		
		Node<Integer> evenHead = new Node(0);
		Node<Integer> evenTail = evenHead;
		
		Node<Integer> oddHead = new Node(0);
		Node<Integer> oddTail = oddHead;
		
		Node<Integer> temp = head;
		
		while(temp != null) {
			if(temp.data % 2 == 0) {
				evenTail.next = temp;
				evenTail = evenTail.next;
			} else {
				oddTail.next = temp;
				oddTail = oddTail.next;
			}
			temp = temp.next;
		}
		
		oddTail.next = null;
		evenTail.next = null;
		
		oddTail.next = evenHead.next;
		return oddHead.next;
	}
	
	public static Node<Integer> getNode(Node<Integer> head, int pos) {
		Node<Integer> temp = head;
		int i=0;
		
		while(i<pos) {
			temp = temp.next;
			i++;
		}
		
		return temp;
	}
	
	public static Node<Integer> deleteNNodesAfterEveryMNodes(Node<Integer> head, int m, int n) {
		Node<Integer> currentNode = head;
		
		while(currentNode != null) {
			for(int i=0; i<m-1 && currentNode != null; i++) {
				currentNode = currentNode.next;
			}
			
			if(currentNode == null) return head;
			Node<Integer> temp = currentNode.next;
			
			for(int i=0; i<n && temp != null; i++) {
				temp = temp.next;
			}
			
			currentNode.next = temp;
			currentNode = currentNode.next;
		}
		
		return head;
	}
	
	public static Node<Integer> reverseEveryKNodes(Node<Integer> head, int k) {
//		Node<Integer> currentNode = head;
//		Node<Integer> prev = null;
//		
//		while(currentNode != null) {
//			
//			int i=0;
//			while(i<k && currentNode != null) {
//				Node<Integer> nextNode = currentNode.next;
//				currentNode.next = prev;
//				prev = currentNode;
//				currentNode = nextNode;
//			}
//			
//			if(currentNode == null) return prev;
//		}
//		
//		return prev;
		
		Node<Integer> currentNode = head;
		int i=0;
		
		Node<Integer> prev = null;
		
		while(i<k && currentNode != null) {
			Node<Integer> nextNode = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = nextNode;
			i++;
		}
		
		if(currentNode == null) return prev;
		
		Node<Integer> smallAns = reverseEveryKNodes(currentNode, k);
		head.next = smallAns;
		return prev;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Node<Integer> head = takeInput();
		int k = sc.nextInt();
		
		head = reverseEveryKNodes(head, k);
		print(head);
		

	}
}
