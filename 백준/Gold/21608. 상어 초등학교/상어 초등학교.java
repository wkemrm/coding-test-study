import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] board;
    static HashMap<Integer, HashSet<Integer>> likeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0 ; i < n * n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            HashSet<Integer> like = new HashSet<>();
            for (int j = 0 ; j < 4 ; j++) {
                like.add(Integer.parseInt(st.nextToken()));
            }
            likeMap.put(now, like);
            setting(now, like);
        }

        int result = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                HashSet<Integer> like = likeMap.get(board[i][j]);
                int count = 0;
                for (int k = 0 ; k < 4 ; k++) {
                    int nx = i + move[k][0];
                    int ny = j + move[k][1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && like.contains(board[nx][ny])) {
                        count++;
                    }
                }

                if (count == 1) {
                    result += 1;
                } else if (count == 2) {
                    result += 10;
                } else if(count == 3) {
                    result += 100;
                } else if(count == 4) {
                    result += 1000;
                }
            }
        }

        System.out.println(result);
    }

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void setting(int now, HashSet<Integer> like) {
        // 1단계 모든 칸 횟수 구하기
        Queue<Block> pq = new PriorityQueue<>();
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (board[i][j] != 0) continue;

                int count = 0;
                for (int k = 0 ; k < 4 ; k++) {
                    int nx = i + move[k][0];
                    int ny = j + move[k][1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && like.contains(board[nx][ny])) {
                        count++;
                    }
                }
                pq.offer(new Block(i, j, count));
            }
        }

        int maxCount = pq.peek().count;

        List<int[]> possibility = new ArrayList<>();
        while (!pq.isEmpty()) {
            Block block = pq.poll();
            if (maxCount == block.count) {
                possibility.add(new int[]{block.x, block.y});
            }
        }

        if (possibility.size() == 1) {
            board[possibility.get(0)[0]][possibility.get(0)[1]] = now;
            return;
        }

        pq = new PriorityQueue<>();
        for (int i = 0 ; i < possibility.size() ; i++) {
            int x = possibility.get(i)[0];
            int y = possibility.get(i)[1];
            int count = 0;
            for (int k = 0 ; k < 4 ; k++) {
                int nx = x + move[k][0];
                int ny = y + move[k][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    count++;
                }
            }
            pq.offer(new Block(x, y, count));
        }

        int maxSlotCount = pq.peek().count;
        List<int[]> possibilitySlot = new ArrayList<>();
        while (!pq.isEmpty()) {
            Block block = pq.poll();
            if (maxSlotCount == block.count) {
                possibilitySlot.add(new int[]{block.x, block.y});
            }
        }

        if (possibilitySlot.size() == 1) {
            board[possibilitySlot.get(0)[0]][possibilitySlot.get(0)[1]] = now;
            return;
        }

        Collections.sort(possibilitySlot, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        board[possibilitySlot.get(0)[0]][possibilitySlot.get(0)[1]] = now;
    }

    public static class Block implements Comparable<Block>{
        int x;
        int y;
        int count;

        public Block(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int compareTo(Block block) {
            return block.count - this.count;
        }
    }


}