class Solution {
    List<String> res;

    private void solve(int open, int n, String string) {
        int close = string.length() - open;
        // base case
        if (string.length() == 2 * n) {
            res.add(new String(string));
            return;
        }
        if(open < n){
            // include '(' and explore: only if open paranthesis is less than n
            solve(open + 1, n, string + "(");
        }
        if(close < open){
            // exclude '(' and explore: close should not be greater than open
            solve(open, n, string + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        solve(0, n, "");
        return res;
    }
}
class Solution {
    List<String> res;

    private boolean isValid(String str) {
        int balanceFactor = 0;
        for (char ch : str.toCharArray()) {
            balanceFactor = (ch == '(') ? balanceFactor + 1 : balanceFactor - 1;
            if (balanceFactor < 0) {
                // invalid: more no of ')' than '('
                return false;
            }
        }
        return balanceFactor == 0;
    }

    private void solve(int n, String curr) {
        if (curr.length() == 2 * n) {
            if (isValid(curr)) {
                res.add(curr);
            }
            return;
        }
        // 2 choices->either include '(' or ')'
        solve(n, curr + "(");
        solve(n, curr + ")");
    }

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        solve(n, "");
        return res;
    }
}
