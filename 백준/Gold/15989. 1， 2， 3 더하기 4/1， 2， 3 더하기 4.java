import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[][] DP = new int[10001][4];
        DP[1][1] = 1;
        DP[1][2] = 0;
        DP[1][3] = 0;
        
        DP[2][1] = 1;
        DP[2][2] = 1;
        DP[2][3] = 0;
        
        DP[3][1] = 1;
        DP[3][2] = 1;
        DP[3][3] = 1;
        
        for (int i = 4 ; i <= 10000 ; i++) {
            DP[i][1] = DP[i -1][1];
            DP[i][2] = DP[i - 2][2] + DP[i - 2][1];
            DP[i][3] = DP[i - 3][1] + DP[i - 3][2] + DP[i - 3][3];
        }
        
        for (int i = 0 ; i < testCase ; i++) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(DP[input][1] + DP[input][2] + DP[input][3]);
        }
    } 
}