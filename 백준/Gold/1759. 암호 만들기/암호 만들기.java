import java.util.*;
import java.io.*;

class Main {
    static int l;
    static int c;
    static char[] cArr;
    static boolean[] visited;

    public static void DFS(String result, char cur) {
        if (result.length() == l) {
            int consonant = 0;
            int gather = 0;
            char [] arr = result.toCharArray();
            for (int i = 0 ; i < l ; i++) {
                if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                    gather++;
                } else {
                    consonant++;
                }
            }
            if (consonant >= 2 && gather >= 1) {
                System.out.println(result);
            }
        } else {
            for (int i = 0 ; i < c ; i++) {
                if (!visited[i] && cur < cArr[i]) {
                    visited[i] = true;
                    DFS(result + cArr[i], cArr[i]);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cArr = new char[c];
        visited = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < c ; i++) {
            cArr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(cArr);

        for (int i = 0 ; i < c ; i++) {
            visited[i] = true;
            DFS(String.valueOf(cArr[i]), cArr[i]);
            visited[i] = false;
        }
    }
}