import java.util.*;
import java.io.*;

class Main {
    static char[][] map = new char[12][6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0 ; i < 12 ; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0 ; j < 6 ; j++) {
                map[i][j] = line[j];
            }
        }

        int result = 0;
        boolean possible = false;

        for (int i = 11 ; i >= 0 ; i--) {
            for (int j = 5 ; j >= 0 ; j--) {
                if (map[i][j] == '.') continue;

                if (BFS(i, j)) {
                    possible = true;
                }
            }
        }

        if (possible) result++;

        // 내리기
        down();

        while(possible) {
            possible = false;
            for (int i = 11 ; i >= 0 ; i--) {
                for (int j = 5 ; j >= 0 ; j--) {
                    if (map[i][j] == '.') continue;

                    if (BFS(i, j)) {
                        possible = true;
                    }
                }
            }

            if (possible) result++;

            // 내리기
            down();
        }

        System.out.print(result);
    }

    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static boolean BFS(int x, int y) {
        char color = map[x][y];
        boolean[][] visited = new boolean[12][6];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while(!q.isEmpty()) {
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();

            for (int i = 0 ; i < 4 ; i++) {
                int nx = cx + direction[i][0];
                int ny = cy + direction[i][1];

                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !visited[nx][ny] && map[nx][ny] == color) {
                    count++;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        if (count >= 4) {
            for (int i = 0 ; i < 12 ; i++) {
                for (int j = 0 ; j < 6 ; j++) {
                    if (visited[i][j]) map[i][j] = '.';
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void down() {
        for (int i = 0 ; i < 6 ; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 11 ; j >= 0 ; j--) {
                if (map[j][i] != '.') list.add(map[j][i]);
            }

            for (int j = 0 ; j < list.size() ; j++) {
                map[11 - j][i] = list.get(j);
            }

            for (int j = list.size() ; j < 12 ; j++) {
                map[11 - j][i] = '.';
            }
        }
    }
}