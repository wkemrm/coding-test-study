import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] board;
    static Direction[] directions;
    static Cctv[] cctv;
    static int count;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        directions = new Direction[6];
        directions[1] = new Direction(new int[][]{{0}, {1}, {2}, {3}});
        directions[2] = new Direction(new int[][]{{0, 2}, {1, 3}});
        directions[3] = new Direction(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}});
        directions[4] = new Direction(new int[][]{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}});
        directions[5] = new Direction(new int[][]{{0, 1, 2, 3}});

        count = 0;
        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 0 && board[i][j] != 6) {
                    count++;
                }
            }
        }

        cctv = new Cctv[count];
        int now = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (board[i][j] == 0 || board[i][j] == 6) continue;
                cctv[now] = new Cctv(board[i][j], i, j);
                now++;
            }
        }

        DFS(0, new int[count]);
        System.out.println(result);
    }

    public static void DFS(int level, int[] arr) {
        if (level == count) {
            solution(arr);
        } else {
            Cctv now = cctv[level];
            int[][] direction = directions[now.num].direction;
            for (int i = 0 ; i < direction.length ; i++) {
                arr[level] = i;
                DFS(level + 1, arr);
            }
        }
    }

    public static void solution(int[] arr) {
        int[][] copy = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int i = 0 ; i < arr.length ; i++) {
            Cctv now = cctv[i];
            int[][] direction = directions[now.num].direction;
            int[] move = direction[arr[i]];
            for (int j = 0 ; j < move.length ; j++) {
                if (move[j] == 0) {
                    for (int k = now.x - 1 ; k >= 0 ; k--) {
                        if (copy[k][now.y] == 6) break;
                        if (copy[k][now.y] == 0) {
                            copy[k][now.y] = -1;
                        }
                    }
                } else if (move[j] == 1) {
                    for (int k = now.y + 1 ; k < m ; k++) {
                        if (copy[now.x][k] == 6) break;
                        if (copy[now.x][k] == 0) {
                            copy[now.x][k] = -1;
                        }
                    }
                } else if (move[j] == 2) {
                    for (int k = now.x + 1 ; k < n ; k++) {
                        if (copy[k][now.y] == 6) break;
                        if (copy[k][now.y] == 0) {
                            copy[k][now.y] = -1;
                        }
                    }
                } else {
                    for (int k = now.y - 1 ; k >= 0 ; k--) {
                        if (copy[now.x][k] == 6) break;
                        if (copy[now.x][k] == 0) {
                            copy[now.x][k] = -1;
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (copy[i][j] == 0) {
                    count++;
                }
            }
        }
        result = Math.min(count, result);
    }

    static class Direction {
        int[][] direction;
        public Direction (int[][] direction) {
            this.direction = direction;
        }
    }

    static class Cctv {
        int num;
        int x;
        int y;
        public Cctv(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
}