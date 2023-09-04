import java.util.ArrayList;
import java.util.Arrays;

public class AlternatePositiveNegative {

    public static void main(String[] args) {
        int[] arr = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        int n = 10;
        rearrange(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int[] arr, int n) {
        ArrayList<Integer> positiveNo = new ArrayList<Integer>();
        ArrayList<Integer> negativesNo = new ArrayList<Integer>();
        for(int value : arr) {
            if(value < 0) {
                negativesNo.add(value);
            } else {
                positiveNo.add(value);
            }
        }
        if(positiveNo.size() > negativesNo.size()) {
            for(int k = 0; k < negativesNo.size(); k++) {
                arr[2 * k] = positiveNo.get(k);
                arr[2 * k + 1] = negativesNo.get(k);
            }
            int index = negativesNo.size() * 2;
            for(int k = negativesNo.size(); k < positiveNo.size(); k++) {
                arr[index] = positiveNo.get(k);
                index++;
            }
        } else {
            for(int k = 0; k < positiveNo.size(); k++) {
                arr[2 * k] = positiveNo.get(k);
                arr[2 * k + 1] = negativesNo.get(k);
            }
            int index = positiveNo.size() * 2;
            for(int k = positiveNo.size(); k < negativesNo.size(); k++) {
                arr[index] = negativesNo.get(k);
                index++;
            }
        }
    }

    //Took most time
    public static void rearrange2(int[] arr, int n) {
        int[] a = new int[arr.length];
        int negatives = 0;
        int positives = 0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i] < 0) {
                negatives++;
            } else {
                positives++;
            }
            a[i] = Integer.MAX_VALUE;
        }
        if(positives < negatives) {
            int j = 0;
            for(int i=0;i<arr.length;i++) {
                if(arr[i] >= 0) {
                    a[j] = arr[i];
                    arr[i] = Integer.MAX_VALUE;
                    j+=2;
                }
            }
            int k = 1;
            if(positives == 0) k = 0;
            for (int value : arr) {
                if (value < 0) {
                    a[k] = value;
                    if (k + 1 < a.length && a[k + 1] != Integer.MAX_VALUE && a[k + 1] > -1) {
                        k += 2;
                    } else {
                        k++;
                    }
                }
            }
        } else {
            int k = 1;
            if(negatives == 0) k = 0;
            for(int i=0;i<arr.length;i++) {
                if(arr[i] < 0) {
                    a[k] = arr[i];
                    arr[i] = Integer.MIN_VALUE;
                    k+=2;
                }
            }
            int j = 0;
            for (int value : arr) {
                if (value >= 0) {
                    a[j] = value;
                    if(j + 1 < a.length && a[j + 1] != Integer.MAX_VALUE && a[j + 1] < 0) {
                        j += 2;
                    } else {
                        j++;
                    }
                }
            }
        }
        System.arraycopy(a, 0, arr, 0, arr.length);
    }

    //Took lesser time then rearrange
    public static void rearrange3(int[] arr, int n) {
        int positives = 0;
        int negatives = 0;
        for (int j : arr) {
            if (j < 0) {
                negatives++;
            } else {
                positives++;
            }
        }
        int i=0;
        int[] positiveNo = new int[positives];
        int j=0;
        int[] negativesNo = new int[negatives];
        for(int value : arr) {
            if(value < 0) {
                negativesNo[i] = value;
                i++;
            } else {
                positiveNo[j] = value;
                j++;
            }
        }
        int l = 0;
        int m = 0;
        int turn = 1;
        for(int k=0;k<arr.length;k++) {
            int value = 0;
            if((l < positiveNo.length && turn == 1) || m >= negativesNo.length) {
                value = positiveNo[l];
                l++;
                turn = 0;
            } else {
                value = negativesNo[m];
                m++;
                turn = 1;
            }
            arr[k] = value;
        }
    }

}
