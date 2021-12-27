package test;

public class PolynomialUse {

	public static void main(String[] args) {
		
		Polynomial p = new Polynomial();
		
		p.setCoefficients(0, 4);
		p.setCoefficients(100, 2);
		p.setCoefficients(5, 3);
		p.print();

	}

}
