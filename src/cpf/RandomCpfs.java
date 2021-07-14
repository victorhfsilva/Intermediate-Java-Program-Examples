package cpf;

import java.util.ArrayList;
import java.util.Random;

public class RandomCpfs {
	
	private ArrayList randomCpfs = new ArrayList();
	
	//Getter and Setters
	public ArrayList getRandomCpfs() {
		return randomCpfs;
	}

	public void setRandomCpfs(ArrayList randomCpfs) {
		this.randomCpfs = randomCpfs;
	}
	
	//Constructor
	public RandomCpfs(int cpfNums) {
		Random gen =  new Random();
		int random;
 		for (int i = 0; i < cpfNums; i++) {
 			String cpfInserido = "";
 			for (int j = 0; j < 9; j++) {
				random = gen.nextInt(10);
				cpfInserido += random;
			}
			CPF cpf = new CPF(cpfInserido);
			randomCpfs.add(cpf);
		}
	}
	
}
