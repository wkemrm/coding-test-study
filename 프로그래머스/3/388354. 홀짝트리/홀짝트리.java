import java.util.*;

class Solution {

    int[] isDegree;
    int[] parent;
    public int[] solution(int[] nodes, int[][] edges) {
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < nodes.length ; i++) {
            max = Math.max(max, nodes[i]);
        }
        
        isDegree = new int[max + 1];
        parent = new int[max + 1];
        
        for (int i = 0 ; i < nodes.length ; i++) {
            parent[nodes[i]] = nodes[i];
        }
        
        for (int i = 0 ; i < edges.length ; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            isDegree[start]++;
            isDegree[end]++;
            union(start, end);
        }
        
        HashMap<Integer, TreeInfo> map = new HashMap<>();
        for (int i = 0 ; i < nodes.length ; i++) {
            int node = nodes[i];
            int group = find(node);
            TreeInfo info = map.getOrDefault(group, new TreeInfo());
            
            if ((node % 2 == 0) && (isDegree[node] % 2 == 0)) {
                info.evenCount++;
            } else if ((node % 2 == 1) && (isDegree[node] % 2 == 1)) {
                info.oddCount++;
            } else if ((node % 2 == 0) && (isDegree[node] % 2 == 1)) {
                info.rEvenCount++;
            } else if ((node % 2 == 1) && (isDegree[node] % 2 == 0)) {
                info.rOddCount++;
            }
            map.put(group, info);
        }
        
        int tree = 0;
        int rTree = 0;
        for (Map.Entry<Integer, TreeInfo> entry : map.entrySet()) {
            TreeInfo info =entry.getValue();
            if (info.isTree()) {
                tree++;
            }
            if (info.isRTree()) {
                rTree++;
            }
        }
        
        return new int[]{tree, rTree};
    }
    
    static class TreeInfo {
        int oddCount;
        int evenCount;
        int rOddCount;
        int rEvenCount;
        
        public boolean isTree() {
            if ((oddCount == 1 && evenCount == 0) || (evenCount == 1 && oddCount == 0)) {
                return true;
            }
            return false;
        }
        
        public boolean isRTree() {
            if ((rOddCount == 1 && rEvenCount == 0) || (rEvenCount == 1 && rOddCount == 0)) {
                return true;
            }
            return false;
        }
    }
    
    public int find(int num) {
        if (parent[num] != num) {
            return parent[num] = find(parent[num]);
        }
        return num;
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

}