import java.util.*;

public class GreedyFlorist {

    public static int getMinimumCost(int k, List<Integer> c) {
        Collections.sort(c, Collections.reverseOrder());

        int totalCost = 0;
        for (int i = 0; i < c.size(); i++) {
            int multiplier = (i / k) + 1;
            totalCost += multiplier * c.get(i);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> costs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            costs.add(scanner.nextInt());
        }
        scanner.close();

        System.out.println(getMinimumCost(k, costs));
    }
}
