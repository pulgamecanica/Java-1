import java.util.Scanner;
import static java.lang.System.out;

public class Exercice1_1 {
	public static void main(String[] args) {
		exercice1_1(args);
		exercice1_2_A(args);//CheckIntegers
		exercice1_2_B(args);//Convert to int, if its int.
		exercice1_3(args);//Filter all
	}
	public static void exercice1_1(String[] args) {
		for(int i = 0; i<args.length; i++)
			System.out.println(".-.-.-."+(i+1)+"  "+args[i]);
	}


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
		for(int i = 0, k = string.length()-1; i<string.length(); i++, k--){
			int box = Character.getNumericValue(string.charAt(i));
			if(k == 0)
				a = box;
				number = number + box * (10*k) + a;
			}
		System.out.println(number);
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








}