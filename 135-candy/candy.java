class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                curr++;
            } else
                curr = 1;
            ans[i] = Math.max(ans[i], curr);
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                curr++;
            } else
                curr = 1;
            ans[i] = Math.max(ans[i], curr);
        }
        return Arrays.stream(ans).sum();
    }
}
