
//Matt Lynn
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PigLatinConverter {

	public static void main(String[] args) {
		String userWayEntryWay = "";
		String userEntry = "";
		String cont = "Y";
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Pig Latin Translator!");
		do {
			do {
				System.out.println("Please enter a line to be Translated");
				userEntry = scan.nextLine();
			} while (userEntry.equals(""));
			userWayEntryWay = bippityBoppityPiggityLatiny(userEntry);
			System.out.println(userWayEntryWay);
			System.out.println("Enter a new word? (y/n)");

		} while (cont.equalsIgnoreCase("y"));

		scan.close();

	}

	public static String bippityBoppityPiggityLatiny(String sentence) {
		String sentenceSwapped = "";
		String[] breakItUp;
		
		breakItUp = sentence.split(" ");
		String[] glueItBack = new String[breakItUp.length];
		System.out.println(Arrays.toString(breakItUp));

		// loops through multiple words
		for (int i = 0; i < breakItUp.length; i++) {
			if (Pattern.matches("[A-Za-z']*", breakItUp[i])) {
				if (findTheVowel(breakItUp[i]) > 0) {
					glueItBack[i] = assemblePig(breakItUp[i], findTheVowel(breakItUp[i]));
				} else if (findTheVowel(breakItUp[i]) == -2) {
					glueItBack[i] = breakItUp[i] + "way ";
				}
			} else
				glueItBack[i] = breakItUp[i] + " ";
			sentenceSwapped += glueItBack[i];

		}

		return sentenceSwapped;
	}

	// returns the index of the vowel or alternate
	public static int findTheVowel(String word) {
		for (int i = 0; i < word.length(); i++) {
			char vowel = word.charAt(i);

			if (vowel == 'a' || vowel == 'e' || vowel == 'i' || vowel == 'o' || vowel == 'u' || vowel == 'A'
					|| vowel == 'E' || vowel == 'I' || vowel == 'O' || vowel == 'U') {
				if (i == 0) {
					return -2;
				} else {
					return i;
				}
			}
		}

		return -1;
	}

//assembles the pig latin words and sentence
	public static String assemblePig(String word, int index) {
		String pigWord = "";
		String latinWord = "";
		for (int j = 0; j < index; j++) {
			latinWord += word.charAt(j);
		}
		for (int j = index; j < word.length(); j++) {
			pigWord += word.charAt(j);
		} // ay
		return pigWord + latinWord + "ay ";
	}

}
