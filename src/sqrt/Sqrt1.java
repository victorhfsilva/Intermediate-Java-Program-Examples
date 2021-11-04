package sqrt;

public class Sqrt1 {
	
	//Variables
	private double sqrtOf;
	private int n;
	private double A0;
	private double A1;	
	public double sqrt;
	
	//Getters
	public double getSqrtOf() {
		return sqrtOf;
	}
	public double getA0() {
		return A0;
	}
	public double getA1() {
		return A1;
	}

	//Constructor
	public Sqrt1(double sqrtOf, int n) {
		this.sqrtOf = sqrtOf;
		this.n = n;
		for (int i = 0; Math.pow(i, 2)<=sqrtOf; i++) {
			A0 = i;
		}
		for (int i = 1; i<n; i++) {
			for (int j = 0; Math.pow(A0+j/Math.pow(10, i),2)<=sqrtOf; j++) {
				A1 = A0 + (j+1)/Math.pow(10, i);
				A0 += j/Math.pow(10, i);
			}
		}
		sqrt = (A0+A1)/2;
	}
	
	public static void main(String[] args) {
		Sqrt1 sqrt2 = new Sqrt1(2,16);
		System.out.println(sqrt2.sqrt);
		Sqrt1 sqrt3 = new Sqrt1(3,16);
		System.out.println(sqrt3.sqrt);
		Sqrt1 sqrtPi = new Sqrt1(Math.PI,16);
		System.out.println(sqrtPi.sqrt);
	}
	
}
