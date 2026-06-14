import java.util.List;
import java.util.ArrayList;

public class Solution {
    private static void solve(int lastBit,String string,int n,List<String> res){
        if(string.length() == n){
            res.add(string);
            return;
        }
        // we can always add 0 to str
        solve(0, string + '0', n, res);
        if(lastBit != 1){
            solve(1, string + '1', n, res);
        }
    }
    public static List< String > generateString(int N) {
        /*
	    using recursion + backtracking approach
            TC : O(2^n)
            SC : O(n)
        */
        List<String> res = new ArrayList<>();
        solve(-1, "", N, res);
        return res;
    }
}

