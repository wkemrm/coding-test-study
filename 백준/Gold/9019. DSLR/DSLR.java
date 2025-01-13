import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            BFS(before, after);
        }
    }

    public static void BFS(int before, int after) {
        boolean[] visited = new boolean[10000];
        String[] command = new String[10000];

        Arrays.fill(command, "");
        Queue<Integer> q = new LinkedList<>();
        q.offer(before);
        visited[before] = true;
        while(!q.isEmpty()) {
            Integer su = q.poll();
            int twice = twice(su);
            if (!visited[twice]) {
                visited[twice] = true;
                q.offer(twice);
                command[twice] = command[su] + "D";
            }

            int minus = minus(su);
            if (!visited[minus]) {
                visited[minus] = true;
                q.offer(minus);
                command[minus] = command[su] + "S";
            }

            int left = left(su);
            if (!visited[left]) {
                visited[left] = true;
                q.offer(left);
                command[left] = command[su] + "L";
            }

            int right = right(su);
            if (!visited[right]) {
                visited[right] = true;
                q.offer(right);
                command[right] = command[su] + "R";
            }
        }

        System.out.println(command[after]);
    }

    public static int twice(int su) {
        return (su * 2) % 10000;
    }

    public static int minus(int su) {
        if (su == 0) {
            return 9999;
        } else {
            return su - 1;
        }
    }

    public static int left(int su) {
        return (su % 1000) * 10 + su / 1000;
    }

    public static int right(int su) {
        return (su % 10) * 1000 + su / 10;
    }
}