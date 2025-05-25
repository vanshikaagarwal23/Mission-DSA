import java.util.Scanner;

public class SamAndSubstrings {
    private static final int MOD = 1000000007;

    public static int substrings(String n) {
        int length = n.length();
        long totalSum = 0;
        long dp = n.charAt(0) - '0'; // Initialize dp with the first digit

        totalSum += dp; // Add the first digit's contribution

        for (int i = 1; i < length; i++) {
            dp = (dp * 10 + (i + 1) * (n.charAt(i) - '0')) % MOD;
            totalSum = (totalSum + dp) % MOD;
        }

        return (int) totalSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        System.out.println(substrings(n));
        scanner.close();
    }
}
