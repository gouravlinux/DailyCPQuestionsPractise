class Solution {
    List<List<String>> res;
    int[] col;
    private boolean clash(int row, int n){
        int column = col[row];
        for(int otherQueenRow = 0;otherQueenRow < row;otherQueenRow++){
            if(column == col[otherQueenRow]){
                // clash
                return true;//in same column
            }
            if(Math.abs(column - col[otherQueenRow]) == Math.abs(row-otherQueenRow)){
                // in diagonal
                return true;
            }
        }
        return false;//no clash
    }
    private List<String> makeString(int n){
        List<String> temp = new ArrayList<>();
        for(int row = 0; row < n;row++){
            StringBuilder newString = new StringBuilder();
            for(int column = 0;column<n;column++){
                if(column == col[row]){
                    newString.append('Q');
                    continue;
                }
                newString.append('.');
            }
            temp.add(newString.toString());
        }
        return temp;
    }
    private void solve(int i, int n){// i represent row no.
        if(i == n){
            List<String> temp = makeString(n);
            res.add(temp);
            return;
        }
        for(int colNo = 0;colNo < n;colNo++){
            col[i] = colNo;
            if(clash(i,n)){
                continue;
            } 
            // else
            solve(i+1, n);
        }
    }
    public List<List<String>> solveNQueens(int n) {
        col = new int[n];
        res = new ArrayList<>();
        solve(0, n);
        return res;
    }
}
class Solution {
    List<List<String>> res;
    Set<Integer> colSet;
    Set<Integer> diagonalSet;
    Set<Integer> antiDiagonalSet;
    int[] columnArr;

    private boolean clash(int row, int col, int n) {
        if (colSet.contains(col)) {//check if in same upward column any other queen is present or not
            return true;
        }
        if (diagonalSet.contains(row + col)) {//check if in right upward diagonal queen is present or not
            return true;
        }
        if (antiDiagonalSet.contains(row - col)) {//check if in left upward diagonal queen is present or not
            return true;
        }
        return false;

    }

    private List<String> makeString(int n) {
        List<String> temp = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder newString = new StringBuilder();
            for (int column = 0; column < n; column++) {
                if (column == columnArr[row]) {
                    newString.append('Q');
                    continue;
                }
                newString.append('.');
            }
            temp.add(newString.toString());
        }
        return temp;
    }

    private void solve(int row, int n) {
        if (row == n) {
            List<String> temp = makeString(n);
            res.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (clash(row, col, n)) {
                continue;
            }
            // else
            colSet.add(col);//include
            diagonalSet.add(row + col);//right diagonal = coordinates sum = (row+col)
            antiDiagonalSet.add(row - col);//left diagonal = coordinates difference = (row-col)
            columnArr[row] = col;
            solve(row + 1, n);//explore
            //exclude
            colSet.remove(col);
            diagonalSet.remove(row + col);
            antiDiagonalSet.remove(row - col);
            // now exploration done through for loop
        }
    }

    public List<List<String>> solveNQueens(int n) {
        colSet = new HashSet<>();
        diagonalSet = new HashSet<>();
        antiDiagonalSet = new HashSet<>();
        columnArr = new int[n];
        res = new ArrayList<>();
        solve(0, n);
        return res;
    }
}
