class Solution {
    public long maxAlternatingSum(int[] nums) {
        nums = Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> Integer.compare(Math.abs(a), Math.abs(b)))
                .mapToInt(Integer::intValue)
                .toArray();
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            ans -= (nums[i] * nums[i]);
        }
        for (int i = n / 2; i < n; i++) {
            ans += (nums[i] * nums[i]);
        }
        return ans;
    }
}