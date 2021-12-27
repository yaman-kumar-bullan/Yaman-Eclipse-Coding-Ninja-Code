package test;

public class Polynomial extends DynamicArray{
	
	private DynamicArray coEfficients;
	private int lastIndex;
	
	public Polynomial() {
		coEfficients = new DynamicArray();
		lastIndex = -1;
	}
	
//	public void set(int index, int element) {
//		if(index >= nextIndex) reStructure();
//		
//		arr[index] = element;
//		nextIndex = index + 1;
//	}
	
	public void setCoefficients(int power, int element) {
		while(!(power < coEfficients.arr.length)) {
			reStructure();
		}
		coEfficients.arr[power] = element;
		lastIndex = Math.max(power, lastIndex);
	}
	
//	public void setCoefficients(int power, int element) {
//		coEfficients.set(power, element);
//		lastIndex = Math.max(power, lastIndex);
//	}
	
	public int get(int index) {
		return arr[index];
	}
	
	public void print() {
		for(int i=0; i<=lastIndex; i++) {
			System.out.print(get(i) + "^" + i + " + ");
		}
	}
	
	public int degree() {
		return lastIndex;
	}
	
	public void add(Polynomial p) {
		int maxDegree = Math.max(this.lastIndex, p.lastIndex);
		
		for(int i=0; i<=maxDegree; i++) {
			int temp = this.coEfficients.get(i) + p.coEfficients.get(i);
			this.coEfficients.set(i, temp);
		}
	}
	
	
	

}
