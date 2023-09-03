import java.util.PriorityQueue;

public class KthSmallest {

    public static void main(String[] args) {
        int[] arr = {20, 10, 60, 30, 50, 40};
        int k = 3;
        System.out.println(answer(arr, k));
    }

    private static int answer(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // By default it makes min heap
        for(int i=0; i<k; i++) {
            pq.add(arr[i]);
        }
        for(int i=0; i<arr.length;i++) {
            if(pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
}
