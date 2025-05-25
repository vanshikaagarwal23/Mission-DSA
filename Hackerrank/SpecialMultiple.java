import java.util.*;

public class SpecialMultiple {

    public static String findSpecialMultiple(int N) {
        if (N == 1) return "9";

        Queue<String> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add("9");
        visited.add(9 % N);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int remainder = Integer.parseInt(current) % N;

            if (remainder == 0) {
                return current;
            }

            String next1 = current + "0";
            String next2 = current + "9";

            int remainder1 = (remainder * 10) % N;
            int remainder2 = (remainder * 10 + 9) % N;

            if (!visited.contains(remainder1)) {
                queue.add(next1);
                visited.add(remainder1);
            }

            if (!visited.contains(remainder2)) {
                queue.add(next2);
                visited.add(remainder2);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int N = scanner.nextInt();
            System.out.println(findSpecialMultiple(N));
        }
        scanner.close();
    }
}
