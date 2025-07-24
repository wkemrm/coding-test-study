import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int h;
    static boolean[][] visited;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        visited = new boolean[h + 1][n + 1];

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            visited[level][start] = true;
        }

        int result = 0;
        while (result <= 3) {
            DFS(0, result);
            if (flag) break;
            result++;
        }
        System.out.print(result > 3 ? -1 : result);
    }

    public static void DFS(int level, int num) {
        if (flag) return;
        if (level == num) {
            for (int i = 1 ; i <= n ; i++) {
                if (!line(i)) {
                    return;
                }
            }
            flag = true;
        } else {
            for (int i = 1 ; i <= h ; i++) {
                for (int j = 1 ; j < n ; j++) {
                    if (visited[i][j]) continue;
                    if (visited[i][j - 1] || visited[i][j + 1]) continue;
                    visited[i][j] = true;
                    DFS(level + 1, num);
                    visited[i][j] = false;
                }
            }
        }
    }

    public static boolean line(int num) {
        int startNum = num;
        for (int i =1 ; i <= h ; i++) {
            if (visited[i][num - 1]) {
                num = num - 1;
            } else if (visited[i][num]) {
                num = num + 1;
            }
        }
        if (startNum == num) {
            return true;
        } else {
            return false;
        }
    }
}