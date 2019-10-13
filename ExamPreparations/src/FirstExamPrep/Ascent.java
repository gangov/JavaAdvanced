package FirstExamPrep;

import java.util.ArrayList;
import java.util.Scanner;

/*
Doctor T. likes to communicate with encrypted messages with his lackeys. But the lackeys are relatively stupid, so you
need to help them understand the Doctor’s messages, by decrypting his encrypted data.
You have been tasked to decrypt several messages. You will be given the messages as several input lines. You must read
and decrypt messages until you receive the command “Ascend”.
When you receive a given message you must decrypt it and print it immediately. The messages have several encoded strings
in them, which you must find. The encoded string consist of – a single comma (,) or an underscore (_), a sequence of
English Alphabet letters, and a digit at the end of it. Examples: “,asd9”, “_z8”, “,xzc9“.
The decoding of a message is done by adding or subtracting the digit in it, from the ASCII code of every character in
the sequence of letters. If the front character is a comma (,) you add the digit to the ASCII codes of the characters,
if it’s an underscore (_), you subtract it.
When you find an encoded string, you must “memorize” it. In other words, you find the encoded string “_qlfh5”,  and
decode it – it results in “lgac”. If you find the same encoded string (_qlfh5), again, in a message afterwards, you must
replace it with the decoded value corresponding to it (lgac), BEFORE beginning to decode the message itself.  Example:
“abcdefg,_qlfh52hijklmn” = “abcdefg,lgac2hijklmn” = “abcdefgnicehijklm”.
You know that “_qlfh5” is “lgac”, so the message would turn into “abcedfg,lgac2hijklmn” which after decoding turns into
“abcdefgnicehijklm”.

Input
The input comes in the form of input lines containing the encoded messages.
When you receive the command “Ascend” the input sequence ends.

Output
You must print every message, immediately after you’ve decoded it.

Constrains
The input lines may consist of any ASCII character.
Upon replacing with memorized patterns, you must do it in the order in which you’ve found the patterns.
 */
public class Ascent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("Ascend")) {
            String[] line = input.split(" ");
            ArrayList<String> words = new ArrayList<>();
            for (String string : line) {
                boolean hasStart = true;
                boolean hasEnd = true;
                while (string.contains(",") || string.contains("_")) {
                    int start = -1;
                    int end = -1;
                    for (int i = 0; i < string.length(); i++) {
                        if (string.charAt(i) == ',' || string.charAt(i) == '_') {
                            start = i;
                            hasStart = false;
                        } else if (Character.isDigit(string.charAt(i))) {
                            end = i;
                            hasEnd = false;
                        }
                        if (start != -1 && end != -1) {
                            String toDecrypt = string.substring(start, end + 1);
                            String leftOverRight = string.substring(end + 1);
                            String leftOverLeft = string.substring(0, start);
                            string = leftOverLeft + magic(toDecrypt) + leftOverRight;

                            start = -1;
                            end = -1;
                        }
                    }
                    if (!string.contains(",") && !string.contains("_")) {
                        words.add(string);
                    }
                }
                if (hasStart && hasEnd) {
                    words.add(string);
                }
            }

            for (String word : words) {
                System.out.print(word + " ");
            }
            System.out.println();
            input = scanner.nextLine();
        }
    }

    private static StringBuilder magic(String word) {
        int code = Integer.parseInt(String.valueOf(word.charAt(word.length() - 1)));
        word = word.substring(0, word.length() - 1);
        char[] newWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(0) == ',') {
                newWord[i] = (char) (word.charAt(i) + code);
            } else {
                newWord[i] = (char) (word.charAt(i) - code);
            }
        }

        StringBuilder toReturn = new StringBuilder();

        for (int i = 1; i < newWord.length; i++) {
            toReturn.append(newWord[i]);
        }

        return toReturn;
    }
}
