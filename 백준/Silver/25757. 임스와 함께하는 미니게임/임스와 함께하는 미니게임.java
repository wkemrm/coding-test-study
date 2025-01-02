import java.util.*;

class Main {
    public static int init(String s) {
        int count = 0;
        if (s.equals("Y")) {
            count = 2;
        } else if (s.equals("F")) {
            count = 3;
        } else {
            count = 4;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int count = init(s);
        sc.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0 ; i < n ; i++) {
            String input = sc.nextLine();
            map.put(input, 0);
        }
        
        int result = map.size() / (count - 1);
        System.out.print(result);
    }
}