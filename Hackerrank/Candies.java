import java.util.*;

public class Candies {

    public static long candies(int n, int[] ratings) {
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        long totalCandies = 0;
        for (int c : candies) {
            totalCandies += c;
        }
        return totalCandies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ratings = new int[n];
        for (int i = 0; i < n; i++) {
            ratings[i] = sc.nextInt();
        }
        System.out.println(candies(n, ratings));
    }
}
