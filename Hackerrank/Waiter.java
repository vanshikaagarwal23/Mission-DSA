import java.util.*;

public class Waiter {

    // Method to generate first Q primes
    private static List<Integer> generatePrimes(int Q) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        while (primes.size() < Q) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }
        return primes;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void waiter(List<Integer> plates, int Q) {
        Stack<Integer> currentStack = new Stack<>();
        // Push plates in reverse order since input is from top to bottom
        for (int i = plates.size() - 1; i >= 0; i--) {
            currentStack.push(plates.get(i));
        }

        List<Integer> primes = generatePrimes(Q);

        for (int i = 0; i < Q; i++) {
            Stack<Integer> A = new Stack<>();
            Stack<Integer> B = new Stack<>();
            int prime = primes.get(i);

            while (!currentStack.isEmpty()) {
                int plate = currentStack.pop();
                if (plate % prime == 0) {
                    B.push(plate);
                } else {
                    A.push(plate);
                }
            }

            // Print B stack top to bottom
            while (!B.isEmpty()) {
                System.out.println(B.pop());
            }

            // Next iteration uses A stack
            currentStack = A;
        }

        // Print remaining plates in the last stack top to bottom
        while (!currentStack.isEmpty()) {
            System.out.println(currentStack.pop());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int Q = scanner.nextInt();
        List<Integer> plates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            plates.add(scanner.nextInt());
        }
        scanner.close();

        waiter(plates, Q);
    }
}
