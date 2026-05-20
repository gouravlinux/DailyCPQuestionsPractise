class Solution {
    public String convert(String s, int numRows) {
        // TC : O(n)
	// auxilary space : O(1)
        // base case
        if(numRows == 1) return s;
        int n = s.length();
        StringBuilder str = new StringBuilder();
        for(int i = 0;i < numRows;i++){
            // take elements from ith row
            int j = i;
            boolean goDown = true;
            int deltaSouth = 2 * (numRows - i - 1);
            int deltaNorth = 2 * i;
            while(j < n){
                str.append(s.charAt(j));
                // base case: if row is the first row
                if(i == 0) {
                    j += deltaSouth; // only add from down, no need of up
                }else if (i == numRows-1){
                    j += deltaNorth; // only add from up, not down
                }
                else{
                    if(goDown == true){
                        j += deltaSouth; // go from down to up
                    }else{
                        j += deltaNorth; // go from up to down
                    }
                    goDown = !goDown; // reverse the direction
                }
            }
        }
        return str.toString();
    }
}

class Solution {
    public String convert(String s, int numRows) {
        // TC : O(n)
        // SC : O(n)
        int n = s.length();
        // base case: if 1 row or s.length() <= numRows, return s 
        if(n <= numRows || numRows == 1) return s;
        // build every row and store it in arr
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currRow = 0;
        boolean goingDown = true;

        for (char ch : s.toCharArray()) {
            rows[currRow].append(ch);
            if (currRow == 0) {
                // goDown only
                goingDown = true;
            } else if (currRow == numRows - 1) {
                // goUp only
                goingDown = false;
            }
            if (goingDown == true)
                currRow++; // go to next row for storing next ch
            else
                currRow--; // go to prev row for storing next ch
        }

        // combine results
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }
        return result.toString();
    }
}
