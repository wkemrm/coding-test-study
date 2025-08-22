class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // [n][n] = Math.min([n - 1][n], [n][n - 1]) + 1;h
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 0 ; i < puddles.length ; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];
            arr[y][x] = -1;
        }

        arr[1][1] = 1;
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= m ; j++) {
                if (i == 1 && j == 1) continue;
                if (arr[i][j] == -1) continue;
                
                int up = (arr[i - 1][j] == -1 ? 0 : arr[i - 1][j]) % 1000000007;
                int left = (arr[i][j - 1] == -1 ? 0 : arr[i][j - 1]) % 1000000007;
                arr[i][j] = (up  + left) % 1000000007;
            }
        }
        
        int answer = arr[n][m];
        return answer;
    }
}