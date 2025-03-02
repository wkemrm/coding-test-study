import java.util.*;
class Solution {
    static int count;
    static int n;
    static int[][] input;
    static boolean[] visited;
    static int[] result;
    static int max = Integer.MIN_VALUE;
    
    public int[] solution(int[][] dice) {
        input = dice;
        count = dice.length / 2;
        n = dice.length;
        result = new int[count];
        visited = new boolean[dice.length];
        DFS(0, 0);
        return result;
    }
    
    public void DFS(int depth, int start) {
        if (depth == count) {
            solution();
        } else {
            for (int i = start ; i < n ; i++) {
                visited[i] = true;
                DFS(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
    
    static List<Integer> ASumList;
    static List<Integer> BSumList;
    
    public void solution() {
        ASumList = new ArrayList<>();
        BSumList = new ArrayList<>();
        int[][] ADice = new int[count][6];
        int[][] BDice = new int[count][6];

        int Acnt = 0;
        int Bcnt = 0;
        for (int i = 0 ; i < n ; i++) {
            if (visited[i]) {
                ADice[Acnt] = input[i];
                Acnt++;
            } else {
                BDice[Bcnt] = input[i];
                Bcnt++;
            }
        }
        
        ASumDFS(0, ADice, 0);
        BSumDFS(0, BDice, 0);
        int win = 0;
        
        Collections.sort(BSumList);
        
        for (int i = 0 ; i < ASumList.size() ; i++) {
            int number = ASumList.get(i);
            int lt = 0;
            int rt = BSumList.size() - 1;
            
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                
                if (BSumList.get(mid) < number) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
            win += lt;
        }
        
        if (win > max) {
            int cnt = 0;
            for (int i = 0 ; i < n ; i++) {
                if (visited[i]) {
                    result[cnt] = i + 1;
                    cnt++;
                }
            }
            max = win;
        }
    }
    
    public void ASumDFS(int depth, int[][] ADice, int sum) {
        if (depth == count) {
            ASumList.add(sum);
        } else {
            for (int i = 0 ; i < 6 ; i++) {
                ASumDFS(depth + 1, ADice, sum + ADice[depth][i]);
            }
        }
    }
    
    public void BSumDFS(int depth, int[][] BDice, int sum) {
        if (depth == count) {
            BSumList.add(sum);
        } else {
            for (int i = 0 ; i < 6 ; i++) {
                BSumDFS(depth + 1, BDice, sum + BDice[depth][i]);
            }
        }
    }
}