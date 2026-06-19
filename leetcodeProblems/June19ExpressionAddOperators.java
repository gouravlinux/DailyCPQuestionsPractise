class Solution {
    List<String> ans;
    int n;

    private void solve(String s, int target, int i, StringBuilder path, long eval, long residual) {
        // eval here means exp's curr value
        // residual means the prev. operand

        // base case
        if (i == n) {
            if (eval == target) {
                ans.add(path.toString());
            }
            return;
        }

        StringBuilder currStr = new StringBuilder();
        long num = 0;

        // backtracking loop
        for (int j = i; j < n; j++) {
            // handle 0: if for j == i and num[j] = '0' then do recursion but after that when j++: 08... -> not a valid number
            if (j > i && s.charAt(i) == '0')
                return;
            currStr.append(s.charAt(j));
            num = num * 10 + (s.charAt(j) - '0');
            int len = path.length();
            if (i == 0) {
                // at 0th level, no need of thinking of operators
                // call for solve(a), solve(ab), solve(abc).... where num = 'abc...'
                path.append(currStr);
                solve(s, target, j + 1, path, num, num); // pass path + currStr
                // backtrack
                path.setLength(len);
            } else {
                path.append('+').append(currStr);
                solve(s, target, j + 1, path, eval + num, num);
                path.setLength(len); // backtrack

                path.append('-').append(currStr);
                solve(s, target, j + 1, path, eval - num, -num);
                path.setLength(len); // backtrack

                path.append('*').append(currStr);
                solve(s, target, j + 1, path, eval - residual + num * residual, num * residual);
                path.setLength(len); // backtrack
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        /*
            using recursion + backtracking
            TC : O(4^N)
            SC : O(N)
        */
        ans = new ArrayList<>();
        n = num.length();
        solve(num, target, 0, new StringBuilder(), 0, 0);
        return ans;
    }
}
