import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] board;
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        st = new StringTokenizer(br.readLine());
        Robot robot = new Robot(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(flag) {
            robot.clear();
            if (robot.isMove()) {
                robot.run();
            } else {
                flag = robot.back();
            }
        }

        System.out.print(robot.count);
    }

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[] left = {3, 0, 1, 2};
    static int[] behind = {2, 3, 0, 1};

    static class Robot {
        int x;
        int y;
        int direction;
        int count;

        public Robot(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.count = 0;
        }

        public boolean isMove() {
            for (int i = 0 ; i < 4 ; i++) {
                int nx = this.x + move[i][0];
                int ny = this.y + move[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean back() {
            int back = behind[direction];
            int nx = x + move[back][0];
            int ny = y + move[back][1];
            if (nx < 0 || nx >= n && ny < 0 && ny >= m || board[nx][ny] == 1) {
                return false;
            }

            this.x = nx;
            this.y = ny;
            return true;
        }

        public void run() {
            this.direction = left[direction];
            int nx = this.x + move[this.direction][0];
            int ny = this.y + move[this.direction][1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                this.x = nx;
                this.y = ny;
            }
        }

        public void clear() {
            if (board[this.x][this.y] == 0) {
                this.count++;
                board[this.x][this.y] = -1;
            }
        }
    }
}