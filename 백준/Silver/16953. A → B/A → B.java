import java.util.*;

class Main {
    public static void main(String[] args) {
        /**
        A, B를 받는다.
        while문을 B가 A보다 작아질때까지 돈다.
        만약 A == B인 경우 break;한다.
        만약 끝자리수가 1인 경우 끝자리수 1을 뺀다
        만약 2로 나눠지는 경우 2로 나눈다.
        마지막에 A랑 B랑 같은지 판단해서 같은 경우 count를 반환한다.
        int count, int A, int B 필요
        **/
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int count = 1;
        while(A < B) {
            if (A == B) {
                break;
            }
            if (B % 10 == 1) {
                B = (B - 1) / 10;
                count++;
            } else if (B % 2 == 0) {
                B = B / 2;
                count++;
            } else {
                break;
            }
        }
        if (A == B) {
            System.out.print(count);
        } else {
            System.out.print(-1);
        }
    }
}