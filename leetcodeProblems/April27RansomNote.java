class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // TC : O(m+n)
        // SC : O(k) where k is the no. of distinct elements in our magazine
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: magazine.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(char ch: ransomNote.toCharArray()){
            if(!map.containsKey(ch) || map.get(ch) == 0){
                return false;
            }
            map.put(ch, map.get(ch)-1);
        }
        return true;
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
	// TC : O(m+n)
	// SC : O(1)
        char[] arr = new char[26];
        for(char ch: magazine.toCharArray()){
            arr[ch-'a']++;
        }
        for(char ch: ransomNote.toCharArray()){
            if(arr[ch-'a'] == 0) return false;// can't decrement
            // else decrement
            else arr[ch-'a']--;
        }
        return true;
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
	// TC : O(m+n+k1)
	// SC : O(k1+k2)
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(char ch: ransomNote.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        for(char ch: magazine.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        for(char ch: map1.keySet()){
            if(!map2.containsKey(ch) || map2.get(ch) < map1.get(ch)){
                return false;
            }
        }
        return true;
    }
}
