class Solution {
    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // isPal[i][j] = s[i...j] is palindrome
        boolean[][] isPal = new boolean[n][n];

        // Length 1
        for (int i = 0; i < n; i++) {
            isPal[i][i] = true;
        }

        // Length 2 to n
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {

                    if (len == 2) {
                        isPal[i][j] = true;
                    } else {
                        isPal[i][j] = isPal[i + 1][j - 1];
                    }
                }
            }
        }

        // dp[i] = maximum palindromes in first i characters
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Don't take s[i-1]
            dp[i] = dp[i - 1];

            // Try every possible starting point
            for (int start = 0; start <= i - k; start++) {

                if (isPal[start][i - 1]) {

                    dp[i] = Math.max(
                        dp[i],
                        dp[start] + 1
                    );
                }
            }
        }

        return dp[n];
    }
}