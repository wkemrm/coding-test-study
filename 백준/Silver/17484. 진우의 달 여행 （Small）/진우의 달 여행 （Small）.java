import java.util.*;

class Main {
    static int n, m;
    static int[][] arr;
    static String[] witch = {"left", "middle", "right"};
    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};
    static int result = Integer.MAX_VALUE;
    public static void DFS(int level, int x, int y, int sum, int witch) {
        if (level == n - 1) {
            result = Math.min(result, sum);
        } else {
            for (int i = 0 ; i < 3 ; i++) {
                if (i != witch) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        DFS(level + 1, nx, ny, sum + arr[nx][ny], i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0 ; i < m ; i++) {
            DFS(0, 0, i, arr[0][i], -1);
        }

        System.out.print(result);
    }
}