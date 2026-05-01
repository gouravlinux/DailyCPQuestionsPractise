class Solution {
    private String sort(String s) {
        int[] charArr;
        charArr = new int[26];
        for (char ch : s.toCharArray()) {
            charArr[ch - 'a']++;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (charArr[i] > 0) {
                charArr[i]--;
                str.append((char) (i + 'a'));
            }
        }
        return str.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // n -> no. of strings
        // k -> max. no. of characters in string
        // TC : N*(k+26)
        // SC : O(26)+O(n*k)

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {// O(n)
            String sortedStr = sort(s);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(s);//O(k)
        }
        List<List<String>> resList = new ArrayList<>();//Space:O(n.k)
        for (String s : map.keySet()) {
            resList.add(map.get(s));
        }
        return resList;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
	// TC : O(nklogk)
	// SC : O(n.k)
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(s);
        }
        List<List<String>> resList = new ArrayList<>();
        for(String s: map.keySet()){
            resList.add(map.get(s));
        }
        return resList;
    }
}
