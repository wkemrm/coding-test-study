import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> nSet = new HashSet<>();
        for (int i = 0 ; i < n ; i++) {
            nSet.add(br.readLine());
        }
        List<String> result = new ArrayList<>();
        for (int i = 0 ; i < m ; i++) {
            String input = br.readLine();
            if (nSet.contains(input)) result.add(input);
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int i = 0 ; i < result.size() ; i++) {
            System.out.println(result.get(i));
        }
    }
}