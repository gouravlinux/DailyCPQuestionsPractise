class Solution {
    boolean[][] visited;
    int m;
    int n;
    int wordLen;

    private boolean isValid(int row, int col) {
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return false;
        }
        return true;
    }

    private boolean solve(int row, int col, char[][] board, String word, int wIdx) {
        boolean ans = false;
        if (wIdx == wordLen) {
            // word found!
            return true;
        }
        if (!isValid(row, col)) {
            return false;//invalid cell
        }
        if (visited[row][col]) {
            return false;//already visited
        }
        if (board[row][col] != word.charAt(wIdx)) {
            return false;// not matching
        }
        // else same
        visited[row][col] = true;//mark visited
        // go to left
        if(solve(row, col - 1, board, word, wIdx + 1)){
            ans = true;
        }
        // go to top
        if(solve(row - 1, col, board, word, wIdx + 1)){
            ans = true;
        }
        // go to right
        if(solve(row, col + 1, board, word, wIdx + 1)){
            ans = true;
        }
        // go to bottom
        if(solve(row + 1, col, board, word, wIdx + 1)){
            ans = true;
        }
        // backtrack: mark it unvisited
        visited[row][col] = false;
        return ans;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        wordLen = word.length();
        if(wordLen > m*n){
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[m][n];
                    if (solve(i, j, board, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Solution {
    int m;
    int n;
    int wordLen;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    private boolean isValid(int row, int col) {
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return false;
        }
        return true;
    }

    private boolean find(int row, int col, char[][] board, String word, int wIdx) {
        boolean ans = false;
        if (wIdx == wordLen) {
            // word found!
            return true;
        }
        if (!isValid(row, col)) {
            return false;//invalid cell
        }
        if (board[row][col] == '$') {
            return false;//already visited
        }
        if (board[row][col] != word.charAt(wIdx)) {
            return false;// not matching
        }
        // else same
        char temp = board[row][col];
        board[row][col] = '$';//mark visited
        for(int[] dir: directions){
            int new_i = row + dir[0];
            int new_j = col + dir[1];
            if(find(new_i, new_j, board, word, wIdx+1)){
                return true;
            }
        }
        // backtrack: mark it unvisited
        board[row][col] = temp;
        return ans;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        wordLen = word.length();
        if(wordLen > m*n){
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (find(i, j, board, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
