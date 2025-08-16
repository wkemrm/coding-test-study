import java.util.*;
import java.io.*;

class Main {
    // 기프티콘 한번 연장할 때 마다 기한이 30일씩 늘어남
    // 기한 연장 최소화
    // 남은 기프티콘 중 기한이 가장 적게 남은 기프티콘만 사용 가능
    // 쓰는 계획, 남은 기간 순 정렬
    // i번째 남은 기간보다 i번쨰 사용 계획이 큰 경우 연장 + 1;
    // i보다 아래에 있는 것들 중 현재 i의 남은 기간 보다 적게 남은 경우 연장 + 1
    // 반복
    static int r;
    static int c;
    static char[][] board;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        visited = new boolean[r][c];

        for(int i = 0 ; i < r ; i++) {
            char[] input = br.readLine().toCharArray();
            board[i] = input;
        }

        for (int i = 0 ; i < r ; i++) {
            visited[i][0] = true;
            if (DFS(i, 0)) answer++;
        }

        System.out.println(answer);
    }

    static int[] move = {-1, 0, 1};

    public static boolean DFS(int x, int y) {
        if (y == c - 1) {
            return true;
        }

        for (int i = 0 ; i < 3 ; i++) {
            int nx = x + move[i];
            int ny = y + 1;
            if (nx >= 0 && nx < r && ny < c && !visited[nx][ny] && board[nx][ny] == '.') {
                visited[nx][ny] = true;
                if (DFS(nx, ny)) {
                    return true;
                }
            }
        }

        return false;
    }
}