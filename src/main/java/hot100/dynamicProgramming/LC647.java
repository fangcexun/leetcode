package hot100.dynamicProgramming;

import com.sun.deploy.util.StringUtils;

public class LC647 {
    public static int countSubstrings(String s) {
        int length = s.length();
        int res = 0;
        boolean[][] dp = new boolean[length][length];

        // 初始化数组
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            res++;
        }

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                // 只有两个字符的时候
                if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }

                if (dp[i][j]) {
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

}
