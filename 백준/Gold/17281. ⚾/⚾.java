import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] inning;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inning = new int[n][10];

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= 9 ; j++) {
                inning[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(1);
        System.out.print(result);
    }

    static boolean[] visited = new boolean[10];
    static int[] order = new int[10];

    public static void DFS(int depth) {
        if (depth == 10) {
            if (order[4] == 1) {
                Board board = new Board();
                board.solution();
            }
        } else {
            for (int i = 1 ; i <= 9 ; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    order[depth] = i;
                    DFS(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static class Board {
        int out = 0;
        int total = 0;
        boolean[] ru = new boolean[4];

        public Board() {
        }

        public void solution() {
            int num = 1;
            for (int i = 0 ; i < n ; i++) {
                while (out < 3) {
                    int r = inning[i][order[num]];
                    if (r == 1) {
                        score(1);
                    } else if (r == 2) {
                        score(2);
                    } else if (r == 3) {
                        score(3);
                    } else if (r == 4) {
                        score(4);
                    } else if (r == 0) {
                        out++;
                    }

                    num++;
                    if (num == 10) num = 1;
                }
                out = 0;
                ru = new boolean[4];
            }

            result = Math.max(result, total);
        }

        public void score(int score) {
            ru[0] = true;
            for (int i = 3 ; i >= 0 ; i--) {
                if (ru[i]) {
                    if (i + score >= 4) {
                        total++;
                        ru[i] = false;
                    } else {
                        ru[i] = false;
                        ru[i + score] = true;
                    }
                }
            }
        }
    }
}