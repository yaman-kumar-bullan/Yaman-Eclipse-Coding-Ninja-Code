package linkedList;
import java.util.*;

public class LinkedListUse {
	
	public static Node<Integer> takeInput() {
		Scanner sc = new Scanner(System.in);
		
//		Node<Integer> head = null;
		Node<Integer> head = null, tail = null;
		int data = sc.nextInt();
		
		while(data != -1) {
			Node<Integer> newNode = new Node<>(data);   //Its next is null at this time
			if(head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				/* newNode.prev = tail;    Use this line when you need to implement Doubly Linked List */
				tail = tail.next; //tail = newNode;
				
				/*  This code is optimised to reduce the time complexity from O(n2) to O(n)
				 * Node<Integer> temp = head; while(temp.next != null) { temp = temp.next; }
				 * temp.next = newNode;
				 */
			}
			data = sc.nextInt();
		}

		return head;
	}
	
	public static Node<Integer> deleteNode(Node<Integer> head, int pos) {   //Valid upto 0 to n-1
		if(pos == 0) {
			return head.next;
		}
		
		Node<Integer> temp = head;
		int i = 0;
		
		while(i<pos-1) {
			temp = temp.next;
			i++;
		}
		
		temp.next = temp.next.next;
		return head;
	}
	
	public static Node<Integer> deleteRecursive(Node<Integer> head, int pos) {  //Valid upto 0 to n-1
		if(pos==0) return head.next;
		
		if(head == null) return head;
		Node<Integer> smallHead = deleteRecursive(head.next, pos-1);
		head.next = smallHead;
		return head;
	}
	
	public static Node<Integer> insertNode(Node<Integer> head, int data, int pos) {  //Here we can add elements from first index starting to last index and one more than that
		
		Node<Integer> toAdd = new Node<>(data);
		
		if(pos==0) {
			toAdd.next = head;
			return toAdd;
		}
		
		Node<Integer> temp = head;
		int i = 0;
		
		while(i<pos-1) {
			temp = temp.next;
			i++;
		}
		Node<Integer> nextNode = temp.next;
		temp.next = toAdd;
		toAdd.next = nextNode;
		return head;
	}
	
	public static Node<Integer> insertRecursive(Node<Integer> head, int data , int pos) {   //Only valid from index 0 to n
		
		if(pos==0) {
			Node<Integer> toAdd = new Node<>(data);
			toAdd.next = head;
			return toAdd;
		}
		
		if(head == null) return head;
		
		Node<Integer> smallHead = insertRecursive(head.next, data, pos-1);
		head.next = smallHead;
		return head;
	}
	
	public static int findNodeRecursive(Node<Integer> head, int n, int index) {
		if(head == null) return -1;
		
		if(head.data == n) return index;
		
		return findNodeRecursive(head.next, n, index++);
	}
	
	public static int findNode(Node<Integer> head, int n) {
		Node<Integer> temp = head;
		int i=0;
		
		while(temp != null) {
			if(temp.data == n) return i;
			temp = temp.next;
			i++;
		}
		
		return -1;
	}
	
	public static void print(Node<Integer> head) {
		
		Node<Integer> temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
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
		
		i=0;
		temp = head; //Temp should again return head
		
		while(i<size-n-1) {
			temp = temp.next;
			i++;
		}
		
		Node<Integer> first = temp;
		Node<Integer> second = temp.next;
		
		tail.next = head;
		first.next = null;
		
		return second;
		
	}
	
	public static Node<Integer> removeDuplicates(Node<Integer> head) {
		Node<Integer> currentNode = head;
		
		while(currentNode != null && currentNode.next != null) {
			if(currentNode.data == currentNode.next.data) {
				currentNode.next = currentNode.next.next;
			} else {
				currentNode = currentNode.next;
			}
		}	
		
		return head;
	}
	
