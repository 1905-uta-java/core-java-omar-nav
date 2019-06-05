package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {		
		// convert into bytes array
        byte [] OGStringBytesArray = string.getBytes(); 
        
        // instantiate another array for the reversed array
        byte [] result =  new byte [OGStringBytesArray.length]; 
   
	    for (int i = 0; i<OGStringBytesArray.length; i++) 
	    	result[i] =  OGStringBytesArray[OGStringBytesArray.length-i-1]; 
	     String resultFinal = new String(result);
//	     System.out.println(new String(resultFinal));
		return resultFinal;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String acronym = "";

        acronym += phrase.toUpperCase().charAt(0);

        for (int i = 1; i <= phrase.length() - 1; i++) {
            if (phrase.charAt(i - 1) == ' ' || phrase.charAt(i - 1) == '-') {
            	acronym += phrase.toUpperCase().charAt(i);
            }
        }
//        System.out.println(acronym);

        return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. 
	 * An equilateral triangle has all three sides the same length. 
	 * An isosceles triangle has at least two sides the same length. 
	 * A scalene triangle has all sides of different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (sideOne == sideTwo && sideTwo == sideThree) {
				return true;
			} else {
			return false;
			}
		}

		public boolean isIsosceles() {
			if (sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) {
				return true;
			} else {
			return false;
			}
		}

		public boolean isScalene() {
			if (sideOne != sideTwo && sideTwo != sideThree && sideOne != sideThree) {
				return true;
			} else {
			return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 
				'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; 
		int[] values = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 
				1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
		int score = 0;
		string = string.toLowerCase();
		for(int i = 0; i < string.length(); i++) {
			  for(int j = 0; j < 26; j++) {
			    if(string.charAt(i) == letters[j])
			    {
			      score += values[j];
			    }
			  }
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 613 995 0253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		string = string.replace(" ", "").replace(".", "").replace("-", "").replace("(", "").replace(")", "");
		
		if(string.length()>11){
			throw new IllegalArgumentException("Number cannot be greateer than 11 digits");
		} 
		// look for way to search by all special characters
		// not arriving to this else if with certain 
		// regex [^0-9] or regex [^0-9] or [.)(^$*:+?@!-] for some reason
		else if (string.contains("@")||string.contains("!")||string.contains("#")||
				string.contains("$")||string.contains("@")||string.contains("*")||
				string.contains(":")){
			throw new IllegalArgumentException("Number cannot contain non numeric values");
		} else  {
			return string;
			
		}
}


	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		string = string.replaceAll("\n", "");
		String wordArray[]= {};
		
		if (string.contains(",")) {
			wordArray = string.split(",");			
		} else {
			wordArray = string.split(" ");			
		}

		Map<String, Integer> wordMap = new HashMap<String, Integer> ();
		for (String s:wordArray) {
			
			if(!wordMap.containsKey(s)) {
				wordMap.put(s, 1);
			} else {
				int count = wordMap.get(s);
				wordMap.put(s, count +1);
			}
		}
//		System.out.println(wordMap);
		return wordMap;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;
		
		public int indexOf(T t) {
			int left = 0;
			int right = sortedList.size() - 1;
			int index = sortedList.size() - 1;

			while (left <= right) {
				int middle = (left + right) / 2;
				if (t.equals(sortedList.get(middle))) {
					index = sortedList.indexOf(t);
					break;
				}
				if (sortedList.indexOf(t) < middle) {
					right = middle - 1;
				} else if (sortedList.indexOf(t) > middle) {
					left = middle + 1;
				}
			}
			return index;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}


	/**
	 * 8. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
        int n = String.valueOf(input).length(); 
        int temporary = input;
        int sum = 0; 
        while (temporary != 0) { 
            int r = temporary % 10; 
            sum += Math.pow(r,n); 
            temporary = temporary / 10; 
        } 
     
        if (sum == input) {
        	return true;
        } else {
        	return false;
        }
		
	}

	/**
	 * 9. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		if(string == "") {
			return false;
		}

		string = string.toUpperCase();
		Set<String> letters = new HashSet<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", 
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", 
				"R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
		string = string.replaceAll("\\s", "");
		String[] wordsArray = string.split("");

		for (int i = 0; i < wordsArray.length; i++) {
			if(letters.contains(wordsArray[i])) {
				letters.remove(wordsArray[i]);
			}
		}
		if (letters.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * 10. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			StringBuilder encryptedText = new StringBuilder();
			String[] inputString = string.split("");
			int shiftBy = 0;
			for (int i = 0; i < inputString.length; i++) {
				char inputLetter = inputString[i].charAt(0);
				if ((int) inputLetter >= 65 && (int) inputLetter <= 90) {
					shiftBy = inputLetter + key;
					if (shiftBy > 90) {
						shiftBy = shiftBy - 90;
						encryptedText.append((char) ('A' + shiftBy - 1));
					} else {
						encryptedText.append((char) shiftBy);
					}
				} else if ((int) inputLetter >= 97 && (int) inputLetter <= 122) {
					shiftBy = inputLetter + key;
					if (shiftBy > 122) {
						shiftBy = shiftBy - 122;
						encryptedText.append((char) ('a' + shiftBy - 1));
					} else {
						encryptedText.append((char) shiftBy);
					}
				} else {
					encryptedText.append(inputLetter);
				}
			}
			return encryptedText.toString();
		}

	}
	

	/**
	 * 11 & 12. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 11
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String ogtext = "";
			String cleanedString = "";
			String ciphertext = "";
			// remove non alphabet characters
			for(char c : string.toCharArray()) {
				if(Character.isLetterOrDigit(c)) {
					cleanedString += c;
        		}
    		}
			
    		cleanedString = cleanedString.toLowerCase();
    		for(char c : cleanedString.toCharArray()) {
    			if(Character.isLetter(c)) {
    				ogtext += (char) ('a' + ('z' - c));
        		} else {
        			ogtext += c;
        		}
    		}
    		
            for(int i = 0; i < ogtext.length(); i += 5) {
                if(i + 5 <= ogtext.length()) {
                	ciphertext += (ogtext.substring(i, i + 5) + " ");
                }
                else {
                	ciphertext += (ogtext.substring(i) + " ");
                }
            }
    		return ciphertext.trim();
		}

		/**
		 * Question 12
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
	        String ogtext = "";
	        String ciphertext = string;
	        ciphertext = ciphertext.toLowerCase().replaceAll("[\\s,.+]", "");
	        for(char c : ciphertext.toCharArray())
	        {
	            if(Character.isLetter(c))
	            {
	            	ogtext += (char) ('z' + ('a' - c));
	            }
	            else
	            {
	            	ogtext += c;
	            }
	        }
	        return ogtext;
		}
	}

	/**
	 * 13. (Optional) The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}


	/**
	 * 14. (Optional) Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * 
	 * given a time in temporal
	 * return same time plus one giga Second
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	
	/**
	 * 15. (Optional) Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		return 0;
	}

}
