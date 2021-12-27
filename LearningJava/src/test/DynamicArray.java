package test;

public class DynamicArray {
	
	protected int[] arr;
	protected int nextIndex;
	
	public DynamicArray() {
		arr = new int[5];
		nextIndex = 0;
	}
	
	public int size() {
		return nextIndex;
	}
	
	public void add(int element) {
		if(nextIndex == arr.length) reStructure();
		arr[nextIndex++] = element;
	}
	
	protected void reStructure() {
		int[] temp = new int[arr.length*2];
		for(int i=0; i<arr.length; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}
	
	public void set(int index, int element) {
		if(index > nextIndex) {     //This will not be allowed
			//Error 
			return;
		}
		if(index == nextIndex) reStructure();
		
		arr[index] = element;
	}
	
	public int get(int index) {
		if(index >= nextIndex) {
			//Error
			
		}
		
		return arr[index];
	}
	
	public boolean isEmpty() {
		if(nextIndex == 0) return true;
		return false;
	}
	
	public int removeLast() {
		if(nextIndex == 0) {
			//Error
		}
		
		int temp = arr[nextIndex-1];
		arr[nextIndex-1] = 0;
		nextIndex = nextIndex-1;
		return temp;
	}

}
