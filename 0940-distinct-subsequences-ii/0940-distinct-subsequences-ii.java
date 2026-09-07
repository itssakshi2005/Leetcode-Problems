class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int n = s.length();

        long[] dp = new long[n + 1];
        dp[0] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 1; i <= n; i++) {
            int ch = s.charAt(i - 1) - 'a';

            dp[i] = (2 * dp[i - 1]) % mod;

            if (last[ch] != -1) {
                dp[i] = (dp[i] - dp[last[ch]] + mod) % mod;
            }

            last[ch] = i - 1;
        }

        return (int) ((dp[n] - 1 + mod) % mod);
    }
}