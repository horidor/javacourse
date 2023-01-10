import java.util.LinkedList;
import java.util.Hashtable;
import java.util.HashSet;

import static java.lang.Character.isLetter;
import static java.lang.Character.toLowerCase;
import java.lang.Integer;

public class Main {

    public static void main(String[] args) {
        StringBuffer text = new StringBuffer("""
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
        Ut mi quam, condimentum quis metus a, mattis tincidunt libero. 
        Ut tincidunt lorem at quam malesuada, non fringilla velit maximus. 
        Nullam eget sapien ornare, vehicula sapien vel, fringilla nisi. 
        Vivamus sodales iaculis nisi eget rutrum. Donec elementum pellentesque faucibus. 
        Vestibulum a erat vitae purus efficitur maximus. Ut ut sagittis nunc, nec sollicitudin est. 
        Donec tempor vehicula ex, non accumsan sem egestas at. """);

        Hashtable<String, HashSet<Integer>> similarwords = new Hashtable();

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
                        HashSet<Integer> temp = new HashSet<>();
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