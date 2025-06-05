import kotlin.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcateAllWords {

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[4];
        words[0] = "word";
        words[1] = "good";
        words[2] = "best";
        words[3] = "word";
        List<Integer> out = findSubstring(s, words);
        for(int i = 0; i< out.size(); i++) {
            System.out.println(out.get(i) + ", ");
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        return l;
    }

}
