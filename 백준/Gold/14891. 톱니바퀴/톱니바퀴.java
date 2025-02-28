import java.util.*;
import java.io.*;

class Main {
    static Node[] nodeArr = new Node[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1 ; i <= 4 ; i++) {
            char[] input = br.readLine().toCharArray();
            List<Integer> status = new ArrayList<>();
            for (int j = 0 ; j < input.length ; j++) {
                status.add(input[j] - '0');
            }
            nodeArr[i] = new Node(i, status);
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            nodeArr[start].start(direction);
        }

        int answer = 0;
        for (int i = 1 ; i <= 4 ; i++) {
            int result = nodeArr[i].getResult();
            if (result == 1) {
                answer += Math.pow(2, i - 1);
            }
        }

        System.out.println(answer);
    }

    static class Node {
        int num;
        List<Integer> status = new ArrayList<>();

        public Node (int num, List<Integer> status) {
            this.num = num;
            this.status = status;
        }

        public void start(int direction) {
            left(num - 1, direction == 1 ? -1 : 1);
            right(num + 1, direction == 1 ? -1 : 1);
            rotaion(this.num, direction);
        }

        public void left(int num, int direction) {
            if (num <= 0) return;
            if (leftCheck(num)) return;
            left(num - 1, direction == 1 ? -1 : 1);
            rotaion(num, direction);
        }

        public boolean leftCheck(int cur) {
            int now = nodeArr[cur].status.get(2);
            int right = nodeArr[cur + 1].status.get(6);

            if (right == now) {
                return true;
            } else {
                return false;
            }
        }

        public void right(int num, int direction) {
            if (num > 4) return;
            if (rightCheck(num)) return;
            right(num + 1, direction == 1 ? -1 : 1);
            rotaion(num, direction);
        }

        public boolean rightCheck(int cur) {
            int now = nodeArr[cur].status.get(6);
            int left = nodeArr[cur - 1].status.get(2);

            if (left == now) {
                return true;
            } else {
                return false;
            }
        }

        public void rotaion(int num, int direction) {
            List<Integer> status = nodeArr[num].status;
            if (direction == -1) {
                status.add(status.get(0));
                status.remove(0);
            } else {
                status.add(0, status.get(status.size() - 1));
                status.remove(status.size() - 1);
            }
        }


        public int getResult() {
            return status.get(0);
        }
    }

}