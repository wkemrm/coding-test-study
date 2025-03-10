import java.util.*;
import java.io.*;
// 흰색일 경우 그 칸로 이동하고 칸에 말이 이미 존재하는 경우a번 말을 올려놓음
// a번 말 위에 다른 말이 있는 경우 a번 말과 위에 있는 모든 말이 이동
// 빨간색인 경우 기존 말의 순서를 반대로 바꾸고 다음 칸 위에 올림
// 파란색인 경우 이동방향을 반대로하고 한 칸 이동, 파란색인 경우에는 이동 x 방향만 바꿈
// 체스판을 벗어나는 경우 파란색과 같다.
// 말이 4개 이상 쌓이는 경우 끝
// 1000회 이상 인 경우 -1 출력
// 1부터 k 까지 뽑으려면 현재 위치를 확인할 수 있는 배열 필요
// map을 Board[][]으로 관리 board 안에는 stack<Integer>과 색깔
// 다음 블록의 색깔을 확인할 수 있는 메서드 필요
// 이동 메서드 필요
// 스택 뒤집는 메서드 필요
//

public class Main {
    static int n;
    static int k;
    static Board[][] board;
    static List<Chess> order = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new Board[n + 1][n + 1];

        for (int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                board[i][j] = new Board(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1 ; i <= k ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            Chess chess = new Chess(i, x, y, direction);
            order.add(chess);
            board[x][y].push(chess);
        }

        boolean flag = false;
        int result = 0;
        for (int i = 1 ; i <= 1000 ; i++) {
            flag = turn();
            if (flag) {
                result = i;
                break;
            }
        }

        if (flag) {
            System.out.print(result);
        } else {
            System.out.print(-1);
        }

    }

    public static boolean turn() {
        for (int i = 0 ; i < order.size() ; i++) {
            Chess chess = order.get(i);
            chess.start();
            if (check(chess.x, chess.y)) {
                return true;
            }
        }
        return false;
    }

    public static boolean check(int x, int y) {
        if (board[x][y].stack.size() >= 4) {
            return true;
        }
        return false;
    }

    public static class Board {
        int color;
        Stack<Chess> stack = new Stack<>();

        public Board(int color) {
            this.color = color;
        }

        public void push(Chess chess) {
            this.stack.push(chess);
        }
    }

    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[] reverse = {0, 2, 1, 4, 3};
    public static class Chess {
        int num;
        int x;
        int y;
        int direction;
        public Chess(int num, int x, int y, int direction) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public void start() {
            // 다음 보드 위치 색깔 확인
            int nextColor = nextColor();

            if (nextColor == 0) {
                white();
            } else if (nextColor == 1) {
                red();
            } else {
                blue();
            }
        }

        public int nextColor() {
            int nx = this.x + dx[direction];
            int ny = this.y + dy[direction];

            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                return board[nx][ny].color;
            } else {
                return 2;
            }
        }

        public void white() {
            int nx = this.x + dx[direction];
            int ny = this.y + dy[direction];
            Stack<Chess> chessStack = new Stack<>();
            while(!board[x][y].stack.isEmpty()) {
                Chess chess = board[x][y].stack.pop();
                chess.x = nx;
                chess.y = ny;
                chessStack.push(chess);
                if (chess.num == this.num) {
                    break;
                }
            }

            while(!chessStack.isEmpty()) {
                board[nx][ny].stack.push(chessStack.pop());
            }
        }

        public void red() {
            int nx = this.x + dx[direction];
            int ny = this.y + dy[direction];
            List<Chess> chessList = new ArrayList<>();
            while(!board[x][y].stack.isEmpty()) {
                Chess chess = board[x][y].stack.pop();
                chess.x = nx;
                chess.y = ny;
                chessList.add(chess);
                if (chess.num == this.num) {
                    break;
                }
            }

            for (int i = 0 ; i < chessList.size() ; i++) {
                board[nx][ny].stack.push(chessList.get(i));
            }
        }

        public void blue() {
            int nx = this.x + dx[reverse[direction]];
            int ny = this.y + dy[reverse[direction]];
            if ((nx < 1 || nx > n || ny < 1 || ny > n) || board[nx][ny].color == 2) {
                this.direction = reverse[direction];
                return;
            } else {
                if (board[nx][ny].color == 0) {
                    Stack<Chess> chessStack = new Stack<>();
                    while(!board[x][y].stack.isEmpty()) {
                        Chess chess = board[x][y].stack.pop();
                        chess.x = nx;
                        chess.y = ny;
                        chessStack.push(chess);
                        if (chess.num == this.num) {
                            chess.direction = reverse[direction];
                            break;
                        }
                    }

                    while(!chessStack.isEmpty()) {
                        board[nx][ny].stack.push(chessStack.pop());
                    }
                } else {
                    List<Chess> chessList = new ArrayList<>();
                    while(!board[x][y].stack.isEmpty()) {
                        Chess chess = board[x][y].stack.pop();
                        chess.x = nx;
                        chess.y = ny;
                        chessList.add(chess);
                        if (chess.num == this.num) {
                            chess.direction = reverse[direction];
                            break;
                        }
                    }

                    for (int i = 0 ; i < chessList.size() ; i++) {
                        board[nx][ny].stack.push(chessList.get(i));
                    }
                }

            }
        }
    }
}

