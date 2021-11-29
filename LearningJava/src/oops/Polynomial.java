package oops;

public class Polynomial {

	private DynamicArray coefficients;
	
	public Polynomial() {
		coefficients = new DynamicArray();
	}
	
	public void print() {
		
		int data[] = coefficients.data;
		for(int i=0; i<data.length; i++) {
			if(data[i] == 0) continue;
			else {
				System.out.print(data[i] + "x^" + i + " + ");
			}
		}
		System.out.println();
	}
	
	public void setCoefficient(int power, int coefficient) {
		coefficients.set(power, coefficient);
	}
	
	public int getCoefficient(int power) {
		return coefficients.get(power); 
	}
	
	public int degree() {
		int[] data = coefficients.data;
		int degree = 0;
		for(int i=0; i<data.length; i++) {
			if(data[i] != 0) degree = i;
		}
		return degree;
	}
	
	public void multiply(Polynomial p) {
		int data1[] = this.coefficients.data;
		int data2[] = p.coefficients.data;
		
//		int newSize = this.degree() + p.degree();
		
//		int temp[] = new int[newSize+1];
		
		int temp[] = new int[data1.length+data2.length];
		
		for(int i=0; i<data1.length; i++) {
			for(int j=0; j<data2.length; j++) {
				temp[i+j] += data1[i] * data2[j];
			}
		}
		
		this.coefficients.data = temp;
	}

	public void subtract(Polynomial p) {
		int[] data1 = this.coefficients.data;
		int[] data2 = p.coefficients.data;
		
		int newSize = Math.max(data1.length, data2.length);
		int temp[] = new int[newSize];
		
		int i=0;
		for(i=0; i<Math.min(data1.length, data2.length); i++) {
			temp[i] = data1[i] - data2[i];
		}
		
		if(data1.length < data2.length) {
			while(i<data2.length) {
				temp[i] = data2[i];
				i++;
			}
		} else {
			while(i<data1.length) {
				temp[i] = data1[i];
				i++;
			}
		}
		
		this.coefficients.data = temp;
	}
	
	public static Polynomial add(Polynomial p1, Polynomial p) {
		int[] data1 = p1.coefficients.data;
		int[] data2 = p.coefficients.data;
		
		int newSize = Math.max(data1.length, data2.length);
		int temp[] = new int[newSize];
		
		int i=0;
		for(i=0; i<Math.min(data1.length, data2.length); i++) {
			temp[i] = data1[i] + data2[i];
		}
		
		if(data1.length < data2.length) {
			while(i<data2.length) {
				temp[i] = data2[i];
				i++;
			}
		} else {
			while(i<data1.length) {
				temp[i] = data1[i];
				i++;
			}
		}
		
		Polynomial newPoly = new Polynomial();
		newPoly.coefficients.data = temp;
		return newPoly;
	}

	public int evaluate(int x) {
		int temp[] = this.coefficients.data;
		int ans = 0;
		for(int i=0; i<temp.length; i++) {
			int power = fastPower(x, i);
			ans += temp[i] * power;
		}
		return ans;
	}
	
	public int fastPower(int x, int y) {
		if(y==0) return 1;
		
		if(y%2==0) return fastPower(x*x, y/2);
		else return x * fastPower(x,y-1);
	}
	
	public void add(Polynomial p) {
		int[] data1 = this.coefficients.data;
		int[] data2 = p.coefficients.data;
		
		int newSize = Math.max(data1.length, data2.length);
		int temp[] = new int[newSize];
		
		int i=0;
		for(i=0; i<Math.min(data1.length, data2.length); i++) {
			temp[i] = data1[i] + data2[i];
		}
		
		if(data1.length < data2.length) {
			while(i<data2.length) {
				temp[i] = data2[i];
				i++;
			}
		} else {
			while(i<data1.length) {
				temp[i] = data1[i];
				i++;
			}
		}
		
		this.coefficients.data = temp;
	}
}
