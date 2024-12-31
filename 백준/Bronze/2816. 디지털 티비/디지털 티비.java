import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i =0 ; i < n ; i++) {
            arr[i] = sc.nextLine();
        }
        
        List<Integer> list = new ArrayList<>();
        int curP = 0;
        int p1 = 0;
        for (int i = 0 ; i < n ; i++) {
            if (arr[i].equals("KBS1")) {
                p1 = i;
                break;
            }
        }
        
        for (int i = 0 ; i < p1 - curP ; i++) {
            list.add(1);
        }
        
        curP = p1;
        
        for (int i = curP ; i > 0 ; i--) {
            String tmp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = tmp;
            list.add(4);
        }
        
        curP = 0;
        int p2 = 0;
        for (int i = 0 ; i < n ; i++) {
            if (arr[i].equals("KBS2")) {
                p2 = i;
                break;
            }
        }
        
        for (int i = 0 ; i < p2 - curP ; i++) {
            list.add(1);
        }
        
        curP = p2;
        
        for (int i = curP ; i > 1 ; i--) {
            String tmp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = tmp;
            list.add(4);
        }
        
        for (int i : list) {
            System.out.print(i);
        }
    }
}