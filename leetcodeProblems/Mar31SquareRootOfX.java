class Solution {
    public int mySqrt(int x) {
        // using Binary Search
        int start = 1;
        int end = x;
        int ans = 0;
        while(start <= end){
            long mid = start + (end-start)/2;
            System.out.println(mid);
            if(mid*mid == x){
                ans = (int)mid;
                return ans;
            }
            if(mid*mid > x){
                // search in left space
                end = (int)mid-1;
            }
            else{
                // mid*mid < x
                ans = (int)mid;//possible answer
                start = (int)mid+1;
            }
        }
        return ans;
    }
}
