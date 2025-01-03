import java.util.*;
import java.io.*;
class Main {
    static int n, m;
    static String[] name;
    static int[] jumsu;

    public static String solution(int input) {
        int lt = 0;
        int rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (jumsu[mid] >= input) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return name[lt];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        name = new String[n];
        jumsu = new int[n];

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            jumsu[i] = Integer.parseInt(st.nextToken());
        }
        
        
        for (int i = 0 ; i < m ; i++) {
            
            sb.append(solution(Integer.parseInt(br.readLine()))).append("\n");
        }
        System.out.print(sb.toString());
    }
}