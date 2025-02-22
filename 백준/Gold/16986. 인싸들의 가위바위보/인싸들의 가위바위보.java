import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int k;
    static int[][] graph;
    static int[][] command;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        command = new int[4][21];
        visited = new boolean[n + 1];

        for (int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2 ; i <= 3 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= 20 ; j++) {
                command[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(1);

        System.out.print(flag ? 1 : 0);
    }

    public static void gameStart() {
        int[] winCount = new int[4];
        int[] now = new int[4];
        Arrays.fill(now, 1);
        int player1 = 1;
        int player2 = 2;
        int nextPlayer = 3;
        while(true) {
            if (winCount[1] == k) {
                flag = true;
                break;
            }

            if (winCount[2] == k || winCount[3] == k) {
                break;
            }

            if (now[1] == n + 1 || now[2] == 21 || now[3] == 21) {
                break;
            }

            nextPlayer = 6 - player1 - player2;

            int winner = win(player1, player2, now);
            winCount[winner]++;
            now[player1]++;
            now[player2]++;

            player1 = winner;
            player2 = nextPlayer;
        }
    }

    public static int win(int player1, int player2, int[] now) {
        if (graph[command[player1][now[player1]]][command[player2][now[player2]]] == 2) {
            return player1;
        } else if (graph[command[player1][now[player1]]][command[player2][now[player2]]] == 0) {
            return player2;
        } else {
            return Math.max(player1, player2);
        }
    }

    public static void DFS(int depth) {
        if (depth == n + 1) {
            if(!flag) {
                gameStart();
            }
        } else {
            for (int i = 1 ; i <= n ; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    command[1][depth] = i;
                    DFS(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

}