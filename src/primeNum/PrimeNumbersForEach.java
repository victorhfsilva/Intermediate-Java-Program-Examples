package primeNum;

import java.util.ArrayList;

public class PrimeNumbersForEach {

static final double MAX_NUM = Math.pow(10,3);
	
	public static double sqrt(int i) {
		return Math.pow(i, 0.5);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		//Variables
		primes.add(2);
		boolean isPrime;
		int iterations=0;
		
		for (int i = 3; i < MAX_NUM; i++) {
			isPrime = true;
			
			for (int k = 0; k < primes.size(); k++) {
				iterations++;
				if (i % primes.get(k) == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) primes.add(i);
		}
		System.out.println(primes);
		System.out.println("Iterations: "+iterations);
	}

}
