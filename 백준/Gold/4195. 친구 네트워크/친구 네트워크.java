import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Map<String, Integer> social = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            arr = new int[200001];
            count = new int[200001];
            int index = 1;
            for (int i = 0 ; i < n ; i++) {
                String[] friends = br.readLine().split(" ");
                if (!social.containsKey(friends[0])) {
                    social.put(friends[0], index);
                    arr[index] = index;
                    count[index] = 1;
                    index++;
                }
                if (!social.containsKey(friends[1])) {
                    social.put(friends[1], index);
                    arr[index] = index;
                    count[index] = 1;
                    index++;
                }

                union(social.get(friends[0]), social.get(friends[1]));
                System.out.println(count[find(social.get(friends[0]))]);
            }

        }
    }

    public static int find(int num) {
        if (arr[num] != num) {
            return arr[num] = find(arr[num]);
        }

        return arr[num];
    }

    public static void union(int first, int second) {
        int root1 = find(first);
        int root2 = find(second);

        if (root1 == root2) {
            return;
        }
        arr[root2] = root1;
        count[root1] += count[root2];
        count[root2] = 0;
    }
}