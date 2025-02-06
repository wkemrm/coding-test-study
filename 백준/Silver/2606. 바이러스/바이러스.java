import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        for (int i = 1 ; i <= n ; i++) {
            arr[i] = i;
        }

        for (int i = 0 ; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int cnt = 0;
        for (int i = 2 ; i <= n ; i++) {
            if (find(i) == 1) cnt++;
        }

        System.out.print(cnt);
    }

    public static int find(int a) {
        if (arr[a] == a) return a;

        return find(arr[a]);
    }

    public static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA == findB) return;

        if (findA < findB) {
            arr[findB] = findA;
        } else {
            arr[findA] = findB;
        }
    }
}