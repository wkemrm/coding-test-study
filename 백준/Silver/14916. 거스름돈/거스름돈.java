import java.util.*;
class Main {
        /**
        1 -> -1 -> 1 % 5 = 1 
        2 -> 2 1개 -> 2 % 5 = 2
        3 -> -1 -> 3 % 5 = 3
        4 -> 2 2개 -> 4 % 5 = 4
        
        5 -> 5 1개 -> 5 % 5 = 0
        6 -> 2 3개 -> 6 % 5 = 1
        7 -> 5 1개 2 1개 -> 7 % 5 = 2
        8 -> 2 4개 -> 8 % 5 = 3
        9 -> 5 1개 2 2개 -> 9 % 5 = 4
        
        10 -> 5 2개 => 10 % 5 = 0
        11 -> 5 1개 2 3개 -> 11 % 5 = 1
        12 -> 5 2개 2 1개 -> 12 % 5 = 2
        13 -> 5 1개 2 4개 -> 13 % 5 = 3
        14 -> 5 2개 2 2개 -> 14 % 5 = 4
        
        15 -> 5 3개 -> 15 % 5 = 0
        16 -> 5 2개 2 3개 -> 16 % 5 = 1
        17 -> 5 3개 2 1개 -> 17 % 5 = 2
        18 -> 5 2개 2 4개 -> 18 % 5 = 3
        19 -> 5 3개 2 2개 -> 19 % 5 = 4
        **/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int result = 0;
        
        if (input == 1 || input == 3) {
            result = -1;
        } else if(input % 5 == 1) {
            result =(input - 5) / 5 + 3;
        } else if (input % 5 == 3) {
            result =(input - 5) / 5 + 4;
        } else {
            result =(input / 5) + (input % 5 / 2);
        }
        System.out.print(result);
    }
}