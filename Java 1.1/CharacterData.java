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
public class CharacterData {
	//Should be private!!! But im too laze to create a getTotal and getCharacter Method XD
	public int total = 0;
	public char character;

	public CharacterData(char character){
		int intChar = character;
		if(intChar >= 97 && intChar <=122)
			this.character = character;
		else
			throw new IllegalArgumentException("the sentence contains non valid arguments :I");
	}
	public void addWord(String word) {
		String wordToLowerCase = word.toLowerCase();
		for(int i = 0; i<wordToLowerCase.length(); i++)
			if(wordToLowerCase.charAt(i) == character)
				total++;
	}



	public static void main(String[] args){
		CharacterData cd = new CharacterData('b');
		int numcd = cd.character;
		System.out.println("Your character: '"+cd.character+"' with number: "+numcd+" Total:"+cd.total);
		System.out.println("********************Bubbles********************");
		cd.addWord("Bubbles");
		System.out.println("Your character: '"+cd.character+"' with number: "+numcd+" Total:"+cd.total);
		System.out.println("********************tree********************");
		cd.addWord("tree");
		System.out.println("Your character: '"+cd.character+"' with number: "+numcd+" Total:"+cd.total);
		System.out.println("********************bigbang********************");
		cd.addWord("bigbang");
		System.out.println("Your character: '"+cd.character+"' with number: "+numcd+" Total:"+cd.total);
	}
}