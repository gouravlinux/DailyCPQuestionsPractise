class Solution {
    private void swap(int[][] matrix,int i,int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    private void reverse(int[] arr){
        int n = arr.length;
        int s = 0;
        int e = n-1;
        while(s < e){
            // swap
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    public void rotate(int[][] matrix) {
        // TC : O(n^2+n^2) = O(n^2)
        // SC : O(1)
        int n = matrix.length;
        // first transpose the matrix
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                swap(matrix, i, j);
            }
        }
        // then reverse all rows
        for(int i = 0;i < n;i++){
            reverse(matrix[i]);
        }
    }
}
class Solution {
    public void rotate(int[][] matrix) {
        // TC : O(n^2)
        // SC : O(n^2)
        // not an in-place solution
        int n = matrix.length;
        int[][] res = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                res[j][n-1-i] = matrix[i][j];
            }
        }
        // copy back
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                matrix[i][j] = res[i][j];
            }
        }
    }
}
