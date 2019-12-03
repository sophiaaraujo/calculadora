//import java.awt.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculos {

	public static void main(String[] args) {
		String resultado;
		List<Double> listaNumeros = new ArrayList<Double>();
		List<Character> listaOperadores = new ArrayList<Character>();
        Scanner teclado = new Scanner(System.in);
		//Calculos c = new Calculos();
		//System.out.println(">>>>" + c.calculadora("5/5"));
        System.out.println("digite a expressão: ");
		String expressao = teclado.nextLine();
		calculadora(expressao);
		calcularValor(listaNumeros, listaOperadores);
		
		
    	
	}

	public static String calculadora(String expressao, String resultado ) {
	
		List<Double> listaNumeros = new ArrayList<Double>();
		List<Character> listaOperadores = new ArrayList<Character>();
		listaNumeros = obterNumeros(expressao);
		listaOperadores = obterOperadores(expressao);

		resultado = calcularValor(listaNumeros, listaOperadores);

		return resultado;

	}

	public static String calcularValor(List<Double> listaNumeros, List<Character> listaOperadores) {
		String resultado = "";
		double total = 0.0;
		int j = 0;
		for (int i = 0; i < listaNumeros.size() - 1; i++) {

			if (total == 0.0) {
				double numero1 = listaNumeros.get(i).doubleValue();
				double numero2 = listaNumeros.get(i + 1).doubleValue();
				char operador = listaOperadores.get(i).charValue();
				total = executarOperacao(numero1, operador, numero2);
			} else if (total > 0.0) {

				double numero2 = listaNumeros.get(i).doubleValue();
				char operador = listaOperadores.get(j).charValue();
				total = executarOperacao(total, operador, numero2);
				j++;
			}

		}

		resultado = "" + total;
		return resultado;
	}

	public static double executarOperacao(double numero1, char operador, double numero2) {
		double resultado = 0.0;

		if (operador == '+') {
			resultado = numero1 + numero2;
		} else if (operador == '-') {
			resultado = numero1 - numero2;
		} else if (operador == '/') {
			resultado = numero1 / numero2;
		} else if (operador == '*') {
			resultado = numero1 * numero2;
		}
		return resultado;
	}

	public static List<Double> obterNumeros(String expressao) {

		List<Double> listaNumeros = new ArrayList<Double>();

		String numeroEmString = "";
		for (int i = 0; i < expressao.length(); i++) {

			if (isOperador(expressao.charAt(i))) {
				Double numero = Double.valueOf(numeroEmString);
				listaNumeros.add(numero);
				numeroEmString = "";
			} else {
				numeroEmString = numeroEmString.concat("" + expressao.charAt(i));
			}
		}
		if (!numeroEmString.isEmpty()) {
			Double numero = Double.valueOf(numeroEmString);
			listaNumeros.add(numero);

		}
		return listaNumeros;
	}

	public static List<Character> obterOperadores(String expressao) {

		List<Character> listaOperadores = new ArrayList<Character>();

		for (int i = 0; i < expressao.length(); i++) {

			if (isOperador(expressao.charAt(i))) {
				listaOperadores.add(new Character(expressao.charAt(i)));
			}
		}

		return listaOperadores;
	}

	public static boolean isOperador(char caracter) {
		boolean isOperador = false;
		if (caracter == '-' || caracter == '+' || caracter == '/' || caracter == '*') {
			isOperador = true;
		}
		return isOperador;
	}

}
