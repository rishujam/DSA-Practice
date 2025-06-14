import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("cats");
        input.add("dog");
        input.add("sand");
        input.add("and");
        input.add("cat");
        System.out.println(wordBreak("catsandog", input));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int maxLength = 0;
        for (String string : wordDict) {
            maxLength = Math.max(string.length(), maxLength);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[1] = wordDict.contains(String.valueOf(s.charAt(0)));
        for(int i = 0; i < s.length(); i++) {
            int j = i;
            while(j != 0) {
                String substring = s.substring(j, i + 1);
                if(wordDict.contains(substring)) {

                }
                j--;
            }
        }
        return true;
    }

}
