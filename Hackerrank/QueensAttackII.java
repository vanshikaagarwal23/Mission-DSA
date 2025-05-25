import java.util.*;

public class QueensAttackII {

    public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        // Initialize the max distance queen can move in each of the 8 directions
        int up = n - r_q;
        int down = r_q - 1;
        int right = n - c_q;
        int left = c_q - 1;

        int upRight = Math.min(up, right);
        int upLeft = Math.min(up, left);
        int downRight = Math.min(down, right);
        int downLeft = Math.min(down, left);

        // For each obstacle, check if it blocks any direction and update the distance
        for (int[] obstacle : obstacles) {
            int r_o = obstacle[0];
            int c_o = obstacle[1];

            // Same column
            if (c_o == c_q) {
                if (r_o > r_q) {
                    // obstacle is upwards
                    int dist = r_o - r_q - 1;
                    if (dist < up) up = dist;
                } else {
                    // obstacle is downwards
                    int dist = r_q - r_o - 1;
                    if (dist < down) down = dist;
                }
            }
            // Same row
            else if (r_o == r_q) {
                if (c_o > c_q) {
                    // obstacle to the right
                    int dist = c_o - c_q - 1;
                    if (dist < right) right = dist;
                } else {
                    // obstacle to the left
                    int dist = c_q - c_o - 1;
                    if (dist < left) left = dist;
                }
            }
            // Diagonal check
            else if (Math.abs(r_o - r_q) == Math.abs(c_o - c_q)) {
                int dist = Math.abs(r_o - r_q) - 1;
                if (r_o > r_q && c_o > c_q) {
                    // upRight
                    if (dist < upRight) upRight = dist;
                } else if (r_o > r_q && c_o < c_q) {
                    // upLeft
                    if (dist < upLeft) upLeft = dist;
                } else if (r_o < r_q && c_o > c_q) {
                    // downRight
                    if (dist < downRight) downRight = dist;
                } else if (r_o < r_q && c_o < c_q) {
                    // downLeft
                    if (dist < downLeft) downLeft = dist;
                }
            }
        }

        // Sum all possible moves
        return up + down + right + left + upRight + upLeft + downRight + downLeft;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       // board size
        int k = sc.nextInt();       // number of obstacles
        int r_q = sc.nextInt();     // queen row
        int c_q = sc.nextInt();     // queen column

        int[][] obstacles = new int[k][2];
        for (int i = 0; i < k; i++) {
            obstacles[i][0] = sc.nextInt();
            obstacles[i][1] = sc.nextInt();
        }

        System.out.println(queensAttack(n, k, r_q, c_q, obstacles));
    }
}
