public class ReverseWordsInString {

    public static void main(String[] args) {
        String in = "a good   example";
        System.out.println(reverseWords(in));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        String out = "";
        for(int i = words.length - 1; i >= 0; i--) {
            if(words[i].isEmpty()) continue;
            out += words[i];
            if(i != 0) {
                out += " ";
            }
        }
        return out;
    }
}
