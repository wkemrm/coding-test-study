import java.util.*;
import java.io.*;

class Main {
    static int r;
    static int c;
    static char[][] graph;
    static boolean[][] visited;
    static int maxCount = Integer.MIN_VALUE;
    static int[] count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0 ,1 ,0, -1};

    public static void DFS(int x, int y, int sum) {
        maxCount = Math.max(maxCount, sum);
        for (int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && count[graph[nx][ny] - 'A'] == 0) {
                count[graph[nx][ny] - 'A'] += 1;
                visited[nx][ny] = true;
                DFS(nx, ny, sum + 1);
                count[graph[nx][ny] - 'A'] -= 1;
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph = new char[r][c];
        visited = new boolean[r][c];
        count = new int[26];

        for (int i = 0 ; i < r ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < c ; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        count[graph[0][0] - 'A'] += 1;
        visited[0][0] = true;
        DFS(0, 0, 1);

        System.out.println(maxCount);
    }
}