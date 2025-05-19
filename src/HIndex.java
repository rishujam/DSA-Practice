import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] = 3;
        a[1] = 0;
        a[2] = 6;
        a[3] = 1;
        a[4] = 5;
        int[] a1 = new int[3];
        a1[0] = 1;
        a1[1] = 3;
        a1[2] = 1;
        int[] a2 = new int[1];
        a2[0] = 100;
        int out = hIndex(a2);
        System.out.print(out);
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int lastPossible = 0;
        for (int i = 1; i <= citations.length; i++) {
            int citation = citations[i - 1];
            int remaining = citations.length - i;
//            if(remaining)
//            if(citation - 1 <= remaining) {
//                lastPossible = citation;
//            } else {
//                break;
//            }
        }
        return lastPossible;
    }

}
