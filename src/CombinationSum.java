import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        int[] in = {2};
        HashMap<ArrayList<Integer>, Boolean> out = new HashMap<>();
        ArrayList<Integer> l = new ArrayList<>();
        HashMap<List<Integer>, Boolean> dp = new HashMap<>();
        ans(in, 1, l, out);
        List<List<Integer>> ans = new ArrayList<List<Integer>>(out.keySet());
        System.out.println(ans);
    }

    static void ans(
            int[] candidates,
            int sum,
            ArrayList<Integer> temp,
            HashMap<ArrayList<Integer>, Boolean> out
    ) {
        if(sum == 0) {
            temp.sort(Comparator.naturalOrder());
            out.put(temp, true);
            return;
        }

        if(sum < 0) {
            return;
        }

        if(candidates.length > 1) {
            int[] leftCandidates = Arrays.copyOfRange(candidates,1, candidates.length);
            if(leftCandidates.length > 0) {
                ans(leftCandidates, sum, temp, out);
            }
        }

        if(candidates.length > 0) {
            int rightSum = sum - candidates[0];
            ArrayList<Integer> rightTemp = new ArrayList<>(temp);
            rightTemp.add(candidates[0]);
            ans(candidates, rightSum, rightTemp, out);
        }
    }
}
