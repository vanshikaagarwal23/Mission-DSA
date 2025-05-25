import java.util.*;

public class LuckBalance {

    public static int luckBalance(int k, int[][] contests) {
        List<Integer> importantContests = new ArrayList<>();
        int luckBalance = 0;

        for (int[] contest : contests) {
            int luck = contest[0];
            int importance = contest[1];

            if (importance == 1) {
                importantContests.add(luck);
            } else {
                // Lose all unimportant contests
                luckBalance += luck;
            }
        }

        // Sort important contests in descending order by luck value
        Collections.sort(importantContests, Collections.reverseOrder());

        // Lose the 'k' most luck valuable important contests
        for (int i = 0; i < importantContests.size(); i++) {
            if (i < k) {
                luckBalance += importantContests.get(i);
            } else {
                // Win the rest important contests, subtract their luck
                luckBalance -= importantContests.get(i);
            }
        }

        return luckBalance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] contests = new int[n][2];
        for (int i = 0; i < n; i++) {
            contests[i][0] = sc.nextInt(); // luck
            contests[i][1] = sc.nextInt(); // importance
        }

        System.out.println(luckBalance(k, contests));
    }
}
