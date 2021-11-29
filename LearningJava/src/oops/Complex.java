package oops;

public class Complex {
	
	private int real;
	private int imaginary;
	
	public Complex(int real, int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getImaginary() {
		return imaginary;
	}

	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}
	
	public void print() {
		if(this.imaginary < 0) {
			this.imaginary = this.imaginary * -1;
			System.out.println(this.real + " - " + this.imaginary + "i");
		} else {
			System.out.println(this.real + " + " + this.imaginary + "i");
		}
	}
	
	public void add(Complex c) {
		this.real = this.real + c.real;
		this.imaginary = this.imaginary + c.imaginary;
	}
	
	public void multiply(Complex c) {
		int imaginary = this.real * c.imaginary + this.imaginary * c.real;
		int real = (this.real * c.real) + (this.imaginary*c.imaginary*(-1));
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public static Complex addComplex(Complex c1, Complex c2) {
		int real = c1.real + c2.real;
		int imaginary = c1.imaginary + c2.imaginary;
		Complex c = new Complex(real, imaginary);
		return c;
	}
	
	public Complex conjugate() {
		int real = this.real;
		int imaginary = this.imaginary * (-1);
		Complex c1 = new Complex(real, imaginary);
		return c1;
	}
	
}
