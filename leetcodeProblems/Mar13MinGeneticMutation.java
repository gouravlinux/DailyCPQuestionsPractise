class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        // BFS(startGene, endGene, bank, set);
        Queue<String> que = new LinkedList<>();
        que.add(startGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        int level = 0;
        while (!que.isEmpty()) {
            int levelSize = que.size();
            while (levelSize-- > 0) {
                String str = que.poll();
                if (str.equals(endGene)) {
                    return level;
                }
                for(char ch: "ACGT".toCharArray()){
                    for(int i = 0;i < str.length();i++){
                        String newString = str.substring(0, i)+ch+str.substring(i+1, str.length());
                        if(!visited.contains(newString) && bankSet.contains(newString) ){
                            visited.add(newString);
                            que.add(newString);
                        }
                    }
                }
            }
            level++;            
        }
        return -1;
    }
}
