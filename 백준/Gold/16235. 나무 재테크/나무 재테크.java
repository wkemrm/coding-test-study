import java.util.*;
import java.io.*;

class Wood implements Comparable<Wood>{
    int x;
    int y;
    int age;

    public Wood(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }

    public int compareTo(Wood wood) {
        return this.age - wood.age;
    }
}

class Main {
    static int n;
    static int m;
    static int k;
    static int[][] a;
    static int[][] map;
    static PriorityQueue<Wood> live = new PriorityQueue<>();
    static Queue<Wood> dead = new LinkedList<>();
    static Queue<Wood> breeding = new LinkedList<>();
    public static void main(String[] LinkedList) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 봄, 여름, 가을, 겨울로 나누어야 할듯
        // 봄에는 어린 나이부터 나이만큼 양분을 먹고 나이가 1증가, 못먹으면 죽음
        // 여름에는 죽은 나무의 나이를 2로 나눈값만큼 양분 추가
        // 그러면 봄에 죽은 나무의 나이와 위치를 저장할 필요가 있을듯
        // 나무 (x, y, age)
        // 산 나무는 PriorityQueue로 죽은 나무는 그냥 Queue로 해도 될듯 5배인거 Queue 만들고
        // 가을 번식은 5인거 BFS로 번식
        // 겨울은 for문으로 증가
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n + 1][n + 1];
        map = new int[n + 1][n + 1];
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                map[i][j] = 5;
            }
        }

        for (int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            live.offer(new Wood(x, y, age));
        }

        for (int i = 1 ; i <= k ; i++) {
            spring();
            summer();
            autumn();
            winter();
        }

        System.out.print(live.size());
    }

    public static void spring() {
        PriorityQueue<Wood> next = new PriorityQueue<Wood>();
        while (!live.isEmpty()) {
            Wood now = live.poll();

            if (map[now.x][now.y] >= now.age) {
                map[now.x][now.y] -= now.age;
                if ((now.age + 1) % 5 == 0) {
                    breeding.offer(new Wood(now.x, now.y, now.age + 1));
                }
                next.offer(new Wood(now.x, now.y, now.age + 1));
            } else {
                dead.offer(new Wood(now.x, now.y, now.age));
            }
        }
        live = next;
    }

    public static void summer() {
        while(!dead.isEmpty()) {
            Wood now = dead.poll();
            map[now.x][now.y] += (now.age / 2);
        }
    }

    static int[][] direction =
            {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public static void autumn() {
        while(!breeding.isEmpty()) {
            Wood now = breeding.poll();
            int cx = now.x;
            int cy = now.y;
            for (int i = 0 ; i < 8 ; i++) {
                int nx = cx + direction[i][0];
                int ny = cy + direction[i][1];
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                    live.offer(new Wood(nx, ny, 1));
                }
            }
        }
    }

    public static void winter() {
        for (int i = 1; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                map[i][j] += a[i][j];
            }
        }
    }
}