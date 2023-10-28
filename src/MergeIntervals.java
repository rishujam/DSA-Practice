import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {
    //Problem: https://leetcode.com/problems/merge-intervals/

    public static void main(String[] args) {
        int[][] in = {{1,4},{4,5}};
        int[][] out = ans(in);
        for (int[] a : out) {
            System.out.println("[" + a[0] + "," + a[1] + "}");
        }
    }

    private static int[][] ans(int[][] intervals) {
        Arrays.sort(intervals, new SortingComparator<>());

        Stack<int[]> st = new Stack<>();
        st.push(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] a = st.peek();
            if(checkIfCanBeMerged(a, intervals[i])) {
                merge(intervals[i], st);
            } else {
                st.push(intervals[i]);
            }
        }

        int[][] output = new int[st.size()][2];
        int i = st.size() - 1;
        while(!st.isEmpty()) {
            output[i] = st.pop();
            i--;
        }
        return output;
    }

    static void merge(int[] toMerge, Stack<int[]> stack) {
        int[] curr = stack.pop();
        int start = Math.min(curr[0], toMerge[0]);
        int end = Math.max(curr[1], toMerge[1]);
        curr[0] = start;
        curr[1] = end;
        stack.push(curr);
    }

    static boolean checkIfCanBeMerged(int[] a, int[] b) {
        return a[1] - b[0] > -1;
    }

    public static class SortingComparator<Array> implements Comparator<Array> {
        @Override
        public int compare(Array o1, Array o2) {
            return (int) java.lang.reflect.Array.get(o1, 0) - (int) java.lang.reflect.Array.get(o2, 0);
        }
    }
}
