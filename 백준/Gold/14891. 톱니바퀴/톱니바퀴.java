import java.util.*;
import java.io.*;

class Circle {
    int index;
    List<Integer> statusList = new ArrayList<>();

    public Circle(int index) {
        this.index = index;
    }

    public void left() {
        statusList.add(statusList.remove(0));
    }

    public void right() {
        statusList.add(0, statusList.remove(statusList.size() - 1));
    }

    // 만약 극이 같은 경우 true
    public boolean leftCouple(Circle circle) {
        return statusList.get(6).equals(circle.statusList.get(2));
    }

    // 만약 극이 같은 경우 true
    public boolean rightCouple(Circle circle) {
        return statusList.get(2).equals(circle.statusList.get(6));
    }

    public int getResult() {
        if (index == 1) {
            return statusList.get(0).equals(1) ? 1 : 0;
        } else if (index == 2) {
            return statusList.get(0).equals(1) ? 2 : 0;
        } else if (index == 3) {
            return statusList.get(0).equals(1) ? 4 : 0;
        } else if (index == 4) {
            return statusList.get(0).equals(1) ? 8 : 0;
        } else {
            return 0;
        }
    }

}

class Total {
    Circle[] circles;

    public Total(Circle[] circles) {
        this.circles = circles;
    }

    public int[] direction(int index, int direction) {
        int[] result = new int[5];
        result[index] = direction;
        // 좌측
        for (int i = index - 1 ; i > 0 ; i--) {
            if (circles[i].rightCouple(circles[i + 1])) {
                break;
            } else {
                if (direction == -1) {
                    result[i] = 1;
                    direction = 1;
                } else {
                    result[i] = -1;
                    direction = -1;
                }
            }
        }
        direction = result[index];
        // 우측
        for (int i = index + 1 ; i <= 4 ; i++) {
            if (circles[i].leftCouple(circles[i - 1])) {
                break;
            } else {
                if (direction == -1) {
                    result[i] = 1;
                    direction = 1;
                } else {
                    result[i] = -1;
                    direction = -1;
                }
            }
        }

        return result;
    }

    public void rotation(int index, int direction) {
        int[] directionArr = this.direction(index, direction);

        for (int i = 1 ; i <= 4 ; i++) {
            if (directionArr[i] == -1) {
                circles[i].left();
            } else if(directionArr[i] == 1) {
                circles[i].right();
            }
        }
    }

    public int result() {
        int sum = 0;
        for (int i = 1 ; i <= 4 ; i++) {
            sum += circles[i].getResult();
        }
        return sum;
    }
}

class Main {
    static Circle[] arr = new Circle[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1 ; i <= 4 ; i++) {
            arr[i] = new Circle(i);
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0 ; j < cArr.length ; j++) {
                arr[i].statusList.add(cArr[j] - '0');
            }
        }
        Total total = new Total(arr);

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0 ; i < k ; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            total.rotation(index, direction);
        }

        System.out.println(total.result());
    }
}