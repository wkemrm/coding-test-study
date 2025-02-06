import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Student> pq = new PriorityQueue<>();
        Map<Integer, Student> map = new HashMap<>();

        for (int i = 0 ; i < m ; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (map.containsKey(input)) {
                map.get(input).up();
            } else {
                if (map.size() < n) {
                    map.put(input, new Student(input, i, 1));
                } else {
                    for (Map.Entry<Integer, Student> entry : map.entrySet()) {
                        pq.offer(entry.getValue());
                    }
                    Student student = pq.poll();
                    map.remove(student.num);
                    map.put(input, new Student(input, i, 1));
                    pq.clear();
                }
            }
        }

        ArrayList list = new ArrayList(map.keySet());
        Collections.sort(list);

        for (int i = 0 ; i < list.size() ; i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    static class Student implements Comparable<Student> {
        int num;
        int index;
        int cnt;

        public Student(int num, int index, int cnt) {
            this.num = num;
            this.index = index;
            this.cnt = cnt;
        }

        public int compareTo(Student student) {
            if (this.cnt != student.cnt) {
                return this.cnt - student.cnt;
            }
            return this.index - student.index;
        }

        public void up() {
            this.cnt++;
        }
    }
}