import java.util.Scanner;

public class SansaAndXOR {
    static int sansaXor(int[] arr) {
        int len = arr.length;
        if (len % 2 == 0) {
            return 0; // Case 1: Even length
        }
        int result = 0;
        for (int i = 0; i < len; i += 2) {
            result ^= arr[i]; // XOR elements at even indices
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = in.nextInt(); // Size of the array
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(sansaXor(arr));
        }
        in.close();
    }
}
