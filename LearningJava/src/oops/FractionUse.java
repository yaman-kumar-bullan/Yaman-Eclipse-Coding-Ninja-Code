package oops;

public class FractionUse {

	public static void main(String[] args) {
		
		Fraction f1 = new Fraction(10,30);
		f1.print();
		
		f1.setNumerator(5);
		f1.print();
		
		Fraction f2 = new Fraction(4,5);
		
//		f2.add(f1);
		f2.multiply(f1);
		System.out.println(f2.getDenominator());
		System.out.println(f2.getNumerator());
		f2.print();
		
		Fraction f = Fraction.add(f1, f2);
		f.print();
		
	}

}
