import java.util.*;

public class HighestValuePalindrome {

    public static String highestValuePalindrome(String s, int n, int k) {
        char[] chars = s.toCharArray();
        boolean[] changed = new boolean[n];  // to keep track of changed positions
        int left = 0, right = n - 1;

        // First pass: make the string palindrome with minimum changes
        while (left < right) {
            if (chars[left] != chars[right]) {
                char maxChar = (char) Math.max(chars[left], chars[right]);
                chars[left] = maxChar;
                chars[right] = maxChar;
                changed[left] = true;
                k--;
            }
            left++;
            right--;
        }

        if (k < 0) return "-1";  // Not possible to make palindrome within k changes

        left = 0;
        right = n - 1;

        // Second pass: maximize palindrome value
        while (left <= right && k > 0) {
            if (left == right) {
                // Middle element in an odd length string
                if (chars[left] != '9' && k > 0) {
                    chars[left] = '9';
                    k--;
                }
            } else {
                if (chars[left] != '9') {
                    // If either side was changed before, only 1 more change needed
                    if (changed[left] || changed[right]) {
                        if (k >= 1) {
                            chars[left] = '9';
                            chars[right] = '9';
                            k--;
                        }
                    } else {
                        // Both sides were same and not changed before, need 2 changes
                        if (k >= 2) {
                            chars[left] = '9';
                            chars[right] = '9';
                            k -= 2;
                        }
                    }
                }
            }
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        System.out.println(highestValuePalindrome(s, n, k));
    }
}
