import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int q;
    static int length;
    static int[][] map;
    static int[][] rotate;
    static int[] order;
    static int minus = 0;
    static boolean[][] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        length = (int)Math.pow(2, n);
        map = new int[length][length];

        order = new int[q];
        for (int i = 0 ; i < length ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < length ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < q ; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < q ; i++) {
            magic(order[i]);
        }
        int sum = 0;
        for (int i = 0 ; i < length ; i++) {
            for (int j = 0 ; j < length ; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);

        visited = new boolean[length][length];
        for (int i = 0 ; i < length ; i++) {
            for (int j = 0 ; j < length ; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    BFS(i, j);
                }
            }
        }
        System.out.println(result);
    }

    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void BFS(int startX, int startY) {
        int sum = 1;
        visited[startX][startY] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});

        while(!q.isEmpty()) {
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();

            for (int i = 0 ; i < 4 ; i++) {
                int nx = cx + direction[i][0];
                int ny = cy + direction[i][1];
                if (nx >= 0 && nx < length && ny >= 0 && ny < length && !visited[nx][ny] && map[nx][ny] > 0) {
                    sum++;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        result = Math.max(sum, result);

    }

    public static void magic(int l) {
        int gugan = (int)Math.pow(2, l);
        List<Block> blockList = new ArrayList<>();
        for (int i = 0 ; i < length ; i = i + gugan) {
            for (int j = 0 ; j < length ; j = j + gugan) {
                blockList.add(new Block(i, j, gugan));
            }
        }
        rotate = new int[length][length];
        for (int i = 0 ; i < blockList.size() ; i++) {
            blockList.get(i).spin();
        }

        map = rotate;
        List<int[]> list = new ArrayList<>();
        for (int i = 0 ; i < length ; i++) {
            for (int j = 0 ; j < length ; j++) {
                int count = 0;
                if (map[i][j] == 0) continue;
                if (i - 1 >= 0 && map[i - 1][j] > 0) {
                    count++;
                }
                if (i + 1 < length && map[i + 1][j] > 0) {
                    count++;
                }
                if (j - 1 >= 0 && map[i][j - 1] > 0) {
                    count++;
                }
                if (j + 1 < length && map[i][j + 1] > 0) {
                    count++;
                }

                if (count < 3) {
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0 ; i < list.size() ; i++) {
            minus++;
            int[] point = list.get(i);
            map[point[0]][point[1]]--;
        }
    }

    public static class Block {
        int sx;
        int sy;
        int l;
        public Block(int sx, int sy, int l) {
            this.sx = sx;
            this.sy = sy;
            this.l = l;
        }

        public void spin() {
            for (int i = 0 ; i < l ; i++) {
                for (int j = 0 ; j < l ; j++) {
                    int x = l - 1 - j + sx;
                    int y = i + sy;
                    rotate[i + sx][j + sy] = map[x][y];
                }
            }
        }
    }
}