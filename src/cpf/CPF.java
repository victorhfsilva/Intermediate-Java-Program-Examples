package cpf;

import java.util.ArrayList;
import java.util.Random;

public class CPF {
	
	//Variables
	private String cpfInserido;
	private ArrayList<Integer> digitosCpfInserido = new ArrayList<Integer>();
	
	private String digitosVerificadores;
	private ArrayList<Integer> intDigitosVerificadores = new ArrayList<Integer>();
	
	private String cpfCompleto;
	private ArrayList<Integer> digitosCpfCompleto = new ArrayList<Integer>();
	
	public String getCpfInserido() {
		return cpfInserido;
	}

	public void setCpfInserido(String cpfInserido) {
		this.cpfInserido = cpfInserido;
	}

	public ArrayList<Integer> getDigitosCpfInserido() {
		return digitosCpfInserido;
	}

	public void setDigitosCpfInserido(ArrayList<Integer> digitosCpfInserido) {
		this.digitosCpfInserido = digitosCpfInserido;
	}

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

	public String getCpfCompleto() {
		return cpfCompleto;
	}

	public void setCpfCompleto(String cpfCompleto) {
		this.cpfCompleto = cpfCompleto;
	}

	public ArrayList<Integer> getDigitosCpfCompleto() {
		return digitosCpfCompleto;
	}

	public void setDigitosCpfCompleto(ArrayList<Integer> digitosCpfCompleto) {
		this.digitosCpfCompleto = digitosCpfCompleto;
	}

	//Constructors
	public CPF(String cpfInserido) {
		this.cpfInserido = cpfInserido;
		digitosCpfInserido = ExtracaoDigitos(cpfInserido);
		DigitosVerificadores digitosVerif = new DigitosVerificadores(digitosCpfInserido);
		digitosVerificadores = digitosVerif.getDigitosVerificadores();
		intDigitosVerificadores = (ArrayList<Integer>) digitosVerif.getIntDigitosVerificadores().clone();
		digitosCpfCompleto = (ArrayList<Integer>) digitosVerif.getDigitosCpfCompleto().clone();
		cpfCompleto = CPFCompleto();
	}
	
	
	public boolean DigitosVerificadoresCorretos(String cpfCompleto) {
		ArrayList<Integer> digitosCpfCompleto = ExtracaoDigitos(cpfCompleto);
		ArrayList<Integer> digitosCpfSemVerificadores = new ArrayList<Integer>();
		ArrayList<Integer> digitosVerificadores = new ArrayList<Integer>();
		
		//Lança Erro caso o número de digitos seja diferente de 11
		try {if (digitosCpfCompleto.size() != 11) throw new Exception();}
		catch (Exception ComprimentoDoDigitoErrado) {
			System.out.println("Comprimento do Dígito Diferente de 11.");
			return false;
		}
		//Extrai o cpf sem digitos verificadores do CPF completo
		for (int i = 0; i < 9; i++) {
			digitosCpfSemVerificadores.add(digitosCpfCompleto.get(i));
		}
		//Extrai os dígitos verificadores do CPF complento
		for (int i = 9; i < 11; i++) {
			digitosVerificadores.add(digitosCpfCompleto.get(i));
		}
		//Verifica se os digitos verificadores são iguais
		DigitosVerificadores digitosVerif = new DigitosVerificadores(digitosCpfSemVerificadores);
		if (digitosVerificadores.get(0) == digitosVerif.getIntDigitosVerificadores().get(0) 
			&& digitosVerificadores.get(1) == digitosVerif.getIntDigitosVerificadores().get(1)) {
			return true;
		}
		
		return false;
	}
	
	//Extração de Dígitos
	public ArrayList<Integer> ExtracaoDigitos(String cpfInserido){
		//Extração os Dígitos da String
		ArrayList<Integer> digitos = new ArrayList<Integer>();
		for (int i = 0; i < cpfInserido.length(); i++) {
			int digito = Character.getNumericValue(cpfInserido.charAt(i));
			//Não adiciona o dígito se ele for menor que 0 ou maior que 9
			if (digito >= 0 && digito < 10 ) digitos.add(digito);
		}
		return digitos;
	}
	
	
	public String CPFCompleto() {
		
		//Cria um número de CPF incluindo o primeiro e o segundo dígito verificador
		String cpfCompleto ="";
		for (int i = 0; i < digitosCpfCompleto.size(); i++) {
			cpfCompleto += digitosCpfCompleto.get(i);
		}
		cpfCompleto = cpfCompleto.substring(0, 3)+"."+cpfCompleto.substring(3, 6)+"."+cpfCompleto.substring(6, 9)+"-"+cpfCompleto.substring(9, 11);
		System.out.println("CPF: "+cpfCompleto);		
		return cpfCompleto;
		
	}

}
