import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] arr;

    static int[][] move = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    static int[] next = {1, 2, 3, 0};
    static int count = 0;
    static int now = 0;
    static int moveCount = 1;
    static int dx;
    static int dy;
    static int[][][] mist = {
            {{-1, 0}, {-2, 0}, {-1, 1}, {-1, -1}, {0, -2}, {1, 0}, {2, 0}, {1, 1}, {1, -1}, {0, -1}},
            {{0, -1}, {0, -2}, {-1, -1}, {1, -1}, {2, 0}, {0, 1}, {0, 2}, {-1, 1}, {1, 1}, {1, 0}},
            {{1, 0}, {2, 0}, {1, -1}, {1, 1}, {0, 2}, {-1, 0}, {-2, 0}, {-1, -1}, {-1, 1}, {0, 1}},
            {{0, 1}, {0, 2}, {1, 1}, {-1, 1}, {-2, 0}, {0, -1}, {0, -2}, {1, -1}, {-1, -1}, {-1, 0}}
    };

    static int[] percent = {7, 2, 1, 10, 5, 7, 2, 1, 10, 0};

    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        for (int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dx = (n / 2) + 1;
        dy = (n / 2) + 1;

        boolean flag = true;
        while (flag) {

            for (int i = 0 ; i < moveCount ; i++) {
                dx = dx + move[now][0];
                dy = dy + move[now][1];

                int nowMist = arr[dx][dy];
                int a = nowMist;
                for (int j = 0 ; j < 9 ; j++) {
                    int nx = dx + mist[now][j][0];
                    int ny = dy + mist[now][j][1];
                    int nextMist = nowMist * percent[j] / 100;
                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                        arr[nx][ny] += nextMist;
                    } else {
                        result += nextMist;
                    }
                    a -= nextMist;
                }
                int nx = dx + mist[now][9][0];
                int ny = dy + mist[now][9][1];
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                    arr[nx][ny] += a;
                } else {
                    result += a;
                }
                arr[dx][dy] = 0;

                if (dx == 1 && dy == 1) {
                    flag = false;
                    break;
                }
            }


            count++;
            now = next[now];
            if (count % 2 == 0) {
                moveCount++;
            }
        }

        System.out.println(result);
    }


}