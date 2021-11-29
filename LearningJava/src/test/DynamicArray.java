package test;

public class DynamicArray {
	
	public int[] data;
//	private int nextIndex;
	
	public DynamicArray() {
		data = new int[5];
//		nextIndex = 0;
	}
	
//	public int size() {
//		return nextIndex;
//	}
	
//	public boolean isEmpty() {
//		if(size() == 0) return true;
//		else return false;
//	}
	
//	public void print() {
//		for(int i=0; i<nextIndex; i++) {
//			System.out.print(data[i] + " ");
//		}
//		System.out.println();
//	}
	
//	public void add(int value) {
//		if(nextIndex == data.length) reStructure();
//		data[nextIndex++] = value;
//	}

	public void reStructure() {
		int[] temp = new int[data.length * 2];
		for(int i=0; i<data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
	
	public void set(int index, int value) {
		while(index > data.length) {
			reStructure();
		}
		data[index] = value;
	}
	
	public int get(int index) {
		if(index > data.length-1) return 0;
		return data[index];
	}
	
//	public int removeLast() {
//		if(isEmpty()) {
//			//Error that trying to remove last element from an empty array
//			return -1;
//		} else {
//			int temp = data[nextIndex-1];
//			data[nextIndex-1] = 0;
//			nextIndex--;
//			return temp;
//		}
//	}
	
}
