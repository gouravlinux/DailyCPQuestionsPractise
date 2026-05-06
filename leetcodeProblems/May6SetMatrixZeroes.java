class Solution {
    public void setZeroes(int[][] matrix) {
        // TC : O(m*n)+O(k*(m+n)) where k is no. of 0's in og matrix
        // SC : O(k) where k is no. of 0's in og matrix
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> zeroCoord = new ArrayList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 0) zeroCoord.add(new int[]{i,j});
            }
        }
        for(int[] coord: zeroCoord){
            int x = coord[0];
            int y = coord[1];
            // make xth row 0 in matrix
            for(int j = 0;j < n;j++){
                matrix[x][j] = 0;
            }
            // make yth col 0 in matrix
            for(int i = 0;i < m;i++){
                matrix[i][y] = 0;
            }
        }
    }
}
class Solution {
    int m;
    int n;

    private void makeRowZero(int[][] temp, int row) {
        for (int j = 0; j < n; j++) {
            temp[row][j] = 0;
        }
    }

    private void makeColZero(int[][] temp, int col) {
        for (int i = 0; i < m; i++) {
            temp[i][col] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
        // TC : O(m*n)
        // SC : O(m*n)
        m = matrix.length;
        n = matrix[0].length;
        int[][] temp = new int[m][n];
        // first copy og matrix into temp
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        // then for every matrix value where it is 0, make that row and col 0 in temp
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    makeRowZero(temp, i);
                    makeColZero(temp, j);
                }
            }
        }
        // copy back temp to matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        // TC : O(m*n)
        // SC : O(m+n)
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rowArr = new boolean[m]; // if true, that row needs to be made 0
        boolean[] colArr = new boolean[n]; // if true, that col needs to be made 0
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 0){
                    rowArr[i] = true;
                    colArr[j] = true;
                }
            }
        }
        
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(rowArr[i] || colArr[j]){
                    matrix[i][j] = 0;
                }
                //else do nothing
            }
        }
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
	// TC : O(m*n)
	// SC : O(1)
        int m = matrix.length;
        int n = matrix[0].length;
        // check if first row is impacted
        boolean isFirstRowImpacted = false;
        for(int col = 0;col < n;col++){
            if(matrix[0][col] == 0){
                isFirstRowImpacted = true;
                break;
            }
        }
        // check if first col. is impacted
        boolean isFirstColImpacted = false;
        for(int row = 0;row < m;row++){
            if(matrix[row][0] == 0){
                isFirstColImpacted = true;
                break;
            }
        }
        // set marker in first row and col
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if((matrix[i][0] == 0) || (matrix[0][j] == 0)){
                    matrix[i][j] = 0;
                }
            }
        }
        // later change first row and first col. 
        if(isFirstRowImpacted){
            for(int j = 0;j < n;j++){
                matrix[0][j] = 0;// make whole row 0
            }
        }
        if(isFirstColImpacted){
            for(int i = 0;i < m;i++){
                matrix[i][0] = 0;//make whole col 0
            }
        }
    }
}
