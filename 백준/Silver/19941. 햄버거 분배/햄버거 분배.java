import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String line = sc.next();
        String[] sArr = line.split("");
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0 ; i < sArr.length ; i++) {
            if (sArr[i].equals("P")) {
                int start =  i - k >= 0 ? i - k : 0;
                int end = i + k < n ? i + k : n -1;
                for (int j = start ; j <= end ; j++) {
                    if (sArr[j].equals("H") && visited[j] == false) {
                        count++;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }
        System.out.print(count);
    }
}