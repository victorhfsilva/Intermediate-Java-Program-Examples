package cpf;

public class Main {
	
	public static void main(String[] args) {
		CPF victor = new CPF("090.972-276b");		
		System.out.println();
		
		String victorCpfCompleto = victor.getCpfCompleto();
		boolean victorCorreto = victor.DigitosVerificadoresCorretos(victorCpfCompleto);
		System.out.println("Digitos Verificadores do Victor: "+victorCorreto);
		System.out.println("Digitos Verificadores 123.456.789-10: " + victor.DigitosVerificadoresCorretos("123.456.789-10"));
		System.out.println("Digitos Verificadores 054.381.645-17: " + victor.DigitosVerificadoresCorretos("054.381.645-17"));
		System.out.println();
		
		RandomCpfs cpfs = new RandomCpfs(100);
	}
}
