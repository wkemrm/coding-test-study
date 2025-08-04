import java.io.*;
import java.util.*;

class Main {
    static int[] robot;
    static int[] belt;
    static int n;
    static int k;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        robot = new int[n];
        belt = new int[n * 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n * 2 ; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            if (check()) {
                break;
            }
            
            // 벨트 이동 -> 내리는 경우 로봇 사라짐
            beltMove();
            // 로봇 이동 -> 내리는 경우 내구도 감소 없음 -> 로봇 사라짐
            robotMove();
            
            // 로봇 올리기
            plusRobot();
            answer++;
        }

        System.out.println(answer);
    }

    public static void beltMove() {
        int last = belt[n * 2 - 1];

        for (int i = n * 2 - 2 ; i >= 0 ; i--) {
            belt[i + 1] = belt[i];
        }
        belt[0] = last;

        for (int i = n - 2 ; i >= 0 ; i--) {
            robot[i + 1] = robot[i];
        }
        robot[0] = 0;
        robot[n - 1] = 0;
    }

    public static void robotMove() {
        for (int i = n - 2 ; i >= 0 ; i--) {
            if (robot[i] == 1 && belt[i + 1] >= 1 && robot[i + 1] == 0) {
                robot[i] = 0;
                robot[i + 1] = 1;
                belt[i + 1]--;
            }
        }
        robot[n - 1] = 0;
    }

    public static void plusRobot() {
        if (belt[0] <= 0) return;
        robot[0] = 1;
        belt[0]--;
    }

    public static boolean check() {
        int count = 0;
        for (int i = 0 ; i < n * 2 ; i++) {
            if (belt[i] == 0) count++;
        }

        return count >= k;
    }

}