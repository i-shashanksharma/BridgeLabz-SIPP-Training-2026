import java.util.PriorityQueue;

public class KthLargestScore {

    static int findKthLargest(int[] scores, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int score : scores) {

            if (minHeap.size() < k) {
                minHeap.offer(score);
            } else if (score > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(score);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] scores = {88, 95, 72, 99, 81, 90};

        int k = 3;

        System.out.println("Kth Largest = " + findKthLargest(scores, k));
    }
}
