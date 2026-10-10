class Solution {
    TreeSet<String> ans = new TreeSet<>();

    private boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                cnt++;
            else if (s.charAt(i) == ')'){
                if (cnt == 0)
                    return false;
                cnt--;
            }
        }
        return cnt == 0;
    }

    private void rec(String s, int i, String curr) {
        if (i == s.length()) {
            if (isValid(curr)) {
                if (ans.size() > 0) {
                    if (ans.first().length() < curr.length())
                        ans = new TreeSet<>();
                    else if (ans.first().length() == curr.length()) {
                        ans.add(curr);
                    }
                } else {
                    ans.add(curr);

                }
            }
        } else {
            if (s.charAt(i) == '(') {
                rec(s, i + 1, curr + '(');
                rec(s, i + 1, curr);
            } else if (s.charAt(i) == ')') {
                rec(s, i + 1, curr + ')');
                rec(s, i + 1, curr);
            } else {
                rec(s, i + 1, curr + s.charAt(i));
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        rec(s, 0, "");
        return new ArrayList<>(ans);
    }
}