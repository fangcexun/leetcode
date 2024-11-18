package hot100.dynamicProgramming;

public class LC5 {
    public String longestPalindrome(String s) {
        int[] res = new int[2];
        int longest = 0;

        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        // init
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }

                if (dp[i][j] && (j - i > longest)) {
                    longest = j - i;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return s.substring(res[0], res[1]);
    }
}
