class Solution {
    int n;
    private int[] getPSE(int[] heights){
        int[] pse = new int[n];
        // a monotonic (increasing) stack would be required
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < n;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                
                stack.pop();
            }
            // now smallest element's index is on top or stack is empty
            pse[i] = stack.isEmpty()?-1 : stack.peek();
            // push index i
            stack.push(i);
        }
        return pse;
    }
    private int[] getNSE(int[] heights){
        int[] nse = new int[n];
        // a monotonic (increasing) stack would be required
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1;i >= 0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){    
                stack.pop();
            }
            // now smallest element's index is on top or stack is empty
            nse[i] = stack.isEmpty()?n : stack.peek();
            // push index i
            stack.push(i);
        }
        return nse;
    }
    public int largestRectangleArea(int[] heights) {
        n = heights.length;
        int[] pse = getPSE(heights);
        int[] nse = getNSE(heights);
        int maxArea = 0;
        for(int i = 0;i < n;i++){
            maxArea = Math.max(maxArea, heights[i] * (nse[i]-pse[i]-1));
        }
        return maxArea;
    }
}

class Solution {
    int n;

    public int largestRectangleArea(int[] heights) {
        n = heights.length;
        int maxArea = 0;
        // monotonic stack: increasing order
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int currEleIdx = stack.pop();
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int nse = i;
                maxArea = Math.max(maxArea, heights[currEleIdx] * (nse - pse - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int currEleIdx = stack.pop();
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int nse = n;//hai hi nhi isliye akhiri (out-of-bound) idx
            maxArea = Math.max(maxArea, heights[currEleIdx] * (nse - pse - 1));
        }
        return maxArea;
    }
}
