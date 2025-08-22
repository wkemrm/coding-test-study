import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int k;
    static Block[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new Block[n + 1][n + 1];

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                board[i][j] = new Block();
            }
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Fire fire = new Fire(x, y, m, s, d);
            board[x][y].fireList.add(fire);
        }

        for (int i = 1 ; i <= k ; i++) {
            Queue<Fire> fires = getFire();
            move(fires);
            div();
        }

        int result = 0;
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                for (Fire fire : board[i][j].fireList) {
                    result += fire.m;
                }
            }
        }

        System.out.print(result);
    }

    public static void div() {
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (!board[i][j].isDiv()) continue;
                board[i][j].div();
            }
        }
    }

    public static void move(Queue<Fire> fires) {
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                board[i][j].clear();
            }
        }

        while(!fires.isEmpty()) {
            Fire fire = fires.poll();
            fire.move();
            board[fire.x][fire.y].fireList.add(new Fire(fire.x, fire.y, fire.m, fire.s, fire.d));
        }
    }

    public static Queue<Fire> getFire() {
        Queue<Fire> q = new LinkedList<>();
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                for (Fire fire : board[i][j].fireList) {
                    q.offer(fire);
                }
            }
        }
        return q;
    }

    public static class Block {
        List<Fire> fireList = new ArrayList<>();

        public void clear() {
            this.fireList.clear();
        }

        public boolean isDiv() {
            return fireList.size() >= 2 ? true : false;
        }

        public void div() {
            int x = fireList.get(0).x;
            int y = fireList.get(0).y;
            int totalM = 0;
            int totalS = 0;
            for (Fire fire : this.fireList) {
                totalM += fire.m;
                totalS += fire.s;

            }

            boolean prevD = fireList.get(0).d % 2 == 0 ? true : false;
            boolean nextD = true;

            for (int i = 1 ; i < fireList.size() ; i++) {
                int nowD = fireList.get(i).d;
                if (nowD % 2 == 0) {
                    if (!prevD) {
                        nextD = false;
                        break;
                    }
                    prevD = true;
                } else {
                    if (prevD) {
                        nextD = false;
                        break;
                    }
                    prevD = false;
                }
            }

            totalM /= 5;
            totalS /= fireList.size();

            if (totalM == 0) {
                clear();
                return;
            }
            clear();
            if (nextD) {
                for (int i = 0 ; i <= 6 ; i += 2) {
                    fireList.add(new Fire(x, y, totalM, totalS, i));
                }
            } else {
                for (int i = 1 ; i <= 7 ; i += 2) {
                    fireList.add(new Fire(x, y, totalM, totalS, i));
                }
            }
        }
    }

    static int[][] move = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static class Fire {
        int x;
        int y;
        int m;
        int s;
        int d;

        public Fire(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public void move() {
            this.x = ((this.x - 1) + move[d][0] * s % n + n) % n + 1;
            this.y = ((this.y - 1) + move[d][1] * s % n + n) % n + 1;
        }
    }
}