class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                if (!st.isEmpty()) {
                    int l = st.pop();
                    int cnt = 0;
                    cnt += i - l + 1;
                    if (l > 0)
                        cnt += dp[l - 1];
                    ans = Math.max(ans, cnt);
                    dp[i] = cnt;
                }
            }
        }
        return ans;
    }
}