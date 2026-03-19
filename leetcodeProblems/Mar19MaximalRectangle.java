class Solution {
    int m;
    int n;

    private int findMaxAreaInHistogram(int[] height) {
        // finding max area of rectangle in histogram using stack
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();// stores indices
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int currIdx = stack.pop();
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int nse = i;
                maxArea = Math.max(maxArea, height[currIdx] * (nse - pse - 1));//height*width
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int currIdx = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, height[currIdx] * (nse - pse - 1));//height*width
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[] height = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;// neeche waale ki height 0 hogi to upar tak ke 0 hi hogi
                } else {
                    height[j] += (matrix[i][j] == '1') ? 1 : 0;
                }
            }
            maxArea = Math.max(maxArea, findMaxAreaInHistogram(height));
        }
        return maxArea;
    }
}
