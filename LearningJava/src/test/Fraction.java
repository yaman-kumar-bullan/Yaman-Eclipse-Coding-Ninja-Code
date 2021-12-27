package test;

public class Fraction {
	
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		try {
			if(denominator == 0) {
				ZeroDenominatorException e = new ZeroDenominatorException();
				throw e;
			}
		} catch(ZeroDenominatorException e) {
			System.out.println("Don't enter 0 in denominator");
			return;
		} 
		this.numerator = numerator;
		this.denominator = denominator;
		simplify();
	}
	
	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
		simplify();
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator){
		try {
			if(denominator == 0) {
				ZeroDenominatorException e = new ZeroDenominatorException();
				throw e;
			}
		} catch(ZeroDenominatorException e) {
			System.out.println("Don't enter 0 in denominator");
			return;
		} 
		
		
		this.denominator = denominator;
		simplify();
	}

	public void print() {
		if(denominator == 1) System.out.println(numerator);
		else {
			System.out.println(numerator + "/" + denominator);
		}
	}
	
	private void simplify() {
		int gcd = 1;
		int smaller = Math.min(numerator, denominator);
		for(int i=2; i<=smaller; i++) {
			if(numerator%i==0 && denominator%i==0) gcd = i;
		}
		
		numerator = numerator/gcd;
		denominator = denominator/gcd;
	}

	public void add(Fraction f) {
		int num = this.numerator*f.denominator + f.numerator*this.denominator;
		int den = this.denominator * f.denominator;
		this.numerator = num;
		this.denominator = den;
		simplify();
	}
	
	public void multiply(Fraction f) {
		int num = this.numerator*f.numerator;
		int den = this.denominator*f.denominator;
		this.numerator = num;
		this.denominator = den;
		simplify();
	}

	public static Fraction add(Fraction f1, Fraction f2) {
		int num = f1.numerator*f2.denominator + f2.numerator*f1.denominator;
		int den = f1.denominator * f2.denominator;
		Fraction f = new Fraction(num,den);
		return f;
	}
	
	public static void main(String[] args) {
		
	}
}
