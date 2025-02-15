import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int l;
    static List<Bridge> bridgeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < n ; i++) {
            int[] arr = new int[n];
            for (int j = 0 ; j < n ; j++) {
                arr[j] = map[i][j];
            }
            bridgeList.add(new Bridge(arr));
        }

        for (int i = 0 ; i < n ; i++) {
            int[] arr = new int[n];
            for (int j = 0 ; j < n ; j++) {
                arr[j] = map[j][i];
            }
            bridgeList.add(new Bridge(arr));
        }

        int result = 0;
        for (Bridge bridge : bridgeList) {
            bridge.solution();
            if (bridge.flag) result++;
        }

        System.out.print(result);
    }


    static class Bridge {
        int[] arr;
        boolean[] visited;
        boolean flag;

        public Bridge (int[] arr) {
            this.arr = arr;
            visited = new boolean[n];
            flag = true;
        }

        public void solution() {
            int i = 1;
            while (i < n) {
                if (!flag) break;
                int before = arr[i - 1];
                int now = arr[i];

                if (before != now) {
                    if (before < now) {
                        // now 기준으로 왼쪽으로 l 만큼 체크
                        int start = i - l;
                        int end = i - 1;
                        check(start, end, now);
                    } else {
                        // before 기준으로 오른쪽으로 l만큼 체크
                        int start = i - 1 + 1;
                        int end = i - 1 + l;
                        check(start, end, before);
                    }
                }

                i++;
            }
        }

        public void check(int start, int end, int num) {
            int count = 0;
            for (int i = start ; i <= end ; i++) {
                if (i >= 0 && i < n) {
                    if (Math.abs(num - arr[i]) != 1 || visited[i]) {
                        flag = false;
                        break;
                    } else {
                        visited[i] = true;
                        count++;
                    }
                }
            }

            if (count != l) {
                flag = false;
            }
        }
    }
}