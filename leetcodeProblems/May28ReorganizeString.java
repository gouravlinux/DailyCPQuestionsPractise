class Pair{
    char ch;
    int freq;
    public Pair(char ch,int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        // TC : O(n)+O(k)+O(k*log(k)) where k is the unique chars in s
        // SC : O(k)+O(k) 
        int n = s.length();
        // store freq. of characters
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(char key: map.keySet()){
            if(map.get(key) > (int)((n+1)/2)){
                // if a char's freq is more than ceil value of n/2
                // then it is impossible to reorganize string
                return "";
            }
        }
        // define a max Heap
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));

        // store all map values in maxHeap
        for(char ch: map.keySet()){
            int freq = map.get(ch);
            maxHeap.add(new Pair(ch, freq));
        }

        StringBuilder sb = new StringBuilder();
        // if maxHeap's size is >= 2, form the result
        while(maxHeap.size() >= 2){
            // will poll() 2 pairs, therefore we took maxHeap's size should be atleast 2
            Pair firstPair = maxHeap.poll();
            Pair secondPair = maxHeap.poll();
            sb.append(firstPair.ch);
            firstPair.freq--;
            if(firstPair.freq > 0) // add back only if freq is alteast 1 remaining
                maxHeap.add(firstPair);
            sb.append(secondPair.ch);
            secondPair.freq--;
            if(secondPair.freq > 0) // add back only if freq is alteast 1 remaining
                maxHeap.add(secondPair);
        }

        if(!maxHeap.isEmpty()){
            // now maxHeap only has single element
            sb.append(maxHeap.poll().ch);
        }
        return sb.toString();
    }
}

class Solution {
    public String reorganizeString(String s) {
        // TC : O(n)
        // SC : O(n)+O(k)
        int n = s.length();
        int maxFreq = 0;
        char charMaxFreq = 'a';
        // store freq. of characters
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
            if(map.get(ch) > maxFreq){
                maxFreq = map.get(ch);
                charMaxFreq = ch; // this char came max times
            }
            if(map.get(ch) > (n+1)/2) return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.setLength(n);
        int i = 0;
        // set char with max freq to alterante positions
        while(map.get(charMaxFreq) > 0){
            sb.setCharAt(i, charMaxFreq);
            i += 2;//now place at alternate position
            map.put(charMaxFreq, map.get(charMaxFreq)-1);
        }
        // place rest of the letters in empty slots in alternate fashion
        for(char ch: map.keySet()){
            while(map.get(ch) > 0){
                if(i >= n){
                    i = 1;
                }
                sb.setCharAt(i, ch);
                i += 2;
                map.put(ch, map.get(ch)-1);
            }
        }
        return sb.toString();
    }
}
