public class ValidPalindrome {

    public static void main(String[] args) {

    }

    public static boolean isPalindrome(String s) {
        String processed = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = processed.length();
        while(i < j) {
            if(processed.charAt(i) != processed.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}
