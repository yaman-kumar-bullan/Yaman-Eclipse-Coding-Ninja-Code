package oops;

public class DynamicArray {

	public int data[];
	private int nextIndex;
	
	public DynamicArray() {
		data = new int[5];
		nextIndex = 0;
	}
	
	public int size() {
		return nextIndex;
	}
	
	public void add(int value) {
		if(nextIndex == data.length) {
			reStructure();
		}
		data[nextIndex++] = value;
	}
	
	public void reStructure() {
		int temp[] = new int[2*data.length];
		for(int i=0; i<data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
	
	public void set(int index, int value) {
		if(index>=data.length) reStructure();
		data[index] = value;
	}
	
	public int get(int index) {
		if(index >= data.length) return 0;
		else return data[index];
	}
	
	public boolean isEmpty() {
		if(size() == 0) return true;
		else return false;
	}
	
	public int removeLast() {
		if(size()==0) {
			//Error
			return -1;
		} else {
			int temp = data[nextIndex-1];
			data[nextIndex-1] = 0;
			nextIndex--;
			return temp;
		}
	}
	
	public void print() {
		for(int i=0; i<nextIndex; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
}


//package oops;
//
//public class DynamicArray {
//
//	private int data[];
//	private int nextIndex;
//	
//	public DynamicArray() {
//		data = new int[5];
//		nextIndex = 0;
//	}
//	
//	public int size() {
//		return nextIndex;
//	}
//	
//	public void add(int value) {
//		if(nextIndex == data.length) {
//			reStructure();
//		}
//		data[nextIndex++] = value;
//	}
//	
//	public void reStructure() {
//		int temp[] = new int[2*data.length];
//		for(int i=0; i<data.length; i++) {
//			temp[i] = data[i];
//		}
//		data = temp;
//	}
//	
//	public void set(int index, int value) {
//		if(index > nextIndex) {
//			//Error
//			return;
//		}
//		else if(index < nextIndex) data[index] = value;
//		else add(value);
//	}
//	
//	public int get(int index) {
//		if(index == nextIndex || index > nextIndex) {
//			//Error
//			return -1;
//		} else return data[index];
//	}
//	
//	public boolean isEmpty() {
//		if(size() == 0) return true;
//		else return false;
//	}
//	
//	public int removeLast() {
//		if(size()==0) {
//			//Error
//			return -1;
//		} else {
//			int temp = data[nextIndex-1];
//			data[nextIndex-1] = 0;
//			nextIndex--;
//			return temp;
//		}
//	}
//	
//	public void print() {
//		for(int i=0; i<nextIndex; i++) {
//			System.out.print(data[i] + " ");
//		}
//		System.out.println();
//	}
//	
//}

