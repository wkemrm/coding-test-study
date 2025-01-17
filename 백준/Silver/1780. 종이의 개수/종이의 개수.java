import java.util.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int minusCount = 0;
    static int zeroCount = 0;
    static int plusCount = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        solution(0, 0, n);
        System.out.println(minusCount);
        System.out.println(zeroCount);
        System.out.println(plusCount);
    }
    
    public static void solution(int x, int y, int size) {
        if (check(x, y, size)) {
            if (graph[x][y] == -1) {
                minusCount++;
                return;
            } else if (graph[x][y] == 0) {
                zeroCount++;
                return;
            } else if (graph[x][y] == 1) {
                plusCount++;
                return;
            }
        }
        
        int nextSize = size / 3;
        solution(x, y, nextSize);
        solution(x, y + nextSize, nextSize);
        solution(x, y + (2 * nextSize), nextSize);
        
        solution(x + nextSize, y, nextSize);
        solution(x + nextSize, y + nextSize, nextSize);
        solution(x + nextSize, y + (2 * nextSize), nextSize);
        
        solution(x + (2 * nextSize), y, nextSize);
        solution(x + (2 * nextSize), y + nextSize, nextSize);
        solution(x + (2 * nextSize), y + (2 * nextSize), nextSize);
    }
    
    public static boolean check(int x, int y, int size) {
        int color = graph[x][y];
        
        for (int i = x ; i < x + size ; i++) {
            for (int j = y ; j < y + size ; j++) {
                if (color != graph[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}