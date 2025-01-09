import java.util.*;
import java.io.*;

class Main {
    static int[][] graph = new int[10][10];

    public static void solution(int x, int y) {
        if (y == 10) {
            solution(x + 1, 1);
            return;
        }

        if (x == 10) {
            for (int i = 1 ; i <= 9 ; i++) {
                for (int j = 1 ; j < 9 ; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println(graph[i][9]);
            }
            System.exit(0);
        }

        if (graph[x][y] == 0) {
            for (int i = 1 ; i <= 9 ; i++) {
                if (possible(x, y, i)) {
                    graph[x][y] = i;
                    solution(x, y + 1);
                }
            }
            graph[x][y] = 0;
            return;
        }
        solution(x, y + 1);
    }

    public static boolean possible(int x, int y, int i) {
        // 가로 확인
        if (!garo(x, i)) {
            return false;
        }

        // 세로 확인
        if (!sero(y, i)) {
            return false;
        }

        // 블록 확인
        if (!block(x, y, i)) {
            return false;
        }

        return true;
    }

    public static boolean garo(int x, int input) {
        for (int i = 1 ; i <= 9 ; i++) {
            if (graph[x][i] == input) {
                return false;
            }
        }

        return true;
    }

    public static boolean sero(int y, int input) {
        for (int i = 1 ; i <= 9 ; i++) {
            if (graph[i][y] == input) {
                return false;
            }
        }

        return true;
    }

    public static boolean block(int x, int y, int input) {
        int startX = ((x - 1) / 3) * 3 + 1;
        int startY = ((y - 1) / 3) * 3 + 1;

        for (int i = startX ; i < startX + 3 ; i++) {
            for (int j = startY ; j < startY + 3 ; j++) {
                if(graph[i][j] == input) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1 ; i < 10 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j < 10 ; j++) {
                int input = Integer.parseInt(st.nextToken());
                graph[i][j] = input;
            }
        }
        solution(1, 1);

    }
}