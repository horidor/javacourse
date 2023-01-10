import java.util.LinkedList;
import java.util.Hashtable;

import static java.lang.Character.isLetter;
import static java.lang.Character.toLowerCase;
import java.lang.Integer;

public class Main {

    public static void main(String[] args) {
        StringBuffer text = new StringBuffer("This is a word sentence! And i have, heh, a word. A word? This is blasphemy!");

        Hashtable<String, LinkedList<Integer>> similarwords = new Hashtable();

        boolean flag_newsentence = false, flag_word = false;
        int sentence_count = 1;
        StringBuffer some_word = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (isLetter(symbol)) {
                some_word.append(toLowerCase(symbol));
                flag_newsentence = false;
                flag_word = true;
            }

            if (!isLetter(symbol)) {
                if (flag_word) {
                    if (similarwords.containsKey(some_word.toString())) {
                        similarwords.get(some_word.toString()).add(sentence_count);
                    }
                    else {
                        LinkedList<Integer> temp = new LinkedList<>();
                        temp.add(sentence_count);
                        similarwords.put(some_word.toString(), temp);
                    }
                    some_word.delete(0, some_word.length());
                    flag_word = false;
                }

                if (symbol == '.' || symbol == '!' || symbol == '?')
                    if (!flag_newsentence) {
                        sentence_count += 1;
                        flag_newsentence = true;
                    }

            }
        }

        LinkedList<String> most_words = new LinkedList<>();
        int max_length = 0;

        for (String word: similarwords.keySet()) {
            int encounter_rate = similarwords.get(word).size();
            if (max_length < encounter_rate) {
                max_length = encounter_rate;
                most_words.clear();
                most_words.add(word);
            }
            else if (max_length == encounter_rate) {
                most_words.add(word);
            }
        }

        for (String same_word: most_words) {
            System.out.format("Sentences %s have similar word: %s\n", similarwords.get(same_word).toString(), same_word);
        }

    }
}