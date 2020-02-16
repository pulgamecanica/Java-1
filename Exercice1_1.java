import java.util.Scanner;
import static java.lang.System.out;
import java.io.*; 
import java.util.*;
public class Exercice1_1 {

	public static void main(String[] args) {
		//exercice1_1(args);
		//exercice1_2_A(args);//CheckIntegers
		//exercice1_2_B(args);//Convert to int, if its int.
		//exercice1_3(args);//Filter all
		//exercice1_4(args);//CharacterStats
		exercice1_5(args);
	}
	//Escreva um programa que liste os argumentos passados ao mesmo. Para imprimir valores para a consola invoque System.out.println(...
	public static void exercice1_1(String[] args) {
		for(int i = 0; i<args.length; i++)
			System.out.println(".-.-.-."+(i+1)+"  "+args[i]);
	}
	//*
	/*
	Desenvolva funções para:
	a) Verificar se uma String corresponde a um inteiro. Para efeitos de simplificação, considere apenas inteiros positivos.
	b) Obter um inteiro a partir de uma String, assumindo que a mesma é válida (a função da alínea (a) devolve verdadeiro para o mesmo argumento).
	Dica: existe uma função nas bibliotecas do Java para fazer isto (Integer.parseInt(String)), mas o objetivo aqui é implementar sem a utilizar.
	*/
	public static boolean contains_int(String arg) {
		for(int j = 0; j<arg.length();j++){
			if(!Character.isDigit(arg.charAt(j)))
				return false;
			}
		return true;
	}
	public static void exercice1_2_A(String[] args) {
		int sum = 0;
		int int_counter = 0;
		int not_int_counter = 0;
		for(int i = 0; i<args.length; i++){
			if(args[i].isEmpty())
				not_int_counter++;
			else if(contains_int(args[i])){
				int_counter++;
			}
			else
				not_int_counter++;
			System.out.println("  "+args[i]+"  ");
		}
		System.out.println("Encontrei "+ int_counter + " inteiros");
		System.out.println("Encontrei "+ not_int_counter + " termos nao inteiros");
	}
	public static int convert_string_to_int(String string){
		int a = 0;
		int number = 0;
		for(int i = 0; i<string.length(); i++){
			int box = Character.getNumericValue(string.charAt(i));
			number = number + box * (int)(Math.pow(10, (string.length() - 1 -i)));
			}
		return number;
	}

	public static void exercice1_2_B(String[] args) {
		int sum = 0;
		for(int i = 0; i < args.length; i++){
			if(args[i].isEmpty())
				System.out.println(args[i] + " is empty");
			else if(!contains_int(args[i]))
				System.out.println(args[i] + " is not an integer");
			else if(contains_int(args[i])){
				int number = convert_string_to_int(args[i]);
				System.out.println("We founded the number: " + args[i]);
				sum = sum + number;			
			}

		}
		System.out.println("Sum of all integers : "+ sum);
	}
	//*
	/*
	Desenvolva um programa que recebe como argumentos um conjunto de palavras, as quais serão utilizadas para filtrar as frases que o utilizador insira
	de seguida. O programa deve repetidamente pedir frases ao utilizador e de seguida exibir as mesmas filtradas (excluindo todas as palavras passadas 
	como argumento ao programa), até que seja dada uma frase vazia.
	*/
	public static String re_order_filter(String filtered_word, String line){
		String[] array_line = line.split(" ");
		for(int i = 0; i < array_line.length; i++){
			if(array_line[i].equals(filtered_word))
				array_line[i] = "";
		}
		String result = String.join(" ", array_line);
		return result;
	}
	public static String filter(String[] args, String line) {
		String result = line;
		for(int i = 0; i<args.length; i++)
			if(line.indexOf(args[i]) !=-1)
				result = re_order_filter(args[i], result);
		return result;
	}
	public static void exercice1_3(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = "frase";
		while(!line.isEmpty()) {
			out.print("-->frase:");
			line = scanner.nextLine(); // bloqueia ate ser dado enter
			out.println("-->linha: " + filter(args, line));
			}
		scanner.close();
	}
	//*
	/*
	Desenvolva um programa que apresente a contagem da frequência de caracteres nos seu argumentos da seguinte forma:
	> java CharacterStats atirei o pau ao gato
	> a: 4 (25.0%)
	> e: 1 (6.25%)
	> g: 1 (6.25%)
	> i: 2 (12.5%)
	> o: 3 (18.75%)
	> p: 1 (6.25%)
	> r: 1 (6.25%)
	> t: 2 (12.5%)
	> u: 1 (6.25%)
	*/
	public static double wordPercentage(String[] args, int total){
		int counter = 0;
		for(int i = 0; i < args.length; i++){
			if(args[i]!= null)
				counter += args[i].length();
		}
		return (double)total/(double)counter;
	}

	public static void exercice1_4(String[] args){
		for(int j = 0; j < 26; j++){
			CharacterData aphabetCheck = new CharacterData((char)(97+j));
			for(int i = 0; i<args.length; i++){
				aphabetCheck.addWord(args[i]);
				if(aphabetCheck.total > 0 && i == args.length - 1)
					out.println(aphabetCheck.character+": " + aphabetCheck.total + "("+wordPercentage(args, aphabetCheck.total)+"%)");
			}
		}
	}
	public static int doTheMath(int a, int b, String operator){
		if(operator.equals("+")){
			return a + b;
		}
		else if(operator.equals("-")){
			return a - b;
		}
		else if(operator.equals("x")){
			return a * b;
		}
		else{
			return a / b;
		}
	}
	public static void exercice1_5(String[] args){
		Stack<String> op = new Stack<String>();
		Stack<String> val = new Stack<String>();
		for(int i = 0; i < args.length; i++){
			if(contains_int(args[i])){
				val.push(args[i]);
			}else if(args[i].equals("+") || args[i].equals("-") || args[i].equals("x") || args[i].equals("/")){
				op.push(args[i]);
			}else if(args[i].equals(")")){
				String a = val.pop();
				String b = val.pop();
				String c = op.pop();
				String result = Integer.toString(doTheMath(convert_string_to_int(a),convert_string_to_int(b),c));
				val.push(result);
			}
		}
		System.out.println(val.lastElement());
	}
}