class Solution {
    int m;
    int n;

    private boolean isValid(int i, int j) {
        if (i >= 0 && j >= 0 && i < m && j < n) {
            return true;
        }
        return false;
    }

    private int findLiveNeighbours(int[][] board, int i, int j) {
        int cnt = 0;
        int[][] neighbours = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { 0, 1 } };
        for (int[] neigh : neighbours) {
            int new_i = i + neigh[0];
            int new_j = j + neigh[1];
            if (isValid(new_i, new_j)) {
                cnt += board[new_i][new_j];
            }
        }
        return cnt;
    }

    public void gameOfLife(int[][] board) {
        // TC : O(m*n)
        // SC : O(m*n)
        m = board.length;
        n = board[0].length;
        int[][] res = new int[m][n];
        // copy board to res
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = board[i][j];
            }
        }
        // all conditions written in qn. is evaluated and set here
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighboursCnt = findLiveNeighbours(board, i, j);
                if ((board[i][j] == 0) && (liveNeighboursCnt == 3)) {
                    res[i][j] = 1;
                } else if (board[i][j] == 1) {
                    if (liveNeighboursCnt < 2) {
                        res[i][j] = 0;
                    } else if (liveNeighboursCnt == 2 || liveNeighboursCnt == 3) {
                        continue;
                    } else if (liveNeighboursCnt > 3) {
                        res[i][j] = 0;
                    }
                }
            }
        }
        // copy back to board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = res[i][j];
            }
        }
    }
}

class Solution {
    int m;
    int n;
    int[] state = {0,0,1,1};// index represent state and value represent new value

    private boolean isValid(int i, int j) {
        if (i >= 0 && j >= 0 && i < m && j < n) {
            return true;
        }
        return false;
    }

    private int findLiveNeighbours(int[][] board, int i, int j) {
        int cnt = 0;
        int[][] neighbours = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { 0, 1 } };
        for (int[] neigh : neighbours) {
            int new_i = i + neigh[0];
            int new_j = j + neigh[1];
            if (isValid(new_i, new_j)) {
                int idx = board[new_i][new_j];
                if(idx == 0 || idx == 2){
                    // og value is 0
                    cnt += 0;
                }else{
                    // og value is 1
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    public void gameOfLife(int[][] board) {
        // TC : O(m*n)
        // SC : O(1)
        // OG | New | State
        // ----------------
        // 0  | 0   | 0
        // 1  | 0   | 1
        // 0  | 1   | 2
        // 1  | 1   | 3
        m = board.length;
        n = board[0].length;
        // in place solution
        // all conditions written in qn. is evaluated and set here
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighboursCnt = findLiveNeighbours(board, i, j);
                if ((board[i][j] == 0) && (liveNeighboursCnt == 3)) {
                    board[i][j] = 2;//state : 0 -> 1 : state = 2 
                } else if (board[i][j] == 1) {
                    if (liveNeighboursCnt < 2) {
                        board[i][j] = 1;// make 1 -> 0 : state = 1
                    } else if (liveNeighboursCnt == 2 || liveNeighboursCnt == 3) {
                        board[i][j] = 3;// make 1 -> 1 : state = 3
                    } else if (liveNeighboursCnt > 3) {
                        board[i][j] = 1; // make 1 -> 0 : state = 1
                    }
                }
            }
        }
        // now, acc. to state convert back to new values
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                board[i][j] = state[board[i][j]];
            }
        }
    }
}

class Solution {
    int m;
    int n;
    int[] state = { 0, 0, 1, 1 };// index represent state and value represent new value

    private boolean isValid(int i, int j) {
        if (i >= 0 && j >= 0 && i < m && j < n) {
            return true;
        }
        return false;
    }

    private int findLiveNeighbours(int[][] board, int row, int col) {
        int cnt = 0;
        // iterate over that 9x9 matrix except itself
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {
                if (isValid(i, j)) {
                    if (i == row && j == col) {//same value is not counted
                        continue;
                    } else {
                        int stateVal = board[i][j];
                        if (stateVal == 0 || stateVal == 2) {
                            // og value is 0
                            cnt += 0;
                        } else {//if stateVal == 1 or stateVal == 3
                            // og value is 1
                            cnt += 1;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public void gameOfLife(int[][] board) {
        // TC : O(m*n)
        // SC : O(1)
        // OG | New | State
        // ----------------
        // 0  | 0   | 0
        // 1  | 0   | 1
        // 0  | 1   | 2
        // 1  | 1   | 3
        m = board.length;
        n = board[0].length;
        // in place solution
        // all conditions written in qn. is evaluated and set here
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighboursCnt = findLiveNeighbours(board, i, j);
                if ((board[i][j] == 0) && (liveNeighboursCnt == 3)) {
                    board[i][j] = 2;//state : 0 -> 1 : state = 2 
                } else if (board[i][j] == 1) {
                    if (liveNeighboursCnt < 2) {
                        board[i][j] = 1;// make 1 -> 0 : state = 1
                    } else if (liveNeighboursCnt == 2 || liveNeighboursCnt == 3) {
                        board[i][j] = 3;// make 1 -> 1 : state = 3
                    } else if (liveNeighboursCnt > 3) {
                        board[i][j] = 1; // make 1 -> 0 : state = 1
                    }
                }
            }
        }
        // now, acc. to state convert back to new values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = state[board[i][j]];
            }
        }
    }
}
