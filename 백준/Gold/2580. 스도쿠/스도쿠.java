import java.util.*;
import java.io.*;

class Main {
    static int[][] graph = new int[9][9];

    public static void sdoku(int x, int y) {
        if (y == 9) {
            sdoku(x + 1, 0);
            return;
        }

        if (x == 9) {
            for (int i = 0 ; i < 9 ; i++) {
                for (int j = 0 ; j < 9 ; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }

        if (graph[x][y] == 0) {
            for (int i = 1 ; i <= 9 ; i++) {
                if (possible(x, y, i)) {
                    graph[x][y] = i;
                    sdoku(x, y + 1);
                }
            }
            graph[x][y] = 0;
            return;
        }

        sdoku(x, y + 1);
    }

    public static boolean possible(int x, int y , int i) {
        if (!garo(x, i)) {
            return false;
        }

        if (!sero(y, i)) {
            return false;
        }

        if (!block(x, y, i)) {
            return false;
        }

        return true;
    }

    public static boolean garo(int x, int input) {
        for (int i = 0 ; i < 9 ; i++) {
            if (graph[x][i] == input) return false;
        }
        return true;
    }

    public static boolean sero(int y, int input) {
        for (int i = 0 ; i < 9 ; i++) {
            if (graph[i][y] == input) return false;
        }
        return true;
    }

    public static boolean block(int x, int y, int input) {
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for (int i = startX ; i < startX + 3 ; i++) {
            for (int j = startY ; j < startY + 3 ; j++) {
                if (graph[i][j] == input) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0 ; i < 9 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 9 ; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sdoku(0, 0);
    }
}