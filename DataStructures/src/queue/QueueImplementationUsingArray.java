package queue;
public class QueueImplementationUsingArray {
	
	private int[] data;
	private int rear;   //enqueue
	private int front;  //dequeue
	private int size;
	
	public QueueImplementationUsingArray() {
		data = new int[5];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public QueueImplementationUsingArray(int size) {
		data = new int[size];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int front() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException();
		
		return data[front];
	}
	
	public void enqueue(int element) throws FullQueueException {
		if(size == data.length) throw new FullQueueException();
		
		if(size == 0) {
			front = 0;
		}
		rear++;
		
		rear = rear % data.length;                   //to make the queue circular
//		if(rear == data.length) rear = 0;
		
		data[rear] = element;
		size++;
	}
	
	public int dequeue() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException();
		
		int temp = data[front];
		front++;
		
		front = front % data.length;                  //to make this code circular
//		if(front == data.length) front = 0;
		
		size--;
		
		if(size == 0) {
			front = -1;
			rear = -1;
		}
		return temp;
	}
}