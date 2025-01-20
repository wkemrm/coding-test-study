import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int r;
    static int c;
    static char[][] graph;
    static Queue<int[]> water = new LinkedList<>();
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int resultX;
    static int resultY;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph = new char[r][c];

        for (int i = 0 ; i < r ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < c ; j++) {
                char ic = input.charAt(j);
                graph[i][j] = ic;

                if (ic == 'S') {
                    q.offer(new int[]{i, j, 0});
                }
                else if(ic == '*') {
                    water.offer(new int[]{i, j});
                } else if (ic == 'D') {
                    resultX = i;
                    resultY = j;
                }
            }
        }

        BFS();

        if (result == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            int waterSize = water.size();
            for (int len = 0 ; len < waterSize ; len++) {
                int cwx = water.peek()[0];
                int cwy = water.peek()[1];
                water.poll();

                for (int i = 0 ; i < 4 ; i++) {
                    int nwx = cwx + dx[i];
                    int nwy = cwy + dy[i];

                    if (nwx >= 0 && nwx < r && nwy >= 0 && nwy < c && graph[nwx][nwy] == '.') {
                        graph[nwx][nwy] = '*';
                        water.offer(new int[]{nwx, nwy});
                    }
                }
            }

            int sSize = q.size();
            for (int len = 0 ; len < sSize ; len++) {
                int csx = q.peek()[0];
                int csy = q.peek()[1];
                int cstime = q.peek()[2];
                q.poll();

                for (int i = 0 ; i < 4 ; i++) {
                    int nsx = csx + dx[i];
                    int nsy = csy + dy[i];

                    if (nsx >= 0 && nsx < r && nsy >= 0 && nsy < c) {
                        if (graph[nsx][nsy] == 'D') {
                            result = Math.min(result, cstime + 1);
                            return;
                        } else if (graph[nsx][nsy] == '.') {
                            graph[nsx][nsy] = 'S';
                            q.offer(new int[]{nsx, nsy, cstime + 1});
                        }
                    }
                }
            }
        }
    }
}