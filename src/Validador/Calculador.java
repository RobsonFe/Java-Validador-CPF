package Validador;

public class Calculador {
	
	private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	public static boolean isValid(String cpfCnpj) {
		return (isValidCPF(cpfCnpj) || isValidCNPJ(cpfCnpj));
	}

	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	private static String padLeft(String text, char character) {
		return String.format("%11s", text).replace(' ', character);
	}

	private static boolean isValidCPF(String cpf) {
		cpf = cpf.trim().replace(".", "").replace("-", "");
		if ((cpf == null) || (cpf.length() != 11))
			return false;

		for (int j = 0; j < 10; j++)
			if (padLeft(Integer.toString(j), Character.forDigit(j, 10)).equals(cpf))
				return false;

		Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
		Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
		return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
	}

	private static boolean isValidCNPJ(String cnpj) {
		cnpj = cnpj.trim().replace(".", "").replace("-", "");
		if ((cnpj == null) || (cnpj.length() != 14))
			return false;

		Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
		Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
		return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
	}
}

/*
 * Este código Java é uma classe chamada Calculador que contém métodos para validar números de CPF (Cadastro de Pessoa Física) e CNPJ (Cadastro Nacional da Pessoa Jurídica) no Brasil. Vou explicar o código passo a passo de forma simples:

A classe possui duas constantes de arrays de inteiros chamadas pesoCPF e pesoCNPJ. Esses arrays são usados para calcular os dígitos verificadores de CPF e CNPJ.

O método público isValid(String cpfCnpj) é o ponto de entrada para validar um número de CPF ou CNPJ. Ele chama os métodos isValidCPF e isValidCNPJ internamente e retorna true se um dos métodos for válido.

Os métodos calcularDigito são métodos privados usados para calcular os dígitos verificadores de CPF e CNPJ. Eles fazem uma série de cálculos com base nos pesos definidos nos arrays pesoCPF e pesoCNPJ.

O método privado padLeft é usado para preencher uma string com um caractere à esquerda até que ela atinja o tamanho desejado. No código, ele é usado para formatar os números de CPF ou CNPJ com zeros à esquerda.

Os métodos privados isValidCPF e isValidCNPJ fazem a validação real dos números de CPF e CNPJ. Eles removem pontos e traços, verificam o comprimento correto e calculam os dígitos verificadores. Se o número for válido, eles retornam true, caso contrário, retornam false.

A classe Calculador encapsula a lógica de validação de CPF e CNPJ em métodos reutilizáveis, permitindo que você verifique facilmente se um número de CPF ou CNPJ é válido em seu código Java. Você pode usar o método isValid para essa verificação.


 * */
