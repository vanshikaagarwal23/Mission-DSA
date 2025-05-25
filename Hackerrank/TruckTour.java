import java.util.*;

public class TruckTour {

    public static int truckTour(List<int[]> pumps) {
        int start = 0;
        int surplus = 0;
        int deficit = 0;

        for (int i = 0; i < pumps.size(); i++) {
            int petrol = pumps.get(i)[0];
            int distance = pumps.get(i)[1];
            surplus += petrol - distance;

            // If surplus falls below zero, cannot start from previous start
            if (surplus < 0) {
                deficit += surplus;
                surplus = 0;
                start = i + 1;
            }
        }

        if (surplus + deficit >= 0) {
            return start;
        } else {
            return -1; // No valid start
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> pumps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int petrol = scanner.nextInt();
            int distance = scanner.nextInt();
            pumps.add(new int[] {petrol, distance});
        }
        scanner.close();

        System.out.println(truckTour(pumps));
    }
}
