package test;

public class Polynomial {
	
	DynamicArray coefficients;
	
	public Polynomial() {
		coefficients = new DynamicArray();
	}
	
	public void print() {
		int[] data = coefficients.data;
		for(int i=0; i<data.length; i++) {
			if(data[i] == 0) continue;
			else System.out.print(data[i] + "x^" + i + " + ");
		}
		System.out.println();
	}
	
	public void setCoefficient(int index, int coefficient) {
		coefficients.set(index, coefficient);
	}
	
	public int getCoefficients(int index) {
		return coefficients.get(index);
	}
	
	public void add(Polynomial p) {
		int[] data1 = coefficients.data;
		int[] data2 = p.coefficients.data;
		
		int[] arr = new int[Math.max(data1.length, data2.length)];
		int i=0;
		for(i=0; i<Math.min(data1.length, data2.length); i++) {
			arr[i] = data1[i] + data2[i];
		}
		
		if(data1.length<data2.length) {
			while(i<data2.length) {
				arr[i] = data2[i];
				i++;
			}
		} else {
			while(i<data1.length) {
				arr[i] = data1[i];
				i++;
			}
		}
		
		this.coefficients.data = arr;
	}
	
	public void subtract(Polynomial p) {
		int[] data1 = this.coefficients.data;
		int[] data2 = p.coefficients.data;
		
		int[] arr = new int[Math.max(data1.length, data2.length)];
		int i=0;
		
		for(i=0; i<Math.min(data1.length, data2.length); i++) {
			arr[i] = data1[i] - data2[i];
		}
		
		if(data1.length<data2.length) {
			while(i<data2.length) {
				arr[i] = -data2[i];
				i++;
			}
		} else {
			while(i<data1.length) {
				arr[i] = data1[i];
				i++;
			}
		}
		
		this.coefficients.data = arr;
	}
	
	public int degree() {
		int[] data = this.coefficients.data;
		int degree = 0;
		for(int i=0; i<data.length; i++) {
			if(data[i] != 0) degree = i;
		}
		return degree;
	}
	
	public void multiply(Polynomial p) {
		int data1[] = this.coefficients.data;
		int data2[] = p.coefficients.data;
		int[] arr = new int[data1.length+data2.length];
		
		for(int i=0; i<data1.length; i++) {
			for(int j=0; j<data2.length; j++) {
				arr[i+j] += data1[i] * data2[j];
			}
		}
		this.coefficients.data = arr;
	}
	
	public static Polynomial add(Polynomial p1, Polynomial p2) {
		int[] data1 = p1.coefficients.data;
		int[] data2 = p2.coefficients.data;
		
		int[] arr = new int[Math.max(data1.length, data2.length)];
		int i=0;
		for(i=0; i<Math.min(data1.length, data2.length); i++) {
			arr[i] = data1[i] + data2[i];
		}
		
		if(data1.length<data2.length) {
			while(i<data2.length) {
				arr[i] = data2[i];
				i++;
			}
		} else {
			while(i<data1.length) {
				arr[i] = data1[i];
				i++;
			}
		}
		
		Polynomial p = new Polynomial();
		p.coefficients.data = arr;
		return p;
	}
	
}
