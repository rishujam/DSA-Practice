import java.util.HashMap;

public class LongestSubstringWithoutRepeatChar {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        while(j < s.length()) {
            Character c = s.charAt(j);
            int charExist = hs.getOrDefault(c, -1);
            if(charExist == -1) {
                hs.put(c, j);
                maxLength = Math.max(maxLength, (j - i) + 1);
            } else {
                while(i != (charExist + 1)) {
                    hs.remove(s.charAt(i));
                    i++;
                }
                hs.put(c, j);
            }
            j++;
        }
        return maxLength;
    }

}
