class Solution {
    private int[] topoSort(int numCourses, int[][] prerequisites){
        int nodeCnt = 0;
        int[] order = new int[numCourses];
        // using kahn's algo
        int[] indegree = new int[numCourses];
        // populate indegree of every vertex in graph
        for(int[] revEdge: prerequisites){
            int v = revEdge[0];
            indegree[v]++;
        }
        // using Queue: storing vertices having indegree = 0
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0;i < numCourses;i++){
            if(indegree[i] == 0) que.add(i);
        }
        // BFS
        int i = 0;
        while(!que.isEmpty()){
            int vertex = que.poll();
            nodeCnt++;
            order[i++] = vertex;
            for(int[] revEdge : prerequisites){
                int u = revEdge[1];
                int v = revEdge[0];
                if(u != vertex)
                    continue;
                indegree[v]--;
                if(indegree[v] == 0) que.add(v);
            }
        }
        return (nodeCnt == numCourses)?order : new int[0];

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // detect cycle: if present : return an empty array
        // not detected: return the order of courses
        return topoSort(numCourses, prerequisites);
    }
}
// using DFS
class Solution {
    boolean[] visited;
    boolean[] inRecursion;
    Stack<Integer> stack;
    int[] order;
    private boolean hasCycleDFS(int vertex,int[][] edges){
        // mark it visited
        visited[vertex] = true;
        // for current Recursion, mark it true
        inRecursion[vertex] = true;
        // explore its neighbours before pushing in stack
        for(int[] revEdge: edges){
            int u = revEdge[1];
            int v = revEdge[0];
            if(u != vertex)
                continue;
            if(!visited[v] && hasCycleDFS(v, edges)){
                return true;
            }
            else if (visited[v] && inRecursion[v]){
                return true;
            }
        } 
        // push in stack
        stack.push(vertex);
        // recursion completed mark inRecursion false
        inRecursion[vertex] = false;
        return false;// no cycle detected till now
    }
    private int[] topoSort(int n, int[][] edges){
        // using DFS
        visited = new boolean[n];
        inRecursion = new boolean[n];
        stack = new Stack<>();
        order = new int[n];
        for(int i = 0;i < n;i++){
            if(!visited[i] && hasCycleDFS(i, edges)){
                return new int[0];//empty array
            }
        }
        // no cycle detected
        int i = 0;
        while(!stack.isEmpty()){
            order[i++] = stack.pop();
        }
        return order;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // detect cycle: if present : return an empty array
        // not detected: return the order of courses
        return topoSort(numCourses, prerequisites);
    }
}
