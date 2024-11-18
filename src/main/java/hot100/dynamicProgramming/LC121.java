package hot100.dynamicProgramming;

public class LC121 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int res = 0;

        int prevMinStock = prices[0];

        for (int i = 1; i < length; i++) {
            res = Math.max(res, prices[i] - prevMinStock);
            prevMinStock = Math.min(prevMinStock, prices[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        LC121 lc121 = new LC121();
        System.out.println(lc121.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
