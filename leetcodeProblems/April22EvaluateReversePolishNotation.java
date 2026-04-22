class Solution {
    public int evalRPN(String[] tokens) {
        int ans = -1;
        Set<String> set = new HashSet<>(Set.of("+","-","*","/"));
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(!set.contains(token)){
                // token is a number
                stack.push(Integer.parseInt(token));
            }
            else{
                // token is an operator
                int b = stack.pop();
                int a = stack.pop();
                int result = -1;
                if(token.equals("+")){
                    result = a + b;
                }
                else if (token.equals("-")){
                    result = a - b;
                }
                else if (token.equals("*")){
                    result = a * b;
                }
                else if (token.equals("/")){
                    result = a / b;
                }
                stack.push(result);
            }
        }
        ans = stack.pop();
        return ans;
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        // TC : O(n)
        // SC : O(n)
        Set<String> set = new HashSet<>(Set.of("+", "-", "*", "/"));
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!set.contains(token)) {
                // token is a number
                stack.push(Integer.parseInt(token));
            } else {
                // token is an operator
                int b = stack.pop();
                int a = stack.pop();
                int result = switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> throw new IllegalArgumentException("Invalid token");
                };
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
