import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int a = Integer.valueOf(split[0]);
            int b = Integer.valueOf(split[1]);
            int c = Integer.valueOf(split[2]);
            if (a == 0 && b == 0 && c == 0) break;
            Integer[] arr = new Integer[]{a, b, c};
            Arrays.sort(arr, Collections.reverseOrder());
            int max = arr[0];
            if (max >= arr[1] + arr[2]) {
                System.out.println("Invalid");
                continue;
            }
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[0]);
            set.add(arr[1]);
            set.add(arr[2]);
            
            if (set.size() == 3) {
                System.out.println("Scalene");
            } else if (set.size() == 2) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Equilateral");
            }
            
        }
    }
}