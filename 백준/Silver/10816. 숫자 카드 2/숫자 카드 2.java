import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < m ; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < m ; i++) {
            int find = arr2[i];

            int lt = 0;
            int rt = n;
            while(lt < rt) {
                int mid = (lt + rt) / 2;


                if (arr1[mid] >= find) {
                    rt = mid;
                } else {
                    lt = mid + 1;
                }
            }
            int start = lt;

            lt = 0;
            rt = n;

            while(lt < rt) {
                int mid = (lt + rt) / 2;

                if (arr1[mid] > find) {
                    rt = mid;
                } else {
                    lt = mid + 1;
                }
            }

            int end = lt;

            sb.append(end - start + " ");
        }

        System.out.println(sb.toString());
    }
}