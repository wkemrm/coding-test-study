import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sortArr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            arr[i] = sortArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sortArr);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        
        for (int i = 0 ; i < n ; i++) {
            if (!map.containsKey(sortArr[i])) {
                map.put(sortArr[i], rank);
                rank++;
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0 ; i < n ; i++) {
            sb.append(map.get(arr[i]) + " ");
        }
        
        System.out.print(sb.toString());
    }
}