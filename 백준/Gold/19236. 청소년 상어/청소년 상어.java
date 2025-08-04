import java.io.*;
import java.util.*;

class Main {
    static int[][] board = new int[4][4];
    static int[][] move = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Fish> fishList = new ArrayList<>();

        for (int i = 0 ; i < 4 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 4 ; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                board[i][j] = num;
                fishList.add(new Fish(i, j, num, dir, true));
            }
        }

        Collections.sort(fishList);
        Fish fish = fishList.get(board[0][0] - 1);
        Shark shark = new Shark(0,  0, fish.d, fish.num);
        board[0][0] = -1;
        fish.isAlive = false;

        DFS(shark, board, fishList);
        System.out.println(result);
    }


    public static void DFS(Shark shark, int[][] board, List<Fish> fishList) {
        if (result < shark.sum) {
            result = shark.sum;
        }

        // 이동
        fishList.forEach(fish -> move(fish, board, fishList));

        for (int dist = 1 ; dist < 4 ; dist++) {

            int nx = shark.x + move[shark.d][0] * dist;
            int ny = shark.y + move[shark.d][1] * dist;

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && board[nx][ny] > 0) {
                int[][] copyBoard = copyBoard(board);
                List<Fish> copyFishList = copyFishList(fishList);

                copyBoard[shark.x][shark.y] = 0;
                Fish fish = copyFishList.get(board[nx][ny] - 1);
                fish.isAlive = false;
                copyBoard[fish.x][fish.y] = -1;

                Shark nextShark = new Shark(fish.x, fish.y, fish.d, shark.sum + fish.num);
                DFS(nextShark, copyBoard, copyFishList);
            }
        }

    }

    public static int[][] copyBoard(int[][] board) {
        int[][] copy = new int[4][4];

        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0 ; j < 4 ; j++) {
                copy[i][j] = board[i][j];
            }
        }

        return copy;
    }

    public static List<Fish> copyFishList(List<Fish> fishList) {
        List<Fish> copyFishList = new ArrayList<>();

        for (int i = 0 ; i < fishList.size() ; i++) {
            Fish fish = fishList.get(i);
            copyFishList.add(new Fish(fish.x, fish.y, fish.num, fish.d, fish.isAlive));
        }
        return copyFishList;
    }

    public static void move(Fish fish, int[][] board, List<Fish> fishList) {
        if (!fish.isAlive) return;

        for (int i = 0 ; i < 8 ; i++) {
            int nextD = (fish.d + i) % 8;
            int nx = fish.x + move[nextD][0];
            int ny = fish.y + move[nextD][1];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && board[nx][ny] > -1) {
                board[fish.x][fish.y] = 0;

                if (board[nx][ny] == 0) {
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    Fish swapFish = fishList.get(board[nx][ny] - 1);

                    swapFish.x = fish.x;
                    swapFish.y = fish.y;
                    board[fish.x][fish.y] = swapFish.num;

                    fish.x = nx;
                    fish.y = ny;
                }

                board[nx][ny] = fish.num;
                fish.d = nextD;

                return;
            }
        }
    }

    public static class Shark {
        int x;
        int y;
        int d;
        int sum;
        public Shark(int x, int y, int d, int sum) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.sum = sum;
        }
    }

    public static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int num;
        int d;
        boolean isAlive;

        public Fish(int x, int y, int num, int d, boolean isAlive) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.d = d;
            this.isAlive = isAlive;
        }

        public int compareTo(Fish fish) {
            return this.num - fish.num;
        }
    }
}