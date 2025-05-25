
   import java.util.Scanner;
   public class consecutivesubsequence {
 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();  // Number of test cases

        while (T-- > 0) {
            int n = scanner.nextInt();  // Size of the array
            int k = scanner.nextInt();  // Divisor

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Array to store frequency of remainders when prefix sums are divided by k
            long[] remainderFreq = new long[k];
            remainderFreq[0] = 1;  // To account for subarrays that themselves are divisible by k

            long prefixSum = 0;
            long count = 0;

            for (int i = 0; i < n; i++) {
                prefixSum += arr[i];
                int remainder = (int) ((prefixSum % k + k) % k);  // Ensure non-negative remainder
                count += remainderFreq[remainder];
                remainderFreq[remainder]++;
            }

            System.out.println(count);
        }

        scanner.close();
    }
}


