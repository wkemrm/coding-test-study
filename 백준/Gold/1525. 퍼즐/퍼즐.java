import java.util.*;
import java.io.*;

class Main {
    static String result = "123456780";
    static int[] direction = {-3, 1, 3, -1};
    static String init = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0 ; i < 3 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 3 ; j++) {
                init += st.nextToken();
            }
        }


        solution();
    }

    public static void solution() {
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put(init, 0);
        q.offer(init);

        while(!q.isEmpty()) {
            String now = q.poll();
            int nowIndex = now.indexOf("0");

            if (now.equals(result)) {
                System.out.println(map.get(now));
                return;
            }

            for (int i = 0 ; i < 4 ; i++) {
                int nextIndex = nowIndex + direction[i];

                if (nextIndex < 0 || nextIndex > 8) continue;
                if (i == 1 && nowIndex % 3 == 2) continue;
                if (i == 3 && nowIndex % 3 == 0) continue;

                char nextIndexChar = now.charAt(nextIndex);
                String next = now.replace(nextIndexChar, 't');
                next = next.replace('0', nextIndexChar);
                next = next.replace('t', '0');

                if (!map.containsKey(next)) {
                    q.offer(next);
                    map.put(next, map.get(now) + 1);
                }
            }
        }

        System.out.println(-1);
    }
}