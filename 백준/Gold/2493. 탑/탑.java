import java.util.*;
import java.io.*;

class Top {
    int index;
    int height;
    public Top (int index, int height) {
        this.index = index;
        this.height = height;
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Top> top = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (top.isEmpty()) {
                System.out.print(0 + " ");
                top.push(new Top(i + 1, input));
            } else {
                boolean flag = false;
                int index = 0;
                while(!top.isEmpty() && !flag) {
                    int before = top.peek().height;
                    if (before < input) {
                        top.pop();
                    } else {
                        flag = true;
                        index = top.peek().index;
                        break;
                    }
                }

                if (!flag) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(index + " ");
                }

                top.push(new Top(i + 1, input));
            }
        }
    }
}