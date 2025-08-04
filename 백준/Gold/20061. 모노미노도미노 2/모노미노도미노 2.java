import java.io.*;
import java.util.*;

class Main {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Green green = new Green();
        Blue blue = new Blue();
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            green.push(t, y);
            green.jumsu();
            green.soft();

            blue.push(t, x);
            blue.jumsu();
            blue.soft();

        }
        System.out.println(result);
        System.out.println(green.count() + blue.count());
    }


    public static class Green {
        boolean[][] green = new boolean[6][4];

        public int count() {
            int count = 0;
            for (int i = 5 ; i >= 2 ; i--) {
                for (int j = 0 ; j <= 3 ; j++) {
                    if (green[i][j]) {
                        count++;
                    }
                }
            }

            return count;
        }

        public int top(int y) {
            int top = 5;
            for (int i = 5 ; i >= 0 ; i--) {
                if (green[i][y]) {
                    top = i - 1;
                }
            }

            return top;
        }

        public void push(int t, int y) {
            switch (t) {
                case 1 : {
                    t1Push(y);
                    break;
                }
                case 2 : {
                    t2Push(y);
                    break;
                }
                case 3 : {
                    t3Push(y);
                    break;
                }
            }
        }

        public void t1Push(int y) {
            int top = top(y);

            green[top][y] = true;
        }

        public void t2Push(int y) {
            int top1 = top(y);
            int top2 = top(y + 1);

            if (top1 < top2) {
                green[top1][y] = true;
                green[top1][y + 1] = true;
            } else {
                green[top2][y] = true;
                green[top2][y + 1] = true;
            }
        }

        public void t3Push(int y) {
            int top = top(y);
            green[top][y] = true;
            green[top - 1][y] = true;
        }

        public void jumsu() {
            List<Integer> list = new ArrayList<>();
            for (int i = 5 ; i >= 0 ; i--) {
                boolean flag = true;
                for (int j = 0 ; j <= 3 ; j++) {
                    if (!green[i][j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    list.add(i);
                    result++;
                }
            }

            remove(list);
        }

        public void remove(List<Integer> list) {
            boolean[][] copy = new boolean[6][4];

            int index = 5;
            for (int i = 5 ; i >= 0 ; i--) {
                if (list.contains(i)) continue;
                for (int j = 0 ; j <= 3 ; j++) {
                    copy[index][j] = green[i][j];
                }
                index--;
            }

            green = copy;
        }

        public void soft() {
            int count = 0;
            for (int i = 1 ; i >= 0 ; i--) {
                for (int j = 0 ; j <= 3 ; j++) {
                    if (green[i][j]) {
                        count++;
                        break;
                    }
                }
            }

            for (int i = 0 ; i < count ; i++) {
                remove(List.of(5));
            }
        }
    }

    public static class Blue {
        boolean[][] blue = new boolean[6][4];

        public int count() {
            int count = 0;
            for (int i = 5 ; i >= 2 ; i--) {
                for (int j = 0 ; j <= 3 ; j++) {
                    if (blue[i][j]) {
                        count++;
                    }
                }
            }

            return count;
        }
        public int top(int x) {
            int top = 5;
            for (int i = 5 ; i >= 0 ; i--) {
                if (blue[i][x]) {
                    top = i - 1;
                }
            }

            return top;
        }

        public void push(int t, int x) {
            switch (t) {
                case 1 : {
                    t1Push(x);
                    break;
                }
                case 2 : {
                    t2Push(x);
                    break;
                }
                case 3 : {
                    t3Push(x);
                    break;
                }
            }
        }

        public void t1Push(int x) {
            int top = top(x);

            blue[top][x] = true;
        }

        public void t2Push(int x) {
            int top = top(x);
            blue[top][x] = true;
            blue[top - 1][x] = true;
        }

        public void t3Push(int x) {
            int top1 = top(x);
            int top2 = top(x + 1);

            if (top1 < top2) {
                blue[top1][x] = true;
                blue[top1][x + 1] = true;
            } else {
                blue[top2][x] = true;
                blue[top2][x + 1] = true;
            }
        }

        public void jumsu() {
            List<Integer> list = new ArrayList<>();
            for (int i = 5 ; i >= 0 ; i--) {
                boolean flag = true;
                for (int j = 0 ; j <= 3 ; j++) {
                    if (!blue[i][j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    list.add(i);
                    result++;
                }
            }

            remove(list);
        }

        public void remove(List<Integer> list) {
            boolean[][] copy = new boolean[6][4];

            int index = 5;
            for (int i = 5 ; i >= 0 ; i--) {
                if (list.contains(i)) continue;
                for (int j = 0 ; j <= 3 ; j++) {
                    copy[index][j] = blue[i][j];
                }
                index--;
            }

            blue = copy;
        }

        public void soft() {
            int count = 0;
            for (int i = 1 ; i >= 0 ; i--) {
                for (int j = 0 ; j <= 3 ; j++) {
                    if (blue[i][j]) {
                        count++;
                        break;
                    }
                }
            }

            for (int i = 0 ; i < count ; i++) {
                remove(List.of(5));
            }
        }
    }
}
