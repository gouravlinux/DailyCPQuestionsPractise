class Solution {
    public boolean checkIfExist(int[] arr) {
        // TC : O(n)
        // SC : O(n)
        Set<Integer> set = new HashSet<>();
        for(int num: arr){
            // if (num is even and its half is present) or 2*num is present
            if((num%2 == 0 && set.contains(num/2)) || set.contains(2*num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
