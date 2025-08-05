import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] board;
    static boolean[][] groom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n + 1][n + 1];
        groom = new boolean[n + 1][n + 1];
        for (int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        groom[n][1] = true;
        groom[n][2] = true;
        groom[n - 1][1] = true;
        groom[n - 1][2] = true;

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            move(d, s);
            rain();
            bug();
            makeGroom();
        }

        int sum = 0;
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                sum += board[i][j];
            }
        }

        System.out.println(sum);
    }

    public static void move(int d, int s) {
        boolean[][] copy = new boolean[n + 1][n + 1];
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (groom[i][j]) {
                    int nx = nextX(i, d, s);
                    int ny = nextY(j, d, s);
                    copy[nx][ny] = true;
                }
            }
        }
        groom = copy;
    }

    static int[][] move = {{}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static int nextX(int index, int d, int s) {
        int next = index + (move[d][0] * s);
        if (next <= 0) {
            int nextMove = n + next;
            while (true) {
                if (nextMove > 0) break;
                nextMove = n + nextMove;
            }
            return nextMove;
        } else if (next > n) {
            int nextMove = next - n;
            while (true) {
                if (nextMove <= n) break;
                nextMove = nextMove - n;
            }
            return nextMove;

        } else {
            return next;
        }
    }

    public static int nextY(int index, int d, int s) {
        int next = index + (move[d][1] * s);
        if (next <= 0) {
            int nextMove = n + next;
            while (true) {
                if (nextMove > 0) break;
                nextMove = n + nextMove;
            }
            return nextMove;
        } else if (next > n) {
            int nextMove = next - n;
            while (true) {
                if (nextMove <= n) break;
                nextMove = nextMove - n;
            }
            return nextMove;

        } else {
            return next;
        }
    }

    public static void rain() {
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (groom[i][j]) {
                    board[i][j] += 1;
                }
            }
        }
    }
    static int[][] bugMove = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    public static void bug() {
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (groom[i][j]) {
                    int count = 0;
                    for (int k = 0 ; k < 4 ; k++) {
                        int nx = i + bugMove[k][0];
                        int ny = j + bugMove[k][1];
                        if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && board[nx][ny] >= 1) count++;
                    }
                    board[i][j] += count;
                }
            }
        }
    }

    public static void makeGroom() {
        boolean[][] copy = new boolean[n + 1][n + 1];
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (!groom[i][j] && board[i][j] >= 2) {
                    copy[i][j] = true;
                    board[i][j] -= 2;
                }
            }
        }
        groom = copy;
    }
}