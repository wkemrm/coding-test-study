import java.util.*;
import java.io.*;

class Main {
    static ArrayList<Block> blockList = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int k = 0 ; k < 5 ; k++) {
            int[][] block = new int[5][5];
            for (int i = 0 ; i < 5 ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < 5 ; j++) {
                    block[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            blockList.add(new Block(block));
        }

        DFS(0);

        if (result != Integer.MAX_VALUE) {
            System.out.print(result);
        } else {
            System.out.print(-1);
        }
    }

    static boolean visited[] = new boolean[5];
    static Block[] blockArr = new Block[5];

    public static void DFS(int depth) {
        if (depth == 5) {
            for (int i = 0 ; i < 4 ; i++) {
                int sx = start[i][0];
                int sy = start[i][1];
                int ex = end[i][0];
                int ey = end[i][1];
                if (blockArr[0].arr[sx][sy] == 1 && blockArr[4].arr[ex][ey] == 1) {
                    BFS(i);
                }
            }
        } else {
            for (int k = 0 ; k < 5 ; k++) {
                if (!visited[k]) {
                    visited[k] = true;
                    Block block = blockList.get(k);
                    blockArr[depth] = block;
                    DFS(depth + 1);

                    for (int i = 0 ; i < 3 ; i++) {
                        block.spin();
                        blockArr[depth] = block;
                        DFS(depth + 1);
                    }
                    visited[k] = false;
                }
            }

        }
    }

    static int[][] start = {{0, 0}, {0, 4}, {4, 4}, {4, 0}};
    static int[][] end = {{4, 4}, {4, 0}, {0, 0}, {0, 4}};
    static int[][] direction = {{-1, 0, 0}, {0, 1, 0}, {1, 0, 0}, {0, -1, 0}, {0, 0, -1}, {0, 0, 1}};

    public static void BFS(int index) {
        int sx = start[index][0];
        int sy = start[index][1];
        int sz = 0;

        boolean[][][] visited = new boolean[5][5][5];
        int[][][] dis = new int[5][5][5];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sz, sx, sy});
        visited[sz][sx][sy] = true;

        while(!q.isEmpty()) {
            int cz = q.peek()[0];
            int cx = q.peek()[1];
            int cy = q.peek()[2];
            int cdis = dis[cz][cx][cy];
            q.poll();

            for (int i = 0 ; i < 6 ; i++) {
                int nz = cz + direction[i][0];
                int nx = cx + direction[i][1];
                int ny = cy + direction[i][2];

                if (nz >= 0 && nz < 5 && nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nz][nx][ny] && blockArr[nz].arr[nx][ny] == 1) {
                    visited[nz][nx][ny] = true;
                    dis[nz][nx][ny] = cdis + 1;
                    q.offer(new int[]{nz, nx, ny});
                }
            }

            int ex = end[index][0];
            int ey = end[index][1];

            if (dis[4][ex][ey] != 0) {
                result = Math.min(result, dis[4][ex][ey]);
            }
        }
    }

    static class Block {
        int[][] arr;

        public Block(int[][] arr) {
            this.arr = arr;
        }

        public void spin() {
            int[][] next = new int[5][5];
            for (int i = 0 ; i < 5 ; i++) {
                for (int j = 0 ; j < 5 ; j++) {
                    next[j][5 - i - 1] = arr[i][j];
                }
            }
            arr = next;
        }
    }
}