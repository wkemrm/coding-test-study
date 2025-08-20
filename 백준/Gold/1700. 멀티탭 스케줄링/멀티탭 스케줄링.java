import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[k + 1];
        int[] arr = new int[k];
        int flugCount = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < k ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0 ; i < k ; i++) {
            int now = arr[i];

            if (visited[now]) continue;

            if (flugCount < n) {
                flugCount++;
                visited[now] = true;
            } else {
                // 사용되는지 여부 판단
                // 모두 사용되는 경우 가장 나중에 사용되는거 뽑기
                // 사용되지 않는 코드 뽑기
                Set<Integer> use = new HashSet<>();
                for (int j = 1 ; j <= k ; j++) {
                    if (visited[j]) use.add(j);
                }

                Map<Integer, Integer> nextUse = new HashMap<>();
                for (int j = i + 1 ; j < k ; j++) {
                    if (use.contains(arr[j])) {
                        if (nextUse.containsKey(arr[j])) continue;

                        nextUse.put(arr[j], j);
                    }
                }

                // 모두 사용되는지 체크
                if (use.size() != nextUse.size()) {
                    for (int flug : use) {
                        if (!nextUse.containsKey(flug)) {
                            visited[flug] = false;
                            break;
                        }
                    }
                } else {
                    int last = 0;
                    int lastFlug = 0;
                    for (Map.Entry<Integer, Integer> entry : nextUse.entrySet()) {
                        if (last < entry.getValue()) {
                            last = entry.getValue();
                            lastFlug = entry.getKey();                        }
                    }
                    
                    visited[lastFlug] = false;
                }

                visited[now] = true;
                result++;
            }


        }

        System.out.print(result);
    }
}