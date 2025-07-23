import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] arr;
    static int plus;
    static int minus;
    static int gob;
    static int nanum;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        gob = Integer.parseInt(st.nextToken());
        nanum = Integer.parseInt(st.nextToken());


        DFS(arr[0], 1, 0, 0, 0, 0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void DFS(int sum, int level, int plusCnt, int minusCnt, int gobCnt, int nanumCnt) {
        if (level == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        } else {
            if (plusCnt < plus) {
                DFS(sum + arr[level], level + 1, plusCnt + 1, minusCnt, gobCnt, nanumCnt);
            }
            if (minusCnt < minus) {
                DFS(sum - arr[level] , level + 1, plusCnt, minusCnt + 1, gobCnt, nanumCnt);
            }
            if (gobCnt < gob) {
                DFS(sum * arr[level], level + 1, plusCnt, minusCnt, gobCnt + 1, nanumCnt);
            }
            if (nanumCnt < nanum) {
                if (sum < 0) {
                    int nextSum = (sum * -1) / arr[level];
                    DFS(-nextSum, level + 1, plusCnt, minusCnt, gobCnt, nanumCnt + 1);
                } else {
                    DFS(sum / arr[level], level + 1, plusCnt, minusCnt, gobCnt, nanumCnt + 1);
                }
            }
        }
    }

}