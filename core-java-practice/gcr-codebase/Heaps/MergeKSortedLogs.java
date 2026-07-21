import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class LogEntry {

    int timestamp;
    String message;

    LogEntry(int timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    @Override
    public String toString() {
        return "(" + timestamp + ", " + message + ")";
    }
}

public class MergeKSortedLogs {

    static List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> sources.get(a[0]).get(a[1]).timestamp -
                        sources.get(b[0]).get(b[1]).timestamp);

        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0});
            }
        }

        List<LogEntry> merged = new ArrayList<>();

        while (!minHeap.isEmpty()) {

            int[] top = minHeap.poll();

            int sourceIndex = top[0];
            int elementIndex = top[1];

            merged.add(sources.get(sourceIndex).get(elementIndex));

            if (elementIndex + 1 < sources.get(sourceIndex).size()) {
                minHeap.offer(new int[]{sourceIndex, elementIndex + 1});
            }
        }

        return merged;
    }

    public static void main(String[] args) {

        List<List<LogEntry>> logs = new ArrayList<>();

        List<LogEntry> server1 = new ArrayList<>();
        server1.add(new LogEntry(1, "A"));
        server1.add(new LogEntry(4, "B"));
        server1.add(new LogEntry(7, "C"));

        List<LogEntry> server2 = new ArrayList<>();
        server2.add(new LogEntry(2, "D"));
        server2.add(new LogEntry(5, "E"));

        List<LogEntry> server3 = new ArrayList<>();
        server3.add(new LogEntry(3, "F"));
        server3.add(new LogEntry(6, "G"));

        logs.add(server1);
        logs.add(server2);
        logs.add(server3);

        List<LogEntry> merged = mergeKSortedLogs(logs);

        for (LogEntry log : merged) {
            System.out.println(log);
        }
    }
}
