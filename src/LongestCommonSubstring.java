import java.util.HashMap;

public class LongestCommonSubstring {

    public static void main(String[] args) {

    }

    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int i = 0;
        int j = 0;
        int count = 0;
        HashMap map = new HashMap<Character, Boolean>();
        while(i < s1.length() && j < s2.length()) {
            Character c1 = s1.charAt(i);
            Character c2 = s2.charAt(j);
            if(c1 == c2) {
                i++;
                j++;
                count++;
            } else {
                count = 0;
                if(s1.charAt(i + 1) == s2.charAt(j)) {

                } else if(s1.charAt(i) == s2.charAt(j + 1)) {

                }
            }
        }
        return  1;
    }

}
