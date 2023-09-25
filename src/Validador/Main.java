package Validador;

public class Main {

	public static void main(String[] args) {
		
		String cpf = "123.456.789-09";
		String cnpj = "12.345.678/0001-01";

		if (Calculador.isValid(cpf)) {
			System.out.println("CPF válido.");
		} else {
			System.out.println("CPF inválido.");
		}

		if (Calculador.isValid(cnpj)) {
			System.out.println("CNPJ válido.");
		} else {
			System.out.println("CNPJ inválido.");
		}


	}

}
