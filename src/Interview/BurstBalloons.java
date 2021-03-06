package Interview;

/**
 * Created by yongyangyu on 11/29/15.
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number
 * on it represented by array nums. You are asked to burst all the balloons. If the you
 * burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * Example:
 *
 * Given [3, 1, 5, 8]
 *
 * Return 167
 *
 * nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = 1;
        int[] arr = new int[nums.length+2];
        for (int x: nums) if (x > 0) arr[n++] = x; // burst all the zero balloons
        arr[0] = arr[n++] = 1;
        int[][] memo = new int[n][n];
        return burst(memo, arr, 0, n-1);
    }

    private int burst(int[][] memo, int[] arr, int left, int right) {
        if (memo[left][right] != 0) return memo[left][right];
        int res = 0;
        for (int i = left+1; i < right; i ++) {
            res = Math.max(res, arr[left] * arr[i] * arr[right] +
                    burst(memo, arr, left, i) + burst(memo, arr, i, right));
        }
        memo[left][right] = res;
        return res;
    }

    public int maxCoins2(int[] nums) {
        int[] arr = new int[nums.length+2];
        int n = 1;
        for (int x: nums) if (x > 0) arr[n++] = x; // burst zero balloons
        arr[0] = arr[n++] = 1;
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k ++) {
            for (int left = 0; left < n - k; left ++) {
                int right = left + k;
                for (int i = left+1; i < right; i ++) {
                    dp[left][right] = Math.max(dp[left][right],
                            arr[left] * arr[i] * arr[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        BurstBalloons bb = new BurstBalloons();
        System.out.println(bb.maxCoins(nums));
    }
}
