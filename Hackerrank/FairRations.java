import java.util.*;

public class FairRations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] loaves = new int[n];
        for (int i = 0; i < n; i++) {
            loaves[i] = scanner.nextInt();
        }
        scanner.close();

        int loafCount = 0;

        for (int i = 0; i < n - 1; i++) {
            if (loaves[i] % 2 != 0) {
                // Give one loaf to current and next person
                loaves[i]++;
                loaves[i + 1]++;
                loafCount += 2;
            }
        }

        // Check if last person has even number of loaves
        if (loaves[n - 1] % 2 != 0) {
            System.out.println("NO");
        } else {
            System.out.println(loafCount);
        }
    }
}
