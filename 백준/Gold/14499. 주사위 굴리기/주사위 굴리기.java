import java.util.*;
import java.io.*;

public class Main {
    /**
     * 123456
     * 51346
     */
    static int[] dice = {0, 0, 0, 0, 0, 0, 0};

    // 북인 경우 이동하는 위치 정보
    static int[] up = {0, 2, 6, 3, 4, 1, 5};
    // 동인 경우 이동하는 위치 정보
    static int[] right = {0, 3, 2, 6, 1, 5, 4};

    // 서인 경우 이동하는치 정보
    static int[] left = {0, 4, 2, 1, 6, 5, 3};

    // 남인 경우
    static int[] down = {0, 5, 1, 3, 4, 6, 2};
    static int[][] direction = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    static int n;
    static int m;
    static int nowX;
    static int nowY;
    static int k;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nowX = Integer.parseInt(st.nextToken());
        nowY = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < k ; i++) {
            int move = Integer.parseInt(st.nextToken());
            switch (move) {
                case 1 : {
                    move(direction[1], right);
                    break;
                }
                case 2 : {
                    move(direction[2], left);
                    break;
                }
                case 3 : {
                    move(direction[3], up);
                    break;
                }
                case 4 : {
                    move(direction[4], down);
                    break;
                }
            }
        }
    }

    public static void move(int[] direction, int[] move) {
        int nx = nowX + direction[0];
        int ny = nowY + direction[1];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
            int[] copy = new int[7];
            for (int j = 1 ; j < 7 ; j++) {
                copy[j] = dice[j];
            }
            for (int j = 1 ; j < 7 ; j++) {
                dice[move[j]] = copy[j];
            }
            nowX = nx;
            nowY = ny;
            if (board[nowX][nowY] == 0) {
                board[nowX][nowY] = dice[6];
            } else {
                dice[6] = board[nowX][nowY];
                board[nowX][nowY] = 0;
            }

            System.out.println(dice[1]);
        }
    }
}