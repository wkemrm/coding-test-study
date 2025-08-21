import java.util.*;
import java.io.*;

class Main {
    static int m;
    static int s;
    static Block[][] board = new Block[5][5];
    static Shark shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i <= 4 ; i++) {
            for (int j = 1 ; j <= 4 ; j++) {
                board[i][j] = new Block();
            }
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            board[x][y].fishList.add(new Fish(x, y, d));
        }

        st = new StringTokenizer(br.readLine());
        shark = new Shark();
        shark.x = Integer.parseInt(st.nextToken());
        shark.y = Integer.parseInt(st.nextToken());


        for (int i = 1 ; i <= s ; i++) {
            Queue<Fish> copyFish = copyFish();
            fishMove();
            shark.eat(i);
            smellDelete(i);
            copy(copyFish);


        }

        int result = 0;
        for (int i = 1 ; i <= 4 ; i++) {
            for (int j = 1 ; j <= 4 ; j++) {
                result += board[i][j].size();
            }
        }

        System.out.println(result);
    }

    public static void copy(Queue<Fish> q) {
        while(!q.isEmpty()) {
            Fish fish = q.poll();
            board[fish.x][fish.y].fishList.add(fish);
        }
    }

    public static void smellDelete(int time) {
        int deleteTime = time - 2;
        if (deleteTime <= 0) return;

        for (int i = 1 ; i <= 4 ; i++) {
            for (int j = 1 ; j <= 4 ; j++) {
                board[i][j].smellDelete(deleteTime);
            }
        }
    }

    static int[][] move = {{}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static int[] next = {0, 8, 1, 2, 3, 4, 5, 6, 7};

    public static void fishMove() {
        Queue<Fish> q = new LinkedList<>();
        for (int i = 1 ; i <= 4 ; i++) {
            for (int j = 1 ; j <= 4 ; j++) {
                for (Fish fish : board[i][j].fishList) {
                    q.offer(fish);
                }
                board[i][j].removeFishList();
            }
        }

        while (!q.isEmpty()) {
            Fish fish = q.poll();

            int nx = fish.x + move[fish.direction][0];
            int ny = fish.y + move[fish.direction][1];

            if (nx >= 1 && nx <= 4 && ny >= 1 && ny <= 4 && !board[nx][ny].isSmell() && !shark.isShark(nx, ny)) {
                board[nx][ny].fishList.add(new Fish(nx, ny, fish.direction));
                continue;
            }

            int nd = fish.direction;
            boolean moveFlag = false;
            for (int i = 0 ; i < 8 ; i++) {
                nd = next[nd];
                nx = fish.x + move[nd][0];
                ny = fish.y + move[nd][1];
                if (nx >= 1 && nx <= 4 && ny >= 1 && ny <= 4 && !board[nx][ny].isSmell() && !shark.isShark(nx, ny)) {
                    board[nx][ny].fishList.add(new Fish(nx, ny, nd));
                    moveFlag = true;
                    break;
                }
            }

            if (!moveFlag) {
                board[fish.x][fish.y].fishList.add(new Fish(fish.x, fish.y, fish.direction));
            }

        }

    }
    public static Queue<Fish> copyFish() {
        Queue<Fish> copyFish = new LinkedList<>();
        for (int i = 1 ; i <= 4 ; i++) {
            for (int j = 1 ; j <= 4 ; j++) {
                for (Fish fish : board[i][j].fishList) {
                    copyFish.offer(fish);
                }
            }
        }

        return copyFish;
    }

    public static class Shark {
        int x;
        int y;

        public boolean isShark(int x, int y) {
            if (this.x == x && this.y == y) {
                return true;
            }
            return false;
        }

        int[][] moveArr;
        int max;
        boolean[][] visited;
        public void eat(int time) {
            moveArr = new int[3][2];
            max = Integer.MIN_VALUE;
            visited = new boolean[5][5];
            DFS(new int[3][2], board[x][y].size(), 0, x, y);


            for (int i = 0 ; i < 3 ; i++) {
                int eatX = moveArr[i][0];
                int eatY = moveArr[i][1];
                board[eatX][eatY].eat(time);
            }
            this.x = moveArr[2][0];
            this.y = moveArr[2][1];
        }


        int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        public void DFS(int[][] arr, int sum, int level, int x, int y) {
            if (level == 3) {
                if (max < sum) {
                    for (int i = 0 ; i < 3 ; i++) {
                        moveArr[i][0] = arr[i][0];
                        moveArr[i][1] = arr[i][1];
                    }
                    max = sum;
                }
                return;
            }

            for (int i = 0 ; i < 4 ; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];
                if (nx >= 1 && nx <= 4 && ny >= 1 && ny <= 4 ) {
                    arr[level] = new int[]{nx, ny};
                    if (visited[nx][ny]) {
                        DFS(arr, sum, level + 1, nx, ny);
                    } else {
                        visited[nx][ny] = true;
                        DFS(arr, sum + board[nx][ny].size(), level + 1, nx, ny);
                        visited[nx][ny] = false;
                    }


                }
            }
        }
    }

    public static class Block {
        List<Fish> fishList = new ArrayList<>();
        Set<Integer> smellList = new HashSet<>();

        public int size() {
            return fishList.size();
        }

        public void removeFishList() {
            fishList.clear();
        }

        public boolean isSmell() {
            return smellList.isEmpty() ? false : true;
        }

        public void eat(int time) {
            for (int i = 0 ; i < fishList.size() ; i++) {
                smellList.add(time);
            }
            fishList.clear();
        }

        public void smellDelete(int time) {
            smellList.remove(time);
        }
    }

    public static class Fish {
        int x;
        int y;
        int direction;

        public Fish(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
}