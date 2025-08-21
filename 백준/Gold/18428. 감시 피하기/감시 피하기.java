import java.util.*;
import java.io.*;

class Main {
    static int n;
    static char[][] board;

    static boolean flag = false;
    static List<int[]> teacher = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                board[i][j] = st.nextToken().charAt(0);
                if (board[i][j] == 'T') {
                    teacher.add(new int[]{i, j});
                }
            }
        }

        DFS(0, 0, 0);

        System.out.println(flag ? "YES" : "NO");
    }

    public static void DFS(int level, int x, int y) {
        if (flag) return;
        if (level >= 3) {
            BFS();
            return;
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = 'O';
                    DFS(level + 1, i, j);
                    board[i][j] = 'X';
                }
            }
        }
    }


    public static void BFS() {
        char[][] copy = new char[n][n];

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int[] t : teacher) {
            // 위
            for (int i = t[0] - 1 ; i >= 0 ; i--) {
                if (copy[i][t[1]] == 'O') break;
                if (copy[i][t[1]] == 'S') return;
            }
            // 오른쪽
            for (int i = t[1] + 1 ; i < n ; i++) {
                if (copy[t[0]][i] == 'O') break;
                if (copy[t[0]][i] == 'S') return;
            }

            // 아래
            for (int i = t[0] + 1 ; i < n ; i++) {
                if (copy[i][t[1]] == 'O') break;
                if (copy[i][t[1]] == 'S') return;
            }

            // 왼쪽
            for (int i = t[1] - 1 ; i >= 0 ; i--) {
                if (copy[t[0]][i] == 'O') break;
                if (copy[t[0]][i] == 'S') return;
            }
        }

        flag = true;
        return;
    }
}