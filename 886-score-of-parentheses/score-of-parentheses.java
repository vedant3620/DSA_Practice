class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<int[]> curr = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                open.push(i);
            else {
                int start = open.pop();
                int score = 0;
                if (start + 1 == i)
                    score = 1;
                else {
                    while (!curr.isEmpty() && curr.peek()[0] > start) {
                        score += curr.pop()[1];
                    }
                    score = 2 * score;
                }
                curr.push(new int[] { start, score });
            }
        }
        int ans = 0;
        while (!curr.isEmpty())
            ans += curr.pop()[1];
        return ans;
    }
}