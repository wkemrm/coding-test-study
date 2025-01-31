import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Robot robot = new Robot(r, c, d);

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            robot.nowClean();
            if (robot.isEmptyByFour()) {
                robot.empty();
            } else {
                if (robot.notEmpty()) {
                    break;
                }
            }
        }

        System.out.println(robot.cnt);
    }

    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Robot {
        int x;
        int y;
        int cnt;
        int d;

        public Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cnt = 0;
        }

        public void nowClean() {
            if (map[x][y] == 0) {
                cnt++;
                map[x][y] = -1;
            }
        }

        int[] behind = {2, 3, 0, 1};
        // true인 경우 작동 멈춤
        public boolean notEmpty() {
            int nextBehind = behind[d];
            int nx = x + direction[nextBehind][0];
            int ny = y + direction[nextBehind][1];
            // 후진 못하는 경우
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 1) return true;

            this.x = nx;
            this.y = ny;
            return false;
        }

        int[] left = {3, 0, 1, 2};
        public void empty() {
            int nextLeft = left[d];
            int nx = x + direction[nextLeft][0];
            int ny = y + direction[nextLeft][1];
            d = nextLeft;
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                this.x = nx;
                this.y = ny;
            }
        }

        public boolean isEmptyByFour() {
            boolean flag = false;
            for (int i = 0 ; i < 4 ; i++) {
                int nx = x + direction[i][0];
                int ny = y + direction[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                    flag = true;
                    break;
                }
            }
            return flag;
        }
    }
}