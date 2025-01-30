import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static List<Cctv> cctvLocation = new ArrayList<>();
    static int[][] map;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] >= 1 && map[i][j] <= 5) {
                   cctvLocation.add(new Cctv(i, j, map[i][j]));
                }
            }
        }

        DFS(0);

        System.out.println(result);
    }

    static class Cctv {
        int x;
        int y;
        int num;

        public Cctv(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        public List<char[]> getDirection() {
            switch(num) {
                case 1 : {
                    return List.of(new char[]{'R'}, new char[]{'D'}, new char[]{'L'}, new char[]{'U'});
                }
                case 2: {
                    return List.of(new char[]{'L', 'R'}, new char[]{'U', 'D'});
                }
                case 3 : {
                    return List.of(new char[]{'U', 'R'}, new char[]{'R', 'D'}, new char[]{'D', 'L'}, new char[]{'L', 'U'});
                }
                case 4 : {
                    return List.of(new char[]{'L', 'U', 'R'}, new char[]{'U', 'R', 'D'}, new char[]{'R', 'D', 'L'}, new char[]{'D', 'L', 'U'});
                }
                case 5 : {
                    return List.of(new char[]{'L', 'U', 'R', 'D'});
                }
                default: {

                }
            }
            return null;
        }
    }

    static List<char[]> selectCctv = new ArrayList<>();

    public static void DFS(int depth) {
        if (depth == cctvLocation.size()) {
            cal();
        } else {
            Cctv cctv = cctvLocation.get(depth);
            for (char[] direction : cctv.getDirection()) {
                selectCctv.add(direction);
                DFS(depth + 1);
                selectCctv.remove(selectCctv.size() - 1);
            }
        }
    }

    public static void cal() {
        int[][] copyMap = new int[n][m];

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int j = 0 ; j < selectCctv.size() ; j++) {
            Cctv cctv = cctvLocation.get(j);
            for (int i = 0 ; i < selectCctv.get(j).length ; i++) {
                switch (selectCctv.get(j)[i]) {
                    case 'L' : {
                        for (int target = cctv.y - 1 ; target >= 0 ; target--) {
                            if (copyMap[cctv.x][target] == 6) break;
                            copyMap[cctv.x][target] = -1;
                        }
                        break;
                    }
                    case 'R' : {
                        for (int target = cctv.y + 1 ; target < m ; target++) {
                            if (copyMap[cctv.x][target] == 6) break;;
                            copyMap[cctv.x][target] = -1;
                        }
                        break;
                    }
                    case 'U' : {
                        for (int target = cctv.x - 1 ; target >= 0 ; target--) {
                            if (copyMap[target][cctv.y] == 6) break;
                            copyMap[target][cctv.y] = -1;
                        }
                        break;
                    }
                    case 'D' : {
                        for (int target = cctv.x + 1 ; target < n ; target++) {
                            if (copyMap[target][cctv.y] == 6) break;
                            copyMap[target][cctv.y] = -1;
                        }
                        break;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (copyMap[i][j] == 0) cnt++;
            }
        }

        result = Math.min(result, cnt);
    }
}