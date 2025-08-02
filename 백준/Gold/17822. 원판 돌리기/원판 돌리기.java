import java.net.Inet4Address;
import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int t;
    static int[][] arr;
    static int[] leftSpin;
    static int[] rightSpin;
    static boolean[][] remove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m];
        leftSpin = new int[m];
        leftSpin[0] = m - 1;
        for (int i = 1 ; i < m ; i++) {
            leftSpin[i] = i - 1;
        }

        rightSpin = new int[m];
        for (int i = 0 ; i < m - 1 ; i++) {
            rightSpin[i] = i + 1;
        }
        rightSpin[m - 1] = 0;

        for (int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < t ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 스핀
            spin(x, k, d);

            boolean isRemove = removeCheck();

            if (isRemove) {
                // remove 배열 true인거 모두 지우기
                remove();
            } else {
                // 평균 구하고 큰수 1 뺴기 작은수 1더하기
                calcul();
            }
        }

        System.out.println(sum());
    }

    public static int sum() {
        int sum = 0;
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (arr[i][j] != -1) {
                    sum += arr[i][j];
                }
            }
        }

        return sum;
    }
    public static void calcul() {
        int sum = 0;
        int count = 0;
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (arr[i][j] != -1) {
                    sum += arr[i][j];
                    count++;
                }
            }
        }

        double avg = (double) sum / count;

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (arr[i][j] == -1) continue;
                if (arr[i][j] < avg) {
                    arr[i][j]++;
                } else if (arr[i][j] > avg){
                    arr[i][j]--;
                }
            }
        }
    }

    public static void remove() {
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (remove[i][j]) {
                    arr[i][j] = -1;
                }
            }
        }
    }

    public static boolean removeCheck() {
        boolean isRemove = false;
        remove = new boolean[n + 1][m];

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (upCheck(i, j)) {
                    isRemove = true;
                }
                if (downCheck(i, j)) {
                    isRemove = true;
                }
                if (leftCheck(i, j)) {
                    isRemove = true;
                }
                if (rightCheck(i, j)) {
                    isRemove = true;
                }
            }
        }

        return isRemove;
    }

    public static void spin(int x, int k, int d) {
        for (int j = x ; j <= n ; j = j + x) {
            for (int spin = 0 ; spin < k ; spin++) {
                if (d == 0) {
                    rightSpin(j);
                } else {
                    leftSpin(j);
                }
            }
        }
    }

    public static void leftSpin(int target) {
        int[] tmp = new int[m];

        for (int i = 0 ; i < leftSpin.length ; i++) {
            tmp[leftSpin[i]] = arr[target][i];
        }

        arr[target] = tmp;
    }

    public static void rightSpin(int target) {
        int[] tmp = new int[m];
        for (int i = 0 ; i < rightSpin.length ; i++) {
            tmp[rightSpin[i]] = arr[target][i];
        }

        arr[target] = tmp;
    }

    public static boolean upCheck(int x, int y) {
        if (x == n) return false;

        if (arr[x][y] != -1 && arr[x + 1][y] != -1 && arr[x][y] == arr[x + 1][y]) {
            remove[x][y] = true;
            remove[x + 1][y] = true;
            return true;
        }

        return false;
    }

    public static boolean downCheck(int x, int y) {
        if (x == 1) return false;

        if (arr[x][y] != -1 && arr[x - 1][y] != -1 && arr[x][y] == arr[x - 1][y]) {
            remove[x][y] = true;
            remove[x - 1][y] = true;
            return true;
        }

        return false;
    }

    public static boolean leftCheck(int x, int y) {
        if (y == 0) {
            if (arr[x][y] != -1 && arr[x][m - 1] != - 1 && arr[x][y] == arr[x][m - 1]) {
                remove[x][y] = true;
                remove[x][m - 1] = true;
                return true;
            }
        } else if (arr[x][y] != -1 && arr[x][y - 1] != -1 && arr[x][y] == arr[x][y - 1]){
            remove[x][y] = true;
            remove[x][y - 1] = true;
            return true;
        }
        return false;
    }

    public static boolean rightCheck(int x, int y) {
        if (y == m - 1) {
            if (arr[x][y] != -1 && arr[x][0] != -1 && arr[x][y] == arr[x][0]) {
                remove[x][y] = true;
                remove[x][0] = true;
                return true;
            }

        } else if (arr[x][y] != -1 && arr[x][y + 1] != -1 && arr[x][y] == arr[x][y + 1]) {
            remove[x][y] = true;
            remove[x][y + 1] = true;
            return true;
        }

        return false;
    }
}