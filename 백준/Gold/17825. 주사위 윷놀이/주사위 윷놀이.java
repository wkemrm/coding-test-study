import java.util.*;
import java.io.*;

class Main {
    static int[] location = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24,
            25, 26,
            27, 28, 29,
            30, 31, 32};
    static int[][] move = {
            {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 21}, {7, 7}, {8, 8}, {9, 9}, {10, 10}, {11, 25}, {12, 12}, {13, 13}, {14, 14}, {15, 15}, {16, 27}, {17, 17}, {18, 18}, {19, 19},
            {20, 20}, {32, 32},
            {22, 22}, {23, 23}, {24, 24}, {30, 30},
            {26, 26}, {24, 24},
            {28, 28}, {29, 29}, {24, 24},
            {31, 31}, {20, 20}, {32, 32}
    };

    static int[] jumsu = {
            0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40,
            13, 16, 19, 25,
            22, 24,
            28, 27, 26,
            30, 35, 0
    };

    static int[] visited = new int[4];
    static int result = Integer.MIN_VALUE;
    static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[10];
        for (int i = 0 ; i < 10 ; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);

        System.out.println(result);
    }

    static void DFS(int n, int sum) {
        if (n == 10) {
            result = Math.max(result, sum);
            return;
        }

        int walk = input[n];

        for (int i = 0 ; i < 4 ; i++) {
            int before = visited[i];
            if (before == 32) continue;

            int curr = move[before][1];
            for (int k = 0 ; k < walk - 1 ; k++) {
                curr = move[curr][0];
            }

            boolean flag = false;
            for (int j = 0 ; j < 4 ; j++) {
                if (j != i && visited[j] == curr && visited[j] != 32) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;

            visited[i] = curr;
            DFS(n + 1, sum + jumsu[curr]);
            visited[i] = before;
        }
    }
}