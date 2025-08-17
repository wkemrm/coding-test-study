import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        Arrays.fill(arr, c);

        Box[] boxes = new Box[m];

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            boxes[i] = new Box();
            boxes[i].s = s;
            boxes[i].e = e;
            boxes[i].c = cost;
        }

        Arrays.sort(boxes);

        int answer = 0;
        for (int i = 0 ; i < m ; i++) {
            Box box = boxes[i];
            int max = box.c;
            for (int j = box.s ; j < box.e ; j++) {
                max = Math.min(max, arr[j]);
            }

            answer += max;
            for (int j = box.s ; j < box.e ; j++) {
                arr[j] -= max;
            }
        }

        System.out.println(answer);
    }

    static class Box implements Comparable<Box> {
        int s, e, c;


        @Override
        public int compareTo(Box o) {
            if (this.e != o.e) {
                return this.e - o.e;
            }
            return this.s - o.s;
        }
    }
}