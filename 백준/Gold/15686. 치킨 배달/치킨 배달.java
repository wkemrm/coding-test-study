import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] map;
    static List<int[]> houseList = new ArrayList<>();
    static List<int[]> chickenList = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] open;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houseList.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chickenList.add(new int[]{i, j});
                }
            }
        }
        open = new boolean[chickenList.size()];
        DFS(0, 0);
        System.out.println(result);
    }
    public static void DFS(int start, int depth) {
        if (depth == m) {
            int sum = 0;
            for (int i = 0 ; i < houseList.size() ; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0 ; j < chickenList.size() ; j++) {
                    if (open[j]) {
                        int houseX = houseList.get(i)[0];
                        int houseY = houseList.get(i)[1];
                        int chickenX = chickenList.get(j)[0];
                        int chickenY = chickenList.get(j)[1];
                        min  = Math.min(min, Math.abs(houseX - chickenX) + Math.abs(houseY - chickenY));
                    }
                }
                sum += min;
            }

            result = Math.min(result, sum);
        } else {
            for (int i = start ; i < chickenList.size() ; i++) {
                open[i] = true;
                DFS(i + 1, depth + 1);
                open[i] = false;
            }
        }
    }
}