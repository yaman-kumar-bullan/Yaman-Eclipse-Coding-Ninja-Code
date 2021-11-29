package oops;

public class DynamicArrayUse {

	public static void main(String[] args) {
		
		DynamicArray da = new DynamicArray();
		
		System.out.println(da.size());
		System.out.println(da.isEmpty());
		da.print();
		da.add(4);
		da.add(7);
		da.print();
		System.out.println(da.size());
		da.set(8, 3);
		da.set(2, 9);
		da.set(1, 50);
		da.print();
		System.out.println(da.get(73));
		System.out.println(da.get(2));
		System.out.println(da.isEmpty());
		
		System.out.println(da.size());
		System.out.println(da.removeLast());
		System.out.println(da.size());
		da.print();
		
	}

}