	public static Node<Integer> reverseLinkedList(Node<Integer> head) {
		Node<Integer> currentNode = head;
		Node<Integer> prevNode = null;
		
		while(currentNode != null) {
			currentNode.prev = prevNode;
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		
		return prevNode;
	}
	
	public static void printReverse(Node<Integer> tail) {
		Node<Integer> currentNode = tail;
		
		while(currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.prev;
		}
		System.out.println();
	}
	
	public static Node<Integer> reverseLinkedList2(Node<Integer> head) {
		
		Node<Integer> currentNode = head;
		Node<Integer> prev = null;
		
		while(currentNode != null) {
			Node<Integer> nextNode = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;         //Here previous will be having the last node
			currentNode = nextNode;
		}
		
		return prev;
		
	}
	
	public static boolean checkPalindrome(Node<Integer> head) {
		StringBuilder sb1 = new StringBuilder();
		Node<Integer> currentNode = head;
		Node<Integer> prev = null;
		
		while(currentNode != null) {
			sb1.append(currentNode.data);
			Node<Integer> nextNode = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = nextNode;
		}
		
		currentNode = prev;
		prev = null;
		
		StringBuilder sb2 = new StringBuilder();
		
		while(currentNode != null) {
			sb2.append(currentNode.data);
			currentNode = currentNode.next;
		}
		
		String str1 = sb1.toString();
		String str2 = sb2.toString();
		
		if(str1.equals(str2)) return true;
		else return false;
		
	}

	public static Node<Integer> mergeSortedLinkedList(Node<Integer> head1, Node<Integer> head2) {  //Making a complete new LL
		if(head1 == null) return head2;
	     if(head2 == null) return head1;
	     
	     Node<Integer> temp = new Node<>(0);   //Its next is going to be the head of new merged Linked List
	     Node<Integer> currentNode = temp;
	     
	     while(head1 != null && head2 != null) {
	         
	         if(head1.data < head2.data) {
	             currentNode.next = head1;
	             head1 = head1.next;
	         } else {
	             currentNode.next = head2;
	             head2 = head2.next;
	         }
	         currentNode = currentNode.next;
	     }
	     
	     if(head1 != null) {
	         currentNode.next = head1;
	     }
	     
	     if(head2 != null) {
	         currentNode.next = head2;
	     }
	     
	     return temp.next;
	}
	
	public static Node<Integer> mergeSortedLinkedList2(Node<Integer> head1, Node<Integer> head2) { //Changing pointers in same LL
	     
	     if(head1 == null) return head2;
	     if(head2 == null) return head1;
	     
	     Node<Integer> h = null;
	     Node<Integer> t = null;
	     
	     if(head1.data < head2.data) {
	         h = head1;
	         t = head1;
	         head1 = head1.next;
	     } else {
	         h = head2;
	         t = head2;
	         head2 = head2.next;
	     }
	     
	     while(head1 != null && head2 != null) {
	         if(head1.data < head2.data) {
	             t.next = head1;
	             head1 = head1.next;
	         } else {
	             t.next = head2;
	             head2 = head2.next;
	         }
	         t = t.next;
	     }
	     
	     if(head1 != null) {
	         t.next = head1;
	     }
	     
	     if(head2 != null) {
	         t.next = head2;
	     }
	     
	     return h;
	     
	   } 
	
	public static Node<Integer> mergeSort(Node<Integer> head) {
		if(head == null || head.next == null) return head;
		
		Node<Integer> middleNode = mid(head);
		Node<Integer> first = head;
		Node<Integer> second = middleNode.next;
		middleNode.next = null;
		
		first = mergeSort(first);
		second = mergeSort(second);
		
		Node<Integer> ansHead = mergeSortedLinkedList2(first, second);
		return ansHead;
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
	
	public static Node<Integer> reverseLinkedListRecursive(Node<Integer> head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node<Integer> finalHead = reverseLinkedListRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return finalHead;
	}
	
	public static DoubleNode<Integer> reverseLinkedListRecursive2(Node<Integer> head) {
//		if(head == null || head.next == null) return head;
//		
//		Node<Integer> smallAns = reverseRecursive2(head.next);
//		Node<Integer> temp = smallAns;
//		while(temp.next != null) {
//			temp = temp.next;
//		}
//		temp.next = head;
//		head.next = null;
//		return smallAns;
		
		
		if(head == null || head.next == null) {
			return new DoubleNode<>(head, head);
		}
		
		DoubleNode<Integer> smallAns = reverseLinkedListRecursive2(head.next);
		smallAns.tail.next = head;
		head.next = null;
		smallAns.tail = head;
		
		return smallAns;
	}
	
	public static Node<Integer> evenAfterOddWithANewLL(Node<Integer> head) {
		if(head == null) return head;
        
        Node<Integer> head1 = new Node<>(0);
        Node<Integer> head2 = new Node<>(0);
        Node<Integer> firstHead = head1;
        Node<Integer> secondHead = head2;
        
        while(head != null) {
            if(head.data % 2 != 0) {
                head1.next = head;
                head1 = head1.next;
            } else {
                head2.next = head;
                head2 = head2.next;
            }
            head = head.next;
        }
        
        head2.next = null;
        
        if(firstHead.next == null) return secondHead.next;
        else if(secondHead.next == null) return firstHead.next;
        
        head1.next = secondHead.next;
        return firstHead.next;
	}
	
	public static Node<Integer> evenAfterOddInTheSameLL(Node<Integer> head) {
		
		Node<Integer> evenHead = null, evenTail = null; //Since we are using references here we are modifying Linkage in the same LL
        Node<Integer> oddHead = null, oddTail = null;
        
        while(head != null) {
            if(head.data % 2 == 0) {
                if(evenHead == null) {
                    evenHead = head;
                    evenTail = head;
                } else {
                    evenTail.next = head;
                    evenTail = head;
                }
            } else {
                if(oddHead == null) {
                    oddHead = head;
                    oddTail = head;
                } else {
                    oddTail.next = head;
                    oddTail = head;
                }
            }
            head = head.next;
        }
        
        if(evenHead == null) return oddHead;
        else if(oddHead == null) return evenHead;
        
        evenTail.next = null;
        
        oddTail.next = evenHead;
        return oddHead;
	}
	
	public static Node<Integer> deleteNNodesAfterMNodes(Node<Integer> head, int m, int n) {
		
		Node<Integer> currentNode = head;
		
		while(currentNode != null) {
			for(int count=1; count<m && currentNode != null; count++) {
				currentNode = currentNode.next;
			}
			if(currentNode == null) return head;
			
			Node<Integer> temp = currentNode.next;
			for(int count = 1; count<=n && temp != null; count++) {
				temp = temp.next;
			}
			currentNode.next = temp;
			currentNode = currentNode.next;
		}
		
		return head;
		
	}

	public static Node<Integer> reverseKNodes(Node<Integer> head, int k) {
		Node<Integer> currentNode = head;
		int count = 0;
		Node<Integer> prev = null;
		
		while(currentNode != null && count<k) {
			Node<Integer> nextNode = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = nextNode;
			count++;
		}
		 
		if(currentNode != null) {
			head.next = reverseKNodes(currentNode,k);
		}
		
		return prev;
	}
	
	public static Node<Integer> swapTwoNodes(Node<Integer> node1, Node<Integer> node2) {
		Node<Integer> nextNode = node2.next;
		node2.next = node1;
		node1.next = nextNode;
		return node2;
	}
	
	public static Node<Integer> swapNodesInPairs(Node<Integer> head) {  //Do some fixes
		if(head == null || head.next == null) return head;
		
		Node<Integer> temp = head;
		Node<Integer> tail = null;
		Node<Integer> newHead = null;
		if(temp.data > temp.next.data) {
			newHead = swapTwoNodes(temp, temp.next);
			tail = temp;
		} else {
			tail = temp.next;
			newHead = temp;
		}
		
		tail.next = swapNodesInPairs(tail.next);
		return newHead;
		
		// if(head==null || head.next==null) return head;
        
//      ListNode newHead = null;
//      ListNode newTail = null;
     
//      newHead = swapTwoNodes(head, head.next);
//      newTail = newHead.next;
     
//      newTail.next = swapPairs(newTail.next);
//      return newHead;
		
	}
	
	public static Node<Integer> swapNodesIteratively(Node<Integer> head) {
		Node<Integer> temp = new Node<>(0);
		temp.next = head;
		Node<Integer> current = temp;
		
		while(current.next != null && current.next.next != null) {
			Node<Integer> first = current.next;
			Node<Integer> second = current.next.next;
			first.next = second.next;
			second.next = first;
			current.next = second;
			current = current.next.next;
		}
		return temp.next;
	}
	
	public static Node<Integer> bubbleSort(Node<Integer> head) {
		Node<Integer> current = head;
		int index = 0;
		
		while(current != null) {
			current = current.next;
			index++;
		}
		
		int n = index;
		
		
		/*
		 * This implementation has a TC of O(n^2) and is very bad 
		 */
		for(int i=0; i<n-1; i++) {    //traversing n-1 times
			current = head;            //assigning current = head in every iteration
			while(current.next != null) {          //We just need to compare until the last two so breaking at the last node
				if(current.data > current.next.data) {       //if swapping is required swap the data
					int temp = current.data;                   
					current.data = current.next.data;
					current.next.data = temp;
				}
				current = current.next;      //move the current node forward to check the next two data
			}
		}
		
		return head;       //Head is not changed
	}
	
	public static void demo(Node<Integer> head) {
		head = new Node<>(3);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Node<Integer> head = takeInput();
		Node<Integer> head2 = takeInput();
		Node<Integer> newHead = mergeSortedLinkedList2(head, head2);
		print(newHead);
	}
}
