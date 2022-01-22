package queue;

public class QueueUse {

	public static void main(String[] args) throws EmptyQueueException, FullQueueException {
		
		QueueImplementationUsingArray queue = new QueueImplementationUsingArray();
		
		for(int i=1; i<=5; i++) {
			queue.enqueue(i);
		}
		
		while(!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
		
	}

}
