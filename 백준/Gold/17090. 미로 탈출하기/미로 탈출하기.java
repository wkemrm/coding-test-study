import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static char[][] graph;
    static int count = 0;
    static boolean[][] visited;
    static int[][] memory;
    static Map<Character, int[]> map = new HashMap<>(){{
        put('U', new int[]{-1, 0});
        put('R', new int[]{0, 1});
        put('D', new int[]{1, 0});
        put('L', new int[]{0, -1});
    }};

    static boolean flag = false;

    public static void DFS(int x, int y) {
        if (memory[x][y] == -1) {
            return;
        } else if(memory[x][y] == 1) {
            count++;
            flag = true;
            return;
        }
        visited[x][y] = true;
        memory[x][y] = -1;
        int dx = map.get(graph[x][y])[0];
        int dy = map.get(graph[x][y])[1];
        int nx = x + dx;
        int ny = y + dy;
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
            DFS(nx, ny);
            if (flag) {
                memory[x][y] = 1;
            }
        } else if (nx < 0 || nx >= n || ny < 0 || ny >= m){
            count++;
            memory[x][y] = 1;
            flag = true;
        }
        visited[x][y] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        memory = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0 ; i < n ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < m ; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                flag = false;
                DFS(i, j);
            }
        }

        System.out.println(count);
    }
}