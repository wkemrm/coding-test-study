import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int l;
    static int r;
    static int[][] map;
    static int[][] dis;
    static boolean[][] visited;
    static boolean flag = false;
    static Map<Integer, Integer> people;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        
        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int result = 0;
        do {
            flag = false;
            int count = 1;
            dis = new int[n][n];
            visited = new boolean[n][n];
            people = new HashMap<Integer, Integer>();
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    if (!visited[i][j]) {
                        BFS(i, j, count);
                        count++;
                    }
                }
            }
            
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    map[i][j] = people.get(dis[i][j]);
                }
            }
            
            if (flag) {
            	result++;
            }
        } while(flag);
        
        System.out.print(result);
        
    }
    
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, - 1}};
    public static void BFS(int x, int y, int count) {
        Queue<int[]> q = new LinkedList<int[]>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        people.put(count, map[x][y]);
        dis[x][y] = count;
        int total = 1;
        
        while(!q.isEmpty()) {
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();
            
            for (int i = 0 ; i < 4 ; i++) {
                int nx = cx + direction[i][0];
                int ny = cy + direction[i][1];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                    if (diff >= l && diff <= r) {
                        visited[nx][ny] = true;
                        people.put(count, people.getOrDefault(count, 0) + map[nx][ny]);
                        q.offer(new int[]{nx, ny});
                        total++;
                        dis[nx][ny] = count;
                        flag = true;
                    }
                }
            }
        }
        
        people.put(count, people.get(count) / total);
    }
}