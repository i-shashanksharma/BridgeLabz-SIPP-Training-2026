import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKLargestCustomers {

    static List<Integer> topKLargest(int[] transactions, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int amount : transactions) {

            if (minHeap.size() < k) {
                minHeap.offer(amount);
            } else if (amount > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(amount);
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {

        int[] transactions = {500, 1200, 900, 3000, 700, 2500};

        System.out.println(topKLargest(transactions, 3));
    }
}
