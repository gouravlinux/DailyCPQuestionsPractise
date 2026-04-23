class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+' || ch == '-') {
                // previous num was made
                res += num * sign;
                num = 0;
                sign = (ch == '-') ? -1 : 1;
            } else if (ch == '(') {
                // push res made till now and sign in the stack
                stack.push(res);
                stack.push(sign);
                num = 0;
                res = 0;
                sign = 1;
            } else {
                // if ch == ')'
                res += num * sign;
                num = 0;
                sign = 1;
                res = res * stack.pop();
                res += stack.pop();
            }
        }
        res += num * sign;
        return res;
    }
}
