import java.util.*;

public class ACMICPCTeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of attendees
        int m = scanner.nextInt(); // Number of topics
        String[] topics = new String[n];
        for (int i = 0; i < n; i++) {
            topics[i] = scanner.next();
        }
        scanner.close();

        int maxTopics = 0;
        int teamCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int knownTopics = countKnownTopics(topics[i], topics[j]);
                if (knownTopics > maxTopics) {
                    maxTopics = knownTopics;
                    teamCount = 1;
                } else if (knownTopics == maxTopics) {
                    teamCount++;
                }
            }
        }

        System.out.println(maxTopics);
        System.out.println(teamCount);
    }

    // Count total known topics by two attendees
    private static int countKnownTopics(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1' || b.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
