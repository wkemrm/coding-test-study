import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int k;
    static int l;
    static int[][] board;
    static Queue<int[]> body = new LinkedList<>();
    static Map<Integer, Character> move = new HashMap<>();

    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int nowD = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];

        for (int i = 0 ; i < k ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
        }

        l = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < l ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            move.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        board[1][1] = 1;
        body.offer(new int[]{1, 1});

        int count = 0;
        int dx = 1;
        int dy = 1;

        while (true) {
            count++;
            int nx = dx + d[nowD][0];
            int ny = dy + d[nowD][1];

            if (nx < 1 || nx > n || ny < 1 || ny > n || board[nx][ny] == 1) {
                break;
            }



            if (board[nx][ny] != 2) {
                int[] tail = body.poll();
                board[tail[0]][tail[1]] = 0;
            }

            board[nx][ny] = 1;
            body.offer(new int[]{nx, ny});
            dx = nx;
            dy = ny;

            // 방향 전환 여부 체크
            if (move.containsKey(count)) {
                if (move.get(count) == 'L') {
                    nowD = (nowD + 4 - 1) % 4;
                } else if (move.get(count) == 'D') {
                    nowD = (nowD + 4 + 1) % 4;
                }
            }

        }

        System.out.print(count);
    }
}