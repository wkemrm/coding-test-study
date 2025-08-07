import java.util.*;
import java.io.*;

class Main {
    static char[] input;
    static char[] boom;
    static int boomSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        boom = br.readLine().toCharArray();
        boomSize = boom.length;

        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < input.length ; i++) {
            stack.push(input[i]);

            if (stack.size() >= boomSize) {
                boolean flag = true;
                for (int j = 0 ; j < boomSize ; j++) {
                    if (boom[j] != stack.get(stack.size() - boomSize + j)) {
                        flag = false;
                        continue;
                    }
                }

                if (flag) {
                    for (int k = 0 ; k < boomSize ; k++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for(char ch : stack) {
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }
    }


}