package primeNum;

import java.util.ArrayList;

public class PrimeNumbersSqrt {

	static final double MAX_NUM = Math.pow(10,3);
	
	public static double sqrt(int i) {
		return Math.pow(i, 0.5);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		ArrayList<Integer> primesLessThanSqrtN = new ArrayList<Integer>();
		
		//Variables
		primes.add(2);
		double root;
		boolean isPrime;
		int iterations=0;
		
		for (int i = 3; i < MAX_NUM; i++) {
			root = sqrt(i);
			isPrime = true;
			int j = 0;
			
			while (primes.get(j)<=root) {
				primesLessThanSqrtN.add(primes.get(j));
				j++;
				iterations++;
			}
			for (int k = 0; k < primesLessThanSqrtN.size(); k++) {
				iterations++;
				if (i % primesLessThanSqrtN.get(k) == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) primes.add(i);
			primesLessThanSqrtN.clear();
		}
		System.out.println(primes);
		System.out.println("Iterations: "+iterations);
	}

}
