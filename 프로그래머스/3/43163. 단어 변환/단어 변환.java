class Solution {
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    public boolean diffCount(String a, String b) {
        int count = 0;
        for (int i = 0 ; i < a.length() ; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
    public void DFS(int level, String curS, String target, String[] words) {
        if (curS.equals(target)) {
            answer = Math.min(answer, level);
        } else {
            for (int i = 0 ; i < words.length ; i++) {
                if (visited[i]) {
                    continue;
                }
                if (diffCount(curS, words[i])) {
                    visited[i] = true;
                    DFS(level + 1, words[i], target, words);
                    visited[i] = false; 
                }
               
                
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        DFS(0, begin, target, words);
        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }
}