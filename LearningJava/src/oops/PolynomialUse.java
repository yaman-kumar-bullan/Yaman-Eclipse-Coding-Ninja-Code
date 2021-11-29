package oops;

public class PolynomialUse {

	public static void main(String[] args) {
		
		Polynomial p = new Polynomial();
		p.setCoefficient(3, 8);
		p.print();
		p.setCoefficient(0, 2);
		p.print();
		System.out.println(p.getCoefficient(55));
		System.out.println(p.getCoefficient(3));
		System.out.println(p.degree());
		
		p.setCoefficient(1, 3);
		// p = 2x^0 + 3x^1 + 8x^3  
		
		Polynomial p2 = new Polynomial();
		p2.setCoefficient(0, 9);
		p2.setCoefficient(2, 4);
		p2.setCoefficient(3, 6);
		p2.setCoefficient(8, 2);
		
//		p2 = 9x^0 + 4x^2 +
		
		p.add(p2);
		p.print();
		
		p.multiply(p2);
		p.print();
		
		p.subtract(p2);
		p.print();
		
		Polynomial newPoly = Polynomial.add(p, p2);
		newPoly.print();
		
//		System.out.println(p2.evaluate(10));
	}

}
