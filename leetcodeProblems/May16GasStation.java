class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // TC : O(n^2)
        // SC : O(1)
        int n = gas.length;
        int gasPresent = 0;
        int ans = -1;
        for(int i = 0;i < n;i++){
            // let i be the starting gas station
            int j = 0;
            for(;j < n;j++){
                int gasStation = (i + j) % n;
                gasPresent += gas[gasStation];
                if(gasPresent < cost[gasStation]){
                    // if you have less gas than to go to next station
                    gasPresent = 0; // reset and move to next i
                    break;
                }else{
                    gasPresent -= cost[gasStation];
                }
            }
            if(j == n){
                // all gasStations were covered
                ans = i;
                break;
            }
        }
        return ans;
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // TC : O(n)
        // SC : O(1)
        int n = gas.length;
        // greedy solution
        int totalGas = 0;
        int totalCost = 0;
        for(int num: gas){
            totalGas += num;
        }
        for(int num: cost){
            totalCost += num;
        }
        if(totalCost > totalGas){
            // then no solution exist
            return -1;
        }
        // else,unique solution exist
        int currGas = 0;
        int expectedStart = 0;
        for(int i = 0;i < n;i++){
            currGas += gas[i] - cost[i]; 
            if(currGas < 0){
                // not the expected start station
                expectedStart = i + 1; // next station
                currGas = 0;
            }
        }
        return expectedStart;
    }
}
