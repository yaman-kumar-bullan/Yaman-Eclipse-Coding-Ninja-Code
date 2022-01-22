package stack;

public class StackImplementationWithArray {
	
	private int[] data;
	private int nextIndex;
	
	public StackImplementationWithArray() {
		data = new int[5];
		nextIndex = 0;
	}
	
	public int size() {
		return nextIndex;
	}
	
	public boolean isEmpty() {
		if(nextIndex == 0) return true;
		return false;
	}
	
	public void push(int element) {
		if(nextIndex == data.length) reStructure();
		data[nextIndex++] = element;
	}
	
	private void reStructure() {
		int[] arr = new int[data.length * 2];
		for(int i=0; i<data.length; i++) {
			arr[i] = data[i];
		}
		data = arr;
	}
	
	public int pop() throws EmptyStackException {
		if(nextIndex == 0) {
			EmptyStackException e = new EmptyStackException();
			throw e;
		}
		
		int temp = data[nextIndex-1];
		data[nextIndex-1] = 0;
		nextIndex--;
		return temp;
	}
	
	public int peek() throws EmptyStackException {
		if(nextIndex == 0) {
			EmptyStackException e = new EmptyStackException();
			throw e;
		}
		
		return data[nextIndex-1];
	}

}
