import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[][] map;
    static List<Diagram> diagramList = new ArrayList<>();
    static int result = Integer.MIN_VALUE;
    
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
            }
        }
        
        boolean[][] diagram1 = new boolean[1][4];
        diagram1[0][0] = diagram1[0][1] = diagram1[0][2] = diagram1[0][3] = true;
        diagramList.add(new Diagram(diagram1));
        
        boolean[][] diagram2 = new boolean[2][2];
        diagram2[0][0] = diagram2[0][1] = diagram2[1][0] = diagram2[1][1] = true;
        diagramList.add(new Diagram(diagram2));
        
        boolean[][] diagram3 = new boolean[3][2];
        diagram3[0][0] = diagram3[1][0] = diagram3[2][0] = diagram3[2][1] = true;
        diagramList.add(new Diagram(diagram3));
        
        boolean[][] diagram4 = new boolean[3][2];
        diagram4[0][0] = diagram4[1][0] = diagram4[1][1] = diagram4[2][1] = true;
        diagramList.add(new Diagram(diagram4));
        
        boolean[][] diagram5 = new boolean[2][3];
        diagram5[0][0] = diagram5[0][1] = diagram5[0][2] = diagram5[1][1] = true;
        diagramList.add(new Diagram(diagram5));
        
        for (Diagram diagram : diagramList) {
            diagram.solution();
        }
        
        System.out.print(result);
    }
    
    static class Diagram {
        int r;
        int c;
        boolean[][] arr;
        
        public Diagram(boolean[][] arr) {
            this.arr = arr;
            this.r = arr.length;
            this.c = arr[0].length;
        }
        
        public void solution() {
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < m ; j++) {
                    if (i + r - 1 < n && j + c -1 < m) {
                        result = Math.max(result, cal(i, j));
                    }
                }
            }
            
            for (int k = 0 ; k < 3 ; k++) {
                spin();
                for (int i = 0 ; i < n ; i++) {
                    for (int j = 0 ; j < m ; j++) {
                        if (i + r - 1 < n && j + c -1 < m) {
                            result = Math.max(result, cal(i, j));
                        }
                    }
                }
            }
            
            spin();
            
            symmetry();
            
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < m ; j++) {
                    if (i + r - 1 < n && j + c -1 < m) {
                        result = Math.max(result, cal(i, j));
                    }
                }
            }
            
            for (int k = 0 ; k < 3 ; k++) {
                spin();
                for (int i = 0 ; i < n ; i++) {
                    for (int j = 0 ; j < m ; j++) {
                        if (i + r - 1 < n && j + c -1 < m) {
                            result = Math.max(result, cal(i, j));
                        }
                    }
                }
            }
        }
        
        public int cal(int x, int y) {
            int sum = 0;
            for (int i = 0 ; i < r ; i++) {
                for (int j = 0 ; j < c ; j++) {
                    if (arr[i][j]) {
                        sum += map[x + i][y + j];
                    }
                }
            }
            return sum;
        }
        
        public void spin() {
            boolean[][] next = new boolean[c][r];
            
            for (int i = 0 ; i < r ; i++) {
                for (int j = 0 ; j < c ; j++) {
                    next[j][r - i - 1] = arr[i][j];
                }
            }
            int temp = r;
            r = c;
            c = temp;
            
            arr = next;
        }
        
        public void symmetry() {
            boolean[][] next = new boolean[r][c];
            if (r > c) {
                for (int i = 0 ; i < r ; i++) {
                    for (int j = 0 ; j < c ; j++) {
                        next[i][c - j - 1] = arr[i][j];
                    }
                }
            } else {
                for (int i = 0 ; i < r ; i++) {
                    for (int j = 0 ; j < c ; j++) {
                        next[r - i - 1][j] = arr[i][j];
                    }
                }
            }
            arr = next;
        }
    }
}