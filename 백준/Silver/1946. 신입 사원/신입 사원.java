import java.util.*;

class People implements Comparable<People>{
    int a;
    int b;
    public People(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    public int compareTo(People people) {
        return this.a - people.a;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0 ; i < t ; i++) {
            ArrayList<People> list = new ArrayList<>();
            int n = sc.nextInt();
            for (int j = 0 ; j < n ; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                list.add(new People(a, b));
            }
            
            Collections.sort(list);
            
            int count = 1;
            int min = list.get(0).b;
            for (int j = 1 ; j < list.size() ; j++) {
                if (list.get(j).b < min) {
                    min = list.get(j).b;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}