import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int k;
    static int l;
    static int[][] graph;
    static List<int[]> snake = new ArrayList<>();
    static Map<Integer, String> timeMove = new HashMap<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        k = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < k ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
        }

        l = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < l ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String move = st.nextToken();
            timeMove.put(time, move);
        }

        int cx = 1;
        int cy = 1;
        int move = 1;
        int time = 0;
        snake.add(new int[]{cx, cy});
        while (true) {
            time++;
            cx += dx[move];
            cy += dy[move];

            if (isFinish(cx, cy)) {
                break;
            }

            if (graph[cx][cy] == 1) {
                graph[cx][cy] = 0;
                snake.add(new int[]{cx, cy});
            } else {
                snake.add(new int[]{cx, cy});
                snake.remove(0);
            }

            if (timeMove.containsKey(time)) {
                String direction = timeMove.get(time);
                if (direction.equals("L")) {
                    move = leftMove(move);
                } else {
                    move = rightMove(move);
                }
            }
        }

        System.out.print(time);
    }

    public static int leftMove(int move) {
        if (move == 0) {
            return 3;
        } else {
            return move - 1;
        }
    }

    public static int rightMove(int move) {
        if (move == 3) {
            return 0;
        } else {
            return move + 1;
        }
    }

    public static boolean isFinish(int nx, int ny) {
        if (nx < 1 || nx > n || ny < 1 || ny > n) {
            return true;
        }

        for (int[] arr : snake) {
            if (arr[0] == nx && arr[1] == ny) {
                return true;
            }
        }

        return false;
    }
}