class Solution {
    public String removeDuplicateLetters(String s) {
        // TC : O(26)+O(n)
        // SC : O(26) + O(k) where k is no of unique chars (which max can go upto 26 letters) and therefore SC ~ O(1)
        int n = s.length();
        // s contains only lowercase letters
        int[] lastIdx = new int[26]; // stores last idx where char is coming
        Arrays.fill(lastIdx, -1);
        boolean[] visited = new boolean[26]; // finds out that is char present in result or not
        StringBuilder result = new StringBuilder();

        // fill lastIdx
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            lastIdx[ch - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (visited[ch - 'a'] == true) {
                continue;
            }
            while (!result.isEmpty()) {
                char lastChar = result.charAt(result.length() - 1);
                if (lastChar > ch && lastIdx[lastChar - 'a'] > i) {
                    // element also present after i
                    // remove that element
                    result.deleteCharAt(result.length() - 1);
                    visited[lastChar - 'a'] = false;
                } else {
                    break;
                }
            }

            result.append(ch);
            visited[ch - 'a'] = true;

        }
        return result.toString();
    }
}
