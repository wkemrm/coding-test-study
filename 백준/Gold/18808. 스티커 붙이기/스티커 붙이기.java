import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static boolean[][] visited;
    static int k;
    static List<Sticker> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];

        for (int i = 0 ; i < k ; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] arr = new int[r][c];
            for (int x = 0 ; x < r ; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0 ; y < c ; y++) {
                    arr[x][y] = Integer.parseInt(st.nextToken());
                }
            }
            list.add(new Sticker(r, c, arr));
        }

        for (int i = 0 ; i < list.size() ; i++) {
            list.get(i).start();
        }

        int result = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (visited[i][j]) result++;
            }
        }

        System.out.print(result);
    }

    static class Sticker {
        int r;
        int c;
        int[][] arr;

        public Sticker(int r, int c, int[][] arr) {
            this.r = r;
            this.c = c;
            this.arr = arr;
        }

        public void start() {
            // 위치 파악
            boolean temp = false;
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < m ; j++) {
                    if (temp) break;
                    if (i + r - 1 >= n || j + c - 1 >= m) continue;

                    if (attach(i, j)) {
                        temp = true;
                    }
                }
            }

            for (int k = 0 ; k < 3 ; k++) {
                if (!temp) {
                    spin();
                    for (int i = 0 ; i < n ; i++) {
                        for (int j = 0 ; j < m ; j++) {
                            if (temp) break;
                            if (i + r - 1 >= n || j + c - 1 >= m) continue;

                            if (attach(i, j)) {
                                temp = true;
                            }
                        }
                    }
                }
            }
        }

        public boolean attach(int x, int y) {
            boolean possible = true;
            for (int i = 0 ; i < r ; i++) {
                for (int j = 0 ; j < c ; j++) {
                    if (arr[i][j] == 1 && visited[x + i][y + j]) {
                        possible = false;
                        break;
                    }
                }
            }

            if (!possible) return false;

            for (int i = 0 ; i < r ; i++) {
                for (int j = 0 ; j < c ; j++) {
                    if (arr[i][j] == 1) visited[x + i][y + j] = true;

                }
            }
            return true;
        }

        public void spin() {
            int[][] next = new int[c][r];
            for (int i = 0 ; i < r ; i++) {
                for (int j = 0 ; j < c ; j++) {
                    next[j][r - 1 - i] = arr[i][j];
                }
            }
            int temp = c;
            this.c = r;
            this.r = temp;
            this.arr = next;
        }
    }
}