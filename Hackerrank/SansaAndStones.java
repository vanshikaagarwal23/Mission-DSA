import java.util.*;

public class SansaAndStones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            if (n % 2 == 0) {
                System.out.println(0);
            } else {
                int xor = 0;
                for (int i = 0; i < n; i += 2) {
                    xor ^= arr[i];
                }
                System.out.println(xor);
            }
        }
        scanner.close();
    }
}
