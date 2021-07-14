package cpf;

import java.util.ArrayList;

public class DigitosVerificadores {
	
	//Declaração de Variáveis
	private String digitosVerificadores;
	private ArrayList<Integer> intDigitosVerificadores = new ArrayList<Integer>();
	private ArrayList<Integer> digitosCpfCompleto = new ArrayList<Integer>();
	
	//Getters and Setters
	public String getDigitosVerificadores() {
		return digitosVerificadores;
	}

	public void setDigitosVerificadores(String digitosVerificadores) {
		this.digitosVerificadores = digitosVerificadores;
	}

	public ArrayList<Integer> getIntDigitosVerificadores() {
		return intDigitosVerificadores;
	}

	public void setIntDigitosVerificadores(ArrayList<Integer> intDigitosVerificadores) {
		this.intDigitosVerificadores = intDigitosVerificadores;
	}

	public ArrayList<Integer> getDigitosCpfCompleto() {
		return digitosCpfCompleto;
	}

	public void setDigitosCpfCompleto(ArrayList<Integer> digitosCpfCompleto) {
		this.digitosCpfCompleto = digitosCpfCompleto;
	}

	//Constructor
	public DigitosVerificadores(ArrayList<Integer> digitosCpfInserido) {
		
		//Lança Erro caso o número de digitos seja diferente de 9
		try {if (digitosCpfInserido.size() != 9) throw new Exception();}
		catch (Exception ComprimentoDoDigitoErrado) {
			System.out.println("Comprimento do Dígito Diferente de 9.");
			return;
		}
		
		//Extração os Dígitos da String
		digitosCpfCompleto = (ArrayList<Integer>) digitosCpfInserido.clone();
		
		//Realização da primeira multiplicação e soma dos dígitos
		ArrayList<Integer> primeiraMultiplicacao = new ArrayList<Integer>();
		for (int i = 10; i>1; i--) {
			primeiraMultiplicacao.add(digitosCpfCompleto.get(digitosCpfCompleto.size()-i+1)*i);
		}
		int primeiraSoma = primeiraMultiplicacao.stream().mapToInt(Integer::intValue).sum();
		
		//Cálculo do primeiro dígito verificador
		int primeiroDigito;
		int primeiroResto = primeiraSoma%11;
		if (primeiroResto < 2) primeiroDigito = 0;
		else primeiroDigito = 11 - primeiroResto;
		//Inlcui o Primeiro Digito Verificador na Lista de Digitos
		intDigitosVerificadores.add(primeiroDigito);
		digitosCpfCompleto.add(primeiroDigito);
				
		//Realização da segunda multiplicação e soma dos dígitos
		ArrayList<Integer> segundaMultiplicacao = new ArrayList<Integer>();
		for (int i = 10; i>1; i--) {
			segundaMultiplicacao.add(digitosCpfCompleto.get(digitosCpfCompleto.size()-i+1)*i);
		}
		int segundaSoma = 0;
		for (int i = 0; i < segundaMultiplicacao.size(); i++) {
			segundaSoma += segundaMultiplicacao.get(i);
		}
		
		//Cálculo do segundo dígito verificador
		int segundoDigito;
		int segundoResto = segundaSoma%11;
		if (segundoResto < 2) segundoDigito = 0;
		else segundoDigito = 11 - segundoResto;
		//Inlcui o Segundo Digito Verificador na Lista de Digitos
		intDigitosVerificadores.add(segundoDigito);
		digitosCpfCompleto.add(segundoDigito);
		
		digitosVerificadores = String.valueOf(primeiroDigito)+String.valueOf(segundoDigito);
		
		
	}
	
}
