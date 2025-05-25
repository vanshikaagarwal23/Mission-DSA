
import java.util.*;

public class RunningMedian {
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Lower half
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Upper half

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int number = scanner.nextInt();
            addNumber(number);
            System.out.println(getMedian());
        }
        scanner.close();
    }

    private static void addNumber(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    private static double getMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
