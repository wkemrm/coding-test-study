import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[h][w];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < w ; i++) {
            int height = Integer.parseInt(st.nextToken());
            for (int j = 0 ; j < height ; j++) {
                graph[j][i] = true;
            }
        }

        int count = 0;

        for (int i = 0 ; i < h ; i++) {
            int prev = -1;
            for (int j = 0 ; j < w ; j++) {
                if (graph[i][j] == true) {
                    if (prev == -1) {
                        prev = j;
                    } else {
                        count += (j - prev - 1);
                        prev = j;
                    }
                }
            }
        }

        System.out.println(count);
    }
}