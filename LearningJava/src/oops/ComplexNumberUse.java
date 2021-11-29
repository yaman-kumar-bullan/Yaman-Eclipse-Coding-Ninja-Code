package oops;

public class ComplexNumberUse {

	public static void main(String[] args) {
		
		Complex c1 = new Complex(2,3);
		c1.print();
		//2+3i
		
		c1.setReal(10);
		c1.setImaginary(30);
		c1.print();
		//10+30i
		
		Complex c2 = new Complex(1,5);
		c1.add(c2);
		c1.print();
		//11+35i
		c2.print();
		//1+5i
		
		Complex c3 = new Complex(3,2);
		c3.multiply(c2);
		c3.print();
		//-7+17i
		c2.print();
		//1+5i
		
		Complex c4 = Complex.addComplex(c1, c3);
		c1.print();
		//11+35i
		c3.print();
		//-7+17i
		c4.print();
		//4+52i
		
		Complex c5 = c1.conjugate();
		c5.print();
		//11-35i

	}

}
