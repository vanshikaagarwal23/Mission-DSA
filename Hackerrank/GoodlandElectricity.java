import java.util.*;

public class GoodlandElectricity {

    public static int goodlandElectricity(int[] cities, int k) {
        int n = cities.length;
        int count = 0;
        int i = 0;

        while (i < n) {
            // Find the rightmost power plant in range [i - (k - 1), i + (k - 1)]
            int left = Math.max(i - (k - 1), 0);
            int right = Math.min(i + (k - 1), n - 1);

            int powerPlantPos = -1;
            // Search from right to left in the range to find the rightmost power plant
            for (int j = right; j >= left; j--) {
                if (cities[j] == 1) {
                    powerPlantPos = j;
                    break;
                }
            }

            if (powerPlantPos == -1) {
                // No power plant can cover city i
                return -1;
            }

            count++;
            // Move i to the city just after powerPlantPos + (k - 1)
            i = powerPlantPos + k;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] cities = new int[n];
        for (int i = 0; i < n; i++) {
            cities[i] = sc.nextInt();
        }

        System.out.println(goodlandElectricity(cities, k));
    }
}
