import java.util.*;

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] remainderCount = new int[k];
        
        // Count the frequency of each remainder
        for (int num : s) {
            remainderCount[num % k]++;
        }

        int count = 0;

        // Include at most one element with remainder 0
        count += Math.min(remainderCount[0], 1);

        // Loop from 1 to k/2 and choose the maximum from complementary remainders
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
                count += Math.max(remainderCount[i], remainderCount[k - i]);
            } else {
                // If k is even, include at most one element with remainder k/2
                count += 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // Size of the array
        int k = scanner.nextInt();  // Divisor

        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.add(scanner.nextInt());
        }

        int result = nonDivisibleSubset(k, s);
        System.out.println(result);
        scanner.close();
    }
}
