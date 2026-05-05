// Approach 1
class Solution {
    int m;
    int n;

    private boolean isValid(int row, int col) {
        if (row >= 0 && row < m && col >= 0 && col < n)
            return true;
        return false;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        // TC : O(m*n)
        // SC : O(m*n)
        List<Integer> res = new ArrayList<>();
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };//RDLU
        int row = 0;
        int col = 0;
        int dirIdx = 0;
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[row][col]);
            vis[row][col] = true;
            int newRow = row + dir[dirIdx][0];
            int newCol = col + dir[dirIdx][1];
            if(isValid(newRow, newCol) && !vis[newRow][newCol]){
                row = newRow;
                col = newCol;
            }else{
                dirIdx = (dirIdx + 1) % 4;//not valid or visited: change direction
                row += dir[dirIdx][0];
                col += dir[dirIdx][1];
            }
        }
        return res;
    }
}

// Approach-2
class Solution {
    int m;
    int n;

    public List<Integer> spiralOrder(int[][] matrix) {
        // TC : O(m*n)
        // SC : O(1)
        List<Integer> res = new ArrayList<>();
        m = matrix.length;
        n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {// go left -> right
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) { // go top to bottom
                res.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                // check if a row exists to traverse
                for (int i = right; i >= left; i--) { // go to right to left
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // check if a col. exists to traverse
                for (int i = bottom; i >= top; i--) {//go from bottom to top
                    res.add(matrix[i][left]);
                }
                left++;
            }

        }
        return res;
    }
}
// approach 3: (similar to approach 2)
class Solution {
    int m;
    int n;

    public List<Integer> spiralOrder(int[][] matrix) {
        // TC : O(m*n)
        // SC : O(1)
        List<Integer> res = new ArrayList<>();
        m = matrix.length;
        n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        int dir = 0;
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                // left to right(col)
                // const: top(row)
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;//that top row should not be visited again
            } else if (dir == 1) {
                // top to bottom(row varies)
                // const: right(col)
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;//that column (right) should not be visited again 
            } else if (dir == 2) {
                // right to left (col. varies)
                // const: bottom(row)
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;//that row(bottom) should not be visited again
            } else if (dir == 3) {
                // bottom to top (row varies)
                // const: left(col)
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;//that col(left) should not be visited again
            }
            dir = (dir + 1) % 4;
        }
        return res;
    }
}
